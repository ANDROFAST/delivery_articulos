package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONObject;

@zzha
public class zzdq implements zzdl {
    final HashMap<String, zzjb<JSONObject>> zzza = new HashMap();

    public Future<JSONObject> zzW(String str) {
        Future com_google_android_gms_internal_zzjb = new zzjb();
        this.zzza.put(str, com_google_android_gms_internal_zzjb);
        return com_google_android_gms_internal_zzjb;
    }

    public void zzX(String str) {
        zzjb com_google_android_gms_internal_zzjb = (zzjb) this.zzza.get(str);
        if (com_google_android_gms_internal_zzjb == null) {
            zzb.m6e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!com_google_android_gms_internal_zzjb.isDone()) {
            com_google_android_gms_internal_zzjb.cancel(true);
        }
        this.zzza.remove(str);
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        zze((String) map.get("request_id"), (String) map.get("fetched_ad"));
    }

    public void zze(String str, String str2) {
        zzb.zzaF("Received ad from the cache.");
        zzjb com_google_android_gms_internal_zzjb = (zzjb) this.zzza.get(str);
        if (com_google_android_gms_internal_zzjb == null) {
            zzb.m6e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        try {
            com_google_android_gms_internal_zzjb.zzf(new JSONObject(str2));
        } catch (Throwable e) {
            zzb.zzb("Failed constructing JSON object from value passed from javascript", e);
            com_google_android_gms_internal_zzjb.zzf(null);
        } finally {
            this.zzza.remove(str);
        }
    }
}
