package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzha;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public class zzz {
    private final zzh zzoq;
    private String zzpH;
    private boolean zzpt;
    private zza zztn;
    private AdListener zzto;
    private PlayStorePurchaseListener zzuA;
    private OnCustomRenderedAdLoadedListener zzuB;
    private Correlator zzuC;
    private boolean zzuD;
    private AppEventListener zzub;
    private AdSize[] zzuc;
    private final zzev zzuu;
    private final AtomicBoolean zzuv;
    private zzs zzuw;
    private String zzux;
    private ViewGroup zzuy;
    private InAppPurchaseListener zzuz;

    public zzz(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzh.zzcJ(), false);
    }

    public zzz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzh.zzcJ(), false);
    }

    zzz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh com_google_android_gms_ads_internal_client_zzh, zzs com_google_android_gms_ads_internal_client_zzs, boolean z2) {
        this.zzuu = new zzev();
        this.zzuy = viewGroup;
        this.zzoq = com_google_android_gms_ads_internal_client_zzh;
        this.zzuw = com_google_android_gms_ads_internal_client_zzs;
        this.zzuv = new AtomicBoolean(false);
        this.zzuD = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzk com_google_android_gms_ads_internal_client_zzk = new zzk(context, attributeSet);
                this.zzuc = com_google_android_gms_ads_internal_client_zzk.zzj(z);
                this.zzpH = com_google_android_gms_ads_internal_client_zzk.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzl.zzcN().zza(viewGroup, zza(context, this.zzuc[0], this.zzuD), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzl.zzcN().zza(viewGroup, new AdSizeParcel(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    zzz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh com_google_android_gms_ads_internal_client_zzh, boolean z2) {
        this(viewGroup, attributeSet, z, com_google_android_gms_ads_internal_client_zzh, null, z2);
    }

    public zzz(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, zzh.zzcJ(), z2);
    }

    public zzz(ViewGroup viewGroup, boolean z) {
        this(viewGroup, null, false, zzh.zzcJ(), z);
    }

    private static AdSizeParcel zza(Context context, AdSize adSize, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, adSize);
        adSizeParcel.zzi(z);
        return adSizeParcel;
    }

    private static AdSizeParcel zza(Context context, AdSize[] adSizeArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, adSizeArr);
        adSizeParcel.zzi(z);
        return adSizeParcel;
    }

    private void zzcZ() {
        try {
            zzd zzaO = this.zzuw.zzaO();
            if (zzaO != null) {
                this.zzuy.addView((View) zze.zzp(zzaO));
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get an ad frame.", e);
        }
    }

    public void destroy() {
        try {
            if (this.zzuw != null) {
                this.zzuw.destroy();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.zzto;
    }

    public AdSize getAdSize() {
        try {
            if (this.zzuw != null) {
                AdSizeParcel zzaP = this.zzuw.zzaP();
                if (zzaP != null) {
                    return zzaP.zzcL();
                }
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get the current AdSize.", e);
        }
        return this.zzuc != null ? this.zzuc[0] : null;
    }

    public AdSize[] getAdSizes() {
        return this.zzuc;
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

    public boolean isLoading() {
        try {
            if (this.zzuw != null) {
                return this.zzuw.isLoading();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public void pause() {
        try {
            if (this.zzuw != null) {
                this.zzuw.pause();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.zzuv.getAndSet(true)) {
            try {
                if (this.zzuw != null) {
                    this.zzuw.zzaR();
                }
            } catch (Throwable e) {
                zzb.zzd("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.zzuw != null) {
                this.zzuw.resume();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to call resume.", e);
        }
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

    public void setAdSizes(AdSize... adSizes) {
        if (this.zzuc != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.zzpH != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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

    public void setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
        this.zzpt = manualImpressionsEnabled;
        try {
            if (this.zzuw != null) {
                this.zzuw.setManualImpressionsEnabled(this.zzpt);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set manual impressions.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzuB = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzuw != null) {
                this.zzuw.zza(onCustomRenderedAdLoadedListener != null ? new zzcm(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        if (this.zzuz != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
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
                zzda();
            }
            if (this.zzuw.zzb(this.zzoq.zza(this.zzuy.getContext(), com_google_android_gms_ads_internal_client_zzy))) {
                this.zzuu.zze(com_google_android_gms_ads_internal_client_zzy.zzcV());
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.zzuc = adSizeArr;
        try {
            if (this.zzuw != null) {
                this.zzuw.zza(zza(this.zzuy.getContext(), this.zzuc, this.zzuD));
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the ad size.", e);
        }
        this.zzuy.requestLayout();
    }

    void zzda() throws RemoteException {
        if ((this.zzuc == null || this.zzpH == null) && this.zzuw == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.zzuw = zzdb();
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
        this.zzuw.setManualImpressionsEnabled(this.zzpt);
        zzcZ();
    }

    protected zzs zzdb() throws RemoteException {
        Context context = this.zzuy.getContext();
        return zzl.zzcO().zza(context, zza(context, this.zzuc, this.zzuD), this.zzpH, this.zzuu);
    }
}
