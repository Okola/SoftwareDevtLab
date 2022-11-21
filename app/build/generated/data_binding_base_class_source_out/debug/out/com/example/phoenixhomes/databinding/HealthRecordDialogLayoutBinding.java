// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

public final class HealthRecordDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final EditText datteHolder1;

  @NonNull
  public final EditText facilityHolder1;

  @NonNull
  public final EditText facilityListHolder1;

  @NonNull
  public final EditText healthfacilityHolder1;

  @NonNull
  public final EditText notificationNoHolder1;

  @NonNull
  public final EditText registerNoHolder1;

  @NonNull
  public final AppCompatButton submit;

  @NonNull
  public final EditText welfareHolder1;

  private HealthRecordDialogLayoutBinding(@NonNull CardView rootView,
      @NonNull EditText datteHolder1, @NonNull EditText facilityHolder1,
      @NonNull EditText facilityListHolder1, @NonNull EditText healthfacilityHolder1,
      @NonNull EditText notificationNoHolder1, @NonNull EditText registerNoHolder1,
      @NonNull AppCompatButton submit, @NonNull EditText welfareHolder1) {
    this.rootView = rootView;
    this.datteHolder1 = datteHolder1;
    this.facilityHolder1 = facilityHolder1;
    this.facilityListHolder1 = facilityListHolder1;
    this.healthfacilityHolder1 = healthfacilityHolder1;
    this.notificationNoHolder1 = notificationNoHolder1;
    this.registerNoHolder1 = registerNoHolder1;
    this.submit = submit;
    this.welfareHolder1 = welfareHolder1;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static HealthRecordDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static HealthRecordDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.health_record_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static HealthRecordDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.datteHolder1;
      EditText datteHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (datteHolder1 == null) {
        break missingId;
      }

      id = R.id.facilityHolder1;
      EditText facilityHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (facilityHolder1 == null) {
        break missingId;
      }

      id = R.id.facilityListHolder1;
      EditText facilityListHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (facilityListHolder1 == null) {
        break missingId;
      }

      id = R.id.healthfacilityHolder1;
      EditText healthfacilityHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (healthfacilityHolder1 == null) {
        break missingId;
      }

      id = R.id.notificationNoHolder1;
      EditText notificationNoHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (notificationNoHolder1 == null) {
        break missingId;
      }

      id = R.id.registerNoHolder1;
      EditText registerNoHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (registerNoHolder1 == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      id = R.id.welfareHolder1;
      EditText welfareHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (welfareHolder1 == null) {
        break missingId;
      }

      return new HealthRecordDialogLayoutBinding((CardView) rootView, datteHolder1, facilityHolder1,
          facilityListHolder1, healthfacilityHolder1, notificationNoHolder1, registerNoHolder1,
          submit, welfareHolder1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}