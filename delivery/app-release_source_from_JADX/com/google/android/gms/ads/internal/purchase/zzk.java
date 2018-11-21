package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzha;

@zzha
public class zzk {
    private final String zzux;

    public zzk(String str) {
        this.zzux = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String zze = zzp.zzbH().zze(intent);
        String zzf = zzp.zzbH().zzf(intent);
        if (zze == null || zzf == null) {
            return false;
        }
        if (!str.equals(zzp.zzbH().zzap(zze))) {
            zzb.zzaH("Developer payload not match.");
            return false;
        } else if (this.zzux == null || zzl.zzc(this.zzux, zze, zzf)) {
            return true;
        } else {
            zzb.zzaH("Fail to verify signature.");
            return false;
        }
    }

    public String zzfN() {
        return zzp.zzbx().zzha();
    }
}
