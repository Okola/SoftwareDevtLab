package com.example.phoenixhomes;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixhomes.databinding.ActivityMaternalProfileBinding;
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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MaternalProfile extends DrawerBaseActivity {


    MaternalProfileAdapter adapter;
    ArrayList<MaternalProfileModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityMaternalProfileBinding a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maternal_profile);

        a =  ActivityMaternalProfileBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Maternal Profile");

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
        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Maternal Profile");

        String id = ref.getKey();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Maternal Profile");

        recyclerView = findViewById(R.id.maternalProfileRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new MaternalProfileAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    MaternalProfileModel details = snapshot.getValue(MaternalProfileModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.maternal_profile_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETnameOfInstitution,ETmflNo,ETancNo,ETpncNo,ETnameOfClient,ETage,ETgravida,ETparity,ETheight,ETweight,ETlmp,
                        ETedd,ETmaritalStatus,ETaddress,ETtelephone,ETeducation,ETnextOfKin,ETrelationship,ETnextofKinContact;

                ETnameOfInstitution = findViewById(R.id.institutionHolder1);
                ETmflNo = findViewById(R.id.mflHolder1);
                ETancNo = findViewById(R.id.ancHolder1);
                ETpncNo = findViewById(R.id.pncHolder1);
                ETnameOfClient = findViewById(R.id.nameHolder1);
                ETage = findViewById(R.id.ageHolder1);
                ETgravida = findViewById(R.id.gravidaHolder1);
                ETparity = findViewById(R.id.parityHolder1);
                ETheight = findViewById(R.id.heightHolder1);
                ETweight = findViewById(R.id.weightHolder1);
                ETlmp = findViewById(R.id.lmpHolder1);
                ETedd = findViewById(R.id.eddHolder1);
                ETmaritalStatus = findViewById(R.id.maritalHolder1);
                ETaddress = findViewById(R.id.addressHolder1);
                ETtelephone = findViewById(R.id.telephoneHolder1);
                ETeducation = findViewById(R.id.educationHolder1);
                ETnextOfKin = findViewById(R.id.nextofKinHolder1);
                ETrelationship = findViewById(R.id.relationshipHolder1);
                ETnextofKinContact = findViewById(R.id.nextOfKinphoneHolder1);

                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String nameOfInstitution = ETnameOfInstitution.getText().toString();
                        String mflNo = ETmflNo.getText().toString();
                        String ancNo = ETancNo.getText().toString();
                        String pncNo = ETpncNo.getText().toString();
                        String nameOfClient = ETnameOfClient.getText().toString();
                        String age = ETage.getText().toString();
                        String gravida = ETgravida.getText().toString();
                        String parity = ETparity.getText().toString();
                        String height = ETheight.getText().toString();
                        String weight = ETweight.getText().toString();
                        String lmp = ETlmp.getText().toString();
                        String edd = ETedd.getText().toString();
                        String maritalStatus = ETmaritalStatus.getText().toString();
                        String address = ETaddress.getText().toString();
                        String telephone = ETtelephone.getText().toString();
                        String education = ETeducation.getText().toString();
                        String nextOfKin = ETnextOfKin.getText().toString();
                        String relationship = ETrelationship.getText().toString();
                        String nextofKinContact =ETnextofKinContact.getText().toString();


                        MaternalProfileModel details = new MaternalProfileModel(nameOfInstitution,mflNo,ancNo,pncNo,nameOfClient,age,gravida,parity,height,weight,lmp,
                                edd,maritalStatus,address,telephone,education,nextOfKin,relationship,nextofKinContact);

                        Map<String, Object> item = new HashMap<>();
                        item.put("nameOfInstitution",nameOfInstitution);
                        item.put("mflNo",mflNo);
                        item.put("ancNo",ancNo);
                        item.put("pncNo",pncNo);
                        item.put("nameOfClient",nameOfClient);
                        item.put("age",age);
                        item.put("gravida",gravida);
                        item.put("parity",parity);
                        item.put("height",height);
                        item.put("weight",weight);
                        item.put("lmp",lmp);
                        item.put("edd",edd);
                        item.put("maritalStatus",maritalStatus);
                        item.put("address",address);
                        item.put("telephone",telephone);
                        item.put("education",education);
                        item.put("nextOfKin",nextOfKin);
                        item.put("relationship",relationship);
                        item.put("nextofKinContact",nextofKinContact);


                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(MaternalProfile.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(MaternalProfile.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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