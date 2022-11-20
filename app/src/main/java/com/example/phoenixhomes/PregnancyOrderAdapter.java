package com.example.phoenixhomes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PregnancyOrderAdapter extends RecyclerView.Adapter<PregnancyOrderAdapter.listViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    ArrayList<PregnancyOrderModel> list;
    Context context;


    public PregnancyOrderAdapter(Context context, ArrayList<PregnancyOrderModel> list, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.list = list;
        this.recyclerViewInterface = recyclerViewInterface;

    }



    @NonNull
    @Override
    public PregnancyOrderAdapter.listViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pregnancy_order_layout, parent, false);
        return new PregnancyOrderAdapter.listViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PregnancyOrderAdapter.listViewHolder holder, int position) {

        holder.order.setText(list.get(position).getOrder());
        holder.date.setText(list.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void startListening() {


    }

    public void stopListening() {
    }




    public class listViewHolder<v> extends RecyclerView.ViewHolder {


        TextView order, date;
        CardView card;



        public listViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);


            order = itemView.findViewById(R.id.pregnancyOrder);
            date = itemView.findViewById(R.id.dateofFirstVisit);
            card = itemView.findViewById(R.id.card_pregnancy_order);

            itemView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onClick(View v) {

                    if (recyclerViewInterface != null){

                        int position = getAdapterPosition();

                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }


                    }

                    notifyDataSetChanged();


                }

            });



        }
    }


}
