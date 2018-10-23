package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ContactList{

	@SerializedName("item")
	private List<ItemItem> item;

	public void setItem(List<ItemItem> item){
		this.item = item;
	}

	public List<ItemItem> getItem(){
		return item;
	}

	@Override
 	public String toString(){
		return 
			"ContactList{" + 
			"item = '" + item + '\'' + 
			"}";
		}
}