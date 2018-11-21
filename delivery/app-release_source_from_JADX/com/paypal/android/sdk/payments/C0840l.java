package com.paypal.android.sdk.payments;

import android.os.Build;
import android.os.Build.VERSION;
import com.paypal.android.sdk.C0507c;
import com.paypal.android.sdk.C0510f;

final class C0840l implements C0507c {
    C0840l() {
    }

    public final String mo3786a() {
        return "2.9.8";
    }

    public final String mo3787b() {
        String str = "PayPal-Android-SDK";
        String str2 = "2.9.8";
        String str3 = "Android";
        String str4 = VERSION.RELEASE;
        String str5 = Build.MANUFACTURER + " " + Build.MODEL;
        StringBuilder stringBuilder = new StringBuilder();
        if (C0510f.m467d((CharSequence) "")) {
            stringBuilder.append(" ");
        }
        String trim = stringBuilder.toString().trim();
        return String.format("PayPalSDK/%s %s (%s %s; %s; %s)", new Object[]{str, str2, str3, str4, str5, trim});
    }

    public final String mo3788c() {
        return BuildConfig.LATEST_SHA1;
    }
}
