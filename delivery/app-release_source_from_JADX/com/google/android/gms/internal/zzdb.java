package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzcp.zza;

@zzha
public class zzdb extends zzg<zzcq> {
    public zzdb() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    private zzcp zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        Throwable e;
        try {
            return zza.zzu(((zzcq) zzaA(context)).zza(zze.zzB(context), zze.zzB(frameLayout), zze.zzB(frameLayout2), 8298000));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    protected zzcq zzD(IBinder iBinder) {
        return zzcq.zza.zzv(iBinder);
    }

    public zzcp zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        if (zzl.zzcN().zzT(context)) {
            zzcp zzb = zzb(context, frameLayout, frameLayout2);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzaF("Using NativeAdViewDelegate from the client jar.");
        return new zzj(frameLayout, frameLayout2);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzD(iBinder);
    }
}
