package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzlh {
    private final String zzabt;
    private final int zzabu;
    private final String zzabv;

    public zzlh(String str, int i, String str2) {
        this.zzabt = str;
        this.zzabu = i;
        this.zzabv = str2;
    }

    public zzlh(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("applicationName"), jSONObject.optInt("maxPlayers"), jSONObject.optString("version"));
    }

    public final int getMaxPlayers() {
        return this.zzabu;
    }

    public final String getVersion() {
        return this.zzabv;
    }

    public final String zznF() {
        return this.zzabt;
    }
}
