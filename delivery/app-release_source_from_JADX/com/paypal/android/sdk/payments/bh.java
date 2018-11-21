package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bh implements OnClickListener {
    private /* synthetic */ PaymentConfirmActivity f963a;

    bh(PaymentConfirmActivity paymentConfirmActivity) {
        this.f963a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f963a.m700i();
    }
}
