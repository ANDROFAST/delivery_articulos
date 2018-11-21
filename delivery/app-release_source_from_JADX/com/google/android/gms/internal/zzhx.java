package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzhx extends zza {
    private zzhy zzJp;
    private zzhv zzJv;
    private zzhw zzJw;

    public zzhx(zzhw com_google_android_gms_internal_zzhw) {
        this.zzJw = com_google_android_gms_internal_zzhw;
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, RewardItemParcel rewardItemParcel) {
        if (this.zzJw != null) {
            this.zzJw.zza(rewardItemParcel);
        }
    }

    public void zza(zzhv com_google_android_gms_internal_zzhv) {
        this.zzJv = com_google_android_gms_internal_zzhv;
    }

    public void zza(zzhy com_google_android_gms_internal_zzhy) {
        this.zzJp = com_google_android_gms_internal_zzhy;
    }

    public void zzb(zzd com_google_android_gms_dynamic_zzd, int i) {
        if (this.zzJv != null) {
            this.zzJv.zzN(i);
        }
    }

    public void zzc(zzd com_google_android_gms_dynamic_zzd, int i) {
        if (this.zzJp != null) {
            this.zzJp.zza(zze.zzp(com_google_android_gms_dynamic_zzd).getClass().getName(), i);
        }
    }

    public void zzg(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJv != null) {
            this.zzJv.zzgC();
        }
    }

    public void zzh(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJp != null) {
            this.zzJp.zzaw(zze.zzp(com_google_android_gms_dynamic_zzd).getClass().getName());
        }
    }

    public void zzi(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJw != null) {
            this.zzJw.onRewardedVideoAdOpened();
        }
    }

    public void zzj(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJw != null) {
            this.zzJw.onRewardedVideoStarted();
        }
    }

    public void zzk(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJw != null) {
            this.zzJw.onRewardedVideoAdClosed();
        }
    }

    public void zzl(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJw != null) {
            this.zzJw.zzgz();
        }
    }

    public void zzm(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzJw != null) {
            this.zzJw.onRewardedVideoAdLeftApplication();
        }
    }
}
