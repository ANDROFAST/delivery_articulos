package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzjo.zza;

@zzha
public class zzgr extends zzgm implements zza {
    zzgr(Context context, zzie.zza com_google_android_gms_internal_zzie_zza, zzjn com_google_android_gms_internal_zzjn, zzgq.zza com_google_android_gms_internal_zzgq_zza) {
        super(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzgq_zza);
    }

    protected void zzfP() {
        if (this.zzFd.errorCode == -2) {
            this.zzps.zzhC().zza((zza) this);
            zzfW();
            zzb.m7v("Loading HTML in WebView.");
            this.zzps.loadDataWithBaseURL(zzp.zzbx().zzaz(this.zzFd.zzDE), this.zzFd.body, "text/html", "UTF-8", null);
        }
    }

    protected void zzfW() {
    }
}
