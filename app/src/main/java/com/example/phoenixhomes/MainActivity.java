package com.example.phoenixhomes;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixhomes.databinding.ActivityMainBinding;
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


public class MainActivity extends DrawerBaseActivity implements AdapterView.OnItemSelectedListener, RecyclerViewInterface {

    ActivityMainBinding activityMainBinding;
    PregnancyOrderAdapter adapter;
    ArrayList<PregnancyOrderModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setTitle("Home");


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();

        db = FirebaseDatabase.getInstance();


        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").push();
        String id = reference.getKey();

        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order");


        recyclerView = findViewById(R.id.pregnancyOrderRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new PregnancyOrderAdapter(this, list,  this);
        ref.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    PregnancyOrderModel details = ds.getValue(PregnancyOrderModel.class);
                    list.add(details);

                }

                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        Button addChild = (Button) findViewById(R.id.addOrder);
        addChild.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.pregnancy_order_layout_dialog))
                        .setExpanded(true,600)
                        .create();
                View myView = dialogPlus.getHolderView();
                TextView selectDate;
                dialogPlus.show();

                EditText ETOrder;

                ETOrder =  findViewById(R.id.orderOfPregnancy);

                selectDate = findViewById(R.id.dateofFirstVisit33);
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                selectDate.setOnClickListener(new View.OnClickListener() {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
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



                Button submit = (Button) findViewById(R.id.submit66);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String order = ETOrder.getText().toString();
                        String date = selectDate.getText().toString();
                        String id = reference.getKey();


                        if(order.isEmpty()){
                            ETOrder.setError("Order is required");

                            return;
                        }
                        else if(date.isEmpty()){
                            Toast.makeText(MainActivity.this, "please select a date of first visit to hospital", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{

                            addDataToFirebase(order,date,id);


                        }
                        dialogPlus.dismiss();




                    }

                    private void addDataToFirebase(String order, String date, String id) {

                        PregnancyOrderModel details = new PregnancyOrderModel(order,date,id);

                        Map<String, Object> item = new HashMap<>();
                        item.put("Pregnancy order",order);
                        item.put("dateOfClinicVisit", date);
                        item.put("Order Id", id);

                        reference.setValue(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(MainActivity.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }


                });


            }


        });




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

        Intent intent = new Intent(MainActivity.this, MotherChildCareHome.class);
        intent.putExtra("orderId", list.get(position).getId());

        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
