package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PlayerStatsEntityCreator implements Creator<PlayerStatsEntity> {
    static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, playerStatsEntity.getAverageSessionLength());
        zzb.zzc(parcel, 1000, playerStatsEntity.getVersionCode());
        zzb.zza(parcel, 2, playerStatsEntity.getChurnProbability());
        zzb.zzc(parcel, 3, playerStatsEntity.getDaysSinceLastPlayed());
        zzb.zzc(parcel, 4, playerStatsEntity.getNumberOfPurchases());
        zzb.zzc(parcel, 5, playerStatsEntity.getNumberOfSessions());
        zzb.zza(parcel, 6, playerStatsEntity.getSessionPercentile());
        zzb.zza(parcel, 7, playerStatsEntity.getSpendPercentile());
        zzb.zza(parcel, 8, playerStatsEntity.zzxo(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzew(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgO(x0);
    }

    public PlayerStatsEntity zzew(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    f4 = zza.zzl(parcel, zzat);
                    break;
                case 2:
                    f3 = zza.zzl(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    f2 = zza.zzl(parcel, zzat);
                    break;
                case 7:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 8:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlayerStatsEntity(i4, f4, f3, i3, i2, i, f2, f, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayerStatsEntity[] zzgO(int i) {
        return new PlayerStatsEntity[i];
    }
}
