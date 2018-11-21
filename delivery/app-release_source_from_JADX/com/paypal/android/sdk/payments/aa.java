package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aa implements OnClickListener {
    private /* synthetic */ LoginActivity f910a;

    aa(LoginActivity loginActivity) {
        this.f910a = loginActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f910a.onBackPressed();
    }
}
