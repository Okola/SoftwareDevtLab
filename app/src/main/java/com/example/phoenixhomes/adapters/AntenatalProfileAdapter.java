package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.AntenatalProfileModel;

import java.util.ArrayList;

public class AntenatalProfileAdapter extends RecyclerView.Adapter<AntenatalProfileAdapter.MyViewHolder> {

    Context context;
    ArrayList<AntenatalProfileModel> list;

    public AntenatalProfileAdapter(Context context, ArrayList<AntenatalProfileModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.antenatal_profile_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AntenatalProfileModel AntenatalProfileModel = list.get(position);


        holder.hb.setText(list.get(position).getHb());
        holder.bloodGroup.setText(list.get(position).getBloodGroup());
        holder.rhesus.setText(list.get(position).getRhesus());
        holder.serology.setText(list.get(position).getSerology());
        holder.tbScreening.setText(list.get(position).getTbScreening());
        holder.ipt.setText(list.get(position).getIpt());
        holder.nextVisit.setText(list.get(position).getNextVisit());
        holder.hiv.setText(list.get(position).getHiv());
        holder.urinalysis.setText(list.get(position).getUrinalysis());
        holder.coupleHivCounseling.setText(list.get(position).getCoupleHivCounseling());


        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView hb,bloodGroup,rhesus,serology,tbScreening,ipt,nextVisit,hiv,urinalysis,coupleHivCounseling;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hb = itemView.findViewById(R.id.hbHolder);
            bloodGroup = itemView.findViewById(R.id.bloodGroupHolder);
            rhesus = itemView.findViewById(R.id.rhesusHolder);
            serology = itemView.findViewById(R.id.serologyHolder);
            tbScreening = itemView.findViewById(R.id.tbScreeningHolder);
            ipt = itemView.findViewById(R.id.iptHolder);
            nextVisit = itemView.findViewById(R.id.nextHolder);
            hiv = itemView.findViewById(R.id.hivHolder);
            urinalysis = itemView.findViewById(R.id.urinalysisHolder);
            coupleHivCounseling = itemView.findViewById(R.id.hivCounselingHolder);


        }

    }
}