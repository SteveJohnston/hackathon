package com.travelsupermarket.latedeals.model;

import java.util.List;
import java.util.Objects;

/**
 * Contains holiday deals for a specific flight.
 */
public class HolidayDealFlight {

    private final String cardId;
    private final CabinClassType cabinClass;
    private final FlightCardJourney outbound;
    private final FlightCardJourney inbound;

    private final List<HolidayDealProviderResult> results;

    /**
     * Constructor.
     */
    public HolidayDealFlight(String cardId, CabinClassType cabinClass, FlightCardJourney outbound,
                             FlightCardJourney inbound, List<HolidayDealProviderResult> results) {
        this.cardId = cardId;
        this.cabinClass = cabinClass;
        this.outbound = outbound;
        this.inbound = inbound;
        this.results = results;
    }

    public String getCardId() {
        return cardId;
    }

    public CabinClassType getCabinClass() {
        return cabinClass;
    }

    public FlightCardJourney getOutbound() {
        return outbound;
    }

    public FlightCardJourney getInbound() {
        return inbound;
    }

    public List<HolidayDealProviderResult> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayDealFlight that = (HolidayDealFlight) o;

        if (cabinClass != that.cabinClass) return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (inbound != null ? !inbound.equals(that.inbound) : that.inbound != null) return false;
        if (outbound != null ? !outbound.equals(that.outbound) : that.outbound != null) return false;
        if (results != null ? !results.equals(that.results) : that.results != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cabinClass, outbound, inbound, results);
    }

    /**
     * Builder for Holidays deal flight results.
     */
    public static final class Builder {
        private String cardId;
        private CabinClassType cabinClass;
        private FlightCardJourney outbound;
        private FlightCardJourney inbound;
        private List<HolidayDealProviderResult> results;

        /**
         */
        public Builder withCardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        /**
         */
        public Builder withCabinClass(CabinClassType cabinClass) {
            this.cabinClass = cabinClass;
            return this;
        }

        /**
         */
        public Builder withOutbound(FlightCardJourney outbound) {
            this.outbound = outbound;
            return this;
        }

        /**
         */
        public Builder withInbound(FlightCardJourney inbound) {
            this.inbound = inbound;
            return this;
        }

        /**
         */
        public Builder withResults(List<HolidayDealProviderResult> results) {
            this.results = results;
            return this;
        }

        /**
         */
        public Builder fromFlightCardSummary(FlightCardSummary flightCardSummary) {
            this.cabinClass = flightCardSummary.getCabinClass();
            this.inbound = flightCardSummary.getInbound();
            this.outbound = flightCardSummary.getOutbound();

            return this;
        }

        /**
         */
        public HolidayDealFlight build() {
            return new HolidayDealFlight(cardId, cabinClass, outbound, inbound, results);
        }
    }
}

