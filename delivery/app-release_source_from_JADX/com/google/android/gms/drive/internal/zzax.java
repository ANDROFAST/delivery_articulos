package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzax implements Creator<OnDeviceUsagePreferenceResponse> {
    static void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onDeviceUsagePreferenceResponse.mVersionCode);
        zzb.zza(parcel, 2, onDeviceUsagePreferenceResponse.zzaqd, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzds(x0);
    }

    public OnDeviceUsagePreferenceResponse zzbx(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    fileUploadPreferencesImpl = (FileUploadPreferencesImpl) zza.zza(parcel, zzat, FileUploadPreferencesImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnDeviceUsagePreferenceResponse(i, fileUploadPreferencesImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnDeviceUsagePreferenceResponse[] zzds(int i) {
        return new OnDeviceUsagePreferenceResponse[i];
    }
}
