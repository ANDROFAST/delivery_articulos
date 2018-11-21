package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzv implements Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        zzb.zzc(parcel, 1000, sessionReadRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        zzb.zza(parcel, 3, sessionReadRequest.zzlx());
        zzb.zza(parcel, 4, sessionReadRequest.zztB());
        zzb.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        zzb.zza(parcel, 7, sessionReadRequest.zzuC());
        zzb.zza(parcel, 8, sessionReadRequest.zzun());
        zzb.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        zzb.zza(parcel, 10, sessionReadRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfw(x0);
    }

    public SessionReadRequest zzdv(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        long j = 0;
        long j2 = 0;
        List list = null;
        List list2 = null;
        boolean z = false;
        boolean z2 = false;
        List list3 = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case 6:
                    list2 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 9:
                    list3 = zza.zzD(parcel, zzat);
                    break;
                case 10:
                    iBinder = zza.zzq(parcel, zzat);
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
            return new SessionReadRequest(i, str, str2, j, j2, list, list2, z, z2, list3, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SessionReadRequest[] zzfw(int i) {
        return new SessionReadRequest[i];
    }
}
