package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.List;

public class zzj implements Creator<SessionReadResult> {
    static void zza(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, sessionReadResult.getSessions(), false);
        zzb.zzc(parcel, 1000, sessionReadResult.getVersionCode());
        zzb.zzc(parcel, 2, sessionReadResult.zzuN(), false);
        zzb.zza(parcel, 3, sessionReadResult.getStatus(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfP(x0);
    }

    public SessionReadResult zzdO(Parcel parcel) {
        Status status = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    list2 = zza.zzc(parcel, zzat, Session.CREATOR);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, SessionDataSet.CREATOR);
                    break;
                case 3:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SessionReadResult[] zzfP(int i) {
        return new SessionReadResult[i];
    }
}
