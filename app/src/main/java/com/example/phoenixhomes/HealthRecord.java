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

import com.example.phoenixhomes.databinding.ActivityHealthRecordBinding;
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

public class HealthRecord extends DrawerBaseActivity {

    HealthRecordAdapter adapter;
    ArrayList<HealthRecordModel> list;
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityHealthRecordBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_record);

        setTitle("Health Record");

        a = ActivityHealthRecordBinding.inflate(getLayoutInflater());
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
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("Health Record");


        recyclerView = findViewById(R.id.healthRecordRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new HealthRecordAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    HealthRecordModel details = snapshot.getValue(HealthRecordModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.health_record_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText EThealthFacility, ETbirthNotificationNo, ETdate, ETpermanentRegisterNo, ETchildWelfareClinicNo, EThealthfacilityName, ETmasterFacilityListNo;

                EThealthFacility = findViewById(R.id.facilityHolder1);
                ETbirthNotificationNo = findViewById(R.id.notificationNoHolder1);
                ETdate = findViewById(R.id.datteHolder1);
                ETpermanentRegisterNo = findViewById(R.id.registerNoHolder1);
                ETchildWelfareClinicNo = findViewById(R.id.welfareHolder1);
                EThealthfacilityName = findViewById(R.id.healthfacilityHolder1);
                ETmasterFacilityListNo = findViewById(R.id.facilityListHolder1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String healthFacility, birthNotificationNo, date, permanentRegisterNo, childWelfareClinicNo, healthfacilityName, masterFacilityListNo;


                        healthFacility = EThealthFacility.getText().toString();
                        birthNotificationNo = ETbirthNotificationNo.getText().toString();
                        date = ETdate.getText().toString();
                        permanentRegisterNo = ETpermanentRegisterNo.getText().toString();
                        childWelfareClinicNo = ETchildWelfareClinicNo.getText().toString();
                        healthfacilityName = EThealthfacilityName.getText().toString();
                        masterFacilityListNo = ETmasterFacilityListNo.getText().toString();




                        HealthRecordModel details = new HealthRecordModel(healthFacility, birthNotificationNo, date, permanentRegisterNo, childWelfareClinicNo, healthfacilityName, masterFacilityListNo);

                        Map<String, Object> item = new HashMap<>();
                        item.put("healthFacility",healthFacility);
                        item.put("birthNotificationNo",birthNotificationNo);
                        item.put("date",date);
                        item.put("permanentRegisterNo", permanentRegisterNo);
                        item.put("childWelfareClinicNo",childWelfareClinicNo);
                        item.put("healthfacilityName",healthfacilityName);
                        item.put("masterFacilityListNo",masterFacilityListNo);



                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(HealthRecord.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(HealthRecord.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
