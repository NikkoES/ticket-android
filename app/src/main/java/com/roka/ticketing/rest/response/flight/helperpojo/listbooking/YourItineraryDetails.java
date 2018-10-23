package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class YourItineraryDetails{

	@SerializedName("ItineraryDetails")
	private ItineraryDetails itineraryDetails;

	@SerializedName("AgentDetails")
	private AgentDetails agentDetails;

	@SerializedName("ReservationDetails")
	private ReservationDetails reservationDetails;

	@SerializedName("PaymentDetails")
	private PaymentDetails paymentDetails;

	@SerializedName("ContactList")
	private ContactList contactList;

	@SerializedName("PassengerDetails")
	private PassengerDetails passengerDetails;

	public void setItineraryDetails(ItineraryDetails itineraryDetails){
		this.itineraryDetails = itineraryDetails;
	}

	public ItineraryDetails getItineraryDetails(){
		return itineraryDetails;
	}

	public void setAgentDetails(AgentDetails agentDetails){
		this.agentDetails = agentDetails;
	}

	public AgentDetails getAgentDetails(){
		return agentDetails;
	}

	public void setReservationDetails(ReservationDetails reservationDetails){
		this.reservationDetails = reservationDetails;
	}

	public ReservationDetails getReservationDetails(){
		return reservationDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails){
		this.paymentDetails = paymentDetails;
	}

	public PaymentDetails getPaymentDetails(){
		return paymentDetails;
	}

	public void setContactList(ContactList contactList){
		this.contactList = contactList;
	}

	public ContactList getContactList(){
		return contactList;
	}

	public void setPassengerDetails(PassengerDetails passengerDetails){
		this.passengerDetails = passengerDetails;
	}

	public PassengerDetails getPassengerDetails(){
		return passengerDetails;
	}

	@Override
 	public String toString(){
		return 
			"YourItineraryDetails{" + 
			"itineraryDetails = '" + itineraryDetails + '\'' + 
			",agentDetails = '" + agentDetails + '\'' + 
			",reservationDetails = '" + reservationDetails + '\'' + 
			",paymentDetails = '" + paymentDetails + '\'' + 
			",contactList = '" + contactList + '\'' + 
			",passengerDetails = '" + passengerDetails + '\'' + 
			"}";
		}
}