package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzha
public class zzbw {
    private final Collection<zzbv> zzuZ = new ArrayList();
    private final Collection<zzbv<String>> zzva = new ArrayList();
    private final Collection<zzbv<String>> zzvb = new ArrayList();

    public void zza(zzbv com_google_android_gms_internal_zzbv) {
        this.zzuZ.add(com_google_android_gms_internal_zzbv);
    }

    public void zzb(zzbv<String> com_google_android_gms_internal_zzbv_java_lang_String) {
        this.zzva.add(com_google_android_gms_internal_zzbv_java_lang_String);
    }

    public void zzc(zzbv<String> com_google_android_gms_internal_zzbv_java_lang_String) {
        this.zzvb.add(com_google_android_gms_internal_zzbv_java_lang_String);
    }

    public List<String> zzdl() {
        List<String> arrayList = new ArrayList();
        for (zzbv com_google_android_gms_internal_zzbv : this.zzva) {
            String str = (String) com_google_android_gms_internal_zzbv.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
