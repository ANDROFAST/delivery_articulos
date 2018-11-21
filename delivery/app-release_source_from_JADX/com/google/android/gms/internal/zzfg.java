package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfb.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzfg extends zza {
    private final NativeContentAdMapper zzBN;

    public zzfg(NativeContentAdMapper nativeContentAdMapper) {
        this.zzBN = nativeContentAdMapper;
    }

    public String getAdvertiser() {
        return this.zzBN.getAdvertiser();
    }

    public String getBody() {
        return this.zzBN.getBody();
    }

    public String getCallToAction() {
        return this.zzBN.getCallToAction();
    }

    public Bundle getExtras() {
        return this.zzBN.getExtras();
    }

    public String getHeadline() {
        return this.zzBN.getHeadline();
    }

    public List getImages() {
        List<Image> images = this.zzBN.getImages();
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
        return this.zzBN.getOverrideClickHandling();
    }

    public boolean getOverrideImpressionRecording() {
        return this.zzBN.getOverrideImpressionRecording();
    }

    public void recordImpression() {
        this.zzBN.recordImpression();
    }

    public void zzc(zzd com_google_android_gms_dynamic_zzd) {
        this.zzBN.handleClick((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public void zzd(zzd com_google_android_gms_dynamic_zzd) {
        this.zzBN.trackView((View) zze.zzp(com_google_android_gms_dynamic_zzd));
    }

    public zzcn zzdH() {
        Image logo = this.zzBN.getLogo();
        return logo != null ? new zzc(logo.getDrawable(), logo.getUri(), logo.getScale()) : null;
    }
}
