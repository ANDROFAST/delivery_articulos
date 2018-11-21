package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bs implements OnClickListener {
    private /* synthetic */ PaymentMethodActivity f977a;

    bs(PaymentMethodActivity paymentMethodActivity) {
        this.f977a = paymentMethodActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f977a.f861i.m653t();
        this.f977a.m711c();
    }
}
