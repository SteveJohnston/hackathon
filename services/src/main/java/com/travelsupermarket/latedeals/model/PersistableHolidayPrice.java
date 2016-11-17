package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Class used to ignore certain properties not required to be persisted in to Redis as part of a Holidays Result.
 * <p/>
 * Also used to exclude Null & Empty fields from being serialized.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"totalMajorUnits", "totalMinorUnits", "avgPPMajorUnits", "avgPPMinorUnits"})
public class PersistableHolidayPrice extends HolidayPrice {

    /**
     * Zero-arg constructor needed for Jackson ObjectMapper.
     */
    protected PersistableHolidayPrice() {
        // Do nothing
    }

    /**
     * Constructor.
     */
    public PersistableHolidayPrice(CurrencyUnit currency, Money total, Money avgPP,
                                   Money avgPPStrikeThrough, Money totalStrikeThrough,
                                   Money adult, Money child, Money infant, Boolean anyFreeChildPlaces) {
        super(currency, total, avgPP, avgPPStrikeThrough, totalStrikeThrough, adult, child, infant, anyFreeChildPlaces);
    }

}
