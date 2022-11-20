package com.example.phoenixhomes;

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

import com.example.phoenixhomes.databinding.ActivityDeliveryBinding;
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

public class Delivery extends DrawerBaseActivity {

    DeliveryAdapter adapter;
    ImpairementsAndDisabilitiesAdapter adapter1;
    ArrayList<DeliveryModel> list;
    ArrayList<ImpairementsAndDisabilitiesModel> list1;
    FirebaseDatabase db;
    DatabaseReference ref,reference;
    RecyclerView recyclerView,rv;
    TextView updateDetails,updateDetails1;
    ActivityDeliveryBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        a =  ActivityDeliveryBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Delivery Details");

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

        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("ADelivery Details");
        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Impairments and Disabilities");


        recyclerView = findViewById(R.id.DeliveryRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new DeliveryAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    DeliveryModel details = snapshot.getValue(DeliveryModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.delivery_dialog_layout))
                        .setExpanded(true, 1400)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText  ETweeks, EThivTested,EThivCounsel,ETdeliveryMode,ETdate,ETbloodLoss,ETpreeclampsia,ETeclampsia,ETobstructedLabor,
                        ETconditionOfMother,EToneMin,ETfiveMin,ETtenMin,ETrescuscitation,EToxytocin,ETbaby,ETbirthWeight,ETbirthLenght,ETheadCircumference,
                        ETplaceOfDelivery,ETconductedby;


                ETweeks = findViewById(R.id.weeksHolder1);
                EThivTested = findViewById(R.id.hivTestedHolder1);
                EThivCounsel = findViewById(R.id.hivCounselHolder1);
                ETdeliveryMode = findViewById(R.id.deliveryModeHolder1);
                ETdate = findViewById(R.id.dateHolder1);
                ETbloodLoss = findViewById(R.id.bloodLossHolder1);
                ETpreeclampsia = findViewById(R.id.preeclampsiaHolder1);
                ETeclampsia = findViewById(R.id.eclampsiaHolder1);
                ETobstructedLabor = findViewById(R.id.obstructedLaborHolder1);
                ETconditionOfMother = findViewById(R.id.conditionOfMotherHolder1);
                EToneMin = findViewById(R.id.oneMinHolder1);
                ETfiveMin = findViewById(R.id.fiveMinHolder1);
                ETtenMin = findViewById(R.id.tenMinHolder1);
                ETrescuscitation = findViewById(R.id.rescuscitationHolder1);
                EToxytocin = findViewById(R.id.oxytocinHolder1);
                ETbaby = findViewById(R.id.babyHolder1);
                ETbirthWeight = findViewById(R.id.birthWeightHolder1);
                ETbirthLenght = findViewById(R.id.birthLenghtnHolder1);
                ETheadCircumference = findViewById(R.id.headCircumferenceHolder1);
                ETplaceOfDelivery = findViewById(R.id.placeOfDeliveryHolder1);
                ETconductedby = findViewById(R.id.conductedbyHolder1);



                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String weeks, hivTested,hivCounsel,deliveryMode,date,bloodLoss,preeclampsia,eclampsia,obstructedLabor,
                                conditionOfMother,oneMin,fiveMin,tenMin,rescuscitation,oxytocin,baby,birthWeight,birthLenght,headCircumference,
                                placeOfDelivery,conductedby;

                        weeks = ETweeks.getText().toString();
                        hivTested = EThivTested.getText().toString();
                        hivCounsel = EThivCounsel.getText().toString();
                        deliveryMode = ETdeliveryMode.getText().toString();
                        date = ETdate.getText().toString();
                        bloodLoss = ETbloodLoss.getText().toString();
                        preeclampsia = ETpreeclampsia.getText().toString();
                        eclampsia = ETeclampsia.getText().toString();
                        obstructedLabor = ETobstructedLabor.getText().toString();
                        conditionOfMother = ETconditionOfMother.getText().toString();
                        oneMin = EToneMin.getText().toString();
                        fiveMin = ETfiveMin.getText().toString();
                        tenMin = ETtenMin.getText().toString();
                        rescuscitation = ETrescuscitation.getText().toString();
                        oxytocin = EToxytocin.getText().toString();
                        baby = ETbaby.getText().toString();
                        birthWeight = ETbirthWeight.getText().toString();
                        birthLenght = ETbirthLenght.getText().toString();
                        headCircumference = ETheadCircumference.getText().toString();
                        placeOfDelivery = ETplaceOfDelivery.getText().toString();
                        conductedby = ETconductedby.getText().toString();



                        DeliveryModel details = new DeliveryModel(weeks, hivTested,hivCounsel,deliveryMode,date,bloodLoss,preeclampsia,eclampsia,obstructedLabor,
                                conditionOfMother,oneMin,fiveMin,tenMin,rescuscitation,oxytocin,baby,birthWeight,birthLenght,headCircumference,
                                placeOfDelivery,conductedby);

                        Map<String, Object> item = new HashMap<>();
                        item.put("weeks",weeks);
                        item.put("hivTested", hivTested);
                        item.put("hivCounsel",hivCounsel);
                        item.put("deliveryMode",deliveryMode);
                        item.put("date",date);
                        item.put("bloodLoss",bloodLoss);
                        item.put("preeclampsia",preeclampsia);
                        item.put("eclampsia",eclampsia);
                        item.put("obstructedLabor",obstructedLabor);
                        item.put("conditionOfMother",conditionOfMother);
                        item.put("oneMin",oneMin);
                        item.put("fiveMin",fiveMin);
                        item.put("rescuscitation",rescuscitation);
                        item.put("oxytocin",oxytocin);
                        item.put("baby",baby);
                        item.put("birthWeight",birthWeight);
                        item.put("birthLenght",birthLenght);
                        item.put("headCircumference",headCircumference);
                        item.put("placeOfDelivery",placeOfDelivery);
                        item.put("conductedby",conductedby);


                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(Delivery.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(Delivery.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });

        rv = findViewById(R.id.impairmentsRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        list1 = new ArrayList<>();
        adapter1 = new ImpairementsAndDisabilitiesAdapter(this, list1);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list1.clear();
                    ImpairementsAndDisabilitiesModel details = snapshot.getValue(ImpairementsAndDisabilitiesModel.class);
                    list1.add(details);
                }


                adapter1.notifyDataSetChanged();
                rv.setAdapter(adapter1);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        updateDetails1 = findViewById(R.id.updatematernalprofile1);
        updateDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.imapairments_and_disabilities_dialog_layout))
                        .setExpanded(true, 1400)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText  ETbabyHead, ETmouthAbnormalities, ETlimbAbnormality, ETlimbNormality, ETmuscleTone,ETjointsMovements,
                        ETnoOfFingers,ETarmsAndShouldersNormalty, ETbabyBack, ETbabyAnusAndGenitalia, ETbabyStiffnesLying;

                ETbabyHead = findViewById(R.id.babyHeadHolder1);
                ETmouthAbnormalities = findViewById(R.id.mouthAbnormalitiesHolder1);
                ETlimbAbnormality = findViewById(R.id.limbAbnormalityHolder1);
                ETlimbNormality = findViewById(R.id.limbNormalityHolder1);
                ETmuscleTone = findViewById(R.id.muscleToneHolder1);
                ETjointsMovements = findViewById(R.id.jointsMovementsHolder1);
                ETnoOfFingers = findViewById(R.id.noOfFingersAndToesHolder1);
                ETarmsAndShouldersNormalty = findViewById(R.id.armsAndShouldersNormaltyHolder1);
                ETbabyBack = findViewById(R.id.babyBackHolder1);
                ETbabyAnusAndGenitalia = findViewById(R.id.babyAnusAndGenitaliaHolder1);
                ETbabyStiffnesLying = findViewById(R.id.babyStiffnesLyingHolder1);


                Button submit = findViewById(R.id.submit1);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String babyHead,mouthAbnormalities, limbAbnormality, limbNormality, muscleTone,jointsMovements,
                                noOfFingersAndToes,armsAndShouldersNormalty, babyBack, babyAnusAndGenitalia, babyStiffnesLying;

                        babyHead = ETbabyHead.getText().toString();
                        mouthAbnormalities = ETmouthAbnormalities.getText().toString();
                        limbAbnormality = ETlimbAbnormality.getText().toString();
                        limbNormality = ETlimbNormality.getText().toString();
                        muscleTone = ETmuscleTone.getText().toString();
                        jointsMovements = ETjointsMovements.getText().toString();
                        noOfFingersAndToes = ETnoOfFingers.getText().toString();
                        armsAndShouldersNormalty = ETarmsAndShouldersNormalty.getText().toString();
                        babyBack = ETbabyBack.getText().toString();
                        babyAnusAndGenitalia = ETbabyAnusAndGenitalia.getText().toString();
                        babyStiffnesLying = ETbabyStiffnesLying.getText().toString();;



                        ImpairementsAndDisabilitiesModel details = new ImpairementsAndDisabilitiesModel(babyHead,mouthAbnormalities, limbAbnormality, limbNormality, muscleTone,jointsMovements,
                                noOfFingersAndToes,armsAndShouldersNormalty, babyBack, babyAnusAndGenitalia, babyStiffnesLying);

                        Map<String, Object> item = new HashMap<>();
                        item.put("babyHead",babyHead);
                        item.put("mouthAbnormalities", mouthAbnormalities);
                        item.put("limbAbnormality",limbAbnormality);
                        item.put("limbNormality",limbNormality);
                        item.put("muscleTone",muscleTone);
                        item.put("jointsMovements",jointsMovements);
                        item.put(" noOfFingersAndToes", noOfFingersAndToes);
                        item.put("armsAndShouldersNormalty",armsAndShouldersNormalty);
                        item.put("babyBackr",babyBack);
                        item.put("babyAnusAndGenitalia",babyAnusAndGenitalia);
                        item.put("babyStiffnesLying",babyStiffnesLying);




                        reference.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(Delivery.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(Delivery.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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