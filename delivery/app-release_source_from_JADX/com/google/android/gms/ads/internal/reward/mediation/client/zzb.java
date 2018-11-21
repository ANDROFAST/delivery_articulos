package com.google.android.gms.ads.internal.reward.mediation.client;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzha;

@zzha
public class zzb implements MediationRewardedVideoAdListener {
    private final zza zzJC;

    public zzb(zza com_google_android_gms_ads_internal_reward_mediation_client_zza) {
        this.zzJC = com_google_android_gms_ads_internal_reward_mediation_client_zza;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClicked.");
        try {
            this.zzJC.zzl(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdClosed.");
        try {
            this.zzJC.zzk(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter adapter, int errorCode) {
        zzx.zzcx("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdFailedToLoad.");
        try {
            this.zzJC.zzc(zze.zzB(adapter), errorCode);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLeftApplication.");
        try {
            this.zzJC.zzm(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdLoaded.");
        try {
            this.zzJC.zzh(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onAdOpened.");
        try {
            this.zzJC.zzi(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter adapter, int errorCode) {
        zzx.zzcx("onInitializationFailed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationFailed.");
        try {
            this.zzJC.zzb(zze.zzB(adapter), errorCode);
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onInitializationSucceeded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onInitializationSucceeded.");
        try {
            this.zzJC.zzg(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter adapter, RewardItem rewardItem) {
        zzx.zzcx("onRewarded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.zzJC.zza(zze.zzB(adapter), new RewardItemParcel(rewardItem));
                return;
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onRewarded.", e);
                return;
            }
        }
        this.zzJC.zza(zze.zzB(adapter), new RewardItemParcel(adapter.getClass().getName(), 1));
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter adapter) {
        zzx.zzcx("onVideoStarted must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Adapter called onVideoStarted.");
        try {
            this.zzJC.zzj(zze.zzB(adapter));
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onVideoStarted.", e);
        }
    }
}
