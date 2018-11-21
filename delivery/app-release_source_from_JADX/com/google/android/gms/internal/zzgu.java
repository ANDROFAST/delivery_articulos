package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.internal.zzgq.zza;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzha
public class zzgu extends zzil {
    private Future<zzie> zzFA;
    private final zza zzFb;
    private final zzie.zza zzFc;
    private final AdResponseParcel zzFd;
    private final zzgv zzFz;
    private final Object zzpK;

    public zzgu(Context context, zzn com_google_android_gms_ads_internal_zzn, zzbc com_google_android_gms_internal_zzbc, zzie.zza com_google_android_gms_internal_zzie_zza, zzan com_google_android_gms_internal_zzan, zza com_google_android_gms_internal_zzgq_zza) {
        this(com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzgq_zza, new zzgv(context, com_google_android_gms_ads_internal_zzn, com_google_android_gms_internal_zzbc, new zziu(context), com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzie_zza));
    }

    zzgu(zzie.zza com_google_android_gms_internal_zzie_zza, zza com_google_android_gms_internal_zzgq_zza, zzgv com_google_android_gms_internal_zzgv) {
        this.zzpK = new Object();
        this.zzFc = com_google_android_gms_internal_zzie_zza;
        this.zzFd = com_google_android_gms_internal_zzie_zza.zzJL;
        this.zzFb = com_google_android_gms_internal_zzgq_zza;
        this.zzFz = com_google_android_gms_internal_zzgv;
    }

    private zzie zzE(int i) {
        return new zzie(this.zzFc.zzJK.zzGq, null, null, i, null, null, this.zzFd.orientation, this.zzFd.zzAU, this.zzFc.zzJK.zzGt, false, null, null, null, null, null, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
    }

    public void onStop() {
        synchronized (this.zzpK) {
            if (this.zzFA != null) {
                this.zzFA.cancel(true);
            }
        }
    }

    public void zzbp() {
        zzie com_google_android_gms_internal_zzie;
        int i;
        try {
            synchronized (this.zzpK) {
                this.zzFA = zzio.zza(this.zzFz);
            }
            com_google_android_gms_internal_zzie = (zzie) this.zzFA.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzb.zzaH("Timed out waiting for native ad.");
            this.zzFA.cancel(true);
            i = 2;
            com_google_android_gms_internal_zzie = null;
        } catch (ExecutionException e2) {
            i = 0;
            com_google_android_gms_internal_zzie = null;
        } catch (InterruptedException e3) {
            com_google_android_gms_internal_zzie = null;
            i = -1;
        } catch (CancellationException e4) {
            com_google_android_gms_internal_zzie = null;
            i = -1;
        }
        if (com_google_android_gms_internal_zzie == null) {
            com_google_android_gms_internal_zzie = zzE(i);
        }
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzgu zzFB;

            public void run() {
                this.zzFB.zzFb.zzb(com_google_android_gms_internal_zzie);
            }
        });
    }
}
