package com.myapps.delivery;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Inicio extends Fragment {
    public static final String TAG = "inicio";
    TextView etiquetaNombreUsuario;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio, container, false);

        etiquetaNombreUsuario = (TextView)view.findViewById(R.id.txtInicioNombreUsuario);
        Bundle parametros1 = getActivity().getIntent().getExtras();
        String nombre = parametros1.getString("par_nombre");
        String email = parametros1.getString("par_email");

        etiquetaNombreUsuario.setText(nombre);

        return view;
    }
}
