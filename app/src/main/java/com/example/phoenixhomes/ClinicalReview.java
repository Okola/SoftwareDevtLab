package com.example.phoenixhomes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.databinding.ActivityClinicalReviewBinding;
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

public class ClinicalReview extends DrawerBaseActivity {

    ClinicalReviewAdapter adapter;
    ArrayList<ClinicalReviewModel> list;
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityClinicalReviewBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinical_review);

        setTitle("Clinical Review");

        a = ActivityClinicalReviewBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();

        db = FirebaseDatabase.getInstance();

        String orderId = "orderId";
        String childId = "childId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");
            childId = extras.getString("childId");

        }

        String finalOrderId = orderId;
        String finalChildId = childId;

        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook")
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("Clinical Review");


        recyclerView = findViewById(R.id.clinicalReviewRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new ClinicalReviewAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    ClinicalReviewModel details = snapshot.getValue(ClinicalReviewModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.clinical_review_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETage, ETweight, ETlength, EThivStatus, EThb, ETphysicalFeatures, ETcolouration, ETheadCircumference, ETeyes, ETears, ETmouth,
                        ETchest, ETheart, ETabdomen, ETumblicalcord, ETspine, ETarmsAndHands, ETlegsAndFeet, ETgeitalia, ETanus;

                ETage = findViewById(R.id.ageAtFirstContactHolder1);
                ETweight = findViewById(R.id.weightInKgNoHolder1);
                ETlength = findViewById(R.id.lenghtorheightHolder1);
                EThivStatus = findViewById(R.id.fathersNameHolder1);
                EThb = findViewById(R.id.HBHolder1);
                ETphysicalFeatures = findViewById(R.id.physicalFeaturesHolder1);
                ETcolouration = findViewById(R.id.colourationHolder1);
                ETheadCircumference = findViewById(R.id.headCircumferenceHolder1);
                ETeyes = findViewById(R.id.eyesHolder1);
                ETears = findViewById(R.id.earsHolder1);
                ETmouth = findViewById(R.id.mouthHolder1);
                ETchest = findViewById(R.id.chestHolder1);
                ETheart = findViewById(R.id.heartHolder1);
                ETabdomen = findViewById(R.id.abdomenHolder1);
                ETumblicalcord = findViewById(R.id.umblicalHolder1);
                ETspine = findViewById(R.id.spineHolder1);
                ETarmsAndHands = findViewById(R.id.armsAndHandsHolder1);
                ETlegsAndFeet = findViewById(R.id.legsAndFeetHolder1);
                ETgeitalia = findViewById(R.id.genitaliaHolder1);
                ETanus = findViewById(R.id.anusHolder1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String  age, weight, length, hivStatus, hb, physicalFeatures, colouration, headCircumference, eyes, ears, mouth,
                                chest, heart, abdomen, umblicalcord, spine, armsAndHands, legsAndFeet, geitalia, anus;
                        
                        age = ETage.getText().toString();
                        weight = ETweight.getText().toString();
                        length = ETlength.getText().toString();
                        hivStatus = EThivStatus.getText().toString();
                        hb = EThb.getText().toString();
                        physicalFeatures = ETphysicalFeatures.getText().toString();
                        colouration = ETcolouration.getText().toString();
                        headCircumference = ETheadCircumference.getText().toString();
                        eyes = ETeyes.getText().toString();
                        ears = ETears.getText().toString();
                        mouth = ETmouth.getText().toString();
                        chest = ETchest.getText().toString();
                        heart =  ETheart.getText().toString();
                        abdomen = ETabdomen.getText().toString();
                        umblicalcord = ETumblicalcord.getText().toString();
                        spine = ETspine.getText().toString();
                        armsAndHands = ETarmsAndHands.getText().toString();
                        legsAndFeet = ETlegsAndFeet.getText().toString();
                        geitalia = ETgeitalia.getText().toString();
                        anus = ETanus.getText().toString();

                        
                        ClinicalReviewModel details = new ClinicalReviewModel(age, weight, length, hivStatus, hb, physicalFeatures, colouration, headCircumference, eyes, ears, mouth,
                                chest, heart, abdomen, umblicalcord, spine, armsAndHands, legsAndFeet, geitalia, anus);
                        
                        Map<String, Object> item = new HashMap<>();
                        item.put("age",age);
                        item.put("weight",weight);
                        item.put("length",length);
                        item.put("hivStatus", hivStatus);
                        item.put("hb",hb);
                        item.put("physicalFeatures",physicalFeatures);
                        item.put("colouration",colouration);
                        item.put("headCircumference",headCircumference);
                        item.put("eyes",eyes);
                        item.put("ears",ears);
                        item.put("mouth", mouth);
                        item.put("chest",chest);
                        item.put("heart",heart);
                        item.put("abdomen", abdomen);
                        item.put("umblicalcord", umblicalcord);
                        item.put("spine", spine);
                        item.put("armsAndHands", armsAndHands);
                        item.put("legsAndFeet",legsAndFeet);
                        item.put("geitalia",geitalia);
                        item.put("anus", anus);
                        



                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(ClinicalReview.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(ClinicalReview.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
