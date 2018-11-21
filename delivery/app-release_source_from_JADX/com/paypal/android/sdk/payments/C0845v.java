package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cj;
import com.paypal.android.sdk.cz;

final class C0845v implements aF {
    private /* synthetic */ C0549p f1307a;

    C0845v(C0549p c0549p) {
        this.f1307a = c0549p;
    }

    public final void mo3758a(aI aIVar) {
        this.f1307a.dismissDialog(2);
        if (aIVar.f897b.equals("invalid_nonce")) {
            this.f1307a.f997c.f466h.setEnabled(false);
            C0838d.m1118a(this.f1307a, cz.m428a(cB.SESSION_EXPIRED_MESSAGE), 4);
            return;
        }
        this.f1307a.f997c.f466h.setEnabled(true);
        C0838d.m1118a(this.f1307a, cz.m429a(aIVar.f897b), 1);
    }

    public final void mo3759a(Object obj) {
        if (obj instanceof cj) {
            C0549p.m779a(this.f1307a, (cj) obj);
        } else {
            this.f1307a.m794i();
        }
    }
}
