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

import com.example.phoenixhomes.databinding.ActivityPresentPregnancyTableBinding;
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

public class PresentPregnancyTable extends DrawerBaseActivity {

    PresentPregnancyTableAdapter adapter;
    ArrayList<PresentPregnancyTableModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityPresentPregnancyTableBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_pregnancy_table);

        a =  ActivityPresentPregnancyTableBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Present Pregnancy");

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


        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Present Pregnancy").push();

        String id = ref.getKey();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Present Pregnancy");

        recyclerView = findViewById(R.id.presentPregnancyRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new PresentPregnancyTableAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    PresentPregnancyTableModel details = ds.getValue(PresentPregnancyTableModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.present_pregnancy_table_dialog_table))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETvisits,ETdate,ETurine,ETweight,ETbp,EThb,ETpallor,ETmaturity,ETfundalHeight,ETpresentatiion,ETlie,ETfoetalHeart,ETfoetalMovt,ETnextVisit;

                ETvisits = findViewById(R.id.visitsHolder1);
                ETdate = findViewById(R.id.ppdateHolder1);
                ETurine = findViewById(R.id.urineHolder1);
                ETweight = findViewById(R.id.ppweightHolder1);
                ETbp = findViewById(R.id.ppbpHolder1);
                EThb = findViewById(R.id.pphbHolder1);
                ETpallor = findViewById(R.id.pallorHolder1);
                ETmaturity = findViewById(R.id.maturityHolder1);
                ETfundalHeight = findViewById(R.id.fundalHeightHolder1);
                ETpresentatiion = findViewById(R.id.presentationHolder1);
                ETlie = findViewById(R.id.lieHolder1);
                ETfoetalHeart = findViewById(R.id.foetalHeartHolder1);
                ETfoetalMovt = findViewById(R.id.foetalMovtHolder1);
                ETnextVisit = findViewById(R.id.ppnextvisitHolder1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String visits = ETvisits.getText().toString();
                        String date = ETdate.getText().toString();
                        String urine = ETurine.getText().toString();
                        String weight = ETweight.getText().toString();
                        String bp = ETbp.getText().toString();
                        String hb = EThb.getText().toString();
                        String pallor = ETpallor.getText().toString();
                        String maturity = ETmaturity.getText().toString();
                        String fundalHeight = ETfundalHeight.getText().toString();
                        String presentatiion = ETpresentatiion.getText().toString();
                        String lie = ETlie.getText().toString();
                        String foetalHeart = ETfoetalHeart.getText().toString();
                        String foetalMovt = ETfoetalMovt.getText().toString();
                        String nextVisit = ETnextVisit.getText().toString();



                        PresentPregnancyTableModel details = new PresentPregnancyTableModel(visits,date,urine,weight,bp,hb,pallor,maturity,fundalHeight,presentatiion,lie,foetalHeart,foetalMovt,nextVisit);


                        Map<String, Object> item = new HashMap<>();
                        item.put("visits",visits);
                        item.put("date",date);
                        item.put("urine",urine);
                        item.put("weight",weight);
                        item.put("bp",bp);
                        item.put("hb",hb);
                        item.put("pallor",pallor);
                        item.put("maturity",maturity);
                        item.put("fundalHeight",fundalHeight);
                        item.put("presentatiion",presentatiion);
                        item.put("lie",lie);
                        item.put("foetalHeart",foetalHeart);
                        item.put("foetalMovt",foetalMovt);
                        item.put("nextVisit",nextVisit);


                        ref.setValue(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PresentPregnancyTable.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PresentPregnancyTable.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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