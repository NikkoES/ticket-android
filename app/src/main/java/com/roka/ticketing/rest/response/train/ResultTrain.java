
package com.roka.ticketing.rest.response.train;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ResultTrain {

    @Expose
    private String email;
    @SerializedName("gds_book_code")
    private String gdsBookCode;
    @SerializedName("gds_book_status")
    private String gdsBookStatus;
    @Expose
    private String name;
    @Expose
    private String number;
    @SerializedName("pax_info")
    private List<PaxInfo> paxInfo;
    @SerializedName("route_info")
    private List<RouteInfo> routeInfo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGdsBookCode() {
        return gdsBookCode;
    }

    public void setGdsBookCode(String gdsBookCode) {
        this.gdsBookCode = gdsBookCode;
    }

    public String getGdsBookStatus() {
        return gdsBookStatus;
    }

    public void setGdsBookStatus(String gdsBookStatus) {
        this.gdsBookStatus = gdsBookStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<PaxInfo> getPaxInfo() {
        return paxInfo;
    }

    public void setPaxInfo(List<PaxInfo> paxInfo) {
        this.paxInfo = paxInfo;
    }

    public List<RouteInfo> getRouteInfo() {
        return routeInfo;
    }

    public void setRouteInfo(List<RouteInfo> routeInfo) {
        this.routeInfo = routeInfo;
    }

}
