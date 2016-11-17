package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.msm.utils.jackson.CurrencyUnitDeserializer;
import com.msm.utils.jackson.CurrencyUnitSerializer;
import com.msm.utils.jackson.SimpleMoneyDeserializer;
import com.msm.utils.jackson.SimpleMoneySerializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.Objects;

/**
 * Holds an individual price for a Holiday Result.
 * The prices can be either "quoted" or "converted".
 * See {@link com.tsm.aggregation.entity.hotels.HotelsPrices}.
 * <p/>
 * It is assumed that all prices are in the same currency as the "currency" field. This is to reduce the json size.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class HolidayPrice {
    private CurrencyUnit currency;
    private Money total;
    private Money avgPP;
    private Money avgPPStrikeThrough;
    private Money totalStrikeThrough;
    private Money adult;
    private Money child;
    private Money infant;
    private Boolean anyFreeChildPlaces;
    /**
     * Though these are derived fields we need to declare them for Jackson deserialization.
     */
    private Integer totalMajorUnits; // Represents the digits prior to the decimal place of total field
    private Integer totalMinorUnits; // Represents the digits following the decimal place of total field
    private Integer avgPPMajorUnits; // Represents the digits prior to the decimal place of avgPP field
    private Integer avgPPMinorUnits; // Represents the digits following the decimal place of avgPP field

    /**
     * Default constructor for JSON marshalling
     */
    protected HolidayPrice() {

    }

    /**
     * Constructor.
     */
    public HolidayPrice(CurrencyUnit currency, Money total, Money avgPP,
                        Money avgPPStrikeThrough, Money totalStrikeThrough,
                        Money adult, Money child, Money infant, Boolean anyFreeChildPlaces) {
        this.currency = currency;
        this.total = total;
        this.avgPP = avgPP;
        this.avgPPStrikeThrough = avgPPStrikeThrough;
        this.totalStrikeThrough = totalStrikeThrough;
        this.adult = adult;
        this.child = child;
        this.infant = infant;
        this.anyFreeChildPlaces = anyFreeChildPlaces;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getTotal() {
        return total;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getAvgPP() {
        return avgPP;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getAvgPPStrikeThrough() {
        return avgPPStrikeThrough;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getTotalStrikeThrough() {
        return totalStrikeThrough;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getAdult() {
        return adult;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getChild() {
        return child;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getInfant() {
        return infant;
    }

    @JsonProperty
    @JsonSerialize(using = CurrencyUnitSerializer.class, as = CurrencyUnit.class)
    @JsonDeserialize(using = CurrencyUnitDeserializer.class, as = CurrencyUnit.class)
    public CurrencyUnit getCurrency() {
        return currency;
    }

    public Boolean getAnyFreeChildPlaces() {
        return anyFreeChildPlaces;
    }

    @JsonProperty
    public String getTotalMajorUnits() {
        return this.total != null ? Integer.toString(this.total.getAmountMajorInt()) : null;
    }

    @JsonProperty
    public String getTotalMinorUnits() {
        return this.total != null ? String.format("%02d", this.total.getAmountMinorInt() - (this.total.getAmountMajorInt() * 100)) : null;
    }

    @JsonProperty
    public String getAvgPPMajorUnits() {
        return this.avgPP != null ? this.avgPP.getAmountMajor().toString() : null;
    }

    @JsonProperty
    public String getAvgPPMinorUnits() {
        return this.avgPP != null ? String.format("%02d", this.avgPP.getAmountMinorInt() - (this.avgPP.getAmountMajorInt() * 100)) : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // Note instance of check here to include sub types of the same class should be equal the same as its parent!
        if (!(o instanceof HolidayPrice)) {
            return false;
        }
        HolidayPrice that = (HolidayPrice) o;
        return Objects.equals(currency, that.currency) &&
                Objects.equals(total, that.total) &&
                Objects.equals(avgPP, that.avgPP) &&
                Objects.equals(avgPPStrikeThrough, that.avgPPStrikeThrough) &&
                Objects.equals(totalStrikeThrough, that.totalStrikeThrough) &&
                Objects.equals(adult, that.adult) &&
                Objects.equals(child, that.child) &&
                Objects.equals(infant, that.infant) &&
                Objects.equals(anyFreeChildPlaces, that.anyFreeChildPlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, total, avgPP, avgPPStrikeThrough,
                totalStrikeThrough, adult, child, infant, anyFreeChildPlaces);
    }

    @Override
    public String toString() {
        return "HolidayPrice{" +
                "currency=" + currency +
                ", total=" + total +
                ", avgPP=" + avgPP +
                ", avgPPStrikeThrough=" + avgPPStrikeThrough +
                ", totalStrikeThrough=" + totalStrikeThrough +
                ", adult=" + adult +
                ", child=" + child +
                ", infant=" + infant +
                ", anyFreeChildPlaces=" + anyFreeChildPlaces +
                '}';
    }

    /**
     * Builder.
     */
    public static class Builder {
        private CurrencyUnit currency;
        private Money total;
        private Money avgPP;
        private Money avgPPStrikeThrough;
        private Money totalStrikeThrough;
        private Money adult;
        private Money child;
        private Money infant;
        private Boolean anyFreeChildPlaces;

        /**
         * Clone price
         */
        public Builder fromPrice(HolidayPrice price) {
            this.currency = price.currency;
            this.total = price.total;
            this.avgPP = price.avgPP;
            this.avgPPStrikeThrough = price.avgPPStrikeThrough;
            this.totalStrikeThrough = price.totalStrikeThrough;
            this.adult = price.adult;
            this.child = price.child;
            this.infant = price.infant;
            this.anyFreeChildPlaces = price.anyFreeChildPlaces;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withCurrency(CurrencyUnit currency) {
            this.currency = currency;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withTotal(Money total) {
            this.total = total;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withAvgPP(Money avgPP) {
            this.avgPP = avgPP;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withAvgPPStrikeThrough(Money avgPPStrikeThrough) {
            this.avgPPStrikeThrough = avgPPStrikeThrough;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withTotalStrikeThrough(Money totalStrikeThrough) {
            this.totalStrikeThrough = totalStrikeThrough;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withAdult(Money adult) {
            this.adult = adult;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withChild(Money child) {
            this.child = child;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withInfant(Money infant) {
            this.infant = infant;
            return this;
        }

        /**
         * Sets the value on the builder.
         */
        public Builder withAnyFreeChildPlaces(Boolean anyFreeChildPlaces) {
            this.anyFreeChildPlaces = anyFreeChildPlaces;
            return this;
        }

        /**
         * Builds an instance of {@link com.tsm.aggregation.entity.holidays.HolidayPrice} with the set values.
         */
        public HolidayPrice build() {
            return new HolidayPrice(currency, total, avgPP, avgPPStrikeThrough,
                    totalStrikeThrough, adult, child, infant, anyFreeChildPlaces);
        }

        /**
         * Builds an instance of {@link PersistableHolidayPrice} with the set values.
         */
        public PersistableHolidayPrice buildPersistable() {
            return new PersistableHolidayPrice(currency, total, avgPP, avgPPStrikeThrough,
                    totalStrikeThrough, adult, child, infant, anyFreeChildPlaces);
        }
    }
}
