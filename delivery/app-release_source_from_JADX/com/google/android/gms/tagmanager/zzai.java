package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzai extends zzak {
    private static final String ID = zzad.EVENT.toString();
    private final zzcp zzbcH;

    public zzai(zzcp com_google_android_gms_tagmanager_zzcp) {
        super(ID, new String[0]);
        this.zzbcH = com_google_android_gms_tagmanager_zzcp;
    }

    public boolean zzEa() {
        return false;
    }

    public zza zzI(Map<String, zza> map) {
        String zzFi = this.zzbcH.zzFi();
        return zzFi == null ? zzdf.zzFJ() : zzdf.zzR(zzFi);
    }
}
