// Generated by view binder compiler. Do not edit!
package com.example.appptin.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.appptin.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentDatosPacienteBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button btnDatoPacienteGuardar;

  @NonNull
  public final EditText etEmail;

  @NonNull
  public final EditText etUserAddress;

  @NonNull
  public final EditText etUserCity;

  @NonNull
  public final EditText etUserGivenName;

  @NonNull
  public final EditText etUserName;

  @NonNull
  public final ImageView ivDatoPacienteBack;

  private FragmentDatosPacienteBinding(@NonNull FrameLayout rootView,
      @NonNull Button btnDatoPacienteGuardar, @NonNull EditText etEmail,
      @NonNull EditText etUserAddress, @NonNull EditText etUserCity,
      @NonNull EditText etUserGivenName, @NonNull EditText etUserName,
      @NonNull ImageView ivDatoPacienteBack) {
    this.rootView = rootView;
    this.btnDatoPacienteGuardar = btnDatoPacienteGuardar;
    this.etEmail = etEmail;
    this.etUserAddress = etUserAddress;
    this.etUserCity = etUserCity;
    this.etUserGivenName = etUserGivenName;
    this.etUserName = etUserName;
    this.ivDatoPacienteBack = ivDatoPacienteBack;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentDatosPacienteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentDatosPacienteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_datos_paciente, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentDatosPacienteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_dato_paciente_guardar;
      Button btnDatoPacienteGuardar = ViewBindings.findChildViewById(rootView, id);
      if (btnDatoPacienteGuardar == null) {
        break missingId;
      }

      id = R.id.et_email;
      EditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.et_user_address;
      EditText etUserAddress = ViewBindings.findChildViewById(rootView, id);
      if (etUserAddress == null) {
        break missingId;
      }

      id = R.id.et_user_city;
      EditText etUserCity = ViewBindings.findChildViewById(rootView, id);
      if (etUserCity == null) {
        break missingId;
      }

      id = R.id.et_user_given_name;
      EditText etUserGivenName = ViewBindings.findChildViewById(rootView, id);
      if (etUserGivenName == null) {
        break missingId;
      }

      id = R.id.et_user_name;
      EditText etUserName = ViewBindings.findChildViewById(rootView, id);
      if (etUserName == null) {
        break missingId;
      }

      id = R.id.iv_dato_paciente_back;
      ImageView ivDatoPacienteBack = ViewBindings.findChildViewById(rootView, id);
      if (ivDatoPacienteBack == null) {
        break missingId;
      }

      return new FragmentDatosPacienteBinding((FrameLayout) rootView, btnDatoPacienteGuardar,
          etEmail, etUserAddress, etUserCity, etUserGivenName, etUserName, ivDatoPacienteBack);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
