package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

@zzha
public class zzgj implements InAppPurchaseResult {
    private final zzgf zzFa;

    public zzgj(zzgf com_google_android_gms_internal_zzgf) {
        this.zzFa = com_google_android_gms_internal_zzgf;
    }

    public void finishPurchase() {
        try {
            this.zzFa.finishPurchase();
        } catch (Throwable e) {
            zzb.zzd("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    public String getProductId() {
        try {
            return this.zzFa.getProductId();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    public Intent getPurchaseData() {
        try {
            return this.zzFa.getPurchaseData();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    public int getResultCode() {
        try {
            return this.zzFa.getResultCode();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    public boolean isVerified() {
        try {
            return this.zzFa.isVerified();
        } catch (Throwable e) {
            zzb.zzd("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
