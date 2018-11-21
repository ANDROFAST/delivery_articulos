package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dy implements db {
    private static Map f1263a = new HashMap();
    private static Map f1264b = new HashMap();

    public dy() {
        f1263a.put(da.CANCEL, "Avbryt");
        f1263a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1263a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1263a.put(da.CARDTYPE_JCB, "JCB");
        f1263a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1263a.put(da.CARDTYPE_VISA, "Visa");
        f1263a.put(da.DONE, "Klart");
        f1263a.put(da.ENTRY_CVV, "CVV");
        f1263a.put(da.ENTRY_POSTAL_CODE, "Postnummer");
        f1263a.put(da.ENTRY_EXPIRES, "Går ut");
        f1263a.put(da.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
        f1263a.put(da.SCAN_GUIDE, "Håll kortet här.\nDet skannas automatiskt.");
        f1263a.put(da.KEYBOARD, "Tangentbord …");
        f1263a.put(da.ENTRY_CARD_NUMBER, "Kortnummer");
        f1263a.put(da.MANUAL_ENTRY_TITLE, "Kortinformation");
        f1263a.put(da.ERROR_NO_DEVICE_SUPPORT, "Den här enheten kan inte använda kameran till att läsa kortnummer.");
        f1263a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Enhetens kamera är inte tillgänglig.");
        f1263a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Ett oväntat fel uppstod när enheten skulle öppna kameran.");
    }

    public final String mo3753a() {
        return "sv";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1264b.containsKey(str2) ? (String) f1264b.get(str2) : (String) f1263a.get(daVar);
    }
}
