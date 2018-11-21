package com.myapps.delivery.util;

import com.myapps.delivery.negocio.PedidoDetalle;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;
import java.math.BigDecimal;
import java.util.ArrayList;

public class PP {
    private static final String CONFIG_CLIENT_ID = "AU575vITT0DsUCxOhFgPPdbQwAW2PUtauvlrPDdM7lMQNBK-vwQQgsSSeBsjgwiscEuBsoF9G9ZTTr3l";
    private static final String CONFIG_ENVIRONMENT = "sandbox";
    private static final String MENSAJE_PEDIDO = "Muchas gracias por comprar!";
    private static final String PAYMENT_INTENT = "sale";
    public static final int REQUEST_CODE_PAYMENT = 1;
    public static final String TAG = "paymentExample";
    public static PayPalConfiguration config = new PayPalConfiguration().environment("sandbox").clientId(CONFIG_CLIENT_ID).merchantName("Alex Cespedes");

    private static PayPalItem[] toItems(ArrayList<PedidoDetalle> detalles, String moneda) {
        PayPalItem[] items = new PayPalItem[detalles.size()];
        for (int i = 0; i < detalles.size(); i++) {
            PedidoDetalle pd = (PedidoDetalle) detalles.get(i);
            items[i] = new PayPalItem(pd.getArticulo().getNombre(), Integer.valueOf(Integer.parseInt(pd.getCantidad())), new BigDecimal(pd.getArticulo().getPrecio()), moneda, pd.getArticulo().getCodigo() + "-" + pd.getEmpresa().getCodigo());
        }
        return items;
    }

    public static PayPalPayment getPago(ArrayList<PedidoDetalle> detalles, String sh, String tx, String nombre, String moneda) {
        PayPalItem[] items = toItems(detalles, moneda);
        BigDecimal subtotal = PayPalItem.getItemTotal(items);
        BigDecimal shipping = new BigDecimal(sh);
        BigDecimal tax = new BigDecimal(tx);
        PayPalPaymentDetails paymentDetails = new PayPalPaymentDetails(shipping, subtotal, tax);
        PayPalPayment payment = new PayPalPayment(subtotal.add(shipping).add(tax), moneda, nombre, "sale");
        payment.items(items).paymentDetails(paymentDetails);
        payment.custom(MENSAJE_PEDIDO);
        return payment;
    }
}
