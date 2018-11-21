package com.paypal.android.sdk;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.ExecutorService;

public final class C0508d {
    private static final String f625a = C0508d.class.getSimpleName();
    private static C0503Y f626b;

    public static final synchronized String m433a(ExecutorService executorService, Context context, C0506b c0506b, String str) {
        String a;
        synchronized (C0508d.class) {
            if (f626b == null) {
                try {
                    C0503Y a2 = C0503Y.m52a();
                    f626b = a2;
                    a = a2.m73a(context, c0506b.m184e(), C0505a.MSDK, str, null, false, null, null);
                    executorService.submit(new C0509e());
                    new StringBuilder("Init risk component: ").append(C0503Y.m60d());
                } catch (Throwable th) {
                    Log.e("paypal.sdk", "An internal component failed to initialize: " + th.getMessage());
                    a = null;
                }
            } else {
                a = f626b.m79g();
                new StringBuilder("risk component already initialized, returning new pairing id:").append(a);
            }
        }
        return a;
    }
}
