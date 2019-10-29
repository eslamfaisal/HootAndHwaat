package com.eslam.hootandhawaat.network;

import com.eslam.hootandhawaat.models.CityResponse;
import com.eslam.hootandhawaat.models.FishesAdsResponse;
import com.eslam.hootandhawaat.models.FishesTypeResponse;
import com.eslam.hootandhawaat.models.FishesTripsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("api/cities/all")
    Call<List<CityResponse>> getCities();

    @GET("api/get/types")
    Call<FishesTypeResponse> getFishesType();

    @GET("api/fishes/get_using_type/type_id={type_id}&city_id={city_id}&page={page}")
    Call<FishesAdsResponse> getFisheAds(
            @Path("type_id") String type_id,
            @Path("city_id") String city_id,
            @Path("page") String page
    );

    @GET("api/get/trips/for/marasi_id={marasi_id}&beach={beach}&city_id={city_id}&page={page}")
    Call<FishesTripsResponse> getTrips(
            @Path("marasi_id") String marasi_id,
            @Path("beach") String beach,
            @Path("city_id") String city_id,
            @Path("page") int page
    );

}
