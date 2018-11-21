package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public class zzab {
    private static final Object zzqf = new Object();
    private static zzab zzuF;
    private zzw zzuG;
    private RewardedVideoAd zzuH;

    private zzab() {
    }

    public static zzab zzdc() {
        zzab com_google_android_gms_ads_internal_client_zzab;
        synchronized (zzqf) {
            if (zzuF == null) {
                zzuF = new zzab();
            }
            com_google_android_gms_ads_internal_client_zzab = zzuF;
        }
        return com_google_android_gms_ads_internal_client_zzab;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzqf) {
            if (this.zzuH != null) {
                rewardedVideoAd = this.zzuH;
            } else {
                this.zzuH = new zzi(context, zzl.zzcR().zza(context, new zzev()));
                rewardedVideoAd = this.zzuH;
            }
        }
        return rewardedVideoAd;
    }

    public void initialize(Context context) {
        synchronized (zzqf) {
            if (this.zzuG != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else {
                try {
                    this.zzuG = zzl.zzcP().zzu(context);
                    this.zzuG.zza();
                } catch (RemoteException e) {
                    zzb.zzaH("Fail to initialize mobile ads setting manager");
                }
            }
        }
    }

    public void zza(Context context, String str, zzac com_google_android_gms_ads_internal_client_zzac) {
        initialize(context);
    }
}
