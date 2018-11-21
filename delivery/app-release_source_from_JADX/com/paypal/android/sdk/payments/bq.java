package com.paypal.android.sdk.payments;

import java.util.TimerTask;

final class bq extends TimerTask {
    private /* synthetic */ PaymentMethodActivity f975a;

    bq(PaymentMethodActivity paymentMethodActivity) {
        this.f975a = paymentMethodActivity;
    }

    public final void run() {
        this.f975a.removeDialog(3);
        PaymentConfirmActivity.m673a(this.f975a, 2, bk.PayPal, null, this.f975a.f861i.m637d());
    }
}
