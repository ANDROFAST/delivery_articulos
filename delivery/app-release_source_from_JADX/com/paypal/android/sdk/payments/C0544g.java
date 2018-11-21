package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C0544g implements OnClickListener {
    private /* synthetic */ Activity f987a;

    C0544g(Activity activity) {
        this.f987a = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f987a.finish();
    }
}
