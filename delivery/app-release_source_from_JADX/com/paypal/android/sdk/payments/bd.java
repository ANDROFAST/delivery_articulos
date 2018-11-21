package com.paypal.android.sdk.payments;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cR;
import com.paypal.android.sdk.cz;
import java.util.ArrayList;

final class bd implements OnClickListener {
    final /* synthetic */ cR f958a;
    final /* synthetic */ ArrayList f959b;
    final /* synthetic */ PaymentConfirmActivity f960c;

    bd(PaymentConfirmActivity paymentConfirmActivity, cR cRVar, ArrayList arrayList) {
        this.f960c = paymentConfirmActivity;
        this.f958a = cRVar;
        this.f959b = arrayList;
    }

    public final void onClick(View view) {
        Builder builder = new Builder(view.getContext());
        builder.setTitle(cz.m428a(cB.SHIPPING_ADDRESS)).setAdapter(this.f958a, new be(this));
        builder.create().show();
    }
}
