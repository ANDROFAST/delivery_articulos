package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzgv.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzgw implements zza<zzd> {
    private final boolean zzFZ;
    private final boolean zzGa;

    public zzgw(boolean z, boolean z2) {
        this.zzFZ = z;
        this.zzGa = z2;
    }

    public /* synthetic */ zzh.zza zza(zzgv com_google_android_gms_internal_zzgv, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return zzb(com_google_android_gms_internal_zzgv, jSONObject);
    }

    public zzd zzb(zzgv com_google_android_gms_internal_zzgv, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        List<zzje> zza = com_google_android_gms_internal_zzgv.zza(jSONObject, "images", true, this.zzFZ, this.zzGa);
        Future zza2 = com_google_android_gms_internal_zzgv.zza(jSONObject, "app_icon", true, this.zzFZ);
        Future zze = com_google_android_gms_internal_zzgv.zze(jSONObject);
        List arrayList = new ArrayList();
        for (zzje com_google_android_gms_internal_zzje : zza) {
            arrayList.add(com_google_android_gms_internal_zzje.get());
        }
        return new zzd(jSONObject.getString("headline"), arrayList, jSONObject.getString("body"), (zzcn) zza2.get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"), (com.google.android.gms.ads.internal.formats.zza) zze.get(), new Bundle());
    }
}
