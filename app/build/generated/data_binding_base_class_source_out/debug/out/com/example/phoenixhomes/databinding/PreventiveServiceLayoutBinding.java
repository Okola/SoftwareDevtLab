// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PreventiveServiceLayoutBinding implements ViewBinding {
  @NonNull
  private final TableLayout rootView;

  @NonNull
  public final TextView dateHolderr;

  @NonNull
  public final TextView medicineHolder;

  @NonNull
  public final TextView nextVisitHolder;

  private PreventiveServiceLayoutBinding(@NonNull TableLayout rootView,
      @NonNull TextView dateHolderr, @NonNull TextView medicineHolder,
      @NonNull TextView nextVisitHolder) {
    this.rootView = rootView;
    this.dateHolderr = dateHolderr;
    this.medicineHolder = medicineHolder;
    this.nextVisitHolder = nextVisitHolder;
  }

  @Override
  @NonNull
  public TableLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PreventiveServiceLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PreventiveServiceLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.preventive_service_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PreventiveServiceLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dateHolderr;
      TextView dateHolderr = ViewBindings.findChildViewById(rootView, id);
      if (dateHolderr == null) {
        break missingId;
      }

      id = R.id.medicineHolder;
      TextView medicineHolder = ViewBindings.findChildViewById(rootView, id);
      if (medicineHolder == null) {
        break missingId;
      }

      id = R.id.nextVisitHolder;
      TextView nextVisitHolder = ViewBindings.findChildViewById(rootView, id);
      if (nextVisitHolder == null) {
        break missingId;
      }

      return new PreventiveServiceLayoutBinding((TableLayout) rootView, dateHolderr, medicineHolder,
          nextVisitHolder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
