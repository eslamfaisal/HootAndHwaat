package com.eslam.hootandhawaat.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.models.CityResponse;
import com.eslam.hootandhawaat.network.RetrofitClient;
import com.john.waveview.WaveView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private final String TAG = "EslamFaisal";

    @BindView(R.id.wave_view)
    WaveView loading;

    @BindView(R.id.cities_spinner)
    Spinner citiesSpinner;
    ArrayAdapter<String> citiesSpinnerAdapter;

    List<String> citiesNames = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        getCities();
    }


    private void getCities() {
        loading.setVisibility(View.VISIBLE);
        RetrofitClient.getInstance().getApi()
                .getCities().enqueue(new Callback<List<CityResponse>>() {
            @Override
            public void onResponse(Call<List<CityResponse>> call,
                                   Response<List<CityResponse>> response) {
                loading.setVisibility(View.GONE);
                Log.d(TAG, "onResponse: " + response.body().toString());
                initCitiesSpinner(response.body());
            }

            @Override
            public void onFailure(Call<List<CityResponse>> call, Throwable t) {
                loading.setVisibility(View.GONE);
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }


    private void initCitiesSpinner(List<CityResponse> cityResponseList) {
        for (CityResponse cityResponse : cityResponseList){
            citiesNames.add(cityResponse.getCName());
        }
        citiesSpinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,citiesNames);
        citiesSpinner.setAdapter(citiesSpinnerAdapter);
    }
}
