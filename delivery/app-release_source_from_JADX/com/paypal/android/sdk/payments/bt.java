package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class bt implements ServiceConnection {
    final /* synthetic */ PaymentMethodActivity f978a;

    bt(PaymentMethodActivity paymentMethodActivity) {
        this.f978a = paymentMethodActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        new StringBuilder().append(PaymentMethodActivity.f853a).append(".onServiceConnected");
        if (this.f978a.isFinishing()) {
            new StringBuilder().append(PaymentMethodActivity.f853a).append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f978a.f861i = ((aG) iBinder).f895a;
        if (this.f978a.f861i.m633a(new bu(this))) {
            PaymentMethodActivity.m719i(this.f978a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f978a.f861i = null;
    }
}
