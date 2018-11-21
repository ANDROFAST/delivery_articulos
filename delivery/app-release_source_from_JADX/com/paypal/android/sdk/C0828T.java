package com.paypal.android.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.List;

public class C0828T extends C0493M {
    private static final String f1160a = C0828T.class.getSimpleName();

    protected static Intent m912a(String str, String str2) {
        Intent intent = new Intent(str);
        intent.setComponent(ComponentName.unflattenFromString(str2));
        intent.setPackage("com.paypal.android.p2pmobile");
        return intent;
    }

    public final boolean m913a(Context context, String str, String str2) {
        boolean z = false;
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(C0828T.m912a(str, str2), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            z = true;
        }
        if (!z) {
            new StringBuilder("PayPal wallet app will not accept intent to: [action:").append(str).append(", class:").append(str2).append("]");
        }
        return z;
    }

    public final boolean m914a(Context context, boolean z, String str) {
        return m14a(context, z, str, "O=Paypal", "O=Paypal", 34172764);
    }
}
