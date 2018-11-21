package com.myapps.delivery;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapps.delivery.negocio.Pedido;
import com.myapps.delivery.negocio.PedidoDetalle;
import com.myapps.delivery.util.F;
import com.myapps.delivery.util.PP;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

//import android.support.v4.app.Fragment;

/**
 * Created by AMD on 17/11/2015.
 */
public class MostrarCarrito extends Fragment implements View.OnClickListener{
    public static final String TAG = "mostrar_carrito";
    TextView etiquetaNombreUsuario;
    AlertDialog modoPago;
    ListView lvDetallePedido;
    Button btnDireccion;
    TextView lblDireccion;
    Button btnRegistrarPedido;
    Button btnIrProductos;

    EditText cantidad;

    Pedido P;
    PedidoDetalle PD;
    String[] opciones = new String[]{"Variar cantidad","Quitar del carrito"};

    PayPalPayment pago;
    //
    public static double lat = 0;
    public static double lon = 0;
    public static boolean checked = false; //Se ha chequeado el mapa.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mostrar_carrito, container, false);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        btnIrProductos = (Button)view.findViewById(R.id.btnIrProductos);
        btnIrProductos.setOnClickListener(this);

        btnDireccion = (Button)view.findViewById(R.id.btnDireccion);
        btnDireccion.setOnClickListener(this);

        lblDireccion = (TextView)view.findViewById(R.id.lblDireccion);

        lvDetallePedido = (ListView)view.findViewById(R.id.lvSelPedidoDetalle);
        lvDetallePedido.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PD = PedidoDetalle.listaPedido.get(position);
                AlertDialog alertDialog = opcionesItem();
                alertDialog.show();
            }
        });

        btnRegistrarPedido = (Button)view.findViewById(R.id.btnRegistrarPedido);
        btnRegistrarPedido.setOnClickListener(this);

        AdapterPedidoDetalle adapter = new AdapterPedidoDetalle(getActivity());
        lvDetallePedido.setAdapter(adapter);

        P = new Pedido();
        try {
            new PedidoDetalle().listar();
        } catch (Exception e) {
            F.msg(getActivity(), e.getMessage());
        }


        Intent intent = new Intent(getActivity(), PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, PP.config);
        getActivity().startService(intent);

        return view;
    }

    public double calcularTotal(){
        double total=0;
        for(int i=0; i<PedidoDetalle.listaPedido.size();i++){
            total=total+(Double.parseDouble(PedidoDetalle.listaPedido.get(i).getSubTotal()));
        }
        return total;
    }

    @Override
    public void onClick(View v) {
        //Button b = (Button) v; int id =  b.getId();

        switch (v.getId()){
            case R.id.btnDireccion:
                mostrarMapa();
                break;
            case R.id.btnRegistrarPedido:
                preRegistrarPedido();
                break;
            case R.id.btnIrProductos:
                Fragment fragment;
                fragment = getFragmentManager().findFragmentByTag(SeleccionarCategoria.TAG);
                if (fragment == null) {
                    fragment = new SeleccionarCategoria();
                }
                getFragmentManager().beginTransaction().replace(R.id.container, fragment, SeleccionarCategoria.TAG).commit();
                break;
        }
    }

    //====================================================================================

    private void mostrarMapa(){
        Intent pantalla = new Intent(getActivity(), SeleccionarDireccion.class);
        this.startActivity(pantalla);
    }

    private AlertDialog opcionesItem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selecciona una operacion")
                .setItems(opciones, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog alertDialog = null;
                        switch (which) {
                            case 0:
                                alertDialog = pedirCantidad();
                                alertDialog.show();
                                break;
                            case 1:
                                alertDialog = deseaQuitar();
                                alertDialog.show();
                                break;
                        }

                    }
                });
        return builder.create();
    }

    private void quitarArticulo(){
        try {
            if (PD.quitar()){
                F.msg(getActivity(), "Articulo quitado");
                PedidoDetalle.listaPedido.remove(PD);
                PD = null;
                recargarLista();
            }
        } catch (Exception e) {
            F.msg(getActivity(), e.getMessage());
        }


    }

    private void actualizarArticulo(){
        try {
            if (PD.actualizar(cantidad.getText().toString())){
                F.msg(getActivity(), "Articulo actualizado");
                int indx = PedidoDetalle.listaPedido.indexOf(PD);
                PD.setCantidad(cantidad.getText().toString());
                PD.setSubTotal(
                        String.valueOf(Float.parseFloat(cantidad.getText().toString()) *
                                Float.parseFloat(PD.getArticulo().getPrecio())));
                PedidoDetalle.listaPedido.set(indx, PD);
                PD = null;
                recargarLista();
            }
        } catch (Exception e) {

            F.msg(getActivity(), e.getMessage());
        }

    }

    private void recargarLista(){
        AdapterPedidoDetalle adapter = new AdapterPedidoDetalle(getActivity());
        lvDetallePedido.setAdapter(adapter);
    }

    public void preRegistrarPedido() {

        if (PedidoDetalle.listaPedido.size()<=0){
            F.msg(getActivity(), "No tiene articulos en el carrito");
            return ;
        }
        /*
        if (lblDireccion.getText().toString().equalsIgnoreCase(" ")){
            F.msg(getActivity(), "Seleccione su direccion");
            return ;
        }
        */
        //AlertDialog alertDialog = iniciarAlerta();
        modoPago = seleccionarModoPago();
        modoPago.show();


    }

    private void realizarPedido(){
        pago = PP.getPago(PedidoDetalle.listaPedido, "0.00", "0.00", "Pedido", "USD");
        Intent intent = new Intent(getActivity(), PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, PP.config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, pago);
        startActivityForResult(intent, PP.REQUEST_CODE_PAYMENT);
    }

    private AlertDialog pedirCantidad(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater =  getActivity().getLayoutInflater();

        View promptView = inflater.inflate(R.layout.cantidad_modal,null);
        alertDialogBuilder.setView(promptView);
        cantidad = (EditText) promptView.findViewById(R.id.txtCantidadArticulo);
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        actualizarArticulo();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return alertDialogBuilder.create();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PP.REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirm =
                        data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirm != null) {
                    try {

                        P.JSON = confirm.getPayment().toJSONObject().toString(4);
                        P.setDireccion(lblDireccion.getText().toString());
                        try {
                            if (P.agregar(getActivity())){

                                PedidoDetalle.listaPedido.clear();
                                lvDetallePedido.setAdapter(null);
                                lblDireccion.setText(null);
                                F.msg(getActivity(), "Pedido realizado correctamente!");
                                recargarLista();

                            }
                        } catch (Exception e) {
                            F.msg(getActivity(), e.getMessage());
                        }


                    } catch (JSONException e) {
                        Log.e(PP.TAG, "Ha ocurrido un error: ", e);
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(PP.TAG, "El usuario cancelo.");
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(
                        PP.TAG,
                        "Pago no valido o configuracion de PayPal errada.");
            }
        }
    }

    private AlertDialog iniciarAlerta(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle("Articulos");
        alertDialogBuilder
                .setMessage("Desea realizar la compra?")
                .setCancelable(true)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        realizarPedido();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                });
        return alertDialogBuilder.create();
    }

    private AlertDialog deseaQuitar(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());

        alertDialogBuilder.setTitle("Articulos");

        alertDialogBuilder
                .setMessage("Desea quitar este articulo?")
                .setCancelable(true)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        quitarArticulo();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return alertDialogBuilder.create();
    }

    public AlertDialog seleccionarModoPago(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Modos de Pago");
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.item_dialog_pagar, null);

        builder.setView(v);
        LinearLayout pagar_paypal= (LinearLayout) v.findViewById(R.id.layout_pagar_paypal);
        LinearLayout pagar_tarjeta= (LinearLayout)v.findViewById(R.id.layout_pagar_tarjeta);
        LinearLayout pagar_domicilio= (LinearLayout)v.findViewById(R.id.layout_pagar_domicilio);

        pagar_paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarPedido();
                modoPago.dismiss();
                //
            }
        });

        pagar_tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle parametros1 = new Bundle();
                parametros1.putDouble("total_pedido", calcularTotal());

                Intent pantallaPagarConTarjeta = new Intent(getActivity(), PagarConTarjeta.class);
                pantallaPagarConTarjeta.putExtras(parametros1);
                getActivity().startActivity(pantallaPagarConTarjeta);
                modoPago.dismiss();

                PedidoDetalle.listaPedido.clear();
                recargarLista();
            }
        });

        pagar_domicilio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle parametros2=new Bundle();
                parametros2.putDouble("total_pedido", calcularTotal());

                Intent pantallaPagoDomicilio = new Intent(getActivity(), PagarDomicilio.class);
                pantallaPagoDomicilio.putExtras(parametros2);
                getActivity().startActivity(pantallaPagoDomicilio);
                modoPago.dismiss();

                PedidoDetalle.listaPedido.clear();
                recargarLista();
            }
        });

        return builder.create();
    }

    public void onWindowFocusChanged(boolean hasFocus){

        if (hasFocus){
            if (checked){
                checked = false;
                this.lblDireccion.setText(F.getDireccionLL(lat, lon));
            }
        }
    }
    @Override
    public void onDestroy() {
        getActivity().stopService(new Intent(getActivity(), PayPalService.class));
        super.onDestroy();
    }


}
