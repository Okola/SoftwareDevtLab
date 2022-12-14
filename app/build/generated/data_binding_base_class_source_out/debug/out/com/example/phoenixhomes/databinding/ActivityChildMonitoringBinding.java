// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityChildMonitoringBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final CardView behaviouralCharacteristics;

  @NonNull
  public final CardView childParticularsCard;

  @NonNull
  public final CardView civilRegistration;

  @NonNull
  public final CardView clinicalReview;

  @NonNull
  public final CardView developmentMilestones;

  @NonNull
  public final CardView developmentprogressHeight;

  @NonNull
  public final CardView developmentprogressWeight;

  @NonNull
  public final CardView feedingInfo;

  @NonNull
  public final CardView healthRecord;

  @NonNull
  public final CardView immunization;

  private ActivityChildMonitoringBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull CardView behaviouralCharacteristics, @NonNull CardView childParticularsCard,
      @NonNull CardView civilRegistration, @NonNull CardView clinicalReview,
      @NonNull CardView developmentMilestones, @NonNull CardView developmentprogressHeight,
      @NonNull CardView developmentprogressWeight, @NonNull CardView feedingInfo,
      @NonNull CardView healthRecord, @NonNull CardView immunization) {
    this.rootView = rootView;
    this.behaviouralCharacteristics = behaviouralCharacteristics;
    this.childParticularsCard = childParticularsCard;
    this.civilRegistration = civilRegistration;
    this.clinicalReview = clinicalReview;
    this.developmentMilestones = developmentMilestones;
    this.developmentprogressHeight = developmentprogressHeight;
    this.developmentprogressWeight = developmentprogressWeight;
    this.feedingInfo = feedingInfo;
    this.healthRecord = healthRecord;
    this.immunization = immunization;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChildMonitoringBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChildMonitoringBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_child_monitoring, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChildMonitoringBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.behaviouralCharacteristics;
      CardView behaviouralCharacteristics = ViewBindings.findChildViewById(rootView, id);
      if (behaviouralCharacteristics == null) {
        break missingId;
      }

      id = R.id.childParticularsCard;
      CardView childParticularsCard = ViewBindings.findChildViewById(rootView, id);
      if (childParticularsCard == null) {
        break missingId;
      }

      id = R.id.civilRegistration;
      CardView civilRegistration = ViewBindings.findChildViewById(rootView, id);
      if (civilRegistration == null) {
        break missingId;
      }

      id = R.id.clinicalReview;
      CardView clinicalReview = ViewBindings.findChildViewById(rootView, id);
      if (clinicalReview == null) {
        break missingId;
      }

      id = R.id.developmentMilestones;
      CardView developmentMilestones = ViewBindings.findChildViewById(rootView, id);
      if (developmentMilestones == null) {
        break missingId;
      }

      id = R.id.developmentprogressHeight;
      CardView developmentprogressHeight = ViewBindings.findChildViewById(rootView, id);
      if (developmentprogressHeight == null) {
        break missingId;
      }

      id = R.id.developmentprogressWeight;
      CardView developmentprogressWeight = ViewBindings.findChildViewById(rootView, id);
      if (developmentprogressWeight == null) {
        break missingId;
      }

      id = R.id.feedingInfo;
      CardView feedingInfo = ViewBindings.findChildViewById(rootView, id);
      if (feedingInfo == null) {
        break missingId;
      }

      id = R.id.healthRecord;
      CardView healthRecord = ViewBindings.findChildViewById(rootView, id);
      if (healthRecord == null) {
        break missingId;
      }

      id = R.id.immunization;
      CardView immunization = ViewBindings.findChildViewById(rootView, id);
      if (immunization == null) {
        break missingId;
      }

      return new ActivityChildMonitoringBinding((LinearLayoutCompat) rootView,
          behaviouralCharacteristics, childParticularsCard, civilRegistration, clinicalReview,
          developmentMilestones, developmentprogressHeight, developmentprogressWeight, feedingInfo,
          healthRecord, immunization);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
