package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.ChildPostNatalExaminationModel;

import java.util.ArrayList;

public class ChildPostNatalExaminationAdapter extends RecyclerView.Adapter<ChildPostNatalExaminationAdapter.MyViewHolder> {

    Context context;
    ArrayList<ChildPostNatalExaminationModel> list1;

    public ChildPostNatalExaminationAdapter(Context context, ArrayList<ChildPostNatalExaminationModel> list1) {
        this.context = context;
        this.list1 = list1;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.child_postnatal_examination_layout, parent, false);
        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ChildPostNatalExaminationModel ChildPostNatalExaminationModel = list1.get(position);

        holder.visit.setText(list1.get(position).getVisit());
        holder.generalCondition.setText(list1.get(position).getGeneralCondition());
        holder.temp.setText(list1.get(position).getTemp());
        holder.breathPM.setText(list1.get(position).getBreathPM());
        holder.feedingMethod.setText(list1.get(position).getFeedingMethod());
        holder.breastfeedingPositioning.setText(list1.get(position).getBreastfeedingPositioning());
        holder.umblicalCord.setText(list1.get(position).getUmblicalCord());
        holder.immunizationStarted.setText(list1.get(position).getImmunizationStarted());
        holder.artprophylaxis.setText(list1.get(position).getArtprophylaxis());
        holder.cotrimoxazole.setText(list1.get(position).getCotrimoxazoleInitiated());

        holder.setIsRecyclable(false);

    }


    @Override
    public int getItemCount() {
        return list1.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView visit, generalCondition, temp, breathPM,feedingMethod, breastfeedingPositioning, umblicalCord,
                immunizationStarted, artprophylaxis,cotrimoxazole;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            visit = itemView.findViewById(R.id.timeHolder);
            generalCondition = itemView.findViewById(R.id.babyConditionHolder);
            temp = itemView.findViewById(R.id.babyTempHolder);
            breathPM = itemView.findViewById(R.id.breatheHolder);
            feedingMethod = itemView.findViewById(R.id.feedingHolder);
            breastfeedingPositioning = itemView.findViewById(R.id.breastfeedingHolder);
            umblicalCord = itemView.findViewById(R.id.ucHolder);
            immunizationStarted = itemView.findViewById(R.id.immunizationHolder);
            artprophylaxis = itemView.findViewById(R.id.artHolder);
            cotrimoxazole = itemView.findViewById(R.id.cotrimoxazoleHolder);





        }



    }
}

