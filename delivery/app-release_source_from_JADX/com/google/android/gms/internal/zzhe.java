package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzei.zzd;
import java.util.Map;
import java.util.concurrent.Future;

@zzha
public final class zzhe {
    private String zzDX;
    private String zzHV;
    private zzjb<zzhh> zzHW = new zzjb();
    zzd zzHX;
    public final zzdl zzHY = new C07251(this);
    public final zzdl zzHZ = new C07262(this);
    private final Object zzpK = new Object();
    zzjn zzps;

    class C07251 implements zzdl {
        final /* synthetic */ zzhe zzIa;

        C07251(zzhe com_google_android_gms_internal_zzhe) {
            this.zzIa = com_google_android_gms_internal_zzhe;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            synchronized (this.zzIa.zzpK) {
                if (this.zzIa.zzHW.isDone()) {
                } else if (this.zzIa.zzDX.equals(map.get("request_id"))) {
                    zzhh com_google_android_gms_internal_zzhh = new zzhh(1, map);
                    zzb.zzaH("Invalid " + com_google_android_gms_internal_zzhh.getType() + " request error: " + com_google_android_gms_internal_zzhh.zzgr());
                    this.zzIa.zzHW.zzf(com_google_android_gms_internal_zzhh);
                }
            }
        }
    }

    class C07262 implements zzdl {
        final /* synthetic */ zzhe zzIa;

        C07262(zzhe com_google_android_gms_internal_zzhe) {
            this.zzIa = com_google_android_gms_internal_zzhe;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            synchronized (this.zzIa.zzpK) {
                if (this.zzIa.zzHW.isDone()) {
                    return;
                }
                zzhh com_google_android_gms_internal_zzhh = new zzhh(-2, map);
                if (this.zzIa.zzDX.equals(com_google_android_gms_internal_zzhh.getRequestId())) {
                    String url = com_google_android_gms_internal_zzhh.getUrl();
                    if (url == null) {
                        zzb.zzaH("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (url.contains("%40mediation_adapters%40")) {
                        String replaceAll = url.replaceAll("%40mediation_adapters%40", zzik.zza(com_google_android_gms_internal_zzjn.getContext(), (String) map.get("check_adapters"), this.zzIa.zzHV));
                        com_google_android_gms_internal_zzhh.setUrl(replaceAll);
                        zzb.m7v("Ad request URL modified to " + replaceAll);
                    }
                    this.zzIa.zzHW.zzf(com_google_android_gms_internal_zzhh);
                    return;
                }
                zzb.zzaH(com_google_android_gms_internal_zzhh.getRequestId() + " ==== " + this.zzIa.zzDX);
            }
        }
    }

    public zzhe(String str, String str2) {
        this.zzHV = str2;
        this.zzDX = str;
    }

    public void zzb(zzd com_google_android_gms_internal_zzei_zzd) {
        this.zzHX = com_google_android_gms_internal_zzei_zzd;
    }

    public void zze(zzjn com_google_android_gms_internal_zzjn) {
        this.zzps = com_google_android_gms_internal_zzjn;
    }

    public zzd zzgo() {
        return this.zzHX;
    }

    public Future<zzhh> zzgp() {
        return this.zzHW;
    }

    public void zzgq() {
        if (this.zzps != null) {
            this.zzps.destroy();
            this.zzps = null;
        }
    }
}
