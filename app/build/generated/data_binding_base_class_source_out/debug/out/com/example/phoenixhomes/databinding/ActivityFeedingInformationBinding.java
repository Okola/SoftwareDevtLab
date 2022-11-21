// Generated by view binder compiler. Do not edit!
package com.example.phoenixhomes.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public final class ActivityFeedingInformationBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FrameLayout FrameLayout;

  @NonNull
  public final RecyclerView feedingInfoRecycler;

  @NonNull
  public final TextView updatematernalprofile;

  private ActivityFeedingInformationBinding(@NonNull FrameLayout rootView,
      @NonNull FrameLayout FrameLayout, @NonNull RecyclerView feedingInfoRecycler,
      @NonNull TextView updatematernalprofile) {
    this.rootView = rootView;
    this.FrameLayout = FrameLayout;
    this.feedingInfoRecycler = feedingInfoRecycler;
    this.updatematernalprofile = updatematernalprofile;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFeedingInformationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFeedingInformationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_feeding_information, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFeedingInformationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      FrameLayout FrameLayout = (FrameLayout) rootView;

      id = R.id.feedingInfoRecycler;
      RecyclerView feedingInfoRecycler = ViewBindings.findChildViewById(rootView, id);
      if (feedingInfoRecycler == null) {
        break missingId;
      }

      id = R.id.updatematernalprofile;
      TextView updatematernalprofile = ViewBindings.findChildViewById(rootView, id);
      if (updatematernalprofile == null) {
        break missingId;
      }

      return new ActivityFeedingInformationBinding((FrameLayout) rootView, FrameLayout,
          feedingInfoRecycler, updatematernalprofile);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}