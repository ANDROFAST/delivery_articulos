package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzha;

@zzha
public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private String zzJg;
    private RewardedVideoAdListener zzJl;
    private final zzb zzJm;
    private final Object zzpK = new Object();

    public zzi(Context context, zzb com_google_android_gms_ads_internal_reward_client_zzb) {
        this.zzJm = com_google_android_gms_ads_internal_reward_client_zzb;
        this.mContext = context;
    }

    public void destroy() {
        synchronized (this.zzpK) {
            if (this.zzJm == null) {
                return;
            }
            try {
                this.zzJm.destroy();
            } catch (Throwable e) {
                zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzpK) {
            rewardedVideoAdListener = this.zzJl;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        String str;
        synchronized (this.zzpK) {
            str = this.zzJg;
        }
        return str;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzpK) {
            if (this.zzJm == null) {
            } else {
                try {
                    z = this.zzJm.isLoaded();
                } catch (Throwable e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String adUnitId, AdRequest adRequest) {
        synchronized (this.zzpK) {
            if (this.zzJm == null) {
                return;
            }
            try {
                this.zzJm.zza(zzh.zzcJ().zza(this.mContext, adRequest.zzaG(), adUnitId));
            } catch (Throwable e) {
                zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        synchronized (this.zzpK) {
            if (this.zzJm == null) {
                return;
            }
            try {
                this.zzJm.pause();
            } catch (Throwable e) {
                zzb.zzd("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        synchronized (this.zzpK) {
            if (this.zzJm == null) {
                return;
            }
            try {
                this.zzJm.resume();
            } catch (Throwable e) {
                zzb.zzd("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener listener) {
        synchronized (this.zzpK) {
            this.zzJl = listener;
            if (this.zzJm != null) {
                try {
                    this.zzJm.zza(new zzg(listener));
                } catch (Throwable e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String userId) {
        synchronized (this.zzpK) {
            if (TextUtils.isEmpty(this.zzJg)) {
                this.zzJg = userId;
                if (this.zzJm != null) {
                    try {
                        this.zzJm.setUserId(userId);
                    } catch (Throwable e) {
                        zzb.zzd("Could not forward setUserId to RewardedVideoAd", e);
                    }
                }
                return;
            }
            zzb.zzaH("A user id has already been set, ignoring.");
        }
    }

    public void show() {
        synchronized (this.zzpK) {
            if (this.zzJm == null) {
                return;
            }
            try {
                this.zzJm.show();
            } catch (Throwable e) {
                zzb.zzd("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
