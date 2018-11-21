package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.internal.zzcz.zza;

@zzha
public class zzde extends zza {
    private final OnCustomClickListener zzyw;

    public zzde(OnCustomClickListener onCustomClickListener) {
        this.zzyw = onCustomClickListener;
    }

    public void zza(zzcv com_google_android_gms_internal_zzcv, String str) {
        this.zzyw.onCustomClick(new zzcw(com_google_android_gms_internal_zzcv), str);
    }
}
