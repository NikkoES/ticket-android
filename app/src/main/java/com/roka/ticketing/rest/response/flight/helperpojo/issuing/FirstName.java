
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class FirstName {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public FirstName.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public FirstName build() {
            FirstName FirstName = new FirstName();
            FirstName.mvalue = mvalue;
            return FirstName;
        }

    }

}
