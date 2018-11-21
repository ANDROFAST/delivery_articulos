package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzcl.zza;

@zzha
public final class zzcm extends zza {
    private final OnCustomRenderedAdLoadedListener zzuB;

    public zzcm(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzuB = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzck com_google_android_gms_internal_zzck) {
        this.zzuB.onCustomRenderedAdLoaded(new zzcj(com_google_android_gms_internal_zzck));
    }
}
