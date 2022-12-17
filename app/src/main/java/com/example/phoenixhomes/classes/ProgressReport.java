package com.example.phoenixhomes.classes;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.databinding.ActivityProgressReportBinding;
import com.example.phoenixhomes.models.ProgressValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class ProgressReport extends DrawerBaseActivity {


    public DrawerLayout drawerLayout;

    //creating the binding variable
    ActivityProgressReportBinding progressReport;
    GraphView graphView;
    LineGraphSeries series;
    @SuppressLint("SimpleDateFormat")
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    EditText weight;
    Button save;
    FirebaseDatabase db;
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_report);
        //initializing the binding variable to get inflater layout for the drawer
        progressReport =  ActivityProgressReportBinding.inflate(getLayoutInflater());
        setContentView(progressReport.getRoot());
        setTitle("Progress Report");

        String childId = "childId";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            childId = extras.getString("childId");
        }

        weight = findViewById(R.id.Weight);
        save = findViewById(R.id.savebtn);


        db = FirebaseDatabase.getInstance();
        reference = db.getReference().child("Users")
                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .child("Child").child(childId).child("weight Progress");


        setListeners();



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
////        graphView.getGridLabelRenderer().setNumVerticalLabels(6);
//        graphView.getGridLabelRenderer().setHumanRounding(true);

//        graphView.getViewport().setScalableY(true);  // activate horizontal and vertical zooming and scrolling
//        graphView.getViewport().setScrollableY(true);  // activate vertical scrolling
//        graphView.getViewport().setXAxisBoundsManual(true);
//        graphView.getViewport().setMinX(3);
//        graphView.getViewport().setMaxX(6);
//        graphView.getViewport().setYAxisBoundsManual(true);
//        graphView.getViewport().setMinY(2);
//        graphView.getViewport().setMaxY(7);


    }

    private void setListeners() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = reference.push().getKey();
                long y = new Date().getTime();
                int x = Integer.parseInt(weight.getText().toString());


                ProgressValue progressValue = new ProgressValue(x,y);
                reference.child(id).setValue(progressValue);
            }
        });
    }
    protected void onStart(){
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataPoint[] dp = new DataPoint[(int)snapshot.getChildrenCount()];
                int index = 0;

                for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                    ProgressValue progressValue = dataSnapshot.getValue(ProgressValue.class);
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