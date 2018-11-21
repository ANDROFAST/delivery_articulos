package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjo.zza;
import java.util.concurrent.atomic.AtomicBoolean;

@zzha
public abstract class zzgm implements zzir<Void>, zza {
    protected final Context mContext;
    protected final zzgq.zza zzFb;
    protected final zzie.zza zzFc;
    protected AdResponseParcel zzFd;
    private Runnable zzFe;
    protected final Object zzFf = new Object();
    private AtomicBoolean zzFg = new AtomicBoolean(true);
    protected final zzjn zzps;

    class C03151 implements Runnable {
        final /* synthetic */ zzgm zzFh;

        C03151(zzgm com_google_android_gms_internal_zzgm) {
            this.zzFh = com_google_android_gms_internal_zzgm;
        }

        public void run() {
            if (this.zzFh.zzFg.get()) {
                zzb.m6e("Timed out waiting for WebView to finish loading.");
                this.zzFh.cancel();
            }
        }
    }

    protected zzgm(Context context, zzie.zza com_google_android_gms_internal_zzie_zza, zzjn com_google_android_gms_internal_zzjn, zzgq.zza com_google_android_gms_internal_zzgq_zza) {
        this.mContext = context;
        this.zzFc = com_google_android_gms_internal_zzie_zza;
        this.zzFd = this.zzFc.zzJL;
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzFb = com_google_android_gms_internal_zzgq_zza;
    }

    private zzie zzD(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzFc.zzJK;
        return new zzie(adRequestInfoParcel.zzGq, this.zzps, this.zzFd.zzAQ, i, this.zzFd.zzAR, this.zzFd.zzGP, this.zzFd.orientation, this.zzFd.zzAU, adRequestInfoParcel.zzGt, this.zzFd.zzGN, null, null, null, null, null, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
    }

    public void cancel() {
        if (this.zzFg.getAndSet(false)) {
            this.zzps.stopLoading();
            zzp.zzbz().zzf(this.zzps);
            zzC(-1);
            zzip.zzKO.removeCallbacks(this.zzFe);
        }
    }

    protected void zzC(int i) {
        if (i != -2) {
            this.zzFd = new AdResponseParcel(i, this.zzFd.zzAU);
        }
        this.zzFb.zzb(zzD(i));
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, boolean z) {
        zzb.zzaF("WebView finished loading.");
        if (this.zzFg.getAndSet(false)) {
            zzC(z ? zzfQ() : -1);
            zzip.zzKO.removeCallbacks(this.zzFe);
        }
    }

    public final Void zzfO() {
        zzx.zzcx("Webview render task needs to be called on UI thread.");
        this.zzFe = new C03151(this);
        zzip.zzKO.postDelayed(this.zzFe, ((Long) zzbz.zzwC.get()).longValue());
        zzfP();
        return null;
    }

    protected abstract void zzfP();

    protected int zzfQ() {
        return -2;
    }

    public /* synthetic */ Object zzfR() {
        return zzfO();
    }
}
