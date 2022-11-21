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

public final class MaternalProfileLayoutBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView addressHolder;

  @NonNull
  public final TextView ageHolder;

  @NonNull
  public final TextView ancHolder;

  @NonNull
  public final TextView eddHolder;

  @NonNull
  public final TextView educationHolder;

  @NonNull
  public final TextView gravidaHolder;

  @NonNull
  public final TextView heightHolder;

  @NonNull
  public final TextView institutionHolder;

  @NonNull
  public final TextView lmpHolder;

  @NonNull
  public final TextView maritalHolder;

  @NonNull
  public final TextView mflHolder;

  @NonNull
  public final TextView nameHolder;

  @NonNull
  public final TextView nextOfKinphoneHolder;

  @NonNull
  public final TextView nextofKinHolder;

  @NonNull
  public final TextView parityHolder;

  @NonNull
  public final TextView pncHolder;

  @NonNull
  public final TextView relationshipHolder;

  @NonNull
  public final TextView telephoneHolder;

  @NonNull
  public final TextView weightHolder;

  private MaternalProfileLayoutBinding(@NonNull CardView rootView, @NonNull TextView addressHolder,
      @NonNull TextView ageHolder, @NonNull TextView ancHolder, @NonNull TextView eddHolder,
      @NonNull TextView educationHolder, @NonNull TextView gravidaHolder,
      @NonNull TextView heightHolder, @NonNull TextView institutionHolder,
      @NonNull TextView lmpHolder, @NonNull TextView maritalHolder, @NonNull TextView mflHolder,
      @NonNull TextView nameHolder, @NonNull TextView nextOfKinphoneHolder,
      @NonNull TextView nextofKinHolder, @NonNull TextView parityHolder,
      @NonNull TextView pncHolder, @NonNull TextView relationshipHolder,
      @NonNull TextView telephoneHolder, @NonNull TextView weightHolder) {
    this.rootView = rootView;
    this.addressHolder = addressHolder;
    this.ageHolder = ageHolder;
    this.ancHolder = ancHolder;
    this.eddHolder = eddHolder;
    this.educationHolder = educationHolder;
    this.gravidaHolder = gravidaHolder;
    this.heightHolder = heightHolder;
    this.institutionHolder = institutionHolder;
    this.lmpHolder = lmpHolder;
    this.maritalHolder = maritalHolder;
    this.mflHolder = mflHolder;
    this.nameHolder = nameHolder;
    this.nextOfKinphoneHolder = nextOfKinphoneHolder;
    this.nextofKinHolder = nextofKinHolder;
    this.parityHolder = parityHolder;
    this.pncHolder = pncHolder;
    this.relationshipHolder = relationshipHolder;
    this.telephoneHolder = telephoneHolder;
    this.weightHolder = weightHolder;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static MaternalProfileLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MaternalProfileLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.maternal_profile_layout, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MaternalProfileLayoutBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addressHolder;
      TextView addressHolder = ViewBindings.findChildViewById(rootView, id);
      if (addressHolder == null) {
        break missingId;
      }

      id = R.id.ageHolder;
      TextView ageHolder = ViewBindings.findChildViewById(rootView, id);
      if (ageHolder == null) {
        break missingId;
      }

      id = R.id.ancHolder;
      TextView ancHolder = ViewBindings.findChildViewById(rootView, id);
      if (ancHolder == null) {
        break missingId;
      }

      id = R.id.eddHolder;
      TextView eddHolder = ViewBindings.findChildViewById(rootView, id);
      if (eddHolder == null) {
        break missingId;
      }

      id = R.id.educationHolder;
      TextView educationHolder = ViewBindings.findChildViewById(rootView, id);
      if (educationHolder == null) {
        break missingId;
      }

      id = R.id.gravidaHolder;
      TextView gravidaHolder = ViewBindings.findChildViewById(rootView, id);
      if (gravidaHolder == null) {
        break missingId;
      }

      id = R.id.heightHolder;
      TextView heightHolder = ViewBindings.findChildViewById(rootView, id);
      if (heightHolder == null) {
        break missingId;
      }

      id = R.id.institutionHolder;
      TextView institutionHolder = ViewBindings.findChildViewById(rootView, id);
      if (institutionHolder == null) {
        break missingId;
      }

      id = R.id.lmpHolder;
      TextView lmpHolder = ViewBindings.findChildViewById(rootView, id);
      if (lmpHolder == null) {
        break missingId;
      }

      id = R.id.maritalHolder;
      TextView maritalHolder = ViewBindings.findChildViewById(rootView, id);
      if (maritalHolder == null) {
        break missingId;
      }

      id = R.id.mflHolder;
      TextView mflHolder = ViewBindings.findChildViewById(rootView, id);
      if (mflHolder == null) {
        break missingId;
      }

      id = R.id.nameHolder;
      TextView nameHolder = ViewBindings.findChildViewById(rootView, id);
      if (nameHolder == null) {
        break missingId;
      }

      id = R.id.nextOfKinphoneHolder;
      TextView nextOfKinphoneHolder = ViewBindings.findChildViewById(rootView, id);
      if (nextOfKinphoneHolder == null) {
        break missingId;
      }

      id = R.id.nextofKinHolder;
      TextView nextofKinHolder = ViewBindings.findChildViewById(rootView, id);
      if (nextofKinHolder == null) {
        break missingId;
      }

      id = R.id.parityHolder;
      TextView parityHolder = ViewBindings.findChildViewById(rootView, id);
      if (parityHolder == null) {
        break missingId;
      }

      id = R.id.pncHolder;
      TextView pncHolder = ViewBindings.findChildViewById(rootView, id);
      if (pncHolder == null) {
        break missingId;
      }

      id = R.id.relationshipHolder;
      TextView relationshipHolder = ViewBindings.findChildViewById(rootView, id);
      if (relationshipHolder == null) {
        break missingId;
      }

      id = R.id.telephoneHolder;
      TextView telephoneHolder = ViewBindings.findChildViewById(rootView, id);
      if (telephoneHolder == null) {
        break missingId;
      }

      id = R.id.weightHolder;
      TextView weightHolder = ViewBindings.findChildViewById(rootView, id);
      if (weightHolder == null) {
        break missingId;
      }

      return new MaternalProfileLayoutBinding((CardView) rootView, addressHolder, ageHolder,
          ancHolder, eddHolder, educationHolder, gravidaHolder, heightHolder, institutionHolder,
          lmpHolder, maritalHolder, mflHolder, nameHolder, nextOfKinphoneHolder, nextofKinHolder,
          parityHolder, pncHolder, relationshipHolder, telephoneHolder, weightHolder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}