package com.travelsupermarket.latedeals.model;

import java.util.List;
import java.util.Objects;

/**
 * holds all Holidays Extras.
 */
public class HolidayExtras {
    private final FreeCancellation freeCancellation;
    private final List<LocalTax> localTaxes;
    private final List<HolidayCardFees> cardFees;
    private final List<HolidayTransfer> transfers;

    /**
     * Default constructor for JSON marshalling
     */
    protected HolidayExtras() {
        this.freeCancellation = null;
        this.localTaxes = null;
        this.cardFees = null;
        this.transfers = null;
    }

    /**
     * Constructor.
     */
    public HolidayExtras(FreeCancellation freeCancellation, List<LocalTax> localTaxes,
                         List<HolidayCardFees> cardFees, List<HolidayTransfer> transfers) {
        this.freeCancellation = freeCancellation;
        this.localTaxes = localTaxes;
        this.cardFees = cardFees;
        this.transfers = transfers;
    }

    public List<LocalTax> getLocalTaxes() {
        return localTaxes;
    }

    public List<HolidayCardFees> getCardFees() {
        return cardFees;
    }

    public List<HolidayTransfer> getTransfers() {
        return transfers;
    }

    public FreeCancellation getFreeCancellation() {
        return freeCancellation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HolidayExtras that = (HolidayExtras) o;

        if (cardFees != null ? !cardFees.equals(that.cardFees) : that.cardFees != null) return false;
        if (freeCancellation != null ? !freeCancellation.equals(that.freeCancellation) : that.freeCancellation != null)
            return false;
        if (localTaxes != null ? !localTaxes.equals(that.localTaxes) : that.localTaxes != null) return false;
        if (transfers != null ? !transfers.equals(that.transfers) : that.transfers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFees, freeCancellation, localTaxes, transfers);
    }

    /**
     * Builder for HolidayExtras.
     */
    public static final class Builder {
        private FreeCancellation freeCancellation;
        private List<LocalTax> localTaxes;
        private List<HolidayCardFees> cardFees;
        private List<HolidayTransfer> transfers;

        /**
         * Default constructor.
         */
        public Builder(){}

        /**
         * Initialise the builder based on a HolidayExtras
         * @param that
         */
        public Builder(HolidayExtras that) {
            this.freeCancellation = that.freeCancellation;
            this.localTaxes = that.localTaxes;
            this.cardFees = that.cardFees;
            this.transfers = that.transfers;
        }

        /**
         * Sets the local taxes.
         *
         * @param localTaxes
         * @return
         */
        public Builder withLocalTaxes(List<LocalTax> localTaxes) {
            this.localTaxes = localTaxes;
            return this;
        }

        /**
         * Sets the card fees.
         *
         * @param cardFees
         * @return
         */
        public Builder withCardFees(List<HolidayCardFees> cardFees) {
            this.cardFees = cardFees;
            return this;
        }

        /**
         * Sets the transfers.
         *
         * @param transfers
         * @return
         */
        public Builder withTransfers(List<HolidayTransfer> transfers) {
            this.transfers = transfers;
            return this;
        }

        /**
         * Sets the cancellation policy.
         *
         * @param freeCancellation
         * @return
         */
        public Builder withFreeCancellation(FreeCancellation freeCancellation) {
            this.freeCancellation = freeCancellation;
            return this;
        }

        /**
         * Sets the holiday extras.
         *
         * @return
         */
        public HolidayExtras build() {
            return new HolidayExtras(freeCancellation, localTaxes, cardFees, transfers);
        }
    }
}
