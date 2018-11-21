package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner zzMW;
    CustomEventInterstitial zzMX;
    CustomEventNative zzMY;
    private View zzbb;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzMZ;
        private final MediationBannerListener zzaT;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzMZ = customEventAdapter;
            this.zzaT = mediationBannerListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClicked.");
            this.zzaT.onAdClicked(this.zzMZ);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClosed.");
            this.zzaT.onAdClosed(this.zzMZ);
        }

        public void onAdFailedToLoad(int errorCode) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
            this.zzaT.onAdFailedToLoad(this.zzMZ, errorCode);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLeftApplication.");
            this.zzaT.onAdLeftApplication(this.zzMZ);
        }

        public void onAdLoaded(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLoaded.");
            this.zzMZ.zza(view);
            this.zzaT.onAdLoaded(this.zzMZ);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdOpened.");
            this.zzaT.onAdOpened(this.zzMZ);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzMZ;
        final /* synthetic */ CustomEventAdapter zzNa;
        private final MediationInterstitialListener zzaU;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzNa = customEventAdapter;
            this.zzMZ = customEventAdapter2;
            this.zzaU = mediationInterstitialListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClicked.");
            this.zzaU.onAdClicked(this.zzMZ);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClosed.");
            this.zzaU.onAdClosed(this.zzMZ);
        }

        public void onAdFailedToLoad(int errorCode) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzaU.onAdFailedToLoad(this.zzMZ, errorCode);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLeftApplication.");
            this.zzaU.onAdLeftApplication(this.zzMZ);
        }

        public void onAdLoaded() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onReceivedAd.");
            this.zzaU.onAdLoaded(this.zzNa);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdOpened.");
            this.zzaU.onAdOpened(this.zzMZ);
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzMZ;
        private final MediationNativeListener zzaV;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzMZ = customEventAdapter;
            this.zzaV = mediationNativeListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClicked.");
            this.zzaV.onAdClicked(this.zzMZ);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdClosed.");
            this.zzaV.onAdClosed(this.zzMZ);
        }

        public void onAdFailedToLoad(int errorCode) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdFailedToLoad.");
            this.zzaV.onAdFailedToLoad(this.zzMZ, errorCode);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLeftApplication.");
            this.zzaV.onAdLeftApplication(this.zzMZ);
        }

        public void onAdLoaded(NativeAdMapper ad) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdLoaded.");
            this.zzaV.onAdLoaded(this.zzMZ, ad);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onAdOpened.");
            this.zzaV.onAdOpened(this.zzMZ);
        }
    }

    private void zza(View view) {
        this.zzbb = view;
    }

    private static <T> T zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    public View getBannerView() {
        return this.zzbb;
    }

    public void onDestroy() {
        if (this.zzMW != null) {
            this.zzMW.onDestroy();
        }
        if (this.zzMX != null) {
            this.zzMX.onDestroy();
        }
        if (this.zzMY != null) {
            this.zzMY.onDestroy();
        }
    }

    public void onPause() {
        if (this.zzMW != null) {
            this.zzMW.onPause();
        }
        if (this.zzMX != null) {
            this.zzMX.onPause();
        }
        if (this.zzMY != null) {
            this.zzMY.onPause();
        }
    }

    public void onResume() {
        if (this.zzMW != null) {
            this.zzMW.onResume();
        }
        if (this.zzMX != null) {
            this.zzMX.onResume();
        }
        if (this.zzMY != null) {
            this.zzMY.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzMW = (CustomEventBanner) zzj(serverParameters.getString("class_name"));
        if (this.zzMW == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzMW.requestBannerAd(context, new zza(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzMX = (CustomEventInterstitial) zzj(serverParameters.getString("class_name"));
        if (this.zzMX == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzMX.requestInterstitialAd(context, zza(listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestNativeAd(Context context, MediationNativeListener listener, Bundle serverParameters, NativeMediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.zzMY = (CustomEventNative) zzj(serverParameters.getString("class_name"));
        if (this.zzMY == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.zzMY.requestNativeAd(context, new zzc(this, listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.zzMX.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
