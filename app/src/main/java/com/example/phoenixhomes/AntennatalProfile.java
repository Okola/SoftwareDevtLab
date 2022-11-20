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

import com.example.phoenixhomes.databinding.ActivityAntennatalProfileBinding;
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

public class AntennatalProfile extends DrawerBaseActivity {

    AntenatalProfileAdapter adapter;
    ArrayList<AntenatalProfileModel> list;
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityAntennatalProfileBinding a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antennatal_profile);

        a =  ActivityAntennatalProfileBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Antenatal Profile");


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

        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Antenatal Profile");


        recyclerView = findViewById(R.id.antenatalProfileRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new AntenatalProfileAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    AntenatalProfileModel details = snapshot.getValue(AntenatalProfileModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.antenatal_profile_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText EThb,ETbloodGroup,ETrhesus,ETserology,ETtbScreening,ETipt,ETnextVisit,EThiv,ETrinalysis,ETcoupleHivCounseling;

                EThb = findViewById(R.id.hbHolder1);
                ETbloodGroup = findViewById(R.id.bloodGroupHolder1);
                ETrhesus = findViewById(R.id.rhesusHolder1);
                ETserology = findViewById(R.id.serologyHolder1);
                ETtbScreening = findViewById(R.id.tbScreeningHolder1);
                ETipt = findViewById(R.id.iptHolder1);
                ETnextVisit = findViewById(R.id.nextHolder1);
                EThiv = findViewById(R.id.hivHolder1);
                ETrinalysis = findViewById(R.id.urinalysisHolder1);
                ETcoupleHivCounseling = findViewById(R.id.hivCounselingHolder1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String hb = EThb.getText().toString();
                        String bloodGroup = ETbloodGroup.getText().toString();
                        String rhesus = ETrhesus.getText().toString();
                        String serology = ETserology.getText().toString();
                        String tbScreening = ETtbScreening.getText().toString();
                        String ipt = ETipt.getText().toString();
                        String nextVisit = ETnextVisit.getText().toString();
                        String hiv = EThiv.getText().toString();
                        String urinalysis = ETrinalysis.getText().toString();
                        String coupleHivCounseling = ETcoupleHivCounseling.getText().toString();

                        AntenatalProfileModel details = new AntenatalProfileModel(hb,bloodGroup,rhesus,serology,tbScreening,ipt,nextVisit,hiv,urinalysis,coupleHivCounseling);

                        Map<String, Object> item = new HashMap<>();
                        item.put("hb",hb);
                        item.put("bloodGroup",bloodGroup);
                        item.put("rhesus",rhesus);
                        item.put("serology",serology);
                        item.put("tbScreening",tbScreening);
                        item.put("ipt",ipt);
                        item.put("nextVisit",nextVisit);
                        item.put("hiv",hiv);
                        item.put("urinalysis",urinalysis);
                        item.put("coupleHivCounseling",coupleHivCounseling);

                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(AntennatalProfile.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(AntennatalProfile.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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