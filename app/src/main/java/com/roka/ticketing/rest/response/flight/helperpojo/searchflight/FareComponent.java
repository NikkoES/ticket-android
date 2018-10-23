
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FareComponent implements Serializable {

    @SerializedName("item")
    private List<com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponentItem> mFareComponentItem;

    public List<com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponentItem> getFareComponentItem() {
        return mFareComponentItem;
    }

    public static class Builder {

        private List<com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponentItem> mFareComponentItem;

        public FareComponent.Builder withFareComponentItem(List<com.roka.ticketing.rest.response.flight.helperpojo.searchflight.FareComponentItem> FareComponentItem) {
            mFareComponentItem = FareComponentItem;
            return this;
        }

        public FareComponent build() {
            FareComponent FareComponent = new FareComponent();
            FareComponent.mFareComponentItem = mFareComponentItem;
            return FareComponent;
        }

    }

}
