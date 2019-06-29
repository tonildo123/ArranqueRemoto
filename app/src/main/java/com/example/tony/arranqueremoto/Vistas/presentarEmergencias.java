package com.example.tony.arranqueremoto.Vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tony.arranqueremoto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class presentarEmergencias extends Fragment {


    public presentarEmergencias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_pantalla_emergencias, container, false);


        return vista;
    }

}
