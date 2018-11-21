package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.WeakHashMap;

@zzha
public final class zzhj {
    private WeakHashMap<Context, zza> zzIW = new WeakHashMap();

    private class zza {
        public final long zzIX = zzp.zzbB().currentTimeMillis();
        public final zzhi zzIY;
        final /* synthetic */ zzhj zzIZ;

        public zza(zzhj com_google_android_gms_internal_zzhj, zzhi com_google_android_gms_internal_zzhi) {
            this.zzIZ = com_google_android_gms_internal_zzhj;
            this.zzIY = com_google_android_gms_internal_zzhi;
        }

        public boolean hasExpired() {
            return ((Long) zzbz.zzwr.get()).longValue() + this.zzIX < zzp.zzbB().currentTimeMillis();
        }
    }

    public zzhi zzE(Context context) {
        zza com_google_android_gms_internal_zzhj_zza = (zza) this.zzIW.get(context);
        zzhi zzgv = (com_google_android_gms_internal_zzhj_zza == null || com_google_android_gms_internal_zzhj_zza.hasExpired() || !((Boolean) zzbz.zzwq.get()).booleanValue()) ? new com.google.android.gms.internal.zzhi.zza(context).zzgv() : new com.google.android.gms.internal.zzhi.zza(context, com_google_android_gms_internal_zzhj_zza.zzIY).zzgv();
        this.zzIW.put(context, new zza(this, zzgv));
        return zzgv;
    }
}
