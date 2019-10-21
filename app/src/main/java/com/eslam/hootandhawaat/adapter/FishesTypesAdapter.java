package com.eslam.hootandhawaat.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eslam.hootandhawaat.R;
import com.eslam.hootandhawaat.models.FishesTypeResponse;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class FishesTypesAdapter extends RecyclerView.Adapter<FishesTypesAdapter.TypeViewHolder> {

    List<FishesTypeResponse.Type> dataList;
    Activity context;

    FisheTypeListener fisheTypeListener;

    public FishesTypesAdapter(List<FishesTypeResponse.Type> dataList, Activity context, FisheTypeListener fisheTypeListener) {
        this.dataList = dataList;
        this.context = context;
        this.fisheTypeListener = fisheTypeListener;
    }

    public void addAll(List<FishesTypeResponse.Type> fishesType) {
        dataList.addAll(fishesType);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_fishes_types_item, parent, false);

        return new TypeViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int i) {
        final FishesTypeResponse.Type typeData = dataList.get(i);

        holder.type.setText(typeData.getFName());
        holder.type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fisheTypeListener.searchForType(typeData);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface FisheTypeListener {
        void searchForType(FishesTypeResponse.Type resul);
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {

       TextView type;

        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);

            type = itemView.findViewById(R.id.fish_type);
        }
    }
}
