package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.FamilyPlanningModel;

import java.util.ArrayList;

public class FamilyPlanningAdapter extends RecyclerView.Adapter<FamilyPlanningAdapter.MyViewHolder> {

    Context context;
    ArrayList<FamilyPlanningModel> list;

    public FamilyPlanningAdapter(Context context, ArrayList<FamilyPlanningModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.family_planning_layout, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FamilyPlanningModel FamilyPlanningModel = list.get(position);

        holder.date.setText(list.get(position).getDate());
        holder.nextVisit.setText(list.get(position).getNextVisit());
        holder.clinicalNotes.setText(list.get(position).getClinicalNotes());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date, clinicalNotes, nextVisit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.dateTodayHolder);
            nextVisit = itemView.findViewById(R.id.nextVisitPlaceHolder);
            clinicalNotes = itemView.findViewById(R.id.familyPlanningClinicalNote);



        }



    }
}
