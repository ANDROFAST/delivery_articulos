package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class du implements db {
    private static Map f1255a = new HashMap();
    private static Map f1256b = new HashMap();

    public du() {
        f1255a.put(da.CANCEL, "Anuluj");
        f1255a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1255a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1255a.put(da.CARDTYPE_JCB, "JCB");
        f1255a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1255a.put(da.CARDTYPE_VISA, "Visa");
        f1255a.put(da.DONE, "Gotowe");
        f1255a.put(da.ENTRY_CVV, "Kod CVV2/CVC2");
        f1255a.put(da.ENTRY_POSTAL_CODE, "Kod pocztowy");
        f1255a.put(da.ENTRY_EXPIRES, "Wygasa");
        f1255a.put(da.EXPIRES_PLACEHOLDER, "MM/RR");
        f1255a.put(da.SCAN_GUIDE, "Przytrzymaj kartę tutaj.\nZostanie ona zeskanowana automatycznie.");
        f1255a.put(da.KEYBOARD, "Klawiatura…");
        f1255a.put(da.ENTRY_CARD_NUMBER, "Numer karty");
        f1255a.put(da.MANUAL_ENTRY_TITLE, "Dane karty");
        f1255a.put(da.ERROR_NO_DEVICE_SUPPORT, "Na tym urządzeniu nie można odczytać numeru karty za pomocą aparatu.");
        f1255a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Aparat na tym urządzeniu jest niedostepny.");
        f1255a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Przy otwieraniu aparatu na tym urządzeniu wystąpił nieoczekiwany błąd.");
    }

    public final String mo3753a() {
        return "pl";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1256b.containsKey(str2) ? (String) f1256b.get(str2) : (String) f1255a.get(daVar);
    }
}
