package com.example.tony.arranqueremoto.Vistas;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tony.arranqueremoto.Persistencia.dbRegistro;
import com.example.tony.arranqueremoto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PresentarLogin extends Fragment {

    dbRegistro base_de_datos;
    EditText usuario, password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_fragment_interface, container, false);
        Button boton_ingresar = (Button)vista.findViewById(R.id.bIngresar2);
        Button boton_registrarme = (Button)vista.findViewById(R.id.bRegistrarme);
         usuario = (EditText)vista.findViewById(R.id.usuario);
         password = (EditText)vista.findViewById(R.id.password);

        boton_registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizar_llamado(v.getId());
            }
        });
        boton_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realizar_llamado(v.getId());


            }
        });
        return vista;
    }

    public void realizar_llamado(int botones){


        switch (botones){
            case R.id.bRegistrarme:
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.contenedorPrincipal, new Registrarme())
                        .addToBackStack(null).commit();
                break;
            case R.id.bIngresar2:
                getActivity().getSupportFragmentManager()
                        .beginTransaction().replace(R.id.contenedorPrincipal, new PantallaPrincipal())
                        .addToBackStack(null).commit();
                break;



        }

    }


    public void llamara_vista_princoal(){
        String txt_usuario  = usuario.getText().toString();
        String txt_password = password.getText().toString();
        boolean consulto_usuario = base_de_datos.consultarU(txt_usuario);
        boolean consulto_pasword = base_de_datos.consultarP(txt_password);
        if(consulto_usuario == true && consulto_pasword==true){
            llamara_vista_princoal();
            Toast.makeText(getContext(),
                    "   Bienvenido !!!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(),
                    "   Campos Vacios  !!! " +
                            "\n ¡¡¡¡  VERIFIQUE  !!!!", Toast.LENGTH_SHORT).show();

        }

    }




}
