package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dj implements db {
    private static Map f1235a = new HashMap();
    private static Map f1236b = new HashMap();

    public dj() {
        f1235a.put(da.CANCEL, "Cancelar");
        f1235a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1235a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1235a.put(da.CARDTYPE_JCB, "JCB");
        f1235a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1235a.put(da.CARDTYPE_VISA, "Visa");
        f1235a.put(da.DONE, "Listo");
        f1235a.put(da.ENTRY_CVV, "CVV");
        f1235a.put(da.ENTRY_POSTAL_CODE, "Código postal");
        f1235a.put(da.ENTRY_EXPIRES, "Caduca");
        f1235a.put(da.EXPIRES_PLACEHOLDER, "MM/AA");
        f1235a.put(da.SCAN_GUIDE, "Sostenga la tarjeta aquí.\nSe escaneará automáticamente.");
        f1235a.put(da.KEYBOARD, "Teclado…");
        f1235a.put(da.ENTRY_CARD_NUMBER, "Número de tarjeta");
        f1235a.put(da.MANUAL_ENTRY_TITLE, "Detalles de la tarjeta");
        f1235a.put(da.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo no puede usar la cámara para leer números de tarjeta.");
        f1235a.put(da.ERROR_CAMERA_CONNECT_FAIL, "La cámara del dispositivo no está disponible.");
        f1235a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "El dispositivo tuvo un error inesperado al abrir la cámara.");
    }

    public final String mo3753a() {
        return "es_MX";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1236b.containsKey(str2) ? (String) f1236b.get(str2) : (String) f1235a.get(daVar);
    }
}
