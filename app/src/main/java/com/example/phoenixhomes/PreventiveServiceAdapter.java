package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PreventiveServiceAdapter extends RecyclerView.Adapter<PreventiveServiceAdapter.MyViewHolder> {

    Context context;
    ArrayList<PreventiveServiceModel> list;

    public PreventiveServiceAdapter(Context context, ArrayList<PreventiveServiceModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.preventive_service_layout, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PreventiveServiceModel PreventiveServiceModel = list.get(position);

        holder.date.setText(list.get(position).getDate());
        holder.nextVisit.setText(list.get(position).getNextVisit());
        holder.medicine.setText(list.get(position).getMedicine());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date,nextVisit,medicine;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateHolderr);
            nextVisit = itemView.findViewById(R.id.nextVisitHolder);
            medicine = itemView.findViewById(R.id.medicineHolder);



        }



    }
}
