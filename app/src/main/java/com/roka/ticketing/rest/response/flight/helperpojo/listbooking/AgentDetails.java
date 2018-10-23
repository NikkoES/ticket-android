package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AgentDetails{

	@SerializedName("BookedBy")
	private BookedBy bookedBy;

	@SerializedName("IssuedBy")
	private IssuedBy issuedBy;

	public void setBookedBy(BookedBy bookedBy){
		this.bookedBy = bookedBy;
	}

	public BookedBy getBookedBy(){
		return bookedBy;
	}

	public void setIssuedBy(IssuedBy issuedBy){
		this.issuedBy = issuedBy;
	}

	public IssuedBy getIssuedBy(){
		return issuedBy;
	}

	@Override
 	public String toString(){
		return 
			"AgentDetails{" + 
			"bookedBy = '" + bookedBy + '\'' + 
			",issuedBy = '" + issuedBy + '\'' + 
			"}";
		}
}