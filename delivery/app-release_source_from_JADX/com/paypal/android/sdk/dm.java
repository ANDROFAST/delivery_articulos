package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dm implements db {
    private static Map f1241a = new HashMap();
    private static Map f1242b = new HashMap();

    public dm() {
        f1241a.put(da.CANCEL, "Hætta við");
        f1241a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1241a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1241a.put(da.CARDTYPE_JCB, "JCB");
        f1241a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1241a.put(da.CARDTYPE_VISA, "Visa");
        f1241a.put(da.DONE, "Lokið");
        f1241a.put(da.ENTRY_CVV, "CVV");
        f1241a.put(da.ENTRY_POSTAL_CODE, "Póstnúmer");
        f1241a.put(da.ENTRY_EXPIRES, "Rennur út");
        f1241a.put(da.EXPIRES_PLACEHOLDER, "MM/ÁÁ");
        f1241a.put(da.SCAN_GUIDE, "Haltu kortinu kyrru hér.\nÞað verður sjálvirkt skannað.");
        f1241a.put(da.KEYBOARD, "Lyklaborð…");
        f1241a.put(da.ENTRY_CARD_NUMBER, "Kortanúmar");
        f1241a.put(da.MANUAL_ENTRY_TITLE, "Kortaupplýsingar");
        f1241a.put(da.ERROR_NO_DEVICE_SUPPORT, "Þetta tæki getur ekki notað myndavélina til að lesa af númer af kortinu.");
        f1241a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Ekki næst samband við myndavélina.");
        f1241a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Upp kom villa við að opna myndavélina..");
    }

    public final String mo3753a() {
        return "is";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1242b.containsKey(str2) ? (String) f1242b.get(str2) : (String) f1241a.get(daVar);
    }
}
