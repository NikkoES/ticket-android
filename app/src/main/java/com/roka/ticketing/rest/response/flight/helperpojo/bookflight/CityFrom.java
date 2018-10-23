
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CityFrom {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public CityFrom.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public CityFrom build() {
            CityFrom CityFrom = new CityFrom();
            CityFrom.mvalue = mvalue;
            return CityFrom;
        }

    }

}
