package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzbq implements Creator<SetDrivePreferencesRequest> {
    static void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, setDrivePreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, setDrivePreferencesRequest.zzaqi, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdK(x0);
    }

    public SetDrivePreferencesRequest zzbP(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DrivePreferences drivePreferences = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    drivePreferences = (DrivePreferences) zza.zza(parcel, zzat, DrivePreferences.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SetDrivePreferencesRequest(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SetDrivePreferencesRequest[] zzdK(int i) {
        return new SetDrivePreferencesRequest[i];
    }
}
