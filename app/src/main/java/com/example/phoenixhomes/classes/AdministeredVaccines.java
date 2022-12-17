package com.example.phoenixhomes.classes;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.adapters.VaccinesAdapter;
import com.example.phoenixhomes.databinding.ActivityAdministeredVaccinesBinding;
import com.example.phoenixhomes.models.Vaccines;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
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
import java.util.Objects;

public class AdministeredVaccines extends DrawerBaseActivity implements AdapterView.OnItemSelectedListener {


    public DrawerLayout drawerLayout;
    VaccinesAdapter adapter;
    ArrayList<Vaccines> vaccineList;
    FirebaseDatabase db;
    DatabaseReference reference;
    RecyclerView recyclerView;
    FirebaseDatabase database;
    Vaccines vaccines;
    String childId;
    Button save;

    //creating the binding variable
    ActivityAdministeredVaccinesBinding progressReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administered_vaccines);

        //initializing the binding variable to get inflater layout for the drawer
        progressReport = ActivityAdministeredVaccinesBinding.inflate(getLayoutInflater());
        setContentView(progressReport.getRoot());

        setTitle("Administered Vaccines");

        String orderId = "orderId";
        String childId = "childId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");
            childId = extras.getString("childId");

        }

        String finalOrderId = orderId;
        String finalChildId = childId;




        db = FirebaseDatabase.getInstance();
        reference = db.getReference().child("Users")
                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("Mother-Child-Handbook")
                .child("Pregnancy Order").child(finalOrderId).child("Child").child(finalChildId).child("vaccines");


        TextView updateDetails = findViewById(R.id.update);
        updateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.administered_vaccine_dialog_layout))
                        .setExpanded(true,800)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);


                TextView selectDate,selectDate2;
                selectDate = findViewById(R.id.select_vaccination_date);
                selectDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(AdministeredVaccines.this,
                                R.style.my_dialog_theme,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                        Calendar mCalendar = Calendar.getInstance();
                                        mCalendar.set(Calendar.YEAR, year);
                                        mCalendar.set(Calendar.MONTH, month);
                                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
                                        selectDate.setText(selectedDate);
                                    }
                                }, year, month, day);
                        dialog.show();
                    }
                });

                selectDate2 = findViewById(R.id.select_nextvaccination_date2);
                selectDate2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(AdministeredVaccines.this,
                                R.style.my_dialog_theme,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                                        Calendar mCalendar = Calendar.getInstance();
                                        mCalendar.set(Calendar.YEAR, year);
                                        mCalendar.set(Calendar.MONTH, month);
                                        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
                                        selectDate2.setText(selectedDate);
                                    }
                                }, year, month, day);
                        dialog.show();
                    }
                });

                Spinner vaccineSpinner, doseSpinner;
                vaccineSpinner = findViewById(R.id.select_administered_vaccine);
                doseSpinner = findViewById(R.id.select_administered_dosage);


                String[] vaccines;
                vaccines = getResources().getStringArray(R.array.Vaccines);
                vaccineSpinner.setOnItemSelectedListener(AdministeredVaccines.this);
                // Create the instance of ArrayAdapter having the gender
                ArrayAdapter ad = new ArrayAdapter(AdministeredVaccines.this, android.R.layout.simple_spinner_item, vaccines);


                // set simple layout resource file for each item of spinner
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Set the ArrayAdapter (ad) data on the Spinner which binds data to spinner
                vaccineSpinner.setAdapter(ad);


                String[] dose;
                dose = getResources().getStringArray(R.array.Dosage);

                doseSpinner.setOnItemSelectedListener(AdministeredVaccines.this);
                // Create the instance of ArrayAdapter having the gender
                ArrayAdapter ad2 = new ArrayAdapter(AdministeredVaccines.this, android.R.layout.simple_spinner_item, dose);


                // set simple layout resource file for each item of spinner
                ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Set the ArrayAdapter (ad) data on the Spinner which binds data to spinner
                doseSpinner.setAdapter(ad2);





                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String vaccine,dose,date,nextDate;

                        vaccine = vaccineSpinner.getSelectedItem().toString();
                        dose = doseSpinner.getSelectedItem().toString();
                        date = selectDate.getText().toString();
                        nextDate = selectDate2.getText().toString();

                        Vaccines details = new Vaccines(vaccine,dose,date,nextDate);

                        Map<String, Object> item = new HashMap<>();
                        item.put("vaccine",vaccine);
                        item.put("dose",dose);
                        item.put("date",date);
                        item.put("nextDate",nextDate);



                        reference.push().updateChildren(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(AdministeredVaccines.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(AdministeredVaccines.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });

        TextView setReminder = findViewById(R.id.setVaccinationReminder);
        setReminder.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {



                    //setting up calendar event
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                    intent.putExtra(Intent.EXTRA_EMAIL,"austojun07@gmail.com");/*TODO: use shared pref/bundles to get email*/

                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(AdministeredVaccines.this, "There is no app that can support this action",
                                Toast.LENGTH_SHORT).show();
                    }

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
    protected void onStart() {
        super.onStart();

            recyclerView = findViewById(R.id.administeredVaccinesRecycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.scrollToPosition(0);
            recyclerView.setHasFixedSize(true);


            vaccineList = new ArrayList<>();
            adapter = new VaccinesAdapter(vaccineList, this);



        reference.addValueEventListener(new ValueEventListener() {

                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot dataSnapshot: snapshot.getChildren()){


                        Vaccines vaccine  = dataSnapshot.getValue(Vaccines.class);
                        assert vaccine != null;
                        vaccineList.add(vaccine);

                    }
                    adapter.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            recyclerView.setAdapter(adapter);
        }

    @Override
    public void onItemClick(int position) {

    }
}