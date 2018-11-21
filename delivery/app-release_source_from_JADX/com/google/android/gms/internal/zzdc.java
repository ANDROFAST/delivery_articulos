package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.internal.zzcx.zza;

@zzha
public class zzdc extends zza {
    private final OnAppInstallAdLoadedListener zzyu;

    public zzdc(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzyu = onAppInstallAdLoadedListener;
    }

    public void zza(zzcr com_google_android_gms_internal_zzcr) {
        this.zzyu.onAppInstallAdLoaded(zzb(com_google_android_gms_internal_zzcr));
    }

    zzcs zzb(zzcr com_google_android_gms_internal_zzcr) {
        return new zzcs(com_google_android_gms_internal_zzcr);
    }
}
