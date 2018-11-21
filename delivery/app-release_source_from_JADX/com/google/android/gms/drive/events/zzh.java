package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzh implements Creator<ProgressEvent> {
    static void zza(ProgressEvent progressEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, progressEvent.mVersionCode);
        zzb.zza(parcel, 2, progressEvent.zzamF, i, false);
        zzb.zzc(parcel, 3, progressEvent.zzAk);
        zzb.zza(parcel, 4, progressEvent.zzanU);
        zzb.zza(parcel, 5, progressEvent.zzanV);
        zzb.zzc(parcel, 6, progressEvent.zzZU);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcJ(x0);
    }

    public ProgressEvent zzaU(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ProgressEvent(i3, driveId, i2, j2, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ProgressEvent[] zzcJ(int i) {
        return new ProgressEvent[i];
    }
}
