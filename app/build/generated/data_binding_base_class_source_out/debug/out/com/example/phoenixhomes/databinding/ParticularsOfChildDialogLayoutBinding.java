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

public final class ParticularsOfChildDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final EditText DOBHolder7;

  @NonNull
  public final EditText birthOrderHolder7;

  @NonNull
  public final EditText birthlengthHolder7;

  @NonNull
  public final EditText birthweightHolder7;

  @NonNull
  public final EditText childGenderHolder7;

  @NonNull
  public final EditText childNameHolder7;

  @NonNull
  public final EditText dateHolder7;

  @NonNull
  public final EditText gestationHolder7;

  @NonNull
  public final AppCompatButton submit;

  @NonNull
  public final EditText xticsHolder7;

  private ParticularsOfChildDialogLayoutBinding(@NonNull CardView rootView,
      @NonNull EditText DOBHolder7, @NonNull EditText birthOrderHolder7,
      @NonNull EditText birthlengthHolder7, @NonNull EditText birthweightHolder7,
      @NonNull EditText childGenderHolder7, @NonNull EditText childNameHolder7,
      @NonNull EditText dateHolder7, @NonNull EditText gestationHolder7,
      @NonNull AppCompatButton submit, @NonNull EditText xticsHolder7) {
    this.rootView = rootView;
    this.DOBHolder7 = DOBHolder7;
    this.birthOrderHolder7 = birthOrderHolder7;
    this.birthlengthHolder7 = birthlengthHolder7;
    this.birthweightHolder7 = birthweightHolder7;
    this.childGenderHolder7 = childGenderHolder7;
    this.childNameHolder7 = childNameHolder7;
    this.dateHolder7 = dateHolder7;
    this.gestationHolder7 = gestationHolder7;
    this.submit = submit;
    this.xticsHolder7 = xticsHolder7;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ParticularsOfChildDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ParticularsOfChildDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.particulars_of_child_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ParticularsOfChildDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.DOBHolder7;
      EditText DOBHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (DOBHolder7 == null) {
        break missingId;
      }

      id = R.id.birthOrderHolder7;
      EditText birthOrderHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (birthOrderHolder7 == null) {
        break missingId;
      }

      id = R.id.birthlengthHolder7;
      EditText birthlengthHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (birthlengthHolder7 == null) {
        break missingId;
      }

      id = R.id.birthweightHolder7;
      EditText birthweightHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (birthweightHolder7 == null) {
        break missingId;
      }

      id = R.id.childGenderHolder7;
      EditText childGenderHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (childGenderHolder7 == null) {
        break missingId;
      }

      id = R.id.childNameHolder7;
      EditText childNameHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (childNameHolder7 == null) {
        break missingId;
      }

      id = R.id.dateHolder7;
      EditText dateHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (dateHolder7 == null) {
        break missingId;
      }

      id = R.id.gestationHolder7;
      EditText gestationHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (gestationHolder7 == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      id = R.id.xticsHolder7;
      EditText xticsHolder7 = ViewBindings.findChildViewById(rootView, id);
      if (xticsHolder7 == null) {
        break missingId;
      }

      return new ParticularsOfChildDialogLayoutBinding((CardView) rootView, DOBHolder7,
          birthOrderHolder7, birthlengthHolder7, birthweightHolder7, childGenderHolder7,
          childNameHolder7, dateHolder7, gestationHolder7, submit, xticsHolder7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
