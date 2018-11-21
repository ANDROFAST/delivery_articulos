package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dh implements db {
    private static Map f1231a = new HashMap();
    private static Map f1232b = new HashMap();

    public dh() {
        f1231a.put(da.CANCEL, "Cancel");
        f1231a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1231a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1231a.put(da.CARDTYPE_JCB, "JCB");
        f1231a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1231a.put(da.CARDTYPE_VISA, "Visa");
        f1231a.put(da.DONE, "Done");
        f1231a.put(da.ENTRY_CVV, "CVV");
        f1231a.put(da.ENTRY_POSTAL_CODE, "Postcode");
        f1231a.put(da.ENTRY_EXPIRES, "Expires");
        f1231a.put(da.EXPIRES_PLACEHOLDER, "MM/YY");
        f1231a.put(da.SCAN_GUIDE, "Hold card here.\nIt will scan automatically.");
        f1231a.put(da.KEYBOARD, "Keyboard…");
        f1231a.put(da.ENTRY_CARD_NUMBER, "Card Number");
        f1231a.put(da.MANUAL_ENTRY_TITLE, "Card Details");
        f1231a.put(da.ERROR_NO_DEVICE_SUPPORT, "This device cannot use the camera to read card numbers.");
        f1231a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Device camera is unavailable.");
        f1231a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "The device had an unexpected error opening the camera.");
    }

    public final String mo3753a() {
        return "en_GB";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1232b.containsKey(str2) ? (String) f1232b.get(str2) : (String) f1231a.get(daVar);
    }
}
