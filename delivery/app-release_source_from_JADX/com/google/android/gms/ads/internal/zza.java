package com.google.android.gms.ads.internal;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbi;
import com.google.android.gms.internal.zzbl;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzij;
import java.util.HashSet;

@zzha
public abstract class zza extends com.google.android.gms.ads.internal.client.zzs.zza implements com.google.android.gms.ads.internal.client.zza, zzn, com.google.android.gms.ads.internal.request.zza.zza, zzdh, com.google.android.gms.internal.zzgq.zza, zzii {
    protected zzch zzoU;
    protected zzcf zzoV;
    protected zzcf zzoW;
    protected boolean zzoX = false;
    protected final zzo zzoY;
    protected final zzq zzoZ;
    protected transient AdRequestParcel zzpa;
    protected final zzay zzpb;
    protected final zzd zzpc;

    zza(zzq com_google_android_gms_ads_internal_zzq, zzo com_google_android_gms_ads_internal_zzo, zzd com_google_android_gms_ads_internal_zzd) {
        this.zzoZ = com_google_android_gms_ads_internal_zzq;
        if (com_google_android_gms_ads_internal_zzo == null) {
            com_google_android_gms_ads_internal_zzo = new zzo(this);
        }
        this.zzoY = com_google_android_gms_ads_internal_zzo;
        this.zzpc = com_google_android_gms_ads_internal_zzd;
        zzp.zzbx().zzK(this.zzoZ.context);
        zzp.zzbA().zzb(this.zzoZ.context, this.zzoZ.zzqR);
        this.zzpb = zzp.zzbA().zzgR();
    }

    private AdRequestParcel zza(AdRequestParcel adRequestParcel) {
        return (!GooglePlayServicesUtil.zzao(this.zzoZ.context) || adRequestParcel.zzty == null) ? adRequestParcel : new zzf(adRequestParcel).zza(null).zzcI();
    }

    private boolean zzaT() {
        zzb.zzaG("Ad leaving application.");
        if (this.zzoZ.zzra == null) {
            return false;
        }
        try {
            this.zzoZ.zzra.onAdLeftApplication();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdLeftApplication().", e);
            return false;
        }
    }

    public void destroy() {
        zzx.zzcx("destroy must be called on the main UI thread.");
        this.zzoY.cancel();
        this.zzpb.zzf(this.zzoZ.zzqW);
        this.zzoZ.destroy();
    }

    public boolean isLoading() {
        return this.zzoX;
    }

    public boolean isReady() {
        zzx.zzcx("isLoaded must be called on the main UI thread.");
        return this.zzoZ.zzqT == null && this.zzoZ.zzqU == null && this.zzoZ.zzqW != null;
    }

    public void onAdClicked() {
        if (this.zzoZ.zzqW == null) {
            zzb.zzaH("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzb.zzaF("Pinging click URLs.");
        this.zzoZ.zzqY.zzgE();
        if (this.zzoZ.zzqW.zzAQ != null) {
            zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW.zzAQ);
        }
        if (this.zzoZ.zzqZ != null) {
            try {
                this.zzoZ.zzqZ.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String name, String info) {
        if (this.zzoZ.zzrb != null) {
            try {
                this.zzoZ.zzrb.onAppEvent(name, info);
            } catch (Throwable e) {
                zzb.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzx.zzcx("pause must be called on the main UI thread.");
    }

    protected void recordImpression() {
        zzc(this.zzoZ.zzqW);
    }

    public void resume() {
        zzx.zzcx("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean enabled) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void stopLoading() {
        zzx.zzcx("stopLoading must be called on the main UI thread.");
        this.zzoX = false;
        this.zzoZ.zzf(true);
    }

    Bundle zza(zzbl com_google_android_gms_internal_zzbl) {
        if (com_google_android_gms_internal_zzbl == null) {
            return null;
        }
        String zzcu;
        if (com_google_android_gms_internal_zzbl.zzcF()) {
            com_google_android_gms_internal_zzbl.wakeup();
        }
        zzbi zzcD = com_google_android_gms_internal_zzbl.zzcD();
        if (zzcD != null) {
            zzcu = zzcD.zzcu();
            zzb.zzaF("In AdManger: loadAd, " + zzcD.toString());
        } else {
            zzcu = null;
        }
        if (zzcu == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", zzcu);
        bundle.putInt("v", 1);
        return bundle;
    }

    public void zza(AdSizeParcel adSizeParcel) {
        zzx.zzcx("setAdSize must be called on the main UI thread.");
        this.zzoZ.zzqV = adSizeParcel;
        if (!(this.zzoZ.zzqW == null || this.zzoZ.zzqW.zzDC == null || this.zzoZ.zzrp != 0)) {
            this.zzoZ.zzqW.zzDC.zza(adSizeParcel);
        }
        if (this.zzoZ.zzqS != null) {
            if (this.zzoZ.zzqS.getChildCount() > 1) {
                this.zzoZ.zzqS.removeView(this.zzoZ.zzqS.getNextView());
            }
            this.zzoZ.zzqS.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzoZ.zzqS.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzoZ.zzqS.requestLayout();
        }
    }

    public void zza(com.google.android.gms.ads.internal.client.zzn com_google_android_gms_ads_internal_client_zzn) {
        zzx.zzcx("setAdListener must be called on the main UI thread.");
        this.zzoZ.zzqZ = com_google_android_gms_ads_internal_client_zzn;
    }

    public void zza(zzo com_google_android_gms_ads_internal_client_zzo) {
        zzx.zzcx("setAdListener must be called on the main UI thread.");
        this.zzoZ.zzra = com_google_android_gms_ads_internal_client_zzo;
    }

    public void zza(zzu com_google_android_gms_ads_internal_client_zzu) {
        zzx.zzcx("setAppEventListener must be called on the main UI thread.");
        this.zzoZ.zzrb = com_google_android_gms_ads_internal_client_zzu;
    }

    public void zza(zzv com_google_android_gms_ads_internal_client_zzv) {
        zzx.zzcx("setCorrelationIdProvider must be called on the main UI thread");
        this.zzoZ.zzrc = com_google_android_gms_ads_internal_client_zzv;
    }

    public void zza(zzcl com_google_android_gms_internal_zzcl) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzgc com_google_android_gms_internal_zzgc) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzgg com_google_android_gms_internal_zzgg, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza) {
        if (!(com_google_android_gms_internal_zzie_zza.zzJL.zzGR == -1 || TextUtils.isEmpty(com_google_android_gms_internal_zzie_zza.zzJL.zzHb))) {
            long zzo = zzo(com_google_android_gms_internal_zzie_zza.zzJL.zzHb);
            if (zzo != -1) {
                zzcf zzb = this.zzoU.zzb(zzo + com_google_android_gms_internal_zzie_zza.zzJL.zzGR);
                this.zzoU.zza(zzb, "stc");
            }
        }
        this.zzoU.zzR(com_google_android_gms_internal_zzie_zza.zzJL.zzHb);
        this.zzoU.zza(this.zzoV, "arf");
        this.zzoW = this.zzoU.zzdu();
        this.zzoU.zzd("gqi", com_google_android_gms_internal_zzie_zza.zzJL.zzHc);
        this.zzoZ.zzqT = null;
        this.zzoZ.zzqX = com_google_android_gms_internal_zzie_zza;
        zza(com_google_android_gms_internal_zzie_zza, this.zzoU);
    }

    protected abstract void zza(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, zzch com_google_android_gms_internal_zzch);

    public void zza(HashSet<zzif> hashSet) {
        this.zzoZ.zza(hashSet);
    }

    protected abstract boolean zza(AdRequestParcel adRequestParcel, zzch com_google_android_gms_internal_zzch);

    boolean zza(zzie com_google_android_gms_internal_zzie) {
        return false;
    }

    protected abstract boolean zza(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2);

    void zzaN() {
        this.zzoU = new zzch(((Boolean) zzbz.zzvL.get()).booleanValue(), "load_ad", this.zzoZ.zzqV.zztV);
        this.zzoV = new zzcf(-1, null, null);
        this.zzoW = new zzcf(-1, null, null);
    }

    public zzd zzaO() {
        zzx.zzcx("getAdFrame must be called on the main UI thread.");
        return zze.zzB(this.zzoZ.zzqS);
    }

    public AdSizeParcel zzaP() {
        zzx.zzcx("getAdSize must be called on the main UI thread.");
        return this.zzoZ.zzqV == null ? null : new ThinAdSizeParcel(this.zzoZ.zzqV);
    }

    public void zzaQ() {
        zzaT();
    }

    public void zzaR() {
        zzx.zzcx("recordManualImpression must be called on the main UI thread.");
        if (this.zzoZ.zzqW == null) {
            zzb.zzaH("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzb.zzaF("Pinging manual tracking URLs.");
        if (this.zzoZ.zzqW.zzGP != null) {
            zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW.zzGP);
        }
    }

    protected boolean zzaS() {
        zzb.m7v("Ad closing.");
        if (this.zzoZ.zzra == null) {
            return false;
        }
        try {
            this.zzoZ.zzra.onAdClosed();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdClosed().", e);
            return false;
        }
    }

    protected boolean zzaU() {
        zzb.zzaG("Ad opening.");
        if (this.zzoZ.zzra == null) {
            return false;
        }
        try {
            this.zzoZ.zzra.onAdOpened();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdOpened().", e);
            return false;
        }
    }

    protected boolean zzaV() {
        zzb.zzaG("Ad finished loading.");
        this.zzoX = false;
        if (this.zzoZ.zzra == null) {
            return false;
        }
        try {
            this.zzoZ.zzra.onAdLoaded();
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdLoaded().", e);
            return false;
        }
    }

    protected void zzb(View view) {
        this.zzoZ.zzqS.addView(view, zzp.zzbz().zzhg());
    }

    public void zzb(zzie com_google_android_gms_internal_zzie) {
        this.zzoU.zza(this.zzoW, "awr");
        this.zzoZ.zzqU = null;
        if (!(com_google_android_gms_internal_zzie.errorCode == -2 || com_google_android_gms_internal_zzie.errorCode == 3)) {
            zzp.zzbA().zzb(this.zzoZ.zzbM());
        }
        if (com_google_android_gms_internal_zzie.errorCode == -1) {
            this.zzoX = false;
            return;
        }
        if (zza(com_google_android_gms_internal_zzie)) {
            zzb.zzaF("Ad refresh scheduled.");
        }
        if (com_google_android_gms_internal_zzie.errorCode != -2) {
            zzf(com_google_android_gms_internal_zzie.errorCode);
            return;
        }
        if (this.zzoZ.zzrn == null) {
            this.zzoZ.zzrn = new zzij(this.zzoZ.zzqP);
        }
        this.zzpb.zze(this.zzoZ.zzqW);
        if (zza(this.zzoZ.zzqW, com_google_android_gms_internal_zzie)) {
            this.zzoZ.zzqW = com_google_android_gms_internal_zzie;
            this.zzoZ.zzbV();
            this.zzoU.zzd("is_mraid", this.zzoZ.zzqW.zzcb() ? "1" : "0");
            this.zzoU.zzd("is_mediation", this.zzoZ.zzqW.zzGN ? "1" : "0");
            if (!(this.zzoZ.zzqW.zzDC == null || this.zzoZ.zzqW.zzDC.zzhC() == null)) {
                this.zzoU.zzd("is_video", this.zzoZ.zzqW.zzDC.zzhC().zzhP() ? "1" : "0");
            }
            this.zzoU.zza(this.zzoV, "ttc");
            if (zzp.zzbA().zzgM() != null) {
                zzp.zzbA().zzgM().zza(this.zzoU);
            }
            if (this.zzoZ.zzbQ()) {
                zzaV();
            }
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzx.zzcx("loadAd must be called on the main UI thread.");
        AdRequestParcel zza = zza(adRequestParcel);
        if (this.zzoZ.zzqT == null && this.zzoZ.zzqU == null) {
            zzb.zzaG("Starting ad request.");
            zzaN();
            this.zzoV = this.zzoU.zzdu();
            if (!zza.zztt) {
                zzb.zzaG("Use AdRequest.Builder.addTestDevice(\"" + zzl.zzcN().zzS(this.zzoZ.context) + "\") to get test ads on this device.");
            }
            this.zzoX = zza(zza, this.zzoU);
            return this.zzoX;
        }
        if (this.zzpa != null) {
            zzb.zzaH("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzb.zzaH("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzpa = zza;
        return false;
    }

    protected void zzc(zzie com_google_android_gms_internal_zzie) {
        if (com_google_android_gms_internal_zzie == null) {
            zzb.zzaH("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzb.zzaF("Pinging Impression URLs.");
        this.zzoZ.zzqY.zzgD();
        if (com_google_android_gms_internal_zzie.zzAR != null) {
            zzp.zzbx().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, com_google_android_gms_internal_zzie.zzAR);
        }
    }

    protected boolean zzc(AdRequestParcel adRequestParcel) {
        ViewParent parent = this.zzoZ.zzqS.getParent();
        return (parent instanceof View) && ((View) parent).isShown() && zzp.zzbx().zzgY();
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (zzc(adRequestParcel)) {
            zzb(adRequestParcel);
            return;
        }
        zzb.zzaG("Ad is not visible. Not refreshing ad.");
        this.zzoY.zzg(adRequestParcel);
    }

    protected boolean zzf(int i) {
        zzb.zzaH("Failed to load ad: " + i);
        this.zzoX = false;
        if (this.zzoZ.zzra == null) {
            return false;
        }
        try {
            this.zzoZ.zzra.onAdFailedToLoad(i);
            return true;
        } catch (Throwable e) {
            zzb.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            return false;
        }
    }

    long zzo(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzb.zzaH("Invalid index for Url fetch time in CSI latency info.");
            return -1;
        } catch (NumberFormatException e2) {
            zzb.zzaH("Cannot find valid format of Url fetch time in CSI latency info.");
            return -1;
        }
    }
}
