package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzcr extends zzak {
    private static final String ID = zzad.SDK_VERSION.toString();

    public zzcr() {
        super(ID, new String[0]);
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        return zzdf.zzR(Integer.valueOf(VERSION.SDK_INT));
    }
}
