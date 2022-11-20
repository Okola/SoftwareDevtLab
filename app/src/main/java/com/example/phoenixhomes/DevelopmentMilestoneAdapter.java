package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DevelopmentMilestoneAdapter extends RecyclerView.Adapter<DevelopmentMilestoneAdapter.MyViewHolder> {

    Context context;
    ArrayList<DevelopmentMilestoneModel> list;

    public DevelopmentMilestoneAdapter(Context context, ArrayList<DevelopmentMilestoneModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.development_milestone_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DevelopmentMilestoneModel DevelopmentMilestoneModel = list.get(position);


        holder.milestone.setText(list.get(position).getMilestone());
        holder.ageArchieved.setText(list.get(position).getAgeArchieved());
        holder.withinTime.setText(list.get(position).getWithinTime());
        holder.delayed.setText(list.get(position).getDelayed());


        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView milestone, ageArchieved, withinTime, delayed;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            milestone = itemView.findViewById(R.id.milestoneHolder);
            ageArchieved = itemView.findViewById(R.id.ageHolder);
            withinTime = itemView.findViewById(R.id.withinTimes);
            delayed = itemView.findViewById(R.id.delayedHolder);



        }

    }
}

