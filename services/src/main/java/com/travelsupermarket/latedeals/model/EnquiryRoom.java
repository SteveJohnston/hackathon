package com.travelsupermarket.latedeals.model;

import java.util.List;
import java.util.Objects;

public class EnquiryRoom {

    private final Integer numAdults;
    private final List<EnquiryRoomChildren> children;

    public EnquiryRoom() {
        this.numAdults = null;
        this.children = null;
    }

    public EnquiryRoom(int numAdults, List<EnquiryRoomChildren> children) {
        this.numAdults = numAdults;
        this.children = children;
    }

    public int getNumAdults() {
        return numAdults;
    }

    public List<EnquiryRoomChildren> getChildren() {
        return children;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numAdults, children);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final EnquiryRoom other = (EnquiryRoom) obj;
        return Objects.equals(this.numAdults, other.numAdults)
                && Objects.equals(this.children, other.children);
    }
}
