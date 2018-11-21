package com.paypal.android.sdk.payments;

import android.content.Intent;

final class aR extends C0518C {
    aR(Intent intent, PayPalConfiguration payPalConfiguration) {
        super(intent, payPalConfiguration);
    }

    protected final String mo3761a() {
        return PaymentActivity.class.getSimpleName();
    }

    final boolean mo3762e() {
        aS aSVar = new aS(m489b());
        boolean z = aSVar.m745a() != null && aSVar.m745a().isProcessable();
        m488a(z, "PaymentActivity.EXTRA_PAYMENT");
        return z;
    }
}
