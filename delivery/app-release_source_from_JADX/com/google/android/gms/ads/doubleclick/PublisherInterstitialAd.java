package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzaa;

public final class PublisherInterstitialAd {
    private final zzaa zzoA;

    public PublisherInterstitialAd(Context context) {
        this.zzoA = new zzaa(context, this);
    }

    public AdListener getAdListener() {
        return this.zzoA.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzoA.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzoA.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoA.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzoA.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoaded() {
        return this.zzoA.isLoaded();
    }

    public boolean isLoading() {
        return this.zzoA.isLoading();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzoA.zza(publisherAdRequest.zzaG());
    }

    public void setAdListener(AdListener adListener) {
        this.zzoA.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.zzoA.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzoA.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.zzoA.setCorrelator(correlator);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzoA.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.zzoA.show();
    }
}
