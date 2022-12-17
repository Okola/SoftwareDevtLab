package com.example.phoenixhomes.classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.databinding.ActivityChildMonitoringBinding;


public class ChildMonitoring extends DrawerBaseActivity {

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
    ActivityChildMonitoringBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_monitoring);

        setTitle("Child Monitoring");

        a =  ActivityChildMonitoringBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());



        String childId = "childId";
        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");
            childId = extras.getString("childId");

        }


        String finalOrderId = orderId;

        String finalChildId = childId;



        c1 = findViewById(R.id.childParticularsCard);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, ParticularsOfChild.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });

        c2 = findViewById(R.id.healthRecord);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, HealthRecord.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });

        c3 = findViewById(R.id.civilRegistration);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, CivilRegistration.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);

            }
        });

        c4 = findViewById(R.id.clinicalReview);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, ClinicalReview.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });

        c5 = findViewById(R.id.feedingInfo);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, FeedingInformation.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });
//
        c6 = findViewById(R.id.behaviouralCharacteristics);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, BehaviouralCharacteristics.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });



        c8 = findViewById(R.id.immunization);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, AdministeredVaccines.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });

        c9 = findViewById(R.id.developmentprogressWeight);
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, DevelopmentProgressWeight.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });

        c9 = findViewById(R.id.developmentprogressHeight);
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, DevelopmentProgressHeight.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });
        c9 = findViewById(R.id.developmentMilestones);
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChildMonitoring.this, DevelopmentMilestone.class);
                intent.putExtra("orderId", finalOrderId);
                intent.putExtra("childId", finalChildId);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onItemClick(int position) {

    }
}