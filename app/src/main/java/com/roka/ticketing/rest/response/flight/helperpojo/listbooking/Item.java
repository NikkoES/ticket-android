package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Item{

	@SerializedName("Segment")
	private Segment segment;

	public void setSegment(Segment segment){
		this.segment = segment;
	}

	public Segment getSegment(){
		return segment;
	}

	@Override
 	public String toString(){
		return 
			"Item{" + 
			"segment = '" + segment + '\'' + 
			"}";
		}
}