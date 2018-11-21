package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Map;
import java.util.Map.Entry;

public class zzaf extends zzd {
    private static String zzRC = "3";
    private static String zzRD = "01VDIWEA?";
    private static zzaf zzRE;

    public zzaf(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    public static zzaf zzlg() {
        return zzRE;
    }

    public void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        String str2 = (String) zzy.zzQr.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc.zzc(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            zzb(i, str, obj, obj2, obj3);
        }
    }

    public void zza(zzab com_google_android_gms_analytics_internal_zzab, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        zzd("Discarding hit. " + str, com_google_android_gms_analytics_internal_zzab != null ? com_google_android_gms_analytics_internal_zzab.toString() : "no hit data");
    }

    public synchronized void zzb(int i, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        synchronized (this) {
            zzx.zzy(str);
            if (i >= 0) {
                i2 = i;
            }
            int length = i2 >= zzRD.length() ? zzRD.length() - 1 : i2;
            char c = zziV().zzkb() ? zziV().zzka() ? 'P' : 'C' : zziV().zzka() ? 'p' : 'c';
            String str2 = zzRC + zzRD.charAt(length) + c + zze.VERSION + ":" + zzc.zzc(str, zzk(obj), zzk(obj2), zzk(obj3));
            if (str2.length() > 1024) {
                str2 = str2.substring(0, 1024);
            }
            zzai zzjj = zziQ().zzjj();
            if (zzjj != null) {
                zzjj.zzlt().zzbn(str2);
            }
        }
    }

    public void zzh(Map<String, String> map, String str) {
        Object stringBuilder;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : map.entrySet()) {
                if (stringBuilder2.length() > 0) {
                    stringBuilder2.append(',');
                }
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append('=');
                stringBuilder2.append((String) entry.getValue());
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "no hit data";
        }
        zzd("Discarding hit. " + str, stringBuilder);
    }

    protected void zzir() {
        synchronized (zzaf.class) {
            zzRE = this;
        }
    }

    protected String zzk(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long((long) ((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        } else {
            if (Math.abs(((Long) l).longValue()) < 100) {
                return String.valueOf(l);
            }
            String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return stringBuilder.toString();
        }
    }
}
