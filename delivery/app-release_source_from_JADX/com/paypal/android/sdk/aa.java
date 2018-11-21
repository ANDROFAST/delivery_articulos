package com.paypal.android.sdk;

import java.util.TimerTask;

final class aa extends TimerTask {
    private /* synthetic */ C0503Y f175a;

    aa(C0503Y c0503y) {
        this.f175a = c0503y;
    }

    public final void run() {
        this.f175a.f97g = this.f175a.f97g + 1;
        at.m154a(C0503Y.f88a, "****** LoadConfigurationTask #" + this.f175a.f97g);
        ak.m129a().m131a(new ah(this.f175a.f92b, this.f175a.f99i, this.f175a.f108r));
    }
}
