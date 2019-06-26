package com.example.tony.arranqueremoto.Persistencia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class OperacionesSQLHelper {
    dbRegistro mi_base_de_datos;

    public void registrar(String usuario, String pass){
        ContentValues valores = new ContentValues();
            valores.put("usuario", usuario);
            valores.put("contraseña", pass);
            mi_base_de_datos.getWritableDatabase().insertOrThrow("registro", "", valores);
    }
    public Boolean consultarU(String usuario){
        SQLiteDatabase bd = mi_base_de_datos.getReadableDatabase();

        String user = "select * from registro where usuario = "+usuario;
        Cursor fila = bd.rawQuery( user , null);

        if(fila != null){
            return true;

        } else {return false;}
    }
    public Boolean consultarP(String pass){
        SQLiteDatabase bd = mi_base_de_datos.getReadableDatabase();

        String password = "select * from registro where password = "+pass;
        Cursor fila = bd.rawQuery( password , null);

        if(fila != null){
            return true;
        } else {return false;}}

}
