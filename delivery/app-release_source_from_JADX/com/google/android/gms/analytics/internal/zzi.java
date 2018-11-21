package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import java.util.Collections;

public class zzi extends zzd {
    private final zza zzPn = new zza(this);
    private zzac zzPo;
    private final zzt zzPp;
    private zzaj zzPq;

    protected class zza implements ServiceConnection {
        final /* synthetic */ zzi zzPr;
        private volatile zzac zzPs;
        private volatile boolean zzPt;

        protected zza(zzi com_google_android_gms_analytics_internal_zzi) {
            this.zzPr = com_google_android_gms_analytics_internal_zzi;
        }

        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0008, B:9:0x0015]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.zzx.zzcx(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0014;
        L_0x0008:
            r0 = r4.zzPr;	 Catch:{ all -> 0x005a }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x005a }
            r0.zzbe(r1);	 Catch:{ all -> 0x005a }
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        L_0x0013:
            return;
        L_0x0014:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0051 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0051 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0051 }
            if (r2 == 0) goto L_0x0049;	 Catch:{ RemoteException -> 0x0051 }
        L_0x0021:
            r0 = com.google.android.gms.analytics.internal.zzac.zza.zzaf(r6);	 Catch:{ RemoteException -> 0x0051 }
            r1 = r4.zzPr;	 Catch:{ RemoteException -> 0x0051 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0051 }
            r1.zzba(r2);	 Catch:{ RemoteException -> 0x0051 }
        L_0x002c:
            if (r0 != 0) goto L_0x005f;
        L_0x002e:
            r0 = com.google.android.gms.common.stats.zzb.zzrz();	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r4.zzPr;	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r1.getContext();	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r4.zzPr;	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r2.zzPn;	 Catch:{ IllegalArgumentException -> 0x007c }
            r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x007c }
        L_0x0041:
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            goto L_0x0013;	 Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception;	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            r2 = r4.zzPr;	 Catch:{ RemoteException -> 0x0051 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0051 }
            r2.zze(r3, r1);	 Catch:{ RemoteException -> 0x0051 }
            goto L_0x002c;
        L_0x0051:
            r1 = move-exception;
            r1 = r4.zzPr;	 Catch:{ all -> 0x005a }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005a }
            r1.zzbe(r2);	 Catch:{ all -> 0x005a }
            goto L_0x002c;
        L_0x005a:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            throw r0;	 Catch:{ all -> 0x0046 }
        L_0x005f:
            r1 = r4.zzPt;	 Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0079;	 Catch:{ all -> 0x005a }
        L_0x0063:
            r1 = r4.zzPr;	 Catch:{ all -> 0x005a }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005a }
            r1.zzbd(r2);	 Catch:{ all -> 0x005a }
            r1 = r4.zzPr;	 Catch:{ all -> 0x005a }
            r1 = r1.zziW();	 Catch:{ all -> 0x005a }
            r2 = new com.google.android.gms.analytics.internal.zzi$zza$1;	 Catch:{ all -> 0x005a }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x005a }
            r1.zzf(r2);	 Catch:{ all -> 0x005a }
            goto L_0x0041;	 Catch:{ all -> 0x005a }
        L_0x0079:
            r4.zzPs = r0;	 Catch:{ all -> 0x005a }
            goto L_0x0041;
        L_0x007c:
            r0 = move-exception;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(final ComponentName name) {
            zzx.zzcx("AnalyticsServiceConnection.onServiceDisconnected");
            this.zzPr.zziW().zzf(new Runnable(this) {
                final /* synthetic */ zza zzPv;

                public void run() {
                    this.zzPv.zzPr.onServiceDisconnected(name);
                }
            });
        }

        public zzac zzjt() {
            zzac com_google_android_gms_analytics_internal_zzac = null;
            this.zzPr.zziS();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = this.zzPr.getContext();
            intent.putExtra("app_package_name", context.getPackageName());
            zzb zzrz = zzb.zzrz();
            synchronized (this) {
                this.zzPs = null;
                this.zzPt = true;
                boolean zza = zzrz.zza(context, intent, this.zzPr.zzPn, 129);
                this.zzPr.zza("Bind to service requested", Boolean.valueOf(zza));
                if (zza) {
                    try {
                        wait(this.zzPr.zziV().zzkw());
                    } catch (InterruptedException e) {
                        this.zzPr.zzbd("Wait for service connect was interrupted");
                    }
                    this.zzPt = false;
                    com_google_android_gms_analytics_internal_zzac = this.zzPs;
                    this.zzPs = null;
                    if (com_google_android_gms_analytics_internal_zzac == null) {
                        this.zzPr.zzbe("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.zzPt = false;
                }
            }
            return com_google_android_gms_analytics_internal_zzac;
        }
    }

    protected zzi(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.zzPq = new zzaj(com_google_android_gms_analytics_internal_zzf.zziT());
        this.zzPp = new zzt(this, com_google_android_gms_analytics_internal_zzf) {
            final /* synthetic */ zzi zzPr;

            public void run() {
                this.zzPr.zzjs();
            }
        };
    }

    private void onDisconnect() {
        zzip().zziN();
    }

    private void onServiceDisconnected(ComponentName name) {
        zziS();
        if (this.zzPo != null) {
            this.zzPo = null;
            zza("Disconnected from device AnalyticsService", name);
            onDisconnect();
        }
    }

    private void zza(zzac com_google_android_gms_analytics_internal_zzac) {
        zziS();
        this.zzPo = com_google_android_gms_analytics_internal_zzac;
        zzjr();
        zzip().onServiceConnected();
    }

    private void zzjr() {
        this.zzPq.start();
        this.zzPp.zzt(zziV().zzkv());
    }

    private void zzjs() {
        zziS();
        if (isConnected()) {
            zzba("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public boolean connect() {
        zziS();
        zzje();
        if (this.zzPo != null) {
            return true;
        }
        zzac zzjt = this.zzPn.zzjt();
        if (zzjt == null) {
            return false;
        }
        this.zzPo = zzjt;
        zzjr();
        return true;
    }

    public void disconnect() {
        zziS();
        zzje();
        try {
            zzb.zzrz().zza(getContext(), this.zzPn);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.zzPo != null) {
            this.zzPo = null;
            onDisconnect();
        }
    }

    public boolean isConnected() {
        zziS();
        zzje();
        return this.zzPo != null;
    }

    public boolean zzb(zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzab);
        zziS();
        zzje();
        zzac com_google_android_gms_analytics_internal_zzac = this.zzPo;
        if (com_google_android_gms_analytics_internal_zzac == null) {
            return false;
        }
        try {
            com_google_android_gms_analytics_internal_zzac.zza(com_google_android_gms_analytics_internal_zzab.zzn(), com_google_android_gms_analytics_internal_zzab.zzla(), com_google_android_gms_analytics_internal_zzab.zzlc() ? zziV().zzko() : zziV().zzkp(), Collections.emptyList());
            zzjr();
            return true;
        } catch (RemoteException e) {
            zzba("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    protected void zzir() {
    }

    public boolean zzjq() {
        zziS();
        zzje();
        zzac com_google_android_gms_analytics_internal_zzac = this.zzPo;
        if (com_google_android_gms_analytics_internal_zzac == null) {
            return false;
        }
        try {
            com_google_android_gms_analytics_internal_zzac.zziK();
            zzjr();
            return true;
        } catch (RemoteException e) {
            zzba("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
