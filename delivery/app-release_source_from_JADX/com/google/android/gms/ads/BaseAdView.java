package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

class BaseAdView extends ViewGroup {
    private final zzz zzoy;

    public BaseAdView(Context context, int adViewType) {
        super(context);
        this.zzoy = new zzz(this, zze(adViewType));
    }

    public BaseAdView(Context context, AttributeSet attrs, int adViewType) {
        super(context, attrs);
        this.zzoy = new zzz(this, attrs, false, zze(adViewType));
    }

    public BaseAdView(Context context, AttributeSet attrs, int defStyle, int adViewType) {
        super(context, attrs, defStyle);
        this.zzoy = new zzz(this, attrs, false, zze(adViewType));
    }

    private static boolean zze(int i) {
        return i == 2;
    }

    public void destroy() {
        this.zzoy.destroy();
    }

    public AdListener getAdListener() {
        return this.zzoy.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzoy.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzoy.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzoy.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoy.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.zzoy.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzoy.zza(adRequest.zzaG());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthInPixels;
        int i = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = getAdSize();
            if (adSize != null) {
                Context context = getContext();
                widthInPixels = adSize.getWidthInPixels(context);
                i = adSize.getHeightInPixels(context);
            } else {
                widthInPixels = 0;
            }
        } else {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            widthInPixels = childAt.getMeasuredWidth();
            i = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(widthInPixels, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        this.zzoy.pause();
    }

    public void resume() {
        this.zzoy.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzoy.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zza)) {
            this.zzoy.zza((zza) adListener);
        } else if (adListener == null) {
            this.zzoy.zza(null);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzoy.setAdSizes(adSize);
    }

    public void setAdUnitId(String adUnitId) {
        this.zzoy.setAdUnitId(adUnitId);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzoy.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        this.zzoy.setPlayStorePurchaseParams(playStorePurchaseListener, publicKey);
    }
}
