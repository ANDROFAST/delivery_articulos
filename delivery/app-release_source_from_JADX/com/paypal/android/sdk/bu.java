package com.paypal.android.sdk;

import com.paypal.android.sdk.payments.PayPalService;
import java.util.HashMap;
import java.util.Map;

public final class bu {
    private static final String f395a = PayPalService.class.getSimpleName();
    private static Map f396b = new HashMap();

    public static bD m334a(String str) {
        bD bDVar = (bD) f396b.get(str);
        new StringBuilder("getLoginAccessToken(").append(str).append(") returns String:").append(bDVar);
        return bDVar;
    }

    public static void m335a(bD bDVar, String str) {
        f396b.put(str, bDVar);
        new StringBuilder("setLoginAccessToken(").append(bDVar).append(",").append(str).append(")");
    }

    public static void m336b(String str) {
        f396b.remove(str);
    }
}
