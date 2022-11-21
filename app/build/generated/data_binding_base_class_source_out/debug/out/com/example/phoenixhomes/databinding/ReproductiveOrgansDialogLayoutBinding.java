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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ReproductiveOrgansDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cardDoctor;

  @NonNull
  public final TextView dateHolder5;

  @NonNull
  public final Spinner examinationSpinner;

  @NonNull
  public final Spinner resultsSpinner;

  @NonNull
  public final AppCompatButton submit;

  @NonNull
  public final Spinner testSpinner;

  @NonNull
  public final Spinner treatmentSpinner;

  private ReproductiveOrgansDialogLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull CardView cardDoctor, @NonNull TextView dateHolder5,
      @NonNull Spinner examinationSpinner, @NonNull Spinner resultsSpinner,
      @NonNull AppCompatButton submit, @NonNull Spinner testSpinner,
      @NonNull Spinner treatmentSpinner) {
    this.rootView = rootView;
    this.cardDoctor = cardDoctor;
    this.dateHolder5 = dateHolder5;
    this.examinationSpinner = examinationSpinner;
    this.resultsSpinner = resultsSpinner;
    this.submit = submit;
    this.testSpinner = testSpinner;
    this.treatmentSpinner = treatmentSpinner;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ReproductiveOrgansDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ReproductiveOrgansDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.reproductive_organs_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ReproductiveOrgansDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_doctor;
      CardView cardDoctor = ViewBindings.findChildViewById(rootView, id);
      if (cardDoctor == null) {
        break missingId;
      }

      id = R.id.dateHolder5;
      TextView dateHolder5 = ViewBindings.findChildViewById(rootView, id);
      if (dateHolder5 == null) {
        break missingId;
      }

      id = R.id.examinationSpinner;
      Spinner examinationSpinner = ViewBindings.findChildViewById(rootView, id);
      if (examinationSpinner == null) {
        break missingId;
      }

      id = R.id.resultsSpinner;
      Spinner resultsSpinner = ViewBindings.findChildViewById(rootView, id);
      if (resultsSpinner == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      id = R.id.testSpinner;
      Spinner testSpinner = ViewBindings.findChildViewById(rootView, id);
      if (testSpinner == null) {
        break missingId;
      }

      id = R.id.treatmentSpinner;
      Spinner treatmentSpinner = ViewBindings.findChildViewById(rootView, id);
      if (treatmentSpinner == null) {
        break missingId;
      }

      return new ReproductiveOrgansDialogLayoutBinding((LinearLayout) rootView, cardDoctor,
          dateHolder5, examinationSpinner, resultsSpinner, submit, testSpinner, treatmentSpinner);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
