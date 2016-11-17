package com.travelsupermarket.latedeals.resource;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.travelsupermarket.http.error.exception.InvalidUrlParameterException;
import com.travelsupermarket.latedeals.locations.Location;
import com.travelsupermarket.latedeals.locations.LocationsLoader;
import com.travelsupermarket.latedeals.model.Enquiry;
import org.apache.commons.lang3.tuple.Pair;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

public class LateDealsResource {

    private static final Joiner JOINER = Joiner.on(",");
    private static final Map<String, Location> LOCATIONS_MAP = LocationsLoader.loadLocations();
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
                //String cards = resultJson.findValue("cards").asText();
                String filterGroups = MAPPER.writeValueAsString(resultJson.findValue("filterGroups"));
                String isComplete = MAPPER.writeValueAsString(resultJson.findValue("isComplete"));
                return JOINER.join(providers, lookups, sortFields, filterGroups, isComplete);
            } catch (Exception ex) {
                return "";
            }
        }
        throw new InvalidUrlParameterException("You sent me crap", "", "", "");
    }
}
