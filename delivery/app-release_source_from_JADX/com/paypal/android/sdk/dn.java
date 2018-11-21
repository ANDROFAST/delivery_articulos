package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dn implements db {
    private static Map f1243a = new HashMap();
    private static Map f1244b = new HashMap();

    public dn() {
        f1243a.put(da.CANCEL, "Annulla");
        f1243a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1243a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1243a.put(da.CARDTYPE_JCB, "JCB");
        f1243a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1243a.put(da.CARDTYPE_VISA, "Visa");
        f1243a.put(da.DONE, "Fine");
        f1243a.put(da.ENTRY_CVV, "CVV");
        f1243a.put(da.ENTRY_POSTAL_CODE, "Codice postale");
        f1243a.put(da.ENTRY_EXPIRES, "Scadenza");
        f1243a.put(da.EXPIRES_PLACEHOLDER, "MM/AA");
        f1243a.put(da.SCAN_GUIDE, "Inquadra la carta.\nLa scansione è automatica.");
        f1243a.put(da.KEYBOARD, "Tastiera…");
        f1243a.put(da.ENTRY_CARD_NUMBER, "Numero di carta");
        f1243a.put(da.MANUAL_ENTRY_TITLE, "Dati carta");
        f1243a.put(da.ERROR_NO_DEVICE_SUPPORT, "La fotocamera non legge il numero di carta.");
        f1243a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Fotocamera non disponibile.");
        f1243a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Errore inatteso nell’apertura della fotocamera.");
    }

    public final String mo3753a() {
        return "it";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1244b.containsKey(str2) ? (String) f1244b.get(str2) : (String) f1243a.get(daVar);
    }
}
