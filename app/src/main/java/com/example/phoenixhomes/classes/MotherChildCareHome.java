package com.example.phoenixhomes.classes;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.databinding.ActivityMotherChildCareHomeBinding;


public class MotherChildCareHome extends DrawerBaseActivity {

    CardView card1,card2;
    ActivityMotherChildCareHomeBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_child_care_home);

        a =  ActivityMotherChildCareHomeBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("MCH Options");


        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");

        }



        card1 = findViewById(R.id.postnatalCard);
        card2 = findViewById(R.id.childMonitoringCard);

        String finalOrderId = orderId;
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MotherChildCareHome.this, PostNatalCare.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);

            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MotherChildCareHome.this, selectChild.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onItemClick(int position) {

    }
}