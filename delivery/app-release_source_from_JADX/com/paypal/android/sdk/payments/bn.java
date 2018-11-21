package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class bn implements OnClickListener {
    private /* synthetic */ PaymentMethodActivity f972a;

    bn(PaymentMethodActivity paymentMethodActivity) {
        this.f972a = paymentMethodActivity;
    }

    public final void onClick(View view) {
        this.f972a.showDialog(1);
    }
}
