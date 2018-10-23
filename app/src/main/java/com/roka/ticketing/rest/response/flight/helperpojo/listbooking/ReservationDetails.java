package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ReservationDetails{

	@SerializedName("BookingCode")
	private BookingCode bookingCode;

	@SerializedName("BookingDate")
	private BookingDate bookingDate;

	@SerializedName("CurrencyCode")
	private CurrencyCode currencyCode;

	@SerializedName("Status")
	private Status status;

	@SerializedName("BalanceDueRemarks")
	private BalanceDueRemarks balanceDueRemarks;

	@SerializedName("BalanceDue")
	private BalanceDue balanceDue;

	@SerializedName("Time")
	private Time time;

	@SerializedName("TimeDescription")
	private TimeDescription timeDescription;

	public void setBookingCode(BookingCode bookingCode){
		this.bookingCode = bookingCode;
	}

	public BookingCode getBookingCode(){
		return bookingCode;
	}

	public void setBookingDate(BookingDate bookingDate){
		this.bookingDate = bookingDate;
	}

	public BookingDate getBookingDate(){
		return bookingDate;
	}

	public void setCurrencyCode(CurrencyCode currencyCode){
		this.currencyCode = currencyCode;
	}

	public CurrencyCode getCurrencyCode(){
		return currencyCode;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	public void setBalanceDueRemarks(BalanceDueRemarks balanceDueRemarks){
		this.balanceDueRemarks = balanceDueRemarks;
	}

	public BalanceDueRemarks getBalanceDueRemarks(){
		return balanceDueRemarks;
	}

	public void setBalanceDue(BalanceDue balanceDue){
		this.balanceDue = balanceDue;
	}

	public BalanceDue getBalanceDue(){
		return balanceDue;
	}

	public void setTime(Time time){
		this.time = time;
	}

	public Time getTime(){
		return time;
	}

	public void setTimeDescription(TimeDescription timeDescription){
		this.timeDescription = timeDescription;
	}

	public TimeDescription getTimeDescription(){
		return timeDescription;
	}

	@Override
 	public String toString(){
		return 
			"ReservationDetails{" + 
			"bookingCode = '" + bookingCode + '\'' + 
			",bookingDate = '" + bookingDate + '\'' + 
			",currencyCode = '" + currencyCode + '\'' + 
			",status = '" + status + '\'' + 
			",balanceDueRemarks = '" + balanceDueRemarks + '\'' + 
			",balanceDue = '" + balanceDue + '\'' + 
			",time = '" + time + '\'' + 
			",timeDescription = '" + timeDescription + '\'' + 
			"}";
		}
}