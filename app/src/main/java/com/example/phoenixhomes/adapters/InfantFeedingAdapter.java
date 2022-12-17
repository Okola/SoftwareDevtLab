package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.InfantFeedingModel;

import java.util.ArrayList;

public class InfantFeedingAdapter extends RecyclerView.Adapter<InfantFeedingAdapter.MyViewHolder> {

    Context context;
    ArrayList<InfantFeedingModel> list;

    public InfantFeedingAdapter(Context context, ArrayList<InfantFeedingModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.infant_feeding_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        InfantFeedingModel InfantFeedingModel = list.get(position);

        holder.counsellingDone.setText(list.get(position).getCounsellingDone());
        holder.counsellingOnBreastFeeding.setText(list.get(position).getCounsellingOnBreastFeeding());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView counsellingDone, counsellingOnBreastFeeding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            counsellingDone = itemView.findViewById(R.id.counsellingDoneHolder);
            counsellingOnBreastFeeding = itemView.findViewById(R.id.counsellingOnBreastFeedingHolder);


        }



    }
}