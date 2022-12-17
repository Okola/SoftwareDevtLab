package com.example.phoenixhomes.classes;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.databinding.ActivityPostNatalCareBinding;

public class PostNatalCare extends DrawerBaseActivity {

    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
    ActivityPostNatalCareBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_natal_care);

        a =  ActivityPostNatalCareBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("ANC,Delivery,PostNatal");


        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");

        }

        String finalOrderId = orderId;

        c1 = findViewById(R.id.maternalProfileCard);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, MaternalProfile.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c2 = findViewById(R.id.medicalAndSurgicalHistory);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, MedicalAndSurgicalHistory.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c3 = findViewById(R.id.previousPregnancy);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, PreviousPregnancy.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);


            }
        });

        c4 = findViewById(R.id.physicalExaminationCard);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, PhysicalExamination.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c5 = findViewById(R.id.antenatalProfile);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, AntennatalProfile.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c6 = findViewById(R.id.InfantFeedingCard);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, InfantFeeding.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);

            }
        });
//
        c7 = findViewById(R.id.presentPregnancyCard);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, PresentPregnancyTable.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c8 = findViewById(R.id.WeightGainCard);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, WeightGain.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c9 = findViewById(R.id.preventiveServicesCard);
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, PreventiveService.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c10 = findViewById(R.id.deliveryCard);
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, Delivery.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c11 = findViewById(R.id.postNatalExaminationCard);
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, PostNatalExamination.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c12 = findViewById(R.id.reproductiveOrgansCard);
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, ReproductiveOrgans.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c14 = findViewById(R.id.familyPlanningCard);
        c14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(PostNatalCare.this, FamilyPlanning.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);
            }
        });

        c15 = findViewById(R.id.clinicalNotesCard);
        c15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PostNatalCare.this, ClinicalNotes.class);
                intent.putExtra("orderId", finalOrderId);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onItemClick(int position) {

    }
}