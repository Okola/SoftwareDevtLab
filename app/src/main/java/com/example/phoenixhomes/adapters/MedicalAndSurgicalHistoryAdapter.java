package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.MedicalAndSurgicalHistroyModel;

import java.util.ArrayList;

public class MedicalAndSurgicalHistoryAdapter extends RecyclerView.Adapter<MedicalAndSurgicalHistoryAdapter.MyViewHolder> {

    Context context;
    ArrayList<MedicalAndSurgicalHistroyModel> list;

    public MedicalAndSurgicalHistoryAdapter(Context context, ArrayList<MedicalAndSurgicalHistroyModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MedicalAndSurgicalHistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.medical_and_surgical_history_layout, parent, false);
        return new MedicalAndSurgicalHistoryAdapter.MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MedicalAndSurgicalHistoryAdapter.MyViewHolder holder, int position) {

        MedicalAndSurgicalHistroyModel medicalAndSurgicalHistroyModel = list.get(position);


        holder.surgicalOperation.setText(list.get(position).getSurgicalOperation());
        holder.diabetes.setText(list.get(position).getDiabetes());
        holder.hypertension.setText(list.get(position).getHypertension());
        holder.bloodTransfusion.setText(list.get(position).getBloodTransfusion());
        holder.tb.setText(list.get(position).getTb());
        holder.drugAllergy.setText(list.get(position).getDrugAllergy());
        holder.others.setText(list.get(position).getOthers());
        holder.twins.setText(list.get(position).getTwins());
        holder.tuberculosis.setText(list.get(position).getTuberculosis());

        holder.setIsRecyclable(false);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView surgicalOperation,diabetes,hypertension,bloodTransfusion,tb,drugAllergy,others,
                twins,tuberculosis;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            surgicalOperation = itemView.findViewById(R.id.surgicalOperationHolder);
            diabetes = itemView.findViewById(R.id.diabetesHolder);
            hypertension = itemView.findViewById(R.id.hyperTensionHolder);
            bloodTransfusion = itemView.findViewById(R.id.bloodTransfusionHolder);
            tb = itemView.findViewById(R.id.tbHolder);
            drugAllergy = itemView.findViewById(R.id.allergyHolder);
            others = itemView.findViewById(R.id.otherHolder);
            twins = itemView.findViewById(R.id.twinsHolder);
            tuberculosis = itemView.findViewById(R.id.tuberculosisHolder);


        }



    }
}