package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zznx;

public abstract class zzj {
    public abstract zzi zza(Context context, zzjn com_google_android_gms_internal_zzjn, int i, zzch com_google_android_gms_internal_zzch, zzcf com_google_android_gms_internal_zzcf);

    protected boolean zzx(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return zznx.zzrQ() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11);
    }
}
