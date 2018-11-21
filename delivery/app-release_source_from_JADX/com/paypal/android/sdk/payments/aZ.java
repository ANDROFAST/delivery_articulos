package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class aZ implements ServiceConnection {
    final /* synthetic */ PaymentConfirmActivity f909a;

    aZ(PaymentConfirmActivity paymentConfirmActivity) {
        this.f909a = paymentConfirmActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new StringBuilder().append(PaymentConfirmActivity.f837a).append(".onServiceConnected");
        this.f909a.f846j = ((aG) iBinder).f895a;
        if (this.f909a.f846j.m633a(new ba(this))) {
            PaymentConfirmActivity.m685b(this.f909a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f909a.f846j = null;
    }
}
