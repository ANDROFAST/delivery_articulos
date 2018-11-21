package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class ab extends Handler {
    private final WeakReference f176a;

    public ab(C0503Y c0503y) {
        this.f176a = new WeakReference(c0503y);
    }

    public final void handleMessage(Message message) {
        C0503Y c0503y = (C0503Y) this.f176a.get();
        if (c0503y != null) {
            c0503y.m74a(message);
        }
    }
}
