package com.example.phoenixhomes;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.databinding.ActivitySelectChildBinding;
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

public class selectChild extends DrawerBaseActivity implements AdapterView.OnItemSelectedListener, RecyclerViewInterface {

    //creating the binding variable
    ActivitySelectChildBinding selectChildBinding;


    Spinner genderSpinner;
    ChildListAdapter adapter;
    ArrayList<Child> childList;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_child);
        setTitle("Children");

        selectChildBinding =  ActivitySelectChildBinding.inflate(getLayoutInflater());
        setContentView(selectChildBinding.getRoot());

        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            orderId = extras.getString("orderId");

        }

        String finalOrderId = orderId;

        SharedPreferences sharedPref = selectChild.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("finId", finalOrderId);
        editor.apply();






        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        db = FirebaseDatabase.getInstance();
        reference = db.getReference().child("Users")
                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Child");
        ref = db.getReference().child("Users")
                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Child").push();

        recyclerView = findViewById(R.id.childRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        childList = new ArrayList<>();
        adapter = new ChildListAdapter(this,childList, (RecyclerViewInterface) this);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){


                    Child child = dataSnapshot.getValue(Child.class);
                    childList.add(child);
                }

                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        Button addChild = (Button) findViewById(R.id.addChild);
        addChild.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialog_child_details))
                        .setExpanded(true,1300)
                        .create();
                View myView = dialogPlus.getHolderView();
                TextView selectDate;
                dialogPlus.show();

                EditText editTextChildName = (EditText) findViewById(R.id.childName);

                selectDate = findViewById(R.id.select_date);
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                selectDate.setOnClickListener(new View.OnClickListener() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(selectChild.this,
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


                genderSpinner = (Spinner) findViewById(R.id.select_gender);
                spinner();

                Button submit = (Button) findViewById(R.id.usubmit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String nameOfChild = editTextChildName.getText().toString();
                        String dateOfBirth = selectDate.getText().toString();
                        String gender = genderSpinner.getSelectedItem().toString();
                        String id = ref.getKey();


                        if(nameOfChild.isEmpty()){
                            editTextChildName.setError("Child Name is required");

                            return;
                        }
                        else if(dateOfBirth.isEmpty()){
                            Toast.makeText(selectChild.this, "please select a date of birth", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(gender.isEmpty()) {
                            Toast.makeText(selectChild.this, "please choose a gender", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{

                            addDataToFirebase(nameOfChild,dateOfBirth,gender,id);


                        }
                        dialogPlus.dismiss();




                    }

                    private void addDataToFirebase(String nameOfChild, String dateOfBirth, String gender, String id) {
                        Child childDetails = new Child();

                        Map<String, Object> item = new HashMap<>();
                        item.put("nameOfChild",nameOfChild);
                        item.put("dateOfBirth",dateOfBirth);
                        item.put("gender",gender);
                        item.put("id",id);


                        ref.setValue(item);
                        Toast.makeText(selectChild.this, "Child added", Toast.LENGTH_SHORT).show();

                    }

                });


            }


        });




    }

    private void spinner() {

        //list for spinner
        String[] genders;
        genders = getResources().getStringArray(R.array.gender);

        genderSpinner.setOnItemSelectedListener(this);
        // Create the instance of ArrayAdapter having the gender
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, genders);


        // set simple layout resource file for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the Spinner which binds data to spinner
        genderSpinner.setAdapter(ad);
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
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onItemClick(int position) {

        SharedPreferences sharedPref = selectChild.this.getPreferences(Context.MODE_PRIVATE);
        String finalOrderId = sharedPref.getString("finId", "");





        Intent intent = new Intent(selectChild.this, ChildMonitoring.class);
        intent.putExtra("nameOfChild", childList.get(position).getNameOfChild());
        intent.putExtra("childId", childList.get(position).getId());
        intent.putExtra("orderId", finalOrderId);




        startActivity(intent);

    }

}