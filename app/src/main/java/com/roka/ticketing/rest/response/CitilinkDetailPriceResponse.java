package com.roka.ticketing.rest.response;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CitilinkDetailPriceResponse{

	@SerializedName("baggageWeight")
	private String baggageWeight;

	@SerializedName("totalPrice")
	private int totalPrice;

	@SerializedName("pricePerPerson")
	private int pricePerPerson;

	@SerializedName("flightClass")
	private String flightClass;

	public void setBaggageWeight(String baggageWeight){
		this.baggageWeight = baggageWeight;
	}

	public String getBaggageWeight(){
		return baggageWeight;
	}

	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	public void setPricePerPerson(int pricePerPerson){
		this.pricePerPerson = pricePerPerson;
	}

	public int getPricePerPerson(){
		return pricePerPerson;
	}

	public void setFlightClass(String flightClass){
		this.flightClass = flightClass;
	}

	public String getFlightClass(){
		return flightClass;
	}

	@Override
 	public String toString(){
		return 
			"CitilinkDetailPriceResponse{" + 
			"baggageWeight = '" + baggageWeight + '\'' + 
			",totalPrice = '" + totalPrice + '\'' + 
			",pricePerPerson = '" + pricePerPerson + '\'' + 
			",flightClass = '" + flightClass + '\'' + 
			"}";
		}
}