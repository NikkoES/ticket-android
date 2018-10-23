
package com.roka.ticketing.rest.payload.train;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Adult {

    @Expose
    private String identity;
    @Expose
    private String name;

    public Adult(String identity, String name) {
        this.identity = identity;
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
