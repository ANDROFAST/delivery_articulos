package com.google.android.gms.internal;

import com.google.android.gms.internal.zzey.zza;

@zzha
public final class zzep extends zza {
    private zzer.zza zzBb;
    private zzeo zzBc;
    private final Object zzpK = new Object();

    public void onAdClicked() {
        synchronized (this.zzpK) {
            if (this.zzBc != null) {
                this.zzBc.zzaZ();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zzpK) {
            if (this.zzBc != null) {
                this.zzBc.zzba();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.zzpK) {
            if (this.zzBb != null) {
                this.zzBb.zzr(error == 3 ? 1 : 2);
                this.zzBb = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zzpK) {
            if (this.zzBc != null) {
                this.zzBc.zzbb();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.zzpK;
        monitor-enter(r1);
        r0 = r3.zzBb;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.zzBb;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zzr(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.zzBb = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.zzBc;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.zzBc;	 Catch:{ all -> 0x001d }
        r0.zzbd();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzep.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.zzpK) {
            if (this.zzBc != null) {
                this.zzBc.zzbc();
            }
        }
    }

    public void zza(zzeo com_google_android_gms_internal_zzeo) {
        synchronized (this.zzpK) {
            this.zzBc = com_google_android_gms_internal_zzeo;
        }
    }

    public void zza(zzer.zza com_google_android_gms_internal_zzer_zza) {
        synchronized (this.zzpK) {
            this.zzBb = com_google_android_gms_internal_zzer_zza;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.internal.zzez r4) {
        /*
        r3 = this;
        r1 = r3.zzpK;
        monitor-enter(r1);
        r0 = r3.zzBb;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.zzBb;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zza(r2, r4);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.zzBb = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.zzBc;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.zzBc;	 Catch:{ all -> 0x001d }
        r0.zzbd();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzep.zza(com.google.android.gms.internal.zzez):void");
    }
}
