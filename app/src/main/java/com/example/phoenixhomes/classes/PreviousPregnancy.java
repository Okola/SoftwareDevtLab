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
import com.example.phoenixhomes.adapters.PreviousPregnancyAdapter;
import com.example.phoenixhomes.databinding.ActivityPreviousPregnancyBinding;
import com.example.phoenixhomes.models.PreviousPregnancyModel;
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

public class PreviousPregnancy extends DrawerBaseActivity {

    PreviousPregnancyAdapter adapter;
    ArrayList<PreviousPregnancyModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityPreviousPregnancyBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_pregnancy);

        a =  ActivityPreviousPregnancyBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Previous Pregnancy");

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


        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Previous Pregnancies").push();

        String id = ref.getKey();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Previous Pregnancies");

        recyclerView = findViewById(R.id.previousPregnancyRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new PreviousPregnancyAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){

                    PreviousPregnancyModel details = ds.getValue(PreviousPregnancyModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.previous_pregnancy_dialog_layout))
                        .setExpanded(true,1200)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETorder,ETyear,ETancAttended,ETdeliveryPlace,ETmaturity,ETlabourDuration,
                        ETdeliveryType,ETbabyWeight,ETsex,EToutcome,ETpuerperium;


                ETorder = findViewById(R.id.pregnancyOrder1);
                ETyear = findViewById(R.id.year1);
                ETancAttended = findViewById(R.id.ancTimes1);
                ETdeliveryPlace = findViewById(R.id.placeofdelivery1);
                ETmaturity = findViewById(R.id.maturity1);
                ETlabourDuration = findViewById(R.id.labourDuration1);
                ETdeliveryType = findViewById(R.id.typeofdelivery1);
                ETbabyWeight = findViewById(R.id.birthweight1);
                ETsex = findViewById(R.id.sex1);
                EToutcome = findViewById(R.id.outcome1);
                ETpuerperium = findViewById(R.id.prueperium1);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String order =  ETorder.getText().toString();
                        String year = ETyear.getText().toString();
                        String ancAttended = ETancAttended.getText().toString();
                        String deliveryPlace = ETdeliveryPlace.getText().toString();
                        String maturity = ETmaturity.getText().toString();
                        String labourDuration = ETlabourDuration.getText().toString();
                        String deliveryType = ETdeliveryType.getText().toString();
                        String babyWeight = ETbabyWeight.getText().toString();
                        String sex = ETsex.getText().toString();
                        String outcome = EToutcome.getText().toString();
                        String puerperium = ETpuerperium.getText().toString();




                        PreviousPregnancyModel details = new PreviousPregnancyModel(order,year,ancAttended,deliveryPlace,maturity,labourDuration,deliveryType,babyWeight,sex,outcome,puerperium);

                        Map<String, Object> item = new HashMap<>();
                        item.put("order",order);
                        item.put("year",year);
                        item.put("ancAttended",ancAttended);
                        item.put("deliveryPlace",deliveryPlace);
                        item.put("maturity",maturity);
                        item.put("labourDuration",labourDuration);
                        item.put("deliveryType",deliveryType);
                        item.put("babyWeight",babyWeight);
                        item.put("sex",sex);
                        item.put("outcome",outcome);
                        item.put("puerperium",puerperium);


                        ref.setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PreviousPregnancy.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PreviousPregnancy.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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
