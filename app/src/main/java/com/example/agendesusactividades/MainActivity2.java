package com.example.agendesusactividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agendesusactividades.db.DbAgenda;

public class MainActivity2 extends AppCompatActivity {
    EditText txtNombre, txtDescripcion, txtFecha_inicio, txtFecha_culminacion, txtUsuario_encargado;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_up_layout_relative);

        txtNombre = findViewById(R.id.et_name_act);
        txtDescripcion = findViewById(R.id.et_descripcion_act);
        txtFecha_inicio = findViewById(R.id.et_fecha_inicio);
        txtFecha_culminacion = findViewById(R.id.et_fecha_terminacion);
        txtUsuario_encargado = findViewById(R.id.et_owner_activity);

        btnAceptar = findViewById(R.id.button);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbAgenda dbAgenda = new DbAgenda(MainActivity2.this);
                long id = dbAgenda.insertarActividad(txtNombre.getText().toString(), txtDescripcion.getText().toString(), txtFecha_inicio.getText().toString(), txtFecha_culminacion.getText().toString(), txtUsuario_encargado.getText().toString());
                limpiar();
                if(id > 0){
                    Toast.makeText(MainActivity2.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity2.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtFecha_inicio.setText("");
        txtFecha_culminacion.setText("");
        txtUsuario_encargado.setText("");
    }
}
