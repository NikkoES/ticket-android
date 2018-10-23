package com.roka.ticketing.bookticket;

import android.arch.persistence.room.util.StringUtil;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.roka.ticketing.BuildConfig;
import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter;
import com.roka.ticketing.bookticket.interfaces.BookTicketInterface;
import com.roka.ticketing.database.HistoryHelper;
import com.roka.ticketing.home.MainActivity;
import com.roka.ticketing.inputpassenger.InputPassengerActivity;
import com.roka.ticketing.repository.entity.AdultEntity;
import com.roka.ticketing.repository.entity.BaseEntity;
import com.roka.ticketing.repository.entity.ChildEntity;
import com.roka.ticketing.repository.entity.EmptyAdultEntity;
import com.roka.ticketing.repository.entity.EmptyChildEntity;
import com.roka.ticketing.repository.entity.EmptyInfantEntity;
import com.roka.ticketing.repository.entity.InfantEntity;
import com.roka.ticketing.repository.entity.PassengerEntity;
import com.roka.ticketing.repository.entity.TitleEntity;
import com.roka.ticketing.rest.payload.flight.BookFlightPayload;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.payload.helperpojo.AdultNames;
import com.roka.ticketing.rest.payload.helperpojo.InfantNames;
import com.roka.ticketing.rest.payload.helperpojo.Keys;
import com.roka.ticketing.rest.payload.train.Adult;
import com.roka.ticketing.rest.payload.train.BookingRail;
import com.roka.ticketing.rest.payload.train.DataCaller;
import com.roka.ticketing.rest.payload.train.DataPassenger;
import com.roka.ticketing.rest.payload.train.DataScheduleDepart;
import com.roka.ticketing.rest.payload.train.Infant;
import com.roka.ticketing.rest.payload.train.Schedule;
import com.roka.ticketing.rest.response.flight.BookFlightResponse;
import com.roka.ticketing.rest.response.train.BookResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;
import com.roka.ticketing.rest.services.RestTrainServices;
import com.roka.ticketing.utilities.Gb;
import com.roka.ticketing.utilities.StringUtilities;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_ADULT;
import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_CHILD;
import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_EMPTY_ADULT;
import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_EMPTY_CHILD;
import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_EMPTY_INFANT;
import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_INFANT;
import static com.roka.ticketing.bookticket.adapter.BookTicketPassengerAdapter.VIEW_TYPE_TITLE;
import static com.roka.ticketing.inputpassenger.InputPassengerActivity.EXTRA_NUMBER_ORDER;
import static com.roka.ticketing.inputpassenger.InputPassengerActivity.EXTRA_TYPE;
import static com.roka.ticketing.inputpassenger.InputPassengerActivity.TYPE_ADULT;
import static com.roka.ticketing.inputpassenger.InputPassengerActivity.TYPE_CHILD;
import static com.roka.ticketing.inputpassenger.InputPassengerActivity.TYPE_INFANT;

/**
 * Created by roka on 06/04/18.
 */

public class BookTicketActivity extends AppCompatActivity
        implements BookTicketInterface {
    @BindView(R.id.rv_bookticket_passenger)
    RecyclerView mRvPassenger;

    @BindView(R.id.btn_insert_booking)
    Button mBtnBooking;

    private BookTicketPassengerAdapter mAdapter;
    private SharedPreferences mPref;
    private Schedule mPayload, routeItem;
    private MaterialDialog mDialog;

    private List<BaseEntity> mData;
    private Gson gson = new Gson();
    private int numAdult;
    private int numChild;
    private int numInfant;
    private int numFilledAdult;
    private int numFilledChild;
    private int numFilledInfant;
    private String[] mSuffixes;
    private String[] mSuffixesChild;
    private RestCalls mServices, mServicesTrain;
    private int bookType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_ticket);
        ButterKnife.bind(this);

        mServices = RestServices.getService();
        mServicesTrain = RestTrainServices.getService();

        mPayload = (Schedule) getIntent().getSerializableExtra(Gb.INTENT_PAYLOAD_ITEM);
        routeItem = (Schedule) getIntent().getSerializableExtra(Gb.INTENT_FLIGHT_ROUTE_ITEM);
        bookType = getIntent().getIntExtra(Gb.INTENT_GENERAL_MODE, 0);

        if(bookType==0){
            mSuffixes = getResources().getStringArray(R.array.suffix);
        }
        else{
            mSuffixes = getResources().getStringArray(R.array.suffix_train);
        }
        mSuffixesChild = getResources().getStringArray(R.array.suffix_child);
        mPref = getSharedPreferences(Gb.PREF_NAME, MODE_PRIVATE);
        mData = new ArrayList<>();
        initRecyclerView();
    }

    @Override
    public void onInputPassengerCliked(int pos, int type) {
        switch (type) {
            case VIEW_TYPE_TITLE: {
                break;
            }
            case VIEW_TYPE_ADULT:
            case VIEW_TYPE_EMPTY_ADULT: {
                Intent intent = new Intent(this, InputPassengerActivity.class);
                intent.putExtra(Gb.INTENT_PAYLOAD_ITEM, mPayload);
                intent.putExtra(EXTRA_TYPE, TYPE_ADULT);
                intent.putExtra(EXTRA_NUMBER_ORDER, mData.get(pos).getNumOrder());
                startActivityForResult(intent, Gb.INPUT_PASSENGER_DATA);
                break;
            }
            case VIEW_TYPE_CHILD:
            case VIEW_TYPE_EMPTY_CHILD: {
                Intent intent = new Intent(this, InputPassengerActivity.class);
                intent.putExtra(Gb.INTENT_PAYLOAD_ITEM, mPayload);
                intent.putExtra(EXTRA_TYPE, TYPE_CHILD);
                intent.putExtra(EXTRA_NUMBER_ORDER, mData.get(pos).getNumOrder());
                startActivityForResult(intent, Gb.INPUT_PASSENGER_DATA);
                break;
            }
            case VIEW_TYPE_INFANT:
            case VIEW_TYPE_EMPTY_INFANT: {
                Intent intent = new Intent(this, InputPassengerActivity.class);
                intent.putExtra(Gb.INTENT_PAYLOAD_ITEM, mPayload);
                intent.putExtra(EXTRA_TYPE, TYPE_INFANT);
                intent.putExtra(EXTRA_NUMBER_ORDER, mData.get(pos).getNumOrder());
                startActivityForResult(intent, Gb.INPUT_PASSENGER_DATA);
                break;
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("ASDF", "RESULT " + requestCode);
        if (requestCode == Gb.INPUT_PASSENGER_DATA) {
            if (resultCode == RESULT_OK) {
                PassengerEntity passengerEntity = (PassengerEntity) data.getSerializableExtra(Gb.REQ_PASSENGER_DATA);

                SharedPreferences.Editor prefsEditor = mPref.edit();
                String json = gson.toJson(passengerEntity);

                if (passengerEntity instanceof AdultEntity) {
                    Log.d("faruk", "masuk adult "+passengerEntity.getNumOrder());
                    prefsEditor.putString(passengerEntity.getNumOrder() + "_ADULT", json);
                } else if (passengerEntity instanceof ChildEntity) {
                    Log.d("faruk", "masuk child "+passengerEntity.getNumOrder());
                    prefsEditor.putString(passengerEntity.getNumOrder() + "_CHILD", json);
                } else {
                    Log.d("faruk", "masuk infant "+passengerEntity.getNumOrder());
                    prefsEditor.putString(passengerEntity.getNumOrder() + "_INFANT", json);
                }
                prefsEditor.commit();
                initRecyclerView();
            }
        }

    }

    private void initRecyclerView() {
        numAdult = mPref.getInt(Gb.PREF_ADULT_NUM, 0);
        numChild = mPref.getInt(Gb.PREF_CHILD_NUM, 0);
        numInfant = mPref.getInt(Gb.PREF_INFANT_NUM, 0);

        mData.clear();
        numFilledAdult = 0;
        numFilledChild = 0;
        numFilledInfant = 0;
        if (numAdult > 0) {
            TitleEntity titleEntity = new TitleEntity();
            titleEntity.setTitle("Adult Passenger");
            mData.add(titleEntity);

            for (int i = 0; i < numAdult; i++) {
                String json = mPref.getString(i + "_ADULT", "");
                if (TextUtils.isEmpty(json)) {
                    EmptyAdultEntity item = new EmptyAdultEntity();
                    item.setNumOrder(i);
                    mData.add(item);
                } else {
                    numFilledAdult++;
                    AdultEntity adultPassenger = gson.fromJson(json, AdultEntity.class);
                    adultPassenger.setNumOrder(i);
                    mData.add(adultPassenger);
                }
            }
        }

        if (numChild > 0) {
            TitleEntity titleEntity = new TitleEntity();
            titleEntity.setTitle("Child Passenger");
            mData.add(titleEntity);

            for (int i = 0; i < numChild; i++) {
                String json = mPref.getString(i + "_CHILD", "");
                if (TextUtils.isEmpty(json)) {
                    EmptyChildEntity item = new EmptyChildEntity();
                    item.setNumOrder(i);
                    mData.add(item);
                } else {
                    numFilledChild++;
                    ChildEntity childPassenger = gson.fromJson(json, ChildEntity.class);
                    childPassenger.setNumOrder(i);
                    mData.add(childPassenger);
                }
            }
        }

        if (numInfant > 0) {
            TitleEntity titleEntity = new TitleEntity();
            titleEntity.setTitle("Infant Passenger");
            mData.add(titleEntity);

            for (int i = 0; i < numInfant; i++) {
                String json = mPref.getString(i + "_INFANT", "");
                if (TextUtils.isEmpty(json)) {
                    EmptyInfantEntity item = new EmptyInfantEntity();
                    item.setNumOrder(i);
                    mData.add(item);
                } else {
                    numFilledInfant++;
                    InfantEntity infantPassenger = gson.fromJson(json, InfantEntity.class);
                    infantPassenger.setNumOrder(i);
                    mData.add(infantPassenger);
                }
            }
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new BookTicketPassengerAdapter(mData, this);

        mRvPassenger.setLayoutManager(manager);
        mRvPassenger.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
    }


    @OnClick(R.id.btn_insert_booking)
    public void onInsertBooking() {

        if (numFilledAdult < numAdult) {
            Toast.makeText(this, "Data Penumpang Adult Tidak Lengkap!", Toast.LENGTH_SHORT).show();
        } else if (numFilledChild < numChild) {
            Toast.makeText(this, "Data Penumpang Child Tidak Lengkap!", Toast.LENGTH_SHORT).show();
        } else if (numFilledInfant < numInfant) {
            Toast.makeText(this, "Data Penumpang Infant Tidak Lengkap!", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(this, "Semua Data Penumpang Lengkap!", Toast.LENGTH_SHORT).show();

            mDialog = new MaterialDialog.Builder(this)
                    .content("Please Wait...")
                    .cancelable(false)
                    .build();

            mDialog.show();


            PassengerEntity pemesan = null;
            if (numAdult > 0) {
                String json = mPref.getString("0_ADULT", "");
                pemesan = gson.fromJson(json, AdultEntity.class);
                pemesan.setNumOrder(0);
            } else if (numChild > 0) {
                String json = mPref.getString("0_CHILD", "");
                pemesan = gson.fromJson(json, ChildEntity.class);
                pemesan.setNumOrder(0);
            }

            List<AdultNames> adultNameList = new ArrayList<>();
            List<Adult> listAdult = new ArrayList<>();
            if (numAdult > 0) {
                for (int i = 0; i < numAdult; i++) {
                    String json = mPref.getString(i + "_ADULT", "");
                    AdultEntity adultPassenger = gson.fromJson(json, AdultEntity.class);
                    adultPassenger.setNumOrder(i);

                    AdultNames adultNames = new AdultNames.Builder()
                            .withIdNo(adultPassenger.getIdentityNumber())
                            .withFirstName(adultPassenger.getFirstName())
                            .withLastName(adultPassenger.getLastName())
                            .withSuffix(mSuffixes[adultPassenger.getSuffix()])
                            .build();

                    adultNameList.add(adultNames);
                    listAdult.add(new Adult(adultPassenger.getIdentityNumber(), adultPassenger.getFirstName()));
                }
            }

            List<AdultNames> childNameList = new ArrayList<>();
            if (numChild > 0) {
                for (int i = 0; i < numChild; i++) {
                    String json = mPref.getString(i + "_ADULT", "");
                    ChildEntity childPassenger = gson.fromJson(json, ChildEntity.class);
                    childPassenger.setNumOrder(i);

                    AdultNames childNames = new AdultNames.Builder()
                            .withIdNo(childPassenger.getIdentityNumber())
                            .withFirstName(childPassenger.getFirstName())
                            .withLastName(childPassenger.getLastName())
                            .withSuffix(mSuffixesChild[childPassenger.getSuffix()])
                            .build();

                    childNameList.add(childNames);

                }
            }

            List<InfantNames> infantNameList = new ArrayList<>();
            List<Infant> listInfant = new ArrayList<>();
            if (numInfant > 0) {
                for (int i = 0; i < numInfant; i++) {
                    String json = mPref.getString(i + "_ADULT", "");
                    InfantEntity infantPassenger = gson.fromJson(json, InfantEntity.class);
                    infantPassenger.setNumOrder(i);

                    InfantNames infantNames = new InfantNames.Builder()
                            .withFirstName(infantPassenger.getFirstName())
                            .withLastName(infantPassenger.getLastName())
                            .withAdultRefference((pemesan.getNumOrder()+1) + "")
                            .build();

                    infantNameList.add(infantNames);
                    listInfant.add(new Infant(infantPassenger.getFirstName()));

                }
            }


            List<Keys> keysList = new ArrayList<>();
            keysList.add(new Keys.Builder().withKey(mPref.getString(Gb.PREF_CLASS_KEY, ""))
                    .withCategory("Departure").build());

            if (pemesan != null) {
                switch (bookType){
                    case 0 : {
                        BookFlightPayload payload = new BookFlightPayload.Builder()
                                .withEmail(pemesan.getEmail())
                                .withReceivedPhone(pemesan.getPhoneNumber())
                                .withSearchKey(mPref.getString(Gb.PREF_SEARCH_KEY, ""))
                                .withAdultNames(adultNameList)
                                .withChildNames(childNameList)
                                .withInfantNames(infantNameList)
                                .withKeys(keysList)
                                .build();

                        Call<BookFlightResponse> call = mServices.bookFlight(payload);
                        call.enqueue(new Callback<BookFlightResponse>() {
                            @Override
                            public void onResponse(Call<BookFlightResponse> call, Response<BookFlightResponse> response) {
                                if (response.isSuccessful()) {
                                    String bookingCode = response.body().getReturn().getBookingCode().getvalue();
                                    mDialog.hide();
                                    Intent intent = new Intent(BookTicketActivity.this, MainActivity.class);
                                    intent.putExtra(MainActivity.EXTRA_ACTIVE_FRAGMENT, MainActivity.FRAGMENT_TRANSACTION);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onFailure(Call<BookFlightResponse> call, Throwable t) {
                                Log.d("http", "" + t.toString());
                                mDialog.hide();
                            }
                        });
                        break;
                    }
                    case 1 : {
                        Log.e("DEPDATE", ""+mPayload.getDep_datetime());
                        Log.e("DEPDATE", ""+StringUtilities.dateResponseToDate(mPayload.getDep_datetime(), "dd-MMM-yyyy", "yyyymmdd"));
                        BookingRail payload = new BookingRail.Builder()
                                .withDataScheduleDepart(new DataScheduleDepart(StringUtilities.dateResponseToDate(mPayload.getDep_datetime(), "dd-MMM-yyyy", "yyyyMMdd"), mPayload.getDes(), mPayload.getOrg(), routeItem.getSubclass(), routeItem.getTransporter_no()))
                                .withDataCaller(new DataCaller(pemesan.getFirstName(), pemesan.getPhoneNumber(), mSuffixes[pemesan.getSuffix()]))
                                .withDataPassenger(new DataPassenger(listAdult, listInfant))
                                .withAdultNames(listAdult)
                                .withChildNames(listInfant)
                                .withToken(BuildConfig.API_TRAIN_TOKEN)
                                .build();

                        Call<BookResponse> call = mServicesTrain.bookingRail(payload);
                        call.enqueue(new Callback<BookResponse>() {
                            @Override
                            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                                if (response.isSuccessful()) {
                                    String bookingCode = response.body().getResult().getGdsBookCode();
                                    mDialog.hide();
                                    Intent intent = new Intent(BookTicketActivity.this, MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                                    HistoryHelper helper = new HistoryHelper(getApplicationContext());
                                    helper.open();
                                    helper.insert(bookingCode, response.toString());
                                    helper.close();

                                    intent.putExtra(Gb.GDS_BOOK_CODE, bookingCode);
                                    intent.putExtra(MainActivity.EXTRA_ACTIVE_FRAGMENT, MainActivity.FRAGMENT_TRANSACTION_TRAIN);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onFailure(Call<BookResponse> call, Throwable t) {
                                Log.d("http", "" + t.toString());
                                mDialog.hide();
                            }
                        });
                        break;
                    }
                }

            } else {
                Toast.makeText(this, "Minimal Harus Ada Penumpang Dewasa/Anak", Toast.LENGTH_SHORT).show();
                mDialog.hide();
            }
        }
    }
}
