package com.example.tony.arranqueremoto;


import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registrarme extends Fragment {

    private  Button bg;
    private EditText et1, et2, et3;
    dbRegistro mi_Base_de_Datos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_registrarme, container, false);
        // Inflate the layout for this fragment
        bg = (Button)vista.findViewById(R.id.bGurdarUsuario);
        et1 =(EditText)vista.findViewById(R.id.etUsuario);
        et2 =(EditText)vista.findViewById(R.id.etContra1);
        et3 =(EditText)vista.findViewById(R.id.etContra2);
        mi_Base_de_Datos = new dbRegistro(getContext(), "",null,  1);

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et2.getText().toString().equals(et3.getText().toString())){
                    cargarUsurario(v);}

            }
        });


        return vista;
    }

    public void cargarUsurario(View v) {



            try {
                mi_Base_de_Datos.alta_registro(
                        et1.getText().toString(),
                        et2.getText().toString());
                        Toast.makeText(getContext(), "Datos de Usuario"
                                +"\n"
                                + et1.getText().toString() +"\n"
                                + et2.getText().toString() +"\n"
                                +"\n cargados", Toast.LENGTH_SHORT).show();
                // ponemos los campos a vacío para insertar el siguiente usuario

                et1.setText(""); et2.setText(""); et3.setText("");
            }catch(SQLiteException e){

                Toast.makeText(getContext(), "contacto ya existe", Toast.LENGTH_SHORT).show();
            }



    }

}
