package com.example.appptin.gestor.fragments.flota.global;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appptin.R;
import com.example.appptin.medico.fragments.historialPeticion.PeticionAdapter;

import java.util.ArrayList;

public class CocheAdapter extends RecyclerView.Adapter<CocheAdapter.MyHolder>{

    ArrayList<InformacionCoche> arrayList;
    LayoutInflater layoutInflater;
    Context context;
    FragmentManager activity;

    public CocheAdapter(Context context, ArrayList<InformacionCoche> arrayList, FragmentManager activity) {
        this.arrayList = arrayList;
        this.context = context;
        this.activity = activity;
        layoutInflater = LayoutInflater.from(context); //Obtener el contexto del activity
    }

    @NonNull
    @Override
    public CocheAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.contenedor_coche, parent, false);
        return new CocheAdapter.MyHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull CocheAdapter.MyHolder holder, int position) {
        holder.txt_nombre.setText(arrayList.get(position).getCoche());
        int colorRGreen = R.color.green_300;
        int color = ContextCompat.getColor(context, colorRGreen);
        holder.view_estado.setBackgroundColor(color);
        //holder.view_estado.setC
          //      setText(arrayList.get(position).getCoche());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txt_nombre;
        View view_estado,contenedorElem;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txt_nombre = itemView.findViewById(R.id.txt_contenedor_nombre);
            view_estado = itemView.findViewById(R.id.roundView_contenedor);
            contenedorElem = itemView.findViewById(R.id.layout_elementos_vehiculos);
        }
    }
}
