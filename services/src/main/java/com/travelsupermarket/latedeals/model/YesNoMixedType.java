package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum to hold yes no or mixed.
 */
public enum YesNoMixedType {

    /**
     * Yes
     */
    YES("Y"),

    /**
     * No
     */
    NO("N"),

    /**
     * Mixed
     */
    MIXED("M");

    private String shortName;

    /**
     * Constructor.
     *
     * @param shortName
     */
    private YesNoMixedType(String shortName) {
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
    public static YesNoMixedType fromJson(String value) {
        if (value.equalsIgnoreCase(YesNoMixedType.YES.toString())) {
            return YES;
        } else if (value.equalsIgnoreCase(YesNoMixedType.NO.toString())) {
            return NO;
        } else if (value.equalsIgnoreCase(YesNoMixedType.MIXED.toString())) {
            return MIXED;
        } else {
            return null;
        }
    }

    /**
     * Return Y, N or null depending on the value.
     */
    public static YesNoMixedType fromBoolean(Boolean value) {
        if (value == null) {
            return null;
        } else if (value) {
            return YesNoMixedType.YES;
        } else {
            return YesNoMixedType.NO;
        }
    }
}
