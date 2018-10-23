package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Journey{

	@SerializedName("item")
	private Item item;

	public void setItem(Item item){
		this.item = item;
	}

	public Item getItem(){
		return item;
	}

	@Override
 	public String toString(){
		return 
			"Journey{" + 
			"item = '" + item + '\'' + 
			"}";
		}
}