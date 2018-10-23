package com.roka.ticketing.rest.response.train;

import com.google.gson.annotations.SerializedName;

public class ResultBook {

    @SerializedName("gds_book_code")
    private String gdsBookCode;

    public String getGdsBookCode() {
        return gdsBookCode;
    }

    public void setGdsBookCode(String gdsBookCode) {
        this.gdsBookCode = gdsBookCode;
    }

}