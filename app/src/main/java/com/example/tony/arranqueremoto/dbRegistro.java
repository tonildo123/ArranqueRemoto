package com.example.tony.arranqueremoto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

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

    public void alta_registro(String usuario, String contraseña) {
        ContentValues valores = new ContentValues();
        valores.put("usuario", usuario);
        valores.put("contraseña", contraseña);

        this.getWritableDatabase().insertOrThrow("registro", "", valores);

    }



    public void modificar_registro(String usuario, String usuario2, String contraseña) {
        this.getWritableDatabase().execSQL
                ("UPDATE contactos SET usuario='" + usuario2 + "' " +
                        ", contraeña='" + contraseña + "' " +
                        "WHERE usuario='" + usuario + "'");
    }



}
