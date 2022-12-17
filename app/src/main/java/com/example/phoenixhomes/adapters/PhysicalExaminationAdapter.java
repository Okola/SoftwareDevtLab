package com.example.phoenixhomes.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.PhysicalExaminationModel;

import java.util.ArrayList;

public class PhysicalExaminationAdapter extends RecyclerView.Adapter<PhysicalExaminationAdapter.MyViewHolder> {

    Context context;
    ArrayList<PhysicalExaminationModel> list;

    public PhysicalExaminationAdapter(Context context, ArrayList<PhysicalExaminationModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public PhysicalExaminationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.physical_examination_layout, parent, false);
        return new PhysicalExaminationAdapter.MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull PhysicalExaminationAdapter.MyViewHolder holder, int position) {

        PhysicalExaminationModel physicalExaminationModel = list.get(position);

        holder.general.setText(list.get(position).getGeneral());
        holder.bp.setText(list.get(position).getBp());
        holder.height.setText(list.get(position).getHeight());
        holder.cvs.setText(list.get(position).getCvs());
        holder.resp.setText(list.get(position).getResp());
        holder.breasts.setText(list.get(position).getBreasts());
        holder.abdomen.setText(list.get(position).getAbdomen());
        holder.virginalExamination.setText(list.get(position).getVirginalExamination());
        holder.discharge.setText(list.get(position).getDischarge());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView general,bp,height,cvs,resp,breasts,abdomen,virginalExamination,discharge;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            general= itemView.findViewById(R.id.generalHolder);
            bp= itemView.findViewById(R.id.bpHolder);
            height= itemView.findViewById(R.id.heightHolder);
            cvs= itemView.findViewById(R.id.cvsHolder);
            resp = itemView.findViewById(R.id.respHolder);
            breasts= itemView.findViewById(R.id.breastsHolder);
            abdomen= itemView.findViewById(R.id.abdomenHolder);
            virginalExamination= itemView.findViewById(R.id.virginalHolder);
            discharge= itemView.findViewById(R.id.dischargeHolder);



        }



    }
}
