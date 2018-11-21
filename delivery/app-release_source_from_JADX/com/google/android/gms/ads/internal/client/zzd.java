package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzd extends zzg<zzr> {
    private static final zzd zztp = new zzd();

    private zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public static zzq zza(Context context, String str, zzev com_google_android_gms_internal_zzev) {
        if (zzl.zzcN().zzT(context)) {
            zzq zzb = zztp.zzb(context, str, com_google_android_gms_internal_zzev);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzaF("Using AdLoader from the client jar.");
        return new zzj(context, str, com_google_android_gms_internal_zzev, new VersionInfoParcel(8298000, 8298000, true));
    }

    private zzq zzb(Context context, String str, zzev com_google_android_gms_internal_zzev) {
        try {
            return zza.zzi(((zzr) zzaA(context)).zza(zze.zzB(context), str, com_google_android_gms_internal_zzev, 8298000));
        } catch (Throwable e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }

    protected zzr zzc(IBinder iBinder) {
        return zzr.zza.zzj(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzc(iBinder);
    }
}
