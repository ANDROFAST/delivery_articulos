package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzeg extends zza {
    private zzec zzAd;
    private zzgg zzAe;
    private String zzAf;
    private String zzpH;
    private zzea zzzU;
    private zzk zzzX;

    public zzeg(Context context, String str, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        this(str, new zzea(context.getApplicationContext(), com_google_android_gms_internal_zzew, versionInfoParcel, com_google_android_gms_ads_internal_zzd));
    }

    public zzeg(String str, zzea com_google_android_gms_internal_zzea) {
        this.zzpH = str;
        this.zzzU = com_google_android_gms_internal_zzea;
        this.zzAd = new zzec();
        zzp.zzbI().zza(com_google_android_gms_internal_zzea);
    }

    private void zzee() {
        if (this.zzzX != null && this.zzAe != null) {
            this.zzzX.zza(this.zzAe, this.zzAf);
        }
    }

    void abort() {
        if (this.zzzX == null) {
            this.zzzX = this.zzzU.zzac(this.zzpH);
            this.zzAd.zzc(this.zzzX);
            zzee();
        }
    }

    public void destroy() throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.destroy();
        }
    }

    public String getMediationAdapterClassName() throws RemoteException {
        return this.zzzX != null ? this.zzzX.getMediationAdapterClassName() : null;
    }

    public boolean isLoading() throws RemoteException {
        return this.zzzX != null && this.zzzX.isLoading();
    }

    public boolean isReady() throws RemoteException {
        return this.zzzX != null && this.zzzX.isReady();
    }

    public void pause() throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.pause();
        }
    }

    public void resume() throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean manualImpressionsEnabled) throws RemoteException {
        abort();
        if (this.zzzX != null) {
            this.zzzX.setManualImpressionsEnabled(manualImpressionsEnabled);
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.showInterstitial();
        } else {
            zzb.zzaH("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.stopLoading();
        }
    }

    public void zza(AdSizeParcel adSizeParcel) throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.zza(adSizeParcel);
        }
    }

    public void zza(zzn com_google_android_gms_ads_internal_client_zzn) throws RemoteException {
        this.zzAd.zzzP = com_google_android_gms_ads_internal_client_zzn;
        if (this.zzzX != null) {
            this.zzAd.zzc(this.zzzX);
        }
    }

    public void zza(zzo com_google_android_gms_ads_internal_client_zzo) throws RemoteException {
        this.zzAd.zzpz = com_google_android_gms_ads_internal_client_zzo;
        if (this.zzzX != null) {
            this.zzAd.zzc(this.zzzX);
        }
    }

    public void zza(zzu com_google_android_gms_ads_internal_client_zzu) throws RemoteException {
        this.zzAd.zzzM = com_google_android_gms_ads_internal_client_zzu;
        if (this.zzzX != null) {
            this.zzAd.zzc(this.zzzX);
        }
    }

    public void zza(zzv com_google_android_gms_ads_internal_client_zzv) throws RemoteException {
        abort();
        if (this.zzzX != null) {
            this.zzzX.zza(com_google_android_gms_ads_internal_client_zzv);
        }
    }

    public void zza(zzcl com_google_android_gms_internal_zzcl) throws RemoteException {
        this.zzAd.zzzO = com_google_android_gms_internal_zzcl;
        if (this.zzzX != null) {
            this.zzAd.zzc(this.zzzX);
        }
    }

    public void zza(zzgc com_google_android_gms_internal_zzgc) throws RemoteException {
        this.zzAd.zzzN = com_google_android_gms_internal_zzgc;
        if (this.zzzX != null) {
            this.zzAd.zzc(this.zzzX);
        }
    }

    public void zza(zzgg com_google_android_gms_internal_zzgg, String str) throws RemoteException {
        this.zzAe = com_google_android_gms_internal_zzgg;
        this.zzAf = str;
        zzee();
    }

    public com.google.android.gms.dynamic.zzd zzaO() throws RemoteException {
        return this.zzzX != null ? this.zzzX.zzaO() : null;
    }

    public AdSizeParcel zzaP() throws RemoteException {
        return this.zzzX != null ? this.zzzX.zzaP() : null;
    }

    public void zzaR() throws RemoteException {
        if (this.zzzX != null) {
            this.zzzX.zzaR();
        } else {
            zzb.zzaH("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) throws RemoteException {
        if (adRequestParcel.zztx != null) {
            abort();
        }
        if (this.zzzX != null) {
            return this.zzzX.zzb(adRequestParcel);
        }
        zza zza = zzp.zzbI().zza(adRequestParcel, this.zzpH);
        if (zza != null) {
            if (!zza.zzAa) {
                zza.zzh(adRequestParcel);
            }
            this.zzzX = zza.zzzX;
            zza.zzc(this.zzzU);
            zza.zzzY.zza(this.zzAd);
            this.zzAd.zzc(this.zzzX);
            zzee();
            return zza.zzAb;
        }
        this.zzzX = this.zzzU.zzac(this.zzpH);
        this.zzAd.zzc(this.zzzX);
        zzee();
        return this.zzzX.zzb(adRequestParcel);
    }
}
