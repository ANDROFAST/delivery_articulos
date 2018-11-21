package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.C0511g;
import com.paypal.android.sdk.av;
import com.paypal.android.sdk.bT;
import com.paypal.android.sdk.bX;
import com.paypal.android.sdk.bY;
import com.paypal.android.sdk.bZ;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.bw;
import com.paypal.android.sdk.cB;
import com.paypal.android.sdk.cI;
import com.paypal.android.sdk.cM;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class LoginActivity extends Activity {
    private final String f735a = LoginActivity.class.getSimpleName();
    private aj f736b;
    private String f737c;
    private String f738d;
    private String f739e;
    private String f740f;
    private String f741g;
    private String f742h;
    private bT f743i;
    private String f744j;
    private boolean f745k;
    private boolean f746l;
    private boolean f747m;
    private boolean f748n;
    private int f749o;
    private cI f750p;
    private boolean f751q;
    private PayPalService f752r;
    private final ServiceConnection f753s = new C0532S(this);

    private bT m500a(aj ajVar) {
        m525g();
        if (ajVar != aj.PIN) {
            return ajVar == aj.EMAIL ? new bT(this.f737c, this.f738d) : this.f743i;
        } else {
            bY a = bq.m947a();
            return new bT(this.f740f == null ? new bZ(a, this.f739e) : new bZ(a, new C0511g(this.f740f), this.f739e), this.f741g);
        }
    }

    static void m502a(Activity activity, int i, bw bwVar, boolean z, boolean z2, String str, PayPalConfiguration payPalConfiguration) {
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtras(activity.getIntent());
        intent.putExtra("com.paypal.android.sdk.payments.persistedLogin", bwVar);
        intent.putExtra("com.paypal.android.sdk.payments.useResponseTypeCode", z);
        intent.putExtra("com.paypal.android.sdk.payments.forceLogin", z2);
        intent.putExtra("com.paypal.android.sdk.payments.requestedScopes", str);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
        activity.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void m504a(LoginActivity loginActivity, View view) {
        bT a = loginActivity.m500a(loginActivity.f736b);
        if (loginActivity.f736b == aj.PIN) {
            loginActivity.f743i = new bT(a.m229d(), null);
            loginActivity.m512b(aj.PIN_LOGIN_IN_PROGRESS);
        } else {
            loginActivity.f743i = new bT(a.m227b(), null);
            loginActivity.m512b(aj.EMAIL_LOGIN_IN_PROGRESS);
        }
        loginActivity.f752r.m620a(a, loginActivity.f746l, loginActivity.m508b(), loginActivity.m515c(), loginActivity.f744j);
    }

    static /* synthetic */ void m505a(LoginActivity loginActivity, aI aIVar) {
        if (aIVar.m735b()) {
            loginActivity.m516d();
            return;
        }
        Object obj = (aIVar.m734a() && aIVar.f897b.equals("invalid_user")) ? 1 : null;
        if (obj != null) {
            loginActivity.m535o();
            C0838d.m1118a((Activity) loginActivity, cz.m428a(cB.TWO_FACTOR_AUTH_INVALID_ONE_TIME_PASSWORD), 3);
        } else if (aIVar.m736c()) {
            loginActivity.m535o();
            C0838d.m1118a((Activity) loginActivity, cz.m429a(aIVar.f897b), 3);
        } else if ("invalid_nonce".equals(aIVar.f897b)) {
            loginActivity.f742h = null;
            loginActivity.m535o();
            C0838d.m1118a((Activity) loginActivity, cz.m428a(cB.SESSION_EXPIRED_MESSAGE), 5);
        } else {
            loginActivity.f742h = null;
            loginActivity.m535o();
            C0838d.m1118a((Activity) loginActivity, cz.m429a(aIVar.f897b), 4);
        }
    }

    static /* synthetic */ void m507a(LoginActivity loginActivity, String str) {
        loginActivity.f738d = null;
        loginActivity.f741g = null;
        loginActivity.m535o();
        C0838d.m1118a((Activity) loginActivity, cz.m429a(str), 1);
    }

    private String m508b() {
        return m515c() ? "code" : "token";
    }

    static /* synthetic */ void m510b(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(C0523H.m498a())));
        loginActivity.f752r.m623a(cy.LoginForgotPassword, Boolean.valueOf(loginActivity.f746l));
    }

    static /* synthetic */ void m511b(LoginActivity loginActivity, String str) {
        loginActivity.m535o();
        if ("invalid_nonce".equals(str)) {
            C0838d.m1118a((Activity) loginActivity, cz.m428a(cB.SESSION_EXPIRED_MESSAGE), 5);
        } else {
            C0838d.m1118a((Activity) loginActivity, cz.m429a(str), 2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m512b(com.paypal.android.sdk.payments.aj r8) {
        /*
        r7 = this;
        r6 = 21;
        r5 = 20;
        r4 = 8;
        r2 = 1;
        r3 = 0;
        r0 = new java.lang.StringBuilder;
        r1 = "changeLoginState:";
        r0.<init>(r1);
        r0.append(r8);
        if (r8 == 0) goto L_0x003b;
    L_0x0014:
        r7.f736b = r8;
    L_0x0016:
        r0 = 20;
        r7.dismissDialog(r0);	 Catch:{ IllegalArgumentException -> 0x01e6 }
        r0 = 21;
        r7.dismissDialog(r0);	 Catch:{ IllegalArgumentException -> 0x01e6 }
    L_0x0020:
        r0 = com.paypal.android.sdk.payments.ab.f911a;
        r1 = r7.f736b;
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x0078;
            case 2: goto L_0x0097;
            case 3: goto L_0x00db;
            case 4: goto L_0x0111;
            case 5: goto L_0x018c;
            case 6: goto L_0x0048;
            case 7: goto L_0x0060;
            case 8: goto L_0x007b;
            case 9: goto L_0x009a;
            case 10: goto L_0x00a8;
            case 11: goto L_0x0114;
            case 12: goto L_0x0147;
            case 13: goto L_0x018f;
            default: goto L_0x002d;
        };
    L_0x002d:
        r0 = com.paypal.android.sdk.payments.ab.f911a;
        r1 = r7.f736b;
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x01c2;
            case 2: goto L_0x01c2;
            case 3: goto L_0x01ce;
            case 4: goto L_0x01ce;
            case 5: goto L_0x01da;
            default: goto L_0x003a;
        };
    L_0x003a:
        return;
    L_0x003b:
        r0 = new java.lang.StringBuilder;
        r1 = "null loginState, refreshing:";
        r0.<init>(r1);
        r1 = r7.f736b;
        r0.append(r1);
        goto L_0x0016;
    L_0x0048:
        r7.m530j();
        r7.m533m();
        r0 = r7.f750p;
        r0 = r0.f484b;
        r0.setEnabled(r2);
        r0 = r7.f750p;
        r0 = r0.f486d;
        r0.setEnabled(r2);
        r7.m527h();
        goto L_0x002d;
    L_0x0060:
        r7.m530j();
        r7.m534n();
        r0 = r7.f750p;
        r0 = r0.f484b;
        r0.setEnabled(r2);
        r0 = r7.f750p;
        r0 = r0.f486d;
        r0.setEnabled(r2);
        r7.m527h();
        goto L_0x002d;
    L_0x0078:
        r7.showDialog(r5);
    L_0x007b:
        r7.m530j();
        r7.m533m();
        r0 = r7.f750p;
        r0 = r0.f484b;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f486d;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f490h;
        r0.setEnabled(r3);
        goto L_0x002d;
    L_0x0097:
        r7.showDialog(r5);
    L_0x009a:
        r7.m530j();
        r7.m534n();
        r0 = r7.f750p;
        r0 = r0.f490h;
        r0.setEnabled(r3);
        goto L_0x002d;
    L_0x00a8:
        r7.m532l();
        r7.m531k();
        r0 = r7.f750p;
        r0 = r0.f497o;
        r0 = r0.f536c;
        r1 = com.paypal.android.sdk.cB.TWO_FACTOR_AUTH_SEND_SMS;
        r1 = com.paypal.android.sdk.cz.m428a(r1);
        r0.setText(r1);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setVisibility(r4);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setVisibility(r4);
        goto L_0x002d;
    L_0x00db:
        r7.showDialog(r6);
        r7.m532l();
        r7.m531k();
        r0 = r7.f750p;
        r0 = r0.f497o;
        r0 = r0.f536c;
        r1 = com.paypal.android.sdk.cB.TWO_FACTOR_AUTH_SEND_SMS_AGAIN;
        r1 = com.paypal.android.sdk.cz.m428a(r1);
        r0.setText(r1);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setVisibility(r4);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setVisibility(r4);
        goto L_0x002d;
    L_0x0111:
        r7.showDialog(r6);
    L_0x0114:
        r7.m532l();
        r7.m531k();
        r0 = r7.f750p;
        r0 = r0.f497o;
        r0 = r0.f536c;
        r1 = com.paypal.android.sdk.cB.TWO_FACTOR_AUTH_SEND_SMS_AGAIN;
        r1 = com.paypal.android.sdk.cz.m428a(r1);
        r0.setText(r1);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setVisibility(r3);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setVisibility(r3);
        goto L_0x002d;
    L_0x0147:
        r7.m532l();
        r7.m531k();
        r0 = r7.f750p;
        r0 = r0.f497o;
        r0 = r0.f536c;
        r1 = com.paypal.android.sdk.cB.TWO_FACTOR_AUTH_SEND_SMS_AGAIN;
        r1 = com.paypal.android.sdk.cz.m428a(r1);
        r0.setText(r1);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setEnabled(r2);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setVisibility(r3);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.requestFocus();
        r1 = new android.os.Handler;
        r1.<init>();
        r2 = new com.paypal.android.sdk.payments.P;
        r2.<init>(r7, r0);
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r1.postDelayed(r2, r4);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setVisibility(r3);
        r7.m529i();
        goto L_0x002d;
    L_0x018c:
        r7.showDialog(r5);
    L_0x018f:
        r7.m532l();
        r7.m531k();
        r0 = r7.f750p;
        r0 = r0.f497o;
        r0 = r0.f536c;
        r1 = com.paypal.android.sdk.cB.TWO_FACTOR_AUTH_SEND_SMS_AGAIN;
        r1 = com.paypal.android.sdk.cz.m428a(r1);
        r0.setText(r1);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f494l;
        r0.setVisibility(r3);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setEnabled(r3);
        r0 = r7.f750p;
        r0 = r0.f495m;
        r0.setVisibility(r3);
        goto L_0x002d;
    L_0x01c2:
        r0 = r7.f752r;
        r1 = new com.paypal.android.sdk.payments.ai;
        r1.<init>(r7);
        r0.m627a(r1);
        goto L_0x003a;
    L_0x01ce:
        r0 = r7.f752r;
        r1 = new com.paypal.android.sdk.payments.N;
        r1.<init>(r7);
        r0.m627a(r1);
        goto L_0x003a;
    L_0x01da:
        r0 = r7.f752r;
        r1 = new com.paypal.android.sdk.payments.O;
        r1.<init>(r7);
        r0.m627a(r1);
        goto L_0x003a;
    L_0x01e6:
        r0 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.payments.LoginActivity.b(com.paypal.android.sdk.payments.aj):void");
    }

    static /* synthetic */ void m514c(LoginActivity loginActivity, View view) {
        loginActivity.m525g();
        if (loginActivity.f736b == aj.PIN) {
            loginActivity.m512b(aj.EMAIL);
        } else {
            loginActivity.m512b(aj.PIN);
        }
        loginActivity.m523f();
        loginActivity.f750p.m371a(loginActivity.f736b == aj.EMAIL);
    }

    private boolean m515c() {
        return getIntent().getBooleanExtra("com.paypal.android.sdk.payments.useResponseTypeCode", false);
    }

    private void m516d() {
        if (this.f752r.m636c().f390g.f279a.isEmpty()) {
            m535o();
            C0838d.m1118a((Activity) this, cz.m428a(cB.TWO_FACTOR_AUTH_NO_ACTIVE_TOKENS_ERROR), 10);
            return;
        }
        m512b(aj.TWO_FA_SEND_FIRST_SMS);
    }

    static /* synthetic */ void m518d(LoginActivity loginActivity, View view) {
        loginActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(bD.m764a())));
        loginActivity.f752r.m623a(cy.SignUp, Boolean.valueOf(loginActivity.f746l));
    }

    private void m520e() {
        setResult(-1);
        finish();
    }

    static /* synthetic */ void m521e(LoginActivity loginActivity, View view) {
        if (loginActivity.f736b == aj.TWO_FA_ENTER_OTP) {
            loginActivity.m512b(aj.TWO_FA_SEND_ANOTHER_SMS_IN_PROGRESS);
        } else {
            loginActivity.m512b(aj.TWO_FA_SEND_FIRST_SMS_IN_PROGRESS);
        }
        loginActivity.f750p.f494l.setText("");
        loginActivity.f752r.m618a(loginActivity.f749o);
    }

    private void m523f() {
        C0838d.m1119a(this.f750p.f485c.f472b, this.f752r.m638e());
        m512b(null);
    }

    static /* synthetic */ void m524f(LoginActivity loginActivity, View view) {
        loginActivity.m512b(aj.TWO_FA_LOGIN_OTP_IN_PROGRESS);
        loginActivity.f752r.m619a(loginActivity.m500a(loginActivity.f736b), loginActivity.f750p.f494l.getText().toString(), loginActivity.f746l, loginActivity.m508b(), loginActivity.m515c(), loginActivity.f744j);
    }

    private void m525g() {
        if (this.f736b == aj.PIN) {
            this.f739e = this.f750p.f484b.getText().toString();
            this.f741g = this.f750p.f486d.getText().toString();
            return;
        }
        this.f737c = this.f750p.f484b.getText().toString();
        this.f738d = this.f750p.f486d.getText().toString();
    }

    static /* synthetic */ void m526g(LoginActivity loginActivity) {
        switch (ab.f911a[loginActivity.f736b.ordinal()]) {
            case 8:
                loginActivity.m512b(aj.EMAIL);
                return;
            case 9:
                loginActivity.m512b(aj.PIN);
                return;
            case 11:
                loginActivity.m512b(aj.TWO_FA_ENTER_OTP);
                return;
            case 13:
                loginActivity.m512b(aj.TWO_FA_ENTER_OTP);
                return;
            default:
                new StringBuilder().append(loginActivity.f736b).append(" case not handled");
                return;
        }
    }

    private void m527h() {
        boolean z = true;
        String obj = this.f750p.f484b.getText().toString();
        String obj2 = this.f750p.f486d.getText().toString();
        if (this.f736b == aj.PIN) {
            if (!(bX.m236d(obj) && bX.m234b(obj2))) {
                z = false;
            }
        } else if (!(bX.m233a(obj) && bX.m235c(obj2))) {
            z = false;
        }
        this.f750p.f490h.setEnabled(z);
        this.f750p.f490h.setFocusable(z);
    }

    static /* synthetic */ void m528h(LoginActivity loginActivity) {
        if (loginActivity.f743i.m226a()) {
            loginActivity.m512b(aj.EMAIL);
        } else {
            loginActivity.m512b(aj.PIN);
        }
    }

    private void m529i() {
        this.f750p.f495m.setEnabled(6 == this.f750p.f494l.getText().toString().length());
    }

    private void m530j() {
        this.f750p.f497o.f534a.setVisibility(8);
        this.f750p.f493k.setEnabled(false);
        this.f750p.f493k.setVisibility(8);
        this.f750p.f497o.f536c.setVisibility(8);
        this.f750p.f495m.setEnabled(false);
        this.f750p.f495m.setVisibility(8);
        this.f750p.f494l.setEnabled(false);
        this.f750p.f494l.setVisibility(8);
    }

    private void m531k() {
        C0838d.m1116a((Activity) this, null, cB.TWO_FACTOR_AUTH_TITLE);
        this.f750p.f493k.setEnabled(true);
        this.f750p.f493k.setVisibility(0);
        new StringBuilder("phone numbers: ").append(this.f752r.m636c().f390g.f279a);
        List arrayList = new ArrayList(this.f752r.m636c().f390g.f279a.values());
        this.f750p.f497o.m395a((String) arrayList.get(this.f749o));
        this.f750p.f497o.f534a.setVisibility(0);
        if (arrayList.size() > 1) {
            this.f750p.f497o.m396a(true);
            Object cMVar = new cM(this, arrayList, this.f749o);
            new ListView(this).setAdapter(cMVar);
            this.f750p.f497o.f535b.setOnClickListener(new C0530Q(this, cMVar, arrayList));
        } else {
            this.f750p.f497o.m396a(false);
        }
        this.f750p.f497o.f536c.setVisibility(0);
    }

    private void m532l() {
        this.f750p.f490h.setEnabled(false);
        this.f750p.f490h.setVisibility(8);
        this.f750p.f484b.setEnabled(false);
        this.f750p.f484b.setVisibility(8);
        this.f750p.f486d.setEnabled(false);
        this.f750p.f486d.setVisibility(8);
        this.f750p.f487e.setEnabled(false);
        this.f750p.f487e.setVisibility(8);
    }

    private void m533m() {
        C0838d.m1116a((Activity) this, null, cB.LOG_IN_TO_PAYPAL);
        this.f750p.f484b.setVisibility(0);
        this.f750p.f484b.setText(this.f737c);
        this.f750p.f484b.setHint(cz.m428a(cB.EMAIL));
        this.f750p.f484b.setInputType(33);
        this.f750p.f486d.setVisibility(0);
        this.f750p.f486d.setText(this.f738d);
        this.f750p.f486d.setHint(cz.m428a(cB.PASSWORD));
        this.f750p.f486d.setInputType(129);
        if (this.f750p.f484b.getText().length() > 0 && this.f750p.f486d.getText().length() == 0) {
            this.f750p.f486d.requestFocus();
        }
        this.f750p.f490h.setVisibility(0);
        this.f750p.f487e.setVisibility(0);
        this.f750p.f488f.setVisibility(0);
        this.f750p.f489g.setVisibility(0);
        this.f750p.f492j.setText(cz.m428a(cB.LOGIN_WITH_PHONE));
    }

    private void m534n() {
        C0838d.m1116a((Activity) this, null, cB.LOG_IN_TO_PAYPAL);
        this.f750p.f484b.setVisibility(0);
        this.f750p.f484b.setText(this.f739e);
        this.f750p.f484b.setHint(cz.m428a(cB.PHONE));
        this.f750p.f484b.setInputType(3);
        this.f750p.f486d.setVisibility(0);
        this.f750p.f486d.setText(this.f741g);
        this.f750p.f486d.setHint(cz.m428a(cB.PIN));
        EditText editText = this.f750p.f486d;
        editText.setInputType(VERSION.SDK_INT < 11 ? 2 : 18);
        if (VERSION.SDK_INT < 11) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (this.f750p.f484b.getText().length() > 0 && this.f750p.f486d.getText().length() == 0) {
            this.f750p.f486d.requestFocus();
        }
        this.f750p.f490h.setVisibility(0);
        this.f750p.f487e.setVisibility(0);
        this.f750p.f488f.setVisibility(0);
        this.f750p.f489g.setVisibility(4);
        this.f750p.f492j.setText(cz.m428a(cB.LOGIN_WITH_EMAIL));
    }

    private void m535o() {
        switch (ab.f911a[this.f736b.ordinal()]) {
            case 1:
                m512b(aj.EMAIL_LOGIN_FAILED);
                return;
            case 2:
                m512b(aj.PIN_LOGIN_FAILED);
                return;
            case 3:
            case 4:
                m512b(aj.TWO_FA_SEND_SMS_FAILED);
                return;
            case 5:
                m512b(aj.TWO_FA_LOGIN_OTP_FAILED);
                return;
            default:
                new StringBuilder().append(this.f736b).append(" case not handled");
                return;
        }
    }

    final void m536a() {
        PayPalConfiguration d = this.f752r.m637d();
        if (cz.f622a) {
            this.f750p.f486d.setGravity(5);
            this.f750p.f484b.setGravity(5);
            this.f750p.f494l.setGravity(5);
        }
        if (!(bX.m238f(Locale.getDefault().getCountry().toLowerCase(Locale.US)) && this.f752r.m636c().f392i)) {
            this.f750p.f492j.setVisibility(4);
        }
        if (this.f747m) {
            this.f747m = false;
            this.f737c = d.m540c();
            String d2 = d.m541d();
            if (d2 != null) {
                this.f739e = d2;
            }
            d2 = d.m542e();
            if (d2 != null) {
                this.f740f = d2;
            }
            if (d.m543f() && !av.m169c(d.m539b())) {
                this.f738d = d.m544g();
                this.f741g = d.m545h();
            }
        }
        if (getIntent().getBooleanExtra("com.paypal.android.sdk.payments.forceLogin", false) && !this.f748n) {
            this.f748n = true;
            this.f752r.m641h();
        }
        if (this.f752r.m643j()) {
            m520e();
            return;
        }
        if (!this.f745k) {
            this.f745k = true;
            this.f752r.m623a(cy.LoginWindow, Boolean.valueOf(this.f746l));
        }
        if (this.f736b == null) {
            bw bwVar = (bw) getIntent().getParcelableExtra("com.paypal.android.sdk.payments.persistedLogin");
            if (bwVar != null) {
                this.f746l = true;
                if (C0510f.m459a(this.f737c) && C0510f.m462b(bwVar.m347b())) {
                    this.f737c = bwVar.m347b();
                }
                if (this.f739e == null && bwVar.m343a() != null) {
                    this.f739e = bwVar.m343a().m246a(bq.m947a());
                }
                switch (ab.f912b[bwVar.m348c().ordinal()]) {
                    case 1:
                        m512b(aj.EMAIL);
                        break;
                    case 2:
                        m512b(aj.PIN);
                        break;
                }
            }
            m512b(aj.EMAIL);
        }
        m523f();
    }

    public final void onBackPressed() {
        this.f752r.m623a(cy.LoginCancel, Boolean.valueOf(this.f746l));
        super.onBackPressed();
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new StringBuilder().append(getClass().getSimpleName()).append(".onCreate");
        this.f744j = getIntent().getExtras().getString("com.paypal.android.sdk.payments.requestedScopes");
        this.f751q = bindService(C0838d.m1121b(this), this.f753s, 1);
        C0510f.m461b((Activity) this);
        C0510f.m455a((Activity) this);
        this.f750p = new cI(this);
        setContentView(this.f750p.f483a);
        this.f750p.f488f.setText(cz.m428a(cB.SIGN_UP));
        this.f750p.f489g.setText(cz.m428a(cB.FORGOT_PASSWORD));
        this.f750p.f491i.setText(cz.m428a(cB.LOG_IN));
        this.f750p.f491i.setHint(cz.m428a(cB.LOG_IN));
        this.f750p.f493k.setText(cz.m428a(cB.TWO_FACTOR_AUTH_SUBTITLE));
        this.f750p.f494l.setHint(cz.m428a(cB.TWO_FACTOR_AUTH_ENTER_SECURITY_CODE));
        this.f750p.f496n.setText(cz.m428a(cB.LOG_IN));
        this.f750p.f497o.m397b(cz.m428a(cB.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER));
        TextWatcher c0528m = new C0528M(this);
        this.f750p.f484b.addTextChangedListener(c0528m);
        this.f750p.f486d.addTextChangedListener(c0528m);
        this.f750p.f490h.setOnClickListener(new C0538Z(this));
        this.f750p.f489g.setOnClickListener(new ac(this));
        this.f750p.f492j.setOnClickListener(new ad(this));
        this.f750p.f488f.setOnClickListener(new ae(this));
        this.f750p.f497o.f536c.setOnClickListener(new af(this));
        this.f750p.f494l.addTextChangedListener(new ag(this));
        this.f750p.f495m.setOnClickListener(new ah(this));
        if (bundle == null) {
            this.f745k = false;
            this.f747m = true;
        } else {
            this.f747m = false;
            this.f745k = bundle.getBoolean("PP_PageTrackingSent");
            this.f736b = (aj) bundle.getParcelable("PP_LoginType");
            this.f737c = bundle.getString("PP_SavedEmail");
            this.f739e = bundle.getString("PP_SavedPhone");
            this.f740f = bundle.getString("PP_savedPhoneCountryCode");
            this.f738d = bundle.getString("PP_SavedPassword");
            this.f741g = bundle.getString("PP_SavedPIN");
            this.f746l = bundle.getBoolean("PP_IsReturningUser");
            this.f748n = bundle.getBoolean("PP_IsClearedLogin");
            this.f744j = bundle.getString("PP_RequestedScopes");
            this.f742h = bundle.getString("PP_SavedOTP");
            this.f743i = (bT) bundle.getParcelable("PP_OriginalLoginData");
            this.f749o = bundle.getInt("PP_TwoFaSelectedPhoneNumberIndex");
        }
        this.f750p.f494l.setText(this.f742h);
    }

    protected final Dialog onCreateDialog(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return C0838d.m1113a((Activity) this, cB.LOGIN_FAILED_ALERT_TITLE, bundle, new C0533U(this));
            case 2:
                return C0838d.m1113a((Activity) this, cB.WE_ARE_SORRY, bundle, new C0534V(this));
            case 3:
                return C0838d.m1113a((Activity) this, cB.LOGIN_FAILED_ALERT_TITLE, bundle, new C0535W(this));
            case 4:
                return C0838d.m1113a((Activity) this, cB.LOGIN_FAILED_ALERT_TITLE, bundle, new C0536X(this));
            case 5:
                return C0838d.m1113a((Activity) this, cB.SESSION_EXPIRED_TITLE, bundle, new C0537Y(this));
            case 10:
                return C0838d.m1113a((Activity) this, cB.LOGIN_FAILED_ALERT_TITLE, bundle, new aa(this));
            case 20:
                return C0838d.m1114a((Context) this, cB.AUTHENTICATING, cB.ONE_MOMENT);
            case 21:
                return C0838d.m1114a((Context) this, cB.TWO_FACTOR_AUTH_SENDING_DIALOG, cB.ONE_MOMENT);
            default:
                return null;
        }
    }

    protected final void onDestroy() {
        new StringBuilder().append(getClass().getSimpleName()).append(".onDestroy");
        if (this.f752r != null) {
            this.f752r.m647n();
        }
        if (this.f751q) {
            unbindService(this.f753s);
            this.f751q = false;
        }
        super.onDestroy();
    }

    protected final void onResume() {
        super.onResume();
        new StringBuilder().append(getClass().getSimpleName()).append(".onResume");
        if (this.f752r != null) {
            m523f();
        }
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m525g();
        bundle.putParcelable("PP_LoginType", this.f736b);
        bundle.putString("PP_SavedEmail", this.f737c);
        bundle.putString("PP_SavedPhone", this.f739e);
        bundle.putString("PP_savedPhoneCountryCode", this.f740f);
        bundle.putString("PP_SavedPassword", this.f738d);
        bundle.putString("PP_SavedPIN", this.f741g);
        bundle.putBoolean("PP_IsReturningUser", this.f746l);
        bundle.putBoolean("PP_PageTrackingSent", this.f745k);
        bundle.putBoolean("PP_IsClearedLogin", this.f748n);
        bundle.putString("PP_RequestedScopes", this.f744j);
        bundle.putString("PP_SavedOTP", this.f742h);
        bundle.putParcelable("PP_OriginalLoginData", this.f743i);
        bundle.putInt("PP_TwoFaSelectedPhoneNumberIndex", this.f749o);
    }
}
