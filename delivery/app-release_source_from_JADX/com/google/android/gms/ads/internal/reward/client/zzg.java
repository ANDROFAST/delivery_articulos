package com.google.android.gms.ads.internal.reward.client;

import com.google.android.gms.ads.internal.reward.client.zzd.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzha;

@zzha
public class zzg extends zza {
    private final RewardedVideoAdListener zzJl;

    public zzg(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzJl = rewardedVideoAdListener;
    }

    public void onRewardedVideoAdClosed() {
        if (this.zzJl != null) {
            this.zzJl.onRewardedVideoAdClosed();
        }
    }

    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        if (this.zzJl != null) {
            this.zzJl.onRewardedVideoAdFailedToLoad(errorCode);
        }
    }

    public void onRewardedVideoAdLeftApplication() {
        if (this.zzJl != null) {
            this.zzJl.onRewardedVideoAdLeftApplication();
        }
    }

    public void onRewardedVideoAdLoaded() {
        if (this.zzJl != null) {
            this.zzJl.onRewardedVideoAdLoaded();
        }
    }

    public void onRewardedVideoAdOpened() {
        if (this.zzJl != null) {
            this.zzJl.onRewardedVideoAdOpened();
        }
    }

    public void onRewardedVideoStarted() {
        if (this.zzJl != null) {
            this.zzJl.onRewardedVideoStarted();
        }
    }

    public void zza(zza com_google_android_gms_ads_internal_reward_client_zza) {
        if (this.zzJl != null) {
            this.zzJl.onRewarded(new zze(com_google_android_gms_ads_internal_reward_client_zza));
        }
    }
}
