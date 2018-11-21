package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dt implements db {
    private static Map f1253a = new HashMap();
    private static Map f1254b = new HashMap();

    public dt() {
        f1253a.put(da.CANCEL, "Annuleren");
        f1253a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1253a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1253a.put(da.CARDTYPE_JCB, "JCB");
        f1253a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1253a.put(da.CARDTYPE_VISA, "Visa");
        f1253a.put(da.DONE, "Gereed");
        f1253a.put(da.ENTRY_CVV, "CVV");
        f1253a.put(da.ENTRY_POSTAL_CODE, "Postcode");
        f1253a.put(da.ENTRY_EXPIRES, "Vervaldatum");
        f1253a.put(da.EXPIRES_PLACEHOLDER, "MM/JJ");
        f1253a.put(da.SCAN_GUIDE, "Houd uw kaart hier.\nScannen gaat automatisch.");
        f1253a.put(da.KEYBOARD, "Toetsenbord…");
        f1253a.put(da.ENTRY_CARD_NUMBER, "Creditcardnummer");
        f1253a.put(da.MANUAL_ENTRY_TITLE, "Kaartgegevens");
        f1253a.put(da.ERROR_NO_DEVICE_SUPPORT, "Met de camera van dit apparaat kunnen geen kaartnummers worden gelezen.");
        f1253a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Camera apparaat niet beschikbaar.");
        f1253a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Er is een onverwachte fout opgetreden bij het starten van de camera.");
    }

    public final String mo3753a() {
        return "nl";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1254b.containsKey(str2) ? (String) f1254b.get(str2) : (String) f1253a.get(daVar);
    }
}
