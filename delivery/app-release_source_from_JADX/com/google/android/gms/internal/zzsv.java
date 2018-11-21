package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzsq.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzsv extends zzg<zzsq> {
    private static zzsv zzblu;

    protected zzsv() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzsv zzGt() {
        if (zzblu == null) {
            zzblu = new zzsv();
        }
        return zzblu;
    }

    public static zzsn zza(Activity activity, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzso com_google_android_gms_internal_zzso) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzsq) zzGt().zzaA(activity)).zza(zze.zzB(activity), com_google_android_gms_dynamic_zzc, walletFragmentOptions, com_google_android_gms_internal_zzso);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzel(iBinder);
    }

    protected zzsq zzel(IBinder iBinder) {
        return zza.zzeh(iBinder);
    }
}
