package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONObject;

public final class zzll implements PlayerInfo {
    private final int zzZH;
    private final JSONObject zzabG;
    private final boolean zzabH;
    private final String zzabq;

    public zzll(String str, int i, JSONObject jSONObject, boolean z) {
        this.zzabq = str;
        this.zzZH = i;
        this.zzabG = jSONObject;
        this.zzabH = z;
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof PlayerInfo)) {
            return false;
        }
        PlayerInfo playerInfo = (PlayerInfo) otherObj;
        return this.zzabH == playerInfo.isControllable() && this.zzZH == playerInfo.getPlayerState() && zzf.zza(this.zzabq, playerInfo.getPlayerId()) && zznu.zze(this.zzabG, playerInfo.getPlayerData());
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

    public int hashCode() {
        return zzw.hashCode(this.zzabq, Integer.valueOf(this.zzZH), this.zzabG, Boolean.valueOf(this.zzabH));
    }

    public boolean isConnected() {
        switch (this.zzZH) {
            case 3:
            case 4:
            case 5:
            case 6:
                return true;
            default:
                return false;
        }
    }

    public boolean isControllable() {
        return this.zzabH;
    }
}
