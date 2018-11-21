package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;

class zzaa {
    private long zzBv;
    private final zznl zzqD;

    public zzaa(zznl com_google_android_gms_internal_zznl) {
        zzx.zzy(com_google_android_gms_internal_zznl);
        this.zzqD = com_google_android_gms_internal_zznl;
    }

    public void clear() {
        this.zzBv = 0;
    }

    public void start() {
        this.zzBv = this.zzqD.elapsedRealtime();
    }

    public boolean zzv(long j) {
        return this.zzBv == 0 || this.zzqD.elapsedRealtime() - this.zzBv >= j;
    }
}
