package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class zza implements Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, addEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, addEventListenerRequest.zzamF, i, false);
        zzb.zzc(parcel, 3, addEventListenerRequest.zzalo);
        zzb.zza(parcel, 4, addEventListenerRequest.zzanC, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcM(x0);
    }

    public AddEventListenerRequest zzaW(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int i3;
            DriveId driveId2;
            int zzg;
            ChangesAvailableOptions changesAvailableOptions2;
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            ChangesAvailableOptions changesAvailableOptions3;
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    changesAvailableOptions3 = changesAvailableOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    changesAvailableOptions2 = changesAvailableOptions3;
                    break;
                case 2:
                    zzg = i2;
                    int i4 = i;
                    driveId2 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, DriveId.CREATOR);
                    changesAvailableOptions2 = changesAvailableOptions;
                    i3 = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i2;
                    changesAvailableOptions3 = changesAvailableOptions;
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    changesAvailableOptions2 = changesAvailableOptions3;
                    break;
                case 4:
                    changesAvailableOptions2 = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ChangesAvailableOptions.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    changesAvailableOptions2 = changesAvailableOptions;
                    i3 = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = i3;
            changesAvailableOptions = changesAvailableOptions2;
        }
        if (parcel.dataPosition() == zzau) {
            return new AddEventListenerRequest(i2, driveId, i, changesAvailableOptions);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AddEventListenerRequest[] zzcM(int i) {
        return new AddEventListenerRequest[i];
    }
}
