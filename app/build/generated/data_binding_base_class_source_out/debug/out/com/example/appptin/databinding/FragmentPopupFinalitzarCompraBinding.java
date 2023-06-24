// Generated by view binder compiler. Do not edit!
package com.example.appptin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appptin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPopupFinalitzarCompraBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnFinalitzarCompraNo;

  @NonNull
  public final Button btnFinalitzarCompraSi;

  @NonNull
  public final LinearLayout popupLayout;

  private FragmentPopupFinalitzarCompraBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnFinalitzarCompraNo, @NonNull Button btnFinalitzarCompraSi,
      @NonNull LinearLayout popupLayout) {
    this.rootView = rootView;
    this.btnFinalitzarCompraNo = btnFinalitzarCompraNo;
    this.btnFinalitzarCompraSi = btnFinalitzarCompraSi;
    this.popupLayout = popupLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPopupFinalitzarCompraBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPopupFinalitzarCompraBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_popup_finalitzar_compra, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPopupFinalitzarCompraBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_finalitzar_compraNo;
      Button btnFinalitzarCompraNo = ViewBindings.findChildViewById(rootView, id);
      if (btnFinalitzarCompraNo == null) {
        break missingId;
      }

      id = R.id.btn_finalitzar_compraSi;
      Button btnFinalitzarCompraSi = ViewBindings.findChildViewById(rootView, id);
      if (btnFinalitzarCompraSi == null) {
        break missingId;
      }

      id = R.id.popup_layout;
      LinearLayout popupLayout = ViewBindings.findChildViewById(rootView, id);
      if (popupLayout == null) {
        break missingId;
      }

      return new FragmentPopupFinalitzarCompraBinding((ConstraintLayout) rootView,
          btnFinalitzarCompraNo, btnFinalitzarCompraSi, popupLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
