package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.ads.internal.purchase.zze;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzg;

@zzha
public final class zzgi extends zzg<zzge> {
    private static final zzgi zzEZ = new zzgi();

    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    private zzgi() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean zzc(Activity activity) throws zza {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static zzgd zze(Activity activity) {
        try {
            if (!zzc(activity)) {
                return zzEZ.zzf(activity);
            }
            zzb.zzaF("Using AdOverlay from the client jar.");
            return new zze(activity);
        } catch (zza e) {
            zzb.zzaH(e.getMessage());
            return null;
        }
    }

    private zzgd zzf(Activity activity) {
        try {
            return com.google.android.gms.internal.zzgd.zza.zzQ(((zzge) zzaA(activity)).zzf(com.google.android.gms.dynamic.zze.zzB(activity)));
        } catch (Throwable e) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected zzge zzU(IBinder iBinder) {
        return com.google.android.gms.internal.zzge.zza.zzR(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzU(iBinder);
    }
}
