package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzf;
import com.google.android.gms.measurement.zzi;
import java.util.ListIterator;

public class zza extends zzf<zza> {
    private final com.google.android.gms.analytics.internal.zzf zzNq;
    private boolean zzNr;

    public zza(com.google.android.gms.analytics.internal.zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf.zziW(), com_google_android_gms_analytics_internal_zzf.zziT());
        this.zzNq = com_google_android_gms_analytics_internal_zzf;
    }

    public void enableAdvertisingIdCollection(boolean enable) {
        this.zzNr = enable;
    }

    protected void zza(zzc com_google_android_gms_measurement_zzc) {
        zzkc com_google_android_gms_internal_zzkc = (zzkc) com_google_android_gms_measurement_zzc.zze(zzkc.class);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzkc.getClientId())) {
            com_google_android_gms_internal_zzkc.setClientId(this.zzNq.zzjl().zzjT());
        }
        if (this.zzNr && TextUtils.isEmpty(com_google_android_gms_internal_zzkc.zziB())) {
            com.google.android.gms.analytics.internal.zza zzjk = this.zzNq.zzjk();
            com_google_android_gms_internal_zzkc.zzaV(zzjk.zziG());
            com_google_android_gms_internal_zzkc.zzH(zzjk.zziC());
        }
    }

    public void zzaP(String str) {
        zzx.zzcG(str);
        zzaQ(str);
        zzzQ().add(new zzb(this.zzNq, str));
    }

    public void zzaQ(String str) {
        Uri zzaR = zzb.zzaR(str);
        ListIterator listIterator = zzzQ().listIterator();
        while (listIterator.hasNext()) {
            if (zzaR.equals(((zzi) listIterator.next()).zzii())) {
                listIterator.remove();
            }
        }
    }

    com.google.android.gms.analytics.internal.zzf zzif() {
        return this.zzNq;
    }

    public zzc zzig() {
        zzc zzzE = zzzP().zzzE();
        zzzE.zzb(this.zzNq.zzjb().zzjB());
        zzzE.zzb(this.zzNq.zzjc().zzkI());
        zzd(zzzE);
        return zzzE;
    }
}
