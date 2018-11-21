package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public final class zzfj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzey zzBK;

    class C02971 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C02971(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    class C02982 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C02982(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C02993 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C02993(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C03004 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C03004(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    class C03026 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C03026(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdLeftApplication();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C03037 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C03037(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    class C03048 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C03048(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    class C03059 implements Runnable {
        final /* synthetic */ zzfj zzBQ;

        C03059(zzfj com_google_android_gms_internal_zzfj) {
            this.zzBQ = com_google_android_gms_internal_zzfj;
        }

        public void run() {
            try {
                this.zzBQ.zzBK.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzfj(zzey com_google_android_gms_internal_zzey) {
        this.zzBK = com_google_android_gms_internal_zzey;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaF("Adapter called onClick.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdClicked();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzb.zzaH("onClick must be called on the main UI thread.");
        zza.zzLE.post(new C02971(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaF("Adapter called onDismissScreen.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaH("onDismissScreen must be called on the main UI thread.");
        zza.zzLE.post(new C03004(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaF("Adapter called onDismissScreen.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaH("onDismissScreen must be called on the main UI thread.");
        zza.zzLE.post(new C03059(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        zzb.zzaF("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdFailedToLoad(zzfk.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaH("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzLE.post(new Runnable(this) {
            final /* synthetic */ zzfj zzBQ;

            public void run() {
                try {
                    this.zzBQ.zzBK.onAdFailedToLoad(zzfk.zza(errorCode));
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        zzb.zzaF("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdFailedToLoad(zzfk.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaH("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzLE.post(new Runnable(this) {
            final /* synthetic */ zzfj zzBQ;

            public void run() {
                try {
                    this.zzBQ.zzBK.onAdFailedToLoad(zzfk.zza(errorCode));
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaF("Adapter called onLeaveApplication.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaH("onLeaveApplication must be called on the main UI thread.");
        zza.zzLE.post(new C03026(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaF("Adapter called onLeaveApplication.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaH("onLeaveApplication must be called on the main UI thread.");
        zza.zzLE.post(new Runnable(this) {
            final /* synthetic */ zzfj zzBQ;

            {
                this.zzBQ = r1;
            }

            public void run() {
                try {
                    this.zzBQ.zzBK.onAdLeftApplication();
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaF("Adapter called onPresentScreen.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaH("onPresentScreen must be called on the main UI thread.");
        zza.zzLE.post(new C03037(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaF("Adapter called onPresentScreen.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaH("onPresentScreen must be called on the main UI thread.");
        zza.zzLE.post(new C02982(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaF("Adapter called onReceivedAd.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaH("onReceivedAd must be called on the main UI thread.");
        zza.zzLE.post(new C03048(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaF("Adapter called onReceivedAd.");
        if (zzl.zzcN().zzhr()) {
            try {
                this.zzBK.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaH("onReceivedAd must be called on the main UI thread.");
        zza.zzLE.post(new C02993(this));
    }
}
