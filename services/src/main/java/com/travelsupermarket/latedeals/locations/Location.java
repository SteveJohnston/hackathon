package com.travelsupermarket.latedeals.locations;

import java.util.Objects;

public class Location {

    private final String locationId;
    private final Integer dvtRating;
    private final Integer tanRating;
    private final Integer partyRating;
    private final String locationFullName;
    private final String countryName;
    private final String continentName;
    private final Double random;


    public Location() {
        this.locationId = null;
        this.dvtRating = null;
        this.tanRating = null;
        this.partyRating = null;
        this.continentName = null;
        this.countryName = null;
        this.locationFullName = null;
        this.random = Math.random();
    }

    public Location(String locationId, Integer dvtRating, Integer tanRating, Integer partyRating,
                    String locationFullName, String countryName, String continentName) {
        this.locationId = locationId;
        this.dvtRating = dvtRating;
        this.tanRating = tanRating;
        this.partyRating = partyRating;
        this.locationFullName = locationFullName;
        this.countryName = countryName;
        this.continentName = continentName;
        this.random = Math.random();
    }

    public String getLocationId() {
        return locationId;
    }

    public Integer getDvtRating() {
        return dvtRating;
    }

    public Integer getTanRating() {
        return tanRating;
    }

    public Integer getPartyRating() {
        return partyRating;
    }

    public String getContinentName() {
        return continentName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLocationFullName() {
        return locationFullName;
    }

    public Double getRandom() {
        return random;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        return Objects.equals(this.locationId, other.locationId);
    }
}
