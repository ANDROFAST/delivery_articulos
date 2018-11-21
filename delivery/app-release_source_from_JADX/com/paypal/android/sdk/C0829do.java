package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class C0829do implements db {
    private static Map f1245a = new HashMap();
    private static Map f1246b = new HashMap();

    public C0829do() {
        f1245a.put(da.CANCEL, "キャンセル");
        f1245a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1245a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1245a.put(da.CARDTYPE_JCB, "JCB");
        f1245a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1245a.put(da.CARDTYPE_VISA, "Visa");
        f1245a.put(da.DONE, "完了");
        f1245a.put(da.ENTRY_CVV, "カード確認コード");
        f1245a.put(da.ENTRY_POSTAL_CODE, "郵便番号");
        f1245a.put(da.ENTRY_EXPIRES, "有効期限");
        f1245a.put(da.EXPIRES_PLACEHOLDER, "MM/YY");
        f1245a.put(da.SCAN_GUIDE, "ここでカードをお持ちください。\n自動的にスキャンされます。");
        f1245a.put(da.KEYBOARD, "キーボード…");
        f1245a.put(da.ENTRY_CARD_NUMBER, "カード番号");
        f1245a.put(da.MANUAL_ENTRY_TITLE, "カードの詳細");
        f1245a.put(da.ERROR_NO_DEVICE_SUPPORT, "この端末ではカード番号の読込にカメラを使えません。");
        f1245a.put(da.ERROR_CAMERA_CONNECT_FAIL, "端末のカメラを使用できません。");
        f1245a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "カメラを起動中に予期しないエラーが発生しました。");
    }

    public final String mo3753a() {
        return "ja";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1246b.containsKey(str2) ? (String) f1246b.get(str2) : (String) f1245a.get(daVar);
    }
}
