package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.internal.zzcy.zza;

@zzha
public class zzdd extends zza {
    private final OnContentAdLoadedListener zzyv;

    public zzdd(OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzyv = onContentAdLoadedListener;
    }

    public void zza(zzct com_google_android_gms_internal_zzct) {
        this.zzyv.onContentAdLoaded(zzb(com_google_android_gms_internal_zzct));
    }

    zzcu zzb(zzct com_google_android_gms_internal_zzct) {
        return new zzcu(com_google_android_gms_internal_zzct);
    }
}
