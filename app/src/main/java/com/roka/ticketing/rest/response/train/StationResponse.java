
package com.roka.ticketing.rest.response.train;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.roka.ticketing.rest.payload.train.Result;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class StationResponse {

    @SerializedName("err_num")
    private String errNum;
    @SerializedName("err_str")
    private String errStr;
    @Expose
    private Result result;

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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
