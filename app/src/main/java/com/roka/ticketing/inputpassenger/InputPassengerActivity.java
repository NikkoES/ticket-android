package com.roka.ticketing.inputpassenger;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.roka.ticketing.R;
import com.roka.ticketing.bookticket.BookTicketActivity;
import com.roka.ticketing.home.MainActivity;
import com.roka.ticketing.inputpassenger.adapter.PassengerAdapter;
import com.roka.ticketing.inputpassenger.interfaces.InputPassengerInterface;
import com.roka.ticketing.repository.entity.AdultEntity;
import com.roka.ticketing.repository.entity.ChildEntity;
import com.roka.ticketing.repository.entity.InfantEntity;
import com.roka.ticketing.repository.entity.PassengerEntity;
import com.roka.ticketing.repository.viewmodel.PassengerViewModel;
import com.roka.ticketing.rest.payload.IssuingPayload;
import com.roka.ticketing.rest.payload.flight.SearchFlightPayload;
import com.roka.ticketing.rest.response.flight.IssuingResponse;
import com.roka.ticketing.rest.services.RestCalls;
import com.roka.ticketing.rest.services.RestServices;
import com.roka.ticketing.utilities.Gb;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by roka on 24/03/18.
 */

public class InputPassengerActivity extends AppCompatActivity implements TextWatcher,
        AdapterView.OnItemSelectedListener,
        Observer<List<PassengerEntity>>,
        InputPassengerInterface {
    @BindView(R.id.et_bookflight_email)
    EditText mEtEmail;

    @BindView(R.id.et_bookflight_phone)
    EditText mEtPhone;

    @BindView(R.id.et_bookflight_identity)
    EditText mEtIdentity;

    @BindView(R.id.et_bookflight_name)
    EditText mEtName;

    @BindView(R.id.et_bookflight_last_name)
    EditText mEtLastName;

    @BindView(R.id.btn_bookflight_book)
    Button mBtnBook;

    @BindView(R.id.sp_bookflight_suffix)
    AppCompatSpinner mSpSuffix;

    @BindView(R.id.rv_passenger)
    RecyclerView mRvPassenger;

    @BindView(R.id.ll_passenger)
    LinearLayout mLlPassenger;

    @BindView(R.id.ll_input_identity)
    LinearLayout mLlInputIdentity;

    @BindView(R.id.ll_input_email)
    LinearLayout mLlInputEmail;

    @BindView(R.id.ll_input_phone)
    LinearLayout mLlInputPhone;

    @BindView(R.id.ll_input_suffix)
    LinearLayout mLlInputSuffix;


    private RestCalls mServices = null;
    private MaterialDialog mDialog;
    private String[] mSuffixes;
    private int mSuffix;
    private PassengerAdapter mPassengerAdapter;
    private ArrayAdapter<String> mAdapter = null;
    private List<PassengerEntity> mData;

    private PassengerViewModel mPassengerVM;

    SharedPreferences mPref;
//    private SearchFlightPayload mPayload;
    private int mType;
    private int mNumOrder;

    private final String TAG = InputPassengerActivity.this.getClass().getSimpleName();

    public static final String EXTRA_TYPE = "type";
    public static final String EXTRA_NUMBER_ORDER = "order";

    public static final int TYPE_ADULT = 1;
    public static final int TYPE_CHILD = 2;
    public static final int TYPE_INFANT = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_input_passenger);
        ButterKnife.bind(this);

        mServices = RestServices.getService();
        mPref = getSharedPreferences(Gb.PREF_NAME, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);

//        mPayload = (SearchFlightPayload) getIntent().getSerializableExtra(Gb.INTENT_PAYLOAD_ITEM);
        mType = getIntent().getIntExtra(EXTRA_TYPE, 1);
        mNumOrder = getIntent().getIntExtra(EXTRA_NUMBER_ORDER, 0);

        if (mType != TYPE_ADULT) {
            mLlInputEmail.setVisibility(View.INVISIBLE);
            mLlInputIdentity.setVisibility(View.INVISIBLE);
            mLlInputPhone.setVisibility(View.INVISIBLE);
            if (mType == TYPE_INFANT)
                mLlInputSuffix.setVisibility(View.INVISIBLE);
        }


        mEtPhone.addTextChangedListener(this);
        mEtLastName.addTextChangedListener(this);
        mEtEmail.addTextChangedListener(this);
        mEtIdentity.addTextChangedListener(this);
        mEtName.addTextChangedListener(this);

        initSpinner();
        initActionBar();
        initViewModel();
        initRecyclerView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initViewModel() {
        mPassengerVM = ViewModelProviders.of(this).get(PassengerViewModel.class);

        mPassengerVM.getAllPassengers().observe(this, this);
    }

    private void initSpinner() {
        if (mType == TYPE_ADULT)
            mSuffixes = getResources().getStringArray(R.array.suffix);
        else
            mSuffixes = getResources().getStringArray(R.array.suffix_child);

        mSuffix = 0;

        mAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mSuffixes);
        mSpSuffix.setAdapter(mAdapter);
        mSpSuffix.setOnItemSelectedListener(this);
    }

    private void initActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initRecyclerView() {
        mData = new ArrayList<>();

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mPassengerAdapter = new PassengerAdapter(mData, this);

        mRvPassenger.setAdapter(mPassengerAdapter);
        mRvPassenger.setLayoutManager(manager);
    }

    private boolean validateForm() {
        if (mType == TYPE_ADULT) {
            if (mEtName.getText().toString() == null || mEtName.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "FirstName Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (mEtEmail.getText().toString() == null || mEtEmail.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "Email Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (mEtIdentity.getText().toString() == null || mEtIdentity.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "Nomer Identitas Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (mEtLastName.getText().toString() == null || mEtLastName.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "LastName Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (mEtPhone.getText().toString() == null || mEtPhone.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "Phone Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            if (mEtName.getText().toString() == null || mEtName.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "FirstName Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (mEtLastName.getText().toString() == null || mEtLastName.getText().toString().length() == 0) {
                Toast.makeText(InputPassengerActivity.this, "LastName Harus diisi!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private void issueTicket(final String bookingCode) {
        IssuingPayload payload = new IssuingPayload(bookingCode);
        Call<IssuingResponse> call = mServices.issueFlight(payload);
        call.enqueue(new Callback<IssuingResponse>() {
            @Override
            public void onResponse(Call<IssuingResponse> call, Response<IssuingResponse> response) {
                mDialog.hide();
                Toast.makeText(InputPassengerActivity.this, "Issue Ticket Successful : " + bookingCode,
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(InputPassengerActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<IssuingResponse> call, Throwable t) {
                Log.d("ASDF", "" + t.toString());
            }
        });
    }

    /*
    @OnClick(R.id.btn_bookflight_book)
    public void onBookFlight() {
        mDialog = new MaterialDialog.Builder(this)
                .content("Please Wait...")
                .cancelable(false)
                .build();

        mDialog.show();
        AdultNames adultNames = new AdultNames.Builder()
                .withIdNo(mEtIdentity.getText().toString())
                .withFirstName(mEtName.getText().toString())
                .withLastName(mEtLastName.getText().toString())
                .withSuffix(mSuffix)
                .build();

        List<AdultNames> adultNameList = new ArrayList<>();
        adultNameList.add(adultNames);

        List<Keys> keysList = new ArrayList<>();
        keysList.add(new Keys.Builder().withKey(mPref.getString(Gb.PREF_CLASS_KEY, "")).withCategory("Departure").build());

        BookFlightPayload payload = new BookFlightPayload.Builder()
                .withEmail(mEtEmail.getText().toString())
                .withReceivedPhone(mEtPhone.getText().toString())
                .withSearchKey(mPref.getString(Gb.PREF_SEARCH_KEY, ""))
                .withAdultNames(adultNameList)
                .withKeys(keysList)
                .build();

        Call<BookFlightResponse> call = mServices.bookFlight(payload);
        call.enqueue(new Callback<BookFlightResponse>() {
            @Override
            public void onResponse(Call<BookFlightResponse> call, Response<BookFlightResponse> response) {
                if(response.isSuccessful()) {
                    String bookingCode = response.body().getReturn().getBookingCode().getvalue();
//                    issueTicket(bookingCode);
                    mDialog.hide();
                    Toast.makeText(InputPassengerActivity.this, "Issue Ticket Successful : "+bookingCode,
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(InputPassengerActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<BookFlightResponse> call, Throwable t) {
                Log.d("ASDF", "" + t.toString());
            }
        });
    } */

    @OnClick(R.id.btn_bookflight_book)
    public void onBookFlight() {
        if (validateForm()) {
            PassengerEntity passenger = new PassengerEntity();
            passenger.setEmail(mEtEmail.getText().toString());
            passenger.setIdentityNumber(mEtIdentity.getText().toString());
            passenger.setFirstName(mEtName.getText().toString());
            passenger.setLastName(mEtLastName.getText().toString());
            passenger.setPhoneNumber(mEtPhone.getText().toString());
            passenger.setSuffix(mSuffix);
            passenger.setNumOrder(mNumOrder);

            mPassengerVM.insertPassenger(passenger);

            Intent intent = new Intent(this, BookTicketActivity.class);

            switch (mType) {
                case TYPE_ADULT: {
                    AdultEntity entity = AdultEntity.copyFrom(passenger);
                    intent.putExtra(Gb.REQ_PASSENGER_DATA, entity);
                    break;
                }
                case TYPE_CHILD: {
                    ChildEntity entity = ChildEntity.copyFrom(passenger);
                    intent.putExtra(Gb.REQ_PASSENGER_DATA, entity);
                    break;
                }
                case TYPE_INFANT: {
                    InfantEntity entity = InfantEntity.copyFrom(passenger);
                    intent.putExtra(Gb.REQ_PASSENGER_DATA, entity);
                    break;
                }
            }

            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        //validateForm();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSuffix = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onChanged(@Nullable List<PassengerEntity> passengerEntities) {
        if (passengerEntities.size() > 0) mLlPassenger.setVisibility(View.VISIBLE);
        else mLlPassenger.setVisibility(View.GONE);

        mData.clear();
        mData.addAll(passengerEntities);
        mPassengerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPassengerSelected(PassengerEntity passenger) {
        Log.d(TAG, "interface");
        passenger.setNumOrder(mNumOrder);
        Intent intent = new Intent(this, BookTicketActivity.class);

        switch (mType) {
            case TYPE_ADULT: {
                AdultEntity entity = AdultEntity.copyFrom(passenger);
                intent.putExtra(Gb.REQ_PASSENGER_DATA, entity);
                break;
            }
            case TYPE_CHILD: {
                ChildEntity entity = ChildEntity.copyFrom(passenger);
                if (entity.getSuffix() > 1) {
                    //jika MS, ganti MISS
                    entity.setSuffix(1);
                }
                intent.putExtra(Gb.REQ_PASSENGER_DATA, entity);
                break;
            }
            case TYPE_INFANT: {
                InfantEntity entity = InfantEntity.copyFrom(passenger);
                intent.putExtra(Gb.REQ_PASSENGER_DATA, entity);
                break;
            }
        }


        setResult(RESULT_OK, intent);
        finish();
    }
}
