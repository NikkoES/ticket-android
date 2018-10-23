
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FlightNo {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public FlightNo.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public FlightNo build() {
            FlightNo FlightNo = new FlightNo();
            FlightNo.mvalue = mvalue;
            return FlightNo;
        }

    }

}
