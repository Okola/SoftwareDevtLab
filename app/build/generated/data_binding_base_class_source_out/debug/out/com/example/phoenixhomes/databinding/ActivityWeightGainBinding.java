// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.phoenixhomes.R;
import com.jjoe64.graphview.GraphView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWeightGainBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout FrameLayout;

  @NonNull
  public final GraphView idGraphView;

  @NonNull
  public final TextView updatematernalprofile;

  private ActivityWeightGainBinding(@NonNull FrameLayout rootView, @NonNull FrameLayout FrameLayout,
      @NonNull GraphView idGraphView, @NonNull TextView updatematernalprofile) {
    this.rootView = rootView;
    this.FrameLayout = FrameLayout;
    this.idGraphView = idGraphView;
    this.updatematernalprofile = updatematernalprofile;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWeightGainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWeightGainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_weight_gain, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWeightGainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout FrameLayout = (FrameLayout) rootView;

      id = R.id.idGraphView;
      GraphView idGraphView = ViewBindings.findChildViewById(rootView, id);
      if (idGraphView == null) {
        break missingId;
      }

      id = R.id.updatematernalprofile;
      TextView updatematernalprofile = ViewBindings.findChildViewById(rootView, id);
      if (updatematernalprofile == null) {
        break missingId;
      }

      return new ActivityWeightGainBinding((FrameLayout) rootView, FrameLayout, idGraphView,
          updatematernalprofile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
