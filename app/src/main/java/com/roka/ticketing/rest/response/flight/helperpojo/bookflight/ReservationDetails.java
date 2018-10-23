
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ReservationDetails {

    @SerializedName("BalanceDue")
    private BalanceDue mBalanceDue;
    @SerializedName("BalanceDueRemarks")
    private BalanceDueRemarks mBalanceDueRemarks;
    @SerializedName("BookingCode")
    private BookingCode mBookingCode;
    @SerializedName("BookingDate")
    private BookingDate mBookingDate;
    @SerializedName("CurrencyCode")
    private CurrencyCode mCurrencyCode;
    @SerializedName("Status")
    private Status mStatus;
    @SerializedName("Time")
    private Time mTime;
    @SerializedName("TimeDescription")
    private TimeDescription mTimeDescription;

    public BalanceDue getBalanceDue() {
        return mBalanceDue;
    }

    public BalanceDueRemarks getBalanceDueRemarks() {
        return mBalanceDueRemarks;
    }

    public BookingCode getBookingCode() {
        return mBookingCode;
    }

    public BookingDate getBookingDate() {
        return mBookingDate;
    }

    public CurrencyCode getCurrencyCode() {
        return mCurrencyCode;
    }

    public Status getStatus() {
        return mStatus;
    }

    public Time getTime() {
        return mTime;
    }

    public TimeDescription getTimeDescription() {
        return mTimeDescription;
    }

    public static class Builder {

        private BalanceDue mBalanceDue;
        private BalanceDueRemarks mBalanceDueRemarks;
        private BookingCode mBookingCode;
        private BookingDate mBookingDate;
        private CurrencyCode mCurrencyCode;
        private Status mStatus;
        private Time mTime;
        private TimeDescription mTimeDescription;

        public ReservationDetails.Builder withBalanceDue(BalanceDue BalanceDue) {
            mBalanceDue = BalanceDue;
            return this;
        }

        public ReservationDetails.Builder withBalanceDueRemarks(BalanceDueRemarks BalanceDueRemarks) {
            mBalanceDueRemarks = BalanceDueRemarks;
            return this;
        }

        public ReservationDetails.Builder withBookingCode(BookingCode BookingCode) {
            mBookingCode = BookingCode;
            return this;
        }

        public ReservationDetails.Builder withBookingDate(BookingDate BookingDate) {
            mBookingDate = BookingDate;
            return this;
        }

        public ReservationDetails.Builder withCurrencyCode(CurrencyCode CurrencyCode) {
            mCurrencyCode = CurrencyCode;
            return this;
        }

        public ReservationDetails.Builder withStatus(Status Status) {
            mStatus = Status;
            return this;
        }

        public ReservationDetails.Builder withTime(Time Time) {
            mTime = Time;
            return this;
        }

        public ReservationDetails.Builder withTimeDescription(TimeDescription TimeDescription) {
            mTimeDescription = TimeDescription;
            return this;
        }

        public ReservationDetails build() {
            ReservationDetails ReservationDetails = new ReservationDetails();
            ReservationDetails.mBalanceDue = mBalanceDue;
            ReservationDetails.mBalanceDueRemarks = mBalanceDueRemarks;
            ReservationDetails.mBookingCode = mBookingCode;
            ReservationDetails.mBookingDate = mBookingDate;
            ReservationDetails.mCurrencyCode = mCurrencyCode;
            ReservationDetails.mStatus = mStatus;
            ReservationDetails.mTime = mTime;
            ReservationDetails.mTimeDescription = mTimeDescription;
            return ReservationDetails;
        }

    }

}
