package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzie.zza;
import java.util.HashMap;

@zzha
public class zzhs extends zzb implements zzhw {
    private zzd zzJf;
    private String zzJg;
    private boolean zzJh;
    private HashMap<String, zzht> zzJi = new HashMap();

    public zzhs(Context context, AdSizeParcel adSizeParcel, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, null, com_google_android_gms_internal_zzew, versionInfoParcel, null);
    }

    public void destroy() {
        zzx.zzcx("destroy must be called on the main UI thread.");
        for (String str : this.zzJi.keySet()) {
            try {
                zzht com_google_android_gms_internal_zzht = (zzht) this.zzJi.get(str);
                if (!(com_google_android_gms_internal_zzht == null || com_google_android_gms_internal_zzht.zzgA() == null)) {
                    com_google_android_gms_internal_zzht.zzgA().destroy();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to destroy adapter: " + str);
            }
        }
    }

    public boolean isLoaded() {
        zzx.zzcx("isLoaded must be called on the main UI thread.");
        return this.zzoZ.zzqT == null && this.zzoZ.zzqU == null && this.zzoZ.zzqW != null && !this.zzJh;
    }

    public void onRewardedVideoAdClosed() {
        if (this.zzJf != null) {
            try {
                this.zzJf.onRewardedVideoAdClosed();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", e);
            }
        }
    }

    public void onRewardedVideoAdLeftApplication() {
        if (this.zzJf != null) {
            try {
                this.zzJf.onRewardedVideoAdLeftApplication();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", e);
            }
        }
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzoZ.zzqW, false);
        if (this.zzJf != null) {
            try {
                this.zzJf.onRewardedVideoAdOpened();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", e);
            }
        }
    }

    public void onRewardedVideoStarted() {
        zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAM);
        if (this.zzJf != null) {
            try {
                this.zzJf.onRewardedVideoStarted();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public void pause() {
        zzx.zzcx("pause must be called on the main UI thread.");
        for (String str : this.zzJi.keySet()) {
            try {
                zzht com_google_android_gms_internal_zzht = (zzht) this.zzJi.get(str);
                if (!(com_google_android_gms_internal_zzht == null || com_google_android_gms_internal_zzht.zzgA() == null)) {
                    com_google_android_gms_internal_zzht.zzgA().pause();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to pause adapter: " + str);
            }
        }
    }

    public void resume() {
        zzx.zzcx("resume must be called on the main UI thread.");
        for (String str : this.zzJi.keySet()) {
            try {
                zzht com_google_android_gms_internal_zzht = (zzht) this.zzJi.get(str);
                if (!(com_google_android_gms_internal_zzht == null || com_google_android_gms_internal_zzht.zzgA() == null)) {
                    com_google_android_gms_internal_zzht.zzgA().resume();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Fail to resume adapter: " + str);
            }
        }
    }

    public void setUserId(String userId) {
        zzx.zzcx("setUserId must be called on the main UI thread.");
        this.zzJg = userId;
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        zzx.zzcx("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.zzqP)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("Invalid ad unit id. Aborting.");
            return;
        }
        this.zzJh = false;
        this.zzoZ.zzqP = rewardedVideoAdRequestParcel.zzqP;
        super.zzb(rewardedVideoAdRequestParcel.zzGq);
    }

    public void zza(zzd com_google_android_gms_ads_internal_reward_client_zzd) {
        zzx.zzcx("setRewardedVideoAdListener must be called on the main UI thread.");
        this.zzJf = com_google_android_gms_ads_internal_reward_client_zzd;
    }

    public void zza(RewardItemParcel rewardItemParcel) {
        zzp.zzbK().zza(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, this.zzoZ.zzqW, this.zzoZ.zzqP, false, this.zzoZ.zzqW.zzBp.zzAN);
        if (this.zzJf != null) {
            try {
                if (this.zzoZ.zzqW == null || this.zzoZ.zzqW.zzJF == null || TextUtils.isEmpty(this.zzoZ.zzqW.zzJF.zzAV)) {
                    this.zzJf.zza(new zzhq(rewardItemParcel.type, rewardItemParcel.zzJD));
                } else {
                    this.zzJf.zza(new zzhq(this.zzoZ.zzqW.zzJF.zzAV, this.zzoZ.zzqW.zzJF.zzAW));
                }
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void zza(final zza com_google_android_gms_internal_zzie_zza, zzch com_google_android_gms_internal_zzch) {
        if (com_google_android_gms_internal_zzie_zza.errorCode != -2) {
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzhs zzJj;

                public void run() {
                    this.zzJj.zzb(new zzie(com_google_android_gms_internal_zzie_zza, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzoZ.zzrp = 0;
        this.zzoZ.zzqU = new zzhz(this.zzoZ.context, this.zzJg, com_google_android_gms_internal_zzie_zza, this);
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdRenderer: " + this.zzoZ.zzqU.getClass().getName());
        this.zzoZ.zzqU.zzfR();
    }

    public boolean zza(zzie com_google_android_gms_internal_zzie, zzie com_google_android_gms_internal_zzie2) {
        if (this.zzJf != null) {
            try {
                this.zzJf.onRewardedVideoAdLoaded();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", e);
            }
        }
        return true;
    }

    public zzht zzav(String str) {
        Throwable th;
        zzht com_google_android_gms_internal_zzht = (zzht) this.zzJi.get(str);
        if (com_google_android_gms_internal_zzht != null) {
            return com_google_android_gms_internal_zzht;
        }
        try {
            zzht com_google_android_gms_internal_zzht2 = new zzht(this.zzpd.zzaf(str), this);
            try {
                this.zzJi.put(str, com_google_android_gms_internal_zzht2);
                return com_google_android_gms_internal_zzht2;
            } catch (Throwable e) {
                Throwable th2 = e;
                com_google_android_gms_internal_zzht = com_google_android_gms_internal_zzht2;
                th = th2;
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + str, th);
                return com_google_android_gms_internal_zzht;
            }
        } catch (Exception e2) {
            th = e2;
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + str, th);
            return com_google_android_gms_internal_zzht;
        }
    }

    protected boolean zzf(int i) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to load ad: " + i);
        this.zzoX = false;
        if (this.zzJf == null) {
            return false;
        }
        try {
            this.zzJf.onRewardedVideoAdFailedToLoad(i);
            return true;
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", e);
            return false;
        }
    }

    public void zzgy() {
        zzx.zzcx("showAd must be called on the main UI thread.");
        if (isLoaded()) {
            this.zzJh = true;
            zzht zzav = zzav(this.zzoZ.zzqW.zzBr);
            if (zzav != null && zzav.zzgA() != null) {
                try {
                    zzav.zzgA().showVideo();
                    return;
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("The reward video has not loaded.");
    }

    public void zzgz() {
        onAdClicked();
    }
}
