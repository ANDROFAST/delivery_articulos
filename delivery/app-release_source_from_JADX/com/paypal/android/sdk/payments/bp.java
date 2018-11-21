package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class bp implements OnClickListener {
    private /* synthetic */ PaymentMethodActivity f974a;

    bp(PaymentMethodActivity paymentMethodActivity) {
        this.f974a = paymentMethodActivity;
    }

    public final void onClick(View view) {
        this.f974a.showDialog(2);
    }
}
