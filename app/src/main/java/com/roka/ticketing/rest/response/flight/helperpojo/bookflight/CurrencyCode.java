
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CurrencyCode {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public CurrencyCode.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public CurrencyCode build() {
            CurrencyCode CurrencyCode = new CurrencyCode();
            CurrencyCode.mvalue = mvalue;
            return CurrencyCode;
        }

    }

}
