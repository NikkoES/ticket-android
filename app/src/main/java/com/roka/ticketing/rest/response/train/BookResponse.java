
package com.roka.ticketing.rest.response.train;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BookResponse {

    @SerializedName("err_num")
    private String errNum;
    @SerializedName("err_str")
    private String errStr;
    @Expose
    private ResultBook result;

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getErrStr() {
        return errStr;
    }

    public void setErrStr(String errStr) {
        this.errStr = errStr;
    }

    public ResultBook getResult() {
        return result;
    }

    public void setResult(ResultBook result) {
        this.result = result;
    }

}
