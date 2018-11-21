package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzn extends zzak {
    private static final String ID = zzad.CONSTANT.toString();
    private static final String VALUE = zzae.VALUE.toString();

    public zzn() {
        super(ID, VALUE);
    }

    public static String zzEd() {
        return ID;
    }

    public static String zzEe() {
        return VALUE;
    }

    public boolean zzEa() {
        return true;
    }

    public zza zzI(Map<String, zza> map) {
        return (zza) map.get(VALUE);
    }
}
