// Generated by view binder compiler. Do not edit!
package com.example.appptin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appptin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentInventarioGestorBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnInvGestorFiltro;

  @NonNull
  public final CardView card;

  @NonNull
  public final RecyclerView rvInventario;

  @NonNull
  public final Spinner spIventarioGestorOrdenar;

  @NonNull
  public final SearchView svInventario;

  @NonNull
  public final TextView txtTitolInventario;

  private FragmentInventarioGestorBinding(@NonNull FrameLayout rootView,
      @NonNull Button btnInvGestorFiltro, @NonNull CardView card,
      @NonNull RecyclerView rvInventario, @NonNull Spinner spIventarioGestorOrdenar,
      @NonNull SearchView svInventario, @NonNull TextView txtTitolInventario) {
    this.rootView = rootView;
    this.btnInvGestorFiltro = btnInvGestorFiltro;
    this.card = card;
    this.rvInventario = rvInventario;
    this.spIventarioGestorOrdenar = spIventarioGestorOrdenar;
    this.svInventario = svInventario;
    this.txtTitolInventario = txtTitolInventario;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentInventarioGestorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentInventarioGestorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_inventario_gestor, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentInventarioGestorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_inv_gestor_filtro;
      Button btnInvGestorFiltro = ViewBindings.findChildViewById(rootView, id);
      if (btnInvGestorFiltro == null) {
        break missingId;
      }

      id = R.id.card;
      CardView card = ViewBindings.findChildViewById(rootView, id);
      if (card == null) {
        break missingId;
      }

      id = R.id.rv_inventario;
      RecyclerView rvInventario = ViewBindings.findChildViewById(rootView, id);
      if (rvInventario == null) {
        break missingId;
      }

      id = R.id.sp_iventario_gestor_ordenar;
      Spinner spIventarioGestorOrdenar = ViewBindings.findChildViewById(rootView, id);
      if (spIventarioGestorOrdenar == null) {
        break missingId;
      }

      id = R.id.sv_inventario;
      SearchView svInventario = ViewBindings.findChildViewById(rootView, id);
      if (svInventario == null) {
        break missingId;
      }

      id = R.id.txt_titol_inventario;
      TextView txtTitolInventario = ViewBindings.findChildViewById(rootView, id);
      if (txtTitolInventario == null) {
        break missingId;
      }

      return new FragmentInventarioGestorBinding((FrameLayout) rootView, btnInvGestorFiltro, card,
          rvInventario, spIventarioGestorOrdenar, svInventario, txtTitolInventario);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
