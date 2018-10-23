
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PriceDetail implements Serializable {

    @SerializedName("item")
    private List<PriceDetailItem> mPriceDetailItem;

    public List<PriceDetailItem> getPriceDetailItem() {
        return mPriceDetailItem;
    }

    public static class Builder {

        private List<PriceDetailItem> mPriceDetailItem;

        public PriceDetail.Builder withPriceDetailItem(List<PriceDetailItem> PriceDetailItem) {
            mPriceDetailItem = PriceDetailItem;
            return this;
        }

        public PriceDetail build() {
            PriceDetail PriceDetail = new PriceDetail();
            PriceDetail.mPriceDetailItem = mPriceDetailItem;
            return PriceDetail;
        }

    }

}
