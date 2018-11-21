package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dk implements db {
    private static Map f1237a = new HashMap();
    private static Map f1238b = new HashMap();

    public dk() {
        f1237a.put(da.CANCEL, "Annuler");
        f1237a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1237a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1237a.put(da.CARDTYPE_JCB, "JCB");
        f1237a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1237a.put(da.CARDTYPE_VISA, "Visa");
        f1237a.put(da.DONE, "OK");
        f1237a.put(da.ENTRY_CVV, "Crypto.");
        f1237a.put(da.ENTRY_POSTAL_CODE, "Code postal");
        f1237a.put(da.ENTRY_EXPIRES, "Date d’expiration");
        f1237a.put(da.EXPIRES_PLACEHOLDER, "MM/AA");
        f1237a.put(da.SCAN_GUIDE, "Maintenez la carte à cet endroit.\nElle va être automatiquement scannée.");
        f1237a.put(da.KEYBOARD, "Clavier…");
        f1237a.put(da.ENTRY_CARD_NUMBER, "Nº de carte");
        f1237a.put(da.MANUAL_ENTRY_TITLE, "Carte");
        f1237a.put(da.ERROR_NO_DEVICE_SUPPORT, "Cet appareil ne peut pas utiliser l’appareil photo pour lire les numéros de carte.");
        f1237a.put(da.ERROR_CAMERA_CONNECT_FAIL, "L’appareil photo n’est pas disponible.");
        f1237a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Une erreur s’est produite en ouvrant l’appareil photo.");
    }

    public final String mo3753a() {
        return "fr";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1238b.containsKey(str2) ? (String) f1238b.get(str2) : (String) f1237a.get(daVar);
    }
}
