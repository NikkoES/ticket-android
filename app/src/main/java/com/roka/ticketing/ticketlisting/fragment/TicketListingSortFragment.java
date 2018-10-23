package com.roka.ticketing.ticketlisting.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by roka on 23/02/18.
 */

public class TicketListingSortFragment extends Fragment {
    public static TicketListingSortFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TicketListingSortFragment fragment = new TicketListingSortFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
