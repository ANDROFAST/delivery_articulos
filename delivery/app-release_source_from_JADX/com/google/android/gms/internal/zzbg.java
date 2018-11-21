package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

@zzha
public class zzbg implements zzbf {
    private final zzbe zzsA;
    private final HashSet<SimpleEntry<String, zzdl>> zzsB = new HashSet();

    public zzbg(zzbe com_google_android_gms_internal_zzbe) {
        this.zzsA = com_google_android_gms_internal_zzbe;
    }

    public void zza(String str, zzdl com_google_android_gms_internal_zzdl) {
        this.zzsA.zza(str, com_google_android_gms_internal_zzdl);
        this.zzsB.add(new SimpleEntry(str, com_google_android_gms_internal_zzdl));
    }

    public void zza(String str, String str2) {
        this.zzsA.zza(str, str2);
    }

    public void zza(String str, JSONObject jSONObject) {
        this.zzsA.zza(str, jSONObject);
    }

    public void zzb(String str, zzdl com_google_android_gms_internal_zzdl) {
        this.zzsA.zzb(str, com_google_android_gms_internal_zzdl);
        this.zzsB.remove(new SimpleEntry(str, com_google_android_gms_internal_zzdl));
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzsA.zzb(str, jSONObject);
    }

    public void zzcs() {
        Iterator it = this.zzsB.iterator();
        while (it.hasNext()) {
            SimpleEntry simpleEntry = (SimpleEntry) it.next();
            zzb.m7v("Unregistering eventhandler: " + ((zzdl) simpleEntry.getValue()).toString());
            this.zzsA.zzb((String) simpleEntry.getKey(), (zzdl) simpleEntry.getValue());
        }
        this.zzsB.clear();
    }
}
