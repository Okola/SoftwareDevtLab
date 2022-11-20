package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VaccinesAdapter extends RecyclerView.Adapter<VaccinesAdapter.vaccinesViewHolder> {

    ArrayList<Vaccines> vaccineList;
    Context context;

    public VaccinesAdapter(ArrayList<Vaccines> vaccineList, Context context) {
        this.vaccineList = vaccineList;
        this.context = context;
    }


    @NonNull
    @Override
    public vaccinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.administered_vaccines_recycler_layout, parent, false);
        return new vaccinesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vaccinesViewHolder holder, int position) {

        Vaccines vaccines  = vaccineList.get(position);
        holder.t1.setText(vaccineList.get(position).getVaccine());
        holder.t2.setText(vaccineList.get(position).getDose());
        holder.t3.setText(vaccineList.get(position).getDate());
        holder.t4.setText(vaccineList.get(position).getNextDate());





    }

    @Override
    public int getItemCount() {
        return vaccineList.size();
    }

    public static class vaccinesViewHolder extends RecyclerView.ViewHolder {
        
        TextView t1,t2,t3,t4;
        public vaccinesViewHolder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.vaccine);
            t2 = itemView.findViewById(R.id.dose);
            t3 = itemView.findViewById(R.id.date);
            t4 = itemView.findViewById(R.id.nextVaccinationVisit);
        }
    }
}
