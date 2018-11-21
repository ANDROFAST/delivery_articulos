package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

@zzha
public class zzjm {
    private final Context mContext;
    private zzk zzEn;
    private final ViewGroup zzMd;
    private final zzjn zzps;

    public zzjm(Context context, ViewGroup viewGroup, zzjn com_google_android_gms_internal_zzjn) {
        this(context, viewGroup, com_google_android_gms_internal_zzjn, null);
    }

    zzjm(Context context, ViewGroup viewGroup, zzjn com_google_android_gms_internal_zzjn, zzk com_google_android_gms_ads_internal_overlay_zzk) {
        this.mContext = context;
        this.zzMd = viewGroup;
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzEn = com_google_android_gms_ads_internal_overlay_zzk;
    }

    public void onDestroy() {
        zzx.zzcx("onDestroy must be called from the UI thread.");
        if (this.zzEn != null) {
            this.zzEn.destroy();
        }
    }

    public void onPause() {
        zzx.zzcx("onPause must be called from the UI thread.");
        if (this.zzEn != null) {
            this.zzEn.pause();
        }
    }

    public void zza(int i, int i2, int i3, int i4, int i5) {
        if (this.zzEn == null) {
            zzcd.zza(this.zzps.zzhL().zzdt(), this.zzps.zzhK(), "vpr");
            zzcf zzb = zzcd.zzb(this.zzps.zzhL().zzdt());
            this.zzEn = new zzk(this.mContext, this.zzps, i5, this.zzps.zzhL().zzdt(), zzb);
            this.zzMd.addView(this.zzEn, 0, new LayoutParams(-1, -1));
            this.zzEn.zzd(i, i2, i3, i4);
            this.zzps.zzhC().zzG(false);
        }
    }

    public void zze(int i, int i2, int i3, int i4) {
        zzx.zzcx("The underlay may only be modified from the UI thread.");
        if (this.zzEn != null) {
            this.zzEn.zzd(i, i2, i3, i4);
        }
    }

    public zzk zzhv() {
        zzx.zzcx("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzEn;
    }
}
