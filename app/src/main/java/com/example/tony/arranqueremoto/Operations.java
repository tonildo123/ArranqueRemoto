package com.example.tony.arranqueremoto;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.telephony.PhoneNumberUtils;
import android.widget.Button;

public class Operations extends FragmentActivity {


    public void boton(int button){
        FragmentManager m = getSupportFragmentManager();
        int b = button;
        switch (b){
            case R.id.bIngresar:
                m.beginTransaction().replace(R.id.contenedorPrincipal, new PantallaPrincipal()).addToBackStack(null).commit();
                break;
            case R.id.bRegistrarme:
                m.beginTransaction()
                        .replace(R.id.contenedorPrincipal, new Registrarme()).addToBackStack(null).commit();
                break;
            case R.id.bEmergencias:
                m.beginTransaction()
                        .replace(R.id.contenedorPrincipal, new PantallaEmergencias()).addToBackStack(null).commit();
                break;
            case R.id.bBuscar:
                Intent pasar = new Intent(getApplicationContext(), MapsActivity.class);
                getApplicationContext().startActivity(pasar);
                break;

            default: break;
        }

    }

}
