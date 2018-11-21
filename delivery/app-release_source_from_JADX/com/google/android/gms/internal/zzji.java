package com.google.android.gms.internal;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;

@zzha
public class zzji {
    public static void zza(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzjj(view, onGlobalLayoutListener).zzhu();
    }

    public static void zza(View view, OnScrollChangedListener onScrollChangedListener) {
        new zzjk(view, onScrollChangedListener).zzhu();
    }
}
