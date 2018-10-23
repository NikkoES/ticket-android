package com.roka.ticketing.rest.response.flight;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LionSearchResponse implements Serializable {

    @SerializedName("flight_data")
    private List<FlightDataItem> flightData;

    @SerializedName("price")
    private String price;

    @SerializedName("detail_price")
    private String detailPrice;

    @SerializedName("ticket_id")
    private String ticketId;

    @SerializedName("total_flight_duration")
    private String totalFlightDuration;

    @SerializedName("available_count")
    private String available_count;

    @SerializedName("signature")
    private String signature;

    @SerializedName("journey_id")
    private String journey_id;

    public void setFlightData(List<FlightDataItem> flightData) {
        this.flightData = flightData;
    }

    public List<FlightDataItem> getFlightData() {
        return flightData;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setDetailPrice(String detailPrice) {
        this.detailPrice = detailPrice;
    }

    public String getDetailPrice() {
        return detailPrice;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTotalFlightDuration() {
        return totalFlightDuration;
    }

    public void setTotalFlightDuration(String totalFlightDuration) {
        this.totalFlightDuration = totalFlightDuration;
    }

    public String getAvailable_count() {
        return available_count;
    }

    public void setAvailable_count(String available_count) {
        this.available_count = available_count;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getJourney_id() {
        return journey_id;
    }

    public void setJourney_id(String journey_id) {
        this.journey_id = journey_id;
    }

    @Override
    public String toString() {
        return
                "LionSearchResponse{" +
                        "flight_data = '" + flightData + '\'' +
                        ",price = '" + price + '\'' +
                        ",detail_price = '" + detailPrice + '\'' +
                        ",ticket_id = '" + ticketId + '\'' +
                        ",total_flight_duration = '" + totalFlightDuration + '\'' +
                        ",available_count = '" + available_count + '\'' +
                        ",signature = '" + signature + '\'' +
                        ",journey_id = '" + journey_id + '\'' +
                        "}";
    }
}