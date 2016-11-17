package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.msm.utils.jackson.MoneyDeserializer;
import com.msm.utils.jackson.MoneySerializer;
import org.joda.money.Money;

import java.util.Objects;

/**
 * Models Holiday Card Fees
 */
public class HolidayCardFees {

    private YesNoMixedType inc;
    private String desc;
    private Money quotedPrice;
    private Money convertedPrice;

    /**
     * Constructor for Jackson
     */
    public HolidayCardFees(){}

    /**
     * Complete constructor.
     *
     * @param inc
     * @param desc
     * @param quotedPrice
     * @param convertedPrice
     */
    public HolidayCardFees(YesNoMixedType inc, String desc, Money quotedPrice, Money convertedPrice) {
        this.inc = inc;
        this.desc = desc;
        this.quotedPrice = quotedPrice;
        this.convertedPrice = convertedPrice;
    }

    /**
     * Provider constructor, no converted price.
     *
     * @param inc
     * @param desc
     * @param quotedPrice
     */
    public HolidayCardFees(YesNoMixedType inc, String desc, Money quotedPrice) {
        this.inc = inc;
        this.desc = desc;
        this.quotedPrice = quotedPrice;
    }

    public YesNoMixedType getInc() {
        return inc;
    }

    public String getDesc() {
        return desc;
    }

    @JsonIgnore
    public Money getQuotedPrice() {
        return quotedPrice;
    }

    @JsonProperty
    @JsonSerialize(using = MoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = MoneyDeserializer.class, as = Money.class)
    public void setQuotedPrice(Money quotedPrice) {
        this.quotedPrice = quotedPrice;
    }

    @JsonProperty
    @JsonSerialize(using = MoneySerializer.class, as = Money.class)
    @JsonDeserialize(using = MoneyDeserializer.class, as = Money.class)
    public Money getConvertedPrice() {
        return convertedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayCardFees that = (HolidayCardFees) o;

        if (convertedPrice != null ? !convertedPrice.equals(that.convertedPrice) : that.convertedPrice != null)
            return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (inc != that.inc) return false;
        if (quotedPrice != null ? !quotedPrice.equals(that.quotedPrice) : that.quotedPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inc, desc, quotedPrice, convertedPrice);
    }
}
