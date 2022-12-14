// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public final class FamilyPlanningDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText clinicalNote7;

  @NonNull
  public final TextView dateHolder7;

  @NonNull
  public final TextView nextVisitHolder7;

  @NonNull
  public final AppCompatButton submit;

  private FamilyPlanningDialogLayoutBinding(@NonNull LinearLayout rootView,
      @NonNull EditText clinicalNote7, @NonNull TextView dateHolder7,
      @NonNull TextView nextVisitHolder7, @NonNull AppCompatButton submit) {
    this.rootView = rootView;
    this.clinicalNote7 = clinicalNote7;
    this.dateHolder7 = dateHolder7;
    this.nextVisitHolder7 = nextVisitHolder7;
    this.submit = submit;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FamilyPlanningDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FamilyPlanningDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.family_planning_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FamilyPlanningDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.clinicalNote7;
      EditText clinicalNote7 = ViewBindings.findChildViewById(rootView, id);
      if (clinicalNote7 == null) {
        break missingId;
      }

      id = R.id.dateHolder7;
      TextView dateHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (dateHolder7 == null) {
        break missingId;
      }

      id = R.id.nextVisitHolder7;
      TextView nextVisitHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (nextVisitHolder7 == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      return new FamilyPlanningDialogLayoutBinding((LinearLayout) rootView, clinicalNote7,
          dateHolder7, nextVisitHolder7, submit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
