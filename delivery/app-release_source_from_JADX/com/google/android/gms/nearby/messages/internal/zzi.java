package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Message;

public class zzi implements Creator<MessageWrapper> {
    static void zza(MessageWrapper messageWrapper, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, messageWrapper.zzaXn, i, false);
        zzb.zzc(parcel, 1000, messageWrapper.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjb(x0);
    }

    public MessageWrapper zzfZ(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Message message = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    message = (Message) zza.zza(parcel, zzat, Message.CREATOR);
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
            return new MessageWrapper(i, message);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MessageWrapper[] zzjb(int i) {
        return new MessageWrapper[i];
    }
}
