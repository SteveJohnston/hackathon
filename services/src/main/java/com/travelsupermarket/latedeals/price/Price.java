package com.travelsupermarket.latedeals.price;

import java.util.Objects;

public class Price {

    private final int priceScore;
    private final int minPricePP;
    private final int maxPricePP;

    public Price() {
        this.priceScore = 0;
        this.minPricePP = 0;
        this.maxPricePP = 0;
    }

    public Price(int priceScore, int minPricePP, int maxPricePP) {
        this.priceScore = priceScore;
        this.minPricePP = minPricePP;
        this.maxPricePP = maxPricePP;
    }

    public int getPriceScore() {
        return priceScore;
    }

    public int getMinPricePP() {
        return minPricePP;
    }

    public int getMaxPricePP() {
        return maxPricePP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceScore, minPricePP, maxPricePP);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Price other = (Price) obj;
        return Objects.equals(this.priceScore, other.priceScore)
                && Objects.equals(this.minPricePP, other.minPricePP)
                && Objects.equals(this.maxPricePP, other.maxPricePP);
    }
}
