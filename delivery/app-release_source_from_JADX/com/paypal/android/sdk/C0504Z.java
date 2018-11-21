package com.paypal.android.sdk;

import java.util.TimerTask;

final class C0504Z extends TimerTask {
    private /* synthetic */ C0503Y f114a;

    C0504Z(C0503Y c0503y) {
        this.f114a = c0503y;
    }

    public final void run() {
        this.f114a.f96f = this.f114a.f96f + 1;
        at.m154a(C0503Y.f88a, "****** LogRiskMetadataTask #" + this.f114a.f96f);
        if (C0503Y.m58c(this.f114a)) {
            at.m154a(C0503Y.f88a, "No host activity in the last " + (this.f114a.f95e / 1000) + " seconds. Stopping update interval.");
            this.f114a.f107q.cancel();
            return;
        }
        try {
            C0503Y.m62f(this.f114a);
        } catch (Throwable e) {
            at.m155a(C0503Y.f88a, "Error in logRiskMetadataTask: ", e);
        }
    }
}
