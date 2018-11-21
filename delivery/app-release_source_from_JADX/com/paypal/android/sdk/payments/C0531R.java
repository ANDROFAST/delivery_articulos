package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C0531R implements OnClickListener {
    private /* synthetic */ C0530Q f873a;

    C0531R(C0530Q c0530q) {
        this.f873a = c0530q;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f873a.f872c.f749o = i;
        this.f873a.f870a.m394a(i);
        this.f873a.f872c.f750p.f497o.m395a((String) this.f873a.f871b.get(i));
    }
}
