package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzbi extends zzak {
    private static final String ID = zzad.LOWERCASE_STRING.toString();
    private static final String zzbdJ = zzae.ARG0.toString();

    public zzbi() {
        super(ID, zzbdJ);
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        return zzdf.zzR(zzdf.zzg((zza) map.get(zzbdJ)).toLowerCase());
    }
}
