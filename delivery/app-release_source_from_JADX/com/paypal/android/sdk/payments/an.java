package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class an implements OnClickListener {
    private /* synthetic */ PayPalFuturePaymentActivity f933a;

    an(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f933a = payPalFuturePaymentActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f933a.f777d.m628a(this.f933a.m559c(), true);
    }
}
