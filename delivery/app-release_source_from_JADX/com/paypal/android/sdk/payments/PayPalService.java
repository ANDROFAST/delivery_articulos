package com.paypal.android.sdk.payments;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import com.paypal.android.sdk.C0506b;
import com.paypal.android.sdk.C0507c;
import com.paypal.android.sdk.C0508d;
import com.paypal.android.sdk.aA;
import com.paypal.android.sdk.aB;
import com.paypal.android.sdk.av;
import com.paypal.android.sdk.aw;
import com.paypal.android.sdk.ax;
import com.paypal.android.sdk.bA;
import com.paypal.android.sdk.bD;
import com.paypal.android.sdk.bM;
import com.paypal.android.sdk.bN;
import com.paypal.android.sdk.bQ;
import com.paypal.android.sdk.bT;
import com.paypal.android.sdk.bV;
import com.paypal.android.sdk.be;
import com.paypal.android.sdk.bi;
import com.paypal.android.sdk.bk;
import com.paypal.android.sdk.bm;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.br;
import com.paypal.android.sdk.bt;
import com.paypal.android.sdk.bu;
import com.paypal.android.sdk.bv;
import com.paypal.android.sdk.bw;
import com.paypal.android.sdk.by;
import com.paypal.android.sdk.cX;
import com.paypal.android.sdk.cc;
import com.paypal.android.sdk.ce;
import com.paypal.android.sdk.cf;
import com.paypal.android.sdk.cg;
import com.paypal.android.sdk.ch;
import com.paypal.android.sdk.ci;
import com.paypal.android.sdk.cj;
import com.paypal.android.sdk.ck;
import com.paypal.android.sdk.cl;
import com.paypal.android.sdk.cn;
import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.cr;
import com.paypal.android.sdk.ct;
import com.paypal.android.sdk.cx;
import com.paypal.android.sdk.cy;
import com.paypal.android.sdk.cz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class PayPalService extends Service {
    public static final String EXTRA_PAYPAL_CONFIGURATION = "com.paypal.android.sdk.paypalConfiguration";
    static final ExecutorService f809a = Executors.newCachedThreadPool();
    private static final String f810c = PayPalService.class.getSimpleName();
    private static Intent f811t;
    bA f812b;
    private C0507c f813d;
    private bt f814e;
    private PayPalConfiguration f815f;
    private boolean f816g;
    private C0539a f817h = new C0539a();
    private C0539a f818i = new C0539a();
    private C0545k f819j = new C0838d(this);
    private String f820k;
    private ax f821l;
    private aH f822m;
    private String f823n;
    private C0506b f824o;
    private bv f825p;
    private List f826q = new ArrayList();
    private boolean f827r = true;
    private boolean f828s = true;
    private final BroadcastReceiver f829u = new aD(this);
    private final IBinder f830v = new aG(this);

    private boolean m590A() {
        return (this.f815f == null || this.f814e == null) ? false : true;
    }

    private static bt m591B() {
        return new bt();
    }

    private void m592C() {
        m628a(new aE(this), false);
    }

    private static aw m593a(String str, String str2) {
        aw awVar = new aw();
        awVar.m173a(str);
        awVar.m174a(new HashMap());
        if (str2 != null) {
            if (str2.startsWith("https://")) {
                if (!str2.endsWith("/")) {
                    new StringBuilder().append(str2).append(" does not end with a slash, adding one.");
                    str2 = str2 + "/";
                }
                for (bk bkVar : br.m952d()) {
                    awVar.m175b().put(bkVar.mo3739a(), str2 + bkVar.mo3741c());
                }
            } else {
                throw new RuntimeException(str2 + " does not start with 'https://', ignoring " + str);
            }
        }
        return awVar;
    }

    private void m596a(Intent intent) {
        f811t = intent;
        new StringBuilder("init:").append(m607b(intent));
        if (this.f815f == null) {
            this.f815f = (PayPalConfiguration) intent.getParcelableExtra(EXTRA_PAYPAL_CONFIGURATION);
            if (this.f815f == null) {
                throw new RuntimeException("Missing EXTRA_PAYPAL_CONFIGURATION. To avoid this error, set EXTRA_PAYPAL_CONFIGURATION in both PayPalService, and the initializing activity.");
            }
        }
        if (this.f815f.m552o()) {
            String str;
            String b = this.f815f.m539b();
            if (av.m169c(b)) {
                str = "https://api-m.paypal.com/v1/";
            } else if (av.m168b(b)) {
                str = "https://api-m.sandbox.paypal.com/v1/";
            } else if (av.m167a(b)) {
                str = null;
            } else if (m615z() && intent.hasExtra("com.paypal.android.sdk.baseEnvironmentUrl")) {
                str = intent.getStringExtra("com.paypal.android.sdk.baseEnvironmentUrl");
            } else {
                throw new RuntimeException("Invalid environment selected:" + b);
            }
            this.f825p = new bv(this.f824o, this.f815f.m539b());
            aw a = m593a(b, str);
            if (this.f821l == null) {
                int intExtra = (m615z() && intent.hasExtra("com.paypal.android.sdk.mockNetworkDelay")) ? intent.getIntExtra("com.paypal.android.sdk.mockNetworkDelay", 500) : 500;
                boolean booleanExtra = (m615z() && intent.hasExtra("com.paypal.android.sdk.mockEnable2fa")) ? intent.getBooleanExtra("com.paypal.android.sdk.mockEnable2fa", false) : false;
                int intExtra2 = (m615z() && intent.hasExtra("com.paypal.android.sdk.mock2faPhoneNumberCount")) ? intent.getIntExtra("com.paypal.android.sdk.mock2faPhoneNumberCount", 1) : 1;
                this.f827r = true;
                if (m615z() && intent.hasExtra("com.paypal.android.sdk.enableAuthenticator")) {
                    this.f827r = intent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticator", true);
                }
                if (m615z() && intent.hasExtra("com.paypal.android.sdk.enableAuthenticatorSecurity")) {
                    this.f828s = intent.getBooleanExtra("com.paypal.android.sdk.enableAuthenticatorSecurity", true);
                }
                boolean booleanExtra2 = (m615z() && intent.hasExtra("com.paypal.android.sdk.enableStageSsl")) ? intent.getBooleanExtra("com.paypal.android.sdk.enableStageSsl", true) : true;
                this.f821l = new ax(this.f824o, a, m616a());
                this.f821l.m921a(new bM(new aJ()));
                this.f821l.m922a(new bi(this.f815f.m539b(), this.f821l, new ct(this.f821l, intExtra, booleanExtra, intExtra2), new be(this.f824o, this.f815f.m539b(), m616a(), this.f821l, 90000, m616a().mo3787b(), aB.m81a(m616a()), booleanExtra2)));
            }
            cz.m430b(this.f815f.m538a());
            if (this.f814e == null) {
                this.f814e = m591B();
            }
            if (!this.f815f.m547j()) {
                clearAllUserData(this.f824o.m185f());
            }
            this.f820k = intent.getComponent().getPackageName();
            m622a(cy.PreConnect);
            m592C();
            return;
        }
        throw new RuntimeException("Service extras invalid.  Please check the docs.");
    }

    private void m597a(bm bmVar) {
        this.f821l.m925b(bmVar);
    }

    private void m598a(cy cyVar, boolean z, String str, String str2, String str3) {
        this.f819j.mo3785a(cyVar, z, str, str2, str3);
    }

    static /* synthetic */ void m599a(PayPalService payPalService, bm bmVar) {
        payPalService.f814e.f386c = null;
        new StringBuilder().append(bmVar.m281o()).append(" request error");
        String b = bmVar.m283q().m87b();
        Log.e("paypal.sdk", b);
        payPalService.m608b(cy.DeviceCheck, b, bmVar.m278k());
        if (payPalService.f822m != null) {
            payPalService.f822m.mo3764a(payPalService.m605b(bmVar));
            payPalService.f822m = null;
        }
        payPalService.f816g = false;
    }

    private static boolean m601a(bD bDVar) {
        return bDVar != null && bDVar.m190c();
    }

    private cn[] m603a(PayPalItem[] payPalItemArr) {
        if (payPalItemArr == null) {
            return null;
        }
        cn[] cnVarArr = new cn[payPalItemArr.length];
        int length = payPalItemArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            PayPalItem payPalItem = payPalItemArr[i];
            int i3 = i2 + 1;
            cnVarArr[i2] = new cn(payPalItem.getName(), payPalItem.getQuantity(), payPalItem.getPrice(), payPalItem.getCurrency(), payPalItem.getSku());
            i++;
            i2 = i3;
        }
        return cnVarArr;
    }

    private aI m605b(bm bmVar) {
        return new aI(this, bmVar.m283q().m87b(), bmVar.m285s(), bmVar.m283q().m86a());
    }

    private static String m607b(Intent intent) {
        if (intent == null) {
            return "Intent = null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Intent{");
        stringBuilder.append("action:" + intent.getAction());
        stringBuilder.append(", cmp:" + intent.getComponent() + ", ");
        if (intent.getExtras() == null) {
            stringBuilder.append("null extras");
        } else {
            stringBuilder.append("extras:");
            for (String str : intent.getExtras().keySet()) {
                stringBuilder.append("(" + str + ":" + intent.getExtras().get(str) + ")");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void m608b(cy cyVar, String str, String str2) {
        m598a(cyVar, false, str, str2, null);
    }

    static /* synthetic */ void m610c(PayPalService payPalService, bm bmVar) {
        String b = bmVar.m283q().m87b();
        Log.e("paypal.sdk", b);
        payPalService.m608b(cy.ConfirmPayment, b, bmVar.m278k());
        payPalService.f818i.m727a(payPalService.m605b(bmVar));
    }

    public static void clearAllUserData(Context context) {
        Log.w("paypal.sdk", "clearing user data");
        f809a.submit(new aB(context));
    }

    private static boolean m615z() {
        return "partner".equals(BuildConfig.FLAVOR);
    }

    final C0507c m616a() {
        if (this.f813d == null) {
            this.f813d = new C0840l();
        }
        return this.f813d;
    }

    final String m617a(String str) {
        return this.f824o.m182c(str);
    }

    final void m618a(int i) {
        this.f821l.m925b(new ck(this.f821l, m616a(), this.f821l.mo3729c(), this.f815f.m548k(), this.f814e.f393j, (String) new ArrayList(this.f814e.f390g.f279a.keySet()).get(i)));
    }

    final void m619a(bT bTVar, String str, boolean z, String str2, boolean z2, String str3) {
        this.f821l.m925b(new cl(this.f821l, m616a(), this.f821l.mo3729c(), this.f815f.m548k(), bTVar, str, this.f814e.f393j, z, str2, z2, str3));
    }

    final void m620a(bT bTVar, boolean z, String str, boolean z2, String str2) {
        this.f821l.m925b(new cl(this.f821l, m616a(), this.f821l.mo3729c(), this.f815f.m548k(), bTVar, z, str, z2, str2));
    }

    final void m621a(bV bVVar, Map map, PayPalItem[] payPalItemArr, String str, boolean z, String str2, String str3, boolean z2, String str4, String str5, String str6) {
        this.f821l.m925b(new cf(this.f821l, m616a(), this.f814e.f391h.m189b(), this.f814e.m332b(), null, bVVar, map, m603a(payPalItemArr), str, z, str2, this.f823n, str3, z2).m1263d(str4).m1265e(str5).m1267f(str6));
    }

    final void m622a(cy cyVar) {
        m598a(cyVar, false, null, null, null);
    }

    final void m623a(cy cyVar, Boolean bool) {
        m598a(cyVar, bool.booleanValue(), null, null, null);
    }

    final void m624a(cy cyVar, Boolean bool, String str) {
        m598a(cyVar, bool.booleanValue(), null, str, null);
    }

    final void m625a(cy cyVar, String str) {
        m598a(cyVar, false, null, str, null);
    }

    final void m626a(cy cyVar, String str, String str2) {
        m598a(cyVar, false, null, str, str2);
    }

    final void m627a(aF aFVar) {
        this.f817h.m726a(aFVar);
    }

    final void m628a(aH aHVar, boolean z) {
        if (z) {
            this.f814e.f386c = null;
        }
        this.f822m = aHVar;
        if (!this.f816g && !this.f814e.m333c()) {
            this.f816g = true;
            m622a(cy.DeviceCheck);
            this.f821l.m925b(new cq(this.f815f.m539b(), this.f821l, m616a(), this.f815f.m548k()));
        }
    }

    final void m629a(String str, String str2, bV bVVar, Map map, PayPalItem[] payPalItemArr, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f821l.m925b(new cg(this.f821l, m616a(), this.f814e.f386c.m189b(), str, str2, str4, bVVar, map, m603a(payPalItemArr), str3, z, str5, this.f823n, str6).m1303d(str7).m1304e(str8).m1306f(str9));
    }

    final void m630a(String str, String str2, String str3, String str4, int i, int i2, bV bVVar, Map map, PayPalItem[] payPalItemArr, String str5, boolean z, String str6, String str7, String str8, String str9, String str10) {
        String str11 = (str3.equalsIgnoreCase("4111111111111111") && av.m168b(this.f815f.m539b())) ? "4444333322221111" : str3;
        this.f821l.m925b(new cg(this.f821l, m616a(), this.f814e.f386c.m189b(), str, str2, str11, str4, i, i2, null, bVVar, map, m603a(payPalItemArr), str5, z, str6, this.f823n, str7).m1303d(str8).m1304e(str9).m1306f(str10));
    }

    final void m631a(List list) {
        this.f821l.m925b(new ce(this.f821l, m616a(), this.f821l.mo3729c(), this.f815f.m548k(), this.f814e.f389f.m188b(), this.f814e.f393j, list));
    }

    final void m632a(boolean z, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3) {
        this.f821l.m925b(new cc(this.f821l, m616a(), this.f814e.f391h.m189b(), this.f814e.m332b(), z, str3, this.f823n, str, str2, jSONObject, jSONObject2));
    }

    protected final boolean m633a(aK aKVar) {
        if (m590A()) {
            return true;
        }
        this.f826q.add(aKVar);
        return false;
    }

    protected final ax m634b() {
        return this.f821l;
    }

    final void m635b(aF aFVar) {
        this.f818i.m726a(aFVar);
    }

    protected final bt m636c() {
        return this.f814e;
    }

    final PayPalConfiguration m637d() {
        return this.f815f;
    }

    public final void doDeleteTokenizedCreditCard(String str, String str2) {
        m597a(new ch(this.f821l, m616a(), str, str2));
    }

    public final void doTrackingRequest(aA aAVar) {
        if (aAVar.f125e) {
            m597a(new cr(this.f821l, m616a(), aAVar));
        } else {
            m597a(new ci(this.f821l, m616a(), cx.m424a(aAVar)));
        }
    }

    protected final String m638e() {
        return this.f815f.m539b();
    }

    protected final String m639f() {
        return this.f815f.m548k();
    }

    final void m640g() {
        m653t();
        m641h();
        this.f825p.m341b();
        m654u();
    }

    final void m641h() {
        this.f814e.f391h = null;
        bu.m336b(this.f815f.m539b());
        this.f814e.f388e = null;
        this.f814e.f387d = null;
    }

    final boolean m642i() {
        return this.f814e.m333c();
    }

    final boolean m643j() {
        bt btVar = this.f814e;
        return btVar.f391h != null && btVar.f391h.m190c();
    }

    final boolean m644k() {
        return (this.f814e.f389f == null || this.f814e.f393j == null) ? false : true;
    }

    final void m645l() {
        bw a = this.f825p.m338a();
        if (a == null) {
            m641h();
            return;
        }
        bD bDVar = this.f814e.f391h;
        bD a2 = bu.m334a(this.f815f.m539b());
        if (!m601a(bDVar) && m601a(a2)) {
            this.f814e.f391h = a2;
        }
        bt btVar = this.f814e;
        String b = a.m349d() ? a.m348c().equals(by.EMAIL) ? a.m347b() : a.m343a().m246a(bq.m947a()) : null;
        btVar.f387d = b;
    }

    final void m646m() {
        this.f818i.m729b();
    }

    final void m647n() {
        this.f817h.m729b();
    }

    final void m648o() {
        this.f822m = null;
    }

    public final IBinder onBind(Intent intent) {
        new StringBuilder("onBind(").append(m607b(intent)).append(")");
        if (!m590A()) {
            if (f811t == null) {
                m596a(intent);
            } else {
                m596a(f811t);
            }
        }
        return this.f830v;
    }

    public final void onCreate() {
        Log.w("paypal.sdk", PayPalService.class.getSimpleName() + " created. " + m616a().mo3787b());
        C0840l c0840l = new C0840l();
        this.f824o = new C0506b(this, "AndroidBasePrefs");
        bN.m213a(this.f824o);
        bQ.m225a(this.f824o);
        this.f823n = C0508d.m433a(f809a, this, this.f824o, "2.9.8");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.paypal.android.sdk.clearAllUserData");
        C0519D.m493a((Context) this).m496a(this.f829u, intentFilter);
    }

    public final void onDestroy() {
        if (this.f821l != null) {
            this.f821l.m920a();
            this.f821l.m924b();
            this.f821l = null;
        }
        try {
            C0519D.m493a((Context) this).m495a(this.f829u);
        } catch (Throwable th) {
            new StringBuilder("ignoring:").append(th.getMessage());
        }
        new StringBuilder("service destroyed: ").append(this);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
        new StringBuilder("onRebind(").append(m607b(intent)).append(")");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        new StringBuilder("onStartCommand(").append(m607b(intent)).append(", ").append(i).append(", ").append(i2).append(")");
        if (!m590A()) {
            new cX(this).m412a();
            if (intent == null || intent.getExtras() == null) {
                throw new RuntimeException("Service extras required. Please see the docs.");
            }
            m596a(intent);
        }
        if (this.f826q.size() > 0) {
            for (aK a : this.f826q) {
                a.mo3760a();
            }
            this.f826q.clear();
        }
        return 3;
    }

    public final boolean onUnbind(Intent intent) {
        new StringBuilder("onUnbind(").append(m607b(intent)).append(")");
        return true;
    }

    final void m649p() {
        this.f821l.m925b(new cj(this.f821l, m616a(), this.f821l.mo3729c(), this.f814e.f386c.m189b(), this.f815f.m548k()));
    }

    final bw m650q() {
        return this.f825p.m338a();
    }

    final String m651r() {
        return this.f814e.f387d;
    }

    final bA m652s() {
        return this.f825p.m337a(this.f815f.m548k());
    }

    final void m653t() {
        this.f812b = m652s();
        this.f825p.m342c();
        if (this.f812b != null && this.f814e.f386c != null) {
            doDeleteTokenizedCreditCard(this.f814e.f386c.m189b(), this.f812b.m934e());
            this.f812b = null;
        }
    }

    final void m654u() {
        if (this.f815f != null && this.f815f.m552o()) {
            this.f814e = m591B();
            m592C();
        }
    }

    protected final String m655v() {
        return this.f820k;
    }

    final boolean m656w() {
        return this.f827r;
    }

    final boolean m657x() {
        return this.f828s;
    }
}
