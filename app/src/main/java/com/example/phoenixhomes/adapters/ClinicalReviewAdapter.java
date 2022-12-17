package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.ClinicalReviewModel;

import java.util.ArrayList;

public class ClinicalReviewAdapter extends RecyclerView.Adapter<ClinicalReviewAdapter.MyViewHolder> {

    Context context;
    ArrayList<ClinicalReviewModel> list;

    public ClinicalReviewAdapter(Context context, ArrayList<ClinicalReviewModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.clinical_review_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ClinicalReviewModel ClinicalReviewModel = list.get(position);

        holder.age.setText(list.get(position).getAge());
        holder.weight.setText(list.get(position).getWeight());
        holder.length.setText(list.get(position).getLength());
        holder.hivStatus.setText(list.get(position).getHivStatus());
        holder.hb.setText(list.get(position).getHb());
        holder.physicalFeatures.setText(list.get(position).getPhysicalFeatures());
        holder.colouration.setText(list.get(position).getColouration());
        holder.headCircumference.setText(list.get(position).getHeadCircumference());
        holder.eyes.setText(list.get(position).getEyes());
        holder.ears.setText(list.get(position).getEars());
        holder.mouth.setText(list.get(position).getMouth());
        holder.chest.setText(list.get(position).getChest());
        holder.heart.setText(list.get(position).getHeart());
        holder.abdomen.setText(list.get(position).getAbdomen());
        holder.umblicalcord.setText(list.get(position).getUmblicalcord());
        holder.spine.setText(list.get(position).getSpine());
        holder.armsAndHands.setText(list.get(position).getArmsAndHands());
        holder.legsAndFeet.setText(list.get(position).getLegsAndFeet());
        holder.geitalia.setText(list.get(position).getGeitalia());
        holder.anus.setText(list.get(position).getAnus());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView  age, weight, length, hivStatus, hb, physicalFeatures, colouration, headCircumference, eyes, ears, mouth,
                chest, heart, abdomen, umblicalcord, spine, armsAndHands, legsAndFeet, geitalia, anus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            age = itemView.findViewById(R.id.ageAtFirstContactHolder);
            weight = itemView.findViewById(R.id.weightInKgNoHolder);
            length = itemView.findViewById(R.id.lenghtorheightHolder);
            hivStatus = itemView.findViewById(R.id.fathersNameHolder);
            hb = itemView.findViewById(R.id.HBHolder);
            physicalFeatures = itemView.findViewById(R.id.physicalFeaturesHolder);
            colouration = itemView.findViewById(R.id.colourationHolder);
            headCircumference = itemView.findViewById(R.id.headCircumferenceHolder);
            eyes = itemView.findViewById(R.id.eyesHolder);
            ears = itemView.findViewById(R.id.earsHolder);
            mouth = itemView.findViewById(R.id.mouthHolder);
            chest = itemView.findViewById(R.id.chestHolder);
            heart = itemView.findViewById(R.id.heartHolder);
            abdomen = itemView.findViewById(R.id.abdomenHolder);
            umblicalcord = itemView.findViewById(R.id.umblicalHolder);
            spine = itemView.findViewById(R.id.spineHolder);
            armsAndHands = itemView.findViewById(R.id.armsAndHandsHolder);
            legsAndFeet = itemView.findViewById(R.id.legsAndFeetHolder);
            geitalia = itemView.findViewById(R.id.genitaliaHolder);
            anus = itemView.findViewById(R.id.anusHolder);



        }

    }
}
