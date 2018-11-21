package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class ay extends Handler {
    private WeakReference f260a;

    public ay(ax axVar) {
        this.f260a = new WeakReference(axVar);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 2:
                ax axVar = (ax) this.f260a.get();
                if (axVar != null) {
                    axVar.f1182e.m84a((bm) message.obj, 0);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
