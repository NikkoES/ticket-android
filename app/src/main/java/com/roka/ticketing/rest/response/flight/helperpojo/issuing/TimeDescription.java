
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class TimeDescription {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public TimeDescription.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public TimeDescription build() {
            TimeDescription TimeDescription = new TimeDescription();
            TimeDescription.mvalue = mvalue;
            return TimeDescription;
        }

    }

}
