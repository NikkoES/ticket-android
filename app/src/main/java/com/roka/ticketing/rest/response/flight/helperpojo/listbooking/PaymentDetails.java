package com.roka.ticketing.rest.response.flight.helperpojo.listbooking;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PaymentDetails{

	@SerializedName("CurrencyCode")
	private CurrencyCode currencyCode;

	@SerializedName("Others")
	private Others others;

	@SerializedName("Total")
	private Total total;

	@SerializedName("BasicFare")
	private BasicFare basicFare;

	@SerializedName("Nta")
	private Nta nta;

	public void setCurrencyCode(CurrencyCode currencyCode){
		this.currencyCode = currencyCode;
	}

	public CurrencyCode getCurrencyCode(){
		return currencyCode;
	}

	public void setOthers(Others others){
		this.others = others;
	}

	public Others getOthers(){
		return others;
	}

	public void setTotal(Total total){
		this.total = total;
	}

	public Total getTotal(){
		return total;
	}

	public void setBasicFare(BasicFare basicFare){
		this.basicFare = basicFare;
	}

	public BasicFare getBasicFare(){
		return basicFare;
	}

	public void setNta(Nta nta){
		this.nta = nta;
	}

	public Nta getNta(){
		return nta;
	}

	@Override
 	public String toString(){
		return 
			"PaymentDetails{" + 
			"currencyCode = '" + currencyCode + '\'' + 
			",others = '" + others + '\'' + 
			",total = '" + total + '\'' + 
			",basicFare = '" + basicFare + '\'' + 
			",nta = '" + nta + '\'' + 
			"}";
		}
}