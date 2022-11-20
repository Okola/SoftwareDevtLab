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

import com.example.phoenixhomes.databinding.ActivityCivilRegistrationBinding;;
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

public class CivilRegistration extends DrawerBaseActivity {

    CivilRegistrationAdapter adapter;
    ArrayList<CivilRegistrationModel> list;
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityCivilRegistrationBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_registration);

        setTitle("Civil Registration");

        a = ActivityCivilRegistrationBinding.inflate(getLayoutInflater());
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
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("Civil Registration");


        recyclerView = findViewById(R.id.civilRegistrationRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new CivilRegistrationAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    CivilRegistrationModel details = snapshot.getValue(CivilRegistrationModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.civil_registration_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETbirthCertNo, ETdateOfReg, ETplaceOfReg, ETfatherName, ETfatherTelNo, ETmotherName,ETmotherTelNo, ETguardianName,
                        ETguardianTelNo, ETcounty, ETdistrict, ETdivision, ETlocation, ETtown, ETestate, ETpostalAddress;



                ETbirthCertNo = findViewById(R.id.birthCertificateNoHolder1);
                ETdateOfReg = findViewById(R.id.dateOfRegistrationNoHolder1);
                ETplaceOfReg = findViewById(R.id.placeOfRegistrationHolder1);
                ETfatherName = findViewById(R.id.fathersNameHolder1);
                ETfatherTelNo = findViewById(R.id.fathersNoHolder1);
                ETmotherName = findViewById(R.id.mothersNameHolder1);
                ETmotherTelNo = findViewById(R.id.mothersNoHolder1);
                ETguardianName = findViewById(R.id.guardianHolder1);
                ETguardianTelNo = findViewById(R.id.guardianNoHolder1);
                ETcounty = findViewById(R.id.countyHolder1);
                ETdistrict = findViewById(R.id.districtHolder1);
                ETdivision = findViewById(R.id.divisionHolder1);
                ETlocation = findViewById(R.id.locationHolder1);
                ETtown = findViewById(R.id.townHolder1);
                ETestate = findViewById(R.id.villageHolder1);
                ETpostalAddress = findViewById(R.id.postalHolder1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String birthCertNo, dateOfReg, placeOfReg, fatherName, fatherTelNo, motherName,motherTelNo, guardianName,
                                guardianTelNo, county, district, division, location, town, estate, postalAddress;

                        birthCertNo = ETbirthCertNo.getText().toString();
                        dateOfReg = ETdateOfReg.getText().toString();
                        placeOfReg = ETplaceOfReg.getText().toString();
                        fatherName = ETfatherName.getText().toString();
                        fatherTelNo = ETfatherTelNo.getText().toString();
                        motherName = ETmotherName.getText().toString();
                        motherTelNo = ETmotherTelNo.getText().toString();
                        guardianName = ETguardianName.getText().toString();
                        guardianTelNo = ETguardianTelNo.getText().toString();
                        county = ETcounty.getText().toString();
                        district = ETdistrict.getText().toString();
                        division = ETdivision.getText().toString();
                        location = ETlocation.getText().toString();
                        town = ETtown.getText().toString();
                        estate = ETestate.getText().toString();
                        postalAddress = ETpostalAddress.getText().toString();




                        CivilRegistrationModel details = new CivilRegistrationModel(birthCertNo, dateOfReg, placeOfReg, fatherName, fatherTelNo, motherName,motherTelNo, guardianName,
                                guardianTelNo, county, district, division, location, town, estate, postalAddress);
                        Map<String, Object> item = new HashMap<>();
                        item.put("birthCertNo",birthCertNo);
                        item.put("dateOfReg",dateOfReg);
                        item.put("placeOfReg",placeOfReg);
                        item.put("fatherName", fatherName);
                        item.put("fatherTelNo",fatherTelNo);
                        item.put("motherName",motherName);
                        item.put("motherTelNo",motherTelNo);
                        item.put("guardianName",guardianName);
                        item.put("guardianTelNo",guardianTelNo);
                        item.put("county",county);
                        item.put("district", district);
                        item.put("division",division);
                        item.put("location",location);
                        item.put("town", town);
                        item.put("estate", estate);
                        item.put("postalAddress", postalAddress);



                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(CivilRegistration.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(CivilRegistration.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
