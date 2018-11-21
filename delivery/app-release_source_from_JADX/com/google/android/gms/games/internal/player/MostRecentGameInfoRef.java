package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzaAC;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.zzaAC = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwX();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) zzwX()).writeToParcel(dest, flags);
    }

    public String zzwR() {
        return getString(this.zzaAC.zzaGa);
    }

    public String zzwS() {
        return getString(this.zzaAC.zzaGb);
    }

    public long zzwT() {
        return getLong(this.zzaAC.zzaGc);
    }

    public Uri zzwU() {
        return zzcu(this.zzaAC.zzaGd);
    }

    public Uri zzwV() {
        return zzcu(this.zzaAC.zzaGe);
    }

    public Uri zzwW() {
        return zzcu(this.zzaAC.zzaGf);
    }

    public MostRecentGameInfo zzwX() {
        return new MostRecentGameInfoEntity(this);
    }
}
