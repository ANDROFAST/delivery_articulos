package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;

public class zzg {
    final String mName;
    final String zzaRd;
    final String zzaSC;
    final long zzaSD;
    final EventParams zzaSE;
    final long zzacS;

    zzg(zzt com_google_android_gms_measurement_internal_zzt, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzx.zzcG(str2);
        zzx.zzcG(str3);
        this.zzaRd = str2;
        this.mName = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaSC = str;
        this.zzacS = j;
        this.zzaSD = j2;
        if (this.zzaSD != 0 && this.zzaSD > this.zzacS) {
            com_google_android_gms_measurement_internal_zzt.zzzz().zzBm().zzez("Event created with reverse previous/current timestamps");
        }
        this.zzaSE = zza(com_google_android_gms_measurement_internal_zzt, bundle);
    }

    private zzg(zzt com_google_android_gms_measurement_internal_zzt, String str, String str2, String str3, long j, long j2, EventParams eventParams) {
        zzx.zzcG(str2);
        zzx.zzcG(str3);
        zzx.zzy(eventParams);
        this.zzaRd = str2;
        this.mName = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzaSC = str;
        this.zzacS = j;
        this.zzaSD = j2;
        if (this.zzaSD != 0 && this.zzaSD > this.zzacS) {
            com_google_android_gms_measurement_internal_zzt.zzzz().zzBm().zzez("Event created with reverse previous/current timestamps");
        }
        this.zzaSE = eventParams;
    }

    private EventParams zza(zzt com_google_android_gms_measurement_internal_zzt, Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return new EventParams(new Bundle());
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator it = bundle2.keySet().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str == null) {
                it.remove();
            } else {
                Object zzk = com_google_android_gms_measurement_internal_zzt.zzAU().zzk(str, bundle2.get(str));
                if (zzk == null) {
                    it.remove();
                } else {
                    com_google_android_gms_measurement_internal_zzt.zzAU().zza(bundle2, str, zzk);
                }
            }
        }
        return new EventParams(bundle2);
    }

    public String toString() {
        return "Event{appId='" + this.zzaRd + '\'' + ", name='" + this.mName + '\'' + ", params=" + this.zzaSE + '}';
    }

    zzg zza(zzt com_google_android_gms_measurement_internal_zzt, long j) {
        return new zzg(com_google_android_gms_measurement_internal_zzt, this.zzaSC, this.zzaRd, this.mName, this.zzacS, j, this.zzaSE);
    }
}
