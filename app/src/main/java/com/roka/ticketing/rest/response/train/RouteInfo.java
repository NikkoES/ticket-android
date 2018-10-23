
package com.roka.ticketing.rest.response.train;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RouteInfo {

    @SerializedName("additional_fee")
    private String additionalFee;
    @SerializedName("arv_date")
    private String arvDate;
    @SerializedName("basic_fare")
    private String basicFare;
    @SerializedName("book_status")
    private String bookStatus;
    @Expose
    private String ccy;
    @SerializedName("dep_date")
    private String depDate;
    @Expose
    private String des;
    @Expose
    private String discount;
    @Expose
    private String org;
    @Expose
    private List<Ticket> ticket;
    @SerializedName("total_price")
    private String totalPrice;
    @SerializedName("transporter_book_code")
    private String transporterBookCode;
    @SerializedName("transporter_name")
    private String transporterName;
    @SerializedName("transporter_no")
    private String transporterNo;
    @SerializedName("transporter_type")
    private String transporterType;

    public String getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(String additionalFee) {
        this.additionalFee = additionalFee;
    }

    public String getArvDate() {
        return arvDate;
    }

    public void setArvDate(String arvDate) {
        this.arvDate = arvDate;
    }

    public String getBasicFare() {
        return basicFare;
    }

    public void setBasicFare(String basicFare) {
        this.basicFare = basicFare;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTransporterBookCode() {
        return transporterBookCode;
    }

    public void setTransporterBookCode(String transporterBookCode) {
        this.transporterBookCode = transporterBookCode;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getTransporterNo() {
        return transporterNo;
    }

    public void setTransporterNo(String transporterNo) {
        this.transporterNo = transporterNo;
    }

    public String getTransporterType() {
        return transporterType;
    }

    public void setTransporterType(String transporterType) {
        this.transporterType = transporterType;
    }

}
