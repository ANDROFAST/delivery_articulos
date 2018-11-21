package com.google.android.gms.measurement;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class zzb implements zzi {
    private static final Uri zzaRh;
    private final LogPrinter zzaRi = new LogPrinter(4, "GA/LogCatTransport");

    class C04031 implements Comparator<zze> {
        final /* synthetic */ zzb zzaRj;

        C04031(zzb com_google_android_gms_measurement_zzb) {
            this.zzaRj = com_google_android_gms_measurement_zzb;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((zze) x0, (zze) x1);
        }

        public int zza(zze com_google_android_gms_measurement_zze, zze com_google_android_gms_measurement_zze2) {
            return com_google_android_gms_measurement_zze.getClass().getCanonicalName().compareTo(com_google_android_gms_measurement_zze2.getClass().getCanonicalName());
        }
    }

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzaRh = builder.build();
    }

    public void zzb(zzc com_google_android_gms_measurement_zzc) {
        List<zze> arrayList = new ArrayList(com_google_android_gms_measurement_zzc.zzzF());
        Collections.sort(arrayList, new C04031(this));
        StringBuilder stringBuilder = new StringBuilder();
        for (zze obj : arrayList) {
            Object obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(obj2);
            }
        }
        this.zzaRi.println(stringBuilder.toString());
    }

    public Uri zzii() {
        return zzaRh;
    }
}
