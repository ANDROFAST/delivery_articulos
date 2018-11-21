package com.google.android.gms.analytics;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzc;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.internal.zzqj;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzql;
import com.google.android.gms.internal.zzqm;
import com.google.android.gms.internal.zzqn;
import com.google.android.gms.internal.zzqo;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzb extends zzc implements zzi {
    private static DecimalFormat zzNA;
    private final String zzNB;
    private final Uri zzNC;
    private final boolean zzND;
    private final boolean zzNE;
    private final zzf zzNq;

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, String str) {
        this(com_google_android_gms_analytics_internal_zzf, str, true, false);
    }

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, String str, boolean z, boolean z2) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzx.zzcG(str);
        this.zzNq = com_google_android_gms_analytics_internal_zzf;
        this.zzNB = str;
        this.zzND = z;
        this.zzNE = z2;
        this.zzNC = zzaR(this.zzNB);
    }

    private static String zzA(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zzb(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, i + "x" + i2);
        }
    }

    private static void zza(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    static Uri zzaR(String str) {
        zzx.zzcG(str);
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String zzb(double d) {
        if (zzNA == null) {
            zzNA = new DecimalFormat("0.######");
        }
        return zzNA.format(d);
    }

    private static void zzb(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public static Map<String, String> zzc(com.google.android.gms.measurement.zzc com_google_android_gms_measurement_zzc) {
        CharSequence zzU;
        Map hashMap = new HashMap();
        zzkb com_google_android_gms_internal_zzkb = (zzkb) com_google_android_gms_measurement_zzc.zzd(zzkb.class);
        if (com_google_android_gms_internal_zzkb != null) {
            for (Entry entry : com_google_android_gms_internal_zzkb.zziz().entrySet()) {
                String zzh = zzh(entry.getValue());
                if (zzh != null) {
                    hashMap.put(entry.getKey(), zzh);
                }
            }
        }
        zzkc com_google_android_gms_internal_zzkc = (zzkc) com_google_android_gms_measurement_zzc.zzd(zzkc.class);
        if (com_google_android_gms_internal_zzkc != null) {
            zzb(hashMap, "t", com_google_android_gms_internal_zzkc.zziA());
            zzb(hashMap, "cid", com_google_android_gms_internal_zzkc.getClientId());
            zzb(hashMap, "uid", com_google_android_gms_internal_zzkc.getUserId());
            zzb(hashMap, "sc", com_google_android_gms_internal_zzkc.zziD());
            zza(hashMap, "sf", com_google_android_gms_internal_zzkc.zziF());
            zza(hashMap, "ni", com_google_android_gms_internal_zzkc.zziE());
            zzb(hashMap, "adid", com_google_android_gms_internal_zzkc.zziB());
            zza(hashMap, "ate", com_google_android_gms_internal_zzkc.zziC());
        }
        zzqn com_google_android_gms_internal_zzqn = (zzqn) com_google_android_gms_measurement_zzc.zzd(zzqn.class);
        if (com_google_android_gms_internal_zzqn != null) {
            zzb(hashMap, "cd", com_google_android_gms_internal_zzqn.zzAm());
            zza(hashMap, "a", (double) com_google_android_gms_internal_zzqn.zzAn());
            zzb(hashMap, "dr", com_google_android_gms_internal_zzqn.zzAo());
        }
        zzql com_google_android_gms_internal_zzql = (zzql) com_google_android_gms_measurement_zzc.zzd(zzql.class);
        if (com_google_android_gms_internal_zzql != null) {
            zzb(hashMap, "ec", com_google_android_gms_internal_zzql.zzAj());
            zzb(hashMap, "ea", com_google_android_gms_internal_zzql.getAction());
            zzb(hashMap, "el", com_google_android_gms_internal_zzql.getLabel());
            zza(hashMap, "ev", (double) com_google_android_gms_internal_zzql.getValue());
        }
        zzqi com_google_android_gms_internal_zzqi = (zzqi) com_google_android_gms_measurement_zzc.zzd(zzqi.class);
        if (com_google_android_gms_internal_zzqi != null) {
            zzb(hashMap, "cn", com_google_android_gms_internal_zzqi.getName());
            zzb(hashMap, "cs", com_google_android_gms_internal_zzqi.getSource());
            zzb(hashMap, "cm", com_google_android_gms_internal_zzqi.zzzU());
            zzb(hashMap, "ck", com_google_android_gms_internal_zzqi.zzzV());
            zzb(hashMap, "cc", com_google_android_gms_internal_zzqi.getContent());
            zzb(hashMap, "ci", com_google_android_gms_internal_zzqi.getId());
            zzb(hashMap, "anid", com_google_android_gms_internal_zzqi.zzzW());
            zzb(hashMap, "gclid", com_google_android_gms_internal_zzqi.zzzX());
            zzb(hashMap, "dclid", com_google_android_gms_internal_zzqi.zzzY());
            zzb(hashMap, "aclid", com_google_android_gms_internal_zzqi.zzzZ());
        }
        zzqm com_google_android_gms_internal_zzqm = (zzqm) com_google_android_gms_measurement_zzc.zzd(zzqm.class);
        if (com_google_android_gms_internal_zzqm != null) {
            zzb(hashMap, "exd", com_google_android_gms_internal_zzqm.getDescription());
            zza(hashMap, "exf", com_google_android_gms_internal_zzqm.zzAk());
        }
        zzqo com_google_android_gms_internal_zzqo = (zzqo) com_google_android_gms_measurement_zzc.zzd(zzqo.class);
        if (com_google_android_gms_internal_zzqo != null) {
            zzb(hashMap, "sn", com_google_android_gms_internal_zzqo.zzAq());
            zzb(hashMap, "sa", com_google_android_gms_internal_zzqo.getAction());
            zzb(hashMap, "st", com_google_android_gms_internal_zzqo.getTarget());
        }
        zzqp com_google_android_gms_internal_zzqp = (zzqp) com_google_android_gms_measurement_zzc.zzd(zzqp.class);
        if (com_google_android_gms_internal_zzqp != null) {
            zzb(hashMap, "utv", com_google_android_gms_internal_zzqp.zzAr());
            zza(hashMap, "utt", (double) com_google_android_gms_internal_zzqp.getTimeInMillis());
            zzb(hashMap, "utc", com_google_android_gms_internal_zzqp.zzAj());
            zzb(hashMap, "utl", com_google_android_gms_internal_zzqp.getLabel());
        }
        zzjz com_google_android_gms_internal_zzjz = (zzjz) com_google_android_gms_measurement_zzc.zzd(zzjz.class);
        if (com_google_android_gms_internal_zzjz != null) {
            for (Entry entry2 : com_google_android_gms_internal_zzjz.zzix().entrySet()) {
                zzU = zzc.zzU(((Integer) entry2.getKey()).intValue());
                if (!TextUtils.isEmpty(zzU)) {
                    hashMap.put(zzU, entry2.getValue());
                }
            }
        }
        zzka com_google_android_gms_internal_zzka = (zzka) com_google_android_gms_measurement_zzc.zzd(zzka.class);
        if (com_google_android_gms_internal_zzka != null) {
            for (Entry entry22 : com_google_android_gms_internal_zzka.zziy().entrySet()) {
                zzU = zzc.zzW(((Integer) entry22.getKey()).intValue());
                if (!TextUtils.isEmpty(zzU)) {
                    hashMap.put(zzU, zzb(((Double) entry22.getValue()).doubleValue()));
                }
            }
        }
        zzqk com_google_android_gms_internal_zzqk = (zzqk) com_google_android_gms_measurement_zzc.zzd(zzqk.class);
        if (com_google_android_gms_internal_zzqk != null) {
            ProductAction zzAf = com_google_android_gms_internal_zzqk.zzAf();
            if (zzAf != null) {
                for (Entry entry3 : zzAf.build().entrySet()) {
                    if (((String) entry3.getKey()).startsWith("&")) {
                        hashMap.put(((String) entry3.getKey()).substring(1), entry3.getValue());
                    } else {
                        hashMap.put(entry3.getKey(), entry3.getValue());
                    }
                }
            }
            int i = 1;
            for (Promotion zzaX : com_google_android_gms_internal_zzqk.zzAi()) {
                hashMap.putAll(zzaX.zzaX(zzc.zzaa(i)));
                i++;
            }
            i = 1;
            for (Product zzaX2 : com_google_android_gms_internal_zzqk.zzAg()) {
                hashMap.putAll(zzaX2.zzaX(zzc.zzY(i)));
                i++;
            }
            i = 1;
            for (Entry entry222 : com_google_android_gms_internal_zzqk.zzAh().entrySet()) {
                List<Product> list = (List) entry222.getValue();
                String zzad = zzc.zzad(i);
                int i2 = 1;
                for (Product zzaX22 : list) {
                    hashMap.putAll(zzaX22.zzaX(zzad + zzc.zzab(i2)));
                    i2++;
                }
                if (!TextUtils.isEmpty((CharSequence) entry222.getKey())) {
                    hashMap.put(zzad + "nm", entry222.getKey());
                }
                i++;
            }
        }
        zzqj com_google_android_gms_internal_zzqj = (zzqj) com_google_android_gms_measurement_zzc.zzd(zzqj.class);
        if (com_google_android_gms_internal_zzqj != null) {
            zzb(hashMap, "ul", com_google_android_gms_internal_zzqj.getLanguage());
            zza(hashMap, "sd", (double) com_google_android_gms_internal_zzqj.zzAa());
            zza(hashMap, "sr", com_google_android_gms_internal_zzqj.zzAb(), com_google_android_gms_internal_zzqj.zzAc());
            zza(hashMap, "vp", com_google_android_gms_internal_zzqj.zzAd(), com_google_android_gms_internal_zzqj.zzAe());
        }
        zzqh com_google_android_gms_internal_zzqh = (zzqh) com_google_android_gms_measurement_zzc.zzd(zzqh.class);
        if (com_google_android_gms_internal_zzqh != null) {
            zzb(hashMap, "an", com_google_android_gms_internal_zzqh.zzkP());
            zzb(hashMap, "aid", com_google_android_gms_internal_zzqh.zzwg());
            zzb(hashMap, "aiid", com_google_android_gms_internal_zzqh.zzzT());
            zzb(hashMap, "av", com_google_android_gms_internal_zzqh.zzkR());
        }
        return hashMap;
    }

    private static String zzh(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return TextUtils.isEmpty(str) ? null : str;
        } else if (!(obj instanceof Double)) {
            return obj instanceof Boolean ? obj != Boolean.FALSE ? "1" : null : String.valueOf(obj);
        } else {
            Double d = (Double) obj;
            return d.doubleValue() != 0.0d ? zzb(d.doubleValue()) : null;
        }
    }

    public void zzb(com.google.android.gms.measurement.zzc com_google_android_gms_measurement_zzc) {
        zzx.zzy(com_google_android_gms_measurement_zzc);
        zzx.zzb(com_google_android_gms_measurement_zzc.zzzJ(), (Object) "Can't deliver not submitted measurement");
        zzx.zzcy("deliver should be called on worker thread");
        com.google.android.gms.measurement.zzc zzzE = com_google_android_gms_measurement_zzc.zzzE();
        zzkc com_google_android_gms_internal_zzkc = (zzkc) zzzE.zze(zzkc.class);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzkc.zziA())) {
            zziU().zzh(zzc(zzzE), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(com_google_android_gms_internal_zzkc.getClientId())) {
            zziU().zzh(zzc(zzzE), "Ignoring measurement without client id");
        } else if (!this.zzNq.zzji().getAppOptOut()) {
            double zziF = com_google_android_gms_internal_zzkc.zziF();
            if (zzam.zza(zziF, com_google_android_gms_internal_zzkc.getClientId())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zziF));
                return;
            }
            Map zzc = zzc(zzzE);
            zzc.put("v", "1");
            zzc.put("_v", zze.zzOS);
            zzc.put("tid", this.zzNB);
            if (this.zzNq.zzji().isDryRunEnabled()) {
                zzc("Dry run is enabled. GoogleAnalytics would have sent", zzA(zzc));
                return;
            }
            Map hashMap = new HashMap();
            zzam.zzc(hashMap, "uid", com_google_android_gms_internal_zzkc.getUserId());
            zzqh com_google_android_gms_internal_zzqh = (zzqh) com_google_android_gms_measurement_zzc.zzd(zzqh.class);
            if (com_google_android_gms_internal_zzqh != null) {
                zzam.zzc(hashMap, "an", com_google_android_gms_internal_zzqh.zzkP());
                zzam.zzc(hashMap, "aid", com_google_android_gms_internal_zzqh.zzwg());
                zzam.zzc(hashMap, "av", com_google_android_gms_internal_zzqh.zzkR());
                zzam.zzc(hashMap, "aiid", com_google_android_gms_internal_zzqh.zzzT());
            }
            zzc.put("_s", String.valueOf(zzip().zza(new zzh(0, com_google_android_gms_internal_zzkc.getClientId(), this.zzNB, !TextUtils.isEmpty(com_google_android_gms_internal_zzkc.zziB()), 0, hashMap))));
            zzip().zza(new zzab(zziU(), zzc, com_google_android_gms_measurement_zzc.zzzH(), true));
        }
    }

    public Uri zzii() {
        return this.zzNC;
    }
}
