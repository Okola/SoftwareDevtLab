package com.example.phoenixhomes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phoenixhomes.R;
import com.example.phoenixhomes.models.MotherPostNatalExaminationModel;

import java.util.ArrayList;

public class MotherPostNatalExaminationAdapter extends RecyclerView.Adapter<MotherPostNatalExaminationAdapter.MyViewHolder> {

    Context context;
    ArrayList<MotherPostNatalExaminationModel> list;

    public MotherPostNatalExaminationAdapter(Context context, ArrayList<MotherPostNatalExaminationModel> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.mother_postnatal_examination_layout, parent, false);
        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MotherPostNatalExaminationModel MotherPostNatalExaminationModel = list.get(position);


        holder.timingOfVisit.setText(list.get(position).getTimingOfVisit());
        holder.date.setText(list.get(position).getDate());
        holder.bloodPressure.setText(list.get(position).getBloodPressure());
        holder.temp.setText(list.get(position).getTemp());
        holder.pulse.setText(list.get(position).getPulse());
        holder.respiratoryRate.setText(list.get(position).getRespiratoryRate());
        holder.generalCondition.setText(list.get(position).getGeneralCondition());
        holder.breast.setText(list.get(position).getBreast());
        holder.csScar.setText(list.get(position).getCsScar());
        holder.involutionOfUterus.setText(list.get(position).getInvolutionOfUterus());
        holder.conditionOfEspisotomy.setText(list.get(position).getConditionOfEspisotomy());
        holder.lochia.setText(list.get(position).getLochia());
        holder.pelvicExam.setText(list.get(position).getPelvicExam());
        holder.vaginalExamination.setText(list.get(position).getVaginalExamination());
        holder.haemoglobin.setText(list.get(position).getHaemoglobin());
        holder.hivStatus.setText(list.get(position).getHivStatus());
        holder.haart.setText(list.get(position).getHaart());
        holder.prophylaxis.setText(list.get(position).getProphylaxis());
        holder.hivretesting.setText(list.get(position).getHivretesting());
        holder.counselling.setText(list.get(position).getCounselling());
        holder.fp.setText(list.get(position).getFp());

        holder.setIsRecyclable(false);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView timingOfVisit, date, bloodPressure, temp, pulse, respiratoryRate, generalCondition, breast,
                csScar, involutionOfUterus, conditionOfEspisotomy, lochia, pelvicExam, vaginalExamination, haemoglobin,
                hivStatus, haart, prophylaxis, hivretesting, counselling, fp;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            timingOfVisit = itemView.findViewById(R.id.timeHolder);
            date = itemView.findViewById(R.id.dateHolder);
            bloodPressure = itemView.findViewById(R.id.bpHolder);
            temp = itemView.findViewById(R.id.TempHolder);
            pulse = itemView.findViewById(R.id.PulseHolder);
            respiratoryRate = itemView.findViewById(R.id. rrHolder);
            generalCondition = itemView.findViewById(R.id.gcHolder);
            breast = itemView.findViewById(R.id.BreastHolder);
            csScar = itemView.findViewById(R.id.cscscarHolder);
            involutionOfUterus = itemView.findViewById(R.id.uterusHolder);
            conditionOfEspisotomy = itemView.findViewById(R.id.espisiotomyHolder);
            lochia = itemView.findViewById(R.id.lochiaHolder);
            pelvicExam = itemView.findViewById(R.id.peHolder);
            vaginalExamination = itemView.findViewById(R.id.veHolder);
            haemoglobin = itemView.findViewById(R.id.HaemoglobinHolder);
            hivStatus = itemView.findViewById(R.id.hivStatusHolder);
            haart = itemView.findViewById(R.id.haartHolder);
            prophylaxis = itemView.findViewById(R.id.prophylaxisHolder);
            hivretesting = itemView.findViewById(R.id.hivRetestingHolder);
            counselling = itemView.findViewById(R.id.counsellingHolder);
            fp = itemView.findViewById(R.id.fpHolder);




        }



    }
}
