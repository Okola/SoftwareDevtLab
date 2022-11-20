package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BehaviouralCharacteristicsAdapter extends RecyclerView.Adapter<BehaviouralCharacteristicsAdapter.MyViewHolder> {

    Context context;
    ArrayList<BehaviouralCharacteristicsModel> list;

    public BehaviouralCharacteristicsAdapter(Context context, ArrayList<BehaviouralCharacteristicsModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.behavioural_characteristics_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        BehaviouralCharacteristicsModel BehaviouralCharacteristicsModel = list.get(position);

        holder.sleepAndWakeupCycles.setText(list.get(position).getSleepAndWakeupCycles());;
        holder.irritability.setText(list.get(position).getIrritability());
        holder.thumborFingerSucking.setText(list.get(position).getThumborFingerSucking());
        holder.others.setText(list.get(position).getOthers());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView sleepAndWakeupCycles, irritability, thumborFingerSucking, others;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            sleepAndWakeupCycles = itemView.findViewById(R.id.sleepingHolder);
            irritability = itemView.findViewById(R.id.irritabilityHolder);
            thumborFingerSucking = itemView.findViewById(R.id.thumbHolder);
            others = itemView.findViewById(R.id.othersnHolder);



        }

    }
}

