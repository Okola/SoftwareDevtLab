package com.example.phoenixhomes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PreviousPregnancyAdapter  extends RecyclerView.Adapter<PreviousPregnancyAdapter.MyViewHolder> {

    Context context;
    ArrayList<PreviousPregnancyModel> list;

    public PreviousPregnancyAdapter(Context context, ArrayList<PreviousPregnancyModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public PreviousPregnancyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.previous_pregnancy_layout, parent, false);
        return new PreviousPregnancyAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PreviousPregnancyAdapter.MyViewHolder holder, int position) {

        PreviousPregnancyModel previousPregnancyModel = list.get(position);


        holder.order.setText(list.get(position).getOrder());
        holder.year.setText(list.get(position).getYear());
        holder.ancAttended.setText(list.get(position).getAncAttended());
        holder.deliveryPlace.setText(list.get(position).getDeliveryPlace());
        holder.maturity.setText(list.get(position).getMaturity());
        holder.labourDuration.setText(list.get(position).getLabourDuration());
        holder.deliveryType.setText(list.get(position).getDeliveryType());
        holder.babyWeight.setText(list.get(position).getBabyWeight());
        holder.sex.setText(list.get(position).getSex());
        holder.outcome.setText(list.get(position).getOutcome());
        holder.puerperium.setText(list.get(position).getPuerperium());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView order,year,ancAttended,deliveryPlace,maturity,labourDuration,deliveryType,babyWeight,sex,outcome,puerperium;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            order = itemView.findViewById(R.id.pregnancyOrder);
            year = itemView.findViewById(R.id.year);
            ancAttended = itemView.findViewById(R.id.ancTimes);
            deliveryPlace = itemView.findViewById(R.id.placeofdelivery);
            maturity = itemView.findViewById(R.id.maturity);
            labourDuration = itemView.findViewById(R.id.labourDuration);
            deliveryType = itemView.findViewById(R.id.typeofdelivery);
            babyWeight = itemView.findViewById(R.id.birthweight);
            sex = itemView.findViewById(R.id.sex);
            outcome = itemView.findViewById(R.id.outcome);
            puerperium = itemView.findViewById(R.id.prueperium);




        }



    }
}
