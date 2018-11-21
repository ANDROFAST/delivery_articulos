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
import java.util.Date;
import java.util.Timer;

public final class PayPalProfileSharingActivity extends Activity {
    public static final String EXTRA_REQUESTED_SCOPES = "com.paypal.android.sdk.requested_scopes";
    public static final String EXTRA_RESULT_AUTHORIZATION = "com.paypal.android.sdk.authorization";
    public static final int RESULT_EXTRAS_INVALID = 2;
    private static final String f803a = PayPalProfileSharingActivity.class.getSimpleName();
    private Date f804b;
    private Timer f805c;
    private PayPalService f806d;
    private final ServiceConnection f807e = new ax(this);
    private boolean f808f;

    public final void finish() {
        super.finish();
        new StringBuilder().append(getClass().getSimpleName()).append(".finish");
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new StringBuilder().append(getClass().getSimpleName()).append(".onActivityResult");
        if (i == 1) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        Log.e(f803a, "result was OK, no intent data, oops");
                        break;
                    }
                    PayPalAuthorization payPalAuthorization = (PayPalAuthorization) intent.getParcelableExtra("com.paypal.android.sdk.authorization");
                    if (payPalAuthorization == null) {
                        Log.e(f803a, "result was OK, have data, but no authorization state in bundle, oops");
                        break;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("com.paypal.android.sdk.authorization", payPalAuthorization);
                    setResult(-1, intent2);
                    break;
                case 0:
                    break;
                default:
                    Log.wtf(f803a, "unexpected request code " + i + " call it a cancel");
                    break;
            }
        }
        finish();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(getClass().getSimpleName()).append(".onCreate");
        new cX(this).m412a();
        new cW(this).m410a();
        new cV(this).m409a(Arrays.asList(new String[]{PayPalProfileSharingActivity.class.getName(), LoginActivity.class.getName(), FuturePaymentInfoActivity.class.getName(), ProfileSharingConsentActivity.class.getName()}));
        this.f808f = bindService(C0838d.m1121b(this), this.f807e, 1);
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
                return C0838d.m1110a((Activity) this, new aw(this));
            case 3:
                return C0838d.m1112a((Activity) this, cB.UNAUTHORIZED_MERCHANT_TITLE, bundle, i);
            default:
                return C0838d.m1112a((Activity) this, cB.UNAUTHORIZED_DEVICE_TITLE, bundle, i);
        }
    }

    protected final void onDestroy() {
        new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy");
        if (this.f806d != null) {
            this.f806d.m648o();
            this.f806d.m654u();
        }
        if (this.f808f) {
            unbindService(this.f807e);
            this.f808f = false;
        }
        super.onDestroy();
    }
}
