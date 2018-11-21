package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public class zze extends zzg<zzt> {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    private zzs zza(Context context, AdSizeParcel adSizeParcel, String str, zzev com_google_android_gms_internal_zzev, int i) {
        Throwable e;
        try {
            return zza.zzk(((zzt) zzaA(context)).zza(com.google.android.gms.dynamic.zze.zzB(context), adSizeParcel, str, com_google_android_gms_internal_zzev, 8298000, i));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zza("Could not create remote AdManager.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    public zzs zza(Context context, AdSizeParcel adSizeParcel, String str, zzev com_google_android_gms_internal_zzev) {
        if (zzl.zzcN().zzT(context)) {
            zzs zza = zza(context, adSizeParcel, str, com_google_android_gms_internal_zzev, 1);
            if (zza != null) {
                return zza;
            }
        }
        zzb.zzaF("Using BannerAdManager from the client jar.");
        return new zzf(context, adSizeParcel, str, com_google_android_gms_internal_zzev, new VersionInfoParcel(8298000, 8298000, true), zzd.zzbf());
    }

    public zzs zzb(Context context, AdSizeParcel adSizeParcel, String str, zzev com_google_android_gms_internal_zzev) {
        if (zzl.zzcN().zzT(context)) {
            zzs zza = zza(context, adSizeParcel, str, com_google_android_gms_internal_zzev, 2);
            if (zza != null) {
                return zza;
            }
        }
        zzb.zzaH("Using InterstitialAdManager from the client jar.");
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(8298000, 8298000, true);
        if (((Boolean) zzbz.zzwj.get()).booleanValue()) {
            return new zzeg(context, str, com_google_android_gms_internal_zzev, versionInfoParcel, zzd.zzbf());
        }
        return new zzk(context, adSizeParcel, str, com_google_android_gms_internal_zzev, versionInfoParcel, zzd.zzbf());
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zze(iBinder);
    }

    protected zzt zze(IBinder iBinder) {
        return zzt.zza.zzl(iBinder);
    }
}
