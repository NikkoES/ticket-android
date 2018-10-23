package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ItemItem{

	@SerializedName("CityFromName")
	private CityFromName cityFromName;

	@SerializedName("CityTo")
	private CityTo cityTo;

	@SerializedName("FlownDate")
	private FlownDate flownDate;

	@SerializedName("CheckInStatus")
	private CheckInStatus checkInStatus;

	@SerializedName("Class")
	private ItemClass itemClass;

	@SerializedName("ReservationStatus")
	private ReservationStatus reservationStatus;

	@SerializedName("CityFrom")
	private CityFrom cityFrom;

	@SerializedName("StdLT")
	private StdLT stdLT;

	@SerializedName("CityToName")
	private CityToName cityToName;

	@SerializedName("FlightNo")
	private FlightNo flightNo;

	@SerializedName("StaLT")
	private StaLT staLT;

	public void setCityFromName(CityFromName cityFromName){
		this.cityFromName = cityFromName;
	}

	public CityFromName getCityFromName(){
		return cityFromName;
	}

	public void setCityTo(CityTo cityTo){
		this.cityTo = cityTo;
	}

	public CityTo getCityTo(){
		return cityTo;
	}

	public void setFlownDate(FlownDate flownDate){
		this.flownDate = flownDate;
	}

	public FlownDate getFlownDate(){
		return flownDate;
	}

	public void setCheckInStatus(CheckInStatus checkInStatus){
		this.checkInStatus = checkInStatus;
	}

	public CheckInStatus getCheckInStatus(){
		return checkInStatus;
	}

	public ItemClass getItemClass() {
		return itemClass;
	}

	public void setItemClass(ItemClass itemClass) {
		this.itemClass = itemClass;
	}

	public void setReservationStatus(ReservationStatus reservationStatus){
		this.reservationStatus = reservationStatus;
	}

	public ReservationStatus getReservationStatus(){
		return reservationStatus;
	}

	public void setCityFrom(CityFrom cityFrom){
		this.cityFrom = cityFrom;
	}

	public CityFrom getCityFrom(){
		return cityFrom;
	}

	public void setStdLT(StdLT stdLT){
		this.stdLT = stdLT;
	}

	public StdLT getStdLT(){
		return stdLT;
	}

	public void setCityToName(CityToName cityToName){
		this.cityToName = cityToName;
	}

	public CityToName getCityToName(){
		return cityToName;
	}

	public void setFlightNo(FlightNo flightNo){
		this.flightNo = flightNo;
	}

	public FlightNo getFlightNo(){
		return flightNo;
	}

	public void setStaLT(StaLT staLT){
		this.staLT = staLT;
	}

	public StaLT getStaLT(){
		return staLT;
	}

	@Override
	public String toString() {
		return "ItemItem{" +
				"cityFromName=" + cityFromName +
				", cityTo=" + cityTo +
				", flownDate=" + flownDate +
				", checkInStatus=" + checkInStatus +
				", itemClass=" + itemClass +
				", reservationStatus=" + reservationStatus +
				", cityFrom=" + cityFrom +
				", stdLT=" + stdLT +
				", cityToName=" + cityToName +
				", flightNo=" + flightNo +
				", staLT=" + staLT +
				'}';
	}
}