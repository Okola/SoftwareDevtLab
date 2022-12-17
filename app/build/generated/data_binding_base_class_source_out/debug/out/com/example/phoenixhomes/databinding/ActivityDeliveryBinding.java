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

public final class ActivityDeliveryBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final RecyclerView DeliveryRecycler;

  @NonNull
  public final FrameLayout FrameLayout;

  @NonNull
  public final RecyclerView impairmentsRecycler;

  @NonNull
  public final TextView updatematernalprofile;

  @NonNull
  public final TextView updatematernalprofile1;

  private ActivityDeliveryBinding(@NonNull FrameLayout rootView,
      @NonNull RecyclerView DeliveryRecycler, @NonNull FrameLayout FrameLayout,
      @NonNull RecyclerView impairmentsRecycler, @NonNull TextView updatematernalprofile,
      @NonNull TextView updatematernalprofile1) {
    this.rootView = rootView;
    this.DeliveryRecycler = DeliveryRecycler;
    this.FrameLayout = FrameLayout;
    this.impairmentsRecycler = impairmentsRecycler;
    this.updatematernalprofile = updatematernalprofile;
    this.updatematernalprofile1 = updatematernalprofile1;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDeliveryBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDeliveryBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_delivery, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDeliveryBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.DeliveryRecycler;
      RecyclerView DeliveryRecycler = ViewBindings.findChildViewById(rootView, id);
      if (DeliveryRecycler == null) {
        break missingId;
      }

      FrameLayout FrameLayout = (FrameLayout) rootView;

      id = R.id.impairmentsRecycler;
      RecyclerView impairmentsRecycler = ViewBindings.findChildViewById(rootView, id);
      if (impairmentsRecycler == null) {
        break missingId;
      }

      id = R.id.updatematernalprofile;
      TextView updatematernalprofile = ViewBindings.findChildViewById(rootView, id);
      if (updatematernalprofile == null) {
        break missingId;
      }

      id = R.id.updatematernalprofile1;
      TextView updatematernalprofile1 = ViewBindings.findChildViewById(rootView, id);
      if (updatematernalprofile1 == null) {
        break missingId;
      }

      return new ActivityDeliveryBinding((FrameLayout) rootView, DeliveryRecycler, FrameLayout,
          impairmentsRecycler, updatematernalprofile, updatematernalprofile1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
