package com.example.phoenixhomes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FerrousFumerateAdapter extends RecyclerView.Adapter<FerrousFumerateAdapter.MyViewHolder> {

    Context context;
    ArrayList<FerrousFumerateModel> list1;

    public FerrousFumerateAdapter(Context context, ArrayList<FerrousFumerateModel> list1) {
        this.context = context;
        this.list1 = list1;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ferrous_fumerate_layout, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        FerrousFumerateModel FerrousFumerateModel = list1.get(position);

        holder.date.setText(list1.get(position).getDate());
        holder.visitOrder.setText(list1.get(position).getOrder());
        holder.weeks.setText(list1.get(position).getWeeks());
        holder.tablets.setText(list1.get(position).getTablets());

        holder.setIsRecyclable(false);


    }


    @Override
    public int getItemCount() {
        return list1.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView visitOrder,weeks,tablets,date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            visitOrder = itemView.findViewById(R.id.visitOrder);
            weeks = itemView.findViewById(R.id.weeks);
            tablets = itemView.findViewById(R.id.tablets);
            

        }



    }
}
