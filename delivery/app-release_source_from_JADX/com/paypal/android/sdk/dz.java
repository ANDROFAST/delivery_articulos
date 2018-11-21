package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dz implements db {
    private static Map f1265a = new HashMap();
    private static Map f1266b = new HashMap();

    public dz() {
        f1265a.put(da.CANCEL, "ยกเลิก");
        f1265a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1265a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1265a.put(da.CARDTYPE_JCB, "JCB");
        f1265a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1265a.put(da.CARDTYPE_VISA, "Visa");
        f1265a.put(da.DONE, "เสร็จแล้ว");
        f1265a.put(da.ENTRY_CVV, "CVV");
        f1265a.put(da.ENTRY_POSTAL_CODE, "รหัสไปรษณีย์");
        f1265a.put(da.ENTRY_EXPIRES, "หมดอายุ");
        f1265a.put(da.EXPIRES_PLACEHOLDER, "ดด/ปป");
        f1265a.put(da.SCAN_GUIDE, "ถือบัตรไว้ตรงนี้\nเครื่องจะสแกนโดยอัตโนมัติ");
        f1265a.put(da.KEYBOARD, "คีย์บอร์ด…");
        f1265a.put(da.ENTRY_CARD_NUMBER, "หมายเลขบัตร");
        f1265a.put(da.MANUAL_ENTRY_TITLE, "รายละเอียดบัตร");
        f1265a.put(da.ERROR_NO_DEVICE_SUPPORT, "อุปกรณ์ไม่สามารถใช้กล้องเพื่ออ่านหมายเลขบัตรได้");
        f1265a.put(da.ERROR_CAMERA_CONNECT_FAIL, "กล้องของอุปกรณ์ไม่พร้อมใช้งาน");
        f1265a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "อุปกรณ์พบข้อผิดพลาดขณะเปิดกล้อง");
    }

    public final String mo3753a() {
        return "th";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1266b.containsKey(str2) ? (String) f1266b.get(str2) : (String) f1265a.get(daVar);
    }
}
