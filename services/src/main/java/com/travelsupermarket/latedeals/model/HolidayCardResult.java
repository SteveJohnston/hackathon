package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Optional;
import com.msm.utils.jackson.DateTimeDeserializer;
import com.msm.utils.jackson.DateTimeSerializer;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Entity representing one single Holiday result (one single flight hotel combination).
 */
public class HolidayCardResult {
    private final DateTime date;
    private final String accomId;
    private final GeoCode geoCode;
    private final String accomName;
    private final Integer starRating;
    private final HotelLocation hotelLocation;
    private final HolidayResultType resultType;
    private final Review reviews;
    private final List<HotelsFacility> highlightedFacilities;
    private final ResultsImage primaryImage;
    private final TravelSummary summary;
    private final Double recommendedScore;
    private final HolidayDealCardResult leadInDeal;
    private final List<HolidayAdditionalDealSummary> additionalDealSummaries;
    private final Optional<String> featureCode;
    private final Optional<String> touristParentId;
    private final Optional<String> touristParentName;
    private final boolean externalLocations;

    @JsonIgnore
    private final Integer providerBoostValue;

    /**
     * Constructor.
     */
    public HolidayCardResult(DateTime date, String accomId, GeoCode geoCode, String accomName,
                             Integer starRating, HotelLocation hotelLocation, HolidayResultType resultType,
                             Review reviews, List<HotelsFacility> highlightedFacilities, ResultsImage primaryImage,
                             TravelSummary summary, Double recommendedScore, HolidayDealCardResult leadInDeal, Integer providerBoostValue,
                             List<HolidayAdditionalDealSummary> additionalDealSummaries) {
        this(date, accomId, geoCode, accomName, starRating, hotelLocation, resultType, reviews, highlightedFacilities, primaryImage,
                summary,recommendedScore, leadInDeal, providerBoostValue, additionalDealSummaries, Optional.<String>absent(),
                Optional.<String>absent(), Optional.<String>absent(), false);
    }

    /**
     * Constructor
     * @param date
     * @param accomId
     * @param geoCode
     * @param accomName
     * @param starRating
     * @param hotelLocation
     * @param resultType
     * @param reviews
     * @param highlightedFacilities
     * @param primaryImage
     * @param summary
     * @param recommendedScore
     * @param leadInDeal
     * @param providerBoostValue
     * @param additionalDealSummaries
     * @param featureCode
     * @param touristParentId
     * @param touristParentName
     * @param externalLocations
     */
    public HolidayCardResult(DateTime date, String accomId, GeoCode geoCode, String accomName,
                             Integer starRating, HotelLocation hotelLocation, HolidayResultType resultType,
                             Review reviews, List<HotelsFacility> highlightedFacilities, ResultsImage primaryImage,
                             TravelSummary summary, Double recommendedScore, HolidayDealCardResult leadInDeal, Integer providerBoostValue,
                             List<HolidayAdditionalDealSummary> additionalDealSummaries, Optional<String> featureCode,
                             Optional<String> touristParentId, Optional<String> touristParentName, boolean externalLocations) {
        this.date = date;
        this.accomId = accomId;
        this.geoCode = geoCode;
        this.accomName = accomName;
        this.starRating = starRating;
        this.hotelLocation = hotelLocation;
        this.resultType = resultType;
        this.reviews = reviews;
        this.highlightedFacilities = highlightedFacilities;
        this.primaryImage = primaryImage;
        this.summary = summary;
        this.recommendedScore = recommendedScore;
        this.leadInDeal = leadInDeal;
        this.providerBoostValue = providerBoostValue;
        this.additionalDealSummaries = additionalDealSummaries;
        this.featureCode = featureCode;
        this.touristParentId = touristParentId;
        this.touristParentName = touristParentName;
        this.externalLocations = externalLocations;
    }

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public DateTime getDate() {
        return date;
    }

    public String getAccomId() {
        return accomId;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public String getAccomName() {
        return accomName;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public HotelLocation getHotelLocation() {
        return hotelLocation;
    }

    public HolidayResultType getResultType() {
        return resultType;
    }

    public Review getReviews() {
        return reviews;
    }

    public List<HotelsFacility> getHighlightedFacilities() {
        return highlightedFacilities;
    }

    public ResultsImage getPrimaryImage() {
        return primaryImage;
    }

    public TravelSummary getSummary() {
        return summary;
    }

    public Double getRecommendedScore() {
        return recommendedScore;
    }

    public HolidayDealCardResult getLeadInDeal() {
        return leadInDeal;
    }

    public Integer getProviderBoostValue() {
        return providerBoostValue;
    }

    public Optional<String> getFeatureCode() { return featureCode; }

    public Optional<String> getTouristParentId() { return touristParentId; }

    public Optional<String> getTouristParentName() { return touristParentName; }

    public boolean isExternalLocations() { return externalLocations; }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HolidayAdditionalDealSummary> getAdditionalDealSummaries() { return additionalDealSummaries; }

    public UUID getResultId() {
        // there will always be exactly one ``HolidayDealFlight`` and exactly one ``HolidayDealProviderResult``
        return this.getLeadInDeal().getFlights().get(0).getResults().get(0).getId();
    }

    @Override
    public String toString() {
        return "HolidayCardResult{" +
                "date=" + date +
                ", accomId='" + accomId + '\'' +
                ", geoCode=" + geoCode +
                ", accomName='" + accomName + '\'' +
                ", starRating=" + starRating +
                ", hotelLocation=" + hotelLocation +
                ", resultType=" + resultType +
                ", reviews=" + reviews +
                ", highlightedFacilities=" + highlightedFacilities +
                ", primaryImage=" + primaryImage +
                ", summary=" + summary +
                ", recommendedScore=" + recommendedScore +
                ", leadInDeal=" + leadInDeal +
                ", additionalDealSummaries=" + additionalDealSummaries +
                ", featureCode=" + featureCode +
                ", touristParentId=" + touristParentId +
                ", touristParentName=" + touristParentName +
                ", externalLocations=" + externalLocations +
                ", providerBoostValue=" + providerBoostValue +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, accomId, geoCode, accomName, starRating, hotelLocation, resultType, reviews, highlightedFacilities,
                primaryImage, summary, recommendedScore, leadInDeal, additionalDealSummaries, featureCode, touristParentId,
                touristParentName, externalLocations, providerBoostValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final HolidayCardResult other = (HolidayCardResult) obj;
        return Objects.equals(this.date, other.date)
                && Objects.equals(this.accomId, other.accomId)
                && Objects.equals(this.geoCode, other.geoCode)
                && Objects.equals(this.accomName, other.accomName)
                && Objects.equals(this.starRating, other.starRating)
                && Objects.equals(this.hotelLocation, other.hotelLocation)
                && Objects.equals(this.resultType, other.resultType)
                && Objects.equals(this.reviews, other.reviews)
                && Objects.equals(this.highlightedFacilities, other.highlightedFacilities)
                && Objects.equals(this.primaryImage, other.primaryImage)
                && Objects.equals(this.summary, other.summary)
                && Objects.equals(this.recommendedScore, other.recommendedScore)
                && Objects.equals(this.leadInDeal, other.leadInDeal)
                && Objects.equals(this.additionalDealSummaries, other.additionalDealSummaries)
                && Objects.equals(this.featureCode, other.featureCode)
                && Objects.equals(this.touristParentId, other.touristParentId)
                && Objects.equals(this.touristParentName, other.touristParentName)
                && Objects.equals(this.externalLocations, other.externalLocations)
                && Objects.equals(this.providerBoostValue, other.providerBoostValue);
    }

    /**
     * static method to create the builder.
     * @return
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for HolidayCardResult.
     */
    public static final class Builder {
        private DateTime date;
        private String accomId;
        private GeoCode geoCode;
        private String accomName;
        private Integer starRating;
        private HotelLocation hotelLocation;
        private HolidayResultType resultType = HolidayResultType.META;
        private Review reviews;
        private List<HotelsFacility> highlightedFacilities;
        private ResultsImage primaryImage;
        private TravelSummary summary;
        private Double recommendedScore;
        private HolidayDealCardResult leadInDeal;
        private Integer providerBoostValue;
        private List<HolidayAdditionalDealSummary> additionalDealSummaries;
        private Optional<String> featureCode;
        private Optional<String> touristParentId;
        private Optional<String> touristParentName;
        private boolean externalLocations;


        /**
         * Initialise the builder based on a HolidayCardResult
         */
        public Builder from(HolidayCardResult from) {
            this.date = from.date;
            this.accomId = from.accomId;
            this.geoCode = from.geoCode;
            this.accomName = from.accomName;
            this.starRating = from.starRating;
            this.hotelLocation = from.hotelLocation;
            this.resultType = from.resultType;
            this.reviews = from.reviews;
            this.highlightedFacilities = from.highlightedFacilities;
            this.primaryImage = from.primaryImage;
            this.summary = from.summary;
            this.recommendedScore = from.recommendedScore;
            this.leadInDeal = from.leadInDeal;
            this.providerBoostValue = from.providerBoostValue;
            this.additionalDealSummaries = from.additionalDealSummaries;
            this.featureCode = from.featureCode;
            this.touristParentId = from.touristParentId;
            this.touristParentName = from.touristParentName;
            this.externalLocations = from.externalLocations;
            return this;
        }

        /**
         *
         * @param date
         * @return
         */
        public Builder withDate(DateTime date) {
            this.date = date;
            return this;
        }

        /**
         *
         * @param accomId
         * @return
         */
        public Builder withAccomId(String accomId) {
            this.accomId = accomId;
            return this;
        }

        /**
         *
         * @param geoCode
         * @return
         */
        public Builder withGeoCode(GeoCode geoCode) {
            this.geoCode = geoCode;
            return this;
        }

        /**
         *
         * @param accomName
         * @return
         */
        public Builder withAccomName(String accomName) {
            this.accomName = accomName;
            return this;
        }

        /**
         *
         * @param starRating
         * @return
         */
        public Builder withStarRating(Integer starRating) {
            this.starRating = starRating;
            return this;
        }

        /**
         *
         * @param hotelLocation
         * @return
         */
        public Builder withHotelLocation(HotelLocation hotelLocation) {
            this.hotelLocation = hotelLocation;
            return this;
        }

        /**
         *
         * @param reviews
         * @return
         */
        public Builder withReviews(Review reviews) {
            this.reviews = reviews;
            return this;
        }

        /**
         *
         * @param highlightedFacilities
         * @return
         */
        public Builder withHighlightedFacilities(List<HotelsFacility> highlightedFacilities) {
            this.highlightedFacilities = highlightedFacilities;
            return this;
        }

        /**
         *
         * @param primaryImage
         * @return
         */
        public Builder withPrimaryImage(ResultsImage primaryImage){
            this.primaryImage = primaryImage;
            return this;
        }

        /**
         *
         * @param summary
         * @return
         */
        public Builder withSummary(TravelSummary summary) {
            this.summary = summary;
            return this;
        }

        /**
         * holiday result card recommend score value.
         * @param recommendedScore
         * @return
         */
        public Builder withRecommendedScore(Double recommendedScore) {
            this.recommendedScore = recommendedScore;
            return this;
        }

        /**
         *
         * @param leadInDeal
         * @return
         */
        public Builder withLeadInDeal(HolidayDealCardResult leadInDeal) {
            this.leadInDeal = leadInDeal;
            return this;
        }

        /**
         *
         * @param resultType
         * @return
         */
        public Builder withResultType(HolidayResultType resultType) {
            this.resultType = resultType;
            return this;
        }

        /**
         *
         * @param providerBoostValue
         * @return
         */
        public Builder withProviderBoostValue(Integer providerBoostValue) {
            this.providerBoostValue = providerBoostValue;
            return this;
        }

        /**
         *
         * @param addtionalDealSummary
         * @return
         */
        public Builder withAddtionalDealSummary(List<HolidayAdditionalDealSummary> addtionalDealSummary) {
            this.additionalDealSummaries = addtionalDealSummary;
            return this;
        }

        /**
         *
         * @param featureCode
         * @return
         */
        public Builder withFeatureCode(Optional<String> featureCode) {
            this.featureCode = featureCode;
            return this;
        }

        /**
         *
         * @param touristParentId
         * @return
         */
        public Builder withTouristParentId(Optional<String> touristParentId) {
            this.touristParentId = touristParentId;
            return this;
        }

        /**
         *
         * @param touristParentName
         * @return
         */
        public Builder withTouristParentName(Optional<String> touristParentName) {
            this.touristParentName = touristParentName;
            return this;
        }

        /**
         *
         * @param externalLocations
         * @return
         */
        public Builder withExternalLocations(boolean externalLocations) {
            this.externalLocations = externalLocations;
            return this;
        }

        /**
         *
         * @return
         */
        public HolidayCardResult build() {
            return new HolidayCardResult(date, accomId, geoCode, accomName, starRating, hotelLocation,
                    resultType, reviews, highlightedFacilities, primaryImage, summary, recommendedScore, leadInDeal,
                    providerBoostValue, additionalDealSummaries, featureCode, touristParentId, touristParentName, externalLocations);
        }
    }
}
