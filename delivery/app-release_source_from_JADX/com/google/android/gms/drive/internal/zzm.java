package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm implements Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, createFileIntentSenderRequest.zzaot, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzamD);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzank, false);
        zzb.zza(parcel, 5, createFileIntentSenderRequest.zzann, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzaou, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcX(x0);
    }

    public CreateFileIntentSenderRequest zzbg(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 6:
                    num = zza.zzh(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CreateFileIntentSenderRequest[] zzcX(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
