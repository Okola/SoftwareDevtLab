package com.example.phoenixhomes.classes;

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

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.adapters.FeedingInformationAdapter;
import com.example.phoenixhomes.databinding.ActivityFeedingInformationBinding;
import com.example.phoenixhomes.models.FeedingInformationModel;
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

public class FeedingInformation extends DrawerBaseActivity {

    FeedingInformationAdapter adapter;
    ArrayList<FeedingInformationModel> list;
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityFeedingInformationBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding_information);

        setTitle("Feeding Information");

        a = ActivityFeedingInformationBinding.inflate(getLayoutInflater());
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
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("Feeding Information");


        recyclerView = findViewById(R.id.feedingInfoRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new FeedingInformationAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    FeedingInformationModel details = snapshot.getValue(FeedingInformationModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.feeding_information_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETbreastfeeding, ETotherFeedsIntroduced, ETcomplementaryFoods, ETindigestion;

                ETbreastfeeding = findViewById(R.id.breastfeedingHolder1);
                ETotherFeedsIntroduced = findViewById(R.id.otherfeedsintroducedNoHolder1);
                ETcomplementaryFoods = findViewById(R.id.complimentaryfoodHolder1);
                ETindigestion = findViewById(R.id.retentionHolder1);
                

                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String breastfeeding, otherFeedsIntroduced, complementaryFoods, indigestion;

                        breastfeeding = ETbreastfeeding.getText().toString();
                        otherFeedsIntroduced = ETotherFeedsIntroduced.getText().toString();
                        complementaryFoods = ETcomplementaryFoods.getText().toString();
                        indigestion = ETindigestion.getText().toString();



                        FeedingInformationModel details = new FeedingInformationModel(breastfeeding, otherFeedsIntroduced, complementaryFoods, indigestion);

                        Map<String, Object> item = new HashMap<>();
                        item.put("breastfeeding",breastfeeding);
                        item.put("otherFeedsIntroduced",otherFeedsIntroduced);
                        item.put("complementaryFoods",complementaryFoods);
                        item.put("indigestion", indigestion);



                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(FeedingInformation.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(FeedingInformation.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
