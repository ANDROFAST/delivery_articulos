package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.paypal.android.sdk.C0497R;
import com.paypal.android.sdk.C0498S;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.C1173Q;
import com.paypal.android.sdk.bA;
import com.paypal.android.sdk.bD;
import com.paypal.android.sdk.bO;
import com.paypal.android.sdk.bV;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cE;
import com.paypal.android.sdk.cF;
import com.paypal.android.sdk.cJ;
import com.paypal.android.sdk.cQ;
import com.paypal.android.sdk.cR;
import com.paypal.android.sdk.cf;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;
import io.card.payment.CardType;
import io.card.payment.CreditCard;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class PaymentConfirmActivity extends Activity {
    private static final String f837a = PaymentConfirmActivity.class.getSimpleName();
    private bj f838b;
    private bA f839c;
    private boolean f840d;
    private boolean f841e;
    private cJ f842f;
    private aS f843g;
    private bk f844h;
    private CreditCard f845i;
    private PayPalService f846j;
    private final ServiceConnection f847k = new aZ(this);
    private boolean f848l;

    private static bV m669a(PayPalPayment payPalPayment) {
        return new bV(new BigDecimal(bO.m215a(payPalPayment.m568a().doubleValue(), payPalPayment.m571d()).trim()), payPalPayment.m571d());
    }

    private void m672a(int i) {
        setResult(i, new Intent());
    }

    static void m673a(Activity activity, int i, bk bkVar, CreditCard creditCard, PayPalConfiguration payPalConfiguration) {
        m674a(activity, 2, bkVar, null, payPalConfiguration, false);
    }

    static void m674a(Activity activity, int i, bk bkVar, CreditCard creditCard, PayPalConfiguration payPalConfiguration, boolean z) {
        Intent intent = new Intent(activity, PaymentConfirmActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_KIND", bkVar);
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_CREDIT_CARD", creditCard);
        intent.putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_RESET_PP_REQUEST_ID", z);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
        activity.startActivityForResult(intent, i);
    }

    private void m675a(Bundle bundle) {
        String string = bundle.getString("authAccount");
        String string2 = bundle.getString("authtoken");
        String string3 = bundle.getString("scope");
        long j = bundle.getLong("valid_until");
        for (String str : bundle.keySet()) {
            if (bundle.get(str) == null) {
                String.format("%s:null", new Object[]{(String) r1.next()});
            } else {
                String.format("%s:%s (%s)", new Object[]{(String) r1.next(), bundle.get(str).toString(), bundle.get(str).getClass().getName()});
            }
        }
        bD bDVar = new bD(string2, string3, j, false);
        if (this.f846j == null) {
            this.f838b = new bj(this, string, bDVar);
        } else {
            m681a(string, bDVar);
        }
    }

    static /* synthetic */ void m677a(PaymentConfirmActivity paymentConfirmActivity, cf cfVar) {
        paymentConfirmActivity.f839c = new bA(cfVar, paymentConfirmActivity.f843g.m745a().getProvidedShippingAddress());
        paymentConfirmActivity.getIntent().putExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO", paymentConfirmActivity.f839c);
        paymentConfirmActivity.m684b();
        paymentConfirmActivity.m701j();
    }

    static /* synthetic */ void m678a(PaymentConfirmActivity paymentConfirmActivity, List list, int i) {
        paymentConfirmActivity.f843g.m746b().m750a(i);
        paymentConfirmActivity.f842f.m373a((Context) paymentConfirmActivity, (cE) list.get(i));
    }

    private void m680a(String str) {
        this.f842f.m377a(str);
    }

    private void m681a(String str, bD bDVar) {
        this.f846j.m636c().f387d = str;
        m680a(str);
        this.f846j.m636c().f391h = bDVar;
        if (this.f844h != bk.PayPal) {
            this.f842f.m383b(true);
        }
    }

    private void m682a(boolean z) {
        new StringBuilder().append(f837a).append(".doLogin");
        if (C0547n.m772a(this, this.f846j)) {
            Intent a = new C1173Q().m1184a(this.f846j.m637d().m548k(), z ? C0497R.PROMPT_LOGIN : C0497R.USER_REQUIRED, C0498S.token, this.f846j.m634b().mo3730d().m184e());
            new StringBuilder("startActivityForResult(").append(a).append(", 2").append(")");
            Log.w("paypal.sdk", "requesting " + a.getStringExtra("response_type") + " with scope={" + a.getStringExtra("scope") + "} from Authenticator.");
            startActivityForResult(a, 2);
            return;
        }
        LoginActivity.m502a(this, 1, this.f846j.m650q(), false, z, "https://uri.paypal.com/services/payments/basic", this.f846j.m637d());
    }

    private static Map m683b(PayPalPayment payPalPayment) {
        if (payPalPayment != null) {
            Map hashMap = new HashMap();
            PayPalPaymentDetails f = payPalPayment.m573f();
            if (f != null) {
                if (f.m579b() != null) {
                    hashMap.put("shipping", bO.m215a(f.m579b().doubleValue(), payPalPayment.m571d()));
                }
                if (f.m578a() != null) {
                    hashMap.put("subtotal", bO.m215a(f.m578a().doubleValue(), payPalPayment.m571d()));
                }
                if (f.m580c() != null) {
                    hashMap.put("tax", bO.m215a(f.m580c().doubleValue(), payPalPayment.m571d()));
                }
            }
            if (!hashMap.isEmpty()) {
                return hashMap;
            }
        }
        return null;
    }

    private void m684b() {
        if (this.f839c != null) {
            Object cRVar;
            JSONObject jSONObject = null;
            if (this.f839c.m751b() != null) {
                jSONObject = this.f839c.m751b().toJSONObject();
            }
            int h = this.f839c.m758h();
            ArrayList a = cQ.m965a(jSONObject, this.f839c.m749a(), this.f839c.m759i());
            if (a == null || a.size() <= 0) {
                this.f842f.m389f().setClickable(false);
                this.f842f.m389f().setVisibility(8);
            } else {
                this.f842f.m389f().setVisibility(0);
                this.f842f.m389f().setClickable(true);
                this.f842f.m374a(getApplicationContext(), (cQ) a.get(h));
                cRVar = new cR(this, a, h);
                new ListView(this).setAdapter(cRVar);
                this.f842f.m387d(new bd(this, cRVar, a));
            }
            h = this.f839c.m757g();
            a = cE.m956a(this.f839c.m753c(), this.f839c.m754d());
            if (a == null || a.size() <= 0) {
                this.f842f.m388e().setClickable(false);
                this.f842f.m388e().setVisibility(8);
            } else {
                this.f842f.m388e().setVisibility(0);
                this.f842f.m388e().setClickable(true);
                this.f842f.m373a(getApplicationContext(), (cE) a.get(h));
                cRVar = new cF(this, a, h);
                new ListView(this).setAdapter(cRVar);
                this.f842f.m385c(new bb(this, cRVar, a));
            }
            this.f842f.m383b(true);
        }
    }

    static /* synthetic */ void m685b(PaymentConfirmActivity paymentConfirmActivity) {
        new StringBuilder().append(f837a).append(".postBindSetup()");
        if (paymentConfirmActivity.f844h.equals(bk.PayPal)) {
            paymentConfirmActivity.f842f.m375a(C0510f.m465d(paymentConfirmActivity.f846j.m637d().m538a()));
        } else {
            paymentConfirmActivity.f842f.m375a(null);
        }
        if (paymentConfirmActivity.f838b != null) {
            paymentConfirmActivity.m681a(paymentConfirmActivity.f838b.f965a, paymentConfirmActivity.f838b.f966b);
            paymentConfirmActivity.f838b = null;
        }
        if (paymentConfirmActivity.getIntent().getBooleanExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_RESET_PP_REQUEST_ID", false)) {
            paymentConfirmActivity.f846j.m636c().m331a();
        }
        boolean e = paymentConfirmActivity.m692e();
        if (!paymentConfirmActivity.f840d) {
            paymentConfirmActivity.f840d = true;
            paymentConfirmActivity.f846j.m622a(cy.ConfirmPaymentWindow);
        }
        paymentConfirmActivity.m693f();
        paymentConfirmActivity.f846j.m635b(new bf(paymentConfirmActivity));
        if (bk.PayPal == paymentConfirmActivity.f844h && !e && paymentConfirmActivity.f839c == null) {
            paymentConfirmActivity.m700i();
        }
    }

    static /* synthetic */ void m686b(PaymentConfirmActivity paymentConfirmActivity, List list, int i) {
        paymentConfirmActivity.f843g.m746b().m752b(i);
        paymentConfirmActivity.f842f.m374a((Context) paymentConfirmActivity, (cQ) list.get(i));
    }

    private void m688c() {
        if (this.f846j.m636c().f391h != null && !this.f846j.m636c().f391h.m938a()) {
            this.f846j.m636c().f391h = null;
            this.f846j.m636c().f387d = null;
        }
    }

    private void m690d() {
        this.f848l = bindService(C0838d.m1121b(this), this.f847k, 1);
    }

    private boolean m692e() {
        if (!this.f844h.equals(bk.PayPal) || this.f846j.m643j() || this.f841e) {
            return false;
        }
        this.f841e = true;
        m682a(false);
        return true;
    }

    private void m693f() {
        PayPalPayment a = this.f843g.m745a();
        this.f842f.m379a(a.m569b(), bO.m221a(Locale.getDefault(), bq.m947a().mo3737c().m474a(), a.m568a().doubleValue(), a.m571d(), true));
        if (this.f844h == bk.PayPal) {
            this.f842f.m380a(true);
            m680a(this.f846j.m651r());
        } else if (this.f844h == bk.CreditCard || this.f844h == bk.CreditCardToken) {
            String a2;
            int i;
            int i2;
            CardType cardType;
            this.f842f.m380a(false);
            if (this.f844h == bk.CreditCard) {
                a2 = bA.m928a(this.f845i.getRedactedCardNumber());
                i = this.f845i.expiryMonth;
                i2 = this.f845i.expiryYear;
                cardType = this.f845i.getCardType();
            } else {
                bA s = this.f846j.m652s();
                a2 = s.m933d();
                i = s.m935f();
                i2 = s.m936g();
                cardType = C0510f.m450a(s);
            }
            this.f842f.m378a(a2, C0510f.m449a((Activity) this, cardType), String.format(Locale.getDefault(), "%02d / %04d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        } else {
            Log.wtf(f837a, "Unknown payment type: " + this.f844h.toString());
            C0838d.m1118a((Activity) this, "The payment is not a valid type. Please try again.", 3);
        }
        C0838d.m1119a(this.f842f.m386d(), this.f846j.m638e());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m696g() {
        /*
        r27 = this;
        r1 = com.paypal.android.sdk.payments.aX.f907a;
        r0 = r27;
        r2 = r0.f844h;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0013;
            case 2: goto L_0x001d;
            case 3: goto L_0x001d;
            default: goto L_0x000f;
        };
    L_0x000f:
        r1 = 1;
    L_0x0010:
        if (r1 != 0) goto L_0x004f;
    L_0x0012:
        return;
    L_0x0013:
        r1 = r27.m692e();
        if (r1 != 0) goto L_0x001b;
    L_0x0019:
        r1 = 1;
        goto L_0x0010;
    L_0x001b:
        r1 = 0;
        goto L_0x0010;
    L_0x001d:
        r0 = r27;
        r1 = r0.f846j;
        r1 = r1.m642i();
        if (r1 != 0) goto L_0x000f;
    L_0x0027:
        r1 = 2;
        r0 = r27;
        r0.showDialog(r1);
        r1 = new java.lang.StringBuilder;
        r2 = "token is expired, get new one. AccessToken: ";
        r1.<init>(r2);
        r0 = r27;
        r2 = r0.f846j;
        r2 = r2.m636c();
        r2 = r2.f386c;
        r1.append(r2);
        r0 = r27;
        r1 = r0.f846j;
        r2 = r27.m697h();
        r3 = 1;
        r1.m628a(r2, r3);
        r1 = 0;
        goto L_0x0010;
    L_0x004f:
        r1 = 2;
        r0 = r27;
        r0.showDialog(r1);
        r0 = r27;
        r1 = r0.f843g;
        r17 = r1.m745a();
        r6 = m669a(r17);
        r7 = m683b(r17);
        r9 = r17.m569b();
        r0 = r27;
        r1 = r0.f846j;
        r1 = r1.m637d();
        r2 = r1.m547j();
        r1 = com.paypal.android.sdk.payments.aX.f907a;
        r0 = r27;
        r3 = r0.f844h;
        r3 = r3.ordinal();
        r1 = r1[r3];
        switch(r1) {
            case 1: goto L_0x0085;
            case 2: goto L_0x00ba;
            case 3: goto L_0x0104;
            default: goto L_0x0084;
        };
    L_0x0084:
        goto L_0x0012;
    L_0x0085:
        r0 = r27;
        r1 = r0.f843g;
        r6 = r1.m746b();
        r0 = r27;
        r1 = r0.f846j;
        r3 = r6.m755e();
        r4 = r6.m756f();
        r5 = r6.m761k();
        if (r5 == 0) goto L_0x00b6;
    L_0x009f:
        r5 = r6.m763m();
    L_0x00a3:
        r7 = r6.m760j();
        if (r7 == 0) goto L_0x00b8;
    L_0x00a9:
        r6 = r6.m762l();
    L_0x00ad:
        r7 = r17.m572e();
        r1.m632a(r2, r3, r4, r5, r6, r7);
        goto L_0x0012;
    L_0x00b6:
        r5 = 0;
        goto L_0x00a3;
    L_0x00b8:
        r6 = 0;
        goto L_0x00ad;
    L_0x00ba:
        r0 = r27;
        r1 = r0.f846j;
        r1 = r1.m652s();
        r0 = r27;
        r3 = r0.f846j;
        r4 = r1.m350a();
        r11 = r3.m617a(r4);
        r0 = r27;
        r3 = r0.f846j;
        r0 = r27;
        r4 = r0.f846j;
        r4 = r4.m636c();
        r4 = r4.m332b();
        r5 = r1.m934e();
        r8 = r17.m574g();
        r12 = r17.m572e();
        r1 = r17.m570c();
        r13 = r1.toString();
        r14 = r17.m575h();
        r15 = r17.m576i();
        r16 = r17.m577j();
        r10 = r2;
        r3.m629a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
        goto L_0x0012;
    L_0x0104:
        r0 = r27;
        r10 = r0.f846j;
        r0 = r27;
        r1 = r0.f846j;
        r1 = r1.m636c();
        r11 = r1.m332b();
        r0 = r27;
        r1 = r0.f845i;
        r1 = r1.getCardType();
        r1 = r1.toString();
        r3 = java.util.Locale.US;
        r12 = r1.toLowerCase(r3);
        r0 = r27;
        r1 = r0.f845i;
        r13 = r1.cardNumber;
        r0 = r27;
        r1 = r0.f845i;
        r14 = r1.cvv;
        r0 = r27;
        r1 = r0.f845i;
        r15 = r1.expiryMonth;
        r0 = r27;
        r1 = r0.f845i;
        r0 = r1.expiryYear;
        r16 = r0;
        r19 = r17.m574g();
        r22 = r17.m572e();
        r1 = r17.m570c();
        r23 = r1.toString();
        r24 = r17.m575h();
        r25 = r17.m576i();
        r26 = r17.m577j();
        r17 = r6;
        r18 = r7;
        r20 = r9;
        r21 = r2;
        r10.m630a(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
        goto L_0x0012;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.PaymentConfirmActivity.g():void");
    }

    private aH m697h() {
        return new aW(this);
    }

    private void m700i() {
        if (this.f846j != null && this.f846j.m636c().f391h != null) {
            showDialog(2);
            PayPalPayment a = this.f843g.m745a();
            this.f846j.m621a(m669a(a), m683b(a), a.m574g(), a.m569b(), this.f846j.m637d().m547j(), a.m572e(), a.m570c().toString(), a.isEnablePayPalShippingAddressesRetrieval(), a.m575h(), a.m576i(), a.m577j());
            m680a(this.f846j.m651r());
        }
    }

    private void m701j() {
        try {
            dismissDialog(2);
        } catch (IllegalArgumentException e) {
        }
    }

    public final void finish() {
        super.finish();
        new StringBuilder().append(f837a).append(".finish");
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new StringBuilder().append(f837a).append(".onActivityResult(requestCode:").append(i).append(", resultCode:").append(i2).append(", data:").append(intent).append(")");
        switch (i) {
            case 1:
                if (i2 == -1) {
                    if (this.f842f != null) {
                        this.f842f.m383b(false);
                    }
                    if (this.f846j != null) {
                        m700i();
                        return;
                    }
                    return;
                }
                m672a(i2);
                finish();
                return;
            case 2:
                if (i2 == -1) {
                    this.f842f.m383b(true);
                    m675a(intent.getExtras());
                    if (this.f846j != null) {
                        m700i();
                        return;
                    }
                    return;
                }
                m672a(i2);
                finish();
                return;
            default:
                Log.e(f837a, "unhandled requestCode " + i);
                return;
        }
    }

    public final void onBackPressed() {
        this.f846j.m622a(cy.ConfirmPaymentCancel);
        m688c();
        super.onBackPressed();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(f837a).append(".onCreate");
        m690d();
        if (bundle == null) {
            if (!C0838d.m1120a((Activity) this)) {
                finish();
            }
            this.f840d = false;
        } else {
            this.f840d = bundle.getBoolean("pageTrackingSent");
            this.f841e = bundle.getBoolean("isLoginActivityStarted");
        }
        if (getIntent().getExtras() == null) {
            onBackPressed();
            return;
        }
        this.f844h = (bk) getIntent().getSerializableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_KIND");
        this.f845i = (CreditCard) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_CREDIT_CARD");
        this.f843g = new aS(getIntent());
        C0510f.m461b((Activity) this);
        C0510f.m455a((Activity) this);
        this.f842f = new cJ(this, this.f844h == bk.PayPal);
        setContentView(this.f842f.m372a());
        C0838d.m1116a((Activity) this, this.f842f.m381b(), cB.CONFIRM);
        this.f842f.m382b(new aT(this));
        this.f842f.m376a(new aY(this));
        if (bk.PayPal == this.f844h) {
            this.f839c = (bA) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.PaymentConfirmActivity.EXTRA_PAYMENT_INFO");
            m684b();
        }
    }

    protected final Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return C0838d.m1111a((Activity) this, cB.PAY_FAILED_ALERT_TITLE, bundle);
            case 2:
                return C0838d.m1114a((Context) this, cB.PROCESSING, cB.ONE_MOMENT);
            case 3:
                return C0838d.m1112a((Activity) this, cB.INTERNAL_ERROR, bundle, i);
            case 4:
                return C0838d.m1113a((Activity) this, cB.SESSION_EXPIRED_TITLE, bundle, new bg(this));
            case 5:
                cz.m428a(cB.UNEXPECTED_PAYMENT_FLOW);
                cB cBVar;
                cB cBVar2;
                cB cBVar3;
                OnClickListener aUVar;
                if (bundle == null || !C0510f.m467d(bundle.getString("BUNDLE_ERROR_CODE"))) {
                    cB cBVar4 = cB.WE_ARE_SORRY;
                    cBVar = cB.UNEXPECTED_PAYMENT_FLOW;
                    cBVar2 = cB.TRY_AGAIN;
                    cBVar3 = cB.CANCEL;
                    aUVar = new aU(this);
                    return new Builder(this).setIcon(17301543).setTitle(cz.m428a(cBVar4)).setMessage(cz.m428a(cBVar)).setPositiveButton(cz.m428a(cBVar2), aUVar).setNegativeButton(cz.m428a(cBVar3), new aV(this)).create();
                }
                String string = bundle.getString("BUNDLE_ERROR_CODE");
                cBVar = cB.WE_ARE_SORRY;
                CharSequence a = cz.m429a(string);
                cBVar2 = cB.TRY_AGAIN;
                cBVar3 = cB.CANCEL;
                aUVar = new bh(this);
                return new Builder(this).setIcon(17301543).setTitle(cz.m428a(cBVar)).setMessage(a).setPositiveButton(cz.m428a(cBVar2), aUVar).setNegativeButton(cz.m428a(cBVar3), new bi(this)).create();
            default:
                return null;
        }
    }

    protected final void onDestroy() {
        new StringBuilder().append(f837a).append(".onDestroy");
        if (this.f846j != null) {
            this.f846j.m646m();
        }
        if (this.f848l) {
            unbindService(this.f847k);
            this.f848l = false;
        }
        super.onDestroy();
    }

    protected final void onRestart() {
        super.onRestart();
        m690d();
    }

    protected final void onResume() {
        super.onResume();
        new StringBuilder().append(f837a).append(".onResume");
        if (this.f846j != null) {
            m693f();
        }
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", this.f840d);
        bundle.putBoolean("isLoginActivityStarted", this.f841e);
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        new StringBuilder().append(f837a).append(".onWindowFocusChanged");
        this.f842f.m384c();
    }
}
