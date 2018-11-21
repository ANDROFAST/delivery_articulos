package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.UUID;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class C0503Y implements LocationListener {
    private static final String f88a = C0503Y.class.getSimpleName();
    private static C0501W f89x = new C0501W();
    private static final Object f90y = new Object();
    private static C0503Y f91z;
    private Context f92b;
    private String f93c;
    private long f94d;
    private long f95e;
    private int f96f;
    private int f97g;
    private long f98h;
    private String f99i;
    private C0499U f100j;
    private C0502X f101k;
    private C0502X f102l;
    private String f103m;
    private Map f104n;
    private Map f105o;
    private Location f106p;
    private Timer f107q;
    private Handler f108r;
    private C0505a f109s;
    private String f110t;
    private String f111u;
    private boolean f112v;
    private String f113w;

    private C0503Y() {
    }

    private static long m51a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
            }
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
            return str != null ? new File(str).lastModified() : 0;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    public static C0503Y m52a() {
        C0503Y c0503y;
        synchronized (f90y) {
            if (f91z == null) {
                f91z = new C0503Y();
            }
            c0503y = f91z;
        }
        return c0503y;
    }

    private static String m53a(TelephonyManager telephonyManager) {
        try {
            return telephonyManager.getSimOperatorName();
        } catch (Throwable e) {
            at.m155a(f88a, "Known SecurityException on some devices", e);
            return null;
        }
    }

    private void m54a(C0499U c0499u) {
        this.f100j = c0499u;
        at.m154a(f88a, "Configuration loaded");
        at.m154a(f88a, "URL:     " + this.f100j.m28a());
        at.m154a(f88a, "Version: " + this.f100j.m29b());
        m71k();
        this.f107q = new Timer();
        long c = this.f100j.m30c();
        long d = this.f100j.m31d();
        long e = this.f100j.m32e();
        at.m154a(f88a, "Sending logRiskMetadata every " + c + " seconds.");
        at.m154a(f88a, "sessionTimeout set to " + d + " seconds.");
        at.m154a(f88a, "compTimeout set to    " + e + " seconds.");
        this.f94d = c * 1000;
        this.f95e = e * 1000;
        ac.m120a(d * 1000);
        if (this.f100j != null && this.f112v) {
            m71k();
            this.f107q = new Timer();
            at.m154a(f88a, "Starting LogRiskMetadataTask");
            this.f107q.scheduleAtFixedRate(new C0504Z(this), 0, this.f94d);
        }
    }

    private void m55a(C0502X c0502x, C0502X c0502x2) {
        boolean z = true;
        if (c0502x != null) {
            c0502x.ac = new HashMap(this.f104n);
            this.f105o = new HashMap(this.f104n);
            JSONObject a = c0502x2 != null ? c0502x.m49a(c0502x2) : c0502x.m48a();
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("appGuid", this.f93c));
            arrayList.add(new BasicNameValuePair("libraryVersion", C0503Y.m60d()));
            arrayList.add(new BasicNameValuePair("additionalData", a.toString()));
            at.m154a(f88a, "Dyson Risk Data " + a.toString());
            if (this.f100j != null) {
                String g = this.f100j.m34g();
                boolean h = this.f100j.m35h();
                at.m154a(f88a, "new LogRiskMetadataRequest to: " + g);
                at.m154a(f88a, "endpointIsStage: " + h + " (using SSL: " + (!h) + ")");
                Handler handler = this.f108r;
                if (h) {
                    z = false;
                }
                ak.m129a().m131a(new ai(g, arrayList, handler, z, null));
            }
        }
    }

    private static long m57b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (VERSION.SDK_INT > 8) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
            }
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir;
            return str != null ? new File(str).lastModified() : 0;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    static /* synthetic */ boolean m58c(C0503Y c0503y) {
        return System.currentTimeMillis() - c0503y.f98h > c0503y.f95e;
    }

    public static String m60d() {
        return String.format(Locale.US, "Dyson/%S (%S %S)", new Object[]{"3.3.1.release", "Android", VERSION.RELEASE});
    }

    static /* synthetic */ void m62f(C0503Y c0503y) {
        if (c0503y.f102l != null) {
            at.m154a(f88a, c0503y.f103m + " update not sent correctly, retrying...");
            if ("full".equals(c0503y.f103m)) {
                c0503y.m55a(c0503y.f102l, null);
                return;
            }
            c0503y.m55a(c0503y.f102l, c0503y.m72l());
        } else if (!ac.m122c() || c0503y.f101k == null) {
            ac.m119a();
            c0503y.f103m = "full";
            r0 = c0503y.m72l();
            c0503y.m55a(r0, null);
            c0503y.f102l = r0;
        } else {
            c0503y.f103m = "incremental";
            r0 = c0503y.m72l();
            c0503y.m55a(c0503y.f101k, r0);
            c0503y.f102l = r0;
        }
    }

    private static String m67i() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private String m68j() {
        StringBuilder stringBuilder = new StringBuilder("https://b.stats.paypal.com/counter.cgi?p=");
        if (this.f109s == null || this.f109s == C0505a.UNKNOWN) {
            return "Beacon not recognize host app";
        }
        int a = this.f109s.m80a();
        if (this.f111u == null) {
            return "Beacon pairing id empty";
        }
        stringBuilder.append(this.f111u).append("&i=");
        String b = at.m159b();
        if (b.equals("")) {
            try {
                stringBuilder.append(C0501W.m45a("emptyIp")).append("&t=");
            } catch (Throwable e) {
                at.m155a(f88a, "error reading property file", e);
            }
        } else {
            stringBuilder.append(b).append("&t=");
        }
        stringBuilder.append(String.valueOf(System.currentTimeMillis() / 1000)).append("&a=").append(a);
        at.m154a(f88a, "Beacon Request URL " + stringBuilder.toString());
        ak.m129a().m131a(new ae(stringBuilder.toString(), this.f93c, this.f110t, at.m146a(this.f92b), this.f108r));
        return stringBuilder.toString();
    }

    private void m71k() {
        if (this.f107q != null) {
            this.f107q.cancel();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.paypal.android.sdk.C0502X m72l() {
        /*
        r12 = this;
        r0 = r12.f92b;
        if (r0 != 0) goto L_0x0006;
    L_0x0004:
        r0 = 0;
    L_0x0005:
        return r0;
    L_0x0006:
        r3 = new com.paypal.android.sdk.X;
        r3.<init>();
        r0 = r12.f100j;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r8 = r0.m36i();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = "phone";
        r0 = r0.getSystemService(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = "wifi";
        r1 = r1.getSystemService(r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = (android.net.wifi.WifiManager) r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r4 = "connectivity";
        r2 = r2.getSystemService(r4);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r5 = 0;
        r4 = 0;
        r6 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r7 = "android.permission.ACCESS_WIFI_STATE";
        r6 = com.paypal.android.sdk.at.m157a(r6, r7);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r6 == 0) goto L_0x041f;
    L_0x003b:
        r1 = r1.getConnectionInfo();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r7 = r1;
    L_0x0040:
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r6 = "android.permission.ACCESS_NETWORK_STATE";
        r1 = com.paypal.android.sdk.at.m157a(r1, r6);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0423;
    L_0x004a:
        r1 = r2.getActiveNetworkInfo();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r6 = r1;
    L_0x004f:
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = "android.permission.ACCESS_COARSE_LOCATION";
        r1 = com.paypal.android.sdk.at.m157a(r1, r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 != 0) goto L_0x0063;
    L_0x0059:
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = "android.permission.ACCESS_FINE_LOCATION";
        r1 = com.paypal.android.sdk.at.m157a(r1, r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0427;
    L_0x0063:
        r1 = 1;
    L_0x0064:
        r2 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r9 = "android.permission.READ_PHONE_STATE";
        r9 = com.paypal.android.sdk.at.m157a(r2, r9);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r0.getPhoneType();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        switch(r2) {
            case 0: goto L_0x042a;
            case 1: goto L_0x0432;
            case 2: goto L_0x044a;
            default: goto L_0x0073;
        };	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0073:
        r1 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = "unknown (";
        r1.<init>(r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r0.getPhoneType();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = ")";
        r1 = r1.append(r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.toString();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f36A = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r4;
        r4 = r5;
    L_0x0090:
        r1 = com.paypal.android.sdk.as.PPRiskDataPhoneType;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 != 0) goto L_0x009b;
    L_0x0098:
        r1 = 0;
        r3.f36A = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x009b:
        r1 = com.paypal.android.sdk.as.PPRiskDataAppGuid;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x00a7;
    L_0x00a3:
        r1 = r12.f93c;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f62a = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x00a7:
        r1 = com.paypal.android.sdk.as.PPRiskDataPairingId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x00b3;
    L_0x00af:
        r1 = r12.f111u;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f54S = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x00b3:
        r1 = com.paypal.android.sdk.as.PPRiskDataSourceApp;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x00c7;
    L_0x00bb:
        r1 = r12.f109s;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 != 0) goto L_0x0462;
    L_0x00bf:
        r1 = com.paypal.android.sdk.C0505a.UNKNOWN;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.m80a();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f50O = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x00c7:
        r1 = com.paypal.android.sdk.as.PPRiskDataSourceAppVersion;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x00d3;
    L_0x00cf:
        r1 = r12.f110t;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f51P = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x00d3:
        r1 = com.paypal.android.sdk.as.PPRiskDataNotifToken;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x00df;
    L_0x00db:
        r1 = r12.f113w;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f59X = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x00df:
        r1 = com.paypal.android.sdk.as.PPRiskDataAndroidId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x00f5;
    L_0x00e7:
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.getContentResolver();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r5 = "android_id";
        r1 = android.provider.Settings.Secure.getString(r1, r5);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f57V = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x00f5:
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = com.paypal.android.sdk.at.m146a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r5 = com.paypal.android.sdk.as.PPRiskDataAppId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r5 = r8.m143a(r5);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r5 == 0) goto L_0x0109;
    L_0x0103:
        r5 = r1.m470a();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f63b = r5;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0109:
        r5 = com.paypal.android.sdk.as.PPRiskDataAppVersion;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r5 = r8.m143a(r5);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r5 == 0) goto L_0x0117;
    L_0x0111:
        r1 = r1.m471b();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f64c = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0117:
        r1 = com.paypal.android.sdk.as.PPRiskDataBaseStationId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0124;
    L_0x011f:
        if (r2 != 0) goto L_0x046e;
    L_0x0121:
        r1 = -1;
    L_0x0122:
        r3.f65d = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0124:
        r1 = com.paypal.android.sdk.as.PPRiskDataCdmaNetworkId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0131;
    L_0x012c:
        if (r2 != 0) goto L_0x0474;
    L_0x012e:
        r1 = -1;
    L_0x012f:
        r3.f48M = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0131:
        r1 = com.paypal.android.sdk.as.PPRiskDataCdmaSystemId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x013e;
    L_0x0139:
        if (r2 != 0) goto L_0x047a;
    L_0x013b:
        r1 = -1;
    L_0x013c:
        r3.f47L = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x013e:
        r1 = com.paypal.android.sdk.as.PPRiskDataBssid;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x014b;
    L_0x0146:
        if (r7 != 0) goto L_0x0480;
    L_0x0148:
        r1 = 0;
    L_0x0149:
        r3.f66e = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x014b:
        r1 = com.paypal.android.sdk.as.PPRiskDataCellId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0158;
    L_0x0153:
        if (r4 != 0) goto L_0x0486;
    L_0x0155:
        r1 = -1;
    L_0x0156:
        r3.f67f = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0158:
        r1 = com.paypal.android.sdk.as.PPRiskDataNetworkOperator;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0166;
    L_0x0160:
        r1 = r0.getNetworkOperator();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f49N = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0166:
        r1 = "3.3.1.release";
        r3.f68g = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r12.f99i;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f69h = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r12.f100j;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 != 0) goto L_0x048c;
    L_0x0172:
        r1 = 0;
    L_0x0173:
        r3.f70i = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = com.paypal.android.sdk.as.PPRiskDataConnType;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0182;
    L_0x017d:
        if (r6 != 0) goto L_0x0494;
    L_0x017f:
        r1 = 0;
    L_0x0180:
        r3.f71j = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0182:
        r1 = com.paypal.android.sdk.as.PPRiskDataDeviceId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0192;
    L_0x018a:
        if (r9 == 0) goto L_0x049a;
    L_0x018c:
        r1 = r0.getDeviceId();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0190:
        r3.f72k = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0192:
        r1 = com.paypal.android.sdk.as.PPRiskDataDeviceModel;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x019e;
    L_0x019a:
        r1 = android.os.Build.MODEL;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f73l = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x019e:
        r1 = com.paypal.android.sdk.as.PPRiskDataDeviceName;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x01aa;
    L_0x01a6:
        r1 = android.os.Build.DEVICE;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f74m = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01aa:
        r1 = com.paypal.android.sdk.as.PPRiskDataDeviceUptime;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x01b8;
    L_0x01b2:
        r10 = android.os.SystemClock.uptimeMillis();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f75n = r10;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01b8:
        r1 = com.paypal.android.sdk.as.PPRiskDataIpAddrs;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x01c6;
    L_0x01c0:
        r1 = com.paypal.android.sdk.at.m159b();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f76o = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01c6:
        r1 = com.paypal.android.sdk.as.PPRiskDataIpAddrs;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x01d5;
    L_0x01ce:
        r1 = 1;
        r1 = com.paypal.android.sdk.at.m151a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f77p = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01d5:
        r1 = com.paypal.android.sdk.as.PPRiskDataLine1Number;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x01e5;
    L_0x01dd:
        if (r9 == 0) goto L_0x049d;
    L_0x01df:
        r1 = r0.getLine1Number();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01e3:
        r3.f79r = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01e5:
        r1 = com.paypal.android.sdk.as.PPRiskDataLinkerId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x01f3;
    L_0x01ed:
        r1 = com.paypal.android.sdk.at.m148a();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f80s = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x01f3:
        r1 = com.paypal.android.sdk.as.PPRiskDataLocaleCountry;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0205;
    L_0x01fb:
        r1 = java.util.Locale.getDefault();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.getCountry();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f81t = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0205:
        r1 = com.paypal.android.sdk.as.PPRiskDataLocaleLang;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0217;
    L_0x020d:
        r1 = java.util.Locale.getDefault();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.getLanguage();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f82u = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0217:
        r1 = com.paypal.android.sdk.as.PPRiskDataLocation;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0226;
    L_0x021f:
        r1 = r12.f106p;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 != 0) goto L_0x04a0;
    L_0x0223:
        r1 = 0;
    L_0x0224:
        r3.f83v = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0226:
        r1 = com.paypal.android.sdk.as.PPRiskDataLocationAreaCode;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0233;
    L_0x022e:
        if (r4 != 0) goto L_0x04b3;
    L_0x0230:
        r1 = -1;
    L_0x0231:
        r3.f84w = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0233:
        r1 = com.paypal.android.sdk.as.PPRiskDataMacAddrs;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0240;
    L_0x023b:
        if (r7 != 0) goto L_0x04b9;
    L_0x023d:
        r1 = 0;
    L_0x023e:
        r3.f85x = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0240:
        r1 = com.paypal.android.sdk.as.PPRiskDataOsType;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x024c;
    L_0x0248:
        r1 = android.os.Build.VERSION.RELEASE;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f87z = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x024c:
        r1 = com.paypal.android.sdk.as.PPRiskDataRiskCompSessionId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x025a;
    L_0x0254:
        r1 = com.paypal.android.sdk.ac.m121b();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f37B = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x025a:
        r1 = com.paypal.android.sdk.as.PPRiskDataRoaming;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0271;
    L_0x0262:
        r1 = new android.telephony.ServiceState;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1.<init>();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.getRoaming();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f38C = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0271:
        r1 = com.paypal.android.sdk.as.PPRiskDataSimOperatorName;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x027f;
    L_0x0279:
        r1 = com.paypal.android.sdk.C0503Y.m53a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f39D = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x027f:
        r1 = com.paypal.android.sdk.as.PPRiskDataSerialNumber;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x028f;
    L_0x0287:
        if (r9 == 0) goto L_0x04bf;
    L_0x0289:
        r1 = r0.getSimSerialNumber();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x028d:
        r3.f40E = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x028f:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = 9;
        if (r1 < r2) goto L_0x0299;
    L_0x0295:
        r1 = android.os.Build.SERIAL;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f60Y = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0299:
        r1 = com.paypal.android.sdk.as.PPRiskDataSmsEnabled;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x02b3;
    L_0x02a1:
        r1 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.getPackageManager();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = "android.hardware.telephony";
        r1 = r1.hasSystemFeature(r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f41F = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02b3:
        r1 = com.paypal.android.sdk.as.PPRiskDataSsid;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x02c0;
    L_0x02bb:
        if (r7 != 0) goto L_0x04c2;
    L_0x02bd:
        r1 = 0;
    L_0x02be:
        r3.f42G = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02c0:
        r1 = com.paypal.android.sdk.as.PPRiskDataSubscriberId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r8.m143a(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x02d0;
    L_0x02c8:
        if (r9 == 0) goto L_0x04c8;
    L_0x02ca:
        r0 = r0.getSubscriberId();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02ce:
        r3.f43H = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02d0:
        r0 = com.paypal.android.sdk.as.PPRiskDataTimestamp;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x02de;
    L_0x02d8:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f44I = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02de:
        r0 = com.paypal.android.sdk.as.PPRiskDataTotalStorageSpace;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x02ec;
    L_0x02e6:
        r0 = com.paypal.android.sdk.at.m163c();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f45J = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02ec:
        r0 = com.paypal.android.sdk.as.PPRiskDataTzName;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x02fe;
    L_0x02f4:
        r0 = java.util.TimeZone.getDefault();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r0.getDisplayName();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f46K = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x02fe:
        r0 = com.paypal.android.sdk.as.PPRiskDataIsEmulator;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x0349;
    L_0x0306:
        r0 = android.os.Build.BRAND;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = "generic";
        r0 = r0.equalsIgnoreCase(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x0342;
    L_0x0310:
        r0 = android.os.Build.PRODUCT;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = "sdk";
        r0 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x0342;
    L_0x031a:
        r0 = android.os.Build.HARDWARE;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = "goldfish";
        r0 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x0342;
    L_0x0324:
        r0 = android.os.Build.FINGERPRINT;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = "generic";
        r0 = r0.startsWith(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x0342;
    L_0x032e:
        r0 = android.os.Build.MANUFACTURER;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = "unknown";
        r0 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x0342;
    L_0x0338:
        r0 = android.os.Build.PRODUCT;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = ".*_?sdk_?.*";
        r0 = r0.matches(r1);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x04cb;
    L_0x0342:
        r0 = 1;
    L_0x0343:
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f52Q = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0349:
        r0 = com.paypal.android.sdk.as.PPRiskDataIsRooted;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x035b;
    L_0x0351:
        r0 = com.paypal.android.sdk.ad.m124a();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f53R = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x035b:
        r0 = com.paypal.android.sdk.as.PPRiskDataKnownApps;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x03b1;
    L_0x0363:
        r1 = new java.util.ArrayList;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1.<init>();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r12.f100j;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x03a8;
    L_0x036c:
        r0 = r12.f100j;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r0.m33f();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r0.iterator();	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
    L_0x0376:
        r0 = r2.hasNext();	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        if (r0 == 0) goto L_0x03a8;
    L_0x037c:
        r0 = r2.next();	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r4 = r12.f92b;	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r4 = r4.getPackageManager();	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r5 = new android.content.Intent;	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r5.<init>();	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r6 = android.content.ComponentName.unflattenFromString(r0);	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r5 = r5.setComponent(r6);	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        r4 = com.paypal.android.sdk.at.m158a(r4, r5);	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        if (r4 == 0) goto L_0x0376;
    L_0x039b:
        r1.add(r0);	 Catch:{ Exception -> 0x039f, RuntimeException -> 0x046c }
        goto L_0x0376;
    L_0x039f:
        r0 = move-exception;
        r0 = f88a;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = "knownApps error";
        r4 = 0;
        com.paypal.android.sdk.at.m155a(r0, r2, r4);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x03a8:
        r0 = r1.size();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x04ce;
    L_0x03ae:
        r0 = 0;
    L_0x03af:
        r3.f78q = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x03b1:
        r0 = com.paypal.android.sdk.as.PPRiskDataAppFirstInstallTime;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x03c1;
    L_0x03b9:
        r0 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = com.paypal.android.sdk.C0503Y.m51a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f55T = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x03c1:
        r0 = com.paypal.android.sdk.as.PPRiskDataAppLastUpdateTime;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x03d1;
    L_0x03c9:
        r0 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = com.paypal.android.sdk.C0503Y.m57b(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f56U = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x03d1:
        r0 = r12.f104n;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.ac = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = com.paypal.android.sdk.as.PPRiskDataGsfId;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x03e5;
    L_0x03dd:
        r0 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = com.paypal.android.sdk.at.m160b(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f61Z = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x03e5:
        r0 = com.paypal.android.sdk.as.PPRiskDataVPNSetting;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x03f3;
    L_0x03ed:
        r0 = com.paypal.android.sdk.at.m165e();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.ab = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x03f3:
        r0 = com.paypal.android.sdk.as.PPRiskDataProxySetting;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x0401;
    L_0x03fb:
        r0 = com.paypal.android.sdk.at.m164d();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.aa = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0401:
        r0 = com.paypal.android.sdk.as.PPRiskDataAdvertisingIdentifier;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 == 0) goto L_0x0411;
    L_0x0409:
        r0 = r12.f92b;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = com.paypal.android.sdk.at.m149a(r0, r3);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f58W = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0411:
        r0 = com.paypal.android.sdk.as.PPRiskDataOsType;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r0 = r8.m143a(r0);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r0 != 0) goto L_0x041c;
    L_0x0419:
        r0 = 0;
        r3.f86y = r0;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x041c:
        r0 = r3;
        goto L_0x0005;
    L_0x041f:
        r1 = 0;
        r7 = r1;
        goto L_0x0040;
    L_0x0423:
        r1 = 0;
        r6 = r1;
        goto L_0x004f;
    L_0x0427:
        r1 = 0;
        goto L_0x0064;
    L_0x042a:
        r1 = "none";
        r3.f36A = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r4;
        r4 = r5;
        goto L_0x0090;
    L_0x0432:
        r2 = "gsm";
        r3.f36A = r2;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0448;
    L_0x0438:
        r1 = r0.getCellLocation();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = android.telephony.gsm.GsmCellLocation.class;
        r1 = com.paypal.android.sdk.at.m147a(r1, r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = (android.telephony.gsm.GsmCellLocation) r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x0444:
        r2 = r4;
        r4 = r1;
        goto L_0x0090;
    L_0x0448:
        r1 = 0;
        goto L_0x0444;
    L_0x044a:
        r2 = "cdma";
        r3.f36A = r2;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        if (r1 == 0) goto L_0x0460;
    L_0x0450:
        r1 = r0.getCellLocation();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = android.telephony.cdma.CdmaCellLocation.class;
        r1 = com.paypal.android.sdk.at.m147a(r1, r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = (android.telephony.cdma.CdmaCellLocation) r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
    L_0x045c:
        r2 = r1;
        r4 = r5;
        goto L_0x0090;
    L_0x0460:
        r1 = 0;
        goto L_0x045c;
    L_0x0462:
        r1 = r12.f109s;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.m80a();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r3.f50O = r1;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x00c7;
    L_0x046c:
        r0 = move-exception;
        throw r0;
    L_0x046e:
        r1 = r2.getBaseStationId();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0122;
    L_0x0474:
        r1 = r2.getNetworkId();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x012f;
    L_0x047a:
        r1 = r2.getSystemId();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x013c;
    L_0x0480:
        r1 = r7.getBSSID();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0149;
    L_0x0486:
        r1 = r4.getCid();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0156;
    L_0x048c:
        r1 = r12.f100j;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1 = r1.m29b();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0173;
    L_0x0494:
        r1 = r6.getTypeName();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0180;
    L_0x049a:
        r1 = 0;
        goto L_0x0190;
    L_0x049d:
        r1 = 0;
        goto L_0x01e3;
    L_0x04a0:
        r1 = new android.location.Location;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r2 = r12.f106p;	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        r1.<init>(r2);	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0224;
    L_0x04a9:
        r0 = move-exception;
        r1 = f88a;
        r2 = "Unknown error in RiskComponent";
        com.paypal.android.sdk.at.m155a(r1, r2, r0);
        goto L_0x041c;
    L_0x04b3:
        r1 = r4.getLac();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x0231;
    L_0x04b9:
        r1 = r7.getMacAddress();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x023e;
    L_0x04bf:
        r1 = 0;
        goto L_0x028d;
    L_0x04c2:
        r1 = r7.getSSID();	 Catch:{ RuntimeException -> 0x046c, Exception -> 0x04a9 }
        goto L_0x02be;
    L_0x04c8:
        r0 = 0;
        goto L_0x02ce;
    L_0x04cb:
        r0 = 0;
        goto L_0x0343;
    L_0x04ce:
        r0 = r1;
        goto L_0x03af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paypal.android.sdk.Y.l():com.paypal.android.sdk.X");
    }

    public final String m73a(Context context, String str, C0505a c0505a, String str2, String str3, boolean z, String str4, String str5) {
        this.f92b = context;
        this.f93c = str;
        this.f112v = z;
        if (c0505a == null) {
            this.f109s = C0505a.UNKNOWN;
        } else {
            this.f109s = c0505a;
        }
        this.f110t = str2;
        this.f101k = null;
        this.f102l = null;
        this.f113w = str5;
        this.f104n = new HashMap();
        this.f97g = 0;
        this.f96f = 0;
        this.f111u = C0503Y.m67i();
        if (str3 == null) {
            try {
                str3 = "https://www.paypalobjects.com/webstatic/risk/dyson_config_android_v3.json";
            } catch (Throwable e) {
                at.m155a(f88a, null, e);
            }
        }
        this.f99i = str3;
        m78f();
        if (this.f108r == null) {
            this.f108r = new ab(this);
            LocationManager locationManager = (LocationManager) this.f92b.getSystemService("location");
            if (locationManager != null) {
                onLocationChanged(at.m145a(locationManager));
                if (locationManager.isProviderEnabled("network")) {
                    locationManager.requestLocationUpdates("network", 3600000, 10.0f, this);
                }
            }
        }
        m71k();
        m68j();
        m54a(new C0499U(this.f92b));
        return this.f111u;
    }

    public final void m74a(Message message) {
        try {
            switch (message.what) {
                case 0:
                    at.m154a(f88a, "Dyson Async URL: " + message.obj);
                    return;
                case 1:
                    at.m154a(f88a, "LogRiskMetadataRequest failed.");
                    return;
                case 2:
                    Object queryParameter;
                    String str = (String) message.obj;
                    at.m154a(f88a, "LogRiskMetadataRequest Server returned: " + str);
                    try {
                        queryParameter = Uri.parse("?" + str).getQueryParameter("responseEnvelope.ack");
                    } catch (UnsupportedOperationException e) {
                        queryParameter = null;
                    }
                    if ("Success".equals(queryParameter)) {
                        at.m154a(f88a, "LogRiskMetadataRequest Success");
                        Map hashMap = new HashMap(this.f104n);
                        for (Entry entry : this.f104n.entrySet()) {
                            Object obj = null;
                            for (Entry entry2 : this.f105o.entrySet()) {
                                Object obj2 = (!((String) entry2.getKey()).equals(entry.getKey()) || (entry2.getValue() != null ? entry2.getValue().equals(entry.getValue()) : entry.getValue() == null)) ? obj : 1;
                                obj = obj2;
                            }
                            if (obj != null) {
                                hashMap.remove(entry.getKey());
                            }
                        }
                        this.f104n = hashMap;
                        this.f101k = this.f102l;
                        this.f102l = null;
                        return;
                    }
                    return;
                case 10:
                    at.m154a(f88a, "Load Configuration URL: " + message.obj);
                    return;
                case 11:
                    at.m154a(f88a, "LoadConfigurationRequest failed.");
                    return;
                case 12:
                    C0499U c0499u = (C0499U) message.obj;
                    if (c0499u != null) {
                        m54a(c0499u);
                        return;
                    }
                    return;
                case 20:
                    at.m154a(f88a, "Beacon URL: " + message.obj);
                    return;
                case 21:
                    at.m154a(f88a, "BeaconRequest failed " + ((Exception) message.obj).getMessage());
                    return;
                case 22:
                    at.m154a(f88a, "Beacon returned: " + message.obj);
                    return;
                default:
                    return;
            }
        } catch (Throwable e2) {
            at.m155a(f88a, null, e2);
        }
        at.m155a(f88a, null, e2);
    }

    public final void m75b() {
        new Timer().schedule(new aa(this), 0);
    }

    public final JSONObject m76c() {
        ac.m119a();
        this.f101k = m72l();
        return this.f101k == null ? null : this.f101k.m48a();
    }

    public final void m77e() {
        ac.m119a();
        this.f101k = m72l();
        m55a(this.f101k, null);
    }

    public final void m78f() {
        at.m154a(f88a, "Host activity detected");
        this.f98h = System.currentTimeMillis();
    }

    public final String m79g() {
        String i = C0503Y.m67i();
        this.f111u = i;
        m77e();
        m68j();
        return i;
    }

    public void onLocationChanged(Location location) {
        if (location != null) {
            this.f106p = new Location(location);
            at.m154a(f88a, "Location Update: " + location.toString());
        }
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
