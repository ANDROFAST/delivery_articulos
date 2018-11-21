package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class InterstitialAd {
    private final zzaa zzoA;

    public InterstitialAd(Context context) {
        this.zzoA = new zzaa(context);
    }

    public AdListener getAdListener() {
        return this.zzoA.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzoA.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzoA.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoA.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.zzoA.isLoaded();
    }

    public boolean isLoading() {
        return this.zzoA.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzoA.zza(adRequest.zzaG());
    }

    public void setAdListener(AdListener adListener) {
        this.zzoA.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zza)) {
            this.zzoA.zza((zza) adListener);
        } else if (adListener == null) {
            this.zzoA.zza(null);
        }
    }

    public void setAdUnitId(String adUnitId) {
        this.zzoA.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzoA.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.zzoA.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }

    public void show() {
        this.zzoA.show();
    }
}
