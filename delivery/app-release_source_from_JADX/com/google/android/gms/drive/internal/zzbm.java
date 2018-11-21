package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbm implements Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzank, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzanl, false);
        zzb.zza(parcel, 4, openFileIntentSenderRequest.zzann, i, false);
        zzb.zza(parcel, 5, openFileIntentSenderRequest.zzaqv, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdG(x0);
    }

    public OpenFileIntentSenderRequest zzbL(Parcel parcel) {
        FilterHolder filterHolder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        String[] strArr = null;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 5:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzat, FilterHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OpenFileIntentSenderRequest[] zzdG(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
