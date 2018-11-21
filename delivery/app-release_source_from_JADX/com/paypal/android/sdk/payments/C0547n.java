package com.paypal.android.sdk.payments;

import android.content.Context;
import com.paypal.android.sdk.C0828T;
import com.paypal.android.sdk.C1173Q;
import com.paypal.android.sdk.av;

class C0547n {
    private static final String f991a = C0547n.class.getSimpleName();

    C0547n() {
    }

    static boolean m772a(Context context, PayPalService payPalService) {
        boolean z = false;
        if (av.m171e(payPalService.m638e())) {
            new StringBuilder("Is mock or sandbox:").append(payPalService.m638e());
        } else if (payPalService.m656w()) {
            C0828T c1173q = new C1173Q();
            boolean x = payPalService.m657x();
            boolean a = c1173q.m913a(context, "com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
            if (c1173q.m914a(context, x, "com.paypal.android.p2pmobile") && a) {
                z = true;
            }
        }
        new StringBuilder("returning isValid:").append(z);
        return z;
    }
}
