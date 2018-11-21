package com.paypal.android.sdk.payments;

import android.util.Log;
import com.paypal.android.sdk.bA;
import com.paypal.android.sdk.bD;
import com.paypal.android.sdk.bF;
import com.paypal.android.sdk.bK;
import com.paypal.android.sdk.bL;
import com.paypal.android.sdk.bT;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.bu;
import com.paypal.android.sdk.bw;
import com.paypal.android.sdk.by;
import com.paypal.android.sdk.cc;
import com.paypal.android.sdk.ce;
import com.paypal.android.sdk.cf;
import com.paypal.android.sdk.cg;
import com.paypal.android.sdk.ch;
import com.paypal.android.sdk.cj;
import com.paypal.android.sdk.ck;
import com.paypal.android.sdk.cl;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cs;
import com.paypal.android.sdk.cy;
import java.util.UUID;

final class aJ implements bL {
    private /* synthetic */ PayPalService f1289a;

    private aJ(PayPalService payPalService) {
        this.f1289a = payPalService;
    }

    private static bD m1069a(String str, String str2, long j) {
        return new bD(str, str2, System.currentTimeMillis() + (1000 * j), true);
    }

    public final void mo3765a() {
        PayPalService.f810c;
    }

    public final void mo3766a(cc ccVar) {
        PayPalService.f810c;
        this.f1289a.m626a(cy.PaymentSuccessful, ccVar.m278k(), ccVar.m1255u());
        if (ccVar.m1256v() && (this.f1289a.m636c().f391h == null || this.f1289a.m636c().f391h.m938a())) {
            bu.m335a(this.f1289a.m636c().f391h, this.f1289a.m638e());
            if (this.f1289a.m636c().f388e != null) {
                this.f1289a.f825p.m340a(this.f1289a.m636c().f388e);
            }
        } else {
            this.f1289a.m641h();
        }
        this.f1289a.f818i.m728a(C0838d.m1115a((bm) ccVar));
        this.f1289a.f818i.m725a();
    }

    public final void mo3767a(ce ceVar) {
        PayPalService.f810c;
        this.f1289a.m625a(cy.AuthorizationSuccessful, ceVar.m278k());
        this.f1289a.f818i.m728a(ceVar.f1369a);
        this.f1289a.f818i.m725a();
    }

    public final void mo3768a(cf cfVar) {
        PayPalService.f810c;
        this.f1289a.f818i.m728a((Object) cfVar);
        this.f1289a.f818i.m725a();
    }

    public final void mo3769a(cg cgVar) {
        PayPalService.f810c;
        this.f1289a.m626a(cy.PaymentSuccessful, cgVar.m278k(), cgVar.m1282E());
        this.f1289a.f818i.m728a(C0838d.m1115a((bm) cgVar));
        Object obj = (cgVar.m1307u() == null || !cgVar.m1279B()) ? 1 : null;
        if (obj != null) {
            if (!cgVar.m1279B()) {
                this.f1289a.m653t();
            }
            this.f1289a.f818i.m725a();
            return;
        }
        this.f1289a.m634b().m925b(new cs(this.f1289a.m634b(), this.f1289a.m616a(), this.f1289a.m636c().f386c.m189b(), UUID.randomUUID().toString(), cgVar.m1308v(), cgVar.m1307u(), cgVar.m1309w(), cgVar.m1310x(), cgVar.m1311y()));
    }

    public final void mo3770a(ch chVar) {
        String b = chVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("DeleteCreditCardRequest Error:").append(b);
        Log.e("paypal.sdk", b);
    }

    public final void mo3771a(cj cjVar) {
        PayPalService.f810c;
        this.f1289a.f818i.m728a((Object) cjVar);
        this.f1289a.f818i.m725a();
    }

    public final void mo3772a(ck ckVar) {
        PayPalService.f810c;
        this.f1289a.m636c().f393j = ckVar.g;
        this.f1289a.f817h.m725a();
    }

    public final void mo3773a(cl clVar) {
        long j = 840;
        PayPalService.f810c;
        long j2 = clVar.f1379f;
        if (j2 <= 840) {
            j = j2;
        }
        if (clVar.f1376c == null) {
            this.f1289a.m636c().f391h = m1069a(clVar.f1377d, clVar.f1378e, j);
        } else {
            this.f1289a.m636c().f393j = clVar.g;
            this.f1289a.m636c().f389f = new bF(clVar.f1376c, clVar.f1378e);
        }
        this.f1289a.m636c().f390g = null;
        bw bwVar = new bw();
        if (clVar.f1374a.m226a()) {
            bwVar.m346a(clVar.f1374a.m227b());
            bwVar.m345a(by.EMAIL);
        } else {
            bwVar.m344a(clVar.f1374a.m229d());
            bwVar.m345a(by.PHONE);
        }
        this.f1289a.m636c().f388e = bwVar;
        if (clVar.f1374a.m226a()) {
            this.f1289a.m636c().f387d = clVar.f1374a.m227b();
            this.f1289a.m624a(cy.LoginPassword, Boolean.valueOf(clVar.f1375b), clVar.m278k());
        } else {
            this.f1289a.m636c().f387d = clVar.f1374a.m229d().m246a(bq.m947a());
            this.f1289a.m624a(cy.LoginPIN, Boolean.valueOf(clVar.f1375b), clVar.m278k());
        }
        this.f1289a.f817h.m725a();
    }

    public final void mo3774a(cq cqVar) {
        PayPalService.f810c;
        this.f1289a.m625a(cy.DeviceCheck, cqVar.m278k());
        this.f1289a.m636c().f386c = m1069a(cqVar.f1385a, cqVar.f1386b, cqVar.f1387c);
        this.f1289a.m636c().f392i = cqVar.f1388d;
        this.f1289a.f816g = false;
        if (this.f1289a.f822m != null) {
            PayPalService.f810c;
            this.f1289a.f822m.mo3763a();
            this.f1289a.f822m = null;
        }
    }

    public final void mo3775a(cs csVar) {
        PayPalService.f810c;
        this.f1289a.f825p.m339a(new bA(this.f1289a.f824o, csVar.m1295u(), csVar.f1427a, csVar.m1297w(), csVar.m1296v(), csVar.m1298x(), csVar.m1299y(), csVar.m1300z()), this.f1289a.f815f.m548k());
        this.f1289a.f818i.m725a();
    }

    public final void mo3776b(cc ccVar) {
        String b = ccVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("ApproveAndExecuteSfoPaymentRequest Error: ").append(b);
        PayPalService.m610c(this.f1289a, ccVar);
    }

    public final void mo3777b(ce ceVar) {
        String b = ceVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("ConsentRequest Error:").append(b);
        Log.e("paypal.sdk", b);
        this.f1289a.f818i.m727a(this.f1289a.m605b((bm) ceVar));
    }

    public final void mo3778b(cf cfVar) {
        String b = cfVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("CreateSfoPaymentRequest Error: ").append(b);
        Log.e("paypal.sdk", b);
        this.f1289a.f818i.m727a(this.f1289a.m605b((bm) cfVar));
    }

    public final void mo3779b(cg cgVar) {
        String b = cgVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("CreditCardPaymentRequest Error:").append(b);
        PayPalService.m610c(this.f1289a, cgVar);
    }

    public final void mo3780b(cj cjVar) {
        String b = cjVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("GetAppInfoRequest Error: ").append(b);
        Log.e("paypal.sdk", b);
        this.f1289a.f818i.m727a(this.f1289a.m605b((bm) cjVar));
    }

    public final void mo3781b(ck ckVar) {
        String b = ckVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("LoginChallengeRequest Error:").append(b);
        Log.e("paypal.sdk", b);
        this.f1289a.f817h.m727a(this.f1289a.m605b((bm) ckVar));
    }

    public final void mo3782b(cl clVar) {
        String b = clVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("LoginRequest Error: ").append(b);
        Log.e("paypal.sdk", b);
        this.f1289a.m641h();
        bT bTVar = clVar.f1374a;
        boolean z = clVar.f1375b;
        if (bTVar.m226a()) {
            this.f1289a.m598a(cy.LoginPassword, z, b, clVar.m278k(), null);
        } else {
            this.f1289a.m598a(cy.LoginPIN, z, b, clVar.m278k(), null);
        }
        this.f1289a.f825p.m341b();
        if (clVar.h) {
            this.f1289a.m636c().f393j = clVar.g;
            this.f1289a.m636c().f390g = new bK(clVar.i);
        }
        this.f1289a.f817h.m727a(this.f1289a.m605b((bm) clVar));
    }

    public final void mo3783b(cq cqVar) {
        PayPalService.m599a(this.f1289a, (bm) cqVar);
    }

    public final void mo3784b(cs csVar) {
        String b = csVar.m283q().m87b();
        PayPalService.f810c;
        new StringBuilder("TokenizeCreditCardRequest Error:").append(b);
        Log.e("paypal.sdk", b);
        this.f1289a.f818i.m725a();
    }
}
