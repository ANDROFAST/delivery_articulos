package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@zzha
public class zzet implements zzel {
    private final Context mContext;
    private final zzen zzBf;
    private final AdRequestInfoParcel zzBu;
    private final long zzBv;
    private final long zzBw;
    private final int zzBx;
    private boolean zzBy = false;
    private final Map<zzje<zzer>, zzeq> zzBz = new HashMap();
    private final Object zzpK = new Object();
    private final zzew zzpd;
    private final boolean zzrF;

    public zzet(Context context, AdRequestInfoParcel adRequestInfoParcel, zzew com_google_android_gms_internal_zzew, zzen com_google_android_gms_internal_zzen, boolean z, long j, long j2, int i) {
        this.mContext = context;
        this.zzBu = adRequestInfoParcel;
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzBf = com_google_android_gms_internal_zzen;
        this.zzrF = z;
        this.zzBv = j;
        this.zzBw = j2;
        this.zzBx = i;
    }

    private void zza(final zzje<zzer> com_google_android_gms_internal_zzje_com_google_android_gms_internal_zzer) {
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzet zzBB;

            public void run() {
                for (zzje com_google_android_gms_internal_zzje : this.zzBB.zzBz.keySet()) {
                    if (com_google_android_gms_internal_zzje != com_google_android_gms_internal_zzje_com_google_android_gms_internal_zzer) {
                        ((zzeq) this.zzBB.zzBz.get(com_google_android_gms_internal_zzje)).cancel();
                    }
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzer zzd(java.util.List<com.google.android.gms.internal.zzje<com.google.android.gms.internal.zzer>> r5) {
        /*
        r4 = this;
        r2 = r4.zzpK;
        monitor-enter(r2);
        r0 = r4.zzBy;	 Catch:{ all -> 0x0037 }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r1 = new com.google.android.gms.internal.zzer;	 Catch:{ all -> 0x0037 }
        r0 = -1;
        r1.<init>(r0);	 Catch:{ all -> 0x0037 }
        monitor-exit(r2);	 Catch:{ all -> 0x0037 }
    L_0x000e:
        return r1;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x0037 }
        r2 = r5.iterator();
    L_0x0014:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x003a;
    L_0x001a:
        r0 = r2.next();
        r0 = (com.google.android.gms.internal.zzje) r0;
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
        r1 = (com.google.android.gms.internal.zzer) r1;	 Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
        if (r1 == 0) goto L_0x0014;
    L_0x0028:
        r3 = r1.zzBo;	 Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
        if (r3 != 0) goto L_0x0014;
    L_0x002c:
        r4.zza(r0);	 Catch:{ InterruptedException -> 0x0030, ExecutionException -> 0x0045 }
        goto L_0x000e;
    L_0x0030:
        r0 = move-exception;
    L_0x0031:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.ads.internal.util.client.zzb.zzd(r1, r0);
        goto L_0x0014;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0037 }
        throw r0;
    L_0x003a:
        r0 = 0;
        r4.zza(r0);
        r1 = new com.google.android.gms.internal.zzer;
        r0 = 1;
        r1.<init>(r0);
        goto L_0x000e;
    L_0x0045:
        r0 = move-exception;
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzet.zzd(java.util.List):com.google.android.gms.internal.zzer");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.internal.zzer zze(java.util.List<com.google.android.gms.internal.zzje<com.google.android.gms.internal.zzer>> r16) {
        /*
        r15 = this;
        r1 = r15.zzpK;
        monitor-enter(r1);
        r0 = r15.zzBy;	 Catch:{ all -> 0x007b }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r2 = new com.google.android.gms.internal.zzer;	 Catch:{ all -> 0x007b }
        r0 = -1;
        r2.<init>(r0);	 Catch:{ all -> 0x007b }
        monitor-exit(r1);	 Catch:{ all -> 0x007b }
    L_0x000e:
        return r2;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x007b }
        r4 = -1;
        r3 = 0;
        r2 = 0;
        r0 = r15.zzBf;
        r0 = r0.zzAY;
        r6 = -1;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x007e;
    L_0x001d:
        r0 = r15.zzBf;
        r0 = r0.zzAY;
    L_0x0021:
        r8 = r16.iterator();
        r6 = r0;
    L_0x0026:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b4;
    L_0x002c:
        r0 = r8.next();
        r0 = (com.google.android.gms.internal.zzje) r0;
        r1 = com.google.android.gms.ads.internal.zzp.zzbB();
        r10 = r1.currentTimeMillis();
        r12 = 0;
        r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x0081;
    L_0x0040:
        r1 = r0.isDone();	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        if (r1 == 0) goto L_0x0081;
    L_0x0046:
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        r1 = (com.google.android.gms.internal.zzer) r1;	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
    L_0x004c:
        if (r1 == 0) goto L_0x00c7;
    L_0x004e:
        r5 = r1.zzBo;	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        if (r5 != 0) goto L_0x00c7;
    L_0x0052:
        r5 = r1.zzBt;	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        if (r5 == 0) goto L_0x00c7;
    L_0x0056:
        r9 = r5.zzes();	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        if (r9 <= r4) goto L_0x00c7;
    L_0x005c:
        r2 = r5.zzes();	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x0063:
        r3 = com.google.android.gms.ads.internal.zzp.zzbB();
        r4 = r3.currentTimeMillis();
        r4 = r4 - r10;
        r4 = r6 - r4;
        r6 = 0;
        r4 = java.lang.Math.max(r4, r6);
        r3 = r1;
        r14 = r0;
        r0 = r4;
        r4 = r2;
        r2 = r14;
    L_0x0079:
        r6 = r0;
        goto L_0x0026;
    L_0x007b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007b }
        throw r0;
    L_0x007e:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        goto L_0x0021;
    L_0x0081:
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        r1 = r0.get(r6, r1);	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        r1 = (com.google.android.gms.internal.zzer) r1;	 Catch:{ InterruptedException -> 0x008a, ExecutionException -> 0x00c3, RemoteException -> 0x00c5, TimeoutException -> 0x00c1 }
        goto L_0x004c;
    L_0x008a:
        r0 = move-exception;
    L_0x008b:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.ads.internal.util.client.zzb.zzd(r1, r0);	 Catch:{ all -> 0x00a2 }
        r0 = com.google.android.gms.ads.internal.zzp.zzbB();
        r0 = r0.currentTimeMillis();
        r0 = r0 - r10;
        r0 = r6 - r0;
        r6 = 0;
        r0 = java.lang.Math.max(r0, r6);
        goto L_0x0079;
    L_0x00a2:
        r0 = move-exception;
        r1 = com.google.android.gms.ads.internal.zzp.zzbB();
        r2 = r1.currentTimeMillis();
        r2 = r2 - r10;
        r2 = r6 - r2;
        r4 = 0;
        java.lang.Math.max(r2, r4);
        throw r0;
    L_0x00b4:
        r15.zza(r3);
        if (r2 != 0) goto L_0x000e;
    L_0x00b9:
        r2 = new com.google.android.gms.internal.zzer;
        r0 = 1;
        r2.<init>(r0);
        goto L_0x000e;
    L_0x00c1:
        r0 = move-exception;
        goto L_0x008b;
    L_0x00c3:
        r0 = move-exception;
        goto L_0x008b;
    L_0x00c5:
        r0 = move-exception;
        goto L_0x008b;
    L_0x00c7:
        r0 = r2;
        r1 = r3;
        r2 = r4;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzet.zze(java.util.List):com.google.android.gms.internal.zzer");
    }

    public void cancel() {
        synchronized (this.zzpK) {
            this.zzBy = true;
            for (zzeq cancel : this.zzBz.values()) {
                cancel.cancel();
            }
        }
    }

    public zzer zzc(List<zzem> list) {
        zzb.zzaF("Starting mediation.");
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        List arrayList = new ArrayList();
        for (zzem com_google_android_gms_internal_zzem : list) {
            zzb.zzaG("Trying mediation network: " + com_google_android_gms_internal_zzem.zzAF);
            for (String com_google_android_gms_internal_zzeq : com_google_android_gms_internal_zzem.zzAG) {
                final zzeq com_google_android_gms_internal_zzeq2 = new zzeq(this.mContext, com_google_android_gms_internal_zzeq, this.zzpd, this.zzBf, com_google_android_gms_internal_zzem, this.zzBu.zzGq, this.zzBu.zzqV, this.zzBu.zzqR, this.zzrF, this.zzBu.zzrj, this.zzBu.zzrl);
                zzje zza = zzio.zza(newCachedThreadPool, new Callable<zzer>(this) {
                    final /* synthetic */ zzet zzBB;

                    public /* synthetic */ Object call() throws Exception {
                        return zzet();
                    }

                    public zzer zzet() throws Exception {
                        synchronized (this.zzBB.zzpK) {
                            if (this.zzBB.zzBy) {
                                return null;
                            }
                            return com_google_android_gms_internal_zzeq2.zza(this.zzBB.zzBv, this.zzBB.zzBw);
                        }
                    }
                });
                this.zzBz.put(zza, com_google_android_gms_internal_zzeq2);
                arrayList.add(zza);
            }
        }
        switch (this.zzBx) {
            case 2:
                return zze(arrayList);
            default:
                return zzd(arrayList);
        }
    }
}
