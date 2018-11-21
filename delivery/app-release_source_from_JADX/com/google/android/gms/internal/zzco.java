package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzha
public class zzco extends Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzxx;
    private final zzcn zzyn;

    public zzco(zzcn com_google_android_gms_internal_zzcn) {
        Drawable drawable;
        double d;
        Uri uri = null;
        this.zzyn = com_google_android_gms_internal_zzcn;
        try {
            zzd zzdC = this.zzyn.zzdC();
            if (zzdC != null) {
                drawable = (Drawable) zze.zzp(zzdC);
                this.mDrawable = drawable;
                uri = this.zzyn.getUri();
                this.mUri = uri;
                d = 1.0d;
                d = this.zzyn.getScale();
                this.zzxx = d;
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get drawable.", e);
        }
        Object obj = uri;
        this.mDrawable = drawable;
        try {
            uri = this.zzyn.getUri();
        } catch (Throwable e2) {
            zzb.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
        d = 1.0d;
        try {
            d = this.zzyn.getScale();
        } catch (Throwable e3) {
            zzb.zzb("Failed to get scale.", e3);
        }
        this.zzxx = d;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public double getScale() {
        return this.zzxx;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
