package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzem {
    public final String zzAE;
    public final String zzAF;
    public final List<String> zzAG;
    public final String zzAH;
    public final String zzAI;
    public final List<String> zzAJ;
    public final List<String> zzAK;
    public final String zzAL;
    public final List<String> zzAM;
    public final List<String> zzAN;

    public zzem(JSONObject jSONObject) throws JSONException {
        String str = null;
        this.zzAF = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        List arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzAG = Collections.unmodifiableList(arrayList);
        this.zzAH = jSONObject.optString("allocation_id", null);
        this.zzAJ = zzp.zzbK().zza(jSONObject, "clickurl");
        this.zzAK = zzp.zzbK().zza(jSONObject, "imp_urls");
        this.zzAM = zzp.zzbK().zza(jSONObject, "video_start_urls");
        this.zzAN = zzp.zzbK().zza(jSONObject, "video_complete_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.zzAE = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzAL = optJSONObject2 != null ? optJSONObject2.toString() : null;
        if (optJSONObject2 != null) {
            str = optJSONObject2.optString("class_name");
        }
        this.zzAI = str;
    }
}
