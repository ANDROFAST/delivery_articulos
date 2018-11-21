package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzan extends zzd {
    protected boolean zzNO;
    protected int zzQh;
    protected String zzRk;
    protected String zzRl;
    protected int zzRn;
    protected boolean zzSb;
    protected boolean zzSc;
    protected boolean zzSd;

    public zzan(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    private static int zzbv(String str) {
        String toLowerCase = str.toLowerCase();
        return "verbose".equals(toLowerCase) ? 0 : "info".equals(toLowerCase) ? 1 : "warning".equals(toLowerCase) ? 2 : "error".equals(toLowerCase) ? 3 : -1;
    }

    public int getLogLevel() {
        zzje();
        return this.zzQh;
    }

    void zza(zzaa com_google_android_gms_analytics_internal_zzaa) {
        int zzbv;
        zzba("Loading global XML config values");
        if (com_google_android_gms_analytics_internal_zzaa.zzkO()) {
            String zzkP = com_google_android_gms_analytics_internal_zzaa.zzkP();
            this.zzRk = zzkP;
            zzb("XML config - app name", zzkP);
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzkQ()) {
            zzkP = com_google_android_gms_analytics_internal_zzaa.zzkR();
            this.zzRl = zzkP;
            zzb("XML config - app version", zzkP);
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzkS()) {
            zzbv = zzbv(com_google_android_gms_analytics_internal_zzaa.zzkT());
            if (zzbv >= 0) {
                this.zzQh = zzbv;
                zza("XML config - log level", Integer.valueOf(zzbv));
            }
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzkU()) {
            zzbv = com_google_android_gms_analytics_internal_zzaa.zzkV();
            this.zzRn = zzbv;
            this.zzSc = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(zzbv));
        }
        if (com_google_android_gms_analytics_internal_zzaa.zzkW()) {
            boolean zzkX = com_google_android_gms_analytics_internal_zzaa.zzkX();
            this.zzNO = zzkX;
            this.zzSd = true;
            zzb("XML config - dry run", Boolean.valueOf(zzkX));
        }
    }

    protected void zzir() {
        zzlM();
    }

    public String zzkP() {
        zzje();
        return this.zzRk;
    }

    public String zzkR() {
        zzje();
        return this.zzRl;
    }

    public boolean zzkS() {
        zzje();
        return this.zzSb;
    }

    public boolean zzkU() {
        zzje();
        return this.zzSc;
    }

    public boolean zzkW() {
        zzje();
        return this.zzSd;
    }

    public boolean zzkX() {
        zzje();
        return this.zzNO;
    }

    public int zzlL() {
        zzje();
        return this.zzRn;
    }

    protected void zzlM() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzbd("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                zzaa com_google_android_gms_analytics_internal_zzaa = (zzaa) new zzz(zziQ()).zzah(i);
                if (com_google_android_gms_analytics_internal_zzaa != null) {
                    zza(com_google_android_gms_analytics_internal_zzaa);
                }
            }
        }
    }
}
