package com.example.phoenixhomes.classes;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.adapters.ReproductiveOrgansAdapter;
import com.example.phoenixhomes.databinding.ActivityReproductiveOrgansBinding;
import com.example.phoenixhomes.models.ReproductiveOrgansModel;
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

public class ReproductiveOrgans extends DrawerBaseActivity implements AdapterView.OnItemSelectedListener{

    ReproductiveOrgansAdapter adapter;
    ArrayList<ReproductiveOrgansModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityReproductiveOrgansBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductive_organs);

        a =   ActivityReproductiveOrgansBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Reproductive Organs Examination");

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


        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Reproductive Organs Screening").push();
        String id = ref.getKey();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Reproductive Organs Screening");


        recyclerView = findViewById(R.id.reproductiveRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new ReproductiveOrgansAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    ReproductiveOrgansModel details = ds.getValue(ReproductiveOrgansModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.reproductive_organs_dialog_layout))
                        .setExpanded(true,800)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                TextView ETdate2;
                Spinner examinationSpinner,testSpinener,resultsSpinner,treatmentSpinner;

                examinationSpinner = findViewById(R.id.examinationSpinner);

                String[] examination;
                examination = getResources().getStringArray(R.array.Examination);
                examinationSpinner.setOnItemSelectedListener(ReproductiveOrgans.this);
                ArrayAdapter<String> ad = new ArrayAdapter<>(ReproductiveOrgans.this, android.R.layout.simple_spinner_item, examination);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                examinationSpinner.setAdapter(ad);

                testSpinener = findViewById(R.id.testSpinner);
                String[] tests;
                tests = getResources().getStringArray(R.array.Test);
                testSpinener.setOnItemSelectedListener(ReproductiveOrgans.this);
                ArrayAdapter<String> ad2 = new ArrayAdapter<>(ReproductiveOrgans.this, android.R.layout.simple_spinner_item, tests);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                testSpinener.setAdapter(ad2);

                resultsSpinner = findViewById(R.id.resultsSpinner);
                String[] results;
                results = getResources().getStringArray(R.array.Results);
                resultsSpinner.setOnItemSelectedListener(ReproductiveOrgans.this);
                ArrayAdapter<String> ad3 = new ArrayAdapter<>(ReproductiveOrgans.this, android.R.layout.simple_spinner_item, results);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                resultsSpinner.setAdapter(ad3);

                treatmentSpinner = findViewById(R.id.treatmentSpinner);
                String[] treatment;
                treatment = getResources().getStringArray(R.array.Treatment);
                treatmentSpinner.setOnItemSelectedListener(ReproductiveOrgans.this);
                ArrayAdapter<String> ad4 = new ArrayAdapter<>(ReproductiveOrgans.this, android.R.layout.simple_spinner_item, treatment);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                treatmentSpinner.setAdapter(ad4);



                ETdate2 = findViewById(R.id.dateHolder5);


                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                ETdate2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(ReproductiveOrgans.this,
                                R.style.my_dialog_theme,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                        Calendar mCalendar = Calendar.getInstance();
                                        mCalendar.set(Calendar.YEAR, year);
                                        mCalendar.set(Calendar.MONTH, month);
                                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
                                        ETdate2.setText(selectedDate);
                                    }
                                }, year, month, day);
                        dialog.show();
                    }
                });





                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String examination = examinationSpinner.getSelectedItem().toString();
                        String test = testSpinener.getSelectedItem().toString();
                        String results = resultsSpinner.getSelectedItem().toString();
                        String treatment = treatmentSpinner.getSelectedItem().toString();
                        String date = ETdate2.getText().toString();

                        ReproductiveOrgansModel details = new ReproductiveOrgansModel(date, examination, test, results, treatment);

                        Map<String, Object> item = new HashMap<>();
                        item.put("examination",examination);
                        item.put("test", test);
                        item.put("results", results);
                        item.put("treatment",treatment);
                        item.put("date",date);


                        ref.setValue(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(ReproductiveOrgans.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(ReproductiveOrgans.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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