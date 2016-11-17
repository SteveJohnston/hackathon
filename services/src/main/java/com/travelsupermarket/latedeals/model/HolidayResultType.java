package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum to hold result type
 */
public enum HolidayResultType {

    /**
     * SPONSORED
     */
    SPONSORED("SPONSORED"),

    /**
     * META
     */
    META("META"),

    /**
     * RECOMMENDED
     */
    RECOMMENDED("RECOMMENDED"),

    /**
     * BOOSTED
     */
    BOOSTED("BOOSTED");

    private String shortName;

    /**
     * Constructor.
     *
     * @param shortName
     */
    private HolidayResultType(String shortName) {
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
    public static HolidayResultType fromJson(String value) {
        if (value.equalsIgnoreCase(SPONSORED.toString())) {
            return SPONSORED;
        } else if (value.equalsIgnoreCase(META.toString())) {
            return META;
        } else if (value.equalsIgnoreCase(RECOMMENDED.toString())) {
            return RECOMMENDED;
        } else if (value.equalsIgnoreCase(BOOSTED.toString())) {
            return BOOSTED;
        } else {
            return META;
        }
    }

    /**
     * Get all the result types as Strings
     */
    public static String[] getResultTypes() {
        List<String> resultTypes = new ArrayList<>();
        for (HolidayResultType type : HolidayResultType.values()) {
            resultTypes.add(type.getShortName());
        }
        return resultTypes.toArray(new String[]{});
    }
}
