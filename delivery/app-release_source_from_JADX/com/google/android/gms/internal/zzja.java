package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzp;

@zzha
public final class zzja {
    private boolean zzLA;
    private boolean zzLB;
    private OnGlobalLayoutListener zzLC;
    private OnScrollChangedListener zzLD;
    private Activity zzLy;
    private boolean zzLz;

    public zzja(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.zzLy = activity;
        this.zzLC = onGlobalLayoutListener;
        this.zzLD = onScrollChangedListener;
    }

    private void zzho() {
        if (this.zzLy != null && !this.zzLz) {
            if (this.zzLC != null) {
                zzp.zzbx().zza(this.zzLy, this.zzLC);
            }
            if (this.zzLD != null) {
                zzp.zzbx().zza(this.zzLy, this.zzLD);
            }
            this.zzLz = true;
        }
    }

    private void zzhp() {
        if (this.zzLy != null && this.zzLz) {
            if (this.zzLC != null) {
                zzp.zzbz().zzb(this.zzLy, this.zzLC);
            }
            if (this.zzLD != null) {
                zzp.zzbx().zzb(this.zzLy, this.zzLD);
            }
            this.zzLz = false;
        }
    }

    public void onAttachedToWindow() {
        this.zzLA = true;
        if (this.zzLB) {
            zzho();
        }
    }

    public void onDetachedFromWindow() {
        this.zzLA = false;
        zzhp();
    }

    public void zzhm() {
        this.zzLB = true;
        if (this.zzLA) {
            zzho();
        }
    }

    public void zzhn() {
        this.zzLB = false;
        zzhp();
    }

    public void zzk(Activity activity) {
        this.zzLy = activity;
    }
}
