package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzo.zza;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzc extends zza {
    private final AdListener zzto;

    public zzc(AdListener adListener) {
        this.zzto = adListener;
    }

    public void onAdClosed() {
        this.zzto.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.zzto.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.zzto.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.zzto.onAdLoaded();
    }

    public void onAdOpened() {
        this.zzto.onAdOpened();
    }
}
