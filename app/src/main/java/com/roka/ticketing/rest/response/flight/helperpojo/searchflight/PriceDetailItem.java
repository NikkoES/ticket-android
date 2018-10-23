
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PriceDetailItem implements Serializable {

    @SerializedName("FareComponent")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponent mFareComponent;
    @SerializedName("Nta_1")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Nta1 mNta1;
    @SerializedName("PaxCategory")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.PaxCategory mPaxCategory;
    @SerializedName("Total_1")
    private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Total1 mTotal1;

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponent getFareComponent() {
        return mFareComponent;
    }

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Nta1 getNta1() {
        return mNta1;
    }

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.PaxCategory getPaxCategory() {
        return mPaxCategory;
    }

    public com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Total1 getTotal1() {
        return mTotal1;
    }

    public static class Builder {

        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponent mFareComponent;
        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Nta1 mNta1;
        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.PaxCategory mPaxCategory;
        private com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Total1 mTotal1;

        public PriceDetailItem.Builder withFareComponent(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponent FareComponent) {
            mFareComponent = FareComponent;
            return this;
        }

        public PriceDetailItem.Builder withNta1(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Nta1 Nta1) {
            mNta1 = Nta1;
            return this;
        }

        public PriceDetailItem.Builder withPaxCategory(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.PaxCategory PaxCategory) {
            mPaxCategory = PaxCategory;
            return this;
        }

        public PriceDetailItem.Builder withTotal1(com.roka.ticketing.rest.response.flight.helperpojo.searchflight.Total1 Total1) {
            mTotal1 = Total1;
            return this;
        }

        public PriceDetailItem build() {
            PriceDetailItem PriceDetailItem = new PriceDetailItem();
            PriceDetailItem.mFareComponent = mFareComponent;
            PriceDetailItem.mNta1 = mNta1;
            PriceDetailItem.mPaxCategory = mPaxCategory;
            PriceDetailItem.mTotal1 = mTotal1;
            return PriceDetailItem;
        }

    }

}
