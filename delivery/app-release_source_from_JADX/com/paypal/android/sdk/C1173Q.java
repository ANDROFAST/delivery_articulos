package com.paypal.android.sdk;

import android.content.Intent;
import android.os.Bundle;

public class C1173Q extends C0828T {
    private static final String f1346a = C1173Q.class.getSimpleName();

    public final Intent m1184a(String str, C0497R c0497r, C0498S c0498s, String str2) {
        Intent b = m1185b(str, c0497r, c0498s, str2);
        b.putExtra("scope", "https://uri.paypal.com/services/payments/basic");
        return b;
    }

    public final Intent m1185b(String str, C0497R c0497r, C0498S c0498s, String str2) {
        Intent a = C0828T.m912a("com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
        Bundle bundle = new Bundle();
        bundle.putString("target_client_id", str);
        if (c0497r != null) {
            bundle.putString("token_request_type", c0497r.toString());
        }
        if (c0498s != null) {
            bundle.putString("response_type", c0498s.toString());
        }
        bundle.putString("app_guid", str2);
        new StringBuilder("launching authenticator with bundle:").append(bundle);
        a.putExtras(bundle);
        return a;
    }
}
