package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.cz;

class C0523H {
    private static final String f721a = C0523H.class.getSimpleName();

    C0523H() {
    }

    static String m498a() {
        CharSequence a = bq.m947a().mo3737c().m474a();
        if (C0510f.m464c(a) || a.equalsIgnoreCase("US")) {
            return "https://www.paypal.com/webapps/accountrecovery/passwordrecovery";
        }
        String c = cz.m431c(a);
        return String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=_account-recovery&from=%s&locale.x=%s", new Object[]{a.toLowerCase(), "PayPalMPL", c});
    }
}
