package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<MessageType> {
    static void zza(MessageType messageType, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, messageType.zzakM, false);
        zzb.zzc(parcel, 1000, messageType.mVersionCode);
        zzb.zza(parcel, 2, messageType.type, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzja(x0);
    }

    public MessageType zzfY(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
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
            return new MessageType(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MessageType[] zzja(int i) {
        return new MessageType[i];
    }
}
