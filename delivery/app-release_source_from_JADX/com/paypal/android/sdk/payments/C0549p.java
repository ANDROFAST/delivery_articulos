package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.URLSpan;
import android.util.Log;
import com.paypal.android.sdk.C0494N;
import com.paypal.android.sdk.C0497R;
import com.paypal.android.sdk.C0498S;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.C1173Q;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cC;
import com.paypal.android.sdk.cj;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

abstract class C0549p extends Activity {
    private static final String f993d = C0549p.class.getSimpleName();
    private static final Map f994l = new C0550r();
    protected PayPalService f995a;
    protected PayPalOAuthScopes f996b;
    protected cC f997c;
    private boolean f998e;
    private C0546m f999f;
    private boolean f1000g;
    private boolean f1001h;
    private boolean f1002i;
    private bx f1003j;
    private final ServiceConnection f1004k = new C0552x(this);

    C0549p() {
    }

    private void m774a(int i, PayPalAuthorization payPalAuthorization) {
        Intent intent = new Intent();
        intent.putExtra("com.paypal.android.sdk.authorization", payPalAuthorization);
        setResult(i, intent);
    }

    private void m775a(int i, String str, String str2, C0525J c0525j) {
        SpannableString spannableString = new SpannableString(Html.fromHtml(str2 + str));
        if (c0525j != null) {
            URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
            if (uRLSpanArr.length > 0) {
                URLSpan uRLSpan = uRLSpanArr[0];
                spannableString.setSpan(new C0540b(uRLSpan, this, FuturePaymentInfoActivity.class, new C0841q(this), c0525j), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
                spannableString.removeSpan(uRLSpan);
            }
        } else {
            m776a(spannableString);
        }
        spannableString.setSpan(new BulletSpan(15), 0, spannableString.length(), 0);
        this.f997c.f461c[i].setVisibility(0);
        this.f997c.f461c[i].setFocusable(true);
        this.f997c.f461c[i].setNextFocusLeftId((i + 100) - 1);
        this.f997c.f461c[i].setNextFocusRightId((i + 100) + 1);
        this.f997c.f461c[i].setText(spannableString);
    }

    private void m776a(SpannableString spannableString) {
        int i = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
        int length = uRLSpanArr.length;
        while (i < length) {
            URLSpan uRLSpan = uRLSpanArr[i];
            spannableString.setSpan(new bE(uRLSpan, new C0842s(this)), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            spannableString.removeSpan(uRLSpan);
            i++;
        }
    }

    private void m777a(C0546m c0546m) {
        this.f995a.m636c().f393j = c0546m.f988a;
        this.f995a.m636c().f389f = c0546m.f989b;
        this.f995a.m636c().f387d = c0546m.f990c;
        m795j();
    }

    static /* synthetic */ void m779a(C0549p c0549p, cj cjVar) {
        c0549p.f1003j = new bx(cjVar);
        c0549p.getIntent().putExtra("com.paypal.android.sdk.payments.ppAppInfo", c0549p.f1003j);
        c0549p.m790f();
        c0549p.m796k();
    }

    private void m782b(SpannableString spannableString) {
        int i = 0;
        URLSpan[] uRLSpanArr = (URLSpan[]) spannableString.getSpans(0, spannableString.length(), URLSpan.class);
        int length = uRLSpanArr.length;
        while (i < length) {
            URLSpan uRLSpan = uRLSpanArr[i];
            spannableString.setSpan(new bE(uRLSpan, new C0843t(this)), spannableString.getSpanStart(uRLSpan), spannableString.getSpanEnd(uRLSpan), 33);
            spannableString.removeSpan(uRLSpan);
            i++;
        }
    }

    private void m784c() {
        if (this.f995a != null) {
            showDialog(2);
            if (this.f995a.m642i()) {
                this.f995a.m649p();
                return;
            }
            new StringBuilder("token is expired, get new one. AccessToken: ").append(this.f995a.m636c().f386c);
            this.f995a.m628a(new C0844u(this), true);
        }
    }

    private void m786d() {
        this.f998e = bindService(C0838d.m1121b(this), this.f1004k, 1);
    }

    static /* synthetic */ void m787d(C0549p c0549p) {
        boolean z;
        new StringBuilder().append(f993d).append(".postBindSetup()");
        new StringBuilder().append(f993d).append(".startLoginIfNeeded (access token: ").append(c0549p.f995a.m636c().f391h).append(")");
        if (c0549p.f995a.m643j() || c0549p.f1001h) {
            z = false;
        } else {
            new StringBuilder().append(f993d).append(" -- doing the login...");
            c0549p.f1001h = true;
            c0549p.m788e();
            z = true;
        }
        cC cCVar = c0549p.f997c;
        if (c0549p.f1002i) {
            c0549p.f1002i = false;
            c0549p.m795j();
        }
        if (!c0549p.f1000g) {
            c0549p.f1000g = true;
            c0549p.f995a.m622a(cy.ConsentWindow);
        }
        C0838d.m1119a(cCVar.f464f.f472b, c0549p.f995a.m638e());
        c0549p.f995a.m635b(new C0845v(c0549p));
        c0549p.m790f();
        if (!z && c0549p.f1003j == null) {
            c0549p.m784c();
        }
    }

    private void m788e() {
        new StringBuilder().append(f993d).append(".doLogin");
        if (C0547n.m772a(this, this.f995a)) {
            Intent b = new C1173Q().m1185b(this.f995a.m637d().m548k(), C0497R.PROMPT_LOGIN, C0498S.code, this.f995a.m634b().mo3730d().m184e());
            new StringBuilder("startActivityForResult(").append(b).append(", 2").append(")");
            Log.w("paypal.sdk", "requesting code with scope=null from Authenticator.");
            startActivityForResult(b, 2);
            return;
        }
        LoginActivity.m502a(this, 1, null, true, false, this.f996b.m565b(), this.f995a.m637d());
    }

    static /* synthetic */ void m789e(C0549p c0549p) {
        c0549p.f995a.m622a(cy.ConsentCancel);
        c0549p.finish();
    }

    private void m790f() {
        if (this.f996b != null && this.f1003j != null && this.f995a != null) {
            int i;
            String l = this.f995a.m637d().m549l();
            if (this.f1003j.m769d() != null) {
                l = this.f1003j.m769d();
            }
            String uri = this.f995a.m637d().m550m().toString();
            if (this.f1003j.m767b() != null) {
                uri = this.f1003j.m767b();
            }
            String uri2 = this.f995a.m637d().m551n().toString();
            if (this.f1003j.m768c() != null) {
                uri2 = this.f1003j.m768c();
            }
            String format = String.format(cz.m428a(cB.CONSENT_AGREEMENT_INTRO), new Object[]{"<b>" + l + "</b>"});
            String str = cz.f622a ? "‏" : "";
            this.f997c.f461c[0].setText(Html.fromHtml(str + format));
            if (cz.f622a) {
                this.f997c.f461c[0].setGravity(5);
            }
            this.f997c.f461c[0].setVisibility(0);
            Collection a = this.f996b.m564a();
            if (a.contains(C0494N.FUTURE_PAYMENTS.m16a()) || a.contains(C0494N.PAYMENT_CODE.m16a()) || a.contains(C0494N.MIS_CUSTOMER.m16a())) {
                m775a(1, String.format(cz.m428a(cB.CONSENT_AGREEMENT_FUTURE_PAYMENTS), new Object[]{"future-payment-consent", "<b>" + l + "</b>", "<b>" + l + "</b>"}), str, C0525J.FUTURE_PAYMENTS);
                i = 2;
            } else {
                i = 1;
            }
            if (a.contains(C0494N.GET_FUNDING_OPTIONS.m16a())) {
                m775a(i, cz.m428a(cB.CONSENT_AGREEMENT_FUNDING_OPTIONS), str, null);
                i++;
            }
            if (a.contains(C0494N.FINANCIAL_INSTRUMENTS.m16a())) {
                m775a(i, cz.m428a(cB.CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS), str, C0525J.FINANCIAL_INSTRUMENTS);
                i++;
            }
            if (a.contains(C0494N.SEND_MONEY.m16a())) {
                m775a(i, String.format(cz.m428a(cB.CONSENT_AGREEMENT_SEND_MONEY), new Object[]{"", l}), str, C0525J.SEND_MONEY);
                i++;
            }
            if (a.contains(C0494N.REQUEST_MONEY.m16a())) {
                m775a(i, String.format(cz.m428a(cB.CONSENT_AGREEMENT_REQUEST_MONEY), new Object[]{"", l}), str, C0525J.REQUEST_MONEY);
                i++;
            }
            if (a.contains(C0494N.LOYALTY.m16a())) {
                m775a(i, cz.m428a(cB.CONSENT_AGREEMENT_LOYALTY_CARD), str, null);
                i++;
            }
            if (a.contains(C0494N.EXPRESS_CHECKOUT.m16a())) {
                m775a(i, cz.m428a(cB.CONSENT_AGREEMENT_EXPRESS_CHECKOUT), str, null);
                i++;
            }
            if (!Collections.disjoint(a, C0494N.f17p)) {
                if (m792g().size() > 0) {
                    m775a(i, String.format(cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTES), new Object[]{m793h()}), str, null);
                    i++;
                }
            }
            m775a(i, String.format(cz.m428a(cB.CONSENT_AGREEMENT_MERCHANT_PRIVACY_POLICY), new Object[]{"<b>" + l + "</b>", uri, uri2}), str, null);
            this.f997c.f461c[i].setNextFocusRightId(2);
            int i2 = i + 1;
            uri2 = cz.m428a(cB.PRIVACY);
            Object[] objArr = new Object[1];
            CharSequence toLowerCase = Locale.getDefault().getCountry().toLowerCase(Locale.US);
            if (C0510f.m464c(toLowerCase)) {
                toLowerCase = "us";
            }
            objArr[0] = String.format("https://www.paypal.com/%s/cgi-bin/webscr?cmd=p/gen/ua/policy_privacy-outside", new Object[]{toLowerCase});
            SpannableString spannableString = new SpannableString(Html.fromHtml(str + String.format(uri2, objArr)));
            m782b(spannableString);
            this.f997c.f462d.setText(spannableString);
            this.f997c.f462d.setMovementMethod(LinkMovementMethod.getInstance());
            this.f997c.f462d.setNextFocusLeftId((i2 + 100) - 1);
            this.f997c.f462d.setNextFocusRightId(1);
            toLowerCase = C0510f.m465d(this.f995a.m637d().m538a());
            if (toLowerCase != null) {
                this.f997c.f463e.setText(toLowerCase);
                this.f997c.f463e.setVisibility(0);
            }
            this.f997c.f467i.setText(cz.m428a(cB.CONSENT_AGREEMENT_AGREE));
            this.f997c.f465g.setOnClickListener(new C0553z(this));
            this.f997c.f466h.setOnClickListener(new C0516A(this));
            this.f997c.f466h.setEnabled(true);
            if (this.f999f != null) {
                m777a(this.f999f);
                this.f999f = null;
            }
        }
    }

    static /* synthetic */ void m791f(C0549p c0549p) {
        c0549p.f995a.m622a(cy.ConsentAgree);
        if (c0549p.f995a.m644k()) {
            c0549p.showDialog(2);
            c0549p.f995a.m631a(c0549p.f996b.m564a());
            return;
        }
        new StringBuilder("code/nonce invalid.  code:").append(c0549p.f995a.m636c().f389f).append(", nonce:").append(c0549p.f995a.m636c().f393j);
        C0838d.m1118a((Activity) c0549p, cz.m428a(cB.SESSION_EXPIRED_MESSAGE), 4);
    }

    private Set m792g() {
        Collection a = this.f996b.m564a();
        Set linkedHashSet = new LinkedHashSet();
        for (C0517B c0517b : C0517B.values()) {
            if (this.f1003j.m766a().contains(c0517b.name()) && a.contains(((C0494N) f994l.get(c0517b)).m16a())) {
                Object a2 = c0517b == C0517B.openid_connect ? null : c0517b == C0517B.oauth_account_creation_date ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_CREATION_DATE) : c0517b == C0517B.oauth_account_verified ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_STATUS) : c0517b == C0517B.oauth_account_type ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_TYPE) : (c0517b == C0517B.oauth_street_address1 || c0517b == C0517B.oauth_street_address2 || c0517b == C0517B.oauth_city || c0517b == C0517B.oauth_state || c0517b == C0517B.oauth_country || c0517b == C0517B.oauth_zip) ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_ADDRESS) : c0517b == C0517B.oauth_age_range ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_AGE_RANGE) : c0517b == C0517B.oauth_date_of_birth ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_DATE_OF_BIRTH) : c0517b == C0517B.oauth_email ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_EMAIL_ADDRESS) : c0517b == C0517B.oauth_fullname ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_FULL_NAME) : c0517b == C0517B.oauth_gender ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_GENDER) : c0517b == C0517B.oauth_language ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_LANGUAGE) : c0517b == C0517B.oauth_locale ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_LOCALE) : c0517b == C0517B.oauth_phone_number ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_PHONE) : c0517b == C0517B.oauth_timezone ? cz.m428a(cB.CONSENT_AGREEMENT_ATTRIBUTE_TIME_ZONE) : c0517b.name();
                if (a2 != null) {
                    linkedHashSet.add(a2);
                }
            }
        }
        return linkedHashSet;
    }

    private String m793h() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : m792g()) {
            if (obj == null) {
                stringBuilder.append(", ");
            } else {
                obj = null;
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private void m794i() {
        m774a(-1, new PayPalAuthorization(this.f995a.m638e(), this.f995a.m636c().f389f.m188b(), this.f995a.m636c().f387d));
        finish();
    }

    private void m795j() {
        String a = this.f995a.m636c().f389f.m187a();
        if (a == null || !Arrays.asList(a.split(" ")).containsAll(this.f996b.m564a())) {
            m784c();
        } else {
            m794i();
        }
    }

    private void m796k() {
        try {
            dismissDialog(2);
        } catch (IllegalArgumentException e) {
        }
    }

    protected abstract void mo3755a();

    public void finish() {
        super.finish();
        new StringBuilder().append(f993d).append(".finish");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        new StringBuilder().append(f993d).append(".onActivityResult(").append(i).append(",").append(i2).append(",").append(intent).append(")");
        switch (i) {
            case 1:
                if (i2 != -1) {
                    m774a(i2, null);
                    finish();
                    return;
                } else if (this.f995a == null) {
                    this.f1002i = true;
                    return;
                } else {
                    m795j();
                    return;
                }
            case 2:
                if (i2 == -1) {
                    C0546m a = C0548o.m773a(intent.getExtras());
                    if (this.f995a == null) {
                        this.f999f = a;
                        return;
                    } else {
                        m777a(a);
                        return;
                    }
                }
                m774a(i2, null);
                finish();
                return;
            default:
                Log.e(f993d, "unhandled requestCode " + i);
                return;
        }
    }

    public void onBackPressed() {
        this.f995a.m622a(cy.ConsentCancel);
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(f993d).append(".onCreate");
        if (bundle == null) {
            if (!C0838d.m1120a((Activity) this)) {
                finish();
            }
            this.f1000g = false;
        } else {
            this.f1000g = bundle.getBoolean("pageTrackingSent");
            this.f1001h = bundle.getBoolean("isLoginActivityStarted");
        }
        mo3755a();
        this.f1003j = (bx) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.ppAppInfo");
        m786d();
        C0510f.m461b((Activity) this);
        C0510f.m455a((Activity) this);
        this.f997c = new cC(this);
        setContentView(this.f997c.f459a);
        C0838d.m1116a((Activity) this, this.f997c.f460b, null);
        this.f997c.f465g.setText(cz.m428a(cB.CANCEL));
        this.f997c.f465g.setVisibility(0);
        m790f();
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return C0838d.m1111a((Activity) this, cB.CONSENT_FAILED_ALERT_TITLE, bundle);
            case 2:
                return C0838d.m1114a((Context) this, cB.PROCESSING, cB.ONE_MOMENT);
            case 3:
                return C0838d.m1112a((Activity) this, cB.INTERNAL_ERROR, bundle, i);
            case 4:
                return C0838d.m1113a((Activity) this, cB.SESSION_EXPIRED_TITLE, bundle, new C0551w(this));
            default:
                return null;
        }
    }

    protected void onDestroy() {
        new StringBuilder().append(f993d).append(".onDestroy");
        if (this.f995a != null) {
            this.f995a.m646m();
        }
        if (this.f998e) {
            unbindService(this.f1004k);
            this.f998e = false;
        }
        super.onDestroy();
    }

    protected void onRestart() {
        super.onRestart();
        m786d();
    }

    protected void onResume() {
        super.onResume();
        new StringBuilder().append(f993d).append(".onResume");
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("pageTrackingSent", this.f1000g);
        bundle.putBoolean("isLoginActivityStarted", this.f1001h);
    }
}
