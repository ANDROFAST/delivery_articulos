package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.Set;

public abstract class zzca extends zzak {
    private static final String zzbdJ = zzae.ARG0.toString();
    private static final String zzbeH = zzae.ARG1.toString();

    public zzca(String str) {
        super(str, zzbdJ, zzbeH);
    }

    public /* bridge */ /* synthetic */ String zzEF() {
        return super.zzEF();
    }

    public /* bridge */ /* synthetic */ Set zzEG() {
        return super.zzEG();
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        for (zza com_google_android_gms_internal_zzag_zza : map.values()) {
            if (com_google_android_gms_internal_zzag_zza == zzdf.zzFJ()) {
                return zzdf.zzR(Boolean.valueOf(false));
            }
        }
        zza com_google_android_gms_internal_zzag_zza2 = (zza) map.get(zzbdJ);
        zza com_google_android_gms_internal_zzag_zza3 = (zza) map.get(zzbeH);
        boolean zza = (com_google_android_gms_internal_zzag_zza2 == null || com_google_android_gms_internal_zzag_zza3 == null) ? false : zza(com_google_android_gms_internal_zzag_zza2, com_google_android_gms_internal_zzag_zza3, map);
        return zzdf.zzR(Boolean.valueOf(zza));
    }

    protected abstract boolean zza(zza com_google_android_gms_internal_zzag_zza, zza com_google_android_gms_internal_zzag_zza2, Map<String, zza> map);
}
