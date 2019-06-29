package com.example.tony.arranqueremoto;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;


import com.example.tony.arranqueremoto.Vistas.MapsActivity;
import com.example.tony.arranqueremoto.Vistas.PresentarLogin;
import com.example.tony.arranqueremoto.Vistas.presentarEmergencias;

import static com.example.tony.arranqueremoto.R.id.bEmergencias;
import static com.example.tony.arranqueremoto.R.id.bIngresar;


public class MainActivity extends AppCompatActivity {
    private Button buscar, emergencia, wathsapp, login;


    android.support.v4.app.FragmentManager manejador = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wathsapp =(Button)findViewById(R.id.bSoporte);
        buscar =(Button)findViewById(R.id.bBuscar);
        emergencia =(Button)findViewById(R.id.bEmergencias);
        login =(Button)findViewById(R.id.bIngresar);

        wathsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador_del_main(v.getId());
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador_del_main(v.getId());
            }
        });
        emergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador_del_main(v.getId());
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador_del_main(v.getId());
            }
        });


    }
    public void presentador_del_main(int button){

        switch (button){
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
                startActivity(pasar);
                break;
            case bIngresar:
                manejador.beginTransaction().replace(R.id.contenedorPrincipal, new PresentarLogin()).addToBackStack(null).commit();
                break;
            case bEmergencias:
                manejador.beginTransaction().replace(R.id.contenedorPrincipal, new presentarEmergencias()).addToBackStack(null).commit();
                break;
        }

    }

}



