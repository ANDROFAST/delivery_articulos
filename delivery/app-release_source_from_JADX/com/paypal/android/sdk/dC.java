package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dC implements db {
    private static Map f1217a = new HashMap();
    private static Map f1218b = new HashMap();

    public dC() {
        f1217a.put(da.CANCEL, "取消");
        f1217a.put(da.CARDTYPE_AMERICANEXPRESS, "美國運通");
        f1217a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1217a.put(da.CARDTYPE_JCB, "JCB");
        f1217a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1217a.put(da.CARDTYPE_VISA, "Visa");
        f1217a.put(da.DONE, "完成");
        f1217a.put(da.ENTRY_CVV, "CVV");
        f1217a.put(da.ENTRY_POSTAL_CODE, "郵遞區號");
        f1217a.put(da.ENTRY_EXPIRES, "到期日");
        f1217a.put(da.EXPIRES_PLACEHOLDER, "月／年");
        f1217a.put(da.SCAN_GUIDE, "將信用卡置於此處。\n裝置會自動掃描。");
        f1217a.put(da.KEYBOARD, "鍵盤…");
        f1217a.put(da.ENTRY_CARD_NUMBER, "卡號");
        f1217a.put(da.MANUAL_ENTRY_TITLE, "信用卡詳細資料");
        f1217a.put(da.ERROR_NO_DEVICE_SUPPORT, "此裝置無法使用相機讀取信用卡卡號。");
        f1217a.put(da.ERROR_CAMERA_CONNECT_FAIL, "無法使用裝置的相機。");
        f1217a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "此裝置啟動相機時發生意外錯誤。");
    }

    public final String mo3753a() {
        return "zh-Hant";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1218b.containsKey(str2) ? (String) f1218b.get(str2) : (String) f1217a.get(daVar);
    }
}
