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

public class ActivityCrearBaseDatos extends AppCompatActivity {

    Button btn_Crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
       btn_Crear = findViewById(R.id.btnCrear);

       btn_Crear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               DbHelper dbHelper = new DbHelper(ActivityCrearBaseDatos.this);
               SQLiteDatabase db = dbHelper.getWritableDatabase();
               if(db != null){
                   Toast.makeText(ActivityCrearBaseDatos.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
               } else{
                   Toast.makeText(ActivityCrearBaseDatos.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_LONG).show();

               }
           }
       });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsIremSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_nuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}