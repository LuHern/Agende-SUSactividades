package com.example.agendesusactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agendesusactividades.db.DbHelper;

public class CrearBaseDatos extends AppCompatActivity {
    Button btnCrear;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_base_datos);
        btnCrear = findViewById(R.id.btnCrear);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(CrearBaseDatos.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(CrearBaseDatos.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(CrearBaseDatos.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.menu_nuevo) {
            nuevoRegistro();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(CrearBaseDatos.this, MainActivity2.class);
        startActivity(intent);
    }
}