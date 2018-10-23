
package com.roka.ticketing.rest.payload.train;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DataCaller {

    @Expose
    private String name;
    @Expose
    private String phone;
    @Expose
    private String title;

    public DataCaller(String name, String phone, String title) {
        this.name = name;
        this.phone = phone;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
