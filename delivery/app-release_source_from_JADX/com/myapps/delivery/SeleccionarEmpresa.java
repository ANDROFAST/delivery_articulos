package com.myapps.delivery;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.myapps.delivery.negocio.Empresa;

public class SeleccionarEmpresa extends Fragment {
    public static final String TAG = "empresa";
    Button btnIrCategorias;
    String cod_cat;
    String codigo_empresa;
    ListView lvEmpresa;

    class C04881 implements OnClickListener {
        C04881() {
        }

        public void onClick(View v) {
            SeleccionarEmpresa.this.getFragmentManager().beginTransaction().replace(C0477R.id.container, SeleccionarEmpresa.this.getFragmentManager().findFragmentByTag(SeleccionarCategoria.TAG), SeleccionarCategoria.TAG).commit();
        }
    }

    class C04892 implements OnItemClickListener {
        C04892() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            SeleccionarEmpresa.this.codigo_empresa = String.valueOf(((Empresa) Empresa.listaEmpresa.get(position)).getCodigo());
            Fragment fragment = new SeleccionarArticulo();
            Bundle parametro = new Bundle();
            parametro.putString("empresa_seleccionada", SeleccionarEmpresa.this.codigo_empresa);
            parametro.putString("categoria_seleccionada", SeleccionarEmpresa.this.cod_cat);
            fragment.setArguments(parametro);
            FragmentTransaction ft = SeleccionarEmpresa.this.getFragmentManager().beginTransaction();
            ft.replace(C0477R.id.container, fragment, "tag");
            ft.addToBackStack("tag");
            ft.commit();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0477R.layout.fragment_seleccionar_empresa, container, false);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.lvEmpresa = (ListView) view.findViewById(C0477R.id.lvlSelEmpListado);
        this.btnIrCategorias = (Button) view.findViewById(C0477R.id.btnIrCategorias);
        this.btnIrCategorias.setOnClickListener(new C04881());
        this.lvEmpresa.setAdapter(new AdapterEmpresa(getActivity()));
        this.lvEmpresa.setOnItemClickListener(new C04892());
        try {
            String codigo_categoria = getArguments().getString("categoria_seleccionada");
            this.cod_cat = codigo_categoria;
            new Empresa().listar(codigo_categoria, "");
        } catch (Exception e) {
            Toast.makeText(getActivity(), e.getMessage(), 1).show();
        }
        return view;
    }
}
