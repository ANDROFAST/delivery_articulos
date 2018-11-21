package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzc {
    private final zzf zzaRk;
    private boolean zzaRl;
    private long zzaRm;
    private long zzaRn;
    private long zzaRo;
    private long zzaRp;
    private long zzaRq;
    private boolean zzaRr;
    private final Map<Class<? extends zze>, zze> zzaRs;
    private final List<zzi> zzaRt;
    private final zznl zzqD;

    zzc(zzc com_google_android_gms_measurement_zzc) {
        this.zzaRk = com_google_android_gms_measurement_zzc.zzaRk;
        this.zzqD = com_google_android_gms_measurement_zzc.zzqD;
        this.zzaRm = com_google_android_gms_measurement_zzc.zzaRm;
        this.zzaRn = com_google_android_gms_measurement_zzc.zzaRn;
        this.zzaRo = com_google_android_gms_measurement_zzc.zzaRo;
        this.zzaRp = com_google_android_gms_measurement_zzc.zzaRp;
        this.zzaRq = com_google_android_gms_measurement_zzc.zzaRq;
        this.zzaRt = new ArrayList(com_google_android_gms_measurement_zzc.zzaRt);
        this.zzaRs = new HashMap(com_google_android_gms_measurement_zzc.zzaRs.size());
        for (Entry entry : com_google_android_gms_measurement_zzc.zzaRs.entrySet()) {
            zze zzf = zzf((Class) entry.getKey());
            ((zze) entry.getValue()).zza(zzf);
            this.zzaRs.put(entry.getKey(), zzf);
        }
    }

    zzc(zzf com_google_android_gms_measurement_zzf, zznl com_google_android_gms_internal_zznl) {
        zzx.zzy(com_google_android_gms_measurement_zzf);
        zzx.zzy(com_google_android_gms_internal_zznl);
        this.zzaRk = com_google_android_gms_measurement_zzf;
        this.zzqD = com_google_android_gms_internal_zznl;
        this.zzaRp = 1800000;
        this.zzaRq = 3024000000L;
        this.zzaRs = new HashMap();
        this.zzaRt = new ArrayList();
    }

    private static <T extends zze> T zzf(Class<T> cls) {
        try {
            return (zze) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public void zzM(long j) {
        this.zzaRn = j;
    }

    public void zzb(zze com_google_android_gms_measurement_zze) {
        zzx.zzy(com_google_android_gms_measurement_zze);
        Class cls = com_google_android_gms_measurement_zze.getClass();
        if (cls.getSuperclass() != zze.class) {
            throw new IllegalArgumentException();
        }
        com_google_android_gms_measurement_zze.zza(zze(cls));
    }

    public <T extends zze> T zzd(Class<T> cls) {
        return (zze) this.zzaRs.get(cls);
    }

    public <T extends zze> T zze(Class<T> cls) {
        zze com_google_android_gms_measurement_zze = (zze) this.zzaRs.get(cls);
        if (com_google_android_gms_measurement_zze != null) {
            return com_google_android_gms_measurement_zze;
        }
        T zzf = zzf(cls);
        this.zzaRs.put(cls, zzf);
        return zzf;
    }

    public zzc zzzE() {
        return new zzc(this);
    }

    public Collection<zze> zzzF() {
        return this.zzaRs.values();
    }

    public List<zzi> zzzG() {
        return this.zzaRt;
    }

    public long zzzH() {
        return this.zzaRm;
    }

    public void zzzI() {
        zzzM().zze(this);
    }

    public boolean zzzJ() {
        return this.zzaRl;
    }

    void zzzK() {
        this.zzaRo = this.zzqD.elapsedRealtime();
        if (this.zzaRn != 0) {
            this.zzaRm = this.zzaRn;
        } else {
            this.zzaRm = this.zzqD.currentTimeMillis();
        }
        this.zzaRl = true;
    }

    zzf zzzL() {
        return this.zzaRk;
    }

    zzg zzzM() {
        return this.zzaRk.zzzM();
    }

    boolean zzzN() {
        return this.zzaRr;
    }

    void zzzO() {
        this.zzaRr = true;
    }
}
