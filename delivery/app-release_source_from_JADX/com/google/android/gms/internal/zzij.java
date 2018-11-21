package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzij {
    private final String zzJO;
    private int zzKq;
    private int zzKr;
    private final Object zzpK;
    private final zzig zzqC;

    zzij(zzig com_google_android_gms_internal_zzig, String str) {
        this.zzpK = new Object();
        this.zzqC = com_google_android_gms_internal_zzig;
        this.zzJO = str;
    }

    public zzij(String str) {
        this(zzp.zzbA(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzpK) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzKq);
            bundle.putInt("pmnll", this.zzKr);
        }
        return bundle;
    }

    public void zzg(int i, int i2) {
        synchronized (this.zzpK) {
            this.zzKq = i;
            this.zzKr = i2;
            this.zzqC.zza(this.zzJO, this);
        }
    }
}
