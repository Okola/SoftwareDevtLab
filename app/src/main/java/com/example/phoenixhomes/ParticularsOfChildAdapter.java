package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParticularsOfChildAdapter extends RecyclerView.Adapter<ParticularsOfChildAdapter.MyViewHolder> {

    Context context;
    ArrayList<ParticularsOfChildModel> list;

    public ParticularsOfChildAdapter(Context context, ArrayList<ParticularsOfChildModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.particulars_of_child_layout, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ParticularsOfChildModel ParticularsOfChildModel = list.get(position);

        holder.name.setText(list.get(position).getName());
        holder.sex.setText(list.get(position).getSex());
        holder.dateOfBirth.setText(list.get(position).getDateOfBirth());
        holder.gestation.setText(list.get(position).getGestation());
        holder.birthWeight.setText(list.get(position).getBirthWeight());
        holder.birthlenght.setText(list.get(position).getBirthlenght());
        holder.otherCharacteristics.setText(list.get(position).getOtherCharacteristics());
        holder.order.setText(list.get(position).getOrder());
        holder.dateFirstSeen.setText(list.get(position).getDateFirstSeen());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, sex, dateOfBirth, gestation, birthWeight, birthlenght, otherCharacteristics, order, dateFirstSeen;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.childNameHolder);
            sex= itemView.findViewById(R.id.childGenderHolder);
            dateOfBirth= itemView.findViewById(R.id.DOBHolder);
            gestation= itemView.findViewById(R.id.gestationHolder);
            birthWeight= itemView.findViewById(R.id.birthweightHolder);
            birthlenght= itemView.findViewById(R.id.birthlengthHolder);
            otherCharacteristics= itemView.findViewById(R.id.xticsHolder);
            order= itemView.findViewById(R.id.birthOrderHolder);
            dateFirstSeen= itemView.findViewById(R.id.dateHolder);



        }

    }
}