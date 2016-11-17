package com.travelsupermarket.latedeals.locations;

import java.util.Objects;

public class Location {

    private final String locationId;
    private final Integer chavRating;
    private final Integer dvtRating;
    private final Integer tanRating;
    private final Integer partyRating;

    public Location() {
        this.locationId = null;
        this.chavRating = null;
        this.dvtRating = null;
        this.tanRating = null;
        this.partyRating = null;
    }

    public Location(String locationId, Integer chavRating, Integer dvtRating, Integer tanRating, Integer partyRating) {
        this.locationId = locationId;
        this.chavRating = chavRating;
        this.dvtRating = dvtRating;
        this.tanRating = tanRating;
        this.partyRating = partyRating;
    }

    public String getLocationId() {
        return locationId;
    }

    public Integer getChavRating() {
        return chavRating;
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

    @Override
    public int hashCode() {
        return Objects.hash(locationId, chavRating, dvtRating, tanRating, partyRating);
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
                && Objects.equals(this.chavRating, other.chavRating)
                && Objects.equals(this.dvtRating, other.dvtRating)
                && Objects.equals(this.tanRating, other.tanRating)
                && Objects.equals(this.partyRating, other.partyRating);
    }
}
