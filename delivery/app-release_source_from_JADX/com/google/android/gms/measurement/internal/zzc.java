package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzny;

public class zzc extends zzv {
    static final String zzaSt = String.valueOf(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    private Boolean zzQe;

    zzc(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    long zzAA() {
        return 3600000;
    }

    long zzAB() {
        return 60000;
    }

    long zzAC() {
        return 61000;
    }

    long zzAD() {
        return ((Long) zzk.zzaSR.get()).longValue();
    }

    public long zzAE() {
        return (long) (GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000);
    }

    public long zzAF() {
        return ((Long) zzk.zzaTd.get()).longValue();
    }

    public long zzAG() {
        return ((Long) zzk.zzaSZ.get()).longValue();
    }

    public long zzAH() {
        return 20;
    }

    public int zzAI() {
        return ((Integer) zzk.zzaST.get()).intValue();
    }

    public int zzAJ() {
        return Math.max(0, ((Integer) zzk.zzaSU.get()).intValue());
    }

    public String zzAK() {
        return (String) zzk.zzaSV.get();
    }

    public long zzAL() {
        return Math.max(0, ((Long) zzk.zzaSW.get()).longValue());
    }

    public long zzAM() {
        return Math.max(0, ((Long) zzk.zzaSY.get()).longValue());
    }

    public long zzAN() {
        return ((Long) zzk.zzaSX.get()).longValue();
    }

    public long zzAO() {
        return Math.max(0, ((Long) zzk.zzaTa.get()).longValue());
    }

    public long zzAP() {
        return Math.max(0, ((Long) zzk.zzaTb.get()).longValue());
    }

    public int zzAQ() {
        return Math.min(20, Math.max(0, ((Integer) zzk.zzaTc.get()).intValue()));
    }

    public /* bridge */ /* synthetic */ void zzAR() {
        super.zzAR();
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    String zzAs() {
        return (String) zzk.zzaSQ.get();
    }

    int zzAt() {
        return 32;
    }

    public int zzAu() {
        return 24;
    }

    int zzAv() {
        return 36;
    }

    int zzAw() {
        return 256;
    }

    int zzAx() {
        return 36;
    }

    int zzAy() {
        return 2048;
    }

    int zzAz() {
        return 20;
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public /* bridge */ /* synthetic */ void zziS() {
        super.zziS();
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    public String zzkA() {
        return "google_app_measurement.db";
    }

    public String zzkB() {
        return "google_app_measurement2.db";
    }

    public long zzkG() {
        return Math.max(0, ((Long) zzk.zzaSS.get()).longValue());
    }

    public boolean zzka() {
        return zzd.zzaiU;
    }

    public boolean zzkb() {
        if (this.zzQe == null) {
            synchronized (this) {
                if (this.zzQe == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String zzj = zzny.zzj(getContext(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(zzj);
                        this.zzQe = Boolean.valueOf(z);
                    }
                    if (this.zzQe == null) {
                        this.zzQe = Boolean.TRUE;
                        zzzz().zzBl().zzez("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzQe.booleanValue();
    }

    long zzkv() {
        return ((Long) zzk.zzaTe.get()).longValue();
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
