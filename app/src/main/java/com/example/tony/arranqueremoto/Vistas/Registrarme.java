package com.example.tony.arranqueremoto.Vistas;


import android.app.ProgressDialog;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tony.arranqueremoto.R;
import com.example.tony.arranqueremoto.Persistencia.dbRegistro;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registrarme extends Fragment {

    private Button bg;
    private EditText et1, et2, et3;
    private String usuario, pass1, pass2;
    dbRegistro mi_Base_de_Datos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_registrarme, container, false);

        bg = (Button)vista.findViewById(R.id.bGurdarUsuario);
        et1 =(EditText)vista.findViewById(R.id.etUsuario);
        et2 =(EditText)vista.findViewById(R.id.etContra1);
        et3 =(EditText)vista.findViewById(R.id.etContra2);
        mi_Base_de_Datos = new dbRegistro(getContext(), "",null,  1);



        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = et1.getText().toString();
                pass1   = et2.getText().toString();
                pass2   = et3.getText().toString();
                try {

                    mi_Base_de_Datos.registrar(usuario, pass1);
                    Toast.makeText(getContext(), "Datos de Usuario"
                            +"\n"
                            + usuario +"\n"
                            + pass1 +"\n"
                            +"\n cargados correctamente!", Toast.LENGTH_SHORT).show();
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");

                }catch (SQLiteException e){ Toast.makeText(getContext(),
                        "contacto ya existe", Toast.LENGTH_SHORT).show();}


            }

        });


        return vista;
    }




}








