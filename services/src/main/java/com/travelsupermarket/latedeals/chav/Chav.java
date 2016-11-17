package com.travelsupermarket.latedeals.chav;

import java.util.Objects;

public class Chav {

    private final int chavScore;
    private final int minStarRating;
    private final int maxStarRating;
    private final int minGuestRating;
    private final int maxGuestRating;

    public Chav() {
        this.chavScore = 0;
        this.minStarRating = 0;
        this.maxStarRating = 0;
        this.minGuestRating = 0;
        this.maxGuestRating = 0;
    }

    public Chav(int chavScore, int minStarRating, int maxStarRating, int minGuestRating, int maxGuestRating) {
        this.chavScore = chavScore;
        this.minStarRating = minStarRating;
        this.maxStarRating = maxStarRating;
        this.minGuestRating = minGuestRating;
        this.maxGuestRating = maxGuestRating;
    }

    public int getChavScore() {
        return chavScore;
    }

    public int getMinStarRating() {
        return minStarRating;
    }

    public int getMaxStarRating() {
        return maxStarRating;
    }

    public int getMinGuestRating() {
        return minGuestRating;
    }

    public int getMaxGuestRating() {
        return maxGuestRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chavScore, minStarRating, maxStarRating, minGuestRating, maxGuestRating);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Chav other = (Chav) obj;
        return Objects.equals(this.chavScore, other.chavScore)
                && Objects.equals(this.minStarRating, other.minStarRating)
                && Objects.equals(this.maxStarRating, other.maxStarRating)
                && Objects.equals(this.minGuestRating, other.minGuestRating)
                && Objects.equals(this.maxGuestRating, other.maxGuestRating);
    }
}
