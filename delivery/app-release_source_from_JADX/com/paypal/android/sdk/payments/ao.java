package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class ao implements ServiceConnection {
    final /* synthetic */ PayPalFuturePaymentActivity f934a;

    ao(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f934a = payPalFuturePaymentActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new StringBuilder().append(PayPalFuturePaymentActivity.f774a).append(".onServiceConnected");
        if (this.f934a.isFinishing()) {
            new StringBuilder().append(PayPalFuturePaymentActivity.f774a).append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f934a.f777d = ((aG) iBinder).f895a;
        if (this.f934a.f777d.m633a(new ap(this))) {
            PayPalFuturePaymentActivity.m560c(this.f934a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f934a.f777d = null;
        PayPalFuturePaymentActivity.f774a;
    }
}
