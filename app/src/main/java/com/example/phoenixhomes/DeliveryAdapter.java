package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.MyViewHolder> {

    Context context;
    ArrayList<DeliveryModel> list;

    public DeliveryAdapter(Context context, ArrayList<DeliveryModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.delivery_layout, parent, false);
        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        DeliveryModel DeliveryModel = list.get(position);


        holder.weeks.setText(list.get(position).getWeeks());
        holder.hivTested.setText(list.get(position).getHivTested());
        holder.hivCounsel.setText(list.get(position).getHivCounsel());
        holder.deliveryMode.setText(list.get(position).getDeliveryMode());
        holder.date.setText(list.get(position).getDate());
        holder.bloodLoss.setText(list.get(position).getBloodLoss());
        holder.preeclampsia.setText(list.get(position).getPreeclampsia());
        holder.eclampsia.setText(list.get(position).getEclampsia());
        holder.obstructedLabor.setText(list.get(position).getObstructedLabor());
        holder.conditionOfMother.setText(list.get(position).getConditionOfMother());
        holder.oneMin.setText(list.get(position).getOneMin());
        holder.fiveMin.setText(list.get(position).getFiveMin());
        holder.tenMin.setText(list.get(position).getTenMin());
        holder.rescuscitation.setText(list.get(position).getRescuscitation());
        holder.oxytocin.setText(list.get(position).getOxytocin());
        holder.baby.setText(list.get(position).getBaby());
        holder.birthWeight.setText(list.get(position).getBirthWeight());
        holder.birthLenght.setText(list.get(position).getBirthLenght());
        holder.headCircumference.setText(list.get(position).getHeadCircumference());
        holder. placeOfDelivery.setText(list.get(position).getPlaceOfDelivery());
        holder. conductedby.setText(list.get(position).getConductedby());

        holder.setIsRecyclable(false);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView weeks, hivTested,hivCounsel,deliveryMode,date,bloodLoss,preeclampsia,eclampsia,obstructedLabor,
                conditionOfMother,oneMin,fiveMin,tenMin,rescuscitation,oxytocin,baby,birthWeight,birthLenght,headCircumference,
                placeOfDelivery,conductedby;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            weeks = itemView.findViewById(R.id.weeksHolder);
            hivTested = itemView.findViewById(R.id.hivTestedHolder);
            hivCounsel = itemView.findViewById(R.id.hivCounselHolder);
            deliveryMode = itemView.findViewById(R.id.deliveryModeHolder);
            date = itemView.findViewById(R.id.dateHolder);
            bloodLoss = itemView.findViewById(R.id.bloodLossHolder);
            preeclampsia = itemView.findViewById(R.id.preeclampsiaHolder);
            eclampsia = itemView.findViewById(R.id.eclampsiaHolder);
            obstructedLabor = itemView.findViewById(R.id.obstructedLaborHolder);
            conditionOfMother = itemView.findViewById(R.id.conditionOfMotherHolder);
            oneMin = itemView.findViewById(R.id.oneMinHolder);
            fiveMin = itemView.findViewById(R.id.fiveMinHolder);
            tenMin = itemView.findViewById(R.id.tenMinHolder);
            rescuscitation = itemView.findViewById(R.id.rescuscitationHolder);
            oxytocin = itemView.findViewById(R.id.oxytocinHolder);
            baby = itemView.findViewById(R.id.babyHolder);
            birthWeight = itemView.findViewById(R.id.birthWeightHolder);
            birthLenght = itemView.findViewById(R.id.birthLenghtnHolder);
            headCircumference = itemView.findViewById(R.id.headCircumferenceHolder);
            placeOfDelivery = itemView.findViewById(R.id.placeOfDeliveryHolder);
            conductedby = itemView.findViewById(R.id.conductedbyHolder);



        }



    }
}
