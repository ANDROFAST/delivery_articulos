package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzba implements Creator<OnDrivePreferencesResponse> {
    static void zza(OnDrivePreferencesResponse onDrivePreferencesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onDrivePreferencesResponse.mVersionCode);
        zzb.zza(parcel, 2, onDrivePreferencesResponse.zzaqi, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdv(x0);
    }

    public OnDrivePreferencesResponse zzbA(Parcel parcel) {
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
            return new OnDrivePreferencesResponse(i, drivePreferences);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnDrivePreferencesResponse[] zzdv(int i) {
        return new OnDrivePreferencesResponse[i];
    }
}
