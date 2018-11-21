package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzqn extends zze<zzqn> {
    private String zzaRS;
    private int zzaRT;
    private int zzaRU;
    private String zzaRV;
    private String zzaRW;
    private boolean zzaRX;
    private boolean zzaRY;
    private boolean zzaRZ;

    public zzqn() {
        this(false);
    }

    public zzqn(boolean z) {
        this(z, zzAl());
    }

    public zzqn(boolean z, int i) {
        zzx.zzbX(i);
        this.zzaRT = i;
        this.zzaRY = z;
    }

    static int zzAl() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Integer.MAX_VALUE;
    }

    private void zzAp() {
        if (this.zzaRZ) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public void setScreenName(String screenName) {
        zzAp();
        this.zzaRS = screenName;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.zzaRS);
        hashMap.put("interstitial", Boolean.valueOf(this.zzaRX));
        hashMap.put("automatic", Boolean.valueOf(this.zzaRY));
        hashMap.put("screenId", Integer.valueOf(this.zzaRT));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzaRU));
        hashMap.put("referrerScreenName", this.zzaRV);
        hashMap.put("referrerUri", this.zzaRW);
        return zze.zzE(hashMap);
    }

    public String zzAm() {
        return this.zzaRS;
    }

    public int zzAn() {
        return this.zzaRT;
    }

    public String zzAo() {
        return this.zzaRW;
    }

    public void zza(zzqn com_google_android_gms_internal_zzqn) {
        if (!TextUtils.isEmpty(this.zzaRS)) {
            com_google_android_gms_internal_zzqn.setScreenName(this.zzaRS);
        }
        if (this.zzaRT != 0) {
            com_google_android_gms_internal_zzqn.zzit(this.zzaRT);
        }
        if (this.zzaRU != 0) {
            com_google_android_gms_internal_zzqn.zziu(this.zzaRU);
        }
        if (!TextUtils.isEmpty(this.zzaRV)) {
            com_google_android_gms_internal_zzqn.zzeq(this.zzaRV);
        }
        if (!TextUtils.isEmpty(this.zzaRW)) {
            com_google_android_gms_internal_zzqn.zzer(this.zzaRW);
        }
        if (this.zzaRX) {
            com_google_android_gms_internal_zzqn.zzan(this.zzaRX);
        }
        if (this.zzaRY) {
            com_google_android_gms_internal_zzqn.zzam(this.zzaRY);
        }
    }

    public void zzam(boolean z) {
        zzAp();
        this.zzaRY = z;
    }

    public void zzan(boolean z) {
        zzAp();
        this.zzaRX = z;
    }

    public void zzeq(String str) {
        zzAp();
        this.zzaRV = str;
    }

    public void zzer(String str) {
        zzAp();
        if (TextUtils.isEmpty(str)) {
            this.zzaRW = null;
        } else {
            this.zzaRW = str;
        }
    }

    public void zzit(int i) {
        zzAp();
        this.zzaRT = i;
    }

    public void zziu(int i) {
        zzAp();
        this.zzaRU = i;
    }
}
