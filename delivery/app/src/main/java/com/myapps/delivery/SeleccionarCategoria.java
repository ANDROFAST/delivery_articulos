package com.myapps.delivery;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myapps.delivery.negocio.Categoria;

/**
 * Created by AMD on 15/11/2015.
 */
public class SeleccionarCategoria extends Fragment {
    public static final String TAG = "categoria";
    ListView lvCategoria;
    String codigo_categoria;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_seleccionar_categoria, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        lvCategoria = (ListView)view.findViewById(R.id.lvSelCatListado);
        lvCategoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                codigo_categoria = String.valueOf(Categoria.listaCategoria.get(position).getCodigo());

                Fragment fragment = new SeleccionarEmpresa();
                Bundle parametro = new Bundle();
                parametro.putString("categoria_seleccionada",codigo_categoria);
                fragment.setArguments(parametro);
                final FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.container, fragment, "tag");
                ft.addToBackStack("tag");
                ft.commit();
            }
        });

        AdapterCategoria adapter = new AdapterCategoria(getActivity());
        lvCategoria.setAdapter(adapter);
        try {
            new Categoria().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }
}
