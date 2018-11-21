package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfa.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzff extends zza {
    private final NativeAppInstallAdMapper zzBM;

    public zzff(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzBM = nativeAppInstallAdMapper;
    }

    public String getBody() {
        return this.zzBM.getBody();
    }

    public String getCallToAction() {
        return this.zzBM.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzBM.getExtras();
    }

    public String getHeadline() {
        return this.zzBM.getHeadline();
    }

    public List getImages() {
        List<Image> images = this.zzBM.getImages();
        if (images == null) {
            return null;
        }
        List arrayList = new ArrayList();
        for (Image image : images) {
            arrayList.add(new zzc(image.getDrawable(), image.getUri(), image.getScale()));
        }
        return arrayList;
    }

    public boolean getOverrideClickHandling() {
        return this.zzBM.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzBM.getOverrideImpressionRecording();
    }

    public String getPrice() {
        return this.zzBM.getPrice();
    }

    public double getStarRating() {
        return this.zzBM.getStarRating();
    }

    public String getStore() {
        return this.zzBM.getStore();
    }

    public void recordImpression() {
        this.zzBM.recordImpression();
    }

    public void zzc(zzd com_google_android_gms_dynamic_zzd) {
        this.zzBM.handleClick((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public void zzd(zzd com_google_android_gms_dynamic_zzd) {
        this.zzBM.trackView((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public zzcn zzdD() {
        Image icon = this.zzBM.getIcon();
        return icon != null ? new zzc(icon.getDrawable(), icon.getUri(), icon.getScale()) : null;
    }
}
