package com.example.tony.arranqueremoto;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PantallaEmergencias extends Fragment {

    private Button b1, b2, b3;
    String numero;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista =  inflater.inflate(R.layout.fragment_pantalla_emergencias, container, false);

        b1 = (Button)vista.findViewById(R.id.buttonPolicia);
        b2 = (Button)vista.findViewById(R.id.buttonAmbulancia);
        b3 = (Button)vista.findViewById(R.id.buttonBomberos);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent llamar = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 911 "));
                    startActivity(llamar);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent llamar = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 107 "));
                    startActivity(llamar);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent llamar = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 100 "));
                    startActivity(llamar);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        return vista;
    }

}
