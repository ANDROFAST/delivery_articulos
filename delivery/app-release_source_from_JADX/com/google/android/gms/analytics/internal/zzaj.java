package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

class zzaj {
    private long zzBv;
    private final zznl zzqD;

    public zzaj(zznl com_google_android_gms_internal_zznl) {
        zzx.zzy(com_google_android_gms_internal_zznl);
        this.zzqD = com_google_android_gms_internal_zznl;
    }

    public zzaj(zznl com_google_android_gms_internal_zznl, long j) {
        zzx.zzy(com_google_android_gms_internal_zznl);
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzBv = j;
    }

    public void clear() {
        this.zzBv = 0;
    }

    public void start() {
        this.zzBv = this.zzqD.elapsedRealtime();
    }

    public boolean zzv(long j) {
        return this.zzBv == 0 || this.zzqD.elapsedRealtime() - this.zzBv > j;
    }
}
