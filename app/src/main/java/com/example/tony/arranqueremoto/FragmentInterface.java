package com.example.tony.arranqueremoto;


import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInterface extends Fragment {
    //Operations op;
    private Button bIng, bReg;

    private EditText usua, contra;
    dbRegistro mi_base_de_datos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista = inflater.inflate(R.layout.fragment_fragment_interface, container, false);
        usua= (EditText)vista.findViewById(R.id.usuario);
        contra = (EditText)vista.findViewById(R.id.password);
        bIng = (Button)vista.findViewById(R.id.bIngresar2);
        bReg = (Button)vista.findViewById(R.id.bRegistrarme);
        mi_base_de_datos = new dbRegistro(getContext(),"" , null, 1);

        bIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
      //           op.boton(v.getId());
                String usuarioC = usua.getText().toString();
                dbRegistro admin = new dbRegistro(getContext(),

                        "arranqueremoto.db", null, 1);
                SQLiteDatabase bd = admin.getReadableDatabase();

                Cursor fila = bd.rawQuery("select * from registro where usuario = " + usuarioC, null);

                usua.setText("");
                contra.setText("");

                if (fila != null) {
                    if(fila.moveToFirst()){
                        botones(v.getId());
                        fila.close();
                        bd.close();
                    }
                    else

                        Toast.makeText(getContext(), "No existe ningún registro con ese usuario ",

                                Toast.LENGTH_SHORT).show();

                }



           }
        });
        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botones(v.getId());


            }
        });

        return vista ;
    }

    public void botones(int id) {

        switch(id){
            case R.id.bRegistrarme:

                Registrarme reg = new Registrarme();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contenedorPrincipal, reg)
                        .addToBackStack(null).commit();
                break;
            case R.id.bIngresar2:
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.contenedorPrincipal, new PantallaPrincipal())
                        .addToBackStack(null).commit();
                break;

        }

    }


}


