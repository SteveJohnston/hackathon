package com.travelsupermarket.latedeals.model;

/**
 * Container for travel summary properties for both hotels and holidays
 */
public class TravelSummary {

    private final Integer uniqueNumProviders;
    private final Integer numResults;
    private final Double valueNextProvider;
    private final Double valueAvgProvider;

    protected TravelSummary(Integer uniqueNumProviders, Integer numResults, Double valueNextProvider, Double valueAvgProvider) {
        this.uniqueNumProviders = uniqueNumProviders;
        this.numResults = numResults;
        this.valueNextProvider = valueNextProvider;
        this.valueAvgProvider = valueAvgProvider;
    }

    public Integer getUniqueNumProviders() {
        return uniqueNumProviders;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public Double getValueNextProvider() {
        return valueNextProvider;
    }

    public Double getValueAvgProvider() {
        return valueAvgProvider;
    }

    /**
     * Builder for <code>TravelSummary</code>
     */
    public static class Builder {

        private Integer uniqueNumProviders;
        private Integer numResults;
        private Double valueNextProvider;
        private Double valueAvgProvider;

        /**
         * Default constructor
         */
        public Builder() {
        }

        /**
         * Overloaded constructor to create from an existing summary
         *
         * @param summary an existing TravelSummary
         */
        public Builder(TravelSummary summary) {
            if (summary != null) {
                this.uniqueNumProviders = summary.getUniqueNumProviders();
                this.numResults = summary.getNumResults();
                this.valueNextProvider = summary.getValueNextProvider();
                this.valueAvgProvider = summary.getValueAvgProvider();
            }
        }

        /**
         * @param uniqueNumProviders
         * @return this <code>Builder</code>
         */
        public Builder withUniqueNumProviders(Integer uniqueNumProviders) {
            this.uniqueNumProviders = uniqueNumProviders;
            return this;
        }

        /**
         * @param numResults
         * @return this <code>Builder</code>
         */
        public Builder withNumResults(Integer numResults) {
            this.numResults = numResults;
            return this;
        }

        /**
         * @param valueNextProvider
         * @return this <code>Builder</code>
         */
        public Builder withValueNextProvider(Double valueNextProvider) {
            this.valueNextProvider = valueNextProvider;
            return this;
        }

        /**
         * @param valueAvgProvider
         * @return this <code>Builder</code>
         */
        public Builder withValueAvgProvider(Double valueAvgProvider) {
            this.valueAvgProvider = valueAvgProvider;
            return this;
        }

        /**
         * @return the <code>TravelSummary</code>
         */
        public TravelSummary build() {
            if (uniqueNumProviders == null && numResults == null && valueNextProvider == null && valueAvgProvider == null)
                return null;
            return new TravelSummary(uniqueNumProviders, numResults, valueNextProvider, valueAvgProvider);
        }
    }
}
