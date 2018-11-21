package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dw implements db {
    private static Map f1259a = new HashMap();
    private static Map f1260b = new HashMap();

    public dw() {
        f1259a.put(da.CANCEL, "Cancelar");
        f1259a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1259a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1259a.put(da.CARDTYPE_JCB, "JCB");
        f1259a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1259a.put(da.CARDTYPE_VISA, "Visa");
        f1259a.put(da.DONE, "Concluído");
        f1259a.put(da.ENTRY_CVV, "CVV");
        f1259a.put(da.ENTRY_POSTAL_CODE, "CEP");
        f1259a.put(da.ENTRY_EXPIRES, "Vencimento");
        f1259a.put(da.EXPIRES_PLACEHOLDER, "MM/AA");
        f1259a.put(da.SCAN_GUIDE, "Posicionar cartão aqui.\nEle será digitalizado automaticamente.");
        f1259a.put(da.KEYBOARD, "Teclado…");
        f1259a.put(da.ENTRY_CARD_NUMBER, "Número do Cartão");
        f1259a.put(da.MANUAL_ENTRY_TITLE, "Dados do cartão");
        f1259a.put(da.ERROR_NO_DEVICE_SUPPORT, "Este dispositivo não pode usar a câmera para ler números de cartão.");
        f1259a.put(da.ERROR_CAMERA_CONNECT_FAIL, "A câmera do dispositivo não está disponível.");
        f1259a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "O dispositivo sofreu um erro inesperado ao abrir a câmera.");
    }

    public final String mo3753a() {
        return "pt_BR";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1260b.containsKey(str2) ? (String) f1260b.get(str2) : (String) f1259a.get(daVar);
    }
}
