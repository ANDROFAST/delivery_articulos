package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
class zzjf {
    private final Object zzLS = new Object();
    private final List<Runnable> zzLT = new ArrayList();
    private final List<Runnable> zzLU = new ArrayList();
    private boolean zzLV = false;

    private void zzd(Runnable runnable) {
        zzio.zza(runnable);
    }

    private void zze(Runnable runnable) {
        zza.zzLE.post(runnable);
    }

    public void zzb(Runnable runnable) {
        synchronized (this.zzLS) {
            if (this.zzLV) {
                zzd(runnable);
            } else {
                this.zzLT.add(runnable);
            }
        }
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzLS) {
            if (this.zzLV) {
                zze(runnable);
            } else {
                this.zzLU.add(runnable);
            }
        }
    }

    public void zzht() {
        synchronized (this.zzLS) {
            if (this.zzLV) {
                return;
            }
            for (Runnable zzd : this.zzLT) {
                zzd(zzd);
            }
            for (Runnable zzd2 : this.zzLU) {
                zze(zzd2);
            }
            this.zzLT.clear();
            this.zzLU.clear();
            this.zzLV = true;
        }
    }
}
