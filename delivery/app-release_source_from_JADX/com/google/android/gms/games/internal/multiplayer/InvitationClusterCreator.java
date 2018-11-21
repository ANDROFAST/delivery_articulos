package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    static void zza(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, zInvitationCluster.zzwL(), false);
        zzb.zzc(parcel, 1000, zInvitationCluster.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgu(x0);
    }

    public ZInvitationCluster zzeg(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    arrayList = zza.zzc(parcel, zzat, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ZInvitationCluster[] zzgu(int i) {
        return new ZInvitationCluster[i];
    }
}
