
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class IssuedBy {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public IssuedBy.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public IssuedBy build() {
            IssuedBy IssuedBy = new IssuedBy();
            IssuedBy.mvalue = mvalue;
            return IssuedBy;
        }

    }

}
