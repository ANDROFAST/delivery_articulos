package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

@zzha
class zzjj extends zzjl implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> zzMb;

    public zzjj(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.zzMb = new WeakReference(onGlobalLayoutListener);
    }

    public void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.zzMb.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            detach();
        }
    }

    protected void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected void zzb(ViewTreeObserver viewTreeObserver) {
        zzp.zzbz().zza(viewTreeObserver, (OnGlobalLayoutListener) this);
    }
}
