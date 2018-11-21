package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class C0516A implements OnClickListener {
    private /* synthetic */ C0549p f683a;

    C0516A(C0549p c0549p) {
        this.f683a = c0549p;
    }

    public final void onClick(View view) {
        view.setEnabled(false);
        C0549p.m791f(this.f683a);
    }
}
