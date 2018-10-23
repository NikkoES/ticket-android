
package com.roka.ticketing.rest.response.flight.helperpojo.bookflight;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class ContactList {

    @SerializedName("item")
    private List<Item> mItem;

    public List<Item> getItem() {
        return mItem;
    }

    public static class Builder {

        private List<Item> mItem;

        public ContactList.Builder withItem(List<Item> item) {
            mItem = item;
            return this;
        }

        public ContactList build() {
            ContactList ContactList = new ContactList();
            ContactList.mItem = mItem;
            return ContactList;
        }

    }

}
