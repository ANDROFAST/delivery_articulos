package com.paypal.android.sdk.payments;

import android.os.AsyncTask;
import io.card.payment.CardIOActivity;

final class bv extends AsyncTask {
    final /* synthetic */ PaymentMethodActivity f979a;

    private bv(PaymentMethodActivity paymentMethodActivity) {
        this.f979a = paymentMethodActivity;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        PaymentMethodActivity.f853a;
        this.f979a.f857e = CardIOActivity.canReadCardWithCamera();
        PaymentMethodActivity.f853a;
        new StringBuilder("cameraAvailable:").append(this.f979a.f857e).append(" time elapsed = ").append(Long.toString(System.currentTimeMillis() - currentTimeMillis));
        this.f979a.runOnUiThread(new bw(this));
        return null;
    }
}
