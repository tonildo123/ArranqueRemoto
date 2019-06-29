package com.example.tony.arranqueremoto.Persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.tony.arranqueremoto.MainActivity;


public class dbRegistro extends SQLiteOpenHelper {
    MainActivity activity;

    private static final String MI_BASE_DE_DATOS = "arranqueremoto.db";
    private static final int DATABASE_VERSION = 1;

    // Sentencia SQL para la creación de una tabla
    private static final String TABLA_CLIENTES = "CREATE TABLE registro" +
            "(usuario TEXT PRIMARY KEY, password TEXT)";
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
    public void registrar(String usuario, String pass){
        ContentValues valores = new ContentValues();

            valores.put("usuario", usuario);
            valores.put("password", pass);
            this.getWritableDatabase().insertOrThrow("registro", "", valores);




    }
    public Boolean consultarU(String usuario){
        SQLiteDatabase bd = this.getReadableDatabase();

        Cursor fila = bd.rawQuery("Select  * from registro where password =", new String[]{usuario});
        if(fila.getCount()>0) return true;
        else return false;
    }
    public Boolean consultarP(String pass){
        SQLiteDatabase bd = this.getReadableDatabase();
        Cursor fila = bd.rawQuery("Select  * from registro where password =?", new String[]{pass});


        if(fila.getCount()>0) return true;
        else return false;
            //String password = "select * from registro where password = "+pass;
        //Cursor fila = bd.rawQuery( password , null);

        /*if(fila != null){
            return true;
        } else {return false;}*/
    }

}
