package com.roka.ticketing.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mikepenz.iconics.IconicsDrawable;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnRangeSelectedListener;
import com.roka.ticketing.R;
import com.roka.ticketing.utilities.ConvertionUtil;
import com.roka.ticketing.utilities.Gb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roka on 16/03/18.
 */

public class CalendarActivity extends AppCompatActivity
        implements OnRangeSelectedListener, OnDateSelectedListener {
    @BindView(R.id.mcv_calendar)
    MaterialCalendarView mMcvCalendar;

    private boolean mIsRange = false;
    private ArrayList<String> mData = null;
    private String mSingleData = null;
    private String mTitleString = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_view);
        ButterKnife.bind(this);

        mData = new ArrayList<>();

        initCalendar();
        initActionBar();
    }

    private void initActionBar() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initCalendar() {
        mIsRange = getIntent().getBooleanExtra(Gb.INTENT_IS_RANGE_SELECTION,
                false);

        mTitleString = getIntent().getStringExtra(Gb.INTENT_TITLE);
        if(mIsRange) mMcvCalendar.setSelectionMode(MaterialCalendarView.SELECTION_MODE_RANGE);
        else mMcvCalendar.setSelectionMode(MaterialCalendarView.SELECTION_MODE_SINGLE);

        mMcvCalendar.state().edit()
                .setMinimumDate(new Date())
                .commit();

        mMcvCalendar.setOnRangeSelectedListener(this);
        mMcvCalendar.setOnDateChangedListener(this);

        getSupportActionBar().setTitle(mTitleString);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calendar, menu);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mIsRange) {
            if(mData.size() == 0) {
                menu.findItem(R.id.calendar_select_date).setIcon(
                        new IconicsDrawable(this)
                                .icon("gmd-check")
                                .color(getResources().getColor(R.color.gray))
                                .sizeDp(18));
                menu.findItem(R.id.calendar_select_date).setEnabled(false);
            } else {
                menu.findItem(R.id.calendar_select_date).setIcon(
                        new IconicsDrawable(this)
                                .icon("gmd-check")
                                .color(getResources().getColor(R.color.white))
                                .sizeDp(18));
                menu.findItem(R.id.calendar_select_date).setEnabled(true);
            }
        } else {
            if(mSingleData == null) {
                menu.findItem(R.id.calendar_select_date).setIcon(
                        new IconicsDrawable(this)
                                .icon("gmd-check")
                                .color(getResources().getColor(R.color.gray))
                                .sizeDp(18));
                menu.findItem(R.id.calendar_select_date).setEnabled(false);
            } else {
                menu.findItem(R.id.calendar_select_date).setIcon(
                        new IconicsDrawable(this)
                                .icon("gmd-check")
                                .color(getResources().getColor(R.color.white))
                                .sizeDp(18));
                menu.findItem(R.id.calendar_select_date).setEnabled(true);

            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                finish();
                return true;

            case R.id.calendar_select_date :
                setActivityResult();
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setActivityResult() {
        Intent intent = new Intent();
        if(mIsRange) {
            intent.putStringArrayListExtra(Gb.REQ_CALENDAR_RESULT,
                    mData);
        }
        else{
            intent.putExtra(Gb.REQ_CALENDAR_RESULT, mSingleData);
        }

        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onRangeSelected(@NonNull MaterialCalendarView widget, @NonNull List<CalendarDay> dates) {
        mData.clear();
        for(CalendarDay date : dates) {
            Log.d("DATE", ConvertionUtil.toGeneralString(date.getDate()));
            mData.add(ConvertionUtil.toGeneralString(date.getDate()));
        }

        invalidateOptionsMenu();
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
        mSingleData = ConvertionUtil.toGeneralString(date.getDate());

        if(!selected) {
            mData.clear();
            mSingleData = null;
        }
        invalidateOptionsMenu();
    }
}