package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dl implements db {
    private static Map f1239a = new HashMap();
    private static Map f1240b = new HashMap();

    public dl() {
        f1239a.put(da.CANCEL, "ביטול");
        f1239a.put(da.CARDTYPE_AMERICANEXPRESS, "אמריקן אקספרס");
        f1239a.put(da.CARDTYPE_DISCOVER, "Discover‏");
        f1239a.put(da.CARDTYPE_JCB, "JCB‏");
        f1239a.put(da.CARDTYPE_MASTERCARD, "מאסטרקארד");
        f1239a.put(da.CARDTYPE_VISA, "ויזה");
        f1239a.put(da.DONE, "בוצע");
        f1239a.put(da.ENTRY_CVV, "קוד אימות כרטיס");
        f1239a.put(da.ENTRY_POSTAL_CODE, "מיקוד");
        f1239a.put(da.ENTRY_EXPIRES, "תאריך תפוגה");
        f1239a.put(da.EXPIRES_PLACEHOLDER, "MM/YY‏");
        f1239a.put(da.SCAN_GUIDE, "החזק את הכרטיס כאן.\nהסריקה תתבצע באופן אוטומטי.");
        f1239a.put(da.KEYBOARD, "מקלדת…");
        f1239a.put(da.ENTRY_CARD_NUMBER, "מספר כרטיס");
        f1239a.put(da.MANUAL_ENTRY_TITLE, "פרטי כרטיס");
        f1239a.put(da.ERROR_NO_DEVICE_SUPPORT, "המכשיר אינו מסוגל להשתמש במצלמה לקריאת מספרי כרטיס.");
        f1239a.put(da.ERROR_CAMERA_CONNECT_FAIL, "מצלמת המכשיר אינה זמינה.");
        f1239a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "המכשיר נתקל בשגיאה בלתי צפויה בזמן הפעלת המצלמה.");
    }

    public final String mo3753a() {
        return "he";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1240b.containsKey(str2) ? (String) f1240b.get(str2) : (String) f1239a.get(daVar);
    }
}
