
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FareComponentItem implements Serializable {

    @SerializedName("Amount")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Amount mAmount;
    @SerializedName("CurrencyCode")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.CurrencyCode mCurrencyCode;
    @SerializedName("FareChargeTypeCode")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeCode mFareChargeTypeCode;
    @SerializedName("FareChargeTypeDesc")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeDesc mFareChargeTypeDesc;

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Amount getAmount() {
        return mAmount;
    }

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.CurrencyCode getCurrencyCode() {
        return mCurrencyCode;
    }

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeCode getFareChargeTypeCode() {
        return mFareChargeTypeCode;
    }

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeDesc getFareChargeTypeDesc() {
        return mFareChargeTypeDesc;
    }

    public static class Builder {

        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Amount mAmount;
        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.CurrencyCode mCurrencyCode;
        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeCode mFareChargeTypeCode;
        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeDesc mFareChargeTypeDesc;

        public FareComponentItem.Builder withAmount(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Amount Amount) {
            mAmount = Amount;
            return this;
        }

        public FareComponentItem.Builder withCurrencyCode(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.CurrencyCode CurrencyCode) {
            mCurrencyCode = CurrencyCode;
            return this;
        }

        public FareComponentItem.Builder withFareChargeTypeCode(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeCode FareChargeTypeCode) {
            mFareChargeTypeCode = FareChargeTypeCode;
            return this;
        }

        public FareComponentItem.Builder withFareChargeTypeDesc(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareChargeTypeDesc FareChargeTypeDesc) {
            mFareChargeTypeDesc = FareChargeTypeDesc;
            return this;
        }

        public FareComponentItem build() {
            FareComponentItem FareComponentItem = new FareComponentItem();
            FareComponentItem.mAmount = mAmount;
            FareComponentItem.mCurrencyCode = mCurrencyCode;
            FareComponentItem.mFareChargeTypeCode = mFareChargeTypeCode;
            FareComponentItem.mFareChargeTypeDesc = mFareChargeTypeDesc;
            return FareComponentItem;
        }

    }

}
