package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzaq {
    private final long zzRr;
    private final long zzbdQ;
    private final long zzbdR;
    private String zzbdS;

    zzaq(long j, long j2, long j3) {
        this.zzbdQ = j;
        this.zzRr = j2;
        this.zzbdR = j3;
    }

    long zzEH() {
        return this.zzbdQ;
    }

    long zzEI() {
        return this.zzbdR;
    }

    String zzEJ() {
        return this.zzbdS;
    }

    void zzfr(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzbdS = str;
        }
    }
}
