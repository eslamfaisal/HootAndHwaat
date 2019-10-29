package com.eslam.hootandhawaat.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.models.FishesTripsResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TripsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final String TRIP_ID = "TRIP_ID";
    // View Types
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    List<FishesTripsResponse.Datum> fishList;
    Activity context;
    private boolean isLoadingAdded = false;
    private boolean retryPageLoad = false;

    public TripsAdapter(List<FishesTripsResponse.Datum> fishList, Activity context) {
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
                View viewItem = inflater.inflate(R.layout.layout_old_trip_item, parent, false);
                viewHolder = new TripsAdapter.TripViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.layout_item_progress, parent, false);
                viewHolder = new TripsAdapter.LoadingVH(viewLoading);
                break;

        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final FishesTripsResponse.Datum fish = fishList.get(i);
        switch (getItemViewType(i)) {

            case ITEM:

                final TripViewHolder holder = (TripViewHolder) viewHolder;
                holder.price.setText(fish.getTripPrice() + context.getString(R.string.sr));
                holder.img.setImageURI(fish.getTripImage());
                holder.name.setText(fish.getTripBoatName());

                holder.description.setText(fish.getPassengers() + context.getString(R.string.Ppassenfer));
                holder.period.setText(fish.getTripTime());
                holder.date.setText(fish.getTripDate());
                holder.mainView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        holder.reserveView.setVisibility(View.VISIBLE);
                    }
                });

//                if (SharedHelper.getKey(context, "log_in_type").equals("userProvider"))
                holder.reserveBtn.setVisibility(View.GONE);


                holder.reserveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (!SharedHelper.getKey(context, "log_in").equals("yes")) {
//                            context.startActivity(new Intent(context, LoginChooseActivity.class));
//                            context.finish();
//                        } else {
//                            Intent intent = new Intent(context,ReserveTripActivity.class);
//                            intent.putExtra(TRIP_ID,fish);
//                            context.startActivity(intent);
//
//                        }
                    }
                });
                break;
            case LOADING:
                final LoadingVH holder2 = (LoadingVH) viewHolder;

        }

    }

    @Override
    public int getItemCount() {
        return fishList.size();
    }

    public void clear() {
        if (fishList != null)
            fishList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<FishesTripsResponse.Datum> newfishList) {
        fishList.addAll(newfishList);
        notifyDataSetChanged();
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        fishList.add(new FishesTripsResponse.Datum());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = fishList.size() - 1;
        FishesTripsResponse.Datum result = getItem(position);

        if (result != null) {
            fishList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public FishesTripsResponse.Datum getItem(int position) {
        return fishList.get(position);
    }

    class TripViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView img;
        LinearLayout reserveView;
        Button reserveBtn;
        TextView price;
        TextView name;
        TextView description;
        View mainView;
        TextView period;
        TextView date;

        public TripViewHolder(@NonNull View itemView) {
            super(itemView);
            mainView = itemView;
            img = mainView.findViewById(R.id.trip_img);
            name = mainView.findViewById(R.id.boat_name);
            price = mainView.findViewById(R.id.trip_price);
            reserveView = mainView.findViewById(R.id.reserveView);
            reserveBtn = mainView.findViewById(R.id.reserveBtn);
            description = mainView.findViewById(R.id.trip_description);
            period = mainView.findViewById(R.id.trip_period);
            date = mainView.findViewById(R.id.trip_date);
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
