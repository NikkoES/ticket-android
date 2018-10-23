
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Description {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public Description.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public Description build() {
            Description Description = new Description();
            Description.mvalue = mvalue;
            return Description;
        }

    }

}
