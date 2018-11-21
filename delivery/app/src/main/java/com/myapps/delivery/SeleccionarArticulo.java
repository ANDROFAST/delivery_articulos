package com.myapps.delivery;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
import com.myapps.delivery.util.F;

/**
 * Created by AMD on 16/11/2015.
 */
public class SeleccionarArticulo extends Fragment {
    public static final String TAG = "articulo";
    ListView lvArticulo;
    String codigo_empresa;
    EditText cantidad;
    Articulo articulo_temporal = null;
    PedidoDetalle PD = null;
    AlertDialog dialogSelecVotar;

    Button btnIrEmpresas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_seleccionar_articulo, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        lvArticulo = (ListView)view.findViewById(R.id.lvSelArticulo);
        btnIrEmpresas = (Button)view.findViewById(R.id.btnIrEmpresas);
        btnIrEmpresas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo_categoria  = getArguments().getString("categoria_seleccionada");

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

        AdapterArticulo adapter = new AdapterArticulo(getActivity());
        lvArticulo.setAdapter(adapter);

        try {
            String codigo_e  = getArguments().getString("empresa_seleccionada");//Recibir parametro del fragment SeleccionarEmpresa
            codigo_empresa=codigo_e;
            new Articulo().listar(codigo_e);
        } catch (Exception e) {
            F.msg(getActivity(), e.getMessage());
        }

        lvArticulo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                articulo_temporal = Articulo.listaArticulo.get(position);
                PD = new PedidoDetalle(
                        new Empresa(Integer.parseInt(codigo_empresa)),
                        articulo_temporal,
                        "0", "0");
                try {
                    if (PD.existe()) {
                        PD = null;
                        F.msg(getActivity(), "El articulo seleccionado ya existe en el carrito");
                        return;
                    }
                } catch (Exception e) {
                    F.msg(getActivity(), e.getMessage());
                }
                AlertDialog alertDialog = iniciarAlerta();
                alertDialog.show();
            }
        });
        lvArticulo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(),"Votar: "+position, Toast.LENGTH_SHORT).show();
                int cod_arti = Articulo.listaArticulo.get(position).getCodigo();
                String nombreArti = Articulo.listaArticulo.get(position).getNombre();
                dialogSelecVotar = seleccionarOperacionVotar(cod_arti, nombreArti);
                dialogSelecVotar.show();

                return true;
            }
        });


        return view;
    }


    private AlertDialog iniciarAlerta(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Articulos");

        alertDialogBuilder
                .setMessage("Desea guardar este articulo?")
                .setCancelable(true)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        AlertDialog alertDialog = pedirCantidad();
                        alertDialog.show();	;
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return alertDialogBuilder.create();
    }

    private AlertDialog pedirCantidad(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =  getActivity().getLayoutInflater();

        View promptView = inflater.inflate(R.layout.cantidad_modal, null);
        alertDialogBuilder.setView(promptView);
        cantidad = (EditText) promptView.findViewById(R.id.txtCantidadArticulo);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        agregarCarrito();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return alertDialogBuilder.create();
    }

    private void agregarCarrito(){
        String cant = cantidad.getText().toString();
        int cantInt = Integer.parseInt(cant);

        //Cantidad inv?lida
        if ( cantInt < 0 || cant.equals("")){
            F.msg(getActivity(), "Cantidad no v?lida");
            return ;
        }
        //Sobrepaso de stock
        if (cantInt > articulo_temporal.getStock()){
            F.msg(getActivity(), "Lo deseado sobrepasa el stock actual");
            return ;
        }		//

        try {
            PD.setCantidad(cant);
            if (PD.registrarTemporal()){
                F.msg(getActivity(), "Articulo agregado al carrito");
            }

        } catch (Exception e) {
            F.msg(getActivity(), e.getMessage());
        }
    }



    public AlertDialog seleccionarOperacionVotar(final int cod_articulo, final String nombre_Articulo){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Votacion");
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.item_dialog_votar, null);

        builder.setView(v);
        LinearLayout votarPorArticulo= (LinearLayout) v.findViewById(R.id.layout_votar_por_articulo);
        LinearLayout estadisticasArticulo= (LinearLayout)v.findViewById(R.id.layout_estadisticas_art);

        votarPorArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle paraVotar = new Bundle();
                paraVotar.putInt("cod_arti", cod_articulo);
                paraVotar.putString("nombre_arti", nombre_Articulo);

                int estadoHaVotadoYa=0;
                try {
                    Votacion objV=new Votacion();
                    estadoHaVotadoYa=objV.verificarSiYaVoto(String.valueOf(cod_articulo), Sesion.codUsuario);
                }catch(Exception e){
                    e.getMessage();
                }

                if(estadoHaVotadoYa==1){
                    Toast.makeText(getActivity(), "Ya ha votado por este articulo", Toast.LENGTH_SHORT).show();
                }else{
                    Intent pantallaVotarPorArti = new Intent(getActivity(), VotarPorArticulo.class);
                    pantallaVotarPorArti.putExtras(paraVotar);
                    getActivity().startActivity(pantallaVotarPorArti);
                    dialogSelecVotar.dismiss();
                }
            }
        });

        estadisticasArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle paraGrafico = new Bundle();
                paraGrafico.putInt("cod_articulo", cod_articulo);
                paraGrafico.putString("nombre_articulo", nombre_Articulo);
                int estadoHayVotos=0;
                try {
                    Votacion objV=new Votacion();
                    estadoHayVotos=objV.validarSiHayVotosParaArticulo(String.valueOf(cod_articulo));
                }catch(Exception e){
                    e.getMessage();
                }
                if(estadoHayVotos==1){//Si hay registro de votaciones, entonces muestra grafico de barras de votaciones
                    Intent pantallaGraficoArti = new Intent(getActivity(), EstadisticasArticulo.class);
                    pantallaGraficoArti.putExtras(paraGrafico);
                    getActivity().startActivity(pantallaGraficoArti);
                    dialogSelecVotar.dismiss();
                }
                else{
                    Toast.makeText(getActivity(), "No hay registro de votaciones para el articulo, SE EL PRIMERO EN VOTAR!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return builder.create();
    }


}

