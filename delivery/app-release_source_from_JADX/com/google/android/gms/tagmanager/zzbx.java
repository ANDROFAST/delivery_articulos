package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzbx extends zzak {
    private static final String ID = zzad.OS_VERSION.toString();

    public zzbx() {
        super(ID, new String[0]);
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        return zzdf.zzR(VERSION.RELEASE);
    }
}
