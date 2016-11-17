package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum to hold board basis.
 */

 //TODO We will need to replace this enum with BoardService in order to use the BackOffice configuration weights.
 // Currently this enum is used in many places including Provider code.

public enum HotelsBoardBasisType {

    /**
     * NA
     */
    NOT_AVAILABLE("NA", 8),

    /**
     * RO
     */
    ROOM_ONLY("RO", 0),

    /**
     * SC
     */
    SELF_CATERING("SC", 1),

    /**
     * BB
     */
    BED_AND_BREAKFAST("BB", 2),

    /**
     * HB
     */
    HALF_BOARD("HB", 3),

    /**
     * SCC
     */
    SHARE_OF_CATERED_CHALETS("SCC", 7),

    /**
     * CC
     */
    CATERED_CHALETS("CC", 6),

    /**
     * FB
     */
    FULL_BOARD("FB", 4),

    /**
     * AI
     */
    ALL_INCLUSIVE("AI", 5);

    private String shortName;
    private int weight;

    /**
     * Constructor.
     *
     * @param shortName
     * @param weight
     */
    private HotelsBoardBasisType(String shortName, int weight) {
        this.shortName = shortName;
        this.weight = weight;
    }

    @JsonIgnore
    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return shortName;
    }


    public int getWeight() {
        return weight;
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
     *
     * //TODO: Use EnumSet to cycle through so we don't have to enumerate values a second time!
     */
    @JsonCreator
    public static HotelsBoardBasisType fromJson(String value) {
        if (value.equalsIgnoreCase(ROOM_ONLY.toString())) {
            return ROOM_ONLY;
        } else if (value.equalsIgnoreCase(SELF_CATERING.toString())) {
            return SELF_CATERING;
        } else if (value.equalsIgnoreCase(ALL_INCLUSIVE.toString())) {
            return ALL_INCLUSIVE;
        } else if (value.equalsIgnoreCase(BED_AND_BREAKFAST.toString())) {
            return BED_AND_BREAKFAST;
        } else if (value.equalsIgnoreCase(HALF_BOARD.toString())) {
            return HALF_BOARD;
        } else if (value.equalsIgnoreCase(FULL_BOARD.toString())) {
            return FULL_BOARD;
        } else if (value.equalsIgnoreCase(CATERED_CHALETS.toString())) {
            return CATERED_CHALETS;
        } else {
            return NOT_AVAILABLE;
        }
    }
}
