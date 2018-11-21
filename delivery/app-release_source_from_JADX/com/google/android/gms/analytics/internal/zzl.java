package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.analytics.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzg;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzPE;
    private final zzah zzPF;
    private final zzag zzPG;
    private final zzi zzPH;
    private long zzPI = Long.MIN_VALUE;
    private final zzt zzPJ;
    private final zzt zzPK;
    private final zzaj zzPL;
    private long zzPM;
    private boolean zzPN;

    class C01953 implements Runnable {
        final /* synthetic */ zzl zzPO;

        C01953(zzl com_google_android_gms_analytics_internal_zzl) {
            this.zzPO = com_google_android_gms_analytics_internal_zzl;
        }

        public void run() {
            this.zzPO.zzjD();
        }
    }

    class C06224 implements zzw {
        final /* synthetic */ zzl zzPO;

        C06224(zzl com_google_android_gms_analytics_internal_zzl) {
            this.zzPO = com_google_android_gms_analytics_internal_zzl;
        }

        public void zzc(Throwable th) {
            this.zzPO.zzjK();
        }
    }

    protected zzl(zzf com_google_android_gms_analytics_internal_zzf, zzg com_google_android_gms_analytics_internal_zzg) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzx.zzy(com_google_android_gms_analytics_internal_zzg);
        this.zzPG = com_google_android_gms_analytics_internal_zzg.zzk(com_google_android_gms_analytics_internal_zzf);
        this.zzPE = com_google_android_gms_analytics_internal_zzg.zzm(com_google_android_gms_analytics_internal_zzf);
        this.zzPF = com_google_android_gms_analytics_internal_zzg.zzn(com_google_android_gms_analytics_internal_zzf);
        this.zzPH = com_google_android_gms_analytics_internal_zzg.zzo(com_google_android_gms_analytics_internal_zzf);
        this.zzPL = new zzaj(zziT());
        this.zzPJ = new zzt(this, com_google_android_gms_analytics_internal_zzf) {
            final /* synthetic */ zzl zzPO;

            public void run() {
                this.zzPO.zzjE();
            }
        };
        this.zzPK = new zzt(this, com_google_android_gms_analytics_internal_zzf) {
            final /* synthetic */ zzl zzPO;

            public void run() {
                this.zzPO.zzjF();
            }
        };
    }

    private void zza(zzh com_google_android_gms_analytics_internal_zzh, zzqi com_google_android_gms_internal_zzqi) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzh);
        zzx.zzy(com_google_android_gms_internal_zzqi);
        zza com_google_android_gms_analytics_zza = new zza(zziQ());
        com_google_android_gms_analytics_zza.zzaP(com_google_android_gms_analytics_internal_zzh.zzjn());
        com_google_android_gms_analytics_zza.enableAdvertisingIdCollection(com_google_android_gms_analytics_internal_zzh.zzjo());
        zzc zzig = com_google_android_gms_analytics_zza.zzig();
        zzkc com_google_android_gms_internal_zzkc = (zzkc) zzig.zze(zzkc.class);
        com_google_android_gms_internal_zzkc.zzaU("data");
        com_google_android_gms_internal_zzkc.zzI(true);
        zzig.zzb(com_google_android_gms_internal_zzqi);
        zzkb com_google_android_gms_internal_zzkb = (zzkb) zzig.zze(zzkb.class);
        zzqh com_google_android_gms_internal_zzqh = (zzqh) zzig.zze(zzqh.class);
        for (Entry entry : com_google_android_gms_analytics_internal_zzh.zzn().entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if ("an".equals(str)) {
                com_google_android_gms_internal_zzqh.setAppName(str2);
            } else if ("av".equals(str)) {
                com_google_android_gms_internal_zzqh.setAppVersion(str2);
            } else if ("aid".equals(str)) {
                com_google_android_gms_internal_zzqh.setAppId(str2);
            } else if ("aiid".equals(str)) {
                com_google_android_gms_internal_zzqh.setAppInstallerId(str2);
            } else if ("uid".equals(str)) {
                com_google_android_gms_internal_zzkc.setUserId(str2);
            } else {
                com_google_android_gms_internal_zzkb.set(str, str2);
            }
        }
        zzb("Sending installation campaign to", com_google_android_gms_analytics_internal_zzh.zzjn(), com_google_android_gms_internal_zzqi);
        zzig.zzM(zziY().zzlo());
        zzig.zzzI();
    }

    private boolean zzbh(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    private void zzjC() {
        Context context = zziQ().getContext();
        if (!AnalyticsReceiver.zzX(context)) {
            zzbd("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzY(context)) {
            zzbe("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzX(context)) {
            zzbd("CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!CampaignTrackingService.zzY(context)) {
            zzbd("CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
    }

    private void zzjE() {
        zzb(new C06224(this));
    }

    private void zzjF() {
        try {
            this.zzPE.zzjw();
            zzjK();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzPK.zzt(zziV().zzkC());
    }

    private boolean zzjL() {
        return this.zzPN ? false : (!zziV().zzka() || zziV().zzkb()) && zzjR() > 0;
    }

    private void zzjM() {
        zzv zziX = zziX();
        if (zziX.zzkK() && !zziX.zzbr()) {
            long zzjx = zzjx();
            if (zzjx != 0 && Math.abs(zziT().currentTimeMillis() - zzjx) <= zziV().zzkk()) {
                zza("Dispatch alarm scheduled (ms)", Long.valueOf(zziV().zzkj()));
                zziX.zzkL();
            }
        }
    }

    private void zzjN() {
        zzjM();
        long zzjR = zzjR();
        long zzlq = zziY().zzlq();
        if (zzlq != 0) {
            zzlq = zzjR - Math.abs(zziT().currentTimeMillis() - zzlq);
            if (zzlq <= 0) {
                zzlq = Math.min(zziV().zzkh(), zzjR);
            }
        } else {
            zzlq = Math.min(zziV().zzkh(), zzjR);
        }
        zza("Dispatch scheduled (ms)", Long.valueOf(zzlq));
        if (this.zzPJ.zzbr()) {
            this.zzPJ.zzu(Math.max(1, zzlq + this.zzPJ.zzkH()));
            return;
        }
        this.zzPJ.zzt(zzlq);
    }

    private void zzjO() {
        zzjP();
        zzjQ();
    }

    private void zzjP() {
        if (this.zzPJ.zzbr()) {
            zzba("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzPJ.cancel();
    }

    private void zzjQ() {
        zzv zziX = zziX();
        if (zziX.zzbr()) {
            zziX.cancel();
        }
    }

    protected void onServiceConnected() {
        zziS();
        if (!zziV().zzka()) {
            zzjH();
        }
    }

    void start() {
        zzje();
        zzx.zza(!this.mStarted, (Object) "Analytics backend already started");
        this.mStarted = true;
        if (!zziV().zzka()) {
            zzjC();
        }
        zziW().zzf(new C01953(this));
    }

    public void zzJ(boolean z) {
        zzjK();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long zza(com.google.android.gms.analytics.internal.zzh r6, boolean r7) {
        /*
        r5 = this;
        com.google.android.gms.common.internal.zzx.zzy(r6);
        r5.zzje();
        r5.zziS();
        r0 = r5.zzPE;	 Catch:{ SQLiteException -> 0x0049 }
        r0.beginTransaction();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.zzPE;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.zzjm();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.getClientId();	 Catch:{ SQLiteException -> 0x0049 }
        r0.zza(r2, r1);	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r5.zzPE;	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r6.zzjm();	 Catch:{ SQLiteException -> 0x0049 }
        r1 = r6.getClientId();	 Catch:{ SQLiteException -> 0x0049 }
        r4 = r6.zzjn();	 Catch:{ SQLiteException -> 0x0049 }
        r0 = r0.zza(r2, r1, r4);	 Catch:{ SQLiteException -> 0x0049 }
        if (r7 != 0) goto L_0x0042;
    L_0x002f:
        r6.zzn(r0);	 Catch:{ SQLiteException -> 0x0049 }
    L_0x0032:
        r2 = r5.zzPE;	 Catch:{ SQLiteException -> 0x0049 }
        r2.zzb(r6);	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.zzPE;	 Catch:{ SQLiteException -> 0x0049 }
        r2.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0049 }
        r2 = r5.zzPE;	 Catch:{ SQLiteException -> 0x005e }
        r2.endTransaction();	 Catch:{ SQLiteException -> 0x005e }
    L_0x0041:
        return r0;
    L_0x0042:
        r2 = 1;
        r2 = r2 + r0;
        r6.zzn(r2);	 Catch:{ SQLiteException -> 0x0049 }
        goto L_0x0032;
    L_0x0049:
        r0 = move-exception;
        r1 = "Failed to update Analytics property";
        r5.zze(r1, r0);	 Catch:{ all -> 0x0065 }
        r0 = -1;
        r2 = r5.zzPE;	 Catch:{ SQLiteException -> 0x0057 }
        r2.endTransaction();	 Catch:{ SQLiteException -> 0x0057 }
        goto L_0x0041;
    L_0x0057:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.zze(r3, r2);
        goto L_0x0041;
    L_0x005e:
        r2 = move-exception;
        r3 = "Failed to end transaction";
        r5.zze(r3, r2);
        goto L_0x0041;
    L_0x0065:
        r0 = move-exception;
        r1 = r5.zzPE;	 Catch:{ SQLiteException -> 0x006c }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x006c }
    L_0x006b:
        throw r0;
    L_0x006c:
        r1 = move-exception;
        r2 = "Failed to end transaction";
        r5.zze(r2, r1);
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zza(com.google.android.gms.analytics.internal.zzh, boolean):long");
    }

    public void zza(zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzab);
        zzg.zziS();
        zzje();
        if (this.zzPN) {
            zzbb("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", com_google_android_gms_analytics_internal_zzab);
        }
        zzab zzf = zzf(com_google_android_gms_analytics_internal_zzab);
        zzjG();
        if (this.zzPH.zzb(zzf)) {
            zzbb("Hit sent to the device AnalyticsService for delivery");
        } else if (zziV().zzka()) {
            zziU().zza(zzf, "Service unavailable on package side");
        } else {
            try {
                this.zzPE.zzc(zzf);
                zzjK();
            } catch (SQLiteException e) {
                zze("Delivery failed to save hit to a database", e);
                zziU().zza(zzf, "deliver: failed to insert hit to database");
            }
        }
    }

    public void zza(final zzw com_google_android_gms_analytics_internal_zzw, final long j) {
        zzg.zziS();
        zzje();
        long j2 = -1;
        long zzlq = zziY().zzlq();
        if (zzlq != 0) {
            j2 = Math.abs(zziT().currentTimeMillis() - zzlq);
        }
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(j2));
        if (!zziV().zzka()) {
            zzjG();
        }
        try {
            if (zzjI()) {
                zziW().zzf(new Runnable(this) {
                    final /* synthetic */ zzl zzPO;

                    public void run() {
                        this.zzPO.zza(com_google_android_gms_analytics_internal_zzw, j);
                    }
                });
                return;
            }
            zziY().zzlr();
            zzjK();
            if (com_google_android_gms_analytics_internal_zzw != null) {
                com_google_android_gms_analytics_internal_zzw.zzc(null);
            }
            if (this.zzPM != j) {
                this.zzPG.zzlj();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zziY().zzlr();
            zzjK();
            if (com_google_android_gms_analytics_internal_zzw != null) {
                com_google_android_gms_analytics_internal_zzw.zzc(th);
            }
        }
    }

    public void zzb(zzw com_google_android_gms_analytics_internal_zzw) {
        zza(com_google_android_gms_analytics_internal_zzw, this.zzPM);
    }

    public void zzbi(String str) {
        zzx.zzcG(str);
        zziS();
        zziR();
        zzqi zza = zzam.zza(zziU(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        CharSequence zzls = zziY().zzls();
        if (str.equals(zzls)) {
            zzbd("Ignoring duplicate install campaign");
        } else if (TextUtils.isEmpty(zzls)) {
            zziY().zzbm(str);
            if (zziY().zzlp().zzv(zziV().zzkF())) {
                zzd("Campaign received too late, ignoring", zza);
                return;
            }
            zzb("Received installation campaign", zza);
            for (zzh zza2 : this.zzPE.zzr(0)) {
                zza(zza2, zza);
            }
        } else {
            zzd("Ignoring multiple install campaigns. original, new", zzls, str);
        }
    }

    protected void zzc(zzh com_google_android_gms_analytics_internal_zzh) {
        zziS();
        zzb("Sending first hit to property", com_google_android_gms_analytics_internal_zzh.zzjn());
        if (!zziY().zzlp().zzv(zziV().zzkF())) {
            String zzls = zziY().zzls();
            if (!TextUtils.isEmpty(zzls)) {
                zzqi zza = zzam.zza(zziU(), zzls);
                zzb("Found relevant installation campaign", zza);
                zza(com_google_android_gms_analytics_internal_zzh, zza);
            }
        }
    }

    zzab zzf(zzab com_google_android_gms_analytics_internal_zzab) {
        if (!TextUtils.isEmpty(com_google_android_gms_analytics_internal_zzab.zzle())) {
            return com_google_android_gms_analytics_internal_zzab;
        }
        Pair zzlw = zziY().zzlt().zzlw();
        if (zzlw == null) {
            return com_google_android_gms_analytics_internal_zzab;
        }
        Long l = (Long) zzlw.second;
        String str = l + ":" + ((String) zzlw.first);
        Map hashMap = new HashMap(com_google_android_gms_analytics_internal_zzab.zzn());
        hashMap.put("_m", str);
        return zzab.zza(this, com_google_android_gms_analytics_internal_zzab, hashMap);
    }

    public void zziK() {
        zzg.zziS();
        zzje();
        if (!zziV().zzka()) {
            zzba("Delete all hits from local store");
            try {
                this.zzPE.zzju();
                this.zzPE.zzjv();
                zzjK();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zzjG();
        if (this.zzPH.zzjq()) {
            zzba("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zziN() {
        zzg.zziS();
        zzje();
        zzba("Service disconnected");
    }

    void zziP() {
        zziS();
        this.zzPM = zziT().currentTimeMillis();
    }

    protected void zzir() {
        this.zzPE.zza();
        this.zzPF.zza();
        this.zzPH.zza();
    }

    protected void zzjD() {
        zzje();
        zziY().zzlo();
        if (!zzbh("android.permission.ACCESS_NETWORK_STATE")) {
            zzbe("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzjS();
        }
        if (!zzbh("android.permission.INTERNET")) {
            zzbe("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zzjS();
        }
        if (AnalyticsService.zzY(getContext())) {
            zzba("AnalyticsService registered in the app manifest and enabled");
        } else if (zziV().zzka()) {
            zzbe("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzbd("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!(this.zzPN || zziV().zzka() || this.zzPE.isEmpty())) {
            zzjG();
        }
        zzjK();
    }

    protected void zzjG() {
        if (!this.zzPN && zziV().zzkc() && !this.zzPH.isConnected()) {
            if (this.zzPL.zzv(zziV().zzkx())) {
                this.zzPL.start();
                zzba("Connecting to service");
                if (this.zzPH.connect()) {
                    zzba("Connected to service");
                    this.zzPL.clear();
                    onServiceConnected();
                }
            }
        }
    }

    public void zzjH() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        com.google.android.gms.measurement.zzg.zziS();
        r6.zzje();
        r6.zziR();
        r0 = r6.zziV();
        r0 = r0.zzkc();
        if (r0 != 0) goto L_0x0018;
    L_0x0013:
        r0 = "Service client disabled. Can't dispatch local hits to device AnalyticsService";
        r6.zzbd(r0);
    L_0x0018:
        r0 = r6.zzPH;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0026;
    L_0x0020:
        r0 = "Service not connected";
        r6.zzba(r0);
    L_0x0025:
        return;
    L_0x0026:
        r0 = r6.zzPE;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0025;
    L_0x002e:
        r0 = "Dispatching local hits to device AnalyticsService";
        r6.zzba(r0);
    L_0x0033:
        r0 = r6.zzPE;	 Catch:{ SQLiteException -> 0x004c }
        r1 = r6.zziV();	 Catch:{ SQLiteException -> 0x004c }
        r1 = r1.zzkl();	 Catch:{ SQLiteException -> 0x004c }
        r2 = (long) r1;	 Catch:{ SQLiteException -> 0x004c }
        r1 = r0.zzp(r2);	 Catch:{ SQLiteException -> 0x004c }
        r0 = r1.isEmpty();	 Catch:{ SQLiteException -> 0x004c }
        if (r0 == 0) goto L_0x0062;	 Catch:{ SQLiteException -> 0x004c }
    L_0x0048:
        r6.zzjK();	 Catch:{ SQLiteException -> 0x004c }
        goto L_0x0025;
    L_0x004c:
        r0 = move-exception;
        r1 = "Failed to read hits from store";
        r6.zze(r1, r0);
        r6.zzjO();
        goto L_0x0025;
    L_0x0056:
        r1.remove(r0);
        r2 = r6.zzPE;	 Catch:{ SQLiteException -> 0x007b }
        r4 = r0.zzkZ();	 Catch:{ SQLiteException -> 0x007b }
        r2.zzq(r4);	 Catch:{ SQLiteException -> 0x007b }
    L_0x0062:
        r0 = r1.isEmpty();
        if (r0 != 0) goto L_0x0033;
    L_0x0068:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (com.google.android.gms.analytics.internal.zzab) r0;
        r2 = r6.zzPH;
        r2 = r2.zzb(r0);
        if (r2 != 0) goto L_0x0056;
    L_0x0077:
        r6.zzjK();
        goto L_0x0025;
    L_0x007b:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r6.zze(r1, r0);
        r6.zzjO();
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zzjH():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean zzjI() {
        /*
        r12 = this;
        r1 = 1;
        r2 = 0;
        com.google.android.gms.measurement.zzg.zziS();
        r12.zzje();
        r0 = "Dispatching a batch of local hits";
        r12.zzba(r0);
        r0 = r12.zzPH;
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0032;
    L_0x0015:
        r0 = r12.zziV();
        r0 = r0.zzka();
        if (r0 != 0) goto L_0x0032;
    L_0x001f:
        r0 = r1;
    L_0x0020:
        r3 = r12.zzPF;
        r3 = r3.zzlk();
        if (r3 != 0) goto L_0x0034;
    L_0x0028:
        if (r0 == 0) goto L_0x0036;
    L_0x002a:
        if (r1 == 0) goto L_0x0036;
    L_0x002c:
        r0 = "No network or service available. Will retry later";
        r12.zzba(r0);
    L_0x0031:
        return r2;
    L_0x0032:
        r0 = r2;
        goto L_0x0020;
    L_0x0034:
        r1 = r2;
        goto L_0x0028;
    L_0x0036:
        r0 = r12.zziV();
        r0 = r0.zzkl();
        r1 = r12.zziV();
        r1 = r1.zzkm();
        r0 = java.lang.Math.max(r0, r1);
        r6 = (long) r0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r4 = 0;
    L_0x0052:
        r0 = r12.zzPE;	 Catch:{ all -> 0x01ee }
        r0.beginTransaction();	 Catch:{ all -> 0x01ee }
        r3.clear();	 Catch:{ all -> 0x01ee }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x00d3 }
        r8 = r0.zzp(r6);	 Catch:{ SQLiteException -> 0x00d3 }
        r0 = r8.isEmpty();	 Catch:{ SQLiteException -> 0x00d3 }
        if (r0 == 0) goto L_0x0083;
    L_0x0066:
        r0 = "Store is empty, nothing to dispatch";
        r12.zzba(r0);	 Catch:{ SQLiteException -> 0x00d3 }
        r12.zzjO();	 Catch:{ SQLiteException -> 0x00d3 }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x0079 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0079 }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x0079 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0079 }
        goto L_0x0031;
    L_0x0079:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x0083:
        r0 = "Hits loaded from store. count";
        r1 = r8.size();	 Catch:{ SQLiteException -> 0x00d3 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ SQLiteException -> 0x00d3 }
        r12.zza(r0, r1);	 Catch:{ SQLiteException -> 0x00d3 }
        r1 = r8.iterator();	 Catch:{ all -> 0x01ee }
    L_0x0094:
        r0 = r1.hasNext();	 Catch:{ all -> 0x01ee }
        if (r0 == 0) goto L_0x00f3;
    L_0x009a:
        r0 = r1.next();	 Catch:{ all -> 0x01ee }
        r0 = (com.google.android.gms.analytics.internal.zzab) r0;	 Catch:{ all -> 0x01ee }
        r10 = r0.zzkZ();	 Catch:{ all -> 0x01ee }
        r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0094;
    L_0x00a8:
        r0 = "Database contains successfully uploaded hit";
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x01ee }
        r3 = r8.size();	 Catch:{ all -> 0x01ee }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x01ee }
        r12.zzd(r0, r1, r3);	 Catch:{ all -> 0x01ee }
        r12.zzjO();	 Catch:{ all -> 0x01ee }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x00c8 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00c8 }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x00c8 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00c8 }
        goto L_0x0031;
    L_0x00c8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x00d3:
        r0 = move-exception;
        r1 = "Failed to read hits from persisted store";
        r12.zzd(r1, r0);	 Catch:{ all -> 0x01ee }
        r12.zzjO();	 Catch:{ all -> 0x01ee }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x00e8 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x00e8 }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x00e8 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x00e8 }
        goto L_0x0031;
    L_0x00e8:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x00f3:
        r0 = r12.zzPH;	 Catch:{ all -> 0x01ee }
        r0 = r0.isConnected();	 Catch:{ all -> 0x01ee }
        if (r0 == 0) goto L_0x0205;
    L_0x00fb:
        r0 = r12.zziV();	 Catch:{ all -> 0x01ee }
        r0 = r0.zzka();	 Catch:{ all -> 0x01ee }
        if (r0 != 0) goto L_0x0205;
    L_0x0105:
        r0 = "Service connected, sending hits to the service";
        r12.zzba(r0);	 Catch:{ all -> 0x01ee }
    L_0x010a:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x01ee }
        if (r0 != 0) goto L_0x0205;
    L_0x0110:
        r0 = 0;
        r0 = r8.get(r0);	 Catch:{ all -> 0x01ee }
        r0 = (com.google.android.gms.analytics.internal.zzab) r0;	 Catch:{ all -> 0x01ee }
        r1 = r12.zzPH;	 Catch:{ all -> 0x01ee }
        r1 = r1.zzb(r0);	 Catch:{ all -> 0x01ee }
        if (r1 != 0) goto L_0x0148;
    L_0x011f:
        r0 = r4;
    L_0x0120:
        r4 = r12.zzPF;	 Catch:{ all -> 0x01ee }
        r4 = r4.zzlk();	 Catch:{ all -> 0x01ee }
        if (r4 == 0) goto L_0x0199;
    L_0x0128:
        r4 = r12.zzPF;	 Catch:{ all -> 0x01ee }
        r9 = r4.zzo(r8);	 Catch:{ all -> 0x01ee }
        r10 = r9.iterator();	 Catch:{ all -> 0x01ee }
        r4 = r0;
    L_0x0133:
        r0 = r10.hasNext();	 Catch:{ all -> 0x01ee }
        if (r0 == 0) goto L_0x018d;
    L_0x0139:
        r0 = r10.next();	 Catch:{ all -> 0x01ee }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x01ee }
        r0 = r0.longValue();	 Catch:{ all -> 0x01ee }
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ all -> 0x01ee }
        goto L_0x0133;
    L_0x0148:
        r10 = r0.zzkZ();	 Catch:{ all -> 0x01ee }
        r4 = java.lang.Math.max(r4, r10);	 Catch:{ all -> 0x01ee }
        r8.remove(r0);	 Catch:{ all -> 0x01ee }
        r1 = "Hit sent do device AnalyticsService for delivery";
        r12.zzb(r1, r0);	 Catch:{ all -> 0x01ee }
        r1 = r12.zzPE;	 Catch:{ SQLiteException -> 0x016d }
        r10 = r0.zzkZ();	 Catch:{ SQLiteException -> 0x016d }
        r1.zzq(r10);	 Catch:{ SQLiteException -> 0x016d }
        r0 = r0.zzkZ();	 Catch:{ SQLiteException -> 0x016d }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ SQLiteException -> 0x016d }
        r3.add(r0);	 Catch:{ SQLiteException -> 0x016d }
        goto L_0x010a;
    L_0x016d:
        r0 = move-exception;
        r1 = "Failed to remove hit that was send for delivery";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01ee }
        r12.zzjO();	 Catch:{ all -> 0x01ee }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x0182 }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x0182 }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x0182 }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x0182 }
        goto L_0x0031;
    L_0x0182:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x018d:
        r8.removeAll(r9);	 Catch:{ all -> 0x01ee }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01b6 }
        r0.zzm(r9);	 Catch:{ SQLiteException -> 0x01b6 }
        r3.addAll(r9);	 Catch:{ SQLiteException -> 0x01b6 }
        r0 = r4;
    L_0x0199:
        r4 = r3.isEmpty();	 Catch:{ all -> 0x01ee }
        if (r4 == 0) goto L_0x01d6;
    L_0x019f:
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01ab }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01ab }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01ab }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01ab }
        goto L_0x0031;
    L_0x01ab:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x01b6:
        r0 = move-exception;
        r1 = "Failed to remove successfully uploaded hits";
        r12.zze(r1, r0);	 Catch:{ all -> 0x01ee }
        r12.zzjO();	 Catch:{ all -> 0x01ee }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01cb }
        r0.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01cb }
        r0 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01cb }
        r0.endTransaction();	 Catch:{ SQLiteException -> 0x01cb }
        goto L_0x0031;
    L_0x01cb:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x01d6:
        r4 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01e3 }
        r4.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01e3 }
        r4 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01e3 }
        r4.endTransaction();	 Catch:{ SQLiteException -> 0x01e3 }
        r4 = r0;
        goto L_0x0052;
    L_0x01e3:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x01ee:
        r0 = move-exception;
        r1 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01fa }
        r1.setTransactionSuccessful();	 Catch:{ SQLiteException -> 0x01fa }
        r1 = r12.zzPE;	 Catch:{ SQLiteException -> 0x01fa }
        r1.endTransaction();	 Catch:{ SQLiteException -> 0x01fa }
        throw r0;
    L_0x01fa:
        r0 = move-exception;
        r1 = "Failed to commit local dispatch transaction";
        r12.zze(r1, r0);
        r12.zzjO();
        goto L_0x0031;
    L_0x0205:
        r0 = r4;
        goto L_0x0120;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zzjI():boolean");
    }

    public void zzjJ() {
        zzg.zziS();
        zzje();
        zzbb("Sync dispatching local hits");
        long j = this.zzPM;
        if (!zziV().zzka()) {
            zzjG();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zzjK();
                return;
            }
        } while (zzjI());
        zziY().zzlr();
        zzjK();
        if (this.zzPM != j) {
            this.zzPG.zzlj();
        }
    }

    public void zzjK() {
        zziQ().zziS();
        zzje();
        if (!zzjL()) {
            this.zzPG.unregister();
            zzjO();
        } else if (this.zzPE.isEmpty()) {
            this.zzPG.unregister();
            zzjO();
        } else {
            boolean z;
            if (((Boolean) zzy.zzQY.get()).booleanValue()) {
                z = true;
            } else {
                this.zzPG.zzlh();
                z = this.zzPG.isConnected();
            }
            if (z) {
                zzjN();
                return;
            }
            zzjO();
            zzjM();
        }
    }

    public long zzjR() {
        if (this.zzPI != Long.MIN_VALUE) {
            return this.zzPI;
        }
        return zziq().zzkU() ? ((long) zziq().zzlL()) * 1000 : zziV().zzki();
    }

    public void zzjS() {
        zzje();
        zziS();
        this.zzPN = true;
        this.zzPH.disconnect();
        zzjK();
    }

    public long zzjx() {
        zzg.zziS();
        zzje();
        try {
            return this.zzPE.zzjx();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0;
        }
    }

    public void zzs(long j) {
        zzg.zziS();
        zzje();
        if (j < 0) {
            j = 0;
        }
        this.zzPI = j;
        zzjK();
    }
}
