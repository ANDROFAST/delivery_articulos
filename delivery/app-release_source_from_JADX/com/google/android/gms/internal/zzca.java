package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;

@zzha
public class zzca {
    private Context mContext = null;
    private String zzrD = null;
    private boolean zzwK;
    private String zzwL;
    private Map<String, String> zzwM;

    public zzca(Context context, String str) {
        this.mContext = context;
        this.zzrD = str;
        this.zzwK = ((Boolean) zzbz.zzvL.get()).booleanValue();
        this.zzwL = (String) zzbz.zzvM.get();
        this.zzwM = new LinkedHashMap();
        this.zzwM.put("s", "gmob_sdk");
        this.zzwM.put("v", "3");
        this.zzwM.put("os", VERSION.RELEASE);
        this.zzwM.put("sdk", VERSION.SDK);
        this.zzwM.put("device", zzp.zzbx().zzhb());
        this.zzwM.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        zzhi zzE = zzp.zzbD().zzE(this.mContext);
        this.zzwM.put("network_coarse", Integer.toString(zzE.zzIM));
        this.zzwM.put("network_fine", Integer.toString(zzE.zzIN));
    }

    Context getContext() {
        return this.mContext;
    }

    String zzbY() {
        return this.zzrD;
    }

    boolean zzdn() {
        return this.zzwK;
    }

    String zzdo() {
        return this.zzwL;
    }

    Map<String, String> zzdp() {
        return this.zzwM;
    }
}
