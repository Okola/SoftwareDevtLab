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

public class ChildListAdapter extends RecyclerView.Adapter<ChildListAdapter.childListViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    ArrayList<Child> childList;
    Context context;


    public ChildListAdapter(Context context, ArrayList<Child> childList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.childList = childList;
        this.recyclerViewInterface = recyclerViewInterface;

    }


    @NonNull
    @Override
    public childListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_recycler_layout, parent, false);
        return new childListViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull childListViewHolder holder, int position) {

        holder.t1.setText(childList.get(position).getNameOfChild());
        holder.t2.setText(childList.get(position).getDateOfBirth());
        holder.t3.setText(childList.get(position).getGender());




    }

    @Override
    public int getItemCount() {
        return childList.size();
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




    public class childListViewHolder<v> extends RecyclerView.ViewHolder {


        TextView t1,t2,t3;
        CardView card;



        public childListViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);


            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            t3 = itemView.findViewById(R.id.text3);
            card = itemView.findViewById(R.id.card_child);
            
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
