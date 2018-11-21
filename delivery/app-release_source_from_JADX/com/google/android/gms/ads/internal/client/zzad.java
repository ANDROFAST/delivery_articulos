package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zzw.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzha;

@zzha
public class zzad extends zzg<zzx> {
    public zzad() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    private zzw zzv(Context context) {
        try {
            return zza.zzo(((zzx) zzaA(context)).zza(zze.zzB(context), 8298000));
        } catch (Throwable e) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzq(iBinder);
    }

    protected zzx zzq(IBinder iBinder) {
        return zzx.zza.zzp(iBinder);
    }

    public zzw zzu(Context context) {
        if (zzl.zzcN().zzT(context)) {
            zzw zzv = zzv(context);
            if (zzv != null) {
                return zzv;
            }
        }
        zzb.zzaF("Using MobileAdsSettingManager from the client jar.");
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(8298000, 8298000, true);
        return zzm.zzr(context);
    }
}
