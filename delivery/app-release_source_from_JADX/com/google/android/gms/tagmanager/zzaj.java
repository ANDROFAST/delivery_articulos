package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf.zzc;
import com.google.android.gms.internal.zzaf.zzd;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaj {
    private static void zza(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaf_zzd) {
        for (zza zzg : com_google_android_gms_internal_zzaf_zzd.zziu) {
            dataLayer.zzfj(zzdf.zzg(zzg));
        }
    }

    public static void zza(DataLayer dataLayer, zzi com_google_android_gms_internal_zzaf_zzi) {
        if (com_google_android_gms_internal_zzaf_zzi.zzjj == null) {
            zzbg.zzaH("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, com_google_android_gms_internal_zzaf_zzi.zzjj);
        zzb(dataLayer, com_google_android_gms_internal_zzaf_zzi.zzjj);
        zzc(dataLayer, com_google_android_gms_internal_zzaf_zzi.zzjj);
    }

    private static void zzb(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaf_zzd) {
        for (zza zzc : com_google_android_gms_internal_zzaf_zzd.zzit) {
            Map zzc2 = zzc(zzc);
            if (zzc2 != null) {
                dataLayer.push(zzc2);
            }
        }
    }

    private static Map<String, Object> zzc(zza com_google_android_gms_internal_zzag_zza) {
        Object zzl = zzdf.zzl(com_google_android_gms_internal_zzag_zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        zzbg.zzaH("value: " + zzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaf_zzd) {
        for (zzc com_google_android_gms_internal_zzaf_zzc : com_google_android_gms_internal_zzaf_zzd.zziv) {
            if (com_google_android_gms_internal_zzaf_zzc.key == null) {
                zzbg.zzaH("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(com_google_android_gms_internal_zzaf_zzc.key);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = com_google_android_gms_internal_zzaf_zzc.zzip;
                long j2 = com_google_android_gms_internal_zzaf_zzc.zziq;
                if (!com_google_android_gms_internal_zzaf_zzc.zzir || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbg.zzaH("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzfj(com_google_android_gms_internal_zzaf_zzc.key);
                Map zzn = dataLayer.zzn(com_google_android_gms_internal_zzaf_zzc.key, obj);
                if (com_google_android_gms_internal_zzaf_zzc.zzis > 0) {
                    if (zzn.containsKey("gtm")) {
                        Object obj2 = zzn.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(com_google_android_gms_internal_zzaf_zzc.zzis));
                        } else {
                            zzbg.zzaH("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        zzn.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(com_google_android_gms_internal_zzaf_zzc.zzis)));
                    }
                }
                dataLayer.push(zzn);
            }
        }
    }
}
