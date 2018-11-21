package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void zza(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, gameRequestCluster.zzwY(), false);
        zzb.zzc(parcel, 1000, gameRequestCluster.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzei(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgx(x0);
    }

    public GameRequestCluster zzei(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzat, GameRequestEntity.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GameRequestCluster(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GameRequestCluster[] zzgx(int i) {
        return new GameRequestCluster[i];
    }
}
