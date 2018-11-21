package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzex.zza;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzha
public final class zzfd extends zza {
    private final MediationAdapter zzBI;
    private zzfe zzBJ;

    public zzfd(MediationAdapter mediationAdapter) {
        this.zzBI = mediationAdapter;
    }

    private Bundle zza(String str, int i, String str2) throws RemoteException {
        zzb.zzaH("Server parameters: " + str);
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    bundle2.putString(str3, jSONObject.getString(str3));
                }
                bundle = bundle2;
            }
            if (this.zzBI instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                bundle.putInt("tagForChildDirectedTreatment", i);
            }
            return bundle;
        } catch (Throwable th) {
            zzb.zzd("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.zzBI.onDestroy();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public Bundle getInterstitialAdapterInfo() {
        if (this.zzBI instanceof zzjy) {
            return ((zzjy) this.zzBI).getInterstitialAdapterInfo();
        }
        zzb.zzaH("MediationAdapter is not a v2 MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
        return new Bundle();
    }

    public zzd getView() throws RemoteException {
        if (this.zzBI instanceof MediationBannerAdapter) {
            try {
                return zze.zzB(((MediationBannerAdapter) this.zzBI).getBannerView());
            } catch (Throwable th) {
                zzb.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public boolean isInitialized() throws RemoteException {
        if (this.zzBI instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzaF("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzBI).isInitialized();
            } catch (Throwable th) {
                zzb.zzd("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        try {
            this.zzBI.onPause();
        } catch (Throwable th) {
            zzb.zzd("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void resume() throws RemoteException {
        try {
            this.zzBI.onResume();
        } catch (Throwable th) {
            zzb.zzd("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzBI instanceof MediationInterstitialAdapter) {
            zzb.zzaF("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzBI).showInterstitial();
            } catch (Throwable th) {
                zzb.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void showVideo() throws RemoteException {
        if (this.zzBI instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzaF("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzBI).showVideo();
            } catch (Throwable th) {
                zzb.zzd("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza com_google_android_gms_ads_internal_reward_mediation_client_zza, String str2) throws RemoteException {
        if (this.zzBI instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzaF("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzBI;
                mediationRewardedVideoAdAdapter.initialize((Context) zze.zzp(com_google_android_gms_dynamic_zzd), new zzfc(adRequestParcel.zztq == -1 ? null : new Date(adRequestParcel.zztq), adRequestParcel.zztr, adRequestParcel.zzts != null ? new HashSet(adRequestParcel.zzts) : null, adRequestParcel.zzty, adRequestParcel.zztt, adRequestParcel.zztu, adRequestParcel.zztF), str, new com.google.android.gms.ads.internal.reward.mediation.client.zzb(com_google_android_gms_ads_internal_reward_mediation_client_zza), zza(str2, adRequestParcel.zztu, null), adRequestParcel.zztA != null ? adRequestParcel.zztA.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, zzey com_google_android_gms_internal_zzey) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adRequestParcel, str, null, com_google_android_gms_internal_zzey);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, String str2, zzey com_google_android_gms_internal_zzey) throws RemoteException {
        if (this.zzBI instanceof MediationInterstitialAdapter) {
            zzb.zzaF("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzBI;
                mediationInterstitialAdapter.requestInterstitialAd((Context) zze.zzp(com_google_android_gms_dynamic_zzd), new zzfe(com_google_android_gms_internal_zzey), zza(str, adRequestParcel.zztu, str2), new zzfc(adRequestParcel.zztq == -1 ? null : new Date(adRequestParcel.zztq), adRequestParcel.zztr, adRequestParcel.zzts != null ? new HashSet(adRequestParcel.zzts) : null, adRequestParcel.zzty, adRequestParcel.zztt, adRequestParcel.zztu, adRequestParcel.zztF), adRequestParcel.zztA != null ? adRequestParcel.zztA.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, String str2, zzey com_google_android_gms_internal_zzey, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
        if (this.zzBI instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.zzBI;
                zzfh com_google_android_gms_internal_zzfh = new zzfh(adRequestParcel.zztq == -1 ? null : new Date(adRequestParcel.zztq), adRequestParcel.zztr, adRequestParcel.zzts != null ? new HashSet(adRequestParcel.zzts) : null, adRequestParcel.zzty, adRequestParcel.zztt, adRequestParcel.zztu, nativeAdOptionsParcel, list, adRequestParcel.zztF);
                Bundle bundle = adRequestParcel.zztA != null ? adRequestParcel.zztA.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzBJ = new zzfe(com_google_android_gms_internal_zzey);
                mediationNativeAdapter.requestNativeAd((Context) zze.zzp(com_google_android_gms_dynamic_zzd), this.zzBJ, zza(str, adRequestParcel.zztu, str2), com_google_android_gms_internal_zzfh, bundle);
            } catch (Throwable th) {
                zzb.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationNativeAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzey com_google_android_gms_internal_zzey) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adSizeParcel, adRequestParcel, str, null, com_google_android_gms_internal_zzey);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzey com_google_android_gms_internal_zzey) throws RemoteException {
        if (this.zzBI instanceof MediationBannerAdapter) {
            zzb.zzaF("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzBI;
                mediationBannerAdapter.requestBannerAd((Context) zze.zzp(com_google_android_gms_dynamic_zzd), new zzfe(com_google_android_gms_internal_zzey), zza(str, adRequestParcel.zztu, str2), com.google.android.gms.ads.zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zztV), new zzfc(adRequestParcel.zztq == -1 ? null : new Date(adRequestParcel.zztq), adRequestParcel.zztr, adRequestParcel.zzts != null ? new HashSet(adRequestParcel.zzts) : null, adRequestParcel.zzty, adRequestParcel.zztt, adRequestParcel.zztu, adRequestParcel.zztF), adRequestParcel.zztA != null ? adRequestParcel.zztA.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zzc(AdRequestParcel adRequestParcel, String str) throws RemoteException {
        if (this.zzBI instanceof MediationRewardedVideoAdAdapter) {
            zzb.zzaF("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzBI;
                mediationRewardedVideoAdAdapter.loadAd(new zzfc(adRequestParcel.zztq == -1 ? null : new Date(adRequestParcel.zztq), adRequestParcel.zztr, adRequestParcel.zzts != null ? new HashSet(adRequestParcel.zzts) : null, adRequestParcel.zzty, adRequestParcel.zztt, adRequestParcel.zztu, adRequestParcel.zztF), zza(str, adRequestParcel.zztu, null), adRequestParcel.zztA != null ? adRequestParcel.zztA.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzb.zzd("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaH("MediationAdapter is not a MediationRewardedVideoAdAdapter: " + this.zzBI.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public zzfa zzeu() {
        NativeAdMapper zzey = this.zzBJ.zzey();
        return zzey instanceof NativeAppInstallAdMapper ? new zzff((NativeAppInstallAdMapper) zzey) : null;
    }

    public zzfb zzev() {
        NativeAdMapper zzey = this.zzBJ.zzey();
        return zzey instanceof NativeContentAdMapper ? new zzfg((NativeContentAdMapper) zzey) : null;
    }

    public Bundle zzew() {
        if (this.zzBI instanceof zzjx) {
            return ((zzjx) this.zzBI).zzew();
        }
        zzb.zzaH("MediationAdapter is not a v2 MediationBannerAdapter: " + this.zzBI.getClass().getCanonicalName());
        return new Bundle();
    }

    public Bundle zzex() {
        return new Bundle();
    }
}
