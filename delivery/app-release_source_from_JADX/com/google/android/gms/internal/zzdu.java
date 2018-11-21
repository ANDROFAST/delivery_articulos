package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzdu extends zzil {
    final zzjn zzps;
    final zzdw zzzj;
    private final String zzzk;

    class C02811 implements Runnable {
        final /* synthetic */ zzdu zzzl;

        C02811(zzdu com_google_android_gms_internal_zzdu) {
            this.zzzl = com_google_android_gms_internal_zzdu;
        }

        public void run() {
            zzp.zzbL().zzb(this.zzzl);
        }
    }

    zzdu(zzjn com_google_android_gms_internal_zzjn, zzdw com_google_android_gms_internal_zzdw, String str) {
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzzj = com_google_android_gms_internal_zzdw;
        this.zzzk = str;
        zzp.zzbL().zza(this);
    }

    public void onStop() {
        this.zzzj.abort();
    }

    public void zzbp() {
        try {
            this.zzzj.zzZ(this.zzzk);
        } finally {
            zzip.zzKO.post(new C02811(this));
        }
    }
}
