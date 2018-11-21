package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzz;

public final class PublisherAdView extends ViewGroup {
    private final zzz zzoy;

    public PublisherAdView(Context context) {
        super(context);
        this.zzoy = new zzz(this);
    }

    public PublisherAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzoy = new zzz(this, attrs, true);
    }

    public PublisherAdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzoy = new zzz(this, attrs, true);
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

    public AdSize[] getAdSizes() {
        return this.zzoy.getAdSizes();
    }

    public String getAdUnitId() {
        return this.zzoy.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzoy.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzoy.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzoy.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoading() {
        return this.zzoy.isLoading();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzoy.zza(publisherAdRequest.zzaG());
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

    public void recordManualImpression() {
        this.zzoy.recordManualImpression();
    }

    public void resume() {
        this.zzoy.resume();
    }

    public void setAdListener(AdListener adListener) {
        this.zzoy.setAdListener(adListener);
    }

    public void setAdSizes(AdSize... adSizes) {
        if (adSizes == null || adSizes.length < 1) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzoy.zza(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        this.zzoy.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzoy.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.zzoy.setCorrelator(correlator);
    }

    public void setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
        this.zzoy.setManualImpressionsEnabled(manualImpressionsEnabled);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzoy.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }
}
