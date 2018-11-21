package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class bo implements OnClickListener {
    private /* synthetic */ PaymentMethodActivity f973a;

    bo(PaymentMethodActivity paymentMethodActivity) {
        this.f973a = paymentMethodActivity;
    }

    public final void onClick(View view) {
        PaymentMethodActivity.m712c(this.f973a);
    }
}
