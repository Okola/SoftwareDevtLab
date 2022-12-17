package com.example.phoenixhomes.classes;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.adapters.MedicalAndSurgicalHistoryAdapter;
import com.example.phoenixhomes.databinding.ActivityMedicalAndSurgicalHistoryBinding;
import com.example.phoenixhomes.models.MedicalAndSurgicalHistroyModel;
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

public class MedicalAndSurgicalHistory extends DrawerBaseActivity {

    MedicalAndSurgicalHistoryAdapter adapter;
    ArrayList<MedicalAndSurgicalHistroyModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityMedicalAndSurgicalHistoryBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_and_surgical_history);

        a =  ActivityMedicalAndSurgicalHistoryBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Medical History");

        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            orderId = extras.getString("orderId");

        }
        String finalOrderId = orderId;


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();

        db = FirebaseDatabase.getInstance();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Medical and Surgical History");


        recyclerView = findViewById(R.id.medicalAndSurgicalHistoryRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new MedicalAndSurgicalHistoryAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot ds: snapshot.getChildren()){
                    list.clear();
                    MedicalAndSurgicalHistroyModel details = snapshot.getValue(MedicalAndSurgicalHistroyModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.medical_and_surgical_history_dialog_layout))
                        .setExpanded(true,1500)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETsurgicalOperation,ETdiabetes,EThypertension,EtbloodTransfusion,ETtb,ETdrugAllergy,Etothers,
                        ETtwins,ETtuberculosis;

                ETsurgicalOperation = findViewById(R.id.surgicalOperationHolder1);
                ETdiabetes  = findViewById(R.id.diabetesHolder1);
                EThypertension  = findViewById(R.id.hyperTensionHolder1);
                EtbloodTransfusion  = findViewById(R.id.bloodTransfusionHolder1);
                ETtb  = findViewById(R.id.tbHolder1);
                ETdrugAllergy  = findViewById(R.id.allergyHolder1);
                Etothers  = findViewById(R.id.otherHolder1);
                ETtwins = findViewById(R.id.twinsHolder1);
                ETtuberculosis = findViewById(R.id.tuberculosisHolder1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String surgicalOperation =  ETsurgicalOperation.getText().toString();
                        String diabetes = ETdiabetes.getText().toString();
                        String hypertension = EThypertension.getText().toString();
                        String bloodTransfusion = EtbloodTransfusion.getText().toString();
                        String tb = ETtb.getText().toString();
                        String drugAllergy = ETdrugAllergy.getText().toString();
                        String others = Etothers.getText().toString();
                        String twins = ETtwins.getText().toString();
                        String tuberculosis = ETtuberculosis.getText().toString();

                        MedicalAndSurgicalHistroyModel details = new MedicalAndSurgicalHistroyModel(surgicalOperation,diabetes,hypertension,bloodTransfusion,tb,drugAllergy,others,
                                twins,tuberculosis);


                        Map<String, Object> item = new HashMap<>();
                        item.put("surgicalOperation",surgicalOperation);
                        item.put("diabetes",diabetes);
                        item.put("hypertension",hypertension);
                        item.put("bloodTransfusion",bloodTransfusion);
                        item.put("tb",tb);
                        item.put("drugAllergy",drugAllergy);
                        item.put("others",others);
                        item.put("twins",twins);
                        item.put("tuberculosis",tuberculosis);


                        reference.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(MedicalAndSurgicalHistory.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(MedicalAndSurgicalHistory.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
