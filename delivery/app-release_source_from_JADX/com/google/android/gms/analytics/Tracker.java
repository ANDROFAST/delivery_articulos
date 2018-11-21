package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqh;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Tracker extends zzd {
    private boolean zzNY;
    private final Map<String, String> zzNZ = new HashMap();
    private final zzad zzOa;
    private final zza zzOb;
    private ExceptionReporter zzOc;
    private zzal zzOd;
    private final Map<String, String> zzxc = new HashMap();

    private class zza extends zzd implements zza {
        final /* synthetic */ Tracker zzOl;
        private boolean zzOm;
        private int zzOn;
        private long zzOo = -1;
        private boolean zzOp;
        private long zzOq;

        protected zza(Tracker tracker, zzf com_google_android_gms_analytics_internal_zzf) {
            this.zzOl = tracker;
            super(com_google_android_gms_analytics_internal_zzf);
        }

        private void zziv() {
            if (this.zzOo >= 0 || this.zzOm) {
                zzik().zza(this.zzOl.zzOb);
            } else {
                zzik().zzb(this.zzOl.zzOb);
            }
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.zzOm = enabled;
            zziv();
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.zzOo = sessionTimeout;
            zziv();
        }

        protected void zzir() {
        }

        public synchronized boolean zziu() {
            boolean z;
            z = this.zzOp;
            this.zzOp = false;
            return z;
        }

        boolean zziw() {
            return zziT().elapsedRealtime() >= this.zzOq + Math.max(1000, this.zzOo);
        }

        public void zzn(Activity activity) {
            if (this.zzOn == 0 && zziw()) {
                this.zzOp = true;
            }
            this.zzOn++;
            if (this.zzOm) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    this.zzOl.setCampaignParamsOnNextHit(intent.getData());
                }
                Map hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                this.zzOl.set("&cd", this.zzOl.zzOd != null ? this.zzOl.zzOd.zzq(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    CharSequence zzp = Tracker.zzp(activity);
                    if (!TextUtils.isEmpty(zzp)) {
                        hashMap.put("&dr", zzp);
                    }
                }
                this.zzOl.send(hashMap);
            }
        }

        public void zzo(Activity activity) {
            this.zzOn--;
            this.zzOn = Math.max(0, this.zzOn);
            if (this.zzOn == 0) {
                this.zzOq = zziT().elapsedRealtime();
            }
        }
    }

    Tracker(zzf analytics, String trackingId, zzad rateLimiter) {
        super(analytics);
        if (trackingId != null) {
            this.zzxc.put("&tid", trackingId);
        }
        this.zzxc.put("useSecure", "1");
        this.zzxc.put("&a", Integer.toString(new Random().nextInt(Integer.MAX_VALUE) + 1));
        if (rateLimiter == null) {
            this.zzOa = new zzad("tracking");
        } else {
            this.zzOa = rateLimiter;
        }
        this.zzOb = new zza(this, analytics);
    }

    private static boolean zza(Entry<String, String> entry) {
        String str = (String) entry.getKey();
        String str2 = (String) entry.getValue();
        return str.startsWith("&") && str.length() >= 2;
    }

    private static String zzb(Entry<String, String> entry) {
        return !zza((Entry) entry) ? null : ((String) entry.getKey()).substring(1);
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzx.zzy(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (zzb != null) {
                    map2.put(zzb, entry.getValue());
                }
            }
        }
    }

    private static void zzc(Map<String, String> map, Map<String, String> map2) {
        zzx.zzy(map2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String zzb = zzb(entry);
                if (!(zzb == null || map2.containsKey(zzb))) {
                    map2.put(zzb, entry.getValue());
                }
            }
        }
    }

    private boolean zzis() {
        return this.zzOc != null;
    }

    static String zzp(Activity activity) {
        zzx.zzy(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        CharSequence stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : null;
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        this.zzNY = enabled;
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.zzOb.enableAutoActivityTracking(enabled);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableExceptionReporting(boolean r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.zzis();	 Catch:{ all -> 0x0026 }
        if (r0 != r4) goto L_0x0009;
    L_0x0007:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
    L_0x0008:
        return;
    L_0x0009:
        if (r4 == 0) goto L_0x0029;
    L_0x000b:
        r0 = r3.getContext();	 Catch:{ all -> 0x0026 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x0026 }
        r2 = new com.google.android.gms.analytics.ExceptionReporter;	 Catch:{ all -> 0x0026 }
        r2.<init>(r3, r1, r0);	 Catch:{ all -> 0x0026 }
        r3.zzOc = r2;	 Catch:{ all -> 0x0026 }
        r0 = r3.zzOc;	 Catch:{ all -> 0x0026 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0026 }
        r0 = "Uncaught exceptions will be reported to Google Analytics";
        r3.zzba(r0);	 Catch:{ all -> 0x0026 }
    L_0x0024:
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        goto L_0x0008;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        r0 = r3.zzOc;	 Catch:{ all -> 0x0026 }
        r0 = r0.zzil();	 Catch:{ all -> 0x0026 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ all -> 0x0026 }
        r0 = "Uncaught exceptions will not be reported to Google Analytics";
        r3.zzba(r0);	 Catch:{ all -> 0x0026 }
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.Tracker.enableExceptionReporting(boolean):void");
    }

    public String get(String key) {
        zzje();
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.zzxc.containsKey(key)) {
            return (String) this.zzxc.get(key);
        }
        if (key.equals("&ul")) {
            return zzam.zza(Locale.getDefault());
        }
        if (key.equals("&cid")) {
            return zziZ().zzjT();
        }
        if (key.equals("&sr")) {
            return zzjc().zzkJ();
        }
        if (key.equals("&aid")) {
            return zzjb().zzjB().zzwg();
        }
        if (key.equals("&an")) {
            return zzjb().zzjB().zzkP();
        }
        if (key.equals("&av")) {
            return zzjb().zzjB().zzkR();
        }
        return key.equals("&aiid") ? zzjb().zzjB().zzzT() : null;
    }

    public void send(Map<String, String> params) {
        final long currentTimeMillis = zziT().currentTimeMillis();
        if (zzik().getAppOptOut()) {
            zzbb("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean isDryRunEnabled = zzik().isDryRunEnabled();
        final Map hashMap = new HashMap();
        zzb(this.zzxc, hashMap);
        zzb(params, hashMap);
        final boolean zze = zzam.zze((String) this.zzxc.get("useSecure"), true);
        zzc(this.zzNZ, hashMap);
        this.zzNZ.clear();
        final String str = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zziU().zzh(hashMap, "Missing hit type parameter");
            return;
        }
        final String str2 = (String) hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zziU().zzh(hashMap, "Missing tracking id parameter");
            return;
        }
        final boolean zzit = zzit();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt((String) this.zzxc.get("&a")) + 1;
                if (parseInt >= Integer.MAX_VALUE) {
                    parseInt = 1;
                }
                this.zzxc.put("&a", Integer.toString(parseInt));
            }
        }
        zziW().zzf(new Runnable(this) {
            final /* synthetic */ Tracker zzOl;

            public void run() {
                boolean z = true;
                if (this.zzOl.zzOb.zziu()) {
                    hashMap.put("sc", "start");
                }
                zzam.zzd(hashMap, "cid", this.zzOl.zzik().getClientId());
                String str = (String) hashMap.get("sf");
                if (str != null) {
                    double zza = zzam.zza(str, 100.0d);
                    if (zzam.zza(zza, (String) hashMap.get("cid"))) {
                        this.zzOl.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza zzb = this.zzOl.zzja();
                if (zzit) {
                    zzam.zzb(hashMap, "ate", zzb.zziC());
                    zzam.zzc(hashMap, "adid", zzb.zziG());
                } else {
                    hashMap.remove("ate");
                    hashMap.remove("adid");
                }
                zzqh zzjB = this.zzOl.zzjb().zzjB();
                zzam.zzc(hashMap, "an", zzjB.zzkP());
                zzam.zzc(hashMap, "av", zzjB.zzkR());
                zzam.zzc(hashMap, "aid", zzjB.zzwg());
                zzam.zzc(hashMap, "aiid", zzjB.zzzT());
                hashMap.put("v", "1");
                hashMap.put("_v", zze.zzOS);
                zzam.zzc(hashMap, "ul", this.zzOl.zzjc().zzkI().getLanguage());
                zzam.zzc(hashMap, "sr", this.zzOl.zzjc().zzkJ());
                boolean z2 = str.equals("transaction") || str.equals("item");
                if (z2 || this.zzOl.zzOa.zzlf()) {
                    long zzbq = zzam.zzbq((String) hashMap.get("ht"));
                    if (zzbq == 0) {
                        zzbq = currentTimeMillis;
                    }
                    if (isDryRunEnabled) {
                        this.zzOl.zziU().zzc("Dry run enabled. Would have sent hit", new zzab(this.zzOl, hashMap, zzbq, zze));
                        return;
                    }
                    String str2 = (String) hashMap.get("cid");
                    Map hashMap = new HashMap();
                    zzam.zza(hashMap, "uid", hashMap);
                    zzam.zza(hashMap, "an", hashMap);
                    zzam.zza(hashMap, "aid", hashMap);
                    zzam.zza(hashMap, "av", hashMap);
                    zzam.zza(hashMap, "aiid", hashMap);
                    String str3 = str2;
                    if (TextUtils.isEmpty((CharSequence) hashMap.get("adid"))) {
                        z = false;
                    }
                    hashMap.put("_s", String.valueOf(this.zzOl.zzip().zza(new zzh(0, str2, str3, z, 0, hashMap))));
                    this.zzOl.zzip().zza(new zzab(this.zzOl, hashMap, zzbq, zze));
                    return;
                }
                this.zzOl.zziU().zzh(hashMap, "Too many hits sent too quickly, rate limiting invoked");
            }
        });
    }

    public void set(String key, String value) {
        zzx.zzb((Object) key, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(key)) {
            this.zzxc.put(key, value);
        }
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", zzam.zzK(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            Object queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                Uri parse = Uri.parse("http://hostname/?" + queryParameter);
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&ci", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("anid");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&anid", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_campaign");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&cn", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_content");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&cc", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_medium");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&cm", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_source");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&cs", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("utm_term");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&ck", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("dclid");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&dclid", queryParameter2);
                }
                queryParameter2 = parse.getQueryParameter("gclid");
                if (queryParameter2 != null) {
                    this.zzNZ.put("&gclid", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("aclid");
                if (queryParameter3 != null) {
                    this.zzNZ.put("&aclid", queryParameter3);
                }
            }
        }
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            zzbd("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.zzOb.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", zzam.zzK(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }

    void zza(zzal com_google_android_gms_analytics_internal_zzal) {
        zzba("Loading Tracker config values");
        this.zzOd = com_google_android_gms_analytics_internal_zzal;
        if (this.zzOd.zzlC()) {
            String trackingId = this.zzOd.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzOd.zzlD()) {
            trackingId = Double.toString(this.zzOd.zzlE());
            set("&sf", trackingId);
            zza("Sample frequency loaded", trackingId);
        }
        if (this.zzOd.zzlF()) {
            int sessionTimeout = this.zzOd.getSessionTimeout();
            setSessionTimeout((long) sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzOd.zzlG()) {
            boolean zzlH = this.zzOd.zzlH();
            enableAutoActivityTracking(zzlH);
            zza("Auto activity tracking loaded", Boolean.valueOf(zzlH));
        }
        if (this.zzOd.zzlI()) {
            zzlH = this.zzOd.zzlJ();
            if (zzlH) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zzlH));
        }
        enableExceptionReporting(this.zzOd.zzlK());
    }

    protected void zzir() {
        this.zzOb.zza();
        String zzkP = zziq().zzkP();
        if (zzkP != null) {
            set("&an", zzkP);
        }
        zzkP = zziq().zzkR();
        if (zzkP != null) {
            set("&av", zzkP);
        }
    }

    boolean zzit() {
        return this.zzNY;
    }
}
