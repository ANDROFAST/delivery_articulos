package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class C0543f implements OnClickListener {
    private /* synthetic */ Activity f985a;
    private /* synthetic */ int f986b;

    C0543f(Activity activity, int i) {
        this.f985a = activity;
        this.f986b = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f985a.removeDialog(this.f986b);
        this.f985a.finish();
    }
}
