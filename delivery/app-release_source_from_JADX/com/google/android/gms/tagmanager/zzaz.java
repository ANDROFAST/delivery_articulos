package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsh.zzc;
import com.google.android.gms.internal.zzsh.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzaz {
    private static zza zzK(Object obj) throws JSONException {
        return zzdf.zzR(zzL(obj));
    }

    static Object zzL(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, zzL(jSONObject.get(str)));
            }
            return hashMap;
        }
    }

    public static zzc zzfu(String str) throws JSONException {
        zza zzK = zzK(new JSONObject(str));
        zzd zzFO = zzc.zzFO();
        for (int i = 0; i < zzK.zzjq.length; i++) {
            zzFO.zzc(zzsh.zza.zzFL().zzb(zzae.INSTANCE_NAME.toString(), zzK.zzjq[i]).zzb(zzae.FUNCTION.toString(), zzdf.zzfF(zzn.zzEd())).zzb(zzn.zzEe(), zzK.zzjr[i]).zzFN());
        }
        return zzFO.zzFR();
    }
}
