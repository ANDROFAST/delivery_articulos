package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.lang.ref.WeakReference;

@zzha
public class zzo {
    private final zza zzqn;
    private AdRequestParcel zzqo;
    private boolean zzqp;
    private boolean zzqq;
    private long zzqr;
    private final Runnable zzx;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzo(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zza(zzip.zzKO));
    }

    zzo(zza com_google_android_gms_ads_internal_zza, zza com_google_android_gms_ads_internal_zzo_zza) {
        this.zzqp = false;
        this.zzqq = false;
        this.zzqr = 0;
        this.zzqn = com_google_android_gms_ads_internal_zzo_zza;
        final WeakReference weakReference = new WeakReference(com_google_android_gms_ads_internal_zza);
        this.zzx = new Runnable(this) {
            final /* synthetic */ zzo zzqt;

            public void run() {
                this.zzqt.zzqp = false;
                zza com_google_android_gms_ads_internal_zza = (zza) weakReference.get();
                if (com_google_android_gms_ads_internal_zza != null) {
                    com_google_android_gms_ads_internal_zza.zzd(this.zzqt.zzqo);
                }
            }
        };
    }

    public void cancel() {
        this.zzqp = false;
        this.zzqn.removeCallbacks(this.zzx);
    }

    public void pause() {
        this.zzqq = true;
        if (this.zzqp) {
            this.zzqn.removeCallbacks(this.zzx);
        }
    }

    public void resume() {
        this.zzqq = false;
        if (this.zzqp) {
            this.zzqp = false;
            zza(this.zzqo, this.zzqr);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.zzqp) {
            zzb.zzaH("An ad refresh is already scheduled.");
            return;
        }
        this.zzqo = adRequestParcel;
        this.zzqp = true;
        this.zzqr = j;
        if (!this.zzqq) {
            zzb.zzaG("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzqn.postDelayed(this.zzx, j);
        }
    }

    public boolean zzbr() {
        return this.zzqp;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000);
    }
}
