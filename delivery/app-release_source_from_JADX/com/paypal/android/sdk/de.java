package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class de implements db {
    private static Map f1225a = new HashMap();
    private static Map f1226b = new HashMap();

    public de() {
        f1225a.put(da.CANCEL, "Abbrechen");
        f1225a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1225a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1225a.put(da.CARDTYPE_JCB, "JCB");
        f1225a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1225a.put(da.CARDTYPE_VISA, "Visa");
        f1225a.put(da.DONE, "Fertig");
        f1225a.put(da.ENTRY_CVV, "Kartenprüfnr.");
        f1225a.put(da.ENTRY_POSTAL_CODE, "PLZ");
        f1225a.put(da.ENTRY_EXPIRES, "Gültig bis");
        f1225a.put(da.EXPIRES_PLACEHOLDER, "MM/JJ");
        f1225a.put(da.SCAN_GUIDE, "Kreditkarte hierhin halten.\nSie wird automatisch gelesen.");
        f1225a.put(da.KEYBOARD, "Tastatur…");
        f1225a.put(da.ENTRY_CARD_NUMBER, "Kartennummer");
        f1225a.put(da.MANUAL_ENTRY_TITLE, "Kreditkartendetails");
        f1225a.put(da.ERROR_NO_DEVICE_SUPPORT, "Dieses Gerät kann mit der Kamera keine Kreditkartennummern lesen.");
        f1225a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Die Kamera ist nicht verfügbar.");
        f1225a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Beim Öffnen der Kamera ist ein unerwarteter Fehler aufgetreten.");
    }

    public final String mo3753a() {
        return "de";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1226b.containsKey(str2) ? (String) f1226b.get(str2) : (String) f1225a.get(daVar);
    }
}
