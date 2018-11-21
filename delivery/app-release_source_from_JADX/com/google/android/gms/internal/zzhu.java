package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzie.zza;

@zzha
public class zzhu extends zzil implements zzhv, zzhy {
    private final Context mContext;
    private final String zzBd;
    private final zza zzFc;
    private int zzFt = 3;
    private final String zzJg;
    private final zzht zzJo;
    private final zzhy zzJp;
    private final String zzJq;
    private int zzJr = 0;
    private final Object zzpK;

    public zzhu(Context context, String str, String str2, String str3, zza com_google_android_gms_internal_zzie_zza, zzht com_google_android_gms_internal_zzht, zzhy com_google_android_gms_internal_zzhy) {
        this.mContext = context;
        this.zzBd = str;
        this.zzJg = str2;
        this.zzJq = str3;
        this.zzFc = com_google_android_gms_internal_zzie_zza;
        this.zzJo = com_google_android_gms_internal_zzht;
        this.zzpK = new Object();
        this.zzJp = com_google_android_gms_internal_zzhy;
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzpK) {
                if (this.zzJr != 0) {
                    return;
                } else if (!zzf(j)) {
                    return;
                }
            }
        }
    }

    public void onStop() {
    }

    public void zzN(int i) {
        zza(this.zzBd, 0);
    }

    public void zza(String str, int i) {
        synchronized (this.zzpK) {
            this.zzJr = 2;
            this.zzFt = i;
            this.zzpK.notify();
        }
    }

    public void zzaw(String str) {
        synchronized (this.zzpK) {
            this.zzJr = 1;
            this.zzpK.notify();
        }
    }

    public void zzbp() {
        if (this.zzJo != null && this.zzJo.zzgB() != null && this.zzJo.zzgA() != null) {
            final zzhx zzgB = this.zzJo.zzgB();
            zzgB.zza((zzhy) this);
            zzgB.zza((zzhv) this);
            final AdRequestParcel adRequestParcel = this.zzFc.zzJK.zzGq;
            final zzex zzgA = this.zzJo.zzgA();
            try {
                if (zzgA.isInitialized()) {
                    com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new Runnable(this) {
                        final /* synthetic */ zzhu zzJt;

                        public void run() {
                            try {
                                zzgA.zzc(adRequestParcel, this.zzJt.zzJq);
                            } catch (Throwable e) {
                                zzb.zzd("Fail to load ad from adapter.", e);
                                this.zzJt.zza(this.zzJt.zzBd, 0);
                            }
                        }
                    });
                } else {
                    com.google.android.gms.ads.internal.util.client.zza.zzLE.post(new Runnable(this) {
                        final /* synthetic */ zzhu zzJt;

                        public void run() {
                            try {
                                zzgA.zza(zze.zzB(this.zzJt.mContext), adRequestParcel, this.zzJt.zzJg, zzgB, this.zzJt.zzJq);
                            } catch (Throwable e) {
                                zzb.zzd("Fail to initialize adapter " + this.zzJt.zzBd, e);
                                this.zzJt.zza(this.zzJt.zzBd, 0);
                            }
                        }
                    });
                }
            } catch (Throwable e) {
                zzb.zzd("Fail to check if adapter is initialized.", e);
                zza(this.zzBd, 0);
            }
            zzk(zzp.zzbB().elapsedRealtime());
            zzgB.zza(null);
            zzgB.zza(null);
            if (this.zzJr == 1) {
                this.zzJp.zzaw(this.zzBd);
            } else {
                this.zzJp.zza(this.zzBd, this.zzFt);
            }
        }
    }

    protected boolean zzf(long j) {
        long elapsedRealtime = 20000 - (zzp.zzbB().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpK.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void zzgC() {
        this.zzJo.zzgB();
        AdRequestParcel adRequestParcel = this.zzFc.zzJK.zzGq;
        try {
            this.zzJo.zzgA().zzc(adRequestParcel, this.zzJq);
        } catch (Throwable e) {
            zzb.zzd("Fail to load ad from adapter.", e);
            zza(this.zzBd, 0);
        }
    }
}
