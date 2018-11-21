package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cz;

final class aW implements aH {
    private /* synthetic */ PaymentConfirmActivity f1292a;

    aW(PaymentConfirmActivity paymentConfirmActivity) {
        this.f1292a = paymentConfirmActivity;
    }

    public final void mo3763a() {
        PaymentConfirmActivity.f837a;
        this.f1292a.m696g();
    }

    public final void mo3764a(aI aIVar) {
        this.f1292a.m701j();
        C0838d.m1118a(this.f1292a, cz.m429a(aIVar.f897b), 1);
        if (this.f1292a.f844h != bk.PayPal) {
            this.f1292a.f842f.m383b(true);
        }
    }
}
