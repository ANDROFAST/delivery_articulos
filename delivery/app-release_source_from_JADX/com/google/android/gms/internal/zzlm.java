package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzlm {
    private final int zzZH;
    private final JSONObject zzabG;
    private final String zzabq;

    public zzlm(String str, int i, JSONObject jSONObject) {
        this.zzabq = str;
        this.zzZH = i;
        this.zzabG = jSONObject;
    }

    public zzlm(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof zzlm)) {
            return false;
        }
        zzlm com_google_android_gms_internal_zzlm = (zzlm) otherObj;
        return this.zzZH == com_google_android_gms_internal_zzlm.getPlayerState() && zzf.zza(this.zzabq, com_google_android_gms_internal_zzlm.getPlayerId()) && zznu.zze(this.zzabG, com_google_android_gms_internal_zzlm.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzabG;
    }

    public String getPlayerId() {
        return this.zzabq;
    }

    public int getPlayerState() {
        return this.zzZH;
    }
}
