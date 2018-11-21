package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

@zzha
class zzjk extends zzjl implements OnScrollChangedListener {
    private final WeakReference<OnScrollChangedListener> zzMb;

    public zzjk(View view, OnScrollChangedListener onScrollChangedListener) {
        super(view);
        this.zzMb = new WeakReference(onScrollChangedListener);
    }

    public void onScrollChanged() {
        OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) this.zzMb.get();
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged();
        } else {
            detach();
        }
    }

    protected void zza(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this);
    }

    protected void zzb(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this);
    }
}
