package com.example.phoenixhomes;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.databinding.ActivityClinicalNotesBinding;
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

public class ClinicalNotes extends DrawerBaseActivity {

    ClinicalNotesAdapter adapter;
    ArrayList<ClinicalNotesModel> list;
    FirebaseDatabase db;
    DatabaseReference reference,ref;
    RecyclerView recyclerView;
    TextView updateDetails;
    ActivityClinicalNotesBinding a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinical_notes);

        a =   ActivityClinicalNotesBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Clinical Notes");


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


        ref = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Clinical Notes").push();
        String id = ref.getKey();

        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Clinical Notes");

        recyclerView = findViewById(R.id.clinicalNotesRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        list = new ArrayList<>();
        adapter = new ClinicalNotesAdapter(this, list);
        reference.addValueEventListener(new ValueEventListener() {

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot ds: snapshot.getChildren()){


                    ClinicalNotesModel details = ds.getValue(ClinicalNotesModel.class);
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
                        .setContentHolder(new ViewHolder(R.layout.clinical_notes_dialog_layout))
                        .setExpanded(true,900)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                TextView ETdate;
                EditText ETclinicalNotes;

                ETdate = findViewById(R.id.dateHolder6);
                ETclinicalNotes = findViewById(R.id.clinicalNote6);



                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                ETdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog = new DatePickerDialog(ClinicalNotes.this,
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



                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String date = ETdate.getText().toString();
                        String clinicalNotes = ETclinicalNotes.getText().toString();



                        ClinicalNotesModel details = new ClinicalNotesModel(date,clinicalNotes);

                        Map<String, Object> item = new HashMap<>();

                        item.put("date",date);
                        item.put("Note",clinicalNotes);

                        ref.setValue(details).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(ClinicalNotes.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(ClinicalNotes.this, "Something went wrong", Toast.LENGTH_SHORT).show();
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