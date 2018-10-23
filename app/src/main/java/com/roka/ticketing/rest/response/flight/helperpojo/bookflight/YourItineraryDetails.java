
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class YourItineraryDetails {

    @SerializedName("AgentDetails")
    private AgentDetails mAgentDetails;
    @SerializedName("ContactList")
    private ContactList mContactList;
    @SerializedName("ItineraryDetails")
    private ItineraryDetails mItineraryDetails;
    @SerializedName("PassengerDetails")
    private PassengerDetails mPassengerDetails;
    @SerializedName("PaymentDetails")
    private PaymentDetails mPaymentDetails;
    @SerializedName("ReservationDetails")
    private ReservationDetails mReservationDetails;

    public AgentDetails getAgentDetails() {
        return mAgentDetails;
    }

    public ContactList getContactList() {
        return mContactList;
    }

    public ItineraryDetails getItineraryDetails() {
        return mItineraryDetails;
    }

    public PassengerDetails getPassengerDetails() {
        return mPassengerDetails;
    }

    public PaymentDetails getPaymentDetails() {
        return mPaymentDetails;
    }

    public ReservationDetails getReservationDetails() {
        return mReservationDetails;
    }

    public static class Builder {

        private AgentDetails mAgentDetails;
        private ContactList mContactList;
        private ItineraryDetails mItineraryDetails;
        private PassengerDetails mPassengerDetails;
        private PaymentDetails mPaymentDetails;
        private ReservationDetails mReservationDetails;

        public YourItineraryDetails.Builder withAgentDetails(AgentDetails AgentDetails) {
            mAgentDetails = AgentDetails;
            return this;
        }

        public YourItineraryDetails.Builder withContactList(ContactList ContactList) {
            mContactList = ContactList;
            return this;
        }

        public YourItineraryDetails.Builder withItineraryDetails(ItineraryDetails ItineraryDetails) {
            mItineraryDetails = ItineraryDetails;
            return this;
        }

        public YourItineraryDetails.Builder withPassengerDetails(PassengerDetails PassengerDetails) {
            mPassengerDetails = PassengerDetails;
            return this;
        }

        public YourItineraryDetails.Builder withPaymentDetails(PaymentDetails PaymentDetails) {
            mPaymentDetails = PaymentDetails;
            return this;
        }

        public YourItineraryDetails.Builder withReservationDetails(ReservationDetails ReservationDetails) {
            mReservationDetails = ReservationDetails;
            return this;
        }

        public YourItineraryDetails build() {
            YourItineraryDetails YourItineraryDetails = new YourItineraryDetails();
            YourItineraryDetails.mAgentDetails = mAgentDetails;
            YourItineraryDetails.mContactList = mContactList;
            YourItineraryDetails.mItineraryDetails = mItineraryDetails;
            YourItineraryDetails.mPassengerDetails = mPassengerDetails;
            YourItineraryDetails.mPaymentDetails = mPaymentDetails;
            YourItineraryDetails.mReservationDetails = mReservationDetails;
            return YourItineraryDetails;
        }

    }

}
