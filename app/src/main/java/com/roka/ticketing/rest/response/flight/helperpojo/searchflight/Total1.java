
package com.roka.ticketing.rest.response.flight.helperpojo.searchflight;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Total1 implements Serializable {


    @SerializedName("value")
    private String mvalue;

    public String getvalue() {
        return mvalue;
    }

    public void setvalue(String value) {
        mvalue = value;
    }

    public static class Builder {


        public Total1 build() {
            Total1 Total1 = new Total1();
            return Total1;
        }

    }

}
