package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.bA;
import com.paypal.android.sdk.bO;
import com.paypal.android.sdk.bp;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cK;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;
import io.card.payment.CardIOActivity;
import io.card.payment.CardType;
import io.card.payment.CreditCard;
import java.util.Locale;
import java.util.Timer;

public final class PaymentMethodActivity extends Activity {
    private static final String f853a = PaymentMethodActivity.class.getSimpleName();
    private Timer f854b;
    private boolean f855c;
    private boolean f856d;
    private boolean f857e;
    private boolean f858f;
    private cK f859g;
    private aS f860h;
    private PayPalService f861i;
    private final ServiceConnection f862j = new bt(this);
    private boolean f863k;

    static void m706a(Activity activity, int i, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, PaymentMethodActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void m707a(PaymentMethodActivity paymentMethodActivity) {
        paymentMethodActivity.f861i.m622a(cy.SelectPayPalPayment);
        PaymentConfirmActivity.m673a(paymentMethodActivity, 2, bk.PayPal, null, paymentMethodActivity.f861i.m637d());
    }

    private void m709b() {
        if (this.f857e && !this.f856d) {
            this.f859g.f527m.setImageBitmap(bp.m325c("iVBORw0KGgoAAAANSUhEUgAAADcAAAAsCAYAAADByiAeAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAohJREFUeNrcWYGRgjAQJMwXQAl0IFbwWMFrBS8VvHYAFagVoBVIB2IFaAV8B08H/GUm/GA+CUouBL2ZTByEwCZ3m70LcRCsrusQutDBswranhBSOTYNgC1rM1ZA82yD+6nN2Urn21xNYAF0Jmf33Ro45DhDH9+1ObN3mMe84yVXTusd7ojjTds7iIzeoZtAU7mE1/E/5p536fj/yvbFb+VmDK2sn9c27b2RcKuVOs9vdJVnVN0QBsyHrjAQQ9RNMmhn5j5tC1g8zQ0A3AK4dbNqKbJ7nJjevIeYKN3HBpSOjy2h6DjznuxLQR4xpZvbYj4MX5+CO2S9aJvGCCEL+LnGEgBv2EEsWRXqIj4HJpeA3ML9FRq5IbhioEiHCsVz6V9s/H9WlwdiDHArSfycHpicpWSM0ia4UvJRRY+xlsiJcKwrnBPBtbSnLEt594b427O9cvisgL2cr6XobMobwbWdDXAitvvUTW8E5JTbAHcWXMOQUiHnHRcb4CrBXoYhBiYSjTooOH5GfSRB4I8BnI/xAV0eoTNxaOCUWfBjdh0DOFFsZAjgMkGtZnBCCTH3pIb2BewY2gDn8bkbU/q5xpgJ5t6pK7++BNcWHdUqmUV8GsQUj72irGD1KNvNHgQY8VJOIccGz+c8ybhxR9pyVOSCsW4+11S/asOZeMCIwWvdnyvuxygzJhgrh3pYiHiYqZ3P8XXI4t6SniTJ3WAWhjHBNUripKqNKNyQFoVXmB+DFXOqWDyw/tLEGItBCv6DpUkmTouSBlyJqOrHYlHjlocXA0Y9JGvAbSWpxrPajoaAy6mKVwBIDyHjG7ZkanyqKXxtu+IacEQ3bCmgZt8gixlhZdEBzK8AAwBIvuGtI5K/kgAAAABJRU5ErkJggg==", (Context) this));
            this.f859g.f527m.setVisibility(0);
            this.f859g.f527m.setContentDescription(cz.m428a(cB.SCAN_CARD_ICON_DESCRIPTION));
        }
    }

    private void m711c() {
        new StringBuilder().append(f853a).append(".refreshPayment");
        if (C0547n.m772a(this, this.f861i)) {
            this.f861i.m641h();
        }
        PayPalPayment a = this.f860h.m745a();
        CharSequence a2 = bO.m221a(Locale.getDefault(), bq.m947a().mo3737c().m474a(), a.m568a().doubleValue(), a.m571d(), true);
        this.f859g.f517c.f548d.setText(a.m569b());
        this.f859g.f517c.f547c.setText(a2);
        if (this.f861i.m643j() && this.f861i.m636c().f391h.m938a()) {
            a2 = this.f861i.m651r();
            if (C0510f.m462b(a2)) {
                this.f859g.f518d.setText(a2);
                this.f859g.f518d.setVisibility(0);
                this.f859g.f516b.setVisibility(0);
            } else {
                this.f859g.f518d.setVisibility(8);
                this.f859g.f516b.setVisibility(8);
            }
        } else {
            this.f859g.f518d.setVisibility(8);
            this.f859g.f516b.setVisibility(8);
        }
        if (this.f861i.m637d().m546i()) {
            new bv().execute(new Void[0]);
            bA s = this.f861i.m652s();
            if (s == null || !s.m931b()) {
                this.f859g.f521g.setVisibility(8);
                this.f859g.f519e.setText(cz.m428a(cB.PAY_WITH_CARD));
                this.f859g.f525k.setVisibility(8);
            } else {
                this.f856d = true;
                this.f859g.f527m.setVisibility(8);
                this.f859g.f519e.setText(s.m933d());
                CardType a3 = C0510f.m450a(s);
                this.f859g.f521g.setImageBitmap(C0510f.m449a((Activity) this, a3));
                this.f859g.f521g.setContentDescription(a3.toString());
                this.f859g.f521g.setVisibility(0);
                this.f859g.f525k.setText(cz.m428a(cB.CLEAR_CREDIT_CARD_INFO));
                this.f859g.f525k.setVisibility(0);
                this.f859g.f522h.setVisibility(0);
                this.f859g.f525k.setVisibility(0);
            }
            m709b();
        } else {
            this.f859g.f522h.setVisibility(8);
            this.f859g.f525k.setVisibility(8);
        }
        C0838d.m1119a(this.f859g.f523i.f472b, this.f861i.m637d().m539b());
    }

    static /* synthetic */ void m712c(PaymentMethodActivity paymentMethodActivity) {
        paymentMethodActivity.f861i.m622a(cy.SelectCreditCardPayment);
        bA s = paymentMethodActivity.f861i.m652s();
        if (s == null || !s.m931b()) {
            Intent intent = new Intent(paymentMethodActivity, CardIOActivity.class);
            intent.putExtra(CardIOActivity.EXTRA_LANGUAGE_OR_LOCALE, paymentMethodActivity.f861i.m637d().m538a());
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true);
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, true);
            intent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false);
            new StringBuilder("startActivityForResult(").append(intent).append(", 1").append(")");
            paymentMethodActivity.startActivityForResult(intent, 1);
            return;
        }
        PaymentConfirmActivity.m673a(paymentMethodActivity, 2, bk.CreditCardToken, null, paymentMethodActivity.f861i.m637d());
    }

    private void m713d() {
        this.f863k = bindService(C0838d.m1121b(this), this.f862j, 1);
    }

    static /* synthetic */ void m719i(PaymentMethodActivity paymentMethodActivity) {
        if (!paymentMethodActivity.f858f) {
            paymentMethodActivity.f858f = true;
            paymentMethodActivity.f861i.m622a(cy.PaymentMethodWindow);
        }
        boolean z = !paymentMethodActivity.f855c && (!paymentMethodActivity.f861i.m637d().m546i() || paymentMethodActivity.f861i.m652s() == null);
        new StringBuilder("autoAdvanceToPayPalConfirmIfLoggedIn: ").append(z);
        if (!C0547n.m772a(paymentMethodActivity, paymentMethodActivity.f861i) && (!(paymentMethodActivity.f861i.m637d().m546i() || paymentMethodActivity.f855c) || (z && paymentMethodActivity.f861i.m643j() && paymentMethodActivity.f861i.m636c().f391h.m938a()))) {
            paymentMethodActivity.showDialog(3);
            paymentMethodActivity.f855c = true;
            paymentMethodActivity.f854b = new Timer();
            paymentMethodActivity.f854b.schedule(new bq(paymentMethodActivity), 1000);
            paymentMethodActivity.f855c = true;
        }
        paymentMethodActivity.m711c();
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new StringBuilder().append(f853a).append(".onActivityResult (requestCode: ").append(i).append(", resultCode: ").append(i2).append(")");
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
                    PaymentConfirmActivity.m674a(this, 2, bk.CreditCard, (CreditCard) intent.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT), (PayPalConfiguration) getIntent().getParcelableExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION), true);
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    PaymentConfirmation paymentConfirmation = (PaymentConfirmation) intent.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                    Intent intent2 = new Intent();
                    intent2.putExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION, paymentConfirmation);
                    setResult(i2, intent2);
                    finish();
                    return;
                } else if (i2 == 0) {
                    this.f855c = true;
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public final void onBackPressed() {
        new StringBuilder().append(f853a).append(".onBackPressed");
        if (this.f861i != null) {
            this.f861i.m622a(cy.PaymentMethodCancel);
        }
        if (this.f854b != null) {
            this.f854b.cancel();
        }
        super.onBackPressed();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(f853a).append(".onCreate");
        C0510f.m461b((Activity) this);
        C0510f.m455a((Activity) this);
        m713d();
        this.f859g = new cK(this);
        this.f860h = new aS(getIntent());
        setContentView(this.f859g.f515a);
        C0838d.m1116a((Activity) this, this.f859g.f526l, cB.YOUR_ORDER);
        this.f859g.f520f.setText(cz.m428a(cB.PAY_WITH));
        this.f859g.f516b.setText(cz.m428a(cB.LOG_OUT_BUTTON));
        this.f859g.f524j.setOnClickListener(new bm(this));
        this.f859g.f516b.setOnClickListener(new bn(this));
        this.f859g.f522h.setOnClickListener(new bo(this));
        this.f859g.f525k.setOnClickListener(new bp(this));
        if (bundle == null) {
            if (!C0838d.m1120a((Activity) this)) {
                finish();
            }
            this.f858f = false;
        } else {
            this.f855c = bundle.getBoolean("PP_PreventAutoLogin");
            this.f858f = bundle.getBoolean("PP_PageTrackingSent");
        }
        this.f854b = null;
    }

    protected final Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return C0838d.m1108a((Activity) this, cB.LOG_OUT, cB.CONFIRM_LOG_OUT, new br(this));
            case 2:
                return C0838d.m1108a((Activity) this, cB.CLEAR_CC_ALERT_TITLE, cB.CONFIRM_CLEAR_CREDIT_CARD_INFO, new bs(this));
            case 3:
                return C0838d.m1114a((Context) this, cB.AUTHENTICATING, cB.ONE_MOMENT);
            default:
                return null;
        }
    }

    protected final void onDestroy() {
        new StringBuilder().append(f853a).append(".onDestroy");
        if (this.f863k) {
            unbindService(this.f862j);
            this.f863k = false;
        }
        super.onDestroy();
    }

    protected final void onRestart() {
        super.onRestart();
        m713d();
    }

    protected final void onResume() {
        super.onResume();
        new StringBuilder().append(f853a).append(".onResume");
        if (this.f861i != null) {
            m711c();
        }
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        new StringBuilder().append(f853a).append(".onSaveInstanceState");
        bundle.putBoolean("PP_PreventAutoLogin", this.f855c);
        bundle.putBoolean("PP_PageTrackingSent", this.f858f);
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f859g.f517c.m398a();
    }
}
