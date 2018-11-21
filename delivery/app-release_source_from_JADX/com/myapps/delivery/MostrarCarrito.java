package com.myapps.delivery;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.myapps.delivery.negocio.Pedido;
import com.myapps.delivery.negocio.PedidoDetalle;
import com.myapps.delivery.util.C0492F;
import com.myapps.delivery.util.PP;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import org.json.JSONException;

public class MostrarCarrito extends Fragment implements OnClickListener {
    public static final String TAG = "mostrar_carrito";
    public static boolean checked = false;
    public static double lat = 0.0d;
    public static double lon = 0.0d;
    Pedido f0P;
    PedidoDetalle PD;
    Button btnDireccion;
    Button btnIrProductos;
    Button btnRegistrarPedido;
    EditText cantidad;
    TextView etiquetaNombreUsuario;
    TextView lblDireccion;
    ListView lvDetallePedido;
    AlertDialog modoPago;
    String[] opciones = new String[]{"Variar cantidad", "Quitar del carrito"};
    PayPalPayment pago;

    class C04651 implements OnItemClickListener {
        C04651() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            MostrarCarrito.this.PD = (PedidoDetalle) PedidoDetalle.listaPedido.get(position);
            MostrarCarrito.this.opcionesItem().show();
        }
    }

    class C04662 implements DialogInterface.OnClickListener {
        C04662() {
        }

        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case 0:
                    MostrarCarrito.this.pedirCantidad().show();
                    return;
                case 1:
                    MostrarCarrito.this.deseaQuitar().show();
                    return;
                default:
                    return;
            }
        }
    }

    class C04673 implements DialogInterface.OnClickListener {
        C04673() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    class C04684 implements DialogInterface.OnClickListener {
        C04684() {
        }

        public void onClick(DialogInterface dialog, int id) {
            MostrarCarrito.this.actualizarArticulo();
        }
    }

    class C04695 implements DialogInterface.OnClickListener {
        C04695() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    class C04706 implements DialogInterface.OnClickListener {
        C04706() {
        }

        public void onClick(DialogInterface dialog, int id) {
            MostrarCarrito.this.realizarPedido();
        }
    }

    class C04717 implements DialogInterface.OnClickListener {
        C04717() {
        }

        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    }

    class C04728 implements DialogInterface.OnClickListener {
        C04728() {
        }

        public void onClick(DialogInterface dialog, int id) {
            MostrarCarrito.this.quitarArticulo();
        }
    }

    class C04739 implements OnClickListener {
        C04739() {
        }

        public void onClick(View v) {
            MostrarCarrito.this.realizarPedido();
            MostrarCarrito.this.modoPago.dismiss();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C0477R.layout.fragment_mostrar_carrito, container, false);
        if (VERSION.SDK_INT > 9) {
            StrictMode.setThreadPolicy(new Builder().permitAll().build());
        }
        this.btnIrProductos = (Button) view.findViewById(C0477R.id.btnIrProductos);
        this.btnIrProductos.setOnClickListener(this);
        this.lblDireccion = (TextView) view.findViewById(C0477R.id.lblDireccion);
        this.lvDetallePedido = (ListView) view.findViewById(C0477R.id.lvSelPedidoDetalle);
        this.lvDetallePedido.setOnItemClickListener(new C04651());
        this.btnRegistrarPedido = (Button) view.findViewById(C0477R.id.btnRegistrarPedido);
        this.btnRegistrarPedido.setOnClickListener(this);
        this.lvDetallePedido.setAdapter(new AdapterPedidoDetalle(getActivity()));
        this.f0P = new Pedido();
        try {
            new PedidoDetalle().listar();
        } catch (Exception e) {
            C0492F.msg(getActivity(), e.getMessage());
        }
        Intent intent = new Intent(getActivity(), PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, PP.config);
        getActivity().startService(intent);
        return view;
    }

    public double calcularTotal() {
        double total = 0.0d;
        for (int i = 0; i < PedidoDetalle.listaPedido.size(); i++) {
            total += Double.parseDouble(((PedidoDetalle) PedidoDetalle.listaPedido.get(i)).getSubTotal());
        }
        return total;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0477R.id.btnIrProductos:
                Fragment fragment = getFragmentManager().findFragmentByTag(SeleccionarCategoria.TAG);
                if (fragment == null) {
                    fragment = new SeleccionarCategoria();
                }
                getFragmentManager().beginTransaction().replace(C0477R.id.container, fragment, SeleccionarCategoria.TAG).commit();
                return;
            case C0477R.id.btnRegistrarPedido:
                preRegistrarPedido();
                return;
            default:
                return;
        }
    }

    private void mostrarMapa() {
        startActivity(new Intent(getActivity(), SeleccionarDireccion.class));
    }

    private AlertDialog opcionesItem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Selecciona una operacion").setItems(this.opciones, new C04662());
        return builder.create();
    }

    private void quitarArticulo() {
        try {
            if (this.PD.quitar()) {
                C0492F.msg(getActivity(), "Articulo quitado");
                PedidoDetalle.listaPedido.remove(this.PD);
                this.PD = null;
                recargarLista();
            }
        } catch (Exception e) {
            C0492F.msg(getActivity(), e.getMessage());
        }
    }

    private void actualizarArticulo() {
        try {
            if (this.PD.actualizar(this.cantidad.getText().toString())) {
                C0492F.msg(getActivity(), "Articulo actualizado");
                int indx = PedidoDetalle.listaPedido.indexOf(this.PD);
                this.PD.setCantidad(this.cantidad.getText().toString());
                this.PD.setSubTotal(String.valueOf(Float.parseFloat(this.cantidad.getText().toString()) * Float.parseFloat(this.PD.getArticulo().getPrecio())));
                PedidoDetalle.listaPedido.set(indx, this.PD);
                this.PD = null;
                recargarLista();
            }
        } catch (Exception e) {
            C0492F.msg(getActivity(), e.getMessage());
        }
    }

    private void recargarLista() {
        this.lvDetallePedido.setAdapter(new AdapterPedidoDetalle(getActivity()));
    }

    public void preRegistrarPedido() {
        if (PedidoDetalle.listaPedido.size() <= 0) {
            C0492F.msg(getActivity(), "No tiene articulos en el carrito");
            return;
        }
        this.modoPago = seleccionarModoPago();
        this.modoPago.show();
    }

    private void realizarPedido() {
        this.pago = PP.getPago(PedidoDetalle.listaPedido, "0.00", "0.00", "Pedido", "USD");
        Intent intent = new Intent(getActivity(), PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, PP.config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, this.pago);
        startActivityForResult(intent, 1);
    }

    private AlertDialog pedirCantidad() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        View promptView = getActivity().getLayoutInflater().inflate(C0477R.layout.cantidad_modal, null);
        alertDialogBuilder.setView(promptView);
        this.cantidad = (EditText) promptView.findViewById(C0477R.id.txtCantidadArticulo);
        alertDialogBuilder.setCancelable(false).setPositiveButton("OK", new C04684()).setNegativeButton("Cancel", new C04673());
        return alertDialogBuilder.create();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 1) {
            return;
        }
        if (resultCode == -1) {
            PaymentConfirmation confirm = (PaymentConfirmation) data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null) {
                try {
                    this.f0P.JSON = confirm.getPayment().toJSONObject().toString(4);
                    this.f0P.setDireccion(this.lblDireccion.getText().toString());
                    try {
                        if (this.f0P.agregar(getActivity())) {
                            PedidoDetalle.listaPedido.clear();
                            this.lvDetallePedido.setAdapter(null);
                            this.lblDireccion.setText(null);
                            C0492F.msg(getActivity(), "Pedido realizado correctamente!");
                            recargarLista();
                        }
                    } catch (Exception e) {
                        C0492F.msg(getActivity(), e.getMessage());
                    }
                } catch (JSONException e2) {
                    Log.e(PP.TAG, "Ha ocurrido un error: ", e2);
                }
            }
        } else if (resultCode == 0) {
            Log.i(PP.TAG, "El usuario cancelo.");
        } else if (resultCode == 2) {
            Log.i(PP.TAG, "Pago no valido o configuracion de PayPal errada.");
        }
    }

    private AlertDialog iniciarAlerta() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Articulos");
        alertDialogBuilder.setMessage("Desea realizar la compra?").setCancelable(true).setPositiveButton("Si", new C04706()).setNegativeButton("No", new C04695());
        return alertDialogBuilder.create();
    }

    private AlertDialog deseaQuitar() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setTitle("Articulos");
        alertDialogBuilder.setMessage("Desea quitar este articulo?").setCancelable(true).setPositiveButton("Si", new C04728()).setNegativeButton("No", new C04717());
        return alertDialogBuilder.create();
    }

    public AlertDialog seleccionarModoPago() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Modos de Pago");
        View v = getActivity().getLayoutInflater().inflate(C0477R.layout.item_dialog_pagar, null);
        builder.setView(v);
        LinearLayout pagar_tarjeta = (LinearLayout) v.findViewById(C0477R.id.layout_pagar_tarjeta);
        LinearLayout pagar_domicilio = (LinearLayout) v.findViewById(C0477R.id.layout_pagar_domicilio);
        ((LinearLayout) v.findViewById(C0477R.id.layout_pagar_paypal)).setOnClickListener(new C04739());
        pagar_tarjeta.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Bundle parametros1 = new Bundle();
                parametros1.putDouble("total_pedido", MostrarCarrito.this.calcularTotal());
                Intent pantallaPagarConTarjeta = new Intent(MostrarCarrito.this.getActivity(), PagarConTarjeta.class);
                pantallaPagarConTarjeta.putExtras(parametros1);
                MostrarCarrito.this.getActivity().startActivity(pantallaPagarConTarjeta);
                MostrarCarrito.this.modoPago.dismiss();
                PedidoDetalle.listaPedido.clear();
                MostrarCarrito.this.recargarLista();
            }
        });
        pagar_domicilio.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Bundle parametros2 = new Bundle();
                parametros2.putDouble("total_pedido", MostrarCarrito.this.calcularTotal());
                Intent pantallaPagoDomicilio = new Intent(MostrarCarrito.this.getActivity(), PagarDomicilio.class);
                pantallaPagoDomicilio.putExtras(parametros2);
                MostrarCarrito.this.getActivity().startActivity(pantallaPagoDomicilio);
                MostrarCarrito.this.modoPago.dismiss();
                PedidoDetalle.listaPedido.clear();
                MostrarCarrito.this.recargarLista();
            }
        });
        return builder.create();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus && checked) {
            checked = false;
            this.lblDireccion.setText(C0492F.getDireccionLL(lat, lon));
        }
    }

    public void onDestroy() {
        getActivity().stopService(new Intent(getActivity(), PayPalService.class));
        super.onDestroy();
    }
}
