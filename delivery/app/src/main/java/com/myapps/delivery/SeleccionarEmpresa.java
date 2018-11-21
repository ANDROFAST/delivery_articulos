package com.myapps.delivery;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.myapps.delivery.negocio.Empresa;

/**
 * Created by AMD on 16/11/2015.
 */
public class SeleccionarEmpresa extends Fragment {
    public static final String TAG = "empresa";
    ListView lvEmpresa;
    String codigo_empresa;
    String cod_cat;
    Button btnIrCategorias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_seleccionar_empresa, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        lvEmpresa = (ListView)view.findViewById(R.id.lvlSelEmpListado);
        btnIrCategorias = (Button)view.findViewById(R.id.btnIrCategorias);
        btnIrCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = getFragmentManager().findFragmentByTag(SeleccionarCategoria.TAG);
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, SeleccionarCategoria.TAG).commit();
            }
        });

        AdapterEmpresa adapter = new AdapterEmpresa(getActivity());
        lvEmpresa.setAdapter(adapter);
        lvEmpresa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                codigo_empresa = String.valueOf(Empresa.listaEmpresa.get(position).getCodigo());

                Fragment fragment = new SeleccionarArticulo();
                Bundle parametro = new Bundle();
                parametro.putString("empresa_seleccionada",codigo_empresa);
                parametro.putString("categoria_seleccionada", cod_cat);
                fragment.setArguments(parametro);
                final FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.container, fragment, "tag");
                ft.addToBackStack("tag");
                ft.commit();
            }
        });

        try {

            String codigo_categoria  = getArguments().getString("categoria_seleccionada");//Recibir parametro del fragment SeleccionarCategoria
            cod_cat=codigo_categoria;
            new Empresa().listar(codigo_categoria, "");

        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return view;
    }
}
