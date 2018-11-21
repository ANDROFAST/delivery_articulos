package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzbb;
    CustomEventBanner zzbc;
    CustomEventInterstitial zzbd;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzbe;
        private final MediationBannerListener zzbf;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzbe = customEventAdapter;
            this.zzbf = mediationBannerListener;
        }

        public void onClick() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzbf.onClick(this.zzbe);
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzbf.onDismissScreen(this.zzbe);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzbf.onFailedToReceiveAd(this.zzbe, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzbf.onLeaveApplication(this.zzbe);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzbf.onPresentScreen(this.zzbe);
        }

        public void onReceivedAd(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onReceivedAd.");
            this.zzbe.zza(view);
            this.zzbf.onReceivedAd(this.zzbe);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzbe;
        private final MediationInterstitialListener zzbg;
        final /* synthetic */ CustomEventAdapter zzbh;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.zzbh = customEventAdapter;
            this.zzbe = customEventAdapter2;
            this.zzbg = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onDismissScreen.");
            this.zzbg.onDismissScreen(this.zzbe);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onFailedToReceiveAd.");
            this.zzbg.onFailedToReceiveAd(this.zzbe, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onLeaveApplication.");
            this.zzbg.onLeaveApplication(this.zzbe);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onPresentScreen.");
            this.zzbg.onPresentScreen(this.zzbe);
        }

        public void onReceivedAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Custom event adapter called onReceivedAd.");
            this.zzbg.onReceivedAd(this.zzbh);
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

    public void destroy() {
        if (this.zzbc != null) {
            this.zzbc.destroy();
        }
        if (this.zzbd != null) {
            this.zzbd.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzbb;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzbc = (CustomEventBanner) zzj(serverParameters.className);
        if (this.zzbc == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzbc.requestBannerAd(new zza(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzbd = (CustomEventInterstitial) zzj(serverParameters.className);
        if (this.zzbd == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzbd.requestInterstitialAd(zza(listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzbd.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, this, mediationInterstitialListener);
    }
}
