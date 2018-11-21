package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.os.Bundle;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cz;

public final class FuturePaymentInfoActivity extends Activity {
    private C0526K f717a;

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0525J c0525j = (C0525J) getIntent().getExtras().getSerializable("com.paypal.details.scope");
        C0510f.m461b((Activity) this);
        C0510f.m455a((Activity) this);
        this.f717a = new C0526K(this, c0525j);
        setContentView(this.f717a.f728a);
        C0838d.m1116a((Activity) this, this.f717a.f729b, null);
        this.f717a.f730c.setText(cz.m428a(cB.BACK_BUTTON));
        this.f717a.f730c.setOnClickListener(new C0524I(this));
    }
}
