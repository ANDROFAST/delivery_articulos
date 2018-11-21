package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<ConnectionEvent> {
    static void zza(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, connectionEvent.mVersionCode);
        zzb.zza(parcel, 2, connectionEvent.getTimeMillis());
        zzb.zza(parcel, 4, connectionEvent.zzrp(), false);
        zzb.zza(parcel, 5, connectionEvent.zzrq(), false);
        zzb.zza(parcel, 6, connectionEvent.zzrr(), false);
        zzb.zza(parcel, 7, connectionEvent.zzrs(), false);
        zzb.zza(parcel, 8, connectionEvent.zzrt(), false);
        zzb.zza(parcel, 10, connectionEvent.zzrx());
        zzb.zza(parcel, 11, connectionEvent.zzrw());
        zzb.zzc(parcel, 12, connectionEvent.getEventType());
        zzb.zza(parcel, 13, connectionEvent.zzru(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcn(x0);
    }

    public ConnectionEvent zzaF(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ConnectionEvent[] zzcn(int i) {
        return new ConnectionEvent[i];
    }
}
