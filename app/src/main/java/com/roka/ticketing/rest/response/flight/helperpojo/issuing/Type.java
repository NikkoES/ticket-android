
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Type {

    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public static class Builder {

        private String mvalue;

        public Type.Builder withvalue(String value) {
            mvalue = value;
            return this;
        }

        public Type build() {
            Type Type = new Type();
            Type.mvalue = mvalue;
            return Type;
        }

    }

}
