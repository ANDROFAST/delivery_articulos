package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzq extends zzak {
    private static final String ID = zzad.CONTAINER_VERSION.toString();
    private final String zzabv;

    public zzq(String str) {
        super(ID, new String[0]);
        this.zzabv = str;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        return this.zzabv == null ? zzdf.zzFJ() : zzdf.zzR(this.zzabv);
    }
}
