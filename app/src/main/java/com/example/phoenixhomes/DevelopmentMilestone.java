package com.example.phoenixhomes;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.databinding.ActivityDevelopmentMilestoneBinding;
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

public class DevelopmentMilestone extends DrawerBaseActivity implements AdapterView.OnItemSelectedListener{

    DevelopmentMilestoneAdapter adapter;
    ArrayList<DevelopmentMilestoneModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityDevelopmentMilestoneBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_development_milestone);

        a = ActivityDevelopmentMilestoneBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());

        setTitle("Development Milestones");

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
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("Development Milestone");


        recyclerView = findViewById(R.id.developmentRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new DevelopmentMilestoneAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    DevelopmentMilestoneModel details = ds.getValue(DevelopmentMilestoneModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.development_milestone_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText  ETageArchieved, ETwithinTime, ETdelayed;
                Spinner ETmilestone;

                ETmilestone = findViewById(R.id.milestoneSpinner);

                String[] medicines;
                medicines = getResources().getStringArray(R.array.Milestones);
                ETmilestone.setOnItemSelectedListener(DevelopmentMilestone.this);
                ArrayAdapter ad = new ArrayAdapter(DevelopmentMilestone.this, android.R.layout.simple_spinner_item, medicines);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                ETmilestone.setAdapter(ad);


                ETageArchieved = findViewById(R.id.ageArchievedHolder);
                ETwithinTime = findViewById(R.id.withinTimeHolder1);
                ETdelayed = findViewById(R.id.delayednHolder1);




                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String  milestone = ETmilestone.getSelectedItem().toString();
                        String ageArchieved = ETageArchieved.getText().toString();
                        String withinTime = ETwithinTime.getText().toString();
                        String delayed = ETdelayed.getText().toString();



                        DevelopmentMilestoneModel details = new DevelopmentMilestoneModel( milestone, ageArchieved, withinTime, delayed);
                        Map<String, Object> item = new HashMap<>();
                        item.put("milestone",milestone);
                        item.put("ageArchieved",ageArchieved);
                        item.put("withinTime",withinTime);
                        item.put("delayed", delayed);



                        ref.push().setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(DevelopmentMilestone.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(DevelopmentMilestone.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(15);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(int position) {

    }
}
