package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cf;
import com.paypal.android.sdk.cz;

final class bf implements aF {
    private /* synthetic */ PaymentConfirmActivity f1298a;

    bf(PaymentConfirmActivity paymentConfirmActivity) {
        this.f1298a = paymentConfirmActivity;
    }

    public final void mo3758a(aI aIVar) {
        this.f1298a.f846j.m636c().m331a();
        this.f1298a.m701j();
        if (!aIVar.m734a() || "UNAUTHORIZED_PAYMENT".equals(aIVar.f897b)) {
            switch (aX.f907a[this.f1298a.f844h.ordinal()]) {
                case 1:
                    Bundle bundle = new Bundle();
                    bundle.putString("BUNDLE_ERROR_CODE", aIVar.f897b);
                    this.f1298a.showDialog(5, bundle);
                    return;
                case 2:
                case 3:
                    this.f1298a.f842f.m383b(true);
                    C0838d.m1118a(this.f1298a, cz.m429a(aIVar.f897b), 1);
                    return;
                default:
                    return;
            }
        }
        switch (aX.f907a[this.f1298a.f844h.ordinal()]) {
            case 1:
                C0838d.m1118a(this.f1298a, cz.m428a(cB.SESSION_EXPIRED_MESSAGE), 4);
                return;
            case 2:
            case 3:
                this.f1298a.showDialog(2);
                PaymentConfirmActivity.f837a;
                new StringBuilder("server thinks token is expired, get new one. AccessToken: ").append(this.f1298a.f846j.m636c().f386c);
                this.f1298a.f846j.m628a(this.f1298a.m697h(), true);
                return;
            default:
                return;
        }
    }

    public final void mo3759a(Object obj) {
        if (obj instanceof ProofOfPayment) {
            Parcelable paymentConfirmation = new PaymentConfirmation(this.f1298a.f846j.m638e(), this.f1298a.f843g.m745a(), (ProofOfPayment) obj);
            Intent intent = this.f1298a.getIntent();
            intent.putExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION, paymentConfirmation);
            this.f1298a.m688c();
            this.f1298a.setResult(-1, intent);
            this.f1298a.finish();
        } else if (obj instanceof cf) {
            PaymentConfirmActivity.m677a(this.f1298a, (cf) obj);
        }
    }
}
