package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.MaternalProfileModel;

import java.util.ArrayList;

public class MaternalProfileAdapter extends RecyclerView.Adapter<MaternalProfileAdapter.MyViewHolder> {

    Context context;
    ArrayList<MaternalProfileModel> list;

    public MaternalProfileAdapter(Context context, ArrayList<MaternalProfileModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MaternalProfileAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.maternal_profile_layout, parent, false);
        return new MaternalProfileAdapter.MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MaternalProfileAdapter.MyViewHolder holder, int position) {

        MaternalProfileModel maternalProfileModel = list.get(position);

        holder.nameOfInstitution.setText(list.get(position).getNameOfInstitution());
        holder.mflNo.setText(list.get(position).getMflNo());
        holder.ancNo.setText(list.get(position).getAncNo());
        holder.pncNo.setText(list.get(position).getPncNo());
        holder.nameOfClient.setText(list.get(position).getNameOfClient());
        holder.age.setText(list.get(position).getAge());
        holder.gravida.setText(list.get(position).getGravida());
        holder.parity.setText(list.get(position).getParity());
        holder.height.setText(list.get(position).getHeight());
        holder.weight.setText(list.get(position).getWeight());
        holder.lmp.setText(list.get(position).getLmp());
        holder.edd.setText(list.get(position).getEdd());
        holder.maritalStatus.setText(list.get(position).getMaritalStatus());
        holder.address.setText(list.get(position).getAddress());
        holder.telephone.setText(list.get(position).getTelephone());
        holder.education.setText(list.get(position).getEducation());
        holder.nextOfKin.setText(list.get(position).getNextOfKin());
        holder.relationship.setText(list.get(position).getRelationship());
        holder.nextofKinContact.setText(list.get(position).getNextofKinContact());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameOfInstitution,mflNo,ancNo,pncNo,nameOfClient,age,gravida,parity,height,weight,lmp,
                edd,maritalStatus,address,telephone,education,nextOfKin,relationship,nextofKinContact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfInstitution = itemView.findViewById(R.id.institutionHolder);
            mflNo = itemView.findViewById(R.id.mflHolder);
            ancNo = itemView.findViewById(R.id.ancHolder);
            pncNo = itemView.findViewById(R.id.pncHolder);
            nameOfClient = itemView.findViewById(R.id.nameHolder);
            age = itemView.findViewById(R.id.ageHolder);
            gravida = itemView.findViewById(R.id.gravidaHolder);
            parity = itemView.findViewById(R.id.parityHolder);
            height = itemView.findViewById(R.id.heightHolder);
            weight = itemView.findViewById(R.id.weightHolder);
            lmp = itemView.findViewById(R.id.lmpHolder);
            edd = itemView.findViewById(R.id.eddHolder);
            maritalStatus = itemView.findViewById(R.id.maritalHolder);
            address = itemView.findViewById(R.id.addressHolder);
            telephone = itemView.findViewById(R.id.telephoneHolder);
            education = itemView.findViewById(R.id.educationHolder);
            nextOfKin = itemView.findViewById(R.id.nextofKinHolder);
            relationship = itemView.findViewById(R.id.relationshipHolder);
            nextofKinContact = itemView.findViewById(R.id.nextOfKinphoneHolder);



        }



    }
}