// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAdministeredVaccinesBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout FrameLayout;

  @NonNull
  public final RecyclerView administeredVaccinesRecycler;

  @NonNull
  public final TextView nextVisit;

  @NonNull
  public final TextView setVaccinationReminder;

  @NonNull
  public final TableRow tableRow1;

  @NonNull
  public final TextView to;

  @NonNull
  public final TextView update;

  private ActivityAdministeredVaccinesBinding(@NonNull FrameLayout rootView,
      @NonNull FrameLayout FrameLayout, @NonNull RecyclerView administeredVaccinesRecycler,
      @NonNull TextView nextVisit, @NonNull TextView setVaccinationReminder,
      @NonNull TableRow tableRow1, @NonNull TextView to, @NonNull TextView update) {
    this.rootView = rootView;
    this.FrameLayout = FrameLayout;
    this.administeredVaccinesRecycler = administeredVaccinesRecycler;
    this.nextVisit = nextVisit;
    this.setVaccinationReminder = setVaccinationReminder;
    this.tableRow1 = tableRow1;
    this.to = to;
    this.update = update;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAdministeredVaccinesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAdministeredVaccinesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_administered_vaccines, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAdministeredVaccinesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout FrameLayout = (FrameLayout) rootView;

      id = R.id.administeredVaccinesRecycler;
      RecyclerView administeredVaccinesRecycler = ViewBindings.findChildViewById(rootView, id);
      if (administeredVaccinesRecycler == null) {
        break missingId;
      }

      id = R.id.nextVisit;
      TextView nextVisit = ViewBindings.findChildViewById(rootView, id);
      if (nextVisit == null) {
        break missingId;
      }

      id = R.id.setVaccinationReminder;
      TextView setVaccinationReminder = ViewBindings.findChildViewById(rootView, id);
      if (setVaccinationReminder == null) {
        break missingId;
      }

      id = R.id.tableRow1;
      TableRow tableRow1 = ViewBindings.findChildViewById(rootView, id);
      if (tableRow1 == null) {
        break missingId;
      }

      id = R.id.to;
      TextView to = ViewBindings.findChildViewById(rootView, id);
      if (to == null) {
        break missingId;
      }

      id = R.id.update;
      TextView update = ViewBindings.findChildViewById(rootView, id);
      if (update == null) {
        break missingId;
      }

      return new ActivityAdministeredVaccinesBinding((FrameLayout) rootView, FrameLayout,
          administeredVaccinesRecycler, nextVisit, setVaccinationReminder, tableRow1, to, update);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
