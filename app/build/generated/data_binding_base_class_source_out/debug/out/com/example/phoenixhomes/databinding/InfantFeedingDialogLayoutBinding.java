// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class InfantFeedingDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText counsellingDoneHolder1;

  @NonNull
  public final EditText counsellingOnBreastFeedingHolder1;

  @NonNull
  public final AppCompatButton submit;

  private InfantFeedingDialogLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull EditText counsellingDoneHolder1, @NonNull EditText counsellingOnBreastFeedingHolder1,
      @NonNull AppCompatButton submit) {
    this.rootView = rootView;
    this.counsellingDoneHolder1 = counsellingDoneHolder1;
    this.counsellingOnBreastFeedingHolder1 = counsellingOnBreastFeedingHolder1;
    this.submit = submit;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static InfantFeedingDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static InfantFeedingDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.infant_feeding_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static InfantFeedingDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.counsellingDoneHolder1;
      EditText counsellingDoneHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (counsellingDoneHolder1 == null) {
        break missingId;
      }

      id = R.id.counsellingOnBreastFeedingHolder1;
      EditText counsellingOnBreastFeedingHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (counsellingOnBreastFeedingHolder1 == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      return new InfantFeedingDialogLayoutBinding((LinearLayout) rootView, counsellingDoneHolder1,
          counsellingOnBreastFeedingHolder1, submit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}