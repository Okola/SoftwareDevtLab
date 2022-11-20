package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PresentPregnancyTableAdapter extends RecyclerView.Adapter<PresentPregnancyTableAdapter.MyViewHolder> {

    Context context;
    ArrayList<PresentPregnancyTableModel> list;

    public PresentPregnancyTableAdapter(Context context, ArrayList<PresentPregnancyTableModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.present_pregnancy_table_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        PresentPregnancyTableModel PresentPregnancyTableModel = list.get(position);

        holder.visits.setText(list.get(position).getVisits());
        holder.date.setText(list.get(position).getDate());
        holder.urine.setText(list.get(position).getUrine());
        holder.weight.setText(list.get(position).getWeight());
        holder.bp.setText(list.get(position).getBp());
        holder.hb.setText(list.get(position).getHb());
        holder.pallor.setText(list.get(position).getPallor());
        holder.maturity.setText(list.get(position).getMaturity());
        holder.fundalHeight.setText(list.get(position).getFundalHeight());
        holder.presentatiion.setText(list.get(position).getPresentatiion());
        holder.lie.setText(list.get(position).getLie());
        holder.foetalHeart.setText(list.get(position).getFoetalHeart());
        holder.foetalMovt.setText(list.get(position).getFoetalMovt());
        holder.nextVisit.setText(list.get(position).getNextVisit());


        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView visits,date,urine,weight,bp,hb,maturity,pallor,fundalHeight,presentatiion,lie,foetalHeart,foetalMovt,nextVisit;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            visits = itemView.findViewById(R.id.visitsHolder);
            date = itemView.findViewById(R.id.ppdateHolder);
            urine = itemView.findViewById(R.id.urineHolder);
            weight = itemView.findViewById(R.id.ppweightHolder);
            bp = itemView.findViewById(R.id.ppbpHolder);
            hb = itemView.findViewById(R.id.pphbHolder);
            maturity = itemView.findViewById(R.id.maturityHolder);
            pallor = itemView.findViewById(R.id.pallorHolder);
            fundalHeight = itemView.findViewById(R.id.fundalHeightHolder);
            presentatiion = itemView.findViewById(R.id.presentationHolder);
            lie = itemView.findViewById(R.id.lieHolder);
            foetalHeart = itemView.findViewById(R.id.foetalHeartHolder);
            foetalMovt = itemView.findViewById(R.id.foetalMovtHolder);
            nextVisit = itemView.findViewById(R.id.ppnextvisitHolder);


        }



    }
}