package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aU implements OnClickListener {
    private /* synthetic */ PaymentConfirmActivity f905a;

    aU(PaymentConfirmActivity paymentConfirmActivity) {
        this.f905a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f905a.m700i();
    }
}
