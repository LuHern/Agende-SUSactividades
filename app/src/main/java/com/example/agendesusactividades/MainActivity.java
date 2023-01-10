package com.example.agendesusactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion_relative);

        TextView usuario = (TextView) findViewById(R.id.et_usuario);
        TextView contrasenia = (TextView) findViewById(R.id.et_password);

        boton = (Button) findViewById(R.id.btn_acceder);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().equals("admin") && contrasenia.getText().toString().equals("123")){
                    Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, CrearBaseDatos.class));

                } else{
                    Toast.makeText(MainActivity.this, "Error de autenticacion", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}