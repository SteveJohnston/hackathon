package com.travelsupermarket.latedeals.model;

import java.util.List;
import java.util.Objects;

public class Enquiry {

    private final String enquiryId;
    private final String departureDate;
    private final Integer numNights;
    private final Integer budgetMin;
    private final Integer budgetMax;
    private final String channelId;
    private final List<EnquiryRoom> rooms;
    private final List<EnquiryLocation> departures;
    private final List<EnquiryLocation> destinations;

    private Enquiry() {
        this.enquiryId = null;
        this.departureDate = null;
        this.numNights = null;
        this.budgetMin = null;
        this.budgetMax = null;
        this.channelId = null;
        this.rooms = null;
        this.departures = null;
        this.destinations = null;
    }

    public Enquiry(String enquiryId, String departureDate, int numNights, int budgetMin, int budgetMax,
                   String channelId, List<EnquiryRoom> rooms, List<EnquiryLocation> departures,
                   List<EnquiryLocation> destinations) {
        this.enquiryId = enquiryId;
        this.departureDate = departureDate;
        this.numNights = numNights;
        this.budgetMin = budgetMin;
        this.budgetMax = budgetMax;
        this.channelId = channelId;
        this.rooms = rooms;
        this.departures = departures;
        this.destinations = destinations;
    }

    public String getEnquiryId() {
        return enquiryId;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public Integer getNumNights() {
        return numNights;
    }

    public Integer getBudgetMin() {
        return budgetMin;
    }

    public Integer getBudgetMax() {
        return budgetMax;
    }

    public String getChannelId() {
        return channelId;
    }

    public List<EnquiryRoom> getRooms() {
        return rooms;
    }

    public List<EnquiryLocation> getDepartures() {
        return departures;
    }

    public List<EnquiryLocation> getDestinations() {
        return destinations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                enquiryId, departureDate, numNights, budgetMin, budgetMax, channelId, rooms, departures, destinations);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Enquiry other = (Enquiry) obj;
        return Objects.equals(this.enquiryId, other.enquiryId)
                && Objects.equals(this.departureDate, other.departureDate)
                && Objects.equals(this.numNights, other.numNights)
                && Objects.equals(this.budgetMin, other.budgetMin)
                && Objects.equals(this.budgetMax, other.budgetMax)
                && Objects.equals(this.channelId, other.channelId)
                && Objects.equals(this.rooms, other.rooms)
                && Objects.equals(this.departures, other.departures)
                && Objects.equals(this.destinations, other.destinations);
    }
}
