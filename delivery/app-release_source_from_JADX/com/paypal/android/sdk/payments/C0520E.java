package com.paypal.android.sdk.payments;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class C0520E extends Handler {
    private /* synthetic */ C0519D f714a;

    C0520E(C0519D c0519d, Looper looper) {
        this.f714a = c0519d;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                C0519D.m494a(this.f714a);
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
