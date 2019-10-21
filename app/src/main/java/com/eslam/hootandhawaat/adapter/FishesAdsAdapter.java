package com.eslam.hootandhawaat.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.models.FishesAdsResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FishesAdsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // View Types
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    List<FishesAdsResponse> fishList;
    Activity context;
    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    public FishesAdsAdapter(List<FishesAdsResponse> fishList, Activity context) {
        this.fishList = fishList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.layout_fishe_ad_item, parent, false);
                viewHolder = new FishViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.layout_item_progress, parent, false);
                viewHolder = new LoadingVH(viewLoading);
                break;

        }
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int position) {
        final FishesAdsResponse fish = fishList.get(position);

        switch (getItemViewType(position)) {

            case ITEM:
                final FishViewHolder holder = (FishViewHolder) viewHolder;

//                holder.price.setText(fish.getF_price() + context.getString(R.string.SR));
//                holder.img.setImageURI(fish.getF_image());
//                holder.name.setText(fish.getF_name());
//
//                if (Integer.parseInt(fish.getF_delevary()) == 1) {
//                    holder.delivery.setText(context.getString(R.string.available_delivery));
//
//                } else {
//                    holder.delivery.setVisibility(View.GONE);
//                }
//
//                if (Integer.valueOf(fish.getF_cooking()) == 1) {
//                    holder.readyToEat.setText(context.getString(R.string.available_cooking));
//
//                } else {
//                    holder.readyToEat.setVisibility(View.GONE);
//                }
//
//                holder.quantity.setText(fish.getF_quantity() + " "+context.getString(R.string.km));
//                holder.mainView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        holder.detailsView.setVisibility(View.VISIBLE);
//                    }
//                });
//
//

                break;

            case LOADING:
                LoadingVH loadingVH = (LoadingVH) viewHolder;


                break;
        }

    }

    public void clear() {
        if (fishList != null)
            fishList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return fishList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return (position == fishList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        fishList.add(new FishesAdsResponse());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = fishList.size() - 1;
        FishesAdsResponse result = getItem(position);

        if (result != null) {
            fishList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public FishesAdsResponse getItem(int position) {
        return fishList.get(position);
    }

    public void addAll(List<FishesAdsResponse> newfishList) {
        fishList.addAll(newfishList);
        notifyDataSetChanged();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView img;
        Button buy;
        TextView price;
        TextView name;
        View mainView;
        TextView readyToEat;
        TextView delivery;
        TextView quantity;
        View detailsView;

        public FishViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView = itemView;
            detailsView = mainView.findViewById(R.id.fish_details);
            img = mainView.findViewById(R.id.fish_img);
            name = mainView.findViewById(R.id.fish_name);
            price = mainView.findViewById(R.id.fish_price);
            buy = mainView.findViewById(R.id.buy_btn);
            readyToEat = mainView.findViewById(R.id.ready_eat);
            delivery = mainView.findViewById(R.id.delivery);
            quantity = mainView.findViewById(R.id.quantity);

        }
    }

    protected class LoadingVH extends RecyclerView.ViewHolder {
        private ProgressBar mProgressBar;

        public LoadingVH(View itemView) {
            super(itemView);

            mProgressBar = itemView.findViewById(R.id.loadmore_progress);

        }
    }
}
