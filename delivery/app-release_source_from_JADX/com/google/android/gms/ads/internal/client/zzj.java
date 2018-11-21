package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzu.zza;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzj extends zza {
    private final AppEventListener zzub;

    public zzj(AppEventListener appEventListener) {
        this.zzub = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.zzub.onAppEvent(name, info);
    }
}
