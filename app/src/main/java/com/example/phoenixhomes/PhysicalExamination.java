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

import com.example.phoenixhomes.databinding.ActivityPhysicalExaminationBinding;
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

public class PhysicalExamination extends DrawerBaseActivity {

    PhysicalExaminationAdapter adapter;
    ArrayList<PhysicalExaminationModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityPhysicalExaminationBinding a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_examination);

        a = ActivityPhysicalExaminationBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Physical Examination");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();

        db = FirebaseDatabase.getInstance();

        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            orderId = extras.getString("orderId");

        }

        String finalOrderId = orderId;


        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Physical Examination");

        recyclerView = findViewById(R.id.physicalExaminationRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new PhysicalExaminationAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for (DataSnapshot ds : snapshot.getChildren()) {

                    list.clear();
                    PhysicalExaminationModel details = snapshot.getValue(PhysicalExaminationModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.physical_examination_dialog_layout))
                        .setExpanded(true, 1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETgeneral, ETbp, ETheight, ETcvs, ETresp, ETbreasts, ETabdomen, ETvirginalExamination, ETdischarge;


                ETgeneral = findViewById(R.id.generalHolder1);
                ETbp = findViewById(R.id.bpHolder1);
                ETheight = findViewById(R.id.heightHolder1);
                ETcvs = findViewById(R.id.cvsHolder1);
                ETresp = findViewById(R.id.respHolder1);
                ETbreasts = findViewById(R.id.breastsHolder1);
                ETabdomen = findViewById(R.id.abdomenHolder1);
                ETvirginalExamination = findViewById(R.id.virginalHolder1);
                ETdischarge = findViewById(R.id.dischargeHolder1);

                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String general = ETgeneral.getText().toString();
                        String bp = ETbp.getText().toString();
                        String height = ETheight.getText().toString();
                        String cvs = ETcvs.getText().toString();
                        String resp = ETresp.getText().toString();
                        String breasts = ETbreasts.getText().toString();
                        String abdomen = ETabdomen.getText().toString();
                        String virginalExamination = ETvirginalExamination.getText().toString();
                        String discharge = ETdischarge.getText().toString();


                        PhysicalExaminationModel details = new PhysicalExaminationModel(general, bp, height, cvs, resp, breasts, abdomen, virginalExamination, discharge);

                        Map<String, Object> item = new HashMap<>();

                        item.put("general", general);
                        item.put("bp", bp);
                        item.put("height", height);
                        item.put("cvs", cvs);
                        item.put("resp", resp);
                        item.put("breasts", breasts);
                        item.put("abdomen", abdomen);
                        item.put("virginalExamination", virginalExamination);
                        item.put("discharge", discharge);


                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PhysicalExamination.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PhysicalExamination.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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

