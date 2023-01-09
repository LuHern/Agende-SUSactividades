package com.example.agendesusactividades.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendesusactividades.R;
import com.example.agendesusactividades.VerActivity;
import com.example.agendesusactividades.entidades.Actividades;

import java.util.ArrayList;

public class ListaActividadesAdapter extends RecyclerView.Adapter<ListaActividadesAdapter.ActividadesViewHolder>{

    ArrayList<Actividades> listaActividades;

    public ListaActividadesAdapter(ArrayList<Actividades> listaActividades
){
        this.listaActividades = listaActividades;

    }

    @NonNull
    @Override
    public ActividadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_actividad, null, false);
        return new ActividadesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActividadesViewHolder holder, int position) {
        holder.view_nombre.setText(listaActividades.get(position).getNombre());
        holder.view_descripcion.setText(listaActividades.get(position).getDescripcion());
        holder.view_fecha_inicio.setText(listaActividades.get(position).getFecha_inicio());
        holder.view_fecha_culminacion.setText(listaActividades.get(position).getFecha_culminacion());
        holder.view_usuario_encargado.setText(listaActividades.get(position).getUsuario_encargado());
    }

    @Override
    public int getItemCount() {
        return listaActividades.size();
    }

    public class ActividadesViewHolder extends RecyclerView.ViewHolder {

        TextView view_nombre, view_descripcion, view_fecha_inicio, view_fecha_culminacion, view_usuario_encargado;

        public ActividadesViewHolder(@NonNull View itemView) {
            super(itemView);

            view_nombre = itemView.findViewById(R.id.view_nombre);
            view_descripcion = itemView.findViewById(R.id.view_descripcion);
            view_fecha_inicio = itemView.findViewById(R.id.view_fecha_inicio);
            view_fecha_culminacion = itemView.findViewById(R.id.view_fecha_culminacion);
            view_usuario_encargado = itemView.findViewById(R.id.view_usuario_encargado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("nombre", listaActividades.get(getAdapterPosition()).getNombre());
                    context.startActivity(intent);
                }
            });
        }
    }

}
