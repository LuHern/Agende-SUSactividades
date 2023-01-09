package com.example.agendesusactividades.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.agendesusactividades.entidades.Actividades;

import java.util.ArrayList;

public class DbAgenda extends DbHelper{

    Context context;

    public DbAgenda(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarActividad(String nombre, String descripcion, String fecha_inicio, String fecha_culminacion, String usuario_encargado){
       long id = 0;
        try {
           DbHelper dbHelper = new DbHelper(context);
           SQLiteDatabase db = dbHelper.getWritableDatabase();

           ContentValues values = new ContentValues();
           values.put("nombre", nombre);
           values.put("descripcion", descripcion);
           values.put("fecha_inicio", fecha_inicio);
           values.put("fecha_culminacion", fecha_culminacion);
           values.put("usuario_encargado", usuario_encargado);

           id = db.insert(TABLE_AGENDA, null, values);
       } catch(Exception ex){
           ex.toString();
       }
        return id;
    }

    public ArrayList <Actividades> mostrarActividades(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList  <Actividades> listaActividades = new ArrayList<>();
        Actividades actividades = null;
        Cursor cursorActividades = null;

        cursorActividades = db.rawQuery("SELECT * FROM " + TABLE_AGENDA, null);

        if(cursorActividades.moveToFirst()){
            do{
                actividades = new Actividades();
                actividades.setNombre(cursorActividades.getString(0));
                actividades.setDescripcion(cursorActividades.getString(1));
                actividades.setFecha_inicio(cursorActividades.getString(2));
                actividades.setFecha_culminacion(cursorActividades.getString(3));
                actividades.setUsuario_encargado(cursorActividades.getString(4));
                listaActividades.add(actividades);
            } while (cursorActividades.moveToNext());
        }
        cursorActividades.close();

        return listaActividades;
    }

    public  Actividades verActividad(String nombre){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Actividades actividades = null;
        Cursor cursorActividades;

        cursorActividades = db.rawQuery("SELECT * FROM " + TABLE_AGENDA + " WHERE nombre = " + nombre + " LIMIT 1 ", null);

        if(cursorActividades.moveToFirst()){
            actividades = new Actividades();
            actividades.setNombre(cursorActividades.getString(0));
            actividades.setDescripcion(cursorActividades.getString(1));
            actividades.setFecha_inicio(cursorActividades.getString(2));
            actividades.setFecha_culminacion(cursorActividades.getString(3));
            actividades.setUsuario_encargado(cursorActividades.getString(4));
        }
        cursorActividades.close();

        return actividades;
    }
}
