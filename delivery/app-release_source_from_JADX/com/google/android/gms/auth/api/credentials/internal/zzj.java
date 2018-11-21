package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<SaveRequest> {
    static void zza(SaveRequest saveRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, saveRequest.getCredential(), i, false);
        zzb.zzc(parcel, 1000, saveRequest.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaG(x0);
    }

    public SaveRequest zzL(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Credential credential = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    credential = (Credential) zza.zza(parcel, zzat, Credential.CREATOR);
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
            return new SaveRequest(i, credential);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SaveRequest[] zzaG(int i) {
        return new SaveRequest[i];
    }
}
