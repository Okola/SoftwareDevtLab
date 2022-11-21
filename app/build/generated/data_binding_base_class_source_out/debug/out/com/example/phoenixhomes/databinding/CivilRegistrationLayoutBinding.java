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

public final class CivilRegistrationLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView birthCertificateNoHolder;

  @NonNull
  public final TextView countyHolder;

  @NonNull
  public final TextView dateOfRegistrationNoHolder;

  @NonNull
  public final TextView districtHolder;

  @NonNull
  public final TextView divisionHolder;

  @NonNull
  public final TextView fathersNameHolder;

  @NonNull
  public final TextView fathersNoHolder;

  @NonNull
  public final TextView guardianHolder;

  @NonNull
  public final TextView guardianNoHolder;

  @NonNull
  public final TextView locationHolder;

  @NonNull
  public final TextView mothersNameHolder;

  @NonNull
  public final TextView mothersNoHolder;

  @NonNull
  public final TextView placeOfRegistrationHolder;

  @NonNull
  public final TextView postalHolder;

  @NonNull
  public final TextView townHolder;

  @NonNull
  public final TextView villageHolder;

  private CivilRegistrationLayoutBinding(@NonNull CardView rootView,
      @NonNull TextView birthCertificateNoHolder, @NonNull TextView countyHolder,
      @NonNull TextView dateOfRegistrationNoHolder, @NonNull TextView districtHolder,
      @NonNull TextView divisionHolder, @NonNull TextView fathersNameHolder,
      @NonNull TextView fathersNoHolder, @NonNull TextView guardianHolder,
      @NonNull TextView guardianNoHolder, @NonNull TextView locationHolder,
      @NonNull TextView mothersNameHolder, @NonNull TextView mothersNoHolder,
      @NonNull TextView placeOfRegistrationHolder, @NonNull TextView postalHolder,
      @NonNull TextView townHolder, @NonNull TextView villageHolder) {
    this.rootView = rootView;
    this.birthCertificateNoHolder = birthCertificateNoHolder;
    this.countyHolder = countyHolder;
    this.dateOfRegistrationNoHolder = dateOfRegistrationNoHolder;
    this.districtHolder = districtHolder;
    this.divisionHolder = divisionHolder;
    this.fathersNameHolder = fathersNameHolder;
    this.fathersNoHolder = fathersNoHolder;
    this.guardianHolder = guardianHolder;
    this.guardianNoHolder = guardianNoHolder;
    this.locationHolder = locationHolder;
    this.mothersNameHolder = mothersNameHolder;
    this.mothersNoHolder = mothersNoHolder;
    this.placeOfRegistrationHolder = placeOfRegistrationHolder;
    this.postalHolder = postalHolder;
    this.townHolder = townHolder;
    this.villageHolder = villageHolder;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CivilRegistrationLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CivilRegistrationLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.civil_registration_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CivilRegistrationLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.birthCertificateNoHolder;
      TextView birthCertificateNoHolder = ViewBindings.findChildViewById(rootView, id);
      if (birthCertificateNoHolder == null) {
        break missingId;
      }

      id = R.id.countyHolder;
      TextView countyHolder = ViewBindings.findChildViewById(rootView, id);
      if (countyHolder == null) {
        break missingId;
      }

      id = R.id.dateOfRegistrationNoHolder;
      TextView dateOfRegistrationNoHolder = ViewBindings.findChildViewById(rootView, id);
      if (dateOfRegistrationNoHolder == null) {
        break missingId;
      }

      id = R.id.districtHolder;
      TextView districtHolder = ViewBindings.findChildViewById(rootView, id);
      if (districtHolder == null) {
        break missingId;
      }

      id = R.id.divisionHolder;
      TextView divisionHolder = ViewBindings.findChildViewById(rootView, id);
      if (divisionHolder == null) {
        break missingId;
      }

      id = R.id.fathersNameHolder;
      TextView fathersNameHolder = ViewBindings.findChildViewById(rootView, id);
      if (fathersNameHolder == null) {
        break missingId;
      }

      id = R.id.fathersNoHolder;
      TextView fathersNoHolder = ViewBindings.findChildViewById(rootView, id);
      if (fathersNoHolder == null) {
        break missingId;
      }

      id = R.id.guardianHolder;
      TextView guardianHolder = ViewBindings.findChildViewById(rootView, id);
      if (guardianHolder == null) {
        break missingId;
      }

      id = R.id.guardianNoHolder;
      TextView guardianNoHolder = ViewBindings.findChildViewById(rootView, id);
      if (guardianNoHolder == null) {
        break missingId;
      }

      id = R.id.locationHolder;
      TextView locationHolder = ViewBindings.findChildViewById(rootView, id);
      if (locationHolder == null) {
        break missingId;
      }

      id = R.id.mothersNameHolder;
      TextView mothersNameHolder = ViewBindings.findChildViewById(rootView, id);
      if (mothersNameHolder == null) {
        break missingId;
      }

      id = R.id.mothersNoHolder;
      TextView mothersNoHolder = ViewBindings.findChildViewById(rootView, id);
      if (mothersNoHolder == null) {
        break missingId;
      }

      id = R.id.placeOfRegistrationHolder;
      TextView placeOfRegistrationHolder = ViewBindings.findChildViewById(rootView, id);
      if (placeOfRegistrationHolder == null) {
        break missingId;
      }

      id = R.id.postalHolder;
      TextView postalHolder = ViewBindings.findChildViewById(rootView, id);
      if (postalHolder == null) {
        break missingId;
      }

      id = R.id.townHolder;
      TextView townHolder = ViewBindings.findChildViewById(rootView, id);
      if (townHolder == null) {
        break missingId;
      }

      id = R.id.villageHolder;
      TextView villageHolder = ViewBindings.findChildViewById(rootView, id);
      if (villageHolder == null) {
        break missingId;
      }

      return new CivilRegistrationLayoutBinding((CardView) rootView, birthCertificateNoHolder,
          countyHolder, dateOfRegistrationNoHolder, districtHolder, divisionHolder,
          fathersNameHolder, fathersNoHolder, guardianHolder, guardianNoHolder, locationHolder,
          mothersNameHolder, mothersNoHolder, placeOfRegistrationHolder, postalHolder, townHolder,
          villageHolder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}