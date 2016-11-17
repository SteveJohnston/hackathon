package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Holds all prices for a holiday result, both provider quoted and after conversion (left empty until then).
 *
 * @param <T> a type or specialisation of {@link HolidayPrice}
 */
public class HolidayPrices<T extends HolidayPrice> {
    private T converted;
    private T quoted;

    /**
     * Zero-arg constructor needed for Jackson ObjectMapper.
     */
    public HolidayPrices() {
    }

    /**
     * Used by provider to create a version with only the quoted price.
     *
     * @param quoted
     */
    public HolidayPrices(T quoted) {
        this.quoted = quoted;
    }

    /**
     * constructor for both quoted and converted prices.
     *
     * @param converted
     * @param quoted
     */
    public HolidayPrices(T converted, T quoted) {
        this.converted = converted;
        this.quoted = quoted;
    }

    @JsonProperty
    public T getConverted() {
        return converted;
    }

    @JsonProperty
    public T getQuoted() {
        return quoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayPrices that = (HolidayPrices) o;

        if (converted != null ? !converted.equals(that.converted) : that.converted != null) return false;
        if (quoted != null ? !quoted.equals(that.quoted) : that.quoted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(converted, quoted);
    }

    @Override
    public String toString() {
        return "HolidayPrices{" +
                "converted=" + converted +
                ", quoted=" + quoted +
                '}';
    }
}
