package com.example.phoenixhomes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixhomes.databinding.ActivityPostNatalExaminationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PostNatalExamination extends DrawerBaseActivity {

    MotherPostNatalExaminationAdapter adapter;
    ChildPostNatalExaminationAdapter adapter1;
    ArrayList<MotherPostNatalExaminationModel> list;
    ArrayList<ChildPostNatalExaminationModel> list1;
    FirebaseDatabase db;
    DatabaseReference ref,reference;
    RecyclerView recyclerView,rv;
    TextView updateDetails,updateDetails1;
    ActivityPostNatalExaminationBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_natal_examination);

        a =  ActivityPostNatalExaminationBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("PostNatal Examination ");


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();

        db = FirebaseDatabase.getInstance();

        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            orderId = extras.getString("orderId");

        }

        String finalOrderId = orderId;

        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("PostNatal Examination").child("Mother");
        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("PostNatal Examination").child("Child");

        recyclerView = findViewById(R.id.motherRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new MotherPostNatalExaminationAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    MotherPostNatalExaminationModel details = ds.getValue(MotherPostNatalExaminationModel.class);
                    list.add(details);
                }


                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        updateDetails = findViewById(R.id.updatematernalprofile);
        updateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.mother_postnatal_examination_dialog_layout))
                        .setExpanded(true, 1400)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETtimingOfVisit, ETdate, ETbloodPressure, ETtemp, ETpulse, ETrespiratoryRate, ETgeneralCondition, ETbreast,
                        ETcsScar, ETinvolutionOfUterus, ETconditionOfEspisotomy, ETlochia, ETpelvicExam, ETvaginalExamination, EThaemoglobin,
                        EThivStatus, EThaart, ETprophylaxis, EThivretesting, ETcounselling, ETfp;


                ETtimingOfVisit = findViewById(R.id.timeHolder1);
                ETdate = findViewById(R.id.dateHolder2);
                ETbloodPressure = findViewById(R.id.bpHolder2);
                ETtemp = findViewById(R.id.TempHolder1);
                ETpulse = findViewById(R.id.PulseHolder1);
                ETrespiratoryRate = findViewById(R.id. rrHolder1);
                ETgeneralCondition = findViewById(R.id.gcHolder1);
                ETbreast = findViewById(R.id.BreastHolder1);
                ETcsScar = findViewById(R.id.cscscarHolder1);
                ETinvolutionOfUterus = findViewById(R.id.uterusHolder1);
                ETconditionOfEspisotomy = findViewById(R.id.espisiotomyHolder1);
                ETlochia = findViewById(R.id.lochiaHolder1);
                ETpelvicExam = findViewById(R.id.peHolder1);
                ETvaginalExamination = findViewById(R.id.veHolder1);
                EThaemoglobin = findViewById(R.id.HaemoglobinHolder1);
                EThivStatus = findViewById(R.id.hivStatusHolder1);
                EThaart = findViewById(R.id.haartHolder1);
                ETprophylaxis = findViewById(R.id.prophylaxisHolder1);
                EThivretesting = findViewById(R.id.hivRetestingHolder1);
                ETcounselling = findViewById(R.id.counsellingHolder1);
                ETfp = findViewById(R.id.fpHolder1);




                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String timingOfVisit, date, bloodPressure, temp, pulse, respiratoryRate, generalCondition, breast,
                                csScar, involutionOfUterus, conditionOfEspisotomy, lochia, pelvicExam, vaginalExamination, haemoglobin,
                                hivStatus, haart, prophylaxis, hivretesting, counselling, fp;

                        timingOfVisit = ETtimingOfVisit.getText().toString();
                        date = ETdate.getText().toString();
                        bloodPressure = ETbloodPressure.getText().toString();
                        temp = ETtemp.getText().toString();
                        pulse = ETpulse.getText().toString();
                        respiratoryRate = ETrespiratoryRate.getText().toString();
                        generalCondition = ETgeneralCondition.getText().toString();
                        breast = ETbreast.getText().toString();
                        csScar = ETcsScar.getText().toString();
                        involutionOfUterus = ETinvolutionOfUterus.getText().toString();
                        conditionOfEspisotomy = ETconditionOfEspisotomy.getText().toString();
                        lochia =ETlochia.getText().toString();
                        pelvicExam = ETpelvicExam.getText().toString();
                        vaginalExamination = ETvaginalExamination.getText().toString();
                        haemoglobin = EThaemoglobin.getText().toString();
                        hivStatus = EThivStatus.getText().toString();
                        haart = EThaart.getText().toString();
                        prophylaxis = ETprophylaxis.getText().toString();
                        hivretesting = EThivretesting.getText().toString();
                        counselling = ETcounselling.getText().toString();
                        fp = ETfp.getText().toString();


                        MotherPostNatalExaminationModel details = new MotherPostNatalExaminationModel(timingOfVisit, date, bloodPressure, temp, pulse, respiratoryRate, generalCondition, breast,
                                csScar, involutionOfUterus, conditionOfEspisotomy, lochia, pelvicExam, vaginalExamination, haemoglobin,
                                hivStatus, haart, prophylaxis, hivretesting, counselling, fp);

                        Map<String, Object> item = new HashMap<>();
                        item.put("timingOfVisit",timingOfVisit);
                        item.put("date", date);
                        item.put("bloodPressure",bloodPressure);
                        item.put("temp",temp);
                        item.put("pulse",pulse);
                        item.put("respiratoryRate",respiratoryRate);
                        item.put("generalCondition",generalCondition);
                        item.put("breast",breast);
                        item.put("csScar",csScar);
                        item.put("involutionOfUterus",involutionOfUterus);
                        item.put("conditionOfEspisotomy",conditionOfEspisotomy);
                        item.put("lochia",lochia);
                        item.put("pelvicExam",pelvicExam);
                        item.put("vaginalExamination",vaginalExamination);
                        item.put("haemoglobin",haemoglobin);
                        item.put("hivStatus",hivStatus);
                        item.put("haart",haart);
                        item.put("prophylaxis",prophylaxis);
                        item.put("hivretesting",hivretesting);
                        item.put("counselling",counselling);
                        item.put("fp",fp);


                        ref.push().setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PostNatalExamination.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PostNatalExamination.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });

        rv = findViewById(R.id.childPostNatalExamsRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        list1 = new ArrayList<>();
        adapter1 = new ChildPostNatalExaminationAdapter(this, list1);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    ChildPostNatalExaminationModel details = ds.getValue(ChildPostNatalExaminationModel.class);
                    list1.add(details);
                }


                adapter1.notifyDataSetChanged();
                rv.setAdapter(adapter1);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        updateDetails1 = findViewById(R.id.updatematernalprofile3);
        updateDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.child_postnatal_examination_dialog_layout))
                        .setExpanded(true, 1400)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText  ETvisit, ETgeneralCondition, ETtemp, ETbreathPM,ETfeedingMethod, ETbreastfeedingPositioning, ETumblicalCord,
                        ETimmunizationStarted, ETartprophylaxis,ETcotrimoxazole;

                ETvisit = findViewById(R.id.timeHolder2);
                ETgeneralCondition = findViewById(R.id.babyConditionHolder2);
                ETtemp = findViewById(R.id.babyTempHolder2);
                ETbreathPM = findViewById(R.id.breatheHolder2);
                ETfeedingMethod = findViewById(R.id.feedingHolder2);
                ETbreastfeedingPositioning = findViewById(R.id.breastfeedingHolder2);
                ETumblicalCord = findViewById(R.id.ucHolder2);
                ETimmunizationStarted = findViewById(R.id.immunizationHolder2);
                ETartprophylaxis = findViewById(R.id.artHolder2);
                ETcotrimoxazole = findViewById(R.id.cotrimoxazoleHolder2);




                Button submit = findViewById(R.id.submit3);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String  visit, generalCondition, temp, breathPM,feedingMethod, breastfeedingPositioning, umblicalCord,
                                immunizationStarted, artprophylaxis,cotrimoxazole;

                        visit = ETvisit.getText().toString();
                        generalCondition = ETgeneralCondition.getText().toString();
                        temp = ETtemp.getText().toString();
                        breathPM = ETbreathPM.getText().toString();
                        feedingMethod = ETfeedingMethod.getText().toString();
                        breastfeedingPositioning = ETbreastfeedingPositioning.getText().toString();
                        umblicalCord = ETumblicalCord.getText().toString();
                        immunizationStarted = ETimmunizationStarted.getText().toString();
                        artprophylaxis = ETartprophylaxis.getText().toString();
                        cotrimoxazole =ETcotrimoxazole.getText().toString();




                        ChildPostNatalExaminationModel details = new ChildPostNatalExaminationModel(visit, generalCondition, temp, breathPM,feedingMethod, breastfeedingPositioning, umblicalCord,
                                immunizationStarted, artprophylaxis,cotrimoxazole);

                        Map<String, Object> item = new HashMap<>();
                        item.put("visit",visit);
                        item.put("generalCondition", generalCondition);
                        item.put("temp",temp);
                        item.put("breathPM",breathPM);
                        item.put("feedingMethod",feedingMethod);
                        item.put("breastfeedingPositioning",breastfeedingPositioning);
                        item.put("umblicalCord", umblicalCord);
                        item.put("immunizationStarted",immunizationStarted);
                        item.put("artprophylaxis",artprophylaxis);
                        item.put("cotrimoxazole",cotrimoxazole);





                        reference.push().setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PostNatalExamination.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PostNatalExamination.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });
    }

    @Override
    public void onItemClick(int position) {

    }
}