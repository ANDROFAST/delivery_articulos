package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zze extends zzak {
    private static final String ID = zzad.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzbcw = zzae.COMPONENT.toString();
    private static final String zzbcx = zzae.CONVERSION_ID.toString();
    private final Context context;

    public zze(Context context) {
        super(ID, zzbcx);
        this.context = context;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbcx);
        if (com_google_android_gms_internal_zzag_zza == null) {
            return zzdf.zzFJ();
        }
        String zzg = zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbcw);
        String zzf = zzax.zzf(this.context, zzg, com_google_android_gms_internal_zzag_zza != null ? zzdf.zzg(com_google_android_gms_internal_zzag_zza) : null);
        return zzf != null ? zzdf.zzR(zzf) : zzdf.zzFJ();
    }
}
