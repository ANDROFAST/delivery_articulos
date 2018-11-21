package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhr;

@zzha
public class zzf extends zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    private zzb zzb(Context context, zzev com_google_android_gms_internal_zzev) {
        Throwable e;
        try {
            return zza.zzaa(((zzc) zzaA(context)).zza(zze.zzB(context), com_google_android_gms_internal_zzev, 8298000));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    public zzb zza(Context context, zzev com_google_android_gms_internal_zzev) {
        if (zzl.zzcN().zzT(context)) {
            zzb zzb = zzb(context, com_google_android_gms_internal_zzev);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzaF("Using RewardedVideoAd from the client jar.");
        return new zzhr(context, com_google_android_gms_internal_zzev, new VersionInfoParcel(8298000, 8298000, true));
    }

    protected zzc zzad(IBinder iBinder) {
        return zzc.zza.zzab(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzad(iBinder);
    }
}
