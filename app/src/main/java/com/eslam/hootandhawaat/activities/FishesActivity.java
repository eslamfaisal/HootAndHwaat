package com.eslam.hootandhawaat.activities;

import android.os.Bundle;
import android.util.Log;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.models.FishesTypeResponse;
import com.eslam.hootandhawaat.network.RetrofitClient;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FishesActivity extends AppCompatActivity {

    private final String TAG = "EslamFaisal";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishes);

        getFishesType();


    }

    private void getFishesType(){

        RetrofitClient.getInstance().getApi().getFishesType().enqueue(new Callback<FishesTypeResponse>() {
            @Override
            public void onResponse(Call<FishesTypeResponse> call, Response<FishesTypeResponse> response) {
                if (response.code()==200){
                    Log.d(TAG, "onResponse: "+response.body().toString());
                    Log.d(TAG, "onResponse: "+response.body().getCode());
                    Log.d(TAG, "onResponse: "+response.body().getTypes().get(0).getFName());
                }else if (response.code()==404){
                    Log.d(TAG, "onResponse: error"+response.message());
                }

            }

            @Override
            public void onFailure(Call<FishesTypeResponse> call, Throwable t) {

                Log.e(TAG, "onFailure: ",t );

            }
        });
    }
}
