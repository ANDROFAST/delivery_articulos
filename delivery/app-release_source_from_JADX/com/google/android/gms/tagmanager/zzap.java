package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class zzap extends zzak {
    private static final String ID = zzad.HASH.toString();
    private static final String zzbdJ = zzae.ARG0.toString();
    private static final String zzbdL = zzae.INPUT_FORMAT.toString();
    private static final String zzbdP = zzae.ALGORITHM.toString();

    public zzap() {
        super(ID, zzbdJ);
    }

    private byte[] zzd(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdJ);
        if (com_google_android_gms_internal_zzag_zza == null || com_google_android_gms_internal_zzag_zza == zzdf.zzFJ()) {
            return zzdf.zzFJ();
        }
        byte[] bytes;
        String zzg = zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdP);
        String zzg2 = com_google_android_gms_internal_zzag_zza == null ? "MD5" : zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbdL);
        String zzg3 = com_google_android_gms_internal_zzag_zza == null ? "text" : zzdf.zzg(com_google_android_gms_internal_zzag_zza);
        if ("text".equals(zzg3)) {
            bytes = zzg.getBytes();
        } else if ("base16".equals(zzg3)) {
            bytes = zzk.zzfa(zzg);
        } else {
            zzbg.m9e("Hash: unknown input format: " + zzg3);
            return zzdf.zzFJ();
        }
        try {
            return zzdf.zzR(zzk.zzj(zzd(zzg2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            zzbg.m9e("Hash: unknown algorithm: " + zzg2);
            return zzdf.zzFJ();
        }
    }
}
