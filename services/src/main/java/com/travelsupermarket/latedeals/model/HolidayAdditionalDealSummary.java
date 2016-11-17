package com.travelsupermarket.latedeals.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

/**
 * Stores Additinal deal summary details.
 */
public class HolidayAdditionalDealSummary {
    private final String id;
    private final String providerId;
    private final int sequence;
    private final HolidayPrice price;
    private final String dealKey;
    private final Long expires;

    @JsonIgnore
    private final Integer providerBoostValue;

    /**
     *
     * @param id
     * @param providerId
     * @param sequence
     * @param price
     * @param dealKey
     * @param expires
     * @param providerBoostValue
     */
    public HolidayAdditionalDealSummary(String id, String providerId, int sequence, HolidayPrice price,
                                        String dealKey, Long expires, Integer providerBoostValue) {
        this.id = id;
        this.providerId = providerId;
        this.sequence = sequence;
        this.price = price;
        this.dealKey = dealKey;
        this.expires = expires;
        this.providerBoostValue = providerBoostValue;
    }

    public String getId() {
        return id;
    }

    public String getProviderId() {
        return providerId;
    }

    public int getSequence() {
        return sequence;
    }

    public HolidayPrice getPrice() {
        return price;
    }

    public String getDealKey() {
        return dealKey;
    }

    public Long getExpires() {
        return expires;
    }

    public Integer getProviderBoostValue() {
        return providerBoostValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayAdditionalDealSummary that = (HolidayAdditionalDealSummary) o;

        if (sequence != that.sequence) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (dealKey != null ? !dealKey.equals(that.dealKey) : that.dealKey != null) return false;
        if (expires != null ? !expires.equals(that.expires) : that.expires != null) return false;
        return !(providerBoostValue != null ? !providerBoostValue.equals(that.providerBoostValue) : that.providerBoostValue != null);

    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, id, providerId, price, dealKey, expires, providerBoostValue);
    }

    /**
     * Builder for Holiday Additional deal summary results.
     */
    public static class HolidayAdditionalDealSummaryBuilder {
        private String id;
        private String providerId;
        private int sequence;
        private HolidayPrice price;
        private String dealKey;
        private Long expires;
        private Integer providerBoostValue;

        /**
         *
         * @param id
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withId(String id) {
            this.id = id;
            return this;
        }

        /**
         *
         * @param providerId
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withProviderId(String providerId) {
            this.providerId = providerId;
            return this;
        }

        /**
         *
         * @param sequence
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withSequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        /**
         *
         * @param price
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withPrices(HolidayPrice price) {
            this.price = price;
            return this;
        }

        /**
         *
         * @param dealKey
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withDealKey(String dealKey) {
            this.dealKey = dealKey;
            return this;
        }

        /**
         *
         * @param expires
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withExpires(Long expires) {
            this.expires = expires;
            return this;
        }


        /**
         *
         * @param providerBoostValue
         * @return
         */
        public HolidayAdditionalDealSummaryBuilder withProviderBoostValue(Integer providerBoostValue) {
            this.providerBoostValue = providerBoostValue;
            return this;
        }

        /**
         *
         * @return
         */
        public HolidayAdditionalDealSummary build() {
            return new HolidayAdditionalDealSummary(id, providerId, sequence, price, dealKey, expires, providerBoostValue);
        }
    }

}
