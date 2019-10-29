package com.eslam.hootandhawaat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.adapter.TripsAdapter;
import com.eslam.hootandhawaat.models.FishesTripsResponse;
import com.eslam.hootandhawaat.network.RetrofitClient;
import com.eslam.hootandhawaat.utility.PaginationScrollListener;
import com.john.waveview.WaveView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TripsActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.fishes_recyclerview)
    RecyclerView fishesRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.sbeed)
    TextView sbeetBot;
    @BindView(R.id.yakht)
    TextView yakht;
    @BindView(R.id.qarb)
    TextView qarb;
    @BindView(R.id.dbab)
    TextView dbab;
    @BindView(R.id.marsa_motawast)
    TextView marsa_motawast;
    @BindView(R.id.marsa_ahmer)
    TextView marsa_ahmer;
    @BindView(R.id.wave_view)
    WaveView progress;
    @BindView(R.id.empty_orders)
    TextView noOrders;

    private List<FishesTripsResponse.Datum> fishList;
    private TripsAdapter adapter;
    private LinearLayoutManager fishesLinearLayoutManager;

    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES;
    private int PAGE_START = 1;
    private int currentPage = PAGE_START;

    private String marasiID = "1";
    private String boatId = "1";

    private String CITY_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trips);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        CITY_ID = intent.getStringExtra("city_id");

        initToolBar();
        initRecycler();
        setListeners();

        getFirstAll();

    }

    private void setListeners() {

        qarb.setOnClickListener(this);
        sbeetBot.setOnClickListener(this);
        yakht.setOnClickListener(this);
        marsa_ahmer.setOnClickListener(this);
        marsa_motawast.setOnClickListener(this);
        dbab.setOnClickListener(this);
    }

    private void initRecycler() {
        fishList = new ArrayList<>();
        adapter = new TripsAdapter(fishList, this);
        fishesLinearLayoutManager = new LinearLayoutManager(this);
        fishesRecyclerView.setLayoutManager(fishesLinearLayoutManager);
        fishesRecyclerView.setItemAnimator(new DefaultItemAnimator());

        fishesRecyclerView.setAdapter(adapter);
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

    }

    private void getFirstAll() {
        currentPage = PAGE_START;
        isLoading = false;
        isLastPage = false;

        progress.setVisibility(View.VISIBLE);
        noOrders.setVisibility(View.GONE);
        adapter.clear();

        RetrofitClient.getInstance()
                .getApi()
                .getTrips(marasiID, boatId, CITY_ID, currentPage)
                .enqueue(new Callback<FishesTripsResponse>() {
                    @Override
                    public void onResponse(Call<FishesTripsResponse> call, Response<FishesTripsResponse> response) {
                        if (response.body() != null && response.body().getData().size() >= 1) {
                            TOTAL_PAGES = response.body().getLastPage();
                            if (response.body() != null) {
                                FishesTripsResponse fishAd = response.body();
                                adapter.addAll(fishAd.getData());
                            }


                            if (currentPage != TOTAL_PAGES) adapter.addLoadingFooter();
                            else isLastPage = true;

                            fishesRecyclerView.addOnScrollListener(new PaginationScrollListener(fishesLinearLayoutManager) {
                                @Override
                                protected void loadMoreItems() {
                                    isLoading = true;
                                    currentPage += 1;

                                    loadNextTrips();
                                }

                                @Override
                                public int getTotalPageCount() {
                                    return TOTAL_PAGES;
                                }

                                @Override
                                public boolean isLastPage() {
                                    return isLastPage;
                                }

                                @Override
                                public boolean isLoading() {
                                    return isLoading;
                                }
                            });
                        } else {
                            noOrders.setVisibility(View.VISIBLE);
                        }
                        progress.setVisibility(View.GONE);

                    }

                    @Override
                    public void onFailure(Call<FishesTripsResponse> call, Throwable t) {
                        noOrders.setVisibility(View.VISIBLE);
                        progress.setVisibility(View.GONE);
                    }
                });
    }

    private void loadNextTrips() {
        RetrofitClient.getInstance()
                .getApi()
                .getTrips(marasiID, boatId, CITY_ID, currentPage)
                .enqueue(new Callback<FishesTripsResponse>() {
                    @Override
                    public void onResponse(Call<FishesTripsResponse> call, Response<FishesTripsResponse> response) {

                        adapter.removeLoadingFooter();
                        isLoading = false;

                        if (response.body() != null) {
                            FishesTripsResponse fishAd = response.body();
                            adapter.addAll(fishAd.getData());
                        }

                        if (currentPage != TOTAL_PAGES) adapter.addLoadingFooter();
                        else isLastPage = true;

                    }

                    @Override
                    public void onFailure(Call<FishesTripsResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.marsa_motawast) {
            marasiID = "1";
            selectMotawast();
            getFirstAll();
        } else if (id == R.id.marsa_ahmer) {
            marasiID = "2";
            selectAhmer();
            getFirstAll();
        } else if (id == R.id.dbab) {
            boatId = "3";
            selectDbab();
            getFirstAll();
        } else if (id == R.id.sbeed) {
            boatId = "1";
            selectSebbd();
            getFirstAll();
        } else if (id == R.id.qarb) {
            boatId = "2";
            selectQarb();
            getFirstAll();
        } else if (id == R.id.yakht) {
            boatId = "4";
            selectYakht();
            getFirstAll();
        }
    }


    void selectDbab() {
        dbab.setBackgroundColor(getResources().getColor(R.color.orange));
        yakht.setBackgroundColor(getResources().getColor(R.color.white));
        qarb.setBackgroundColor(getResources().getColor(R.color.white));
        sbeetBot.setBackgroundColor(getResources().getColor(R.color.white));
    }

    void selectYakht() {
        dbab.setBackgroundColor(getResources().getColor(R.color.white));
        yakht.setBackgroundColor(getResources().getColor(R.color.orange));
        qarb.setBackgroundColor(getResources().getColor(R.color.white));
        sbeetBot.setBackgroundColor(getResources().getColor(R.color.white));
    }

    void selectQarb() {
        dbab.setBackgroundColor(getResources().getColor(R.color.white));
        yakht.setBackgroundColor(getResources().getColor(R.color.white));
        qarb.setBackgroundColor(getResources().getColor(R.color.orange));
        sbeetBot.setBackgroundColor(getResources().getColor(R.color.white));
    }

    void selectSebbd() {
        dbab.setBackgroundColor(getResources().getColor(R.color.white));
        yakht.setBackgroundColor(getResources().getColor(R.color.white));
        qarb.setBackgroundColor(getResources().getColor(R.color.white));
        sbeetBot.setBackgroundColor(getResources().getColor(R.color.orange));
    }

    void selectMotawast() {
        marsa_motawast.setBackgroundColor(getResources().getColor(R.color.orange));
        marsa_ahmer.setBackgroundColor(getResources().getColor(R.color.white));
    }

    void selectAhmer() {
        marsa_motawast.setBackgroundColor(getResources().getColor(R.color.white));
        marsa_ahmer.setBackgroundColor(getResources().getColor(R.color.orange));
    }

}

