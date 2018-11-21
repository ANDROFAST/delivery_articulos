package com.paypal.android.sdk.payments;

import android.app.AlertDialog.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cM;
import com.paypal.android.sdk.cz;
import java.util.List;

final class C0530Q implements OnClickListener {
    final /* synthetic */ cM f870a;
    final /* synthetic */ List f871b;
    final /* synthetic */ LoginActivity f872c;

    C0530Q(LoginActivity loginActivity, cM cMVar, List list) {
        this.f872c = loginActivity;
        this.f870a = cMVar;
        this.f871b = list;
    }

    public final void onClick(View view) {
        Builder builder = new Builder(view.getContext());
        builder.setTitle(cz.m428a(cB.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER)).setAdapter(this.f870a, new C0531R(this));
        builder.create().show();
    }
}
