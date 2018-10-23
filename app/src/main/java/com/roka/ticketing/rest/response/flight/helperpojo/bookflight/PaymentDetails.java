
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PaymentDetails {

    @SerializedName("BasicFare")
    private BasicFare mBasicFare;
    @SerializedName("CurrencyCode")
    private CurrencyCode mCurrencyCode;
    @SerializedName("Nta")
    private Nta mNta;
    @SerializedName("Others")
    private Others mOthers;
    @SerializedName("Total")
    private Total mTotal;

    public BasicFare getBasicFare() {
        return mBasicFare;
    }

    public CurrencyCode getCurrencyCode() {
        return mCurrencyCode;
    }

    public Nta getNta() {
        return mNta;
    }

    public Others getOthers() {
        return mOthers;
    }

    public Total getTotal() {
        return mTotal;
    }

    public static class Builder {

        private BasicFare mBasicFare;
        private CurrencyCode mCurrencyCode;
        private Nta mNta;
        private Others mOthers;
        private Total mTotal;

        public PaymentDetails.Builder withBasicFare(BasicFare BasicFare) {
            mBasicFare = BasicFare;
            return this;
        }

        public PaymentDetails.Builder withCurrencyCode(CurrencyCode CurrencyCode) {
            mCurrencyCode = CurrencyCode;
            return this;
        }

        public PaymentDetails.Builder withNta(Nta Nta) {
            mNta = Nta;
            return this;
        }

        public PaymentDetails.Builder withOthers(Others Others) {
            mOthers = Others;
            return this;
        }

        public PaymentDetails.Builder withTotal(Total Total) {
            mTotal = Total;
            return this;
        }

        public PaymentDetails build() {
            PaymentDetails PaymentDetails = new PaymentDetails();
            PaymentDetails.mBasicFare = mBasicFare;
            PaymentDetails.mCurrencyCode = mCurrencyCode;
            PaymentDetails.mNta = mNta;
            PaymentDetails.mOthers = mOthers;
            PaymentDetails.mTotal = mTotal;
            return PaymentDetails;
        }

    }

}
