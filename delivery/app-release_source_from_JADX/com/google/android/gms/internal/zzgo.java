package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzie.zza;

@zzha
public class zzgo extends zzgm {
    private zzgn zzFr;

    zzgo(Context context, zza com_google_android_gms_internal_zzie_zza, zzjn com_google_android_gms_internal_zzjn, zzgq.zza com_google_android_gms_internal_zzgq_zza) {
        super(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzgq_zza);
    }

    protected void zzfP() {
        int i;
        int i2;
        AdSizeParcel zzaP = this.zzps.zzaP();
        if (zzaP.zztW) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            i = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
        } else {
            i = zzaP.widthPixels;
            i2 = zzaP.heightPixels;
        }
        this.zzFr = new zzgn(this, this.zzps, i, i2);
        this.zzps.zzhC().zza((zzjo.zza) this);
        this.zzFr.zza(this.zzFd);
    }

    protected int zzfQ() {
        if (!this.zzFr.zzfU()) {
            return !this.zzFr.zzfV() ? 2 : -2;
        } else {
            zzb.zzaF("Ad-Network indicated no fill with passback URL.");
            return 3;
        }
    }
}
