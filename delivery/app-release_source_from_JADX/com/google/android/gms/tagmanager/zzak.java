package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzak {
    private final Set<String> zzbdN;
    private final String zzbdO;

    public zzak(String str, String... strArr) {
        this.zzbdO = str;
        this.zzbdN = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.zzbdN.add(add);
        }
    }

    public String zzEF() {
        return this.zzbdO;
    }

    public Set<String> zzEG() {
        return this.zzbdN;
    }

    public abstract boolean zzEa();

    public abstract zza zzI(Map<String, zza> map);

    boolean zzf(Set<String> set) {
        return set.containsAll(this.zzbdN);
    }
}
