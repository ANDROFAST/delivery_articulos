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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0477R.layout.fragment_inicio, container, false);
        this.etiquetaNombreUsuario = (TextView) view.findViewById(C0477R.id.txtInicioNombreUsuario);
        Bundle parametros1 = getActivity().getIntent().getExtras();
        String nombre = parametros1.getString("par_nombre");
        String email = parametros1.getString("par_email");
        this.etiquetaNombreUsuario.setText(nombre);
        return view;
    }
}
