package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzen {
    public final List<zzem> zzAO;
    public final long zzAP;
    public final List<String> zzAQ;
    public final List<String> zzAR;
    public final List<String> zzAS;
    public final String zzAT;
    public final long zzAU;
    public final String zzAV;
    public final int zzAW;
    public final int zzAX;
    public final long zzAY;
    public int zzAZ;
    public int zzBa;

    public zzen(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (zzb.zzQ(2)) {
            zzb.m7v("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        List arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            zzem com_google_android_gms_internal_zzem = new zzem(jSONArray.getJSONObject(i2));
            arrayList.add(com_google_android_gms_internal_zzem);
            if (i < 0 && zza(com_google_android_gms_internal_zzem)) {
                i = i2;
            }
        }
        this.zzAZ = i;
        this.zzBa = jSONArray.length();
        this.zzAO = Collections.unmodifiableList(arrayList);
        this.zzAT = jSONObject.getString("qdata");
        this.zzAX = jSONObject.optInt("fs_model_type", -1);
        this.zzAY = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzAP = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.zzAQ = zzp.zzbK().zza(optJSONObject, "click_urls");
            this.zzAR = zzp.zzbK().zza(optJSONObject, "imp_urls");
            this.zzAS = zzp.zzbK().zza(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzAU = optLong > 0 ? optLong * 1000 : -1;
            JSONArray optJSONArray = optJSONObject.optJSONArray("rewards");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                this.zzAV = null;
                this.zzAW = 0;
                return;
            }
            this.zzAV = optJSONArray.getJSONObject(0).optString("rb_type");
            this.zzAW = optJSONArray.getJSONObject(0).optInt("rb_amount");
            return;
        }
        this.zzAP = -1;
        this.zzAQ = null;
        this.zzAR = null;
        this.zzAS = null;
        this.zzAU = -1;
        this.zzAV = null;
        this.zzAW = 0;
    }

    private boolean zza(zzem com_google_android_gms_internal_zzem) {
        for (String equals : com_google_android_gms_internal_zzem.zzAG) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
