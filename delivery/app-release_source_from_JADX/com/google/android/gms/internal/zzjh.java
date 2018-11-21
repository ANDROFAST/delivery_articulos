package com.google.android.gms.internal;

import com.google.android.gms.internal.zzjg.zzc;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzha
public class zzjh<T> implements zzjg<T> {
    protected int zzAk = 0;
    protected final BlockingQueue<zza> zzLW = new LinkedBlockingQueue();
    protected T zzLX;
    private final Object zzpK = new Object();

    class zza {
        public final zzc<T> zzLY;
        public final com.google.android.gms.internal.zzjg.zza zzLZ;
        final /* synthetic */ zzjh zzMa;

        public zza(zzjh com_google_android_gms_internal_zzjh, zzc<T> com_google_android_gms_internal_zzjg_zzc_T, com.google.android.gms.internal.zzjg.zza com_google_android_gms_internal_zzjg_zza) {
            this.zzMa = com_google_android_gms_internal_zzjh;
            this.zzLY = com_google_android_gms_internal_zzjg_zzc_T;
            this.zzLZ = com_google_android_gms_internal_zzjg_zza;
        }
    }

    public int getStatus() {
        return this.zzAk;
    }

    public void reject() {
        synchronized (this.zzpK) {
            if (this.zzAk != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzAk = -1;
            for (zza com_google_android_gms_internal_zzjh_zza : this.zzLW) {
                com_google_android_gms_internal_zzjh_zza.zzLZ.run();
            }
            this.zzLW.clear();
        }
    }

    public void zza(zzc<T> com_google_android_gms_internal_zzjg_zzc_T, com.google.android.gms.internal.zzjg.zza com_google_android_gms_internal_zzjg_zza) {
        synchronized (this.zzpK) {
            if (this.zzAk == 1) {
                com_google_android_gms_internal_zzjg_zzc_T.zzc(this.zzLX);
            } else if (this.zzAk == -1) {
                com_google_android_gms_internal_zzjg_zza.run();
            } else if (this.zzAk == 0) {
                this.zzLW.add(new zza(this, com_google_android_gms_internal_zzjg_zzc_T, com_google_android_gms_internal_zzjg_zza));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzpK) {
            if (this.zzAk != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzLX = t;
            this.zzAk = 1;
            for (zza com_google_android_gms_internal_zzjh_zza : this.zzLW) {
                com_google_android_gms_internal_zzjh_zza.zzLY.zzc(t);
            }
            this.zzLW.clear();
        }
    }
}
