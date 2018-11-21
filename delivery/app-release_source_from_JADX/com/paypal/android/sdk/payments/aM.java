package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aM implements OnClickListener {
    private /* synthetic */ PaymentActivity f900a;

    aM(PaymentActivity paymentActivity) {
        this.f900a = paymentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f900a.f834d.m628a(this.f900a.m664c(), true);
    }
}
