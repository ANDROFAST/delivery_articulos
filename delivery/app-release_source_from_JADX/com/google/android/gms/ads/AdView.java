package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class AdView extends BaseAdView {
    public AdView(Context context) {
        super(context, 1);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs, 1);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle, 1);
    }

    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    public /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    public /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    public /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    public /* bridge */ /* synthetic */ InAppPurchaseListener getInAppPurchaseListener() {
        return super.getInAppPurchaseListener();
    }

    public /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    public /* bridge */ /* synthetic */ boolean isLoading() {
        return super.isLoading();
    }

    public /* bridge */ /* synthetic */ void loadAd(AdRequest x0) {
        super.loadAd(x0);
    }

    public /* bridge */ /* synthetic */ void pause() {
        super.pause();
    }

    public /* bridge */ /* synthetic */ void resume() {
        super.resume();
    }

    public /* bridge */ /* synthetic */ void setAdListener(AdListener x0) {
        super.setAdListener(x0);
    }

    public /* bridge */ /* synthetic */ void setAdSize(AdSize x0) {
        super.setAdSize(x0);
    }

    public /* bridge */ /* synthetic */ void setAdUnitId(String x0) {
        super.setAdUnitId(x0);
    }

    public /* bridge */ /* synthetic */ void setInAppPurchaseListener(InAppPurchaseListener x0) {
        super.setInAppPurchaseListener(x0);
    }

    public /* bridge */ /* synthetic */ void setPlayStorePurchaseParams(PlayStorePurchaseListener x0, String x1) {
        super.setPlayStorePurchaseParams(x0, x1);
    }
}
