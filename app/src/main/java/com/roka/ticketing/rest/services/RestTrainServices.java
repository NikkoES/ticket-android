package com.roka.ticketing.rest.services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by roka on 15/03/18.
 */

public class RestTrainServices {
    private static Retrofit retrofit = null;
    private static final String baseUrl = "http://ws.demo.gds.medit.sqiva.com/";

    public static RestCalls getService() {
        if(retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(540, TimeUnit.SECONDS)
                    .writeTimeout(540, TimeUnit.SECONDS)
                    .readTimeout(540, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(RestCalls.class);
        }

        else return retrofit.create(RestCalls.class);
    }
}
