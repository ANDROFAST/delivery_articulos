package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<LogEvent> {
    static void zza(LogEvent logEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, logEvent.versionCode);
        zzb.zza(parcel, 2, logEvent.zzaYn);
        zzb.zza(parcel, 3, logEvent.tag, false);
        zzb.zza(parcel, 4, logEvent.zzaYp, false);
        zzb.zza(parcel, 5, logEvent.zzaYq, false);
        zzb.zza(parcel, 6, logEvent.zzaYo);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjp(x0);
    }

    public LogEvent zzgn(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 5:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LogEvent(i, j2, j, str, bArr, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LogEvent[] zzjp(int i) {
        return new LogEvent[i];
    }
}