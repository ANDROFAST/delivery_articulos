package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzha
public class zzcw implements NativeCustomTemplateAd {
    private final zzcv zzyt;

    public zzcw(zzcv com_google_android_gms_internal_zzcv) {
        this.zzyt = com_google_android_gms_internal_zzcv;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzyt.getAvailableAssetNames();
        } catch (Throwable e) {
            zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzyt.getCustomTemplateId();
        } catch (Throwable e) {
            zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String assetName) {
        try {
            zzcn zzT = this.zzyt.zzT(assetName);
            if (zzT != null) {
                return new zzco(zzT);
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String assetName) {
        try {
            return this.zzyt.zzS(assetName);
        } catch (Throwable e) {
            zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String assetName) {
        try {
            this.zzyt.performClick(assetName);
        } catch (Throwable e) {
            zzb.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzyt.recordImpression();
        } catch (Throwable e) {
            zzb.zzb("Failed to record impression.", e);
        }
    }
}
