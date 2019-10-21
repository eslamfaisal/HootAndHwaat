package com.eslam.hootandhawaat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.adapter.FishesAdsAdapter;
import com.eslam.hootandhawaat.adapter.FishesTypesAdapter;
import com.eslam.hootandhawaat.models.FishesTypeResponse;
import com.eslam.hootandhawaat.network.RetrofitClient;
import com.eslam.hootandhawaat.utility.PaginationScrollListener;
import com.john.waveview.WaveView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FishesActivity extends AppCompatActivity implements FishesTypesAdapter.FisheTypeListener {

    private final String TAG = "EslamFaisal";
    @BindView(R.id.fishes_recyclerview)
    RecyclerView fishesRecyclerView;
    @BindView(R.id.fishes_types_recycler_view)
    RecyclerView fishesTypesRecyclerView;
    @BindView(R.id.wave_view)
    WaveView progress;
    @BindView(R.id.empty_orders)
    TextView noOrders;
    @BindView(R.id.typesProgress)
    ProgressBar typesProgress;

    private FishesAdsAdapter fishesAdsAdapter;
    private LinearLayoutManager fishesLinearLayoutManager;
    private FishesTypesAdapter fishesTypesAdapter;
    private LinearLayoutManager typesLinearLayoutManager;

    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int PAGE_START = 1;
    private int TOTAL_PAGES;
    private int currentPage = PAGE_START;

    private String CITY_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishes);
        ButterKnife.bind(this);

        setTitle("Fishes Ads");

        Intent intent = getIntent();
        CITY_ID = intent.getStringExtra("city_id");

        initRecyclerView();
        getFishesType();

    }

    private void getFishesType() {
        typesProgress.setVisibility(View.VISIBLE);
        RetrofitClient.getInstance().getApi().getFishesType().enqueue(new Callback<FishesTypeResponse>() {
            @Override
            public void onResponse(Call<FishesTypeResponse> call, Response<FishesTypeResponse> response) {
                typesProgress.setVisibility(View.GONE);
                if (response.code() == 200) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    fishesTypesAdapter.addAll(response.body().getTypes());
                } else if (response.code() == 404) {
                    Log.d(TAG, "onResponse: error" + response.message());
                }

            }

            @Override
            public void onFailure(Call<FishesTypeResponse> call, Throwable t) {
                typesProgress.setVisibility(View.GONE);
                Log.e(TAG, "onFailure: ", t);

            }
        });
    }

    private void initRecyclerView() {
        fishesTypesAdapter = new FishesTypesAdapter(new ArrayList<>(), this, this);
        typesLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        fishesTypesRecyclerView.setLayoutManager(typesLinearLayoutManager);
        fishesTypesRecyclerView.setAdapter(fishesTypesAdapter);

        fishesAdsAdapter = new FishesAdsAdapter(new ArrayList<>(), this);
        fishesLinearLayoutManager = new LinearLayoutManager(this);
        fishesRecyclerView.setLayoutManager(fishesLinearLayoutManager);
        fishesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        fishesRecyclerView.setAdapter(fishesAdsAdapter);
        fishesRecyclerView.addOnScrollListener(new PaginationScrollListener(fishesLinearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage += 1;


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
    }

    @Override
    public void searchForType(FishesTypeResponse.Type fishType) {

    }
}
