package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcn.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzcs extends NativeAppInstallAd {
    private final zzcr zzyo;
    private final List<Image> zzyp = new ArrayList();
    private final zzco zzyq;

    public zzcs(zzcr com_google_android_gms_internal_zzcr) {
        zzco com_google_android_gms_internal_zzco;
        this.zzyo = com_google_android_gms_internal_zzcr;
        try {
            List<Object> images = this.zzyo.getImages();
            if (images != null) {
                for (Object zzd : images) {
                    zzcn zzd2 = zzd(zzd);
                    if (zzd2 != null) {
                        this.zzyp.add(new zzco(zzd2));
                    }
                }
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzcn zzdD = this.zzyo.zzdD();
            if (zzdD != null) {
                com_google_android_gms_internal_zzco = new zzco(zzdD);
                this.zzyq = com_google_android_gms_internal_zzco;
            }
        } catch (Throwable e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        com_google_android_gms_internal_zzco = null;
        this.zzyq = com_google_android_gms_internal_zzco;
    }

    public void destroy() {
        try {
            this.zzyo.destroy();
        } catch (Throwable e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzyo.getBody();
        } catch (Throwable e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzyo.getCallToAction();
        } catch (Throwable e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzyo.getExtras();
        } catch (Throwable e) {
            zzb.zzb("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzyo.getHeadline();
        } catch (Throwable e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public Image getIcon() {
        return this.zzyq;
    }

    public List<Image> getImages() {
        return this.zzyp;
    }

    public CharSequence getPrice() {
        try {
            return this.zzyo.getPrice();
        } catch (Throwable e) {
            zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        Double d = null;
        try {
            double starRating = this.zzyo.getStarRating();
            if (starRating != -1.0d) {
                d = Double.valueOf(starRating);
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get star rating.", e);
        }
        return d;
    }

    public CharSequence getStore() {
        try {
            return this.zzyo.getStore();
        } catch (Throwable e) {
            zzb.zzb("Failed to get store", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzaJ() {
        return zzdE();
    }

    zzcn zzd(Object obj) {
        return obj instanceof IBinder ? zza.zzt((IBinder) obj) : null;
    }

    protected zzd zzdE() {
        try {
            return this.zzyo.zzdE();
        } catch (Throwable e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
