package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzha
public final class zzhf {
    private int mOrientation = -1;
    private final AdRequestInfoParcel zzBu;
    private List<String> zzFH;
    private String zzIb;
    private String zzIc;
    private List<String> zzId;
    private String zzIe;
    private String zzIf;
    private List<String> zzIg;
    private long zzIh = -1;
    private boolean zzIi = false;
    private final long zzIj = -1;
    private long zzIk = -1;
    private boolean zzIl = false;
    private boolean zzIm = false;
    private boolean zzIn = false;
    private boolean zzIo = true;
    private int zzIp = 0;
    private String zzIq = "";
    private boolean zzIr = false;
    private String zzxA;

    public zzhf(AdRequestInfoParcel adRequestInfoParcel) {
        this.zzBu = adRequestInfoParcel;
    }

    static String zzd(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    static long zze(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzb.zzaH("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    static List<String> zzf(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private boolean zzg(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf((String) list.get(0)).booleanValue()) ? false : true;
    }

    private void zzi(Map<String, List<String>> map) {
        this.zzIb = zzd(map, "X-Afma-Ad-Size");
    }

    private void zzj(Map<String, List<String>> map) {
        List zzf = zzf(map, "X-Afma-Click-Tracking-Urls");
        if (zzf != null) {
            this.zzId = zzf;
        }
    }

    private void zzk(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzIe = (String) list.get(0);
        }
    }

    private void zzl(Map<String, List<String>> map) {
        List zzf = zzf(map, "X-Afma-Tracking-Urls");
        if (zzf != null) {
            this.zzIg = zzf;
        }
    }

    private void zzm(Map<String, List<String>> map) {
        long zze = zze(map, "X-Afma-Interstitial-Timeout");
        if (zze != -1) {
            this.zzIh = zze;
        }
    }

    private void zzn(Map<String, List<String>> map) {
        this.zzIf = zzd(map, "X-Afma-ActiveView");
    }

    private void zzo(Map<String, List<String>> map) {
        this.zzIm = "native".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzp(Map<String, List<String>> map) {
        this.zzIl |= zzg(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzq(Map<String, List<String>> map) {
        this.zzIi |= zzg(map, "X-Afma-Mediation");
    }

    private void zzr(Map<String, List<String>> map) {
        List zzf = zzf(map, "X-Afma-Manual-Tracking-Urls");
        if (zzf != null) {
            this.zzFH = zzf;
        }
    }

    private void zzs(Map<String, List<String>> map) {
        long zze = zze(map, "X-Afma-Refresh-Rate");
        if (zze != -1) {
            this.zzIk = zze;
        }
    }

    private void zzt(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = zzp.zzbz().zzhe();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = zzp.zzbz().zzhd();
            }
        }
    }

    private void zzu(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Use-HTTPS");
        if (list != null && !list.isEmpty()) {
            this.zzIn = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzv(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (list != null && !list.isEmpty()) {
            this.zzIo = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void zzw(Map<String, List<String>> map) {
        List<String> zzf = zzf(map, "X-Afma-OAuth-Token-Status");
        this.zzIp = 0;
        if (zzf != null) {
            for (String str : zzf) {
                if ("Clear".equalsIgnoreCase(str)) {
                    this.zzIp = 1;
                    return;
                } else if ("No-Op".equalsIgnoreCase(str)) {
                    this.zzIp = 0;
                    return;
                }
            }
        }
    }

    private void zzx(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Gws-Query-Id");
        if (list != null && !list.isEmpty()) {
            this.zzIq = (String) list.get(0);
        }
    }

    private void zzy(Map<String, List<String>> map) {
        String zzd = zzd(map, "X-Afma-Fluid");
        if (zzd != null && zzd.equals("height")) {
            this.zzIr = true;
        }
    }

    public void zzb(String str, Map<String, List<String>> map, String str2) {
        this.zzIc = str;
        this.zzxA = str2;
        zzh(map);
    }

    public void zzh(Map<String, List<String>> map) {
        zzi(map);
        zzj((Map) map);
        zzk(map);
        zzl(map);
        zzm(map);
        zzq(map);
        zzr(map);
        zzs(map);
        zzt(map);
        zzn(map);
        zzu(map);
        zzp(map);
        zzo(map);
        zzv(map);
        zzw(map);
        zzx(map);
        zzy(map);
    }

    public AdResponseParcel zzj(long j) {
        return new AdResponseParcel(this.zzBu, this.zzIc, this.zzxA, this.zzId, this.zzIg, this.zzIh, this.zzIi, -1, this.zzFH, this.zzIk, this.mOrientation, this.zzIb, j, this.zzIe, this.zzIf, this.zzIl, this.zzIm, this.zzIn, this.zzIo, false, this.zzIp, this.zzIq, this.zzIr);
    }
}
