package com.myapps.delivery.util;

import com.myapps.delivery.negocio.PedidoDetalle;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalItem;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalPaymentDetails;

import java.math.BigDecimal;
import java.util.ArrayList;


public class PP {
	
	public static final String TAG = "paymentExample";
	private static final String CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX;
	private static final String PAYMENT_INTENT = PayPalPayment.PAYMENT_INTENT_SALE;
	private static final String CONFIG_CLIENT_ID =
			"AU575vITT0DsUCxOhFgPPdbQwAW2PUtauvlrPDdM7lMQNBK-vwQQgsSSeBsjgwiscEuBsoF9G9ZTTr3l";
	
	public static final int REQUEST_CODE_PAYMENT = 1;		
	private static final String MENSAJE_PEDIDO ="Muchas gracias por comprar!";
	
	
	public static PayPalConfiguration config = new PayPalConfiguration()
     .environment(CONFIG_ENVIRONMENT)
     .clientId(CONFIG_CLIENT_ID)   
     .merchantName("Alex Cespedes");     
	 	 
 
	private static PayPalItem[] toItems(ArrayList<PedidoDetalle> detalles, String moneda){
		PayPalItem[] items = new PayPalItem[detalles.size()];
		PedidoDetalle pd = null;		
		
		for (int i = 0; i < detalles.size();i++){
			pd = detalles.get(i);
			items[i] = new PayPalItem(
					pd.getArticulo().getNombre(),
					Integer.parseInt(pd.getCantidad()),
					new BigDecimal(pd.getArticulo().getPrecio()),
					moneda,
					pd.getArticulo().getCodigo()+"-"+pd.getEmpresa().getCodigo()
					);
			pd = null;
		}		
		return items; 
	}
    
	public static PayPalPayment getPago(
			ArrayList<PedidoDetalle> detalles, String sh, String tx,
    		String nombre,String moneda
    		) {
        //--- include an item list, payment amount details
        /*
    	PayPalItem[] items =
            {
                    new PayPalItem("sample item #1", 2, new BigDecimal("87.50"), "USD",
                            "sku-12345678"),
                    new PayPalItem("free sample item #2", 1, new BigDecimal("0.00"),
                            "USD", "sku-zero-price"),
                    new PayPalItem("sample item #3 with a longer name", 6, new BigDecimal("37.99"),
                            "USD", "sku-33333") 
            };*/
		
		PayPalItem[] items = toItems(detalles,moneda);
        BigDecimal subtotal = PayPalItem.getItemTotal(items);
        BigDecimal shipping = new BigDecimal(sh);
        BigDecimal tax = new BigDecimal(tx);
        PayPalPaymentDetails paymentDetails = new PayPalPaymentDetails(shipping, subtotal, tax);
        BigDecimal amount = subtotal.add(shipping).add(tax);
        PayPalPayment payment = new PayPalPayment(amount, moneda, nombre, PAYMENT_INTENT);
        payment.items(items).paymentDetails(paymentDetails);

        //--- set other optional fields like invoice_number, custom field, and soft_descriptor        
        payment.custom(MENSAJE_PEDIDO);        
        return payment;
    }
    
    /*
     * Add app-provided shipping address to payment
     */
	/*
    private void addAppProvidedShippingAddress(PayPalPayment paypalPayment) {
        ShippingAddress shippingAddress =
                new ShippingAddress().recipientName("Mom Parker").line1("52 North Main St.")
                        .city("Austin").state("TX").postalCode("78729").countryCode("US");
        paypalPayment.providedShippingAddress(shippingAddress);
    }
    */
    /*
     * Enable retrieval of shipping addresses from buyer's PayPal account
    
	
    private void enableShippingAddressRetrieval(PayPalPayment paypalPayment, boolean enable) {
        paypalPayment.enablePayPalShippingAddressesRetrieval(enable);
    }
     */
    
    /*
    private PayPalOAuthScopes getOauthScopes() {
        /* create the set of required scopes
         * Note: see https://developer.paypal.com/docs/integration/direct/identity/attributes/ for mapping between the
         * attributes you select for this app in the PayPal developer portal and the scopes required here.
         
        Set<String> scopes = new HashSet<String>(
                Arrays.asList(PayPalOAuthScopes.PAYPAL_SCOPE_EMAIL, PayPalOAuthScopes.PAYPAL_SCOPE_ADDRESS) );
        return new PayPalOAuthScopes(scopes);
    }*/
    
    

}

