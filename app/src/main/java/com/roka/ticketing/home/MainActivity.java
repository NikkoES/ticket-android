package com.roka.ticketing.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.roka.ticketing.R;
import com.roka.ticketing.home.fragment.BookingListFragment;
import com.roka.ticketing.home.fragment.BookingListTrainFragment;
import com.roka.ticketing.home.fragment.HomeFragment;
import com.roka.ticketing.home.interfaces.HomeInterface;
import com.roka.ticketing.ticket.TicketActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        HomeInterface{

    private TextView mTextMessage;

    public static final String EXTRA_ACTIVE_FRAGMENT = "active_fragment";

    public static final int FRAGMENT_HOME = 1;
    public static final int FRAGMENT_FAVORITE = 2;
    public static final int FRAGMENT_TRANSACTION = 3;
    public static final int FRAGMENT_TRANSACTION_TRAIN = 4;
    public static final int FRAGMENT_CART = 5;
    public static final int FRAGMENT_ACCOUNT = 5;

    public static final int POS_FLIGHT = 0;
    public static final int POS_TRAIN = 1;

    private Fragment mFragment = null;

    private int mActiveFragment;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        mActiveFragment = getIntent().getIntExtra(EXTRA_ACTIVE_FRAGMENT, FRAGMENT_HOME);

        initActionBar();
        initFragment();
    }

    private void initActionBar() {
//        setSupportActionBar(mToolbar);
    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();
        mFragment = HomeFragment.newInstance(this);
        ft.add(R.id.fr_fragment, mFragment);
        ft.commit();
        changeFragment(mActiveFragment);
    }

    private void changeFragment(int fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();

        switch (fragment) {
            case FRAGMENT_HOME :
                mFragment = HomeFragment.newInstance(this);
                break;
            case FRAGMENT_TRANSACTION :
                mFragment = BookingListFragment.newInstance();
                break;
            case FRAGMENT_TRANSACTION_TRAIN :
                mFragment = BookingListTrainFragment.newInstance();
                break;
        }

        ft.replace(R.id.fr_fragment, mFragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
//                mTextMessage.setText(R.string.title_home);
                changeFragment(FRAGMENT_HOME);
                return true;

            case R.id.nav_account :
//                mTextMessage.setText(R.string.title_account);
                changeFragment(FRAGMENT_ACCOUNT);
                return true;

//            case R.id.nav_cart :
////                mTextMessage.setText(R.string.title_cart);
//                changeFragment(FRAGMENT_CART);
//                return true;

            case R.id.nav_transaction_train :
//                mTextMessage.setText(R.string.title_cart);
                changeFragment(FRAGMENT_TRANSACTION_TRAIN);
                return true;

            case R.id.nav_transaction :
//                mTextMessage.setText(R.string.title_transaction);
                changeFragment(FRAGMENT_TRANSACTION);
                return true;

            case R.id.nav_favorite :
//                mTextMessage.setText(R.string.title_favorite);
                changeFragment(FRAGMENT_FAVORITE);
                return true;
        }
        return false;
    }

    @Override
    public void paymentCallback(int position) {
        switch (position) {
            case POS_FLIGHT :
            case POS_TRAIN :
                Intent intent = new Intent(this, TicketActivity.class);
                startActivity(intent);
        }
    }
}

