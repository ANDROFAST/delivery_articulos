package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

class zza {
    final String zzRl;
    final String zzaRd;
    final String zzaSe;
    final String zzaSf;
    final String zzaSg;
    final long zzaSh;
    final long zzaSi;
    final String zzaSj;
    final long zzaSk;
    final long zzaSl;
    final boolean zzaSm;

    zza(String str, String str2, String str3, String str4, long j, long j2, String str5, String str6, long j3, long j4, boolean z) {
        zzx.zzcG(str);
        zzx.zzab(j >= 0);
        this.zzaRd = str;
        this.zzaSe = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = null;
        }
        this.zzaSf = str3;
        this.zzaSg = str4;
        this.zzaSh = j;
        this.zzaSi = j2;
        this.zzRl = str5;
        this.zzaSj = str6;
        this.zzaSk = j3;
        this.zzaSl = j4;
        this.zzaSm = z;
    }

    public zza zzJ(String str, String str2) {
        return new zza(this.zzaRd, str, this.zzaSf, str2, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, this.zzaSk, this.zzaSl, this.zzaSm);
    }

    public zza zzK(String str, String str2) {
        return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, this.zzaSh, this.zzaSi, str, str2, this.zzaSk, this.zzaSl, this.zzaSm);
    }

    public zza zzO(long j) {
        return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, this.zzaSk, j, this.zzaSm);
    }

    public zza zza(zzo com_google_android_gms_measurement_internal_zzo, long j) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzo);
        long j2 = this.zzaSh + 1;
        if (j2 > 2147483647L) {
            com_google_android_gms_measurement_internal_zzo.zzBm().zzez("Bundle index overflow");
            j2 = 0;
        }
        return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, j2, j, this.zzRl, this.zzaSj, this.zzaSk, this.zzaSl, this.zzaSm);
    }

    public zza zzao(boolean z) {
        return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, this.zzaSk, this.zzaSl, z);
    }

    public zza zze(String str, long j) {
        return new zza(this.zzaRd, this.zzaSe, str, this.zzaSg, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, j, this.zzaSl, this.zzaSm);
    }
}
