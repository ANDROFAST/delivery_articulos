package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcp;

public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zzoF;
    private final zzcp zzoG = zzaK();

    public NativeAdView(Context context) {
        super(context);
        this.zzoF = zzn(context);
    }

    public NativeAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzoF = zzn(context);
    }

    public NativeAdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.zzoF = zzn(context);
    }

    public NativeAdView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.zzoF = zzn(context);
    }

    private zzcp zzaK() {
        zzx.zzb(this.zzoF, (Object) "createDelegate must be called after mOverlayFrame has been created");
        return zzl.zzcQ().zza(this.zzoF.getContext(), this, this.zzoF);
    }

    private FrameLayout zzn(Context context) {
        View zzo = zzo(context);
        zzo.setLayoutParams(new LayoutParams(-1, -1));
        addView(zzo);
        return zzo;
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        super.bringChildToFront(this.zzoF);
    }

    public void bringChildToFront(View child) {
        super.bringChildToFront(child);
        if (this.zzoF != child) {
            super.bringChildToFront(this.zzoF);
        }
    }

    public void destroy() {
        try {
            this.zzoG.destroy();
        } catch (Throwable e) {
            zzb.zzb("Unable to destroy native ad view", e);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzoF);
    }

    public void removeView(View child) {
        if (this.zzoF != child) {
            super.removeView(child);
        }
    }

    public void setNativeAd(NativeAd ad) {
        try {
            this.zzoG.zzb((zzd) ad.zzaJ());
        } catch (Throwable e) {
            zzb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    protected void zza(String str, View view) {
        try {
            this.zzoG.zza(str, zze.zzB(view));
        } catch (Throwable e) {
            zzb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    protected View zzm(String str) {
        try {
            zzd zzU = this.zzoG.zzU(str);
            if (zzU != null) {
                return (View) zze.zzp(zzU);
            }
        } catch (Throwable e) {
            zzb.zzb("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    FrameLayout zzo(Context context) {
        return new FrameLayout(context);
    }
}
