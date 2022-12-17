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
import com.example.phoenixhomes.adapters.FerrousFumerateAdapter;
import com.example.phoenixhomes.adapters.PreventiveServiceAdapter;
import com.example.phoenixhomes.databinding.ActivityPreventiveServiceBinding;
import com.example.phoenixhomes.models.FerrousFumerateModel;
import com.example.phoenixhomes.models.PreventiveServiceModel;
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

public class PreventiveService extends DrawerBaseActivity implements AdapterView.OnItemSelectedListener{

    PreventiveServiceAdapter adapter;
    FerrousFumerateAdapter adapter1;
    ArrayList<PreventiveServiceModel> list;
    ArrayList<FerrousFumerateModel> list1;
    FirebaseDatabase db;
    DatabaseReference reference,ref,re,refer;
    RecyclerView recyclerView,rv;
    TextView updateDetails,updateDetails1;
    ActivityPreventiveServiceBinding a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive_service);

        a =  ActivityPreventiveServiceBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Preventive Services");

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


        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Preventive Service").push();
        String id = ref.getKey();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Preventive Service");

        re = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Ferrous Fumerate").push();
        refer = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Ferrous Fumerate");


        prevetiveRecycler();



        updateDetails = findViewById(R.id.updatematernalprofile);
        updateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.preventive_service_dialog_layout))
                        .setExpanded(true,600)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                TextView ETdate,ETnextVisit;
                Spinner medicineSpinner;

                ETdate = findViewById(R.id.dateHolderr1);
                ETnextVisit = findViewById(R.id.nextVisitHolder1);
                medicineSpinner = findViewById(R.id.medicineSpinner);

                String[] medicines;
                medicines = getResources().getStringArray(R.array.Medicine);
                medicineSpinner.setOnItemSelectedListener(PreventiveService.this);
                ArrayAdapter ad = new ArrayAdapter(PreventiveService.this, android.R.layout.simple_spinner_item, medicines);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                medicineSpinner.setAdapter(ad);


                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                ETdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(PreventiveService.this,
                                R.style.my_dialog_theme,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                        Calendar mCalendar = Calendar.getInstance();
                                        mCalendar.set(Calendar.YEAR, year);
                                        mCalendar.set(Calendar.MONTH, month);
                                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
                                        ETdate.setText(selectedDate);
                                    }
                                }, year, month, day);
                        dialog.show();
                    }
                });

                ETnextVisit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(PreventiveService.this,
                                R.style.my_dialog_theme,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                        Calendar mCalendar = Calendar.getInstance();
                                        mCalendar.set(Calendar.YEAR, year);
                                        mCalendar.set(Calendar.MONTH, month);
                                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
                                        ETnextVisit.setText(selectedDate);
                                    }
                                }, year, month, day);
                        dialog.show();
                    }
                });






                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String date = ETdate.getText().toString();
                        String nextVisit = ETnextVisit.getText().toString();
                        String medicine = medicineSpinner.getSelectedItem().toString();



                        PreventiveServiceModel details = new PreventiveServiceModel(medicine,date,nextVisit);

                        Map<String, Object> item = new HashMap<>();
                        item.put("medicine",medicine);
                        item.put("date",date);
                        item.put("nextVisit",nextVisit);

                        ref.setValue(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PreventiveService.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PreventiveService.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });

        ferrousRecycler();







        updateDetails1 = findViewById(R.id.updatematernalprofile1);
        updateDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.ferrous_fumerate_dialog_layout))
                        .setExpanded(true,600)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                TextView ETdate2;
                Spinner orderSpinner,weeksSpinener,tabletsSpinner;

                orderSpinner = findViewById(R.id.visitOrderSpinner);

                String[] order;
                order = getResources().getStringArray(R.array.visitOrder);
                orderSpinner.setOnItemSelectedListener(PreventiveService.this);
                ArrayAdapter ad = new ArrayAdapter(PreventiveService.this, android.R.layout.simple_spinner_item, order);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                orderSpinner.setAdapter(ad);

                weeksSpinener = findViewById(R.id.weeksSpinner);
                String[] weeks;
                weeks = getResources().getStringArray(R.array.Weeks);
                weeksSpinener.setOnItemSelectedListener(PreventiveService.this);
                ArrayAdapter ad2 = new ArrayAdapter(PreventiveService.this, android.R.layout.simple_spinner_item, weeks);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                weeksSpinener.setAdapter(ad2);

                tabletsSpinner = findViewById(R.id.tabletsSpinner);
                String[] tablets;
                tablets = getResources().getStringArray(R.array.Tablets);
                tabletsSpinner.setOnItemSelectedListener(PreventiveService.this);
                ArrayAdapter ad3 = new ArrayAdapter(PreventiveService.this, android.R.layout.simple_spinner_item, tablets);
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                tabletsSpinner.setAdapter(ad3);



                ETdate2 = findViewById(R.id.dateHolderr2);


                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                ETdate2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(PreventiveService.this,
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





                Button submit2 = findViewById(R.id.submit1);
                submit2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String order = orderSpinner.getSelectedItem().toString();
                        String weeks = weeksSpinener.getSelectedItem().toString();
                        String tablets = tabletsSpinner.getSelectedItem().toString();
                        String date = ETdate2.getText().toString();
                        FerrousFumerateModel details = new FerrousFumerateModel(order,weeks,tablets,date);

                        Map<String, Object> item = new HashMap<>();
                        item.put("order",order);
                        item.put("weeks",weeks);
                        item.put("tablets",tablets);
                        item.put("date",date);


                        re.setValue(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(PreventiveService.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(PreventiveService.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });


    }

    private void prevetiveRecycler() {

        recyclerView = findViewById(R.id.preventiveServicesRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new PreventiveServiceAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    PreventiveServiceModel details = ds.getValue(PreventiveServiceModel.class);
                    list.add(details);

                }

                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ferrousRecycler() {


        rv = findViewById(R.id.ferrousRecycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        list1 = new ArrayList<>();
        adapter1 = new FerrousFumerateAdapter(this, list1);

        refer.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snap) {


                for(DataSnapshot s: snap.getChildren()){

                    FerrousFumerateModel d = s.getValue(FerrousFumerateModel.class);
                    list1.add(d);

                }

                adapter1.notifyDataSetChanged();
                rv.setAdapter(adapter1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
