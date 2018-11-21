package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.zzda.zza;

@zzha
public class zzdf extends zza {
    private final OnCustomTemplateAdLoadedListener zzyx;

    public zzdf(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzyx = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzcv com_google_android_gms_internal_zzcv) {
        this.zzyx.onCustomTemplateAdLoaded(new zzcw(com_google_android_gms_internal_zzcv));
    }
}
