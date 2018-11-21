package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzb extends zzak {
    private static final String ID = zzad.ADVERTISER_ID.toString();
    private final zza zzbcv;

    public zzb(Context context) {
        this(zza.zzaW(context));
    }

    zzb(zza com_google_android_gms_tagmanager_zza) {
        super(ID, new String[0]);
        this.zzbcv = com_google_android_gms_tagmanager_zza;
    }

    public boolean zzEa() {
        return false;
    }

    public zza zzI(Map<String, zza> map) {
        String zzDU = this.zzbcv.zzDU();
        return zzDU == null ? zzdf.zzFJ() : zzdf.zzR(zzDU);
    }
}
