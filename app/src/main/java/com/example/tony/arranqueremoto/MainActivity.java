package com.example.tony.arranqueremoto;

import android.Manifest;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final int codigo_de_repuesta_escritura = 0;
    private  Button b1, b3, b4, b5;
    // UI references.



    android.support.v4.app.FragmentManager manejador = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b5 = (Button)findViewById(R.id.bEmergencias);
        b4 = (Button)findViewById(R.id.bBuscar);
        b3 = (Button)findViewById(R.id.bSoporte);
        b1 = (Button)findViewById(R.id.bIngresar);
        // permisos y parametros necesario para mostar mi posicion
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        codigo_de_repuesta_escritura);
            }
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones(v.getId());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones(v.getId());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones(v.getId());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones(v.getId());
            }
        });


        //manejador.beginTransaction().replace(R.id.contenedorPrincipal, new FragmentInterface()).commit();


    }

    public void botones(int boton) {
        switch(boton){

            case R.id.bSoporte:
                String num = "3814757398";
                Intent _intencion = new Intent("android.intent.action.MAIN");
                _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
                _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("54 9 " +num )
                        +"@s.whatsapp.net");
                startActivity(_intencion);;
                break;
            case R.id.bBuscar:
                Intent pasar = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(pasar);;
                break;
            case R.id.bEmergencias:
                manejador.beginTransaction().replace(R.id.contenedorPrincipal, new PantallaEmergencias()).commit();
                break;
            case R.id.bIngresar:
                manejador.beginTransaction().replace(R.id.contenedorPrincipal, new FragmentInterface()).commit();
                break;

        }

    }

}
