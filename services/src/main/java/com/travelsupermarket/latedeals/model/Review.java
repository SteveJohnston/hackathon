package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.Objects;

/**
 * Representation of Review entity
 */
@JsonPropertyOrder({"reviewCount", "score","description"})
public final class Review {
    private final Integer reviewCount;
    private final Integer score;
    private final String description;

    /**
     * Needed for JSON Deserialisation.
     */
    public Review() {
        this.score = null;
        this.reviewCount = null;
        this.description = null;
    }

    /**
     * Constructor for builder.
     */
    private Review(ReviewBuilder builder) {
        this.score = builder.score;
        this.reviewCount = builder.reviewCount;
        this.description = builder.description;
    }

    @JsonProperty
    public Integer getScore() {
        return score;
    }

    @JsonProperty
    public Integer getReviewCount() {
        return reviewCount;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (reviewCount != null ? !reviewCount.equals(review.reviewCount) : review.reviewCount != null) return false;
        if (description != null ? !description.equals(review.description) : review.description != null) return false;
        if (score != null ? !score.equals(review.score) : review.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reviewCount, description, score);
    }

    /**
     * Builder for Review.
     */
    public static class ReviewBuilder {
        private Integer reviewCount;
        private Integer score;
        private String description;

        /**
         * sets the score
         *
         * @param reviewCount
         * @return
         */
        public ReviewBuilder withRating(Integer reviewCount) {
            this.reviewCount = reviewCount;
            return this;
        }

        /**
         * sets the reviewCount
         *
         * @param score
         * @return
         */
        public ReviewBuilder withScore(Integer score) {
            this.score = score;
            return this;
        }

        /**
         * sets the description
         *
         * @param description
         * @return
         */
        public ReviewBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * creates an instance of Review
         *
         * @return
         */

        public Review build() {
            return new Review(this);
        }
    }
}
