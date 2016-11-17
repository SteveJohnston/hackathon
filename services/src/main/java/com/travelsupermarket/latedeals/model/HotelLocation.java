package com.travelsupermarket.latedeals.model;

/**
 * A hotel specific location, used to identify the location and whether the hotel is within a pre-determined radius.
 */
public class HotelLocation {
    private final String locationId;
    private final boolean withinRange;

    /**
     * Constructor.
     */
    public HotelLocation(String locationId, boolean withinRange) {
        this.locationId = locationId;
        this.withinRange = withinRange;
    }

    public String getLocationId() {
        return locationId;
    }

    public boolean isWithinRange() {
        return withinRange;
    }
}
