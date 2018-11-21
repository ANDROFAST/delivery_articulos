package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public abstract class zzgp extends zzil {
    protected final Context mContext;
    protected final com.google.android.gms.internal.zzgq.zza zzFb;
    protected final com.google.android.gms.internal.zzie.zza zzFc;
    protected AdResponseParcel zzFd;
    protected final Object zzFf = new Object();
    protected final Object zzpK = new Object();

    class C03161 implements Runnable {
        final /* synthetic */ zzgp zzFs;

        C03161(zzgp com_google_android_gms_internal_zzgp) {
            this.zzFs = com_google_android_gms_internal_zzgp;
        }

        public void run() {
            this.zzFs.onStop();
        }
    }

    protected static final class zza extends Exception {
        private final int zzFt;

        public zza(String str, int i) {
            super(str);
            this.zzFt = i;
        }

        public int getErrorCode() {
            return this.zzFt;
        }
    }

    protected zzgp(Context context, com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, com.google.android.gms.internal.zzgq.zza com_google_android_gms_internal_zzgq_zza) {
        super(true);
        this.mContext = context;
        this.zzFc = com_google_android_gms_internal_zzie_zza;
        this.zzFd = com_google_android_gms_internal_zzie_zza.zzJL;
        this.zzFb = com_google_android_gms_internal_zzgq_zza;
    }

    public void onStop() {
    }

    protected abstract zzie zzD(int i);

    public void zzbp() {
        int errorCode;
        synchronized (this.zzpK) {
            zzb.zzaF("AdRendererBackgroundTask started.");
            int i = this.zzFc.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzb.zzaG(e.getMessage());
                } else {
                    zzb.zzaH(e.getMessage());
                }
                if (this.zzFd == null) {
                    this.zzFd = new AdResponseParcel(errorCode);
                } else {
                    this.zzFd = new AdResponseParcel(errorCode, this.zzFd.zzAU);
                }
                zzip.zzKO.post(new C03161(this));
                i = errorCode;
            }
            final zzie zzD = zzD(i);
            zzip.zzKO.post(new Runnable(this) {
                final /* synthetic */ zzgp zzFs;

                public void run() {
                    synchronized (this.zzFs.zzpK) {
                        this.zzFs.zzi(zzD);
                    }
                }
            });
        }
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzi(zzie com_google_android_gms_internal_zzie) {
        this.zzFb.zzb(com_google_android_gms_internal_zzie);
    }
}
