package com.myapps.delivery;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.myapps.delivery.negocio.Categoria;

public class SeleccionarCategoria extends Fragment {
    public static final String TAG = "categoria";
    String codigo_categoria;
    ListView lvCategoria;

    class C04871 implements OnItemClickListener {
        C04871() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            SeleccionarCategoria.this.codigo_categoria = String.valueOf(((Categoria) Categoria.listaCategoria.get(position)).getCodigo());
            Fragment fragment = new SeleccionarEmpresa();
            Bundle parametro = new Bundle();
            parametro.putString("categoria_seleccionada", SeleccionarCategoria.this.codigo_categoria);
            fragment.setArguments(parametro);
            FragmentTransaction ft = SeleccionarCategoria.this.getFragmentManager().beginTransaction();
            ft.replace(C0477R.id.container, fragment, "tag");
            ft.addToBackStack("tag");
            ft.commit();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0477R.layout.fragment_seleccionar_categoria, container, false);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.lvCategoria = (ListView) view.findViewById(C0477R.id.lvSelCatListado);
        this.lvCategoria.setOnItemClickListener(new C04871());
        this.lvCategoria.setAdapter(new AdapterCategoria(getActivity()));
        try {
            new Categoria().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
