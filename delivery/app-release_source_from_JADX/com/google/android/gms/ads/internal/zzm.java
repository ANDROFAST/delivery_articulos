package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzw.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;

@zzha
public class zzm extends zza {
    private static final Object zzqf = new Object();
    private static zzm zzqg;
    private final Context mContext;
    private boolean zzqh = false;

    zzm(Context context) {
        this.mContext = context;
    }

    public static zzm zzr(Context context) {
        zzm com_google_android_gms_ads_internal_zzm;
        synchronized (zzqf) {
            if (zzqg == null) {
                zzqg = new zzm(context.getApplicationContext());
            }
            com_google_android_gms_ads_internal_zzm = zzqg;
        }
        return com_google_android_gms_ads_internal_zzm;
    }

    public void zza() {
        synchronized (zzqf) {
            if (this.zzqh) {
                zzb.zzaH("Mobile ads is initialized already.");
                return;
            }
            this.zzqh = true;
        }
    }
}
