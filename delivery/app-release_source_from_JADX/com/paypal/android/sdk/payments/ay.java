package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

final class ay implements aH {
    final /* synthetic */ PayPalProfileSharingActivity f1296a;

    ay(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f1296a = payPalProfileSharingActivity;
    }

    public final void mo3763a() {
        Date time = Calendar.getInstance().getTime();
        if (this.f1296a.f804b.compareTo(time) > 0) {
            long time2 = this.f1296a.f804b.getTime() - time.getTime();
            PayPalProfileSharingActivity.f803a;
            new StringBuilder("Delaying ").append(time2).append(" miliseconds so user doesn't see flicker.");
            this.f1296a.f805c = new Timer();
            this.f1296a.f805c.schedule(new az(this), time2);
            return;
        }
        ProfileSharingConsentActivity.m1061a(this.f1296a, 1, this.f1296a.f806d.m637d());
    }

    public final void mo3764a(aI aIVar) {
        C0838d.m1117a(this.f1296a, aIVar, 1, 2, 3);
    }
}
