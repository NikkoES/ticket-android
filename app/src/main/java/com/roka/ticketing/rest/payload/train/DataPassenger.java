
package com.roka.ticketing.rest.payload.train;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class DataPassenger {

    @Expose
    private List<Adult> adult;
    @Expose
    private List<Infant> infant;

    public DataPassenger(List<Adult> adult, List<Infant> infant) {
        this.adult = adult;
        this.infant = infant;
    }

    public List<Adult> getAdult() {
        return adult;
    }

    public void setAdult(List<Adult> adult) {
        this.adult = adult;
    }

    public List<Infant> getInfant() {
        return infant;
    }

    public void setInfant(List<Infant> infant) {
        this.infant = infant;
    }

}
