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


    public Location() {
        this.locationId = null;
        this.dvtRating = null;
        this.tanRating = null;
        this.partyRating = null;
        this.continentName = null;
        this.countryName = null;
        this.locationFullName = null;
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

    @Override
    public int hashCode() {
        return Objects.hash(locationId, dvtRating, tanRating, partyRating, locationFullName, countryName, continentName);
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
        return Objects.equals(this.locationId, other.locationId)
                && Objects.equals(this.dvtRating, other.dvtRating)
                && Objects.equals(this.tanRating, other.tanRating)
                && Objects.equals(this.partyRating, other.partyRating)
                && Objects.equals(this.locationFullName, other.locationFullName)
                && Objects.equals(this.countryName, other.countryName)
                && Objects.equals(this.continentName, other.continentName);
    }
}
