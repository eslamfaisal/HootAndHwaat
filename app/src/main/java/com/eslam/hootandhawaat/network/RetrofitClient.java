package com.eslam.hootandhawaat.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    public static final String BASE_URL = "http://howt.feckrah.com/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient() {
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(logging);

        Interceptor authorization = chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .build();

            return chain.proceed(newRequest);

        };

        httpClientBuilder.addInterceptor(authorization);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClientBuilder.build())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (mInstance == null) {
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi() {
        return retrofit.create(Api.class);
    }

}
