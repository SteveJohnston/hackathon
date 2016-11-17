package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.msm.utils.jackson.CurrencyUnitDeserializer;
import com.msm.utils.jackson.CurrencyUnitSerializer;
import com.msm.utils.jackson.SimpleMoneyDeserializer;
import com.msm.utils.jackson.SimpleMoneySerializer;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Price information for a Holiday Flight & Hotel
 */
public class HolidayDealFlightAndHotelPrices {

    /**
     * Set from the users locale
     */
    private CurrencyUnit baseCurrency;

    /**
     * Only really used after conversion, matches the currency of the child, adult and infant
     *
     * NOTE THIS IS THE AVG PER PERSON AND NOT THE AVG PER NIGHT LIKE THE HOTELS CHANNEL IS
     */
    private Money avg;

    /**
     * The original average (in providers quoted locale)
     */
    private Money total;

    /**
     * Constructor for use by the builder.
     *
     * @param baseCurrency
     * @param avg
     * @param total
     */
    public HolidayDealFlightAndHotelPrices(CurrencyUnit baseCurrency, Money avg, Money total) {
        this.baseCurrency = baseCurrency;
        this.avg = avg;
        this.total = total;
    }

    @JsonProperty
    @JsonSerialize(using = CurrencyUnitSerializer.class, as = CurrencyUnit.class)
    @JsonDeserialize(using = CurrencyUnitDeserializer.class, as = CurrencyUnit.class)
    public CurrencyUnit getBaseCurrency() {
        return baseCurrency;
    }


    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getAvg() {
        return avg;
    }

    @JsonProperty
    @JsonSerialize(using = SimpleMoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = SimpleMoneyDeserializer.class, as = Money.class)
    public Money getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        HolidayDealFlightAndHotelPrices that = (HolidayDealFlightAndHotelPrices) o;

        return new EqualsBuilder()
                .append(this.baseCurrency, that.baseCurrency)
                .append(this.avg, that.avg)
                .append(this.total, that.total)
                .build();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(baseCurrency)
                .append(avg)
                .append(total)
                .build();
    }

    /**
     * Builds a FlightPrice.
     */
    public static class FlightPriceBuilder {
        private CurrencyUnit baseCurrency;
        private Money avg;
        private Money total;

        /**
         * create an instance of FlightPrice.
         *
         * @return
         */
        public HolidayDealFlightAndHotelPrices build() {
            return new HolidayDealFlightAndHotelPrices(baseCurrency, avg, total);
        }

        /**
         * Sets the baseCurrency.
         *
         * @param baseCurrency
         * @return
         */
        public FlightPriceBuilder withBaseCurrency(CurrencyUnit baseCurrency) {
            this.baseCurrency = baseCurrency;
            return this;
        }

        /**
         * Sets the avg.
         * <p/>
         * Only really used after conversion, matches the currency of the child, adult and infant.
         *
         * @param avg
         * @return
         */
        public FlightPriceBuilder withAvg(Money avg) {
            this.avg = avg;
            return this;
        }

        /**
         * Sets the total.
         * <p/>
         * The original average (in providers quoted locale).
         *
         * @param total
         * @return
         */
        public FlightPriceBuilder withTotal(Money total) {
            this.total = total;
            return this;
        }
    }
}
