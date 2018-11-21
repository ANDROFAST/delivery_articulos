package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzlk implements GameManagerState {
    private final int zzabA;
    private final JSONObject zzabC;
    private final String zzabD;
    private final Map<String, PlayerInfo> zzabF;
    private final String zzabt;
    private final int zzabu;
    private final int zzabz;

    public zzlk(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzabA = i;
        this.zzabz = i2;
        this.zzabD = str;
        this.zzabC = jSONObject;
        this.zzabt = str2;
        this.zzabu = i3;
        this.zzabF = new HashMap(collection.size());
        for (PlayerInfo playerInfo : collection) {
            this.zzabF.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public boolean equals(Object otherObj) {
        boolean z = true;
        if (otherObj == null || !(otherObj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) otherObj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z2 = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                boolean z3;
                if (!zzf.zza(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    z3 = z2;
                } else if (!zzf.zza(playerInfo, playerInfo2)) {
                    return false;
                } else {
                    z3 = true;
                }
                z2 = z3;
            }
            if (!z2) {
                return false;
            }
        }
        if (!(this.zzabA == gameManagerState.getLobbyState() && this.zzabz == gameManagerState.getGameplayState() && this.zzabu == gameManagerState.getMaxPlayers() && zzf.zza(this.zzabt, gameManagerState.getApplicationName()) && zzf.zza(this.zzabD, gameManagerState.getGameStatusText()) && zznu.zze(this.zzabC, gameManagerState.getGameData()))) {
            z = false;
        }
        return z;
    }

    public CharSequence getApplicationName() {
        return this.zzabt;
    }

    public List<PlayerInfo> getConnectedControllablePlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getConnectedPlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getControllablePlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public JSONObject getGameData() {
        return this.zzabC;
    }

    public CharSequence getGameStatusText() {
        return this.zzabD;
    }

    public int getGameplayState() {
        return this.zzabz;
    }

    public Collection<String> getListOfChangedPlayers(GameManagerState other) {
        Collection hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = other.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : other.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    public int getLobbyState() {
        return this.zzabA;
    }

    public int getMaxPlayers() {
        return this.zzabu;
    }

    public PlayerInfo getPlayer(String playerId) {
        return playerId == null ? null : (PlayerInfo) this.zzabF.get(playerId);
    }

    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzabF.values());
    }

    public List<PlayerInfo> getPlayersInState(int playerState) {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == playerState) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public boolean hasGameDataChanged(GameManagerState other) {
        return !zznu.zze(this.zzabC, other.getGameData());
    }

    public boolean hasGameStatusTextChanged(GameManagerState other) {
        return !zzf.zza(this.zzabD, other.getGameStatusText());
    }

    public boolean hasGameplayStateChanged(GameManagerState other) {
        return this.zzabz != other.getGameplayState();
    }

    public boolean hasLobbyStateChanged(GameManagerState other) {
        return this.zzabA != other.getLobbyState();
    }

    public boolean hasPlayerChanged(String playerId, GameManagerState other) {
        return !zzf.zza(getPlayer(playerId), other.getPlayer(playerId));
    }

    public boolean hasPlayerDataChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || !zznu.zze(player.getPlayerData(), player2.getPlayerData());
    }

    public boolean hasPlayerStateChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzabA), Integer.valueOf(this.zzabz), this.zzabF, this.zzabD, this.zzabC, this.zzabt, Integer.valueOf(this.zzabu));
    }
}
