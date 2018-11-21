package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzad extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ENCODE.toString();
    private static final String zzbdJ = zzae.ARG0.toString();
    private static final String zzbdK = zzae.NO_PADDING.toString();
    private static final String zzbdL = zzae.INPUT_FORMAT.toString();
    private static final String zzbdM = zzae.OUTPUT_FORMAT.toString();

    public zzad() {
        super(ID, zzbdJ);
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdJ);
        if (com_google_android_gms_internal_zzag_zza == null || com_google_android_gms_internal_zzag_zza == zzdf.zzFJ()) {
            return zzdf.zzFJ();
        }
        String zzg = zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdL);
        String zzg2 = com_google_android_gms_internal_zzag_zza == null ? "text" : zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdM);
        String zzg3 = com_google_android_gms_internal_zzag_zza == null ? "base16" : zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdK);
        int i = (com_google_android_gms_internal_zzag_zza == null || !zzdf.zzk(com_google_android_gms_internal_zzag_zza).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object zzj;
            if ("text".equals(zzg2)) {
                bytes = zzg.getBytes();
            } else if ("base16".equals(zzg2)) {
                bytes = zzk.zzfa(zzg);
            } else if ("base64".equals(zzg2)) {
                bytes = Base64.decode(zzg, i);
            } else if ("base64url".equals(zzg2)) {
                bytes = Base64.decode(zzg, i | 8);
            } else {
                zzbg.m9e("Encode: unknown input format: " + zzg2);
                return zzdf.zzFJ();
            }
            if ("base16".equals(zzg3)) {
                zzj = zzk.zzj(bytes);
            } else if ("base64".equals(zzg3)) {
                zzj = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(zzg3)) {
                zzj = Base64.encodeToString(bytes, i | 8);
            } else {
                zzbg.m9e("Encode: unknown output format: " + zzg3);
                return zzdf.zzFJ();
            }
            return zzdf.zzR(zzj);
        } catch (IllegalArgumentException e) {
            zzbg.m9e("Encode: invalid input:");
            return zzdf.zzFJ();
        }
    }
}
