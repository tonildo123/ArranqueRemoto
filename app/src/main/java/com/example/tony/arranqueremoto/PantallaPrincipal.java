package com.example.tony.arranqueremoto;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PantallaPrincipal extends Fragment {

    android.support.v4.app.FragmentManager manejador = getFragmentManager();
    private Button buscar, apagar, arrancar, conectar, emergencias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_pantalla_principal, container, false);

        conectar = (Button)vista.findViewById(R.id.bBonnBluetooth);
        apagar = (Button)vista.findViewById(R.id.bApagar);
        arrancar = (Button)vista.findViewById(R.id.bArranque);


        return vista;
    }

}
