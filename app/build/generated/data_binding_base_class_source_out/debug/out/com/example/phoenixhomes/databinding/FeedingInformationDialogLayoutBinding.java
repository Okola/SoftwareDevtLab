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

public final class FeedingInformationDialogLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final EditText breastfeedingHolder1;

  @NonNull
  public final EditText complimentaryfoodHolder1;

  @NonNull
  public final EditText otherfeedsintroducedNoHolder1;

  @NonNull
  public final EditText retentionHolder1;

  @NonNull
  public final AppCompatButton submit;

  private FeedingInformationDialogLayoutBinding(@NonNull CardView rootView,
      @NonNull EditText breastfeedingHolder1, @NonNull EditText complimentaryfoodHolder1,
      @NonNull EditText otherfeedsintroducedNoHolder1, @NonNull EditText retentionHolder1,
      @NonNull AppCompatButton submit) {
    this.rootView = rootView;
    this.breastfeedingHolder1 = breastfeedingHolder1;
    this.complimentaryfoodHolder1 = complimentaryfoodHolder1;
    this.otherfeedsintroducedNoHolder1 = otherfeedsintroducedNoHolder1;
    this.retentionHolder1 = retentionHolder1;
    this.submit = submit;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static FeedingInformationDialogLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FeedingInformationDialogLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.feeding_information_dialog_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FeedingInformationDialogLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.breastfeedingHolder1;
      EditText breastfeedingHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (breastfeedingHolder1 == null) {
        break missingId;
      }

      id = R.id.complimentaryfoodHolder1;
      EditText complimentaryfoodHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (complimentaryfoodHolder1 == null) {
        break missingId;
      }

      id = R.id.otherfeedsintroducedNoHolder1;
      EditText otherfeedsintroducedNoHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (otherfeedsintroducedNoHolder1 == null) {
        break missingId;
      }

      id = R.id.retentionHolder1;
      EditText retentionHolder1 = ViewBindings.findChildViewById(rootView, id);
      if (retentionHolder1 == null) {
        break missingId;
      }

      id = R.id.submit;
      AppCompatButton submit = ViewBindings.findChildViewById(rootView, id);
      if (submit == null) {
        break missingId;
      }

      return new FeedingInformationDialogLayoutBinding((CardView) rootView, breastfeedingHolder1,
          complimentaryfoodHolder1, otherfeedsintroducedNoHolder1, retentionHolder1, submit);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
