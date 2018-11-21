package com.paypal.android.sdk;

import java.util.Set;

public final class cz {
    public static boolean f622a;
    private static final C0514j f623b = new C0514j(cB.class, C0554y.f1008a);
    private static Set f624c = new cA();

    public static String m428a(cB cBVar) {
        return f623b.m481a((Enum) cBVar);
    }

    public static String m429a(String str) {
        return str.equals(aG.SERVER_COMMUNICATION_ERROR.toString()) ? f623b.m481a(cB.SERVER_PROBLEM) : str.equals(aG.INTERNAL_SERVER_ERROR.toString()) ? f623b.m482a("INTERNAL_SERVICE_ERROR", cB.SYSTEM_ERROR_WITH_CODE) : str.equals(aG.PARSE_RESPONSE_ERROR.toString()) ? f623b.m481a(cB.PP_SERVICE_ERROR_JSON_PARSE_ERROR) : f623b.m482a(str, cB.SYSTEM_ERROR_WITH_CODE);
    }

    public static void m430b(String str) {
        f623b.m483a(str);
        boolean z = C0510f.m467d((CharSequence) str) && f624c.contains(str);
        f622a = z;
    }

    public static String m431c(String str) {
        String a = f623b.m480a();
        return !a.contains("_") ? a + "_" + str : a;
    }
}
