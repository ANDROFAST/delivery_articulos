package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

final class aq implements aH {
    final /* synthetic */ PayPalFuturePaymentActivity f1295a;

    aq(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f1295a = payPalFuturePaymentActivity;
    }

    public final void mo3763a() {
        Date time = Calendar.getInstance().getTime();
        if (this.f1295a.f775b.compareTo(time) > 0) {
            long time2 = this.f1295a.f775b.getTime() - time.getTime();
            PayPalFuturePaymentActivity.f774a;
            new StringBuilder("Delaying ").append(time2).append(" milliseconds so user doesn't see flicker.");
            this.f1295a.f776c = new Timer();
            this.f1295a.f776c.schedule(new ar(this), time2);
            return;
        }
        this.f1295a.m558b();
    }

    public final void mo3764a(aI aIVar) {
        C0838d.m1117a(this.f1295a, aIVar, 1, 2, 3);
    }
}
