package com.myapps.delivery;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.myapps.delivery.negocio.Articulo;
import com.myapps.delivery.negocio.Empresa;
import com.myapps.delivery.negocio.PedidoDetalle;
import com.myapps.delivery.negocio.Sesion;
import com.myapps.delivery.negocio.Votacion;
import com.myapps.delivery.util.C0492F;

public class SeleccionarArticulo extends Fragment {
    public static final String TAG = "articulo";
    PedidoDetalle PD = null;
    Articulo articulo_temporal = null;
    Button btnIrEmpresas;
    EditText cantidad;
    String codigo_empresa;
    AlertDialog dialogSelecVotar;
    ListView lvArticulo;

    class C04781 implements OnClickListener {
        C04781() {
        }

        public void onClick(View v) {
            String codigo_categoria = SeleccionarArticulo.this.getArguments().getString("categoria_seleccionada");
            Fragment fragment = new SeleccionarEmpresa();
            Bundle parametro = new Bundle();
            parametro.putString("categoria_seleccionada", codigo_categoria);
            fragment.setArguments(parametro);
            FragmentTransaction ft = SeleccionarArticulo.this.getFragmentManager().beginTransaction();
            ft.replace(C0477R.id.container, fragment, "tag");
            ft.addToBackStack("tag");
            ft.commit();
        }
    }

    class C04792 implements OnItemClickListener {
        C04792() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            SeleccionarArticulo.this.articulo_temporal = (Articulo) Articulo.listaArticulo.get(position);
            SeleccionarArticulo.this.PD = new PedidoDetalle(new Empresa(Integer.parseInt(SeleccionarArticulo.this.codigo_empresa)), SeleccionarArticulo.this.articulo_temporal, "0", "0");
            try {
                if (SeleccionarArticulo.this.PD.existe()) {
                    SeleccionarArticulo.this.PD = null;
                    C0492F.msg(SeleccionarArticulo.this.getActivity(), "El articulo seleccionado ya existe en el carrito");
                    return;
                }
            } catch (Exception e) {
                C0492F.msg(SeleccionarArticulo.this.getActivity(), e.getMessage());
            }
            SeleccionarArticulo.this.iniciarAlerta().show();
        }
    }

    class C04803 implements OnItemLongClickListener {
        C04803() {
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
            int cod_arti = ((Articulo) Articulo.listaArticulo.get(position)).getCodigo();
            String nombreArti = ((Articulo) Articulo.listaArticulo.get(position)).getNombre();
            SeleccionarArticulo.this.dialogSelecVotar = SeleccionarArticulo.this.seleccionarOperacionVotar(cod_arti, nombreArti);
            SeleccionarArticulo.this.dialogSelecVotar.show();
            return true;
        }
    }

    class C04814 implements DialogInterface.OnClickListener {
        C04814() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    class C04825 implements DialogInterface.OnClickListener {
        C04825() {
        }

        public void onClick(DialogInterface dialog, int id) {
            SeleccionarArticulo.this.pedirCantidad().show();
        }
    }

    class C04836 implements DialogInterface.OnClickListener {
        C04836() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    class C04847 implements DialogInterface.OnClickListener {
        C04847() {
        }

        public void onClick(DialogInterface dialog, int id) {
            SeleccionarArticulo.this.agregarCarrito();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0477R.layout.fragment_seleccionar_articulo, container, false);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.lvArticulo = (ListView) view.findViewById(C0477R.id.lvSelArticulo);
        this.btnIrEmpresas = (Button) view.findViewById(C0477R.id.btnIrEmpresas);
        this.btnIrEmpresas.setOnClickListener(new C04781());
        this.lvArticulo.setAdapter(new AdapterArticulo(getActivity()));
        try {
            String codigo_e = getArguments().getString("empresa_seleccionada");
            this.codigo_empresa = codigo_e;
            new Articulo().listar(codigo_e);
        } catch (Exception e) {
            C0492F.msg(getActivity(), e.getMessage());
        }
        this.lvArticulo.setOnItemClickListener(new C04792());
        this.lvArticulo.setOnItemLongClickListener(new C04803());
        return view;
    }

    private AlertDialog iniciarAlerta() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Articulos");
        alertDialogBuilder.setMessage("Desea guardar este articulo?").setCancelable(true).setPositiveButton("Si", new C04825()).setNegativeButton("No", new C04814());
        return alertDialogBuilder.create();
    }

    private AlertDialog pedirCantidad() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        View promptView = getActivity().getLayoutInflater().inflate(C0477R.layout.cantidad_modal, null);
        alertDialogBuilder.setView(promptView);
        this.cantidad = (EditText) promptView.findViewById(C0477R.id.txtCantidadArticulo);
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new C04847()).setNegativeButton("Cancel", new C04836());
        return alertDialogBuilder.create();
    }

    private void agregarCarrito() {
        String cant = this.cantidad.getText().toString();
        int cantInt = Integer.parseInt(cant);
        if (cantInt < 0 || cant.equals("")) {
            C0492F.msg(getActivity(), "Cantidad no v?lida");
        } else if (cantInt > this.articulo_temporal.getStock()) {
            C0492F.msg(getActivity(), "Lo deseado sobrepasa el stock actual");
        } else {
            try {
                this.PD.setCantidad(cant);
                if (this.PD.registrarTemporal()) {
                    C0492F.msg(getActivity(), "Articulo agregado al carrito");
                }
            } catch (Exception e) {
                C0492F.msg(getActivity(), e.getMessage());
            }
        }
    }

    public AlertDialog seleccionarOperacionVotar(final int cod_articulo, final String nombre_Articulo) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Votacion");
        View v = getActivity().getLayoutInflater().inflate(C0477R.layout.item_dialog_votar, null);
        builder.setView(v);
        LinearLayout estadisticasArticulo = (LinearLayout) v.findViewById(C0477R.id.layout_estadisticas_art);
        ((LinearLayout) v.findViewById(C0477R.id.layout_votar_por_articulo)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Bundle paraVotar = new Bundle();
                paraVotar.putInt("cod_arti", cod_articulo);
                paraVotar.putString("nombre_arti", nombre_Articulo);
                int estadoHaVotadoYa = 0;
                try {
                    estadoHaVotadoYa = new Votacion().verificarSiYaVoto(String.valueOf(cod_articulo), Sesion.codUsuario);
                } catch (Exception e) {
                    e.getMessage();
                }
                if (estadoHaVotadoYa == 1) {
                    Toast.makeText(SeleccionarArticulo.this.getActivity(), "Ya ha votado por este articulo", 0).show();
                    return;
                }
                Intent pantallaVotarPorArti = new Intent(SeleccionarArticulo.this.getActivity(), VotarPorArticulo.class);
                pantallaVotarPorArti.putExtras(paraVotar);
                SeleccionarArticulo.this.getActivity().startActivity(pantallaVotarPorArti);
                SeleccionarArticulo.this.dialogSelecVotar.dismiss();
            }
        });
        estadisticasArticulo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Bundle paraGrafico = new Bundle();
                paraGrafico.putInt("cod_articulo", cod_articulo);
                paraGrafico.putString("nombre_articulo", nombre_Articulo);
                int estadoHayVotos = 0;
                try {
                    estadoHayVotos = new Votacion().validarSiHayVotosParaArticulo(String.valueOf(cod_articulo));
                } catch (Exception e) {
                    e.getMessage();
                }
                if (estadoHayVotos == 1) {
                    Intent pantallaGraficoArti = new Intent(SeleccionarArticulo.this.getActivity(), EstadisticasArticulo.class);
                    pantallaGraficoArti.putExtras(paraGrafico);
                    SeleccionarArticulo.this.getActivity().startActivity(pantallaGraficoArti);
                    SeleccionarArticulo.this.dialogSelecVotar.dismiss();
                    return;
                }
                Toast.makeText(SeleccionarArticulo.this.getActivity(), "No hay registro de votaciones para el articulo, SE EL PRIMERO EN VOTAR!", 0).show();
            }
        });
        return builder.create();
    }
}
