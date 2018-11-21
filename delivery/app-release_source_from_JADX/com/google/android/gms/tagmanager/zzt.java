package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class zzt extends zzak {
    private static final String ID = zzad.FUNCTION_CALL.toString();
    private static final String zzbcy = zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzbdi = zzae.FUNCTION_CALL_NAME.toString();
    private final zza zzbdj;

    public interface zza {
        Object zzc(String str, Map<String, Object> map);
    }

    public zzt(zza com_google_android_gms_tagmanager_zzt_zza) {
        super(ID, zzbdi);
        this.zzbdj = com_google_android_gms_tagmanager_zzt_zza;
    }

    public boolean zzEa() {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzbdi));
        Map hashMap = new HashMap();
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) map.get(zzbcy);
        if (com_google_android_gms_internal_zzag_zza != null) {
            Object zzl = zzdf.zzl(com_google_android_gms_internal_zzag_zza);
            if (zzl instanceof Map) {
                for (Entry entry : ((Map) zzl).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                zzbg.zzaH("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.zzFJ();
            }
        }
        try {
            return zzdf.zzR(this.zzbdj.zzc(zzg, hashMap));
        } catch (Exception e) {
            zzbg.zzaH("Custom macro/tag " + zzg + " threw exception " + e.getMessage());
            return zzdf.zzFJ();
        }
    }
}
