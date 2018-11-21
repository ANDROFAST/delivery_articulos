package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
    private final PlayerColumnNames zzaAC;
    private final MostRecentGameInfoRef zzaAD;
    private final PlayerLevelInfo zzaAn;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.zzaAC = new PlayerColumnNames(prefix);
        this.zzaAD = new MostRecentGameInfoRef(holder, dataRow, this.zzaAC);
        if (zzvd()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzaAC.zzaFS);
            int integer2 = getInteger(this.zzaAC.zzaFV);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzaAC.zzaFT), getLong(this.zzaAC.zzaFU));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzaAC.zzaFU), getLong(this.zzaAC.zzaFW));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzaAn = new PlayerLevelInfo(getLong(this.zzaAC.zzaFR), getLong(this.zzaAC.zzaFX), playerLevel2, playerLevel);
            return;
        }
        this.zzaAn = null;
    }

    private boolean zzvd() {
        return (zzcv(this.zzaAC.zzaFR) || getLong(this.zzaAC.zzaFR) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public Uri getBannerImageLandscapeUri() {
        return zzcu(this.zzaAC.zzaGi);
    }

    public String getBannerImageLandscapeUrl() {
        return getString(this.zzaAC.zzaGj);
    }

    public Uri getBannerImagePortraitUri() {
        return zzcu(this.zzaAC.zzaGk);
    }

    public String getBannerImagePortraitUrl() {
        return getString(this.zzaAC.zzaGl);
    }

    public String getDisplayName() {
        return getString(this.zzaAC.zzaFJ);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zza(this.zzaAC.zzaFJ, dataOut);
    }

    public Uri getHiResImageUri() {
        return zzcu(this.zzaAC.zzaFM);
    }

    public String getHiResImageUrl() {
        return getString(this.zzaAC.zzaFN);
    }

    public Uri getIconImageUri() {
        return zzcu(this.zzaAC.zzaFK);
    }

    public String getIconImageUrl() {
        return getString(this.zzaAC.zzaFL);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzct(this.zzaAC.zzaFQ) || zzcv(this.zzaAC.zzaFQ)) ? -1 : getLong(this.zzaAC.zzaFQ);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaAn;
    }

    public String getName() {
        return getString(this.zzaAC.name);
    }

    public String getPlayerId() {
        return getString(this.zzaAC.zzaFI);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzaAC.zzaFO);
    }

    public String getTitle() {
        return getString(this.zzaAC.title);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zza(this.zzaAC.title, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public String toString() {
        return PlayerEntity.zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }

    public String zzuY() {
        return getString(this.zzaAC.zzaGh);
    }

    public boolean zzuZ() {
        return getBoolean(this.zzaAC.zzaGg);
    }

    public int zzva() {
        return getInteger(this.zzaAC.zzaFP);
    }

    public boolean zzvb() {
        return getBoolean(this.zzaAC.zzaFZ);
    }

    public MostRecentGameInfo zzvc() {
        return zzcv(this.zzaAC.zzaGa) ? null : this.zzaAD;
    }
}
