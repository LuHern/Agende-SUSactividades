package com.example.agendesusactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.agendesusactividades.db.DbAgenda;
import com.example.agendesusactividades.entidades.Actividades;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class VerActivity extends AppCompatActivity {

    TextView txt_nombre, txt_descripcion, txt_fecha_inicio, txt_fecha_culminacion, txt_usuario_encargado;
    Button btn_Aceptar;

    Actividades actividad;
    String nombre = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txt_nombre = findViewById(R.id.tv_nombre);
        txt_descripcion = findViewById(R.id.tv_descripcion);
        txt_fecha_inicio = findViewById(R.id.tv_fecha_inicio);
        txt_fecha_culminacion = findViewById(R.id.et_fecha_terminacion);
        txt_usuario_encargado = findViewById(R.id.et_owner_activity);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();

            if(extras == null){
                nombre = String.valueOf(Integer.parseInt(null));
            } else{
                nombre = extras.getString("nombre");
            }
        } else{
            nombre = (String) savedInstanceState.getSerializable("nombre");
        }

        DbAgenda dbAgenda = new DbAgenda(VerActivity.this);
        actividad = dbAgenda.verActividad(nombre);

        if(actividad != null){
            txt_nombre.setText(actividad.getNombre());
            txt_descripcion.setText(actividad.getDescripcion());
            txt_fecha_inicio.setText(actividad.getFecha_inicio());
            txt_fecha_culminacion.setText(actividad.getFecha_culminacion());
            txt_usuario_encargado.setText(actividad.getUsuario_encargado());
            btn_Aceptar.setVisibility(View.INVISIBLE);

            txt_nombre.setInputType(InputType.TYPE_NULL);
            txt_descripcion.setInputType(InputType.TYPE_NULL);
            txt_fecha_inicio.setInputType(InputType.TYPE_NULL);
            txt_fecha_culminacion.setInputType(InputType.TYPE_NULL);
            txt_usuario_encargado.setInputType(InputType.TYPE_NULL);
        }
    }
}