package com.travelsupermarket.latedeals.model;

import java.util.Objects;

public class EnquiryLocation {

    private final String id;
    private final String name;
    private final GeoCode geocode;
    private final String type;
    private final String countryId;
    private final String featureCode;
    private final String touristAreaIds;
    private final String touristParentId;

    public EnquiryLocation() {
        this.id = null;
        this.name = null;
        this.geocode = null;
        this.type = null;
        this.countryId = null;
        this.featureCode = null;
        this.touristAreaIds = null;
        this.touristParentId = null;
    }

    public EnquiryLocation(String id, String name, GeoCode geocode, String type, String countryId, String featureCode,
                           String touristAreaIds, String touristParentId) {
        this.id = id;
        this.name = name;
        this.geocode = geocode;
        this.type = type;
        this.countryId = countryId;
        this.featureCode = featureCode;
        this.touristAreaIds = touristAreaIds;
        this.touristParentId = touristParentId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GeoCode getGeocode() {
        return geocode;
    }

    public String getType() {
        return type;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public String getTouristAreaIds() {
        return touristAreaIds;
    }

    public String getTouristParentId() {
        return touristParentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, geocode, type, countryId, featureCode, touristAreaIds, touristParentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EnquiryLocation other = (EnquiryLocation) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.geocode, other.geocode)
                && Objects.equals(this.type, other.type)
                && Objects.equals(this.countryId, other.countryId)
                && Objects.equals(this.featureCode, other.featureCode)
                && Objects.equals(this.touristAreaIds, other.touristAreaIds)
                && Objects.equals(this.touristParentId, other.touristParentId);
    }
}
