package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class C0522G {
    final IntentFilter f718a;
    final BroadcastReceiver f719b;
    boolean f720c;

    C0522G(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f718a = intentFilter;
        this.f719b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.f719b);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.f718a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
