package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cS;
import com.paypal.android.sdk.cV;
import com.paypal.android.sdk.cW;
import com.paypal.android.sdk.cX;
import com.paypal.android.sdk.cz;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public final class PaymentActivity extends Activity {
    public static final String EXTRA_PAYMENT = "com.paypal.android.sdk.payment";
    public static final String EXTRA_RESULT_CONFIRMATION = "com.paypal.android.sdk.paymentConfirmation";
    public static final int RESULT_EXTRAS_INVALID = 2;
    private static final String f831a = PaymentActivity.class.getSimpleName();
    private Timer f832b;
    private Date f833c;
    private PayPalService f834d;
    private final ServiceConnection f835e = new aN(this);
    private boolean f836f;

    private void m663b() {
        PaymentMethodActivity.m706a(this, 1, this.f834d.m637d());
    }

    private aH m664c() {
        return new aP(this);
    }

    static /* synthetic */ void m665c(PaymentActivity paymentActivity) {
        if (paymentActivity.f834d.m637d() == null) {
            Log.e(f831a, "Service state invalid.  Did you start the PayPalService?");
            paymentActivity.setResult(2);
            paymentActivity.finish();
            return;
        }
        aR aRVar = new aR(paymentActivity.getIntent(), paymentActivity.f834d.m637d());
        if (!aRVar.m491d()) {
            Log.e(f831a, "Service extras invalid.  Please see the docs.");
            paymentActivity.setResult(2);
            paymentActivity.finish();
        } else if (aRVar.mo3762e()) {
            paymentActivity.f834d.m645l();
            paymentActivity.f834d.m636c().m331a();
            if (paymentActivity.f834d.m642i()) {
                paymentActivity.m663b();
                return;
            }
            Calendar instance = Calendar.getInstance();
            instance.add(13, 1);
            paymentActivity.f833c = instance.getTime();
            paymentActivity.f834d.m628a(paymentActivity.m664c(), false);
        } else {
            Log.e(f831a, "Extras invalid.  Please see the docs.");
            paymentActivity.setResult(2);
            paymentActivity.finish();
        }
    }

    public final void finish() {
        super.finish();
        new StringBuilder().append(f831a).append(".finish");
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new StringBuilder().append(f831a).append(".onActivityResult");
        if (i == 1) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        Log.e(f831a, "result was OK, no intent data, oops");
                        break;
                    }
                    PaymentConfirmation paymentConfirmation = (PaymentConfirmation) intent.getParcelableExtra(EXTRA_RESULT_CONFIRMATION);
                    if (paymentConfirmation == null) {
                        Log.e(f831a, "result was OK, have data, but no payment state in bundle, oops");
                        break;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra(EXTRA_RESULT_CONFIRMATION, paymentConfirmation);
                    setResult(-1, intent2);
                    break;
                case 0:
                    break;
                default:
                    Log.wtf("paypal.sdk", "unexpected request code " + i + " call it a cancel");
                    break;
            }
        }
        finish();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(f831a).append(".onCreate");
        new cX(this).m412a();
        new cW(this).m410a();
        new cV(this).m409a(Arrays.asList(new String[]{PaymentActivity.class.getName(), LoginActivity.class.getName(), PaymentMethodActivity.class.getName(), PaymentConfirmActivity.class.getName()}));
        this.f836f = bindService(C0838d.m1121b(this), this.f835e, 1);
        C0510f.m461b((Activity) this);
        C0510f.m455a((Activity) this);
        cS cSVar = new cS(this);
        setContentView(cSVar.f552a);
        cSVar.f553b.setText(cz.m428a(cB.CHECKING_DEVICE));
        C0838d.m1116a((Activity) this, null, cB.CHECKING_DEVICE);
    }

    protected final Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 2:
                return C0838d.m1110a((Activity) this, new aM(this));
            case 3:
                return C0838d.m1112a((Activity) this, cB.UNAUTHORIZED_MERCHANT_TITLE, bundle, i);
            default:
                return C0838d.m1112a((Activity) this, cB.UNAUTHORIZED_DEVICE_TITLE, bundle, i);
        }
    }

    protected final void onDestroy() {
        new StringBuilder().append(f831a).append(".onDestroy");
        if (this.f834d != null) {
            this.f834d.m648o();
            this.f834d.m654u();
        }
        if (this.f836f) {
            unbindService(this.f835e);
            this.f836f = false;
        }
        super.onDestroy();
    }
}
