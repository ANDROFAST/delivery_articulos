package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class aD extends BroadcastReceiver {
    private /* synthetic */ PayPalService f894a;

    aD(PayPalService payPalService) {
        this.f894a = payPalService;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.paypal.android.sdk.clearAllUserData")) {
            this.f894a.m640g();
            Log.w("paypal.sdk", "active service user data cleared");
        }
    }
}
