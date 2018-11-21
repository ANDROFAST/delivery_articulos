package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zzha
public class zzch {
    private final Object zzpK = new Object();
    boolean zzwK;
    private final List<zzcf> zzxb = new LinkedList();
    private final Map<String, String> zzxc = new LinkedHashMap();
    private String zzxd;
    private zzcf zzxe;
    private zzch zzxf;

    public zzch(boolean z, String str, String str2) {
        this.zzwK = z;
        this.zzxc.put("action", str);
        this.zzxc.put("ad_format", str2);
    }

    public void zzR(String str) {
        if (this.zzwK) {
            synchronized (this.zzpK) {
                this.zzxd = str;
            }
        }
    }

    public boolean zza(zzcf com_google_android_gms_internal_zzcf, long j, String... strArr) {
        synchronized (this.zzpK) {
            for (String com_google_android_gms_internal_zzcf2 : strArr) {
                this.zzxb.add(new zzcf(j, com_google_android_gms_internal_zzcf2, com_google_android_gms_internal_zzcf));
            }
        }
        return true;
    }

    public boolean zza(zzcf com_google_android_gms_internal_zzcf, String... strArr) {
        return (!this.zzwK || com_google_android_gms_internal_zzcf == null) ? false : zza(com_google_android_gms_internal_zzcf, zzp.zzbB().elapsedRealtime(), strArr);
    }

    public zzcf zzb(long j) {
        return !this.zzwK ? null : new zzcf(j, null, null);
    }

    public void zzc(zzch com_google_android_gms_internal_zzch) {
        synchronized (this.zzpK) {
            this.zzxf = com_google_android_gms_internal_zzch;
        }
    }

    public void zzd(String str, String str2) {
        if (this.zzwK && !TextUtils.isEmpty(str2)) {
            zzcb zzgM = zzp.zzbA().zzgM();
            if (zzgM != null) {
                synchronized (this.zzpK) {
                    zzgM.zzP(str).zza(this.zzxc, str, str2);
                }
            }
        }
    }

    public zzcf zzdu() {
        return zzb(zzp.zzbB().elapsedRealtime());
    }

    public void zzdv() {
        synchronized (this.zzpK) {
            this.zzxe = zzdu();
        }
    }

    public String zzdw() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        synchronized (this.zzpK) {
            for (zzcf com_google_android_gms_internal_zzcf : this.zzxb) {
                long time = com_google_android_gms_internal_zzcf.getTime();
                String zzdr = com_google_android_gms_internal_zzcf.zzdr();
                zzcf com_google_android_gms_internal_zzcf2 = com_google_android_gms_internal_zzcf2.zzds();
                if (com_google_android_gms_internal_zzcf2 != null && time > 0) {
                    stringBuilder2.append(zzdr).append('.').append(time - com_google_android_gms_internal_zzcf2.getTime()).append(',');
                }
            }
            this.zzxb.clear();
            if (!TextUtils.isEmpty(this.zzxd)) {
                stringBuilder2.append(this.zzxd);
            } else if (stringBuilder2.length() > 0) {
                stringBuilder2.setLength(stringBuilder2.length() - 1);
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    public zzcf zzdx() {
        zzcf com_google_android_gms_internal_zzcf;
        synchronized (this.zzpK) {
            com_google_android_gms_internal_zzcf = this.zzxe;
        }
        return com_google_android_gms_internal_zzcf;
    }

    Map<String, String> zzn() {
        Map<String, String> map;
        synchronized (this.zzpK) {
            zzcb zzgM = zzp.zzbA().zzgM();
            if (zzgM == null || this.zzxf == null) {
                map = this.zzxc;
            } else {
                map = zzgM.zza(this.zzxc, this.zzxf.zzn());
            }
        }
        return map;
    }
}
