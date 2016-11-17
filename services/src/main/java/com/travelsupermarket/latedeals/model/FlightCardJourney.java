package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.msm.utils.jackson.DateTimeDeserializer;
import com.msm.utils.jackson.DateTimeSerializer;
import com.msm.utils.jackson.DurationDeserializer;
import com.msm.utils.jackson.DurationSerializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the Journey information for a {@link com.tsm.aggregation.entity.flights.ui.FlightCardResult}.
 */
public class FlightCardJourney {

    private String depart; //IATA Code
    private DateTime departTime;

    private String arrive; //Optional IATA Code
    private DateTime arriveTime;

    private String marketingCarrier;

    private String operatingCarrier;

    private String firstFlight; //combination of airline code and firstFlight number for the first flight

    private Duration duration;

    private Integer stops;

    private Integer days; //TODO calculate this field as per story 1009

    private int journeyHash;

    private List<FlightCardVia> vias = new ArrayList<>();

    /**
     * Default constructor.
     */
    public FlightCardJourney() {
    }

    /**
     * Constructor used by the builder.
     *
     * @param depart
     * @param departTime
     * @param arrive
     * @param arriveTime
     * @param marketingCarrier
     * @param operatingCarrier
     * @param firstFlight
     * @param duration
     * @param stops
     * @param days
     * @param journeyHash
     * @param vias
     */
    private FlightCardJourney(String depart, DateTime departTime, String arrive,
                              DateTime arriveTime, String marketingCarrier,
                              String operatingCarrier, String firstFlight,
                              Duration duration, Integer stops, Integer days, int journeyHash,
                              List<FlightCardVia> vias) {

        this.depart = depart;
        this.departTime = departTime;
        this.arrive = arrive;
        this.arriveTime = arriveTime;
        this.marketingCarrier = marketingCarrier;
        this.operatingCarrier = operatingCarrier;
        this.firstFlight = firstFlight;
        this.duration = duration;
        this.stops = stops;
        this.days = days;
        this.journeyHash = journeyHash;
        this.vias = vias;
    }

    @JsonProperty
    public String getDepart() {
        return depart;
    }

    @JsonProperty
    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public DateTime getDepartTime() {
        return departTime;
    }

    @JsonProperty
    public String getArrive() {
        return arrive;
    }

    @JsonProperty
    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public DateTime getArriveTime() {
        return arriveTime;
    }

    @JsonProperty
    public String getMarketingCarrier() {
        return marketingCarrier;
    }

    @JsonProperty
    public String getOperatingCarrier() {
        return operatingCarrier;
    }

    @JsonProperty
    public String getFirstFlight() {
        return firstFlight;
    }

    @JsonProperty
    @JsonSerialize(using = DurationSerializer.class)
    @JsonDeserialize(using = DurationDeserializer.class)
    public Duration getDuration() {
        return duration;
    }

    @JsonProperty
    public Integer getStops() {
        return stops;
    }

    @JsonProperty
    public Integer getDays() {
        return days;
    }

    @JsonProperty
    public int getJourneyHash() {
        return journeyHash;
    }

    @JsonProperty
    public List<FlightCardVia> getVias() {
        return vias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        FlightCardJourney that = (FlightCardJourney) o;

        return new EqualsBuilder()
                .append(this.depart, that.depart)
                .append(this.departTime, that.departTime)
                .append(this.arrive, that.arrive)
                .append(this.arriveTime, that.arriveTime)
                .append(this.marketingCarrier, that.marketingCarrier)
                .append(this.operatingCarrier, that.operatingCarrier)
                .append(this.firstFlight, that.firstFlight)
                .append(this.duration, that.duration)
                .append(this.stops, that.stops)
                .append(this.days, that.days)
                .append(this.journeyHash, that.journeyHash)
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(depart)
                .append(departTime)
                .append(arrive)
                .append(arriveTime)
                .append(marketingCarrier)
                .append(operatingCarrier)
                .append(firstFlight)
                .append(duration)
                .append(stops)
                .append(days)
                .append(journeyHash)
                .build();
    }

    /**
     * Creates an instance of FlightCardJourney.
     */
    public static class FlightCardJourneyBuilder {
        private String depart;
        private DateTime departTime;
        private String arrive;
        private DateTime arriveTime;
        private String marketingCarrier;
        private String operatingCarrier;
        private String firstFlight;
        private Duration duration;
        private Integer stops;
        private Integer days;
        private int journeyHash;
        private List<FlightCardVia> vias;

        /**
         * sets the depart iata.
         *
         * @param depart
         * @return
         */
        public FlightCardJourneyBuilder withDepart(String depart) {
            this.depart = depart;
            return this;
        }

        /**
         * sets the departure time.
         *
         * @param departTime
         * @return
         */
        public FlightCardJourneyBuilder withDepartTime(DateTime departTime) {
            this.departTime = departTime;
            return this;
        }

        /**
         * sets the arrive iata.
         *
         * @param arrive
         * @return
         */
        public FlightCardJourneyBuilder withArrive(String arrive) {
            this.arrive = arrive;
            return this;
        }

        /**
         * sets the arrival time.
         *
         * @param arriveTime
         * @return
         */
        public FlightCardJourneyBuilder withArriveTime(DateTime arriveTime) {
            this.arriveTime = arriveTime;
            return this;
        }

        /**
         * sets the marketing carrier id.
         *
         * @param marketingCarrier
         * @return
         */
        public FlightCardJourneyBuilder withMarketingCarrier(String marketingCarrier) {
            this.marketingCarrier = marketingCarrier;
            return this;
        }

        /**
         * sets the marketing carrier id.
         *
         * @param operatingCarrier
         * @return
         */
        public FlightCardJourneyBuilder withOperatingCarrier(String operatingCarrier) {
            this.operatingCarrier = operatingCarrier;
            return this;
        }

        /**
         * sets the first flight in the list of legs (sequence 1).
         *
         * @param firstFlight
         * @return
         */
        public FlightCardJourneyBuilder withFirstFlight(String firstFlight) {
            this.firstFlight = firstFlight;
            return this;
        }

        /**
         * sets the duration.
         *
         * @param duration
         * @return
         */
        public FlightCardJourneyBuilder withDuration(Duration duration) {
            this.duration = duration;
            return this;
        }

        /**
         * sets the stops.
         *
         * @param stops
         * @return
         */
        public FlightCardJourneyBuilder withStops(Integer stops) {
            this.stops = stops;
            return this;
        }

        /**
         * sets the days.
         *
         * @param days
         * @return
         */
        public FlightCardJourneyBuilder withDays(Integer days) {
            this.days = days;
            return this;
        }

        /**
         * sets the journey hash.
         *
         * @param journeyHash
         * @return
         */
        public FlightCardJourneyBuilder withJourneyHash(int journeyHash) {
            this.journeyHash = journeyHash;
            return this;
        }

        /**
         * sets the vias.
         *
         * @param vias
         * @return
         */
        public FlightCardJourneyBuilder withVias(List<FlightCardVia> vias) {
            this.vias = vias;
            return this;
        }

        /**
         * creates an instance of FlightCardJourney.
         *
         * @return
         */
        public FlightCardJourney build() {
            return new FlightCardJourney(depart, departTime, arrive, arriveTime,
                    marketingCarrier, operatingCarrier, firstFlight,
                    duration, stops, days, journeyHash, vias);
        }
    }
}
