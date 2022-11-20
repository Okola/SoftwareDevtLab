package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImpairementsAndDisabilitiesAdapter extends RecyclerView.Adapter<ImpairementsAndDisabilitiesAdapter.MyViewHolder> {

    Context context;
    ArrayList<ImpairementsAndDisabilitiesModel> list1;

    public ImpairementsAndDisabilitiesAdapter(Context context, ArrayList<ImpairementsAndDisabilitiesModel> list1) {
        this.context = context;
        this.list1 = list1;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.imapairments_and_disabilities_layout, parent, false);
        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ImpairementsAndDisabilitiesModel ImpairementsAndDisabilitiesModel = list1.get(position);

        holder.babyHead.setText(list1.get(position).getBabyHead());
        holder.mouthAbnormalities.setText(list1.get(position).getMouthAbnormalities());
        holder.limbAbnormality.setText(list1.get(position).getLimbAbnormality());
        holder.limbNormality.setText(list1.get(position).getLimbNormality());
        holder.muscleTone.setText(list1.get(position).getMuscleTone());
        holder.jointsMovements.setText(list1.get(position).getJointsMovements());
        holder.noOfFingers.setText(list1.get(position).getNoOfFingersAndToes());
        holder.armsAndShouldersNormalty.setText(list1.get(position).getArmsAndShouldersNormalty());
        holder.babyBack.setText(list1.get(position).getBabyBack());
        holder.babyAnusAndGenitalia.setText(list1.get(position).getBabyAnusAndGenitalia());
        holder.babyStiffnesLying.setText(list1.get(position).getBabyStiffnesLying());


        holder.setIsRecyclable(false);

    }


    @Override
    public int getItemCount() {
        return list1.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView babyHead, mouthAbnormalities, limbAbnormality, limbNormality, muscleTone,jointsMovements,
                noOfFingers,armsAndShouldersNormalty, babyBack, babyAnusAndGenitalia, babyStiffnesLying;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            babyHead = itemView.findViewById(R.id.babyHeadHolder);
            mouthAbnormalities = itemView.findViewById(R.id.mouthAbnormalitiesHolder);
            limbAbnormality = itemView.findViewById(R.id.limbAbnormalityHolder);
            limbNormality = itemView.findViewById(R.id.limbNormalityHolder);
            muscleTone = itemView.findViewById(R.id.muscleToneHolder);
            jointsMovements = itemView.findViewById(R.id.jointsMovementsHolder);
            noOfFingers = itemView.findViewById(R.id.noOfFingersAndToesHolder);
            armsAndShouldersNormalty = itemView.findViewById(R.id.armsAndShouldersNormaltyHolder);
            babyBack = itemView.findViewById(R.id.babyBackHolder);
            babyAnusAndGenitalia = itemView.findViewById(R.id.babyAnusAndGenitaliaHolder);
            babyStiffnesLying = itemView.findViewById(R.id.babyStiffnesLyingHolder);
           



        }



    }
}

