package com.example.tony.arranqueremoto.Vistas;


import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tony.arranqueremoto.Persistencia.OperacionesSQLHelper;
import com.example.tony.arranqueremoto.R;
import com.example.tony.arranqueremoto.Persistencia.dbRegistro;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registrarme extends Fragment {

    private  Button bg;
    private EditText et1, et2, et3;
    dbRegistro mi_Base_de_Datos;
    OperacionesSQLHelper sqlHelper = new OperacionesSQLHelper();

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
                String usuario = et1.getText().toString();
                String pass1 = et1.getText().toString();
                String pass2 = et1.getText().toString();


                if (pass1 == pass2){
                    try {
                        sqlHelper.registrar(usuario, pass1);
                        Toast.makeText(getContext(), "Datos de Usuario"
                                +"\n"
                                + usuario +"\n"
                                + pass1 +"\n"
                                +"\n cargados correctamente!", Toast.LENGTH_SHORT).show();
                    }catch (SQLiteException e){ Toast.makeText(getContext(),
                            "contacto ya existe", Toast.LENGTH_SHORT).show();}


                    //cargarUsurario(v); asi se pasa toda la vista
                }

            }
        });


        return vista;
    }


}
