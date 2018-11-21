package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dr implements db {
    private static Map f1249a = new HashMap();
    private static Map f1250b = new HashMap();

    public dr() {
        f1249a.put(da.CANCEL, "Batal");
        f1249a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1249a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1249a.put(da.CARDTYPE_JCB, "JCB");
        f1249a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1249a.put(da.CARDTYPE_VISA, "Visa");
        f1249a.put(da.DONE, "Selesai");
        f1249a.put(da.ENTRY_CVV, "CVV");
        f1249a.put(da.ENTRY_POSTAL_CODE, "Poskod");
        f1249a.put(da.ENTRY_EXPIRES, "Luput");
        f1249a.put(da.EXPIRES_PLACEHOLDER, "BB/TT");
        f1249a.put(da.SCAN_GUIDE, "Pegang kad di sini.\nIa akan mengimbas secara automatik.");
        f1249a.put(da.KEYBOARD, "Papan Kekunci…");
        f1249a.put(da.ENTRY_CARD_NUMBER, "Nombor Kad");
        f1249a.put(da.MANUAL_ENTRY_TITLE, "Butiran Kad");
        f1249a.put(da.ERROR_NO_DEVICE_SUPPORT, "Peranti ini tidak dapat menggunakan kamera untuk membaca nombor kad.");
        f1249a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Kamera peranti tidak tersedia.");
        f1249a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Peranti mengalami ralat tidak dijangka semasa membuka kamera.");
    }

    public final String mo3753a() {
        return "ms";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1250b.containsKey(str2) ? (String) f1250b.get(str2) : (String) f1249a.get(daVar);
    }
}
