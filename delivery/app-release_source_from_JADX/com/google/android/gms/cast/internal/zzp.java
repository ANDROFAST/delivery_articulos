package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzYy = new zzl("RequestTracker");
    public static final Object zzacU = new Object();
    private long zzabr = -1;
    private long zzacR;
    private long zzacS = 0;
    private zzo zzacT;

    public zzp(long j) {
        this.zzacR = j;
    }

    private void zzoh() {
        this.zzabr = -1;
        this.zzacT = null;
        this.zzacS = 0;
    }

    public void clear() {
        synchronized (zzacU) {
            if (this.zzabr != -1) {
                zzoh();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzacU) {
            z = this.zzabr != -1 && this.zzabr == j;
        }
        return z;
    }

    public void zza(long j, zzo com_google_android_gms_cast_internal_zzo) {
        synchronized (zzacU) {
            zzo com_google_android_gms_cast_internal_zzo2 = this.zzacT;
            long j2 = this.zzabr;
            this.zzabr = j;
            this.zzacT = com_google_android_gms_cast_internal_zzo;
            this.zzacS = SystemClock.elapsedRealtime();
        }
        if (com_google_android_gms_cast_internal_zzo2 != null) {
            com_google_android_gms_cast_internal_zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo com_google_android_gms_cast_internal_zzo = null;
        synchronized (zzacU) {
            if (this.zzabr == -1 || this.zzabr != j) {
                z = false;
            } else {
                zzYy.zzb("request %d completed", Long.valueOf(this.zzabr));
                com_google_android_gms_cast_internal_zzo = this.zzacT;
                zzoh();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo com_google_android_gms_cast_internal_zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzacU) {
            if (this.zzabr == -1 || j - this.zzacS < this.zzacR) {
                z = false;
                com_google_android_gms_cast_internal_zzo = null;
            } else {
                zzYy.zzb("request %d timed out", Long.valueOf(this.zzabr));
                j2 = this.zzabr;
                com_google_android_gms_cast_internal_zzo = this.zzacT;
                zzoh();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzoi() {
        boolean z;
        synchronized (zzacU) {
            z = this.zzabr != -1;
        }
        return z;
    }
}
