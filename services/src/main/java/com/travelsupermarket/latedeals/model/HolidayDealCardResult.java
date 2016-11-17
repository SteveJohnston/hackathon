package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.msm.utils.jackson.DateTimeDeserializer;
import com.msm.utils.jackson.DateTimeSerializer;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Objects;

/**
 * Individual Flight Card result.
 */
public class HolidayDealCardResult {
    private final DateTime date;
    private final String accomId;
    private final List<HolidayDealFlight> flights;

    @JsonIgnore
    private final Integer providerBoostValue;

    /**
     * Constructor.
     *
     * @param date
     * @param accomId
     * @param flights
     */
    public HolidayDealCardResult(DateTime date, String accomId, List<HolidayDealFlight> flights, Integer providerBoostValue) {
        this.date = date;
        this.accomId = accomId;
        this.flights = flights;
        this.providerBoostValue = providerBoostValue;
    }

    @JsonSerialize(using = DateTimeSerializer.class)
    @JsonDeserialize(using = DateTimeDeserializer.class)
    public DateTime getDate() {
        return date;
    }

    public String getAccomId() {
        return accomId;
    }

    public List<HolidayDealFlight> getFlights() {
        return flights;
    }

    public Integer getProviderBoostValue() {
        return providerBoostValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayDealCardResult that = (HolidayDealCardResult) o;

        if (accomId != null ? !accomId.equals(that.accomId) : that.accomId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (flights != null ? !flights.equals(that.flights) : that.flights != null) return false;
        if (providerBoostValue != null ? !providerBoostValue.equals(that.providerBoostValue) :
                that.providerBoostValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, accomId, flights, providerBoostValue);
    }
}
