package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzcj implements CustomRenderedAd {
    private final zzck zzxj;

    public zzcj(zzck com_google_android_gms_internal_zzck) {
        this.zzxj = com_google_android_gms_internal_zzck;
    }

    public String getBaseUrl() {
        try {
            return this.zzxj.zzdy();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzxj.getContent();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzxj.zza(view != null ? zze.zzB(view) : null);
        } catch (Throwable e) {
            zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzxj.recordClick();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzxj.recordImpression();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
