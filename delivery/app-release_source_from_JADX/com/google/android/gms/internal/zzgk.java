package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzha
public class zzgk implements InAppPurchase {
    private final zzgb zzEK;

    public zzgk(zzgb com_google_android_gms_internal_zzgb) {
        this.zzEK = com_google_android_gms_internal_zzgb;
    }

    public String getProductId() {
        try {
            return this.zzEK.getProductId();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.zzEK.recordPlayBillingResolution(billingResponseCode);
        } catch (Throwable e) {
            zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int resolution) {
        try {
            this.zzEK.recordResolution(resolution);
        } catch (Throwable e) {
            zzb.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
