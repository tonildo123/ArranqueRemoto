package com.example.tony.arranqueremoto.Persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dbRegistro extends SQLiteOpenHelper {

    private static final String MI_BASE_DE_DATOS = "arranqueremoto.db";
    private static final int DATABASE_VERSION = 1;

    // Sentencia SQL para la creación de una tabla
    private static final String TABLA_CLIENTES = "CREATE TABLE registro" +
            "(usuario TEXT PRIMARY KEY, contraseña TEXT)";
    public dbRegistro(Context context, String s, Object o, int i) {
        super(context, MI_BASE_DE_DATOS, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CLIENTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS registro");
        onCreate(db);

    }

}
