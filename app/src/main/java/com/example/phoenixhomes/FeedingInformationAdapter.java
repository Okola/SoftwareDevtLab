package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedingInformationAdapter extends RecyclerView.Adapter<FeedingInformationAdapter.MyViewHolder> {

    Context context;
    ArrayList<FeedingInformationModel> list;

    public FeedingInformationAdapter(Context context, ArrayList<FeedingInformationModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.feeding_information_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FeedingInformationModel FeedingInformationModel = list.get(position);


        holder.breastfeeding.setText(list.get(position).getBreastfeeding());
        holder.otherFeedsIntroduced.setText(list.get(position).getOtherFeedsIntroduced());
        holder.complementaryFoods.setText(list.get(position).getComplementaryFoods());
        holder.indigestion.setText(list.get(position).getIndigestion());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView breastfeeding, otherFeedsIntroduced, complementaryFoods, indigestion;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            breastfeeding = itemView.findViewById(R.id.breastfeedingHolder);
            otherFeedsIntroduced = itemView.findViewById(R.id.otherfeedsintroducedNoHolder);
            complementaryFoods = itemView.findViewById(R.id.complimentaryfoodHolder);
            indigestion = itemView.findViewById(R.id.retentionHolder);


        }

    }
}
