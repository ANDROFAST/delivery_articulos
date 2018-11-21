package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzab {
    private final List<Command> zzRp;
    private final long zzRq;
    private final long zzRr;
    private final int zzRs;
    private final boolean zzRt;
    private final String zzRu;
    private final Map<String, String> zzxc;

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z) {
        this(com_google_android_gms_analytics_internal_zzc, map, j, z, 0, 0, null);
    }

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(com_google_android_gms_analytics_internal_zzc, map, j, z, j2, i, null);
    }

    public zzab(zzc com_google_android_gms_analytics_internal_zzc, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzc);
        zzx.zzy(map);
        this.zzRr = j;
        this.zzRt = z;
        this.zzRq = j2;
        this.zzRs = i;
        this.zzRp = list != null ? list : Collections.EMPTY_LIST;
        this.zzRu = zzn(list);
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            String zza;
            if (zzj(entry.getKey())) {
                zza = zza(com_google_android_gms_analytics_internal_zzc, entry.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(com_google_android_gms_analytics_internal_zzc, entry.getValue()));
                }
            }
        }
        for (Entry entry2 : map.entrySet()) {
            if (!zzj(entry2.getKey())) {
                zza = zza(com_google_android_gms_analytics_internal_zzc, entry2.getKey());
                if (zza != null) {
                    hashMap.put(zza, zzb(com_google_android_gms_analytics_internal_zzc, entry2.getValue()));
                }
            }
        }
        if (!TextUtils.isEmpty(this.zzRu)) {
            zzam.zzc(hashMap, "_v", this.zzRu);
            if (this.zzRu.equals("ma4.0.0") || this.zzRu.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zzxc = Collections.unmodifiableMap(hashMap);
    }

    public static zzab zza(zzc com_google_android_gms_analytics_internal_zzc, zzab com_google_android_gms_analytics_internal_zzab, Map<String, String> map) {
        return new zzab(com_google_android_gms_analytics_internal_zzc, map, com_google_android_gms_analytics_internal_zzab.zzla(), com_google_android_gms_analytics_internal_zzab.zzlc(), com_google_android_gms_analytics_internal_zzab.zzkZ(), com_google_android_gms_analytics_internal_zzab.zzkY(), com_google_android_gms_analytics_internal_zzab.zzlb());
    }

    private static String zza(zzc com_google_android_gms_analytics_internal_zzc, Object obj) {
        if (obj == null) {
            return null;
        }
        Object obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            com_google_android_gms_analytics_internal_zzc.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        return TextUtils.isEmpty(obj2) ? null : obj2;
    }

    private static String zzb(zzc com_google_android_gms_analytics_internal_zzc, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        obj2 = obj2.substring(0, 8192);
        com_google_android_gms_analytics_internal_zzc.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), obj2);
        return obj2;
    }

    private static boolean zzj(Object obj) {
        return obj == null ? false : obj.toString().startsWith("&");
    }

    private String zzn(String str, String str2) {
        zzx.zzcG(str);
        zzx.zzb(!str.startsWith("&"), (Object) "Short param name required");
        String str3 = (String) this.zzxc.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String zzn(List<Command> list) {
        CharSequence value;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.getId())) {
                    value = command.getValue();
                    break;
                }
            }
        }
        value = null;
        return TextUtils.isEmpty(value) ? null : value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.zzRr);
        if (this.zzRq != 0) {
            stringBuffer.append(", dbId=").append(this.zzRq);
        }
        if (((long) this.zzRs) != 0) {
            stringBuffer.append(", appUID=").append(this.zzRs);
        }
        List<String> arrayList = new ArrayList(this.zzxc.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) this.zzxc.get(str));
        }
        return stringBuffer.toString();
    }

    public int zzkY() {
        return this.zzRs;
    }

    public long zzkZ() {
        return this.zzRq;
    }

    public long zzla() {
        return this.zzRr;
    }

    public List<Command> zzlb() {
        return this.zzRp;
    }

    public boolean zzlc() {
        return this.zzRt;
    }

    public long zzld() {
        return zzam.zzbq(zzn("_s", "0"));
    }

    public String zzle() {
        return zzn("_m", "");
    }

    public Map<String, String> zzn() {
        return this.zzxc;
    }
}
