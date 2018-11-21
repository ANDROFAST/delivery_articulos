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

public final class PayPalFuturePaymentActivity extends Activity {
    public static final String EXTRA_RESULT_AUTHORIZATION = "com.paypal.android.sdk.authorization";
    public static final int RESULT_EXTRAS_INVALID = 2;
    private static final String f774a = PayPalFuturePaymentActivity.class.getSimpleName();
    private Date f775b;
    private Timer f776c;
    private PayPalService f777d;
    private final ServiceConnection f778e = new ao(this);
    private boolean f779f;

    private void m558b() {
        FuturePaymentConsentActivity.m1055a(this, 1, this.f777d.m637d());
    }

    private aH m559c() {
        return new aq(this);
    }

    static /* synthetic */ void m560c(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        if (payPalFuturePaymentActivity.f777d.m637d() == null) {
            Log.e(f774a, "Service state invalid.  Did you start the PayPalService?");
            payPalFuturePaymentActivity.setResult(2);
            payPalFuturePaymentActivity.finish();
            return;
        }
        aA aAVar = new aA(payPalFuturePaymentActivity.getIntent(), payPalFuturePaymentActivity.f777d.m637d(), false);
        if (!aAVar.m491d()) {
            Log.e(f774a, "Service extras invalid.  Please see the docs.");
            payPalFuturePaymentActivity.setResult(2);
            payPalFuturePaymentActivity.finish();
        } else if (!aAVar.mo3762e()) {
            Log.e(f774a, "Extras invalid.  Please see the docs.");
            payPalFuturePaymentActivity.setResult(2);
            payPalFuturePaymentActivity.finish();
        } else if (payPalFuturePaymentActivity.f777d.m642i()) {
            payPalFuturePaymentActivity.m558b();
        } else {
            Calendar instance = Calendar.getInstance();
            instance.add(13, 1);
            payPalFuturePaymentActivity.f775b = instance.getTime();
            payPalFuturePaymentActivity.f777d.m628a(payPalFuturePaymentActivity.m559c(), false);
        }
    }

    public final void finish() {
        super.finish();
        new StringBuilder().append(f774a).append(".finish");
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new StringBuilder().append(f774a).append(".onActivityResult");
        if (i == 1) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        Log.e(f774a, "result was OK, no intent data, oops");
                        break;
                    }
                    PayPalAuthorization payPalAuthorization = (PayPalAuthorization) intent.getParcelableExtra("com.paypal.android.sdk.authorization");
                    if (payPalAuthorization == null) {
                        Log.e(f774a, "result was OK, have data, but no authorization state in bundle, oops");
                        break;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("com.paypal.android.sdk.authorization", payPalAuthorization);
                    setResult(-1, intent2);
                    break;
                case 0:
                    break;
                default:
                    Log.wtf(f774a, "unexpected request code " + i + " call it a cancel");
                    break;
            }
        }
        finish();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(f774a).append(".onCreate");
        new cX(this).m412a();
        new cW(this).m410a();
        new cV(this).m409a(Arrays.asList(new String[]{PayPalFuturePaymentActivity.class.getName(), LoginActivity.class.getName(), FuturePaymentInfoActivity.class.getName(), FuturePaymentConsentActivity.class.getName()}));
        this.f779f = bindService(C0838d.m1121b(this), this.f778e, 1);
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
                return C0838d.m1110a((Activity) this, new an(this));
            case 3:
                return C0838d.m1112a((Activity) this, cB.UNAUTHORIZED_MERCHANT_TITLE, bundle, i);
            default:
                return C0838d.m1112a((Activity) this, cB.UNAUTHORIZED_DEVICE_TITLE, bundle, i);
        }
    }

    protected final void onDestroy() {
        new StringBuilder().append(f774a).append(".onDestroy");
        if (this.f777d != null) {
            this.f777d.m648o();
            this.f777d.m654u();
        }
        if (this.f779f) {
            unbindService(this.f778e);
            this.f779f = false;
        }
        super.onDestroy();
    }
}
