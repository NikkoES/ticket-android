
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Attributes {

    @SerializedName("SOAP-ENC:arrayType")
    private String mSOAPENCArrayType;
    @SerializedName("xsi:type")
    private String mXsiType;

    public String getSOAPENCArrayType() {
        return mSOAPENCArrayType;
    }

    public String getXsiType() {
        return mXsiType;
    }

    public static class Builder {

        private String mSOAPENCArrayType;
        private String mXsiType;

        public Attributes.Builder withSOAPENCArrayType(String SOAPENCArrayType) {
            mSOAPENCArrayType = SOAPENCArrayType;
            return this;
        }

        public Attributes.Builder withXsiType(String xsiType) {
            mXsiType = xsiType;
            return this;
        }

        public Attributes build() {
            Attributes Attributes = new Attributes();
            Attributes.mSOAPENCArrayType = mSOAPENCArrayType;
            Attributes.mXsiType = mXsiType;
            return Attributes;
        }

    }

}
