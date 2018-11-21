package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dp implements db {
    private static Map f1247a = new HashMap();
    private static Map f1248b = new HashMap();

    public dp() {
        f1247a.put(da.CANCEL, "취소");
        f1247a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1247a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1247a.put(da.CARDTYPE_JCB, "JCB");
        f1247a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1247a.put(da.CARDTYPE_VISA, "Visa");
        f1247a.put(da.DONE, "완료");
        f1247a.put(da.ENTRY_CVV, "CVV");
        f1247a.put(da.ENTRY_POSTAL_CODE, "우편번호");
        f1247a.put(da.ENTRY_EXPIRES, "유효기간");
        f1247a.put(da.EXPIRES_PLACEHOLDER, "MM / YY");
        f1247a.put(da.SCAN_GUIDE, "카드를 여기에 갖다 대세요.\n자동으로 스캔됩니다.");
        f1247a.put(da.KEYBOARD, "키보드…");
        f1247a.put(da.ENTRY_CARD_NUMBER, "카드 번호");
        f1247a.put(da.MANUAL_ENTRY_TITLE, "카드 세부정보");
        f1247a.put(da.ERROR_NO_DEVICE_SUPPORT, "기기가 카메라를 이용한 카드 숫자 판독을 지원하지 않습니다.");
        f1247a.put(da.ERROR_CAMERA_CONNECT_FAIL, "기기에서 카메라를 사용할 수 없습니다.");
        f1247a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "기기에서 카메라를 여는 동안 예상치 못한 오류가 발생했습니다.");
    }

    public final String mo3753a() {
        return "ko";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1248b.containsKey(str2) ? (String) f1248b.get(str2) : (String) f1247a.get(daVar);
    }
}
