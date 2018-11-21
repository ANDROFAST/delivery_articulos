package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzc extends zzak {
    private static final String ID = zzad.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzbcv;

    public zzc(Context context) {
        this(zza.zzaW(context));
    }

    zzc(zza com_google_android_gms_tagmanager_zza) {
        super(ID, new String[0]);
        this.zzbcv = com_google_android_gms_tagmanager_zza;
    }

    public boolean zzEa() {
        return false;
    }

    public zza zzI(Map<String, zza> map) {
        return zzdf.zzR(Boolean.valueOf(!this.zzbcv.isLimitAdTrackingEnabled()));
    }
}
