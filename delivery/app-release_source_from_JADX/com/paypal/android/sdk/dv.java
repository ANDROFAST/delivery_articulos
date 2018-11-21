package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dv implements db {
    private static Map f1257a = new HashMap();
    private static Map f1258b = new HashMap();

    public dv() {
        f1257a.put(da.CANCEL, "Cancelar");
        f1257a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1257a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1257a.put(da.CARDTYPE_JCB, "JCB");
        f1257a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1257a.put(da.CARDTYPE_VISA, "Visa");
        f1257a.put(da.DONE, "Concluído");
        f1257a.put(da.ENTRY_CVV, "CSC");
        f1257a.put(da.ENTRY_POSTAL_CODE, "Código Postal");
        f1257a.put(da.ENTRY_EXPIRES, "Validade");
        f1257a.put(da.EXPIRES_PLACEHOLDER, "MM/AA");
        f1257a.put(da.SCAN_GUIDE, "Segure o cartão aqui.\nSerá lido automaticamente.");
        f1257a.put(da.KEYBOARD, "Teclado…");
        f1257a.put(da.ENTRY_CARD_NUMBER, "Número do cartão");
        f1257a.put(da.MANUAL_ENTRY_TITLE, "Detalhes do cartão");
        f1257a.put(da.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode utilizar a câmara para ler números de cartões.");
        f1257a.put(da.ERROR_CAMERA_CONNECT_FAIL, "A câmara do dispositivo não está disponível.");
        f1257a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Ocorreu um erro inesperado no dispositivo ao abrir a câmara.");
    }

    public final String mo3753a() {
        return "pt";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1258b.containsKey(str2) ? (String) f1258b.get(str2) : (String) f1257a.get(daVar);
    }
}
