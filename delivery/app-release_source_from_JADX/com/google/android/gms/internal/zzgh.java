package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.zzgc.zza;

@zzha
public final class zzgh extends zza {
    private final InAppPurchaseListener zzuz;

    public zzgh(InAppPurchaseListener inAppPurchaseListener) {
        this.zzuz = inAppPurchaseListener;
    }

    public void zza(zzgb com_google_android_gms_internal_zzgb) {
        this.zzuz.onInAppPurchaseRequested(new zzgk(com_google_android_gms_internal_zzgb));
    }
}
