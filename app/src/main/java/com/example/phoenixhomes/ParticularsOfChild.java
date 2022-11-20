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

import com.example.phoenixhomes.databinding.ActivityParticularsOfChildBinding;
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

public class ParticularsOfChild extends DrawerBaseActivity {

    ParticularsOfChildAdapter adapter;
    ArrayList<ParticularsOfChildModel> list;
    FirebaseDatabase db;
    DatabaseReference ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityParticularsOfChildBinding a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particulars_of_child);

        setTitle("Child Details");

        a =   ActivityParticularsOfChildBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();

        String childId = "childId";
        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");
            childId = extras.getString("childId");

        }


        String finalOrderId = orderId;

        String finalChildId = childId;



        db = FirebaseDatabase.getInstance();

        ref = db.getReference().child("Users")
                .child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order")
                .child(finalOrderId).child("Child").child(finalChildId).child("Particulars of Child");


        recyclerView = findViewById(R.id.particularsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new ParticularsOfChildAdapter(this, list);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    list.clear();
                    ParticularsOfChildModel details = snapshot.getValue(ParticularsOfChildModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.particulars_of_child_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETname, ETsex, ETdateOfBirth, ETgestation, ETbirthWeight, ETbirthlenght, ETotherCharacteristics, ETorder, ETdateFirstSeen;



                ETname = findViewById(R.id.childNameHolder7);
                ETsex = findViewById(R.id.childGenderHolder7);
                ETdateOfBirth = findViewById(R.id.DOBHolder7);
                ETgestation = findViewById(R.id.gestationHolder7);
                ETbirthWeight = findViewById(R.id.birthweightHolder7);
                ETbirthlenght = findViewById(R.id.birthlengthHolder7);
                ETotherCharacteristics = findViewById(R.id.xticsHolder7);
                ETorder = findViewById(R.id.birthOrderHolder7);
                ETdateFirstSeen = findViewById(R.id.dateHolder7);
                

                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String name, sex, dateOfBirth, gestation, birthWeight, birthlenght, otherCharacteristics, order, dateFirstSeen;

                        name = ETname.getText().toString();
                        sex =ETsex.getText().toString();
                        dateOfBirth = ETdateOfBirth.getText().toString();
                        gestation = ETgestation.getText().toString();
                        birthWeight = ETbirthWeight.getText().toString();
                        birthlenght = ETbirthlenght.getText().toString();
                        otherCharacteristics = ETotherCharacteristics.getText().toString();
                        order = ETorder.getText().toString();
                        dateFirstSeen = ETdateFirstSeen.getText().toString();


                        ParticularsOfChildModel details = new ParticularsOfChildModel(name, sex, dateOfBirth, gestation, birthWeight, birthlenght, otherCharacteristics, order, dateFirstSeen);

                        Map<String, Object> item = new HashMap<>();
                        item.put("name",name);
                        item.put("sex",sex);
                        item.put("dateOfBirth",dateOfBirth);
                        item.put("gestation",gestation);
                        item.put("birthWeight",birthWeight);
                        item.put("birthlenght",birthlenght);
                        item.put("otherCharacteristics",otherCharacteristics);
                        item.put("order",order);
                        item.put("dateFirstSeen",dateFirstSeen);


                        ref.updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(ParticularsOfChild.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(ParticularsOfChild.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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