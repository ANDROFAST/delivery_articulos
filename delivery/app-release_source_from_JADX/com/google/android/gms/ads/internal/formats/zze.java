package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzct.zza;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public class zze extends zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzpK = new Object();
    private String zzxA;
    private String zzxC;
    private zza zzxG;
    private zzh zzxH;
    private zzcn zzxI;
    private String zzxJ;
    private String zzxy;
    private List<zzc> zzxz;

    public zze(String str, List list, String str2, zzcn com_google_android_gms_internal_zzcn, String str3, String str4, zza com_google_android_gms_ads_internal_formats_zza, Bundle bundle) {
        this.zzxy = str;
        this.zzxz = list;
        this.zzxA = str2;
        this.zzxI = com_google_android_gms_internal_zzcn;
        this.zzxC = str3;
        this.zzxJ = str4;
        this.zzxG = com_google_android_gms_ads_internal_formats_zza;
        this.mExtras = bundle;
    }

    public void destroy() {
        this.zzxy = null;
        this.zzxz = null;
        this.zzxA = null;
        this.zzxI = null;
        this.zzxC = null;
        this.zzxJ = null;
        this.zzxG = null;
        this.mExtras = null;
        this.zzpK = null;
        this.zzxH = null;
    }

    public String getAdvertiser() {
        return this.zzxJ;
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

    public void zzb(zzh com_google_android_gms_ads_internal_formats_zzh) {
        synchronized (this.zzpK) {
            this.zzxH = com_google_android_gms_ads_internal_formats_zzh;
        }
    }

    public zzd zzdE() {
        return com.google.android.gms.dynamic.zze.zzB(this.zzxH);
    }

    public String zzdF() {
        return "1";
    }

    public zza zzdG() {
        return this.zzxG;
    }

    public zzcn zzdH() {
        return this.zzxI;
    }
}
