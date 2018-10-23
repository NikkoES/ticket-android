
package com.roka.ticketing.rest.response.flight.helperpojo.issuing;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ItineraryDetails {

    @SerializedName("Journey")
    private Journey mJourney;

    public Journey getJourney() {
        return mJourney;
    }

    public static class Builder {

        private Journey mJourney;

        public ItineraryDetails.Builder withJourney(Journey Journey) {
            mJourney = Journey;
            return this;
        }

        public ItineraryDetails build() {
            ItineraryDetails ItineraryDetails = new ItineraryDetails();
            ItineraryDetails.mJourney = mJourney;
            return ItineraryDetails;
        }

    }

}
