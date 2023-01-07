package com.example.agendesusactividades.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbAgenda extends DbHelper{

    Context context;

    public DbAgenda(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarAgenda(String nombre, String descripcion, String fecha_inicio, String fecha_culminacion, String usuario_encargado ){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("descripcion", descripcion);
            values.put("fecha_inicio", fecha_inicio);
            values.put("fecha_culminacion", fecha_culminacion);
            values.put("ususario_encargado", usuario_encargado);

            id = db.insert(TABLE_AGENDA, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }
}
