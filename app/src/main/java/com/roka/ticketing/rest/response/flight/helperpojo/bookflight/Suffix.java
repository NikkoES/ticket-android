
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Suffix {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public Suffix.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public Suffix build() {
            Suffix Suffix = new Suffix();
            Suffix.mvalue = mvalue;
            return Suffix;
        }

    }

}
