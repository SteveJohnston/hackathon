package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents the a via stop.
 */
public class FlightCardVia {
    private String code;

    /**
     * default constructor.
     */
    public FlightCardVia() {
    }

    /**
     * used by the builder.
     *
     * @param code
     */
    public FlightCardVia(String code) {
        this.code = code;
    }

    @JsonProperty
    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        FlightCardVia that = (FlightCardVia) o;

        return new EqualsBuilder()
                .append(this.code, that.code)
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(code)
                .build();
    }
}
