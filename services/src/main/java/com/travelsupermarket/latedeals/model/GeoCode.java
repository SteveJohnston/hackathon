package com.travelsupermarket.latedeals.model;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class GeoCode {

    private final Double lat;
    private final Double lon;

    private GeoCode() {
        this.lat = null;
        this.lon = null;
    }


    private GeoCode(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lon);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final GeoCode other = (GeoCode) obj;
        return Objects.equals(this.lat, other.lat)
                && Objects.equals(this.lon, other.lon);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("lat", lat)
                .add("lon", lon)
                .toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private double lat;
        private double lon;

        public Builder withLat(double lat) {
            this.lat = lat;
            return this;
        }

        public Builder withLon(double lon) {
            this.lon = lon;
            return this;
        }

        public GeoCode build() {
            return new GeoCode(lat, lon);
        }
    }
}
