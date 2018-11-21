package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;

@zzha
class zzq implements Runnable {
    private boolean mCancelled = false;
    private zzk zzEn;

    zzq(zzk com_google_android_gms_ads_internal_overlay_zzk) {
        this.zzEn = com_google_android_gms_ads_internal_overlay_zzk;
    }

    public void cancel() {
        this.mCancelled = true;
        zzip.zzKO.removeCallbacks(this);
    }

    public void run() {
        if (!this.mCancelled) {
            this.zzEn.zzfu();
            zzfD();
        }
    }

    public void zzfD() {
        zzip.zzKO.postDelayed(this, 250);
    }
}
