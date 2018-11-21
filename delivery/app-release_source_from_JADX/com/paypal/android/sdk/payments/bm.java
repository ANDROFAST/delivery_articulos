package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class bm implements OnClickListener {
    private /* synthetic */ PaymentMethodActivity f971a;

    bm(PaymentMethodActivity paymentMethodActivity) {
        this.f971a = paymentMethodActivity;
    }

    public final void onClick(View view) {
        PaymentMethodActivity.m707a(this.f971a);
    }
}
