package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bi implements OnClickListener {
    private /* synthetic */ PaymentConfirmActivity f964a;

    bi(PaymentConfirmActivity paymentConfirmActivity) {
        this.f964a = paymentConfirmActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f964a.onBackPressed();
    }
}
