package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.text.style.URLSpan;
import android.view.View;

final class C0540b extends URLSpan {
    private Activity f939a;
    private Class f940b;
    private C0541c f941c;
    private C0525J f942d;

    C0540b(URLSpan uRLSpan, Activity activity, Class cls, C0541c c0541c, C0525J c0525j) {
        super(uRLSpan.getURL());
        this.f939a = activity;
        this.f940b = cls;
        this.f941c = c0541c;
        this.f942d = c0525j;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.f939a, this.f940b);
        intent.putExtra("com.paypal.details.scope", this.f942d);
        this.f941c.mo3789a();
        this.f939a.startActivity(intent);
    }
}
