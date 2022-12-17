package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.ReproductiveOrgansModel;

import java.util.ArrayList;

public class ReproductiveOrgansAdapter extends RecyclerView.Adapter<ReproductiveOrgansAdapter.MyViewHolder> {

    Context context;
    ArrayList<ReproductiveOrgansModel> list;

    public ReproductiveOrgansAdapter(Context context, ArrayList<ReproductiveOrgansModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.reproductive_organs_layout, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ReproductiveOrgansModel ReproductiveOrgansModel = list.get(position);

        holder.date.setText(list.get(position).getDate());
        holder.examination.setText(list.get(position).getExamination());
        holder.test.setText(list.get(position).getTest());
        holder.results.setText(list.get(position).getResults());
        holder.treatment.setText(list.get(position).getTreatment());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date, examination, test, results, treatment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date= itemView.findViewById(R.id.dateHolder4);
            examination= itemView.findViewById(R.id.examinationHolder4);
            test= itemView.findViewById(R.id.testHolder4);
            results= itemView.findViewById(R.id.resultsHolder4);
            treatment= itemView.findViewById(R.id.treatmentHolder4);


        }



    }
}