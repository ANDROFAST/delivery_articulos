package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzie.zza;

@zzha
public class zzgt extends zzgp {
    private zzen zzBf;
    private zzel zzFx;
    protected zzer zzFy;
    private final zzch zzoU;
    private zzew zzpd;

    zzgt(Context context, zza com_google_android_gms_internal_zzie_zza, zzew com_google_android_gms_internal_zzew, zzgq.zza com_google_android_gms_internal_zzgq_zza, zzch com_google_android_gms_internal_zzch) {
        super(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzgq_zza);
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzBf = com_google_android_gms_internal_zzie_zza.zzJF;
        this.zzoU = com_google_android_gms_internal_zzch;
    }

    public void onStop() {
        synchronized (this.zzFf) {
            super.onStop();
            if (this.zzFx != null) {
                this.zzFx.cancel();
            }
        }
    }

    protected zzie zzD(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzFc.zzJK;
        return new zzie(adRequestInfoParcel.zzGq, null, this.zzFd.zzAQ, i, this.zzFd.zzAR, this.zzFd.zzGP, this.zzFd.orientation, this.zzFd.zzAU, adRequestInfoParcel.zzGt, this.zzFd.zzGN, this.zzFy != null ? this.zzFy.zzBp : null, this.zzFy != null ? this.zzFy.zzBq : null, this.zzFy != null ? this.zzFy.zzBr : AdMobAdapter.class.getName(), this.zzBf, this.zzFy != null ? this.zzFy.zzBs : null, this.zzFd.zzGO, this.zzFc.zzqV, this.zzFd.zzGM, this.zzFc.zzJH, this.zzFd.zzGR, this.zzFd.zzGS, this.zzFc.zzJE, null);
    }

    protected void zzh(long j) throws zza {
        synchronized (this.zzFf) {
            this.zzFx = zzi(j);
        }
        this.zzFy = this.zzFx.zzc(this.zzBf.zzAO);
        switch (this.zzFy.zzBo) {
            case 0:
                return;
            case 1:
                throw new zza("No fill from any mediation ad networks.", 3);
            default:
                throw new zza("Unexpected mediation result: " + this.zzFy.zzBo, 0);
        }
    }

    zzel zzi(long j) {
        if (this.zzBf.zzAX != -1) {
            return new zzet(this.mContext, this.zzFc.zzJK, this.zzpd, this.zzBf, this.zzFd.zztY, j, ((Long) zzbz.zzwC.get()).longValue(), 2);
        }
        return new zzeu(this.mContext, this.zzFc.zzJK, this.zzpd, this.zzBf, this.zzFd.zztY, j, ((Long) zzbz.zzwC.get()).longValue(), this.zzoU);
    }
}
