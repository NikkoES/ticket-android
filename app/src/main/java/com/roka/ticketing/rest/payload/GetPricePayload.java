package com.roka.ticketing.rest.payload;

import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.LionSearchResponse;

import java.io.Serializable;

public class GetPricePayload implements Serializable {

    @SerializedName("ticket")
    private LionSearchResponse ticket;

    @SerializedName("payload")
    private SearchFlightPayload payload;


    public LionSearchResponse getTicket() {
        return ticket;
    }

    public void setTicket(LionSearchResponse ticket) {
        this.ticket = ticket;
    }

    public SearchFlightPayload getPayload() {
        return payload;
    }

    public void setPayload(SearchFlightPayload payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "GetPricePayload{" +
                "ticket=" + ticket +
                ", payload=" + payload +
                '}';
    }


}
