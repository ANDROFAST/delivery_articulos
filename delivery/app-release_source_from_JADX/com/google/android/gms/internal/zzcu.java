package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcn.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzcu extends NativeContentAd {
    private final List<Image> zzyp = new ArrayList();
    private final zzct zzyr;
    private final zzco zzys;

    public zzcu(zzct com_google_android_gms_internal_zzct) {
        zzco com_google_android_gms_internal_zzco;
        this.zzyr = com_google_android_gms_internal_zzct;
        try {
            List<Object> images = this.zzyr.getImages();
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
            zzcn zzdH = this.zzyr.zzdH();
            if (zzdH != null) {
                com_google_android_gms_internal_zzco = new zzco(zzdH);
                this.zzys = com_google_android_gms_internal_zzco;
            }
        } catch (Throwable e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        com_google_android_gms_internal_zzco = null;
        this.zzys = com_google_android_gms_internal_zzco;
    }

    public void destroy() {
        try {
            this.zzyr.destroy();
        } catch (Throwable e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.zzyr.getAdvertiser();
        } catch (Throwable e) {
            zzb.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzyr.getBody();
        } catch (Throwable e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzyr.getCallToAction();
        } catch (Throwable e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzyr.getExtras();
        } catch (Throwable e) {
            zzb.zzd("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzyr.getHeadline();
        } catch (Throwable e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public List<Image> getImages() {
        return this.zzyp;
    }

    public Image getLogo() {
        return this.zzys;
    }

    protected /* synthetic */ Object zzaJ() {
        return zzdE();
    }

    zzcn zzd(Object obj) {
        return obj instanceof IBinder ? zza.zzt((IBinder) obj) : null;
    }

    protected zzd zzdE() {
        try {
            return this.zzyr.zzdE();
        } catch (Throwable e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
