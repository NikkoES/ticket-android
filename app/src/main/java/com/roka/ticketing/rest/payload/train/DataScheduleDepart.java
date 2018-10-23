
package com.roka.ticketing.rest.payload.train;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DataScheduleDepart {

    @SerializedName("dep_date")
    private String depDate;
    @Expose
    private String des;
    @Expose
    private String org;
    @Expose
    private String subclass;
    @SerializedName("transporter_no")
    private String transporterNo;

    public DataScheduleDepart(String depDate, String des, String org, String subclass, String transporterNo) {
        this.depDate = depDate;
        this.des = des;
        this.org = org;
        this.subclass = subclass;
        this.transporterNo = transporterNo;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getTransporterNo() {
        return transporterNo;
    }

    public void setTransporterNo(String transporterNo) {
        this.transporterNo = transporterNo;
    }

}
