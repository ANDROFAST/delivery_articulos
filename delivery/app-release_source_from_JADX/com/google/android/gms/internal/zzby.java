package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.concurrent.Callable;

@zzha
public class zzby {
    private final Object zzpK = new Object();
    private boolean zzqh = false;
    private SharedPreferences zzvc = null;

    public void initialize(Context context) {
        synchronized (this.zzpK) {
            if (this.zzqh) {
                return;
            }
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                return;
            }
            this.zzvc = zzp.zzbE().zzw(remoteContext);
            this.zzqh = true;
        }
    }

    public <T> T zzd(final zzbv<T> com_google_android_gms_internal_zzbv_T) {
        synchronized (this.zzpK) {
            if (this.zzqh) {
                return zziz.zzb(new Callable<T>(this) {
                    final /* synthetic */ zzby zzve;

                    public T call() {
                        return com_google_android_gms_internal_zzbv_T.zza(this.zzve.zzvc);
                    }
                });
            }
            T zzdk = com_google_android_gms_internal_zzbv_T.zzdk();
            return zzdk;
        }
    }
}
