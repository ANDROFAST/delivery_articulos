package com.paypal.android.sdk.payments;

import android.text.style.URLSpan;
import android.view.View;

final class bE extends URLSpan {
    private C0541c f953a;

    bE(URLSpan uRLSpan, C0541c c0541c) {
        super(uRLSpan.getURL());
        this.f953a = c0541c;
    }

    public final void onClick(View view) {
        this.f953a.mo3789a();
        super.onClick(view);
    }
}
