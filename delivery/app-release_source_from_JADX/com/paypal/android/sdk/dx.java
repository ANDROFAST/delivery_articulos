package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class dx implements db {
    private static Map f1261a = new HashMap();
    private static Map f1262b = new HashMap();

    public dx() {
        f1261a.put(da.CANCEL, "Отмена");
        f1261a.put(da.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1261a.put(da.CARDTYPE_DISCOVER, "Discover");
        f1261a.put(da.CARDTYPE_JCB, "JCB");
        f1261a.put(da.CARDTYPE_MASTERCARD, "MasterCard");
        f1261a.put(da.CARDTYPE_VISA, "Visa");
        f1261a.put(da.DONE, "Готово");
        f1261a.put(da.ENTRY_CVV, "Код безопасности");
        f1261a.put(da.ENTRY_POSTAL_CODE, "Индекс");
        f1261a.put(da.ENTRY_EXPIRES, "Действительна до");
        f1261a.put(da.EXPIRES_PLACEHOLDER, "ММ/ГГ");
        f1261a.put(da.SCAN_GUIDE, "Держите карту внутри рамки.\nОна будет считана\nавтоматически.");
        f1261a.put(da.KEYBOARD, "Клавиатура…");
        f1261a.put(da.ENTRY_CARD_NUMBER, "Номер карты");
        f1261a.put(da.MANUAL_ENTRY_TITLE, "Информация о карте");
        f1261a.put(da.ERROR_NO_DEVICE_SUPPORT, "В данном устройстве нет опции считывания номера карты с помощью фотокамеры.");
        f1261a.put(da.ERROR_CAMERA_CONNECT_FAIL, "Фотокамера устройства недоступна.");
        f1261a.put(da.ERROR_CAMERA_UNEXPECTED_FAIL, "Возникла незапланированная ошибка при открытии фотокамеры устройства.");
    }

    public final String mo3753a() {
        return "ru";
    }

    public final /* synthetic */ String mo3754a(Enum enumR, String str) {
        da daVar = (da) enumR;
        String str2 = daVar.toString() + "|" + str;
        return f1262b.containsKey(str2) ? (String) f1262b.get(str2) : (String) f1261a.get(daVar);
    }
}
