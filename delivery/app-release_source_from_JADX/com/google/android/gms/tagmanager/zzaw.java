package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaw extends zzak {
    private static final String ID = zzad.INSTALL_REFERRER.toString();
    private static final String zzbcw = zzae.COMPONENT.toString();
    private final Context context;

    public zzaw(Context context) {
        super(ID, new String[0]);
        this.context = context;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        String zzl = zzax.zzl(this.context, ((zza) map.get(zzbcw)) != null ? zzdf.zzg((zza) map.get(zzbcw)) : null);
        return zzl != null ? zzdf.zzR(zzl) : zzdf.zzFJ();
    }
}
