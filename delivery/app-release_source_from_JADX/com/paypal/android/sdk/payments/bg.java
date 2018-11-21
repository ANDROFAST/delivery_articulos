package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bg implements OnClickListener {
    private /* synthetic */ PaymentConfirmActivity f962a;

    bg(PaymentConfirmActivity paymentConfirmActivity) {
        this.f962a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f962a.m682a(true);
    }
}
