package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.util.ArrayList;
import java.util.List;

public abstract class zzf<T extends zzf> {
    private final zzg zzaRu;
    protected final zzc zzaRv;
    private final List<zzd> zzaRw = new ArrayList();

    protected zzf(zzg com_google_android_gms_measurement_zzg, zznl com_google_android_gms_internal_zznl) {
        zzx.zzy(com_google_android_gms_measurement_zzg);
        this.zzaRu = com_google_android_gms_measurement_zzg;
        zzc com_google_android_gms_measurement_zzc = new zzc(this, com_google_android_gms_internal_zznl);
        com_google_android_gms_measurement_zzc.zzzO();
        this.zzaRv = com_google_android_gms_measurement_zzc;
    }

    protected void zza(zzc com_google_android_gms_measurement_zzc) {
    }

    protected void zzd(zzc com_google_android_gms_measurement_zzc) {
        for (zzd zza : this.zzaRw) {
            zza.zza(this, com_google_android_gms_measurement_zzc);
        }
    }

    public zzc zzig() {
        zzc zzzE = this.zzaRv.zzzE();
        zzd(zzzE);
        return zzzE;
    }

    protected zzg zzzM() {
        return this.zzaRu;
    }

    public zzc zzzP() {
        return this.zzaRv;
    }

    public List<zzi> zzzQ() {
        return this.zzaRv.zzzG();
    }
}
