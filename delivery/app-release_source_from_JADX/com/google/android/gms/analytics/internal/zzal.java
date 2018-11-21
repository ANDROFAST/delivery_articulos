package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zzal implements zzp {
    public String zzNB;
    public double zzRU = -1.0d;
    public int zzRV = -1;
    public int zzRW = -1;
    public int zzRX = -1;
    public int zzRY = -1;
    public Map<String, String> zzRZ = new HashMap();

    public int getSessionTimeout() {
        return this.zzRV;
    }

    public String getTrackingId() {
        return this.zzNB;
    }

    public String zzbo(String str) {
        String str2 = (String) this.zzRZ.get(str);
        return str2 != null ? str2 : str;
    }

    public boolean zzlC() {
        return this.zzNB != null;
    }

    public boolean zzlD() {
        return this.zzRU >= 0.0d;
    }

    public double zzlE() {
        return this.zzRU;
    }

    public boolean zzlF() {
        return this.zzRV >= 0;
    }

    public boolean zzlG() {
        return this.zzRW != -1;
    }

    public boolean zzlH() {
        return this.zzRW == 1;
    }

    public boolean zzlI() {
        return this.zzRX != -1;
    }

    public boolean zzlJ() {
        return this.zzRX == 1;
    }

    public boolean zzlK() {
        return this.zzRY == 1;
    }

    public String zzq(Activity activity) {
        return zzbo(activity.getClass().getCanonicalName());
    }
}
