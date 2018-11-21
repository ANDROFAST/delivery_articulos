package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class di implements db {
    private static Map f1233a = new HashMap();
    private static Map f1234b = new HashMap();

    public di() {
        f1233a.put(da.CANCEL, "Cancelar");
        f1233a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1233a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1233a.put(da.CARDTYPE_JCB, "JCB");
        f1233a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1233a.put(da.CARDTYPE_VISA, "Visa");
        f1233a.put(da.DONE, "Hecho");
        f1233a.put(da.ENTRY_CVV, "CVV");
        f1233a.put(da.ENTRY_POSTAL_CODE, "Código postal");
        f1233a.put(da.ENTRY_EXPIRES, "Caduca");
        f1233a.put(da.EXPIRES_PLACEHOLDER, "MM/AA");
        f1233a.put(da.SCAN_GUIDE, "Mantenga la tarjeta aquí.\nSe escaneará automáticamente.");
        f1233a.put(da.KEYBOARD, "Teclado…");
        f1233a.put(da.ENTRY_CARD_NUMBER, "Número de tarjeta");
        f1233a.put(da.MANUAL_ENTRY_TITLE, "Detalles de la tarjeta");
        f1233a.put(da.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo no puede usar la cámara para leer números de tarjeta.");
        f1233a.put(da.ERROR_CAMERA_CONNECT_FAIL, "La cámara del dispositivo no está disponible.");
        f1233a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Al abrir la cámara, el dispositivo ha experimentado un error inesperado.");
    }

    public final String mo3753a() {
        return "es";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1234b.containsKey(str2) ? (String) f1234b.get(str2) : (String) f1233a.get(daVar);
    }
}
