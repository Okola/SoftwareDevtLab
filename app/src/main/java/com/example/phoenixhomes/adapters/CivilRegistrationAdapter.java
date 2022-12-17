package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.CivilRegistrationModel;

import java.util.ArrayList;

public class CivilRegistrationAdapter extends RecyclerView.Adapter<CivilRegistrationAdapter.MyViewHolder> {

    Context context;
    ArrayList<CivilRegistrationModel> list;

    public CivilRegistrationAdapter(Context context, ArrayList<CivilRegistrationModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.civil_registration_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CivilRegistrationModel CivilRegistrationModel = list.get(position);

        holder.birthCertNo.setText(list.get(position).getBirthCertNo());
        holder.dateOfReg.setText(list.get(position).getDateOfReg());
        holder.placeOfReg.setText(list.get(position).getPlaceOfReg());
        holder.fatherName.setText(list.get(position).getFatherName());
        holder.fatherTelNo.setText(list.get(position).getFatherTelNo());
        holder.motherName.setText(list.get(position).getMotherName());
        holder.motherTelNo.setText(list.get(position).getMotherTelNo());
        holder.guardianName.setText(list.get(position).getGuardianName());
        holder.guardianTelNo.setText(list.get(position).getGuardianTelNo());
        holder.county.setText(list.get(position).getCounty());
        holder.district.setText(list.get(position).getDistrict());
        holder.division.setText(list.get(position).getDivision());
        holder.location.setText(list.get(position).getLocation());
        holder.town.setText(list.get(position).getTown());
        holder.estate.setText(list.get(position).getEstate());
        holder.postalAddress.setText(list.get(position).getPostalAddress());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView birthCertNo, dateOfReg, placeOfReg, fatherName, fatherTelNo, motherName,motherTelNo, guardianName,
                guardianTelNo, county, district, division, location, town, estate, postalAddress;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            birthCertNo = itemView.findViewById(R.id.birthCertificateNoHolder);
            dateOfReg = itemView.findViewById(R.id.dateOfRegistrationNoHolder);
            placeOfReg = itemView.findViewById(R.id.placeOfRegistrationHolder);
            fatherName = itemView.findViewById(R.id.fathersNameHolder);
            fatherTelNo = itemView.findViewById(R.id.fathersNoHolder);
            motherName = itemView.findViewById(R.id.mothersNameHolder);
            motherTelNo = itemView.findViewById(R.id.mothersNoHolder);
            guardianName = itemView.findViewById(R.id.guardianHolder);
            guardianTelNo = itemView.findViewById(R.id.guardianNoHolder);
            county = itemView.findViewById(R.id.countyHolder);
            district = itemView.findViewById(R.id.districtHolder);
            division = itemView.findViewById(R.id.divisionHolder);
            location = itemView.findViewById(R.id.locationHolder);
            town = itemView.findViewById(R.id.townHolder);
            estate = itemView.findViewById(R.id.villageHolder);
            postalAddress = itemView.findViewById(R.id.postalHolder);


        }

    }
}
