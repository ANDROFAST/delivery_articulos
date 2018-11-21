package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.List;
import java.util.Map;

class zzx extends zzdd {
    private static final String ID = zzad.DATA_LAYER_WRITE.toString();
    private static final String VALUE = zzae.VALUE.toString();
    private static final String zzbdE = zzae.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzbcG;

    public zzx(DataLayer dataLayer) {
        super(ID, VALUE);
        this.zzbcG = dataLayer;
    }

    private void zza(zza com_google_android_gms_internal_zzag_zza) {
        if (com_google_android_gms_internal_zzag_zza != null && com_google_android_gms_internal_zzag_zza != zzdf.zzFD()) {
            String zzg = zzdf.zzg(com_google_android_gms_internal_zzag_zza);
            if (zzg != zzdf.zzFI()) {
                this.zzbcG.zzfj(zzg);
            }
        }
    }

    private void zzb(zza com_google_android_gms_internal_zzag_zza) {
        if (com_google_android_gms_internal_zzag_zza != null && com_google_android_gms_internal_zzag_zza != zzdf.zzFD()) {
            Object zzl = zzdf.zzl(com_google_android_gms_internal_zzag_zza);
            if (zzl instanceof List) {
                for (Object zzl2 : (List) zzl2) {
                    if (zzl2 instanceof Map) {
                        this.zzbcG.push((Map) zzl2);
                    }
                }
            }
        }
    }

    public void zzK(Map<String, zza> map) {
        zzb((zza) map.get(VALUE));
        zza((zza) map.get(zzbdE));
    }
}
