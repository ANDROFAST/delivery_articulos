package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<LocationRequestUpdateData> {
    static void zza(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, locationRequestUpdateData.zzaMg);
        zzb.zzc(parcel, 1000, locationRequestUpdateData.getVersionCode());
        zzb.zza(parcel, 2, locationRequestUpdateData.zzaMh, i, false);
        zzb.zza(parcel, 3, locationRequestUpdateData.zzye(), false);
        zzb.zza(parcel, 4, locationRequestUpdateData.mPendingIntent, i, false);
        zzb.zza(parcel, 5, locationRequestUpdateData.zzyf(), false);
        zzb.zza(parcel, 6, locationRequestUpdateData.zzyg(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhv(x0);
    }

    public LocationRequestUpdateData zzeP(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) zza.zza(parcel, zzat, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder3 = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 6:
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
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder3, pendingIntent, iBinder2, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LocationRequestUpdateData[] zzhv(int i) {
        return new LocationRequestUpdateData[i];
    }
}
