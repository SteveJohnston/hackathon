package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enumerates possible cabin class values.
 * <p/>
 * TODO if we used a string instead of an enum we could map this automatically using translation mappings without a switch etc.
 */
public enum CabinClassType {

    /**
     * Ecomony Flights
     */
    ECONOMY("E"),

    /**
     * Premium Ecomony
     */
    PREMIUM_ECONOMY("P"),

    /**
     * Business
     */
    BUSINESS("B"),

    /**
     * First
     */
    FIRST("F"),

    /**
     * Mixed
     */
    MIXED("M"),

    /**
     * Any
     */
    ANY("A"),

    /**
     * Invalid Type
     */
    INVALID("Invalid");

    private final String shortName;

    private CabinClassType(String shortName) {
        this.shortName = shortName;
    }

    @JsonIgnore
    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return shortName;
    }

    /**
     * Convenience method to convert <code>enum</code> to JSON
     */
    @JsonValue
    public String toJson() {
        return toString();
    }

    /**
     * Convenience method to convert JSON to <code>enum</code>
     */
    @JsonCreator
    public static CabinClassType fromJson(String shortName) {
        for (CabinClassType pct : CabinClassType.values()) {
            if (pct.shortName.equals(shortName)) {
                return pct;
            }
        }

        return INVALID;
    }
}
