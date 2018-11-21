package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh {
    private final String zzOu;
    private final long zzPj;
    private final String zzPk;
    private final boolean zzPl;
    private long zzPm;
    private final Map<String, String> zzxc;

    public zzh(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        zzx.zzcG(str);
        zzx.zzcG(str2);
        this.zzPj = j;
        this.zzOu = str;
        this.zzPk = str2;
        this.zzPl = z;
        this.zzPm = j2;
        if (map != null) {
            this.zzxc = new HashMap(map);
        } else {
            this.zzxc = Collections.emptyMap();
        }
    }

    public String getClientId() {
        return this.zzOu;
    }

    public long zzjm() {
        return this.zzPj;
    }

    public String zzjn() {
        return this.zzPk;
    }

    public boolean zzjo() {
        return this.zzPl;
    }

    public long zzjp() {
        return this.zzPm;
    }

    public Map<String, String> zzn() {
        return this.zzxc;
    }

    public void zzn(long j) {
        this.zzPm = j;
    }
}
