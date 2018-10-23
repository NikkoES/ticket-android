package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ListBookingResponse{

	@SerializedName("BookingCode")
	private BookingCode bookingCode;

	@SerializedName("YourItineraryDetails")
	private YourItineraryDetails yourItineraryDetails;

	@SerializedName("Username")
	private Username username;

	@SerializedName("timeInsert")
	private long timeInsert;

	@SerializedName("ErrorCode")
	private ErrorCode errorCode;

	@SerializedName("ErrorMessage")
	private ErrorMessage errorMessage;

	@SerializedName("key")
	private String key;

	public void setBookingCode(BookingCode bookingCode){
		this.bookingCode = bookingCode;
	}

	public BookingCode getBookingCode(){
		return bookingCode;
	}

	public void setYourItineraryDetails(YourItineraryDetails yourItineraryDetails){
		this.yourItineraryDetails = yourItineraryDetails;
	}

	public YourItineraryDetails getYourItineraryDetails(){
		return yourItineraryDetails;
	}

	public void setUsername(Username username){
		this.username = username;
	}

	public Username getUsername(){
		return username;
	}

	public void setTimeInsert(long timeInsert){
		this.timeInsert = timeInsert;
	}

	public long getTimeInsert(){
		return timeInsert;
	}

	public void setErrorCode(ErrorCode errorCode){
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode(){
		return errorCode;
	}

	public void setErrorMessage(ErrorMessage errorMessage){
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage(){
		return errorMessage;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"ListBookingResponse{" + 
			"bookingCode = '" + bookingCode + '\'' + 
			",yourItineraryDetails = '" + yourItineraryDetails + '\'' + 
			",username = '" + username + '\'' + 
			",timeInsert = '" + timeInsert + '\'' + 
			",errorCode = '" + errorCode + '\'' + 
			",errorMessage = '" + errorMessage + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}