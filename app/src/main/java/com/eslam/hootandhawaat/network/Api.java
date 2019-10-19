package com.eslam.hootandhawaat.network;

import com.eslam.hootandhawaat.models.CityResponse;
import com.eslam.hootandhawaat.models.FishesTypeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("api/cities/all")
    Call<List<CityResponse>> getCities();

    @GET("api/get/types")
    Call<FishesTypeResponse> getFishesType();

}
