package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *  Holds Flight card summary
 */
public class FlightCardSummary {

    private String allianceId;
    private String marketingCarrier;
    private FlightCardJourney outbound;
    private FlightCardJourney inbound;
    private CabinClassType cabinClass;

    /**
     * Default constructor for Json
     */
    public FlightCardSummary() {
    }


    private FlightCardSummary(Builder flightCardResultBuilder) {

        this.allianceId = flightCardResultBuilder.allianceId;
        this.marketingCarrier = flightCardResultBuilder.marketingCarrier;
        this.outbound = flightCardResultBuilder.outbound;
        this.inbound = flightCardResultBuilder.inbound;
        this.cabinClass = flightCardResultBuilder.cabinClass;

    }


    @JsonProperty
    public String getAllianceId() {
        return allianceId;
    }

    @JsonProperty
    public String getMarketingCarrier() {
        return marketingCarrier;
    }
    @JsonProperty
    public FlightCardJourney getOutbound() {
        return outbound;
    }

    @JsonProperty
    public FlightCardJourney getInbound() {
        return inbound;
    }
    @JsonProperty
    @JsonDeserialize(using = CabinClassDeserializer.class)
    public CabinClassType getCabinClass() {
        return cabinClass;
    }

    /**
     * Builder for the FlightCardResult.
     */
    public static class Builder {
        private String allianceId;
        private CabinClassType cabinClass;
        private String marketingCarrier;
        private FlightCardJourney outbound;
        private FlightCardJourney inbound;
        /**
         * set the allianceId.
         *
         * @param allianceId
         * @return
         */
        public Builder withAllianceId(String allianceId) {
            this.allianceId = allianceId;
            return this;
        }

        /**
         * sets the pax class (cabinClass in the json)
         *
         * @param cabinClass
         * @return
         */
        public Builder withCabinClass(CabinClassType cabinClass) {
            this.cabinClass = cabinClass;
            return this;
        }

        /**
         * set the marketingCarrier.
         *
         * @param marketingCarrier
         * @return
         */
        public Builder withMarketingCarrier(String marketingCarrier) {
            this.marketingCarrier = marketingCarrier;
            return this;
        }

        /**
         * set the outbound journey.
         *
         * @param outbound
         * @return
         */
        public Builder withOutbound(FlightCardJourney outbound) {
            this.outbound = outbound;
            return this;
        }

        /**
         * set the inboundJourney.
         *
         * @param inbound
         * @return
         */
        public Builder withInbound(FlightCardJourney inbound) {
            this.inbound = inbound;
            return this;
        }

        /**
         * create an instance of FlightCardResult.
         *
         * @return
         */
        public FlightCardSummary build() {
            return new FlightCardSummary(this);
        }
    }
}
