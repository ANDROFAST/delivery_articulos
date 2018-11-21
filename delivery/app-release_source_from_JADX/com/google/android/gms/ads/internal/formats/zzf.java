package com.google.android.gms.ads.internal.formats;

import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzcv.zza;
import com.google.android.gms.internal.zzha;
import java.util.Arrays;
import java.util.List;

@zzha
public class zzf extends zza implements zzh.zza {
    private final Object zzpK = new Object();
    private final zza zzxG;
    private zzh zzxH;
    private final String zzxK;
    private final SimpleArrayMap<String, zzc> zzxL;
    private final SimpleArrayMap<String, String> zzxM;

    public zzf(String str, SimpleArrayMap<String, zzc> simpleArrayMap, SimpleArrayMap<String, String> simpleArrayMap2, zza com_google_android_gms_ads_internal_formats_zza) {
        this.zzxK = str;
        this.zzxL = simpleArrayMap;
        this.zzxM = simpleArrayMap2;
        this.zzxG = com_google_android_gms_ads_internal_formats_zza;
    }

    public List<String> getAvailableAssetNames() {
        int i = 0;
        String[] strArr = new String[(this.zzxL.size() + this.zzxM.size())];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzxL.size(); i3++) {
            strArr[i2] = (String) this.zzxL.keyAt(i3);
            i2++;
        }
        while (i < this.zzxM.size()) {
            strArr[i2] = (String) this.zzxM.keyAt(i);
            i++;
            i2++;
        }
        return Arrays.asList(strArr);
    }

    public String getCustomTemplateId() {
        return this.zzxK;
    }

    public void performClick(String assetName) {
        synchronized (this.zzpK) {
            if (this.zzxH == null) {
                zzb.m6e("Attempt to call performClick before ad initialized.");
                return;
            }
            this.zzxH.zza(assetName, null, null, null);
        }
    }

    public void recordImpression() {
        synchronized (this.zzpK) {
            if (this.zzxH == null) {
                zzb.m6e("Attempt to perform recordImpression before ad initialized.");
                return;
            }
            this.zzxH.recordImpression();
        }
    }

    public String zzS(String str) {
        return (String) this.zzxM.get(str);
    }

    public zzcn zzT(String str) {
        return (zzcn) this.zzxL.get(str);
    }

    public void zzb(zzh com_google_android_gms_ads_internal_formats_zzh) {
        synchronized (this.zzpK) {
            this.zzxH = com_google_android_gms_ads_internal_formats_zzh;
        }
    }

    public String zzdF() {
        return "3";
    }

    public zza zzdG() {
        return this.zzxG;
    }
}
