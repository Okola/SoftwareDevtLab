package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.HealthRecordModel;

import java.util.ArrayList;

public class HealthRecordAdapter extends RecyclerView.Adapter<HealthRecordAdapter.MyViewHolder> {

    Context context;
    ArrayList<HealthRecordModel> list;

    public HealthRecordAdapter(Context context, ArrayList<HealthRecordModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.health_record_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        HealthRecordModel HealthRecordModel = list.get(position);

        holder.healthFacility.setText(list.get(position).getHealthFacility());
        holder.birthNotificationNo.setText(list.get(position).getBirthNotificationNo());;
        holder.date.setText(list.get(position).getDate());;
        holder.permanentRegisterNo.setText(list.get(position).getPermanentRegisterNo());;
        holder.childWelfareClinicNo.setText(list.get(position).getChildWelfareClinicNo());;
        holder.healthfacilityName.setText(list.get(position).getHealthfacilityName());;
        holder.masterFacilityListNo.setText(list.get(position).getMasterFacilityListNo());;

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView healthFacility, birthNotificationNo, date, permanentRegisterNo, childWelfareClinicNo, healthfacilityName, masterFacilityListNo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            healthFacility = itemView.findViewById(R.id.facilityHolder);
            birthNotificationNo = itemView.findViewById(R.id.notificationNoHolder);
            date = itemView.findViewById(R.id.datteHolder);
            permanentRegisterNo = itemView.findViewById(R.id.registerNoHolder);
            childWelfareClinicNo = itemView.findViewById(R.id.welfareHolder);
            healthfacilityName = itemView.findViewById(R.id.healthfacilityHolder);
            masterFacilityListNo = itemView.findViewById(R.id.facilityListHolder);





        }

    }
}
