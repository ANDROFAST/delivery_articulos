package com.paypal.android.sdk.payments;

import android.view.View;
import android.view.View.OnClickListener;

final class C0524I implements OnClickListener {
    private /* synthetic */ FuturePaymentInfoActivity f722a;

    C0524I(FuturePaymentInfoActivity futurePaymentInfoActivity) {
        this.f722a = futurePaymentInfoActivity;
    }

    public final void onClick(View view) {
        this.f722a.finish();
    }
}
