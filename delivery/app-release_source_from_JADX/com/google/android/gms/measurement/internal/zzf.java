package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.internal.zznl;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class zzf extends zzw {
    private long zzaSA;
    private String zzaSB;

    zzf(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
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

    public String zzBe() {
        zzje();
        return VERSION.RELEASE;
    }

    public long zzBf() {
        zzje();
        return this.zzaSA;
    }

    public String zzBg() {
        zzje();
        return this.zzaSB;
    }

    public String zzhb() {
        zzje();
        return Build.MODEL;
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

    protected void zzir() {
        Calendar instance = Calendar.getInstance();
        this.zzaSA = TimeUnit.MINUTES.convert((long) (instance.get(16) + instance.get(15)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        this.zzaSB = locale.getLanguage().toLowerCase(Locale.ENGLISH) + "-" + locale.getCountry().toLowerCase(Locale.ENGLISH);
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
