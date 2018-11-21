package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class zzli {
    private static final zzl zzYy = new zzl("GameManagerMessage");
    protected final zzlh zzaaX;
    protected final int zzabA;
    protected final List<zzlm> zzabB;
    protected final JSONObject zzabC;
    protected final String zzabD;
    protected final String zzabE;
    protected final String zzabq;
    protected final long zzabr;
    protected final JSONObject zzabs;
    protected final int zzabw;
    protected final int zzabx;
    protected final String zzaby;
    protected final int zzabz;

    public zzli(int i, int i2, String str, JSONObject jSONObject, int i3, int i4, List<zzlm> list, JSONObject jSONObject2, String str2, String str3, long j, String str4, zzlh com_google_android_gms_internal_zzlh) {
        this.zzabw = i;
        this.zzabx = i2;
        this.zzaby = str;
        this.zzabs = jSONObject;
        this.zzabz = i3;
        this.zzabA = i4;
        this.zzabB = list;
        this.zzabC = jSONObject2;
        this.zzabD = str2;
        this.zzabq = str3;
        this.zzabr = j;
        this.zzabE = str4;
        this.zzaaX = com_google_android_gms_internal_zzlh;
    }

    private static List<zzlm> zza(JSONArray jSONArray) {
        List<zzlm> arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Object com_google_android_gms_internal_zzlm;
                try {
                    com_google_android_gms_internal_zzlm = new zzlm(optJSONObject);
                } catch (Throwable e) {
                    zzYy.zzc(e, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", Integer.valueOf(i));
                    com_google_android_gms_internal_zzlm = null;
                }
                if (com_google_android_gms_internal_zzlm != null) {
                    arrayList.add(com_google_android_gms_internal_zzlm);
                }
            }
        }
        return arrayList;
    }

    protected static zzli zzh(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("type", -1);
        switch (optInt) {
            case 1:
                zzlh com_google_android_gms_internal_zzlh = null;
                JSONObject optJSONObject = jSONObject.optJSONObject("gameManagerConfig");
                if (optJSONObject != null) {
                    zzlh com_google_android_gms_internal_zzlh2 = new zzlh(optJSONObject);
                }
                return new zzli(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), jSONObject.optLong("requestId"), jSONObject.optString("playerToken"), com_google_android_gms_internal_zzlh);
            case 2:
                return new zzli(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), -1, null, null);
            default:
                try {
                    zzYy.zzf("Unrecognized Game Message type %d", Integer.valueOf(optInt));
                    break;
                } catch (Throwable e) {
                    zzYy.zzc(e, "Exception while parsing GameManagerMessage from json", new Object[0]);
                    break;
                }
        }
        return null;
    }

    public final JSONObject getExtraMessageData() {
        return this.zzabs;
    }

    public final JSONObject getGameData() {
        return this.zzabC;
    }

    public final int getGameplayState() {
        return this.zzabz;
    }

    public final int getLobbyState() {
        return this.zzabA;
    }

    public final String getPlayerId() {
        return this.zzabq;
    }

    public final long getRequestId() {
        return this.zzabr;
    }

    public final int getStatusCode() {
        return this.zzabx;
    }

    public final int zznG() {
        return this.zzabw;
    }

    public final String zznH() {
        return this.zzaby;
    }

    public final List<zzlm> zznI() {
        return this.zzabB;
    }

    public final String zznJ() {
        return this.zzabD;
    }

    public final String zznK() {
        return this.zzabE;
    }

    public final zzlh zznL() {
        return this.zzaaX;
    }
}
