package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class zzce extends zzak {
    private static final String ID = zzad.REGEX_GROUP.toString();
    private static final String zzbeT = zzae.ARG0.toString();
    private static final String zzbeU = zzae.ARG1.toString();
    private static final String zzbeV = zzae.IGNORE_CASE.toString();
    private static final String zzbeW = zzae.GROUP.toString();

    public zzce() {
        super(ID, zzbeT, zzbeU);
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzag_zza = (zza) map.get(zzbeT);
        zza com_google_android_gms_internal_zzag_zza2 = (zza) map.get(zzbeU);
        if (com_google_android_gms_internal_zzag_zza == null || com_google_android_gms_internal_zzag_zza == zzdf.zzFJ() || com_google_android_gms_internal_zzag_zza2 == null || com_google_android_gms_internal_zzag_zza2 == zzdf.zzFJ()) {
            return zzdf.zzFJ();
        }
        int i = 64;
        if (zzdf.zzk((zza) map.get(zzbeV)).booleanValue()) {
            i = 66;
        }
        zza com_google_android_gms_internal_zzag_zza3 = (zza) map.get(zzbeW);
        int intValue;
        if (com_google_android_gms_internal_zzag_zza3 != null) {
            Long zzi = zzdf.zzi(com_google_android_gms_internal_zzag_zza3);
            if (zzi == zzdf.zzFE()) {
                return zzdf.zzFJ();
            }
            intValue = zzi.intValue();
            if (intValue < 0) {
                return zzdf.zzFJ();
            }
        }
        intValue = 1;
        try {
            CharSequence zzg = zzdf.zzg(com_google_android_gms_internal_zzag_zza);
            Object obj = null;
            Matcher matcher = Pattern.compile(zzdf.zzg(com_google_android_gms_internal_zzag_zza2), i).matcher(zzg);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? zzdf.zzFJ() : zzdf.zzR(obj);
        } catch (PatternSyntaxException e) {
            return zzdf.zzFJ();
        }
    }
}
