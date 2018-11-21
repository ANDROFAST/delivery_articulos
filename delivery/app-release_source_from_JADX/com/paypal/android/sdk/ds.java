package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class ds implements db {
    private static Map f1251a = new HashMap();
    private static Map f1252b = new HashMap();

    public ds() {
        f1251a.put(da.CANCEL, "Avbryt");
        f1251a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1251a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1251a.put(da.CARDTYPE_JCB, "JCB");
        f1251a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1251a.put(da.CARDTYPE_VISA, "Visa");
        f1251a.put(da.DONE, "Fullført");
        f1251a.put(da.ENTRY_CVV, "CVV");
        f1251a.put(da.ENTRY_POSTAL_CODE, "Postnummer");
        f1251a.put(da.ENTRY_EXPIRES, "Utløper");
        f1251a.put(da.EXPIRES_PLACEHOLDER, "MM/ÅÅ");
        f1251a.put(da.SCAN_GUIDE, "Hold kortet her.\nDet skannes automatisk.");
        f1251a.put(da.KEYBOARD, "Tastatur …");
        f1251a.put(da.ENTRY_CARD_NUMBER, "Kortnummer");
        f1251a.put(da.MANUAL_ENTRY_TITLE, "Kortdetaljer");
        f1251a.put(da.ERROR_NO_DEVICE_SUPPORT, "Denne enheten kan ikke bruke kameraet til å lese kortnumre.");
        f1251a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Kameraet er utilgjengelig.");
        f1251a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Det oppstod en uventet feil ved kameraoppstart.");
    }

    public final String mo3753a() {
        return "nb";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1252b.containsKey(str2) ? (String) f1252b.get(str2) : (String) f1251a.get(daVar);
    }
}
