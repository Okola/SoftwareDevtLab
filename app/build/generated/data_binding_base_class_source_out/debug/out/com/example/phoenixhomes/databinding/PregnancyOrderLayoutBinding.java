// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PregnancyOrderLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardPregnancyOrder;

  @NonNull
  public final TextView dateofFirstVisit;

  @NonNull
  public final TextView pregnancyOrder;

  private PregnancyOrderLayoutBinding(@NonNull CardView rootView,
      @NonNull CardView cardPregnancyOrder, @NonNull TextView dateofFirstVisit,
      @NonNull TextView pregnancyOrder) {
    this.rootView = rootView;
    this.cardPregnancyOrder = cardPregnancyOrder;
    this.dateofFirstVisit = dateofFirstVisit;
    this.pregnancyOrder = pregnancyOrder;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static PregnancyOrderLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PregnancyOrderLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pregnancy_order_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PregnancyOrderLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cardPregnancyOrder = (CardView) rootView;

      id = R.id.dateofFirstVisit;
      TextView dateofFirstVisit = ViewBindings.findChildViewById(rootView, id);
      if (dateofFirstVisit == null) {
        break missingId;
      }

      id = R.id.pregnancyOrder;
      TextView pregnancyOrder = ViewBindings.findChildViewById(rootView, id);
      if (pregnancyOrder == null) {
        break missingId;
      }

      return new PregnancyOrderLayoutBinding((CardView) rootView, cardPregnancyOrder,
          dateofFirstVisit, pregnancyOrder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
