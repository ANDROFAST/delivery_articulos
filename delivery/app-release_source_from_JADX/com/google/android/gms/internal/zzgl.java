package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzgg.zza;

@zzha
public final class zzgl extends zza {
    private final PlayStorePurchaseListener zzuA;

    public zzgl(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzuA = playStorePurchaseListener;
    }

    public boolean isValidPurchase(String productId) {
        return this.zzuA.isValidPurchase(productId);
    }

    public void zza(zzgf com_google_android_gms_internal_zzgf) {
        this.zzuA.onInAppPurchaseFinished(new zzgj(com_google_android_gms_internal_zzgf));
    }
}
