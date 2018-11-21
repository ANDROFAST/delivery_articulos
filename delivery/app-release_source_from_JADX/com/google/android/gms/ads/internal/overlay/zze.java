package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zznx;

@zzha
public class zze {
    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzDI == 4 && adOverlayInfoParcel.zzDB == null) {
            if (adOverlayInfoParcel.zzDA != null) {
                adOverlayInfoParcel.zzDA.onAdClicked();
            }
            zzp.zzbu().zza(context, adOverlayInfoParcel.zzDz, adOverlayInfoParcel.zzDH);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzqR.zzLH);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!zznx.isAtLeastL()) {
            intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
        }
        zzp.zzbx().zzb(context, intent);
    }
}
