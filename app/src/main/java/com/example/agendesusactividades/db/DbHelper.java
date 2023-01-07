package com.example.agendesusactividades.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "agenda.db";
    public static final String TABLE_AGENDA = "t_agenda";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_AGENDA + "(" +
                " nombre TEXT NOT NULL," +
                " descripcion TEXT NOT NULL," +
                " fecha_inicio TEXT NOT NULL," +
                " fecha_culminacion TEXT NOT NULL," +
                " usuario_encargado TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_AGENDA);
        onCreate(sqLiteDatabase);
    }
}
