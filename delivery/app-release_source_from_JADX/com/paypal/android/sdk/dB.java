package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dB implements db {
    private static Map f1215a = new HashMap();
    private static Map f1216b = new HashMap();

    public dB() {
        f1215a.put(da.CANCEL, "取消");
        f1215a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1215a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1215a.put(da.CARDTYPE_JCB, "JCB");
        f1215a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1215a.put(da.CARDTYPE_VISA, "Visa");
        f1215a.put(da.DONE, "完成");
        f1215a.put(da.ENTRY_CVV, "CVV");
        f1215a.put(da.ENTRY_POSTAL_CODE, "邮政编码");
        f1215a.put(da.ENTRY_EXPIRES, "失效日期：");
        f1215a.put(da.EXPIRES_PLACEHOLDER, "MM/YY");
        f1215a.put(da.SCAN_GUIDE, "持卡置于此处。\n设备会自动扫描卡。");
        f1215a.put(da.KEYBOARD, "键盘…");
        f1215a.put(da.ENTRY_CARD_NUMBER, "卡号");
        f1215a.put(da.MANUAL_ENTRY_TITLE, "卡详细信息");
        f1215a.put(da.ERROR_NO_DEVICE_SUPPORT, "此设备无法使用摄像头读取卡号。");
        f1215a.put(da.ERROR_CAMERA_CONNECT_FAIL, "设备摄像头不可用。");
        f1215a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "设备打开摄像头时出现意外错误。");
    }

    public final String mo3753a() {
        return "zh-Hans";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1216b.containsKey(str2) ? (String) f1216b.get(str2) : (String) f1215a.get(daVar);
    }
}
