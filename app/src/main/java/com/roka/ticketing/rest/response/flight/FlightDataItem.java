package com.roka.ticketing.rest.response.flight;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("com.robohorse.robopojogenerator")
public class FlightDataItem implements Serializable{

	@SerializedName("departureTime")
	private String departureTime;

	@SerializedName("arrivalPort")
	private String arrivalPort;

	@SerializedName("maskapai_name")
	private String maskapaiName;

	@SerializedName("arrivalTime")
	private String arrivalTime;

	@SerializedName("departurePort")
	private String departurePort;

	@SerializedName("transition_period")
	private String transitionPeriod;

	@SerializedName("flight_id")
	private String flightId;

	@SerializedName("flight_duration")
	private String flightDuration;

	public void setDepartureTime(String departureTime){
		this.departureTime = departureTime;
	}

	public String getDepartureTime(){
		return departureTime;
	}

	public void setArrivalPort(String arrivalPort){
		this.arrivalPort = arrivalPort;
	}

	public String getArrivalPort(){
		return arrivalPort;
	}

	public void setMaskapaiName(String maskapaiName){
		this.maskapaiName = maskapaiName;
	}

	public String getMaskapaiName(){
		return maskapaiName;
	}

	public void setArrivalTime(String arrivalTime){
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalTime(){
		return arrivalTime;
	}

	public void setDeparturePort(String departurePort){
		this.departurePort = departurePort;
	}

	public String getDeparturePort(){
		return departurePort;
	}

	public void setTransitionPeriod(String transitionPeriod){
		this.transitionPeriod = transitionPeriod;
	}

	public String getTransitionPeriod(){
		return transitionPeriod;
	}

	public void setFlightId(String flightId){
		this.flightId = flightId;
	}

	public String getFlightId(){
		return flightId;
	}

	public void setFlightDuration(String flightDuration){
		this.flightDuration = flightDuration;
	}

	public String getFlightDuration(){
		return flightDuration;
	}

	@Override
 	public String toString(){
		return 
			"FlightDataItem{" + 
			"departureTime = '" + departureTime + '\'' + 
			",arrivalPort = '" + arrivalPort + '\'' + 
			",maskapai_name = '" + maskapaiName + '\'' + 
			",arrivalTime = '" + arrivalTime + '\'' + 
			",departurePort = '" + departurePort + '\'' + 
			",transition_period = '" + transitionPeriod + '\'' + 
			",flight_id = '" + flightId + '\'' + 
			",flight_duration = '" + flightDuration + '\'' + 
			"}";
		}
}