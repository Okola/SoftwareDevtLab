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

import com.example.phoenixhomes.databinding.ActivityBehaviouralCharacteristicsBinding;
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

public class BehaviouralCharacteristics extends DrawerBaseActivity{

    BehaviouralCharacteristicsAdapter adapter;
    ArrayList<BehaviouralCharacteristicsModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityBehaviouralCharacteristicsBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavioural_characteristics);

        setTitle("Behavioural Characteristics");

        a = ActivityBehaviouralCharacteristicsBinding.inflate(getLayoutInflater());
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
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("Behavioural Characteristics");


        recyclerView = findViewById(R.id.behaviouralRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new BehaviouralCharacteristicsAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    BehaviouralCharacteristicsModel details = snapshot.getValue(BehaviouralCharacteristicsModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.behavioural_characteristics_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETsleepAndWakeupCycles, ETirritability, ETthumborFingerSucking, ETothers;


                ETsleepAndWakeupCycles = findViewById(R.id.sleepingHolder);
                ETirritability = findViewById(R.id.irritabilityHolder);
                ETthumborFingerSucking = findViewById(R.id.thumbHolder);
                ETothers = findViewById(R.id.othersnHolder);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String sleepAndWakeupCycles, irritability, thumborFingerSucking, others;

                        sleepAndWakeupCycles =  ETsleepAndWakeupCycles.getText().toString();
                        irritability = ETirritability.getText().toString();
                        thumborFingerSucking = ETthumborFingerSucking.getText().toString();
                        others = ETothers.getText().toString();






                        BehaviouralCharacteristicsModel details = new BehaviouralCharacteristicsModel(sleepAndWakeupCycles, irritability, thumborFingerSucking, others);
                        Map<String, Object> item = new HashMap<>();
                        item.put("sleepAndWakeupCycles",sleepAndWakeupCycles);
                        item.put("irritability",irritability);
                        item.put("thumborFingerSucking",thumborFingerSucking);
                        item.put("others", others);
                      



                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(BehaviouralCharacteristics.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(BehaviouralCharacteristics.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
