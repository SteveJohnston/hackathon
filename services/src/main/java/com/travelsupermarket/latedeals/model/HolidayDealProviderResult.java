package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.msm.utils.jackson.DateTimeDeserializer;
import com.msm.utils.jackson.DateTimeSerializer;
import org.joda.time.DateTime;

import java.util.Objects;
import java.util.UUID;

/**
 * Models the result details for a holiday deal.
 */
public class HolidayDealProviderResult {
    private final UUID id;
    private final String providerId;
    private final String providerName;
    private final String phoneToBook;

    private final HolidayPrices prices;
    private final HolidayDealFlightAndHotelPrices flightPrices;
    private final HolidayDealFlightAndHotelPrices hotelPrices;

    private final Integer numSeatsRemaining;
    private final Integer numRoomsRemaining;
    private final HotelsBoardBasisType boardBasis;
    private final DateTime checkInDate;
    private final DateTime checkOutDate;
    private final String roomDescription;
    private final String dealMessage;

    //TODO this will change
    private final HolidayExtras holidayExtras;
    private final String dealKey;
    private final Long expires;
    private final String queryMetaHash;
    private final Long cacheStartTime;
    private final Integer numNights;


    /**
     * Constructor.
     */
    public HolidayDealProviderResult(UUID id, String providerId, String providerName, String phoneToBook,
                                     HolidayPrices prices, HolidayDealFlightAndHotelPrices flightPrices,
                                     HolidayDealFlightAndHotelPrices hotelPrices, Integer numSeatsRemaining,
                                     Integer numRoomsRemaining, HotelsBoardBasisType boardBasis, DateTime checkInDate,
                                     DateTime checkOutDate, String roomDescription, String dealMessage,
                                     HolidayExtras holidayExtras, String dealKey, Long expires, String queryMetaHash,
                                     Integer numNights, Long cacheStartTime) {
        this.id = id;
        this.providerId = providerId;
        this.providerName = providerName;
        this.phoneToBook = phoneToBook;
        this.prices = prices;
        this.flightPrices = flightPrices;
        this.hotelPrices = hotelPrices;
        this.numSeatsRemaining = numSeatsRemaining;
        this.numRoomsRemaining = numRoomsRemaining;
        this.boardBasis = boardBasis;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomDescription = roomDescription;
        this.dealMessage = dealMessage;
        this.holidayExtras = holidayExtras;
        this.dealKey = dealKey;
        this.expires = expires;
        this.queryMetaHash = queryMetaHash;
        this.numNights = numNights;
        this.cacheStartTime = cacheStartTime;
    }

    /**
     * Constructor.
     */


    public UUID getId() {
        return id;
    }

    public String getProviderId() {
        return providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getPhoneToBook() {
        return phoneToBook;
    }

    public HolidayPrices getPrices() {
        return prices;
    }

    public HolidayDealFlightAndHotelPrices getFlightPrices() {
        return flightPrices;
    }

    public Integer getNumSeatsRemaining() {
        return numSeatsRemaining;
    }

    public HotelsBoardBasisType getBoardBasis() {
        return boardBasis;
    }

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public DateTime getCheckInDate() {
        return checkInDate;
    }

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public DateTime getCheckOutDate() {
        return checkOutDate;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getDealMessage() {
        return dealMessage;
    }

    public Integer getNumRoomsRemaining() {
        return numRoomsRemaining;
    }

    public HolidayDealFlightAndHotelPrices getHotelPrices() {
        return hotelPrices;
    }

    public HolidayExtras getHolidayExtras() {
        return holidayExtras;
    }

    public String getDealKey() {
        return this.dealKey;
    }

    public Long getExpires() {
        return expires;
    }

    public Long getCacheStartTime() {
        return cacheStartTime;
    }
   
    public String getQueryMetaHash() {
        return queryMetaHash;
    }

    public Integer getNumNights() {
        return numNights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayDealProviderResult that = (HolidayDealProviderResult) o;

        if (boardBasis != that.boardBasis) return false;
        if (checkInDate != null ? !checkInDate.equals(that.checkInDate) : that.checkInDate != null) return false;
        if (checkOutDate != null ? !checkOutDate.equals(that.checkOutDate) : that.checkOutDate != null) return false;
        if (dealMessage != null ? !dealMessage.equals(that.dealMessage) : that.dealMessage != null) return false;
        if (flightPrices != null ? !flightPrices.equals(that.flightPrices) : that.flightPrices != null) return false;
        if (holidayExtras != null ? !holidayExtras.equals(that.holidayExtras) : that.holidayExtras != null)
            return false;
        if (hotelPrices != null ? !hotelPrices.equals(that.hotelPrices) : that.hotelPrices != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (numRoomsRemaining != null ? !numRoomsRemaining.equals(that.numRoomsRemaining) : that.numRoomsRemaining != null)
            return false;
        if (numSeatsRemaining != null ? !numSeatsRemaining.equals(that.numSeatsRemaining) : that.numSeatsRemaining != null)
            return false;
        if (phoneToBook != null ? !phoneToBook.equals(that.phoneToBook) : that.phoneToBook != null) return false;
        if (prices != null ? !prices.equals(that.prices) : that.prices != null) return false;
        if (providerId != null ? !providerId.equals(that.providerId) : that.providerId != null) return false;
        if (roomDescription != null ? !roomDescription.equals(that.roomDescription) : that.roomDescription != null)
            return false;
        if (dealKey != null ? !dealKey.equals(that.dealKey) : that.dealKey != null)
            return false;
        if (expires != null ? !expires.equals(that.expires) : that.expires != null)
            return false;
        if (queryMetaHash != null ? !queryMetaHash.equals(that.queryMetaHash) : that.queryMetaHash != null)
            return false;
        if(cacheStartTime != null ? !cacheStartTime.equals(that.cacheStartTime) : that.cacheStartTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(providerId, phoneToBook, prices, flightPrices, hotelPrices,
                numSeatsRemaining, numRoomsRemaining, boardBasis, checkInDate, checkOutDate, roomDescription,
                dealMessage, holidayExtras, cacheStartTime);
    }

    /**
     * Builder for Holiday deal provider results.
     */
    public static final class Builder {
        private UUID id;
        private String providerId;
        private String providerName;
        private String phoneToBook;
        private HolidayPrices prices;
        private HolidayDealFlightAndHotelPrices flightPrices;
        private HolidayDealFlightAndHotelPrices hotelPrices;
        private Integer numSeatsRemaining;
        private Integer numRoomsRemaining;
        private HotelsBoardBasisType boardBasis;
        private DateTime checkInDate;
        private DateTime checkOutDate;
        private String roomDescription;
        private String dealMessage;
        private HolidayExtras holidayExtras;
        private String dealKey;
        private Long expires;
        private String queryMetaHash;
        private Long cacheStartTime;
        private Integer numNights;

        /**
         */
        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        /**
         */
        public Builder withProviderId(String providerId) {
            this.providerId = providerId;
            return this;
        }

        /**
         */
        public Builder withProviderName(String providerName) {
            this.providerName = providerName;
            return this;
        }

        /**
         */
        public Builder withPhoneToBook(String phoneToBook) {
            this.phoneToBook = phoneToBook;
            return this;
        }

        /**
         */
        public Builder withPrices(HolidayPrices prices) {
            this.prices = prices;
            return this;
        }

        /**
         */
        public Builder withFlightPrices(HolidayDealFlightAndHotelPrices flightPrices) {
            this.flightPrices = flightPrices;
            return this;
        }

        /**
         */
        public Builder withHotelPrices(HolidayDealFlightAndHotelPrices hotelPrices) {
            this.hotelPrices = hotelPrices;
            return this;
        }

        /**
         */
        public Builder withNumSeatsRemaining(Integer numSeatsRemaining) {
            this.numSeatsRemaining = numSeatsRemaining;
            return this;
        }

        /**
         */
        public Builder withNumRoomsRemaining(Integer numRoomsRemaining) {
            this.numRoomsRemaining = numRoomsRemaining;
            return this;
        }

        /**
         */
        public Builder withBoardBasis(HotelsBoardBasisType boardBasis) {
            this.boardBasis = boardBasis;
            return this;
        }

        /**
         */
        public Builder withCheckInDate(DateTime checkInDate) {
            this.checkInDate = checkInDate;
            return this;
        }

        /**
         */
        public Builder withCheckOutDate(DateTime checkOutDate) {
            this.checkOutDate = checkOutDate;
            return this;
        }

        /**
         */
        public Builder withRoomDescription(String roomDescription) {
            this.roomDescription = roomDescription;
            return this;
        }

        /**
         */
        public Builder withDealMessage(String dealMessage) {
            this.dealMessage = dealMessage;
            return this;
        }

        /**
         */
        public Builder withHolidayExtras(HolidayExtras holidayExtras) {
            this.holidayExtras = holidayExtras;
            return this;
        }

        /**
         */
        public Builder withDealKey(String dealKey) {
            this.dealKey = dealKey;
            return this;
        }

        /**
         */
        public Builder withExpires(Long expires) {
            this.expires = expires;
            return this;
        }


        /**
         */
        public Builder withQueryMetaHash(String queryMetaHash) {
            this.queryMetaHash = queryMetaHash;
            return this;
        }

        /**
         */
        public Builder withCacheStartTime(Long cacheStartTime) {
            this.cacheStartTime = cacheStartTime;
            return this;
        }

        /**
         */
        public Builder withNumNights(Integer numNights) {
            this.numNights = numNights;
            return this;
        }

        /**
         */
        public HolidayDealProviderResult build() {
            return new HolidayDealProviderResult(id, providerId, providerName, phoneToBook, prices, flightPrices,
                    hotelPrices, numSeatsRemaining, numRoomsRemaining, boardBasis, checkInDate, checkOutDate,
                    roomDescription, dealMessage, holidayExtras, dealKey, expires, queryMetaHash, numNights, cacheStartTime);
        }

    }
}
