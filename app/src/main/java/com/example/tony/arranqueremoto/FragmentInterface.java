package com.example.tony.arranqueremoto;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInterface extends Fragment {
    private String num = "3814757398";

    private EditText usua, contra;
    private Button ingresar, registrarme, wathsapp, emergencia, mi_ubicacion;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_fragment_interface, container, false);
        usua= (EditText)vista.findViewById(R.id.usuario);
        contra = (EditText)vista.findViewById(R.id.password);


        ingresar = (Button)vista.findViewById(R.id.bIngresar);
        registrarme = (Button)vista.findViewById(R.id.bRegistrarme);
        emergencia = (Button)vista.findViewById(R.id.bEmergencias);
        wathsapp = (Button)vista.findViewById(R.id.bContactos);
        mi_ubicacion  = (Button)vista.findViewById(R.id.bBuscar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PantallaPrincipal pp = new PantallaPrincipal();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorPrincipal, pp)
                        .addToBackStack(null).commit();

            }
        });
        registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrarme reg = new Registrarme();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorPrincipal, reg)
                        .addToBackStack(null).commit();
            }
        });
        emergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PantallaEmergencias pe = new PantallaEmergencias();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorPrincipal, pe)
                        .addToBackStack(null).commit();
            }
        });
        mi_ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasar = new Intent(getActivity(), MapsActivity.class);
                getActivity().startActivity(pasar);
            }
        });
        wathsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent _intencion = new Intent("android.intent.action.MAIN");
                _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
                _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators("54" +num )
                        +"@s.whatsapp.net");
                getActivity().startActivity(_intencion);
            }
        });


        return vista ;
    }

}
