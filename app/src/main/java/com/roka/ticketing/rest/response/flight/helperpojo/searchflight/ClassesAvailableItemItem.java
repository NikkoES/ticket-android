package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by roka on 15/03/18.
 */

public class ClassesAvailableItemItem implements Serializable {
    @SerializedName("Key")
    private Key mKey;
    @SerializedName("Availability")
    private Availability mAvailability;
    @SerializedName("SeatAvail")
    private SeatAvail mSeatAvail;
    @SerializedName("PassengerClass")
    private PassengerClass mPassengerClass;
    @SerializedName("Currency")
    private Currency mCurrency;
    @SerializedName("Price")
    private Price mPrice;
    @SerializedName("StatusAvail")
    private StatusAvail mStatusAvail;
    @SerializedName("PriceDetail")
    private PriceDetail mPriceDetail;

    public Key getmKey() {
        return mKey;
    }

    public Availability getmAvailability() {
        return mAvailability;
    }

    public SeatAvail getmSeatAvail() {
        return mSeatAvail;
    }

    public PassengerClass getmPassengerClass() {
        return mPassengerClass;
    }

    public Currency getmCurrency() {
        return mCurrency;
    }

    public Price getmPrice() {
        return mPrice;
    }

    public StatusAvail getmStatusAvail() {
        return mStatusAvail;
    }

    public PriceDetail getmPriceDetail() {
        return mPriceDetail;
    }
}
