package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzha;

@zzha
public class zzaa {
    private final Context mContext;
    private final zzh zzoq;
    private String zzpH;
    private zza zztn;
    private AdListener zzto;
    private PlayStorePurchaseListener zzuA;
    private OnCustomRenderedAdLoadedListener zzuB;
    private Correlator zzuC;
    private PublisherInterstitialAd zzuE;
    private AppEventListener zzub;
    private final zzev zzuu;
    private zzs zzuw;
    private String zzux;
    private InAppPurchaseListener zzuz;

    public zzaa(Context context) {
        this(context, zzh.zzcJ(), null);
    }

    public zzaa(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzh.zzcJ(), publisherInterstitialAd);
    }

    public zzaa(Context context, zzh com_google_android_gms_ads_internal_client_zzh, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzuu = new zzev();
        this.mContext = context;
        this.zzoq = com_google_android_gms_ads_internal_client_zzh;
        this.zzuE = publisherInterstitialAd;
    }

    private void zzM(String str) throws RemoteException {
        if (this.zzpH == null) {
            zzN(str);
        }
        this.zzuw = zzl.zzcO().zzb(this.mContext, new AdSizeParcel(), this.zzpH, this.zzuu);
        if (this.zzto != null) {
            this.zzuw.zza(new zzc(this.zzto));
        }
        if (this.zztn != null) {
            this.zzuw.zza(new zzb(this.zztn));
        }
        if (this.zzub != null) {
            this.zzuw.zza(new zzj(this.zzub));
        }
        if (this.zzuz != null) {
            this.zzuw.zza(new zzgh(this.zzuz));
        }
        if (this.zzuA != null) {
            this.zzuw.zza(new zzgl(this.zzuA), this.zzux);
        }
        if (this.zzuB != null) {
            this.zzuw.zza(new zzcm(this.zzuB));
        }
        if (this.zzuC != null) {
            this.zzuw.zza(this.zzuC.zzaH());
        }
    }

    private void zzN(String str) {
        if (this.zzuw == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public AdListener getAdListener() {
        return this.zzto;
    }

    public String getAdUnitId() {
        return this.zzpH;
    }

    public AppEventListener getAppEventListener() {
        return this.zzub;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzuz;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zzuw != null) {
                return this.zzuw.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzuB;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.zzuw != null) {
                z = this.zzuw.isReady();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public boolean isLoading() {
        boolean z = false;
        try {
            if (this.zzuw != null) {
                z = this.zzuw.isLoading();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is loading.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzto = adListener;
            if (this.zzuw != null) {
                this.zzuw.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.zzpH != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzpH = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzub = appEventListener;
            if (this.zzuw != null) {
                this.zzuw.zza(appEventListener != null ? new zzj(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.zzuC = correlator;
        try {
            if (this.zzuw != null) {
                this.zzuw.zza(this.zzuC == null ? null : this.zzuC.zzaH());
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zzuA != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zzuz = inAppPurchaseListener;
            if (this.zzuw != null) {
                this.zzuw.zza(inAppPurchaseListener != null ? new zzgh(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzuB = onCustomRenderedAdLoadedListener;
            if (this.zzuw != null) {
                this.zzuw.zza(onCustomRenderedAdLoadedListener != null ? new zzcm(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        if (this.zzuz != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zzuA = playStorePurchaseListener;
            this.zzux = publicKey;
            if (this.zzuw != null) {
                this.zzuw.zza(playStorePurchaseListener != null ? new zzgl(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            zzN("show");
            this.zzuw.showInterstitial();
        } catch (Throwable e) {
            zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza com_google_android_gms_ads_internal_client_zza) {
        try {
            this.zztn = com_google_android_gms_ads_internal_client_zza;
            if (this.zzuw != null) {
                this.zzuw.zza(com_google_android_gms_ads_internal_client_zza != null ? new zzb(com_google_android_gms_ads_internal_client_zza) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzy com_google_android_gms_ads_internal_client_zzy) {
        try {
            if (this.zzuw == null) {
                zzM("loadAd");
            }
            if (this.zzuw.zzb(this.zzoq.zza(this.mContext, com_google_android_gms_ads_internal_client_zzy))) {
                this.zzuu.zze(com_google_android_gms_ads_internal_client_zzy.zzcV());
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }
}
