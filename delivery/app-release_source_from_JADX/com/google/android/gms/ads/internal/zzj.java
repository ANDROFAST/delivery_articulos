package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzha;

@zzha
public class zzj extends zza {
    private final Context mContext;
    private NativeAdOptionsParcel zzpE;
    private zzv zzpG;
    private final String zzpH;
    private final VersionInfoParcel zzpI;
    private zzcx zzpN;
    private zzcy zzpO;
    private SimpleArrayMap<String, zzcz> zzpP = new SimpleArrayMap();
    private SimpleArrayMap<String, zzda> zzpQ = new SimpleArrayMap();
    private final zzew zzpd;
    private zzo zzpz;

    public zzj(Context context, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpH = str;
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzpI = versionInfoParcel;
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.zzpE = nativeAdOptionsParcel;
    }

    public void zza(zzcx com_google_android_gms_internal_zzcx) {
        this.zzpN = com_google_android_gms_internal_zzcx;
    }

    public void zza(zzcy com_google_android_gms_internal_zzcy) {
        this.zzpO = com_google_android_gms_internal_zzcy;
    }

    public void zza(String str, zzda com_google_android_gms_internal_zzda, zzcz com_google_android_gms_internal_zzcz) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzpQ.put(str, com_google_android_gms_internal_zzda);
        this.zzpP.put(str, com_google_android_gms_internal_zzcz);
    }

    public void zzb(zzo com_google_android_gms_ads_internal_client_zzo) {
        this.zzpz = com_google_android_gms_ads_internal_client_zzo;
    }

    public void zzb(zzv com_google_android_gms_ads_internal_client_zzv) {
        this.zzpG = com_google_android_gms_ads_internal_client_zzv;
    }

    public zzp zzbm() {
        return new zzi(this.mContext, this.zzpH, this.zzpd, this.zzpI, this.zzpz, this.zzpN, this.zzpO, this.zzpQ, this.zzpP, this.zzpE, this.zzpG);
    }
}
