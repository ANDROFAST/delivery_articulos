package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dd implements db {
    private static Map f1223a = new HashMap();
    private static Map f1224b = new HashMap();

    public dd() {
        f1223a.put(da.CANCEL, "Annuller");
        f1223a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1223a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1223a.put(da.CARDTYPE_JCB, "JCB");
        f1223a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1223a.put(da.CARDTYPE_VISA, "Visa");
        f1223a.put(da.DONE, "Udført");
        f1223a.put(da.ENTRY_CVV, "CVV");
        f1223a.put(da.ENTRY_POSTAL_CODE, "Postnummer");
        f1223a.put(da.ENTRY_EXPIRES, "Udløber");
        f1223a.put(da.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
        f1223a.put(da.SCAN_GUIDE, "Hold kortet her.\nDet scannes automatisk.");
        f1223a.put(da.KEYBOARD, "Tastatur…");
        f1223a.put(da.ENTRY_CARD_NUMBER, "Kortnummer");
        f1223a.put(da.MANUAL_ENTRY_TITLE, "Kortoplysninger");
        f1223a.put(da.ERROR_NO_DEVICE_SUPPORT, "Denne enhed kan ikke anvende kameraet til at læse kortnumre.");
        f1223a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Enhed kamera ikke er tilgængelig.");
        f1223a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Enheden havde en uventet fejl under åbning af kamera.");
    }

    public final String mo3753a() {
        return "da";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1224b.containsKey(str2) ? (String) f1224b.get(str2) : (String) f1223a.get(daVar);
    }
}
