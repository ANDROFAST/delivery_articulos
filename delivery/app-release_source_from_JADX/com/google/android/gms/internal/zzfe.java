package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzx;

@zzha
public final class zzfe implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzey zzBK;
    private NativeAdMapper zzBL;

    public zzfe(zzey com_google_android_gms_internal_zzey) {
        this.zzBK = com_google_android_gms_internal_zzey;
    }

    public void onAdClicked(MediationBannerAdapter adapter) {
        zzx.zzcx("onAdClicked must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClicked.");
        try {
            this.zzBK.onAdClicked();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter adapter) {
        zzx.zzcx("onAdClicked must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClicked.");
        try {
            this.zzBK.onAdClicked();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationNativeAdapter adapter) {
        zzx.zzcx("onAdClicked must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClicked.");
        try {
            this.zzBK.onAdClicked();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter adapter) {
        zzx.zzcx("onAdClosed must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClosed.");
        try {
            this.zzBK.onAdClosed();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter adapter) {
        zzx.zzcx("onAdClosed must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClosed.");
        try {
            this.zzBK.onAdClosed();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationNativeAdapter adapter) {
        zzx.zzcx("onAdClosed must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdClosed.");
        try {
            this.zzBK.onAdClosed();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter adapter, int errorCode) {
        zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdFailedToLoad with error. " + errorCode);
        try {
            this.zzBK.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter adapter, int errorCode) {
        zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdFailedToLoad with error " + errorCode + ".");
        try {
            this.zzBK.onAdFailedToLoad(errorCode);
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationNativeAdapter adapter, int error) {
        zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdFailedToLoad with error " + error + ".");
        try {
            this.zzBK.onAdFailedToLoad(error);
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter adapter) {
        zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLeftApplication.");
        try {
            this.zzBK.onAdLeftApplication();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter adapter) {
        zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLeftApplication.");
        try {
            this.zzBK.onAdLeftApplication();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationNativeAdapter adapter) {
        zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLeftApplication.");
        try {
            this.zzBK.onAdLeftApplication();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter adapter) {
        zzx.zzcx("onAdLoaded must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLoaded.");
        try {
            this.zzBK.onAdLoaded();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter adapter) {
        zzx.zzcx("onAdLoaded must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLoaded.");
        try {
            this.zzBK.onAdLoaded();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationNativeAdapter adapter, NativeAdMapper nativeAdMapper) {
        zzx.zzcx("onAdLoaded must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdLoaded.");
        this.zzBL = nativeAdMapper;
        try {
            this.zzBK.onAdLoaded();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter adapter) {
        zzx.zzcx("onAdOpened must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdOpened.");
        try {
            this.zzBK.onAdOpened();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter adapter) {
        zzx.zzcx("onAdOpened must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdOpened.");
        try {
            this.zzBK.onAdOpened();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationNativeAdapter adapter) {
        zzx.zzcx("onAdOpened must be called on the main UI thread.");
        zzb.zzaF("Adapter called onAdOpened.");
        try {
            this.zzBK.onAdOpened();
        } catch (Throwable e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public NativeAdMapper zzey() {
        return this.zzBL;
    }
}
