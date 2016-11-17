package com.travelsupermarket.latedeals.model;

import java.util.Objects;

/**
 * Stores various hotel related facilities.
 */
public class HotelsFacility {
    private final String filterId;
    private final String name;
    private final Boolean included;

    /**
     * Constructor.
     */
    public HotelsFacility() {
        this.filterId = null;
        this.name = null;
        this.included = null;
    }

    /**
     * Constructor.
     */
    public HotelsFacility(String filterId, String name, Boolean included) {
        this.filterId = filterId;
        this.name = name;
        this.included = included;
    }

    public String getFilterId() {
        return filterId;
    }

    public String getName() {
        return name;
    }

    public Boolean getIncluded() {
        return included;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelsFacility that = (HotelsFacility) o;

        if (filterId != null ? !filterId.equals(that.filterId) : that.filterId != null) return false;
        if (included != null ? !included.equals(that.included) : that.included != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filterId, name, included);
    }

    /**
     * Builder for HotelFacilities
     */
    public static class HotelsFacilityBuilder {
        private String filterId;
        private String name;
        private Boolean included;

        /**
         * Sets the id.
         */
        public HotelsFacilityBuilder withFilterId(String filterId) {
            this.filterId = filterId;
            return this;
        }

        /**
         * Sets the name.
         */
        public HotelsFacilityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets whether this is included.
         */
        public HotelsFacilityBuilder withIncluded(Boolean included) {
            this.included = included;
            return this;
        }

        /**
         * Build the Facility.
         */
        public HotelsFacility build() {
            return new HotelsFacility(filterId, name, included);
        }
    }

}
