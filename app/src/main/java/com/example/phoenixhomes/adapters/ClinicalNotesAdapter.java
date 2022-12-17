package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.ClinicalNotesModel;

import java.util.ArrayList;

public class ClinicalNotesAdapter extends RecyclerView.Adapter<ClinicalNotesAdapter.MyViewHolder> {

    Context context;
    ArrayList<ClinicalNotesModel> list;

    public ClinicalNotesAdapter(Context context, ArrayList<ClinicalNotesModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.clinical_notes_layout, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ClinicalNotesModel ClinicalNotesModel = list.get(position);

        holder.date.setText(list.get(position).getDate());
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

            date = itemView.findViewById(R.id.dateTodayPlaceHolder);
            clinicalNotes = itemView.findViewById(R.id.ClinicalNotePlaceHolder);



        }



    }
}
