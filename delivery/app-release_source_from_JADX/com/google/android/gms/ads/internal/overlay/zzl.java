package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;

@zzha
public class zzl extends zzj {
    public zzi zza(Context context, zzjn com_google_android_gms_internal_zzjn, int i, zzch com_google_android_gms_internal_zzch, zzcf com_google_android_gms_internal_zzcf) {
        if (!zzx(context)) {
            return null;
        }
        return new zzc(context, new zzp(context, com_google_android_gms_internal_zzjn.zzhF(), com_google_android_gms_internal_zzjn.getRequestId(), com_google_android_gms_internal_zzch, com_google_android_gms_internal_zzcf));
    }
}
