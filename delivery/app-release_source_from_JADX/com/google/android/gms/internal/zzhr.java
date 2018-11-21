package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzha
public class zzhr extends zza {
    private final Context mContext;
    private final zzhs zzJe;
    private final VersionInfoParcel zzpI;
    private final Object zzpK = new Object();

    public zzhr(Context context, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpI = versionInfoParcel;
        this.zzJe = new zzhs(context, AdSizeParcel.zzcK(), com_google_android_gms_internal_zzew, versionInfoParcel);
    }

    public void destroy() {
        synchronized (this.zzpK) {
            this.zzJe.destroy();
        }
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.zzpK) {
            isLoaded = this.zzJe.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        synchronized (this.zzpK) {
            this.zzJe.pause();
        }
    }

    public void resume() {
        synchronized (this.zzpK) {
            this.zzJe.resume();
        }
    }

    public void setUserId(String userId) {
        synchronized (this.zzpK) {
            this.zzJe.setUserId(userId);
        }
    }

    public void show() {
        synchronized (this.zzpK) {
            this.zzJe.zzgy();
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzpK) {
            this.zzJe.zza(rewardedVideoAdRequestParcel);
        }
    }

    public void zza(zzd com_google_android_gms_ads_internal_reward_client_zzd) {
        synchronized (this.zzpK) {
            this.zzJe.zza(com_google_android_gms_ads_internal_reward_client_zzd);
        }
    }
}
