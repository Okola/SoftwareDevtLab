package com.example.phoenixhomes.classes;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.databinding.ActivityWeightGainBinding;
import com.example.phoenixhomes.models.WeightGainModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class WeightGain extends DrawerBaseActivity {

    GraphView graphView;
    LineGraphSeries series;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    EditText weight;
    TextView updateDetails;
    Button save;
    FirebaseDatabase db;
    DatabaseReference reference;
    ActivityWeightGainBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_gain);

        a =  ActivityWeightGainBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        setTitle("Weight Progress Chart");


        weight = findViewById(R.id.Weight);
        save = findViewById(R.id.savebtn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        String currentUserId = user.getUid();


        String orderId = "orderId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            orderId = extras.getString("orderId");

        }

        String finalOrderId = orderId;


        db = FirebaseDatabase.getInstance();
        reference = db.getReference().child("Users").child(currentUserId).child("Mother-Child-Handbook").child("Pregnancy Order").child(finalOrderId).child("Weight Gain");


        setListeners();

        updateDetails = findViewById(R.id.updatematernalprofile);
        updateDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(v.getContext())
                        .setContentHolder(new ViewHolder(R.layout.weight_gain_dialog_layout))
                        .setExpanded(true,500)
                        .create();
                View myView = dialogPlus.getHolderView();
                dialogPlus.show();

                EditText ETweight = findViewById(R.id.Weight);


                Button submit = findViewById(R.id.submit);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        float yValue = Float.parseFloat(ETweight.getText().toString());
                        long xValue = new Date().getTime();

                        SharedPreferences sharedPref = WeightGain.this.getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putFloat("xValue", xValue);
                        editor.apply();


                        WeightGainModel details = new WeightGainModel(yValue, xValue);

                        Map<String, Object> item = new HashMap<>();
                        item.put("xValue",xValue);
                        item.put("yValue",yValue);


                        reference.push().setValue(item).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                dialogPlus.dismiss();
                                Toast.makeText(WeightGain.this, "Details Added Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                dialogPlus.dismiss();
                                Toast.makeText(WeightGain.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                });





            }
        });



        graphView = findViewById(R.id.idGraphView);
        series = new LineGraphSeries();
        graphView.addSeries(series);

        graphView.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX){
                    return sdf.format(new Date((long)value));
                }
                else{

                    return super.formatLabel(value, isValueX);
                }

            }
        });



        graphView.getGridLabelRenderer().setNumHorizontalLabels(3);
        graphView.getGridLabelRenderer().setHorizontalLabelsAngle(135);
        graphView.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
        graphView.getViewport().setScrollable(true);  // activate horizontal scrolling
//
//
//
//        graphView.getGridLabelRenderer().setNumHorizontalLabels(3);
//        graphView.getGridLabelRenderer().setHorizontalLabelsAngle(135);
//        graphView.getGridLabelRenderer().setHumanRounding(true);
//        graphView.getGridLabelRenderer().setNumVerticalLabels(6);
//
//        graphView.getViewport().setScalable(true);  // activate horizontal zooming and scrolling
//        graphView.getViewport().setScrollable(true);  // activate horizontal scrolling
//        graphView.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
//        graphView.getViewport().setScrollableY(true);  // activate vertical scrolling
//        graphView.getViewport().setXAxisBoundsManual(true);
//        graphView.getViewport().setMinX(3);
//        graphView.getViewport().setMaxX(6);
//        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setMinY(20);
        graphView.getViewport().setMaxY(150);


    }

    private void setListeners() {



        SharedPreferences sharedPref = WeightGain.this.getPreferences(Context.MODE_PRIVATE);
        Float xAxis = sharedPref.getFloat("xValue", (float) 1.1);

        float x = xAxis;
        long y = new Date().getTime();




    }
    protected void onStart(){
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[] dp = new DataPoint[(int)snapshot.getChildrenCount()];
                int index = 0;

                for(DataSnapshot ds: snapshot.getChildren()){

                    WeightGainModel progressValue = ds.getValue(WeightGainModel.class);
                    assert progressValue != null;
                    dp[index] = new DataPoint(progressValue.getxValue(), progressValue.getyValue());
                    index++;
                }
                series.resetData(dp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void onItemClick(int position) {

    }
}
