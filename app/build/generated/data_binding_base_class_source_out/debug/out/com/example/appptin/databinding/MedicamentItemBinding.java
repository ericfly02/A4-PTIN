// Generated by view binder compiler. Do not edit!
package com.example.appptin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appptin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MedicamentItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView medNom;

  @NonNull
  public final TextView medPvp;

  @NonNull
  public final ImageView medicamentImage;

  private MedicamentItemBinding(@NonNull LinearLayout rootView, @NonNull TextView medNom,
      @NonNull TextView medPvp, @NonNull ImageView medicamentImage) {
    this.rootView = rootView;
    this.medNom = medNom;
    this.medPvp = medPvp;
    this.medicamentImage = medicamentImage;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MedicamentItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MedicamentItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.medicament_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MedicamentItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.med_Nom;
      TextView medNom = ViewBindings.findChildViewById(rootView, id);
      if (medNom == null) {
        break missingId;
      }

      id = R.id.med_Pvp;
      TextView medPvp = ViewBindings.findChildViewById(rootView, id);
      if (medPvp == null) {
        break missingId;
      }

      id = R.id.medicament_image;
      ImageView medicamentImage = ViewBindings.findChildViewById(rootView, id);
      if (medicamentImage == null) {
        break missingId;
      }

      return new MedicamentItemBinding((LinearLayout) rootView, medNom, medPvp, medicamentImage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
