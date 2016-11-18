package com.travelsupermarket.latedeals.resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Range;
import com.travelsupermarket.http.error.exception.InvalidUrlParameterException;
import com.travelsupermarket.latedeals.chav.Chav;
import com.travelsupermarket.latedeals.chav.ChavLoader;
import com.travelsupermarket.latedeals.locations.Location;
import com.travelsupermarket.latedeals.locations.LocationsLoader;
import com.travelsupermarket.latedeals.model.Enquiry;
import com.travelsupermarket.latedeals.model.HolidayCardResult;
import com.travelsupermarket.latedeals.price.Price;
import com.travelsupermarket.latedeals.price.PriceLoader;
import org.apache.commons.lang3.tuple.Pair;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LateDealsResource {

    private static final Joiner JOINER = Joiner.on(",");
    private static final Map<String, Location> LOCATIONS_MAP = LocationsLoader.loadLocations();
    private static final Map<Integer, Chav> CHAV_MAP = ChavLoader.loadChavs();
    private static final Map<Integer, Price> PRICE_MAP = PriceLoader.loadPrice();
    private static final Map<Integer, Pair<Integer, Integer>> MONEY_MAP = ImmutableMap.of(
            1, Pair.of(100, 300),
            2, Pair.of(200, 500),
            3, Pair.of(300, 700),
            4, Pair.of(400, 900),
            5, Pair.of(500, 2000)
    );

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String QUERY_URL = "http://internal-gateway1.services.prod1.gb.tsm.internal/gb/holidays/v1/search/%s/%s";
    private static final String RESULT_URL = "http://internal-gateway1.services.prod1.gb.tsm.internal/gb/holidays/v1/results/%s/%s";

    private final JerseyClient client;

    public LateDealsResource() {
        this.client = new JerseyClientBuilder().build();
    }

    /**
     * Starts a search
     */
    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search/{date}/{nights}/{rooms}/{departure}/{chav}/{tan}/{money}/{party}/{dvt}")
    public Enquiry search(@PathParam("date") Optional<String> date,
                          @PathParam("nights") Optional<Integer> nights,
                          @PathParam("rooms") Optional<String> rooms,
                          @PathParam("departure") Optional<String> departure,
                          @PathParam("chav") Optional<Integer> chav,
                          @PathParam("tan") Optional<Integer> tan,
                          @PathParam("money") Optional<Integer> money,
                          @PathParam("party") Optional<Integer> party,
                          @PathParam("dvt") Optional<Integer> dvt,
                          @QueryParam("userId") Optional<String> userId)
            throws InvalidUrlParameterException {
        if (date.isPresent() && nights.isPresent()) {
            return client
                    .target(String.format(QUERY_URL, date.get(), nights.get()))
                    .queryParam("departures", departure.get())
                    .queryParam("destinations", "56374488e4b00555cedbb8c9")
                    .queryParam("minBudget", MONEY_MAP.get(money.get()).getLeft())
                    .queryParam("maxBudget", MONEY_MAP.get(money.get()).getRight())
                    .queryParam("room", rooms.get())
                    .queryParam("userId", userId.get())
                    .request(MediaType.APPLICATION_JSON)
                    .get(Enquiry.class);
        }
        throw new InvalidUrlParameterException("You sent me crap", "", "", "");
    }

    /**
     * Gets a result set
     */
    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/results/{enquiryId}/{date}/{chav}/{tan}/{money}/{party}/{dvt}")
    public String results(@PathParam("enquiryId") Optional<String> enquiryId,
                          @PathParam("date") Optional<String> date,
                          @PathParam("chav") Optional<Integer> chav,
                          @PathParam("tan") Optional<Integer> tan,
                          @PathParam("money") Optional<Integer> money,
                          @PathParam("party") Optional<Integer> party,
                          @PathParam("dvt") Optional<Integer> dvt) throws InvalidUrlParameterException {

        if (date.isPresent() && enquiryId.isPresent()) {
            try {
                JsonNode resultJson = MAPPER.readTree(client
                        .target(String.format(RESULT_URL, enquiryId.get(), date.get()))
                        .queryParam("offset", 0)
                        .queryParam("limit", "321123")
                        .request(MediaType.APPLICATION_JSON)
                        .get().readEntity(String.class));
                String providers = MAPPER.writeValueAsString(resultJson.findValue("providers"));
                String lookups = MAPPER.writeValueAsString(resultJson.findValue("lookups"));
                String sortFields = MAPPER.writeValueAsString(resultJson.findValue("sortFields"));
                String filterGroups = MAPPER.writeValueAsString(resultJson.findValue("filterGroups"));
                String isComplete = MAPPER.writeValueAsString(resultJson.findValue("isComplete"));

                String cards = getCards(resultJson.findValue("cards"), tan.get(), dvt.get(), party.get(), chav.get(), money.get());
                return JOINER.join("{ \"providers\": " + providers,
                        "\"lookups\": " + lookups,
                        "\"sortFields\": " + sortFields,
                        "\"cards\" : " + cards,
                        "\"filterGroups\": " + filterGroups,
                        "\"isComplete\": " + isComplete + "}");
            } catch (Exception ex) {
                return "";
            }
        }
        throw new InvalidUrlParameterException("You sent me crap", "", "", "");
    }

    public String getCards(JsonNode cardsNode, int tan, int dvt, int party, int chav, int price) throws JsonProcessingException {
        List<HolidayCardResult> results = new ArrayList<>();
        ArrayNode arrayNode = (ArrayNode) cardsNode;
        try {
            for (JsonNode node : arrayNode) {
                HolidayCardResult result = MAPPER.readValue(MAPPER.writeValueAsString(node), HolidayCardResult.class);
                if (LOCATIONS_MAP.containsKey(result.getHotelLocation().getLocationId())) {
                    Location location = LOCATIONS_MAP.get(result.getHotelLocation().getLocationId());
                    result.setDvtRating(location.getDvtRating());
                    result.setPartyRating(location.getPartyRating());
                    result.setTanRating(location.getTanRating());
                    result.setContinentName(location.getContinentName());
                    result.setCountryName(location.getCountryName());
                    result.setLocationFullName(location.getLocationFullName());
                    results.add(result);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        Chav chavRating = CHAV_MAP.get(chav);
        Price priceVal = PRICE_MAP.get(price);
        Range starRange = Range.closed(chavRating.getMinStarRating(), chavRating.getMaxStarRating());
        Range guestRange = Range.closed(chavRating.getMinGuestRating(), chavRating.getMaxGuestRating());
        Range range = Range.closed(priceVal.getMinPricePP(), priceVal.getMaxPricePP());

        results = results.parallelStream()
                .filter(result -> result.getTanRating() == tan &&
                                result.getDvtRating() == dvt &&
                                result.getPartyRating() == party &&
                                starRange.contains(result.getStarRating()) &&
                                result.getReviews() != null &&
                                guestRange.contains(result.getReviews().getScore()) &&
                                range.contains(result.getLeadInDeal().getFlights().get(0).getResults().get(0).getPrices().getConverted().getAvgPP().getAmount().intValue())
                )
                .distinct()
                .sorted((r1, r2) -> Double.compare(
                        LOCATIONS_MAP.get(r1.getHotelLocation().getLocationId()).getRandom(),
                        LOCATIONS_MAP.get(r2.getHotelLocation().getLocationId()).getRandom()))
                .collect(Collectors.toList());

        return MAPPER.writeValueAsString(ImmutableList.copyOf(results));
    }
}
