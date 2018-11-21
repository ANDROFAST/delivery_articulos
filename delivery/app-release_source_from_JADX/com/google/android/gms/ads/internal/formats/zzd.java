package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzcr.zza;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public class zzd extends zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzpK = new Object();
    private String zzxA;
    private zzcn zzxB;
    private String zzxC;
    private double zzxD;
    private String zzxE;
    private String zzxF;
    private zza zzxG;
    private zzh zzxH;
    private String zzxy;
    private List<zzc> zzxz;

    public zzd(String str, List list, String str2, zzcn com_google_android_gms_internal_zzcn, String str3, double d, String str4, String str5, zza com_google_android_gms_ads_internal_formats_zza, Bundle bundle) {
        this.zzxy = str;
        this.zzxz = list;
        this.zzxA = str2;
        this.zzxB = com_google_android_gms_internal_zzcn;
        this.zzxC = str3;
        this.zzxD = d;
        this.zzxE = str4;
        this.zzxF = str5;
        this.zzxG = com_google_android_gms_ads_internal_formats_zza;
        this.mExtras = bundle;
    }

    public void destroy() {
        this.zzxy = null;
        this.zzxz = null;
        this.zzxA = null;
        this.zzxB = null;
        this.zzxC = null;
        this.zzxD = 0.0d;
        this.zzxE = null;
        this.zzxF = null;
        this.zzxG = null;
        this.mExtras = null;
        this.zzpK = null;
        this.zzxH = null;
    }

    public String getBody() {
        return this.zzxA;
    }

    public String getCallToAction() {
        return this.zzxC;
    }

    public String getCustomTemplateId() {
        return "";
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getHeadline() {
        return this.zzxy;
    }

    public List getImages() {
        return this.zzxz;
    }

    public String getPrice() {
        return this.zzxF;
    }

    public double getStarRating() {
        return this.zzxD;
    }

    public String getStore() {
        return this.zzxE;
    }

    public void zzb(zzh com_google_android_gms_ads_internal_formats_zzh) {
        synchronized (this.zzpK) {
            this.zzxH = com_google_android_gms_ads_internal_formats_zzh;
        }
    }

    public zzcn zzdD() {
        return this.zzxB;
    }

    public com.google.android.gms.dynamic.zzd zzdE() {
        return zze.zzB(this.zzxH);
    }

    public String zzdF() {
        return "2";
    }

    public zza zzdG() {
        return this.zzxG;
    }
}
