package com.paypal.android.sdk.payments;

import android.os.Bundle;
import com.paypal.android.sdk.bF;

class C0548o {
    private static final String f992a = C0548o.class.getSimpleName();

    C0548o() {
    }

    public static C0546m m773a(Bundle bundle) {
        String string = bundle.getString("authAccount");
        String string2 = bundle.getString("code");
        String string3 = bundle.getString("nonce");
        for (String str : bundle.keySet()) {
            if (bundle.get(str) == null) {
                String.format("%s:null", new Object[]{(String) r4.next()});
            } else {
                String.format("%s:%s (%s)", new Object[]{(String) r4.next(), bundle.get(str).toString(), bundle.get(str).getClass().getName()});
            }
        }
        return new C0546m(string3, new bF(string2, null), string);
    }
}
