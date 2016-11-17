package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Models hotels free cancellation options
 */
@JsonPropertyOrder({"inc", "desc"})
public class FreeCancellation {

    private YesNoMixedType inc;
    private String desc;

    /**
     * Constructor.
     */
    public FreeCancellation() {
    }

    /**
     * Default constructor
     * @param inc included
     * @param desc description
     */
    public FreeCancellation(YesNoMixedType inc, String desc) {
        this.inc = inc;
        this.desc = desc;
    }

    public YesNoMixedType getInc() {
        return inc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FreeCancellation that = (FreeCancellation) o;

        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (inc != that.inc) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = inc != null ? inc.hashCode() : 0;
        result = prime * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}
