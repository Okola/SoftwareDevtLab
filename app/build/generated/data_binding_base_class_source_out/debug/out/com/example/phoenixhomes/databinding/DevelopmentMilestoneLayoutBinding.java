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

public final class DevelopmentMilestoneLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView ageHolder;

  @NonNull
  public final TextView delayedHolder;

  @NonNull
  public final TextView milestoneHolder;

  @NonNull
  public final TextView withinTimes;

  private DevelopmentMilestoneLayoutBinding(@NonNull CardView rootView, @NonNull TextView ageHolder,
      @NonNull TextView delayedHolder, @NonNull TextView milestoneHolder,
      @NonNull TextView withinTimes) {
    this.rootView = rootView;
    this.ageHolder = ageHolder;
    this.delayedHolder = delayedHolder;
    this.milestoneHolder = milestoneHolder;
    this.withinTimes = withinTimes;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static DevelopmentMilestoneLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DevelopmentMilestoneLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.development_milestone_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DevelopmentMilestoneLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ageHolder;
      TextView ageHolder = ViewBindings.findChildViewById(rootView, id);
      if (ageHolder == null) {
        break missingId;
      }

      id = R.id.delayedHolder;
      TextView delayedHolder = ViewBindings.findChildViewById(rootView, id);
      if (delayedHolder == null) {
        break missingId;
      }

      id = R.id.milestoneHolder;
      TextView milestoneHolder = ViewBindings.findChildViewById(rootView, id);
      if (milestoneHolder == null) {
        break missingId;
      }

      id = R.id.withinTimes;
      TextView withinTimes = ViewBindings.findChildViewById(rootView, id);
      if (withinTimes == null) {
        break missingId;
      }

      return new DevelopmentMilestoneLayoutBinding((CardView) rootView, ageHolder, delayedHolder,
          milestoneHolder, withinTimes);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
