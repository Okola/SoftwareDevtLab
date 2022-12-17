// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdministeredVaccineDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Spinner selectAdministeredDosage;

  @NonNull
  public final Spinner selectAdministeredVaccine;

  @NonNull
  public final TextView selectNextvaccinationDate2;

  @NonNull
  public final TextView selectVaccinationDate;

  @NonNull
  public final AppCompatButton submit;

  private AdministeredVaccineDialogLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull Spinner selectAdministeredDosage, @NonNull Spinner selectAdministeredVaccine,
      @NonNull TextView selectNextvaccinationDate2, @NonNull TextView selectVaccinationDate,
      @NonNull AppCompatButton submit) {
    this.rootView = rootView;
    this.selectAdministeredDosage = selectAdministeredDosage;
    this.selectAdministeredVaccine = selectAdministeredVaccine;
    this.selectNextvaccinationDate2 = selectNextvaccinationDate2;
    this.selectVaccinationDate = selectVaccinationDate;
    this.submit = submit;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdministeredVaccineDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdministeredVaccineDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.administered_vaccine_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdministeredVaccineDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.select_administered_dosage;
      Spinner selectAdministeredDosage = ViewBindings.findChildViewById(rootView, id);
      if (selectAdministeredDosage == null) {
        break missingId;
      }

      id = R.id.select_administered_vaccine;
      Spinner selectAdministeredVaccine = ViewBindings.findChildViewById(rootView, id);
      if (selectAdministeredVaccine == null) {
        break missingId;
      }

      id = R.id.select_nextvaccination_date2;
      TextView selectNextvaccinationDate2 = ViewBindings.findChildViewById(rootView, id);
      if (selectNextvaccinationDate2 == null) {
        break missingId;
      }

      id = R.id.select_vaccination_date;
      TextView selectVaccinationDate = ViewBindings.findChildViewById(rootView, id);
      if (selectVaccinationDate == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      return new AdministeredVaccineDialogLayoutBinding((LinearLayout) rootView,
          selectAdministeredDosage, selectAdministeredVaccine, selectNextvaccinationDate2,
          selectVaccinationDate, submit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
