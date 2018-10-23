package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ItineraryDetails{

	@SerializedName("Journey")
	private Journey journey;

	public void setJourney(Journey journey){
		this.journey = journey;
	}

	public Journey getJourney(){
		return journey;
	}

	@Override
 	public String toString(){
		return 
			"ItineraryDetails{" + 
			"journey = '" + journey + '\'' + 
			"}";
		}
}