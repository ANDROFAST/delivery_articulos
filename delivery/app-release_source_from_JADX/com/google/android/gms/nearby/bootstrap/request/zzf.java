package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzf implements Creator<SendDataRequest> {
    static void zza(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sendDataRequest.zzCm(), i, false);
        zzb.zzc(parcel, 1000, sendDataRequest.versionCode);
        zzb.zza(parcel, 2, sendDataRequest.getData(), false);
        zzb.zza(parcel, 3, sendDataRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziF(x0);
    }

    public SendDataRequest zzfM(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
        Device device = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            Device device2;
            IBinder iBinder2;
            byte[] bArr2;
            int zzat = zza.zzat(parcel);
            IBinder iBinder3;
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    byte[] bArr3 = bArr;
                    device2 = (Device) zza.zza(parcel, zzat, Device.CREATOR);
                    iBinder2 = iBinder;
                    bArr2 = bArr3;
                    break;
                case 2:
                    device2 = device;
                    i2 = i;
                    iBinder3 = iBinder;
                    bArr2 = zza.zzs(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = zza.zzq(parcel, zzat);
                    bArr2 = bArr;
                    device2 = device;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    bArr2 = bArr;
                    device2 = device;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder2 = iBinder;
                    bArr2 = bArr;
                    device2 = device;
                    i2 = i;
                    break;
            }
            i = i2;
            device = device2;
            bArr = bArr2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new SendDataRequest(i, device, bArr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SendDataRequest[] zziF(int i) {
        return new SendDataRequest[i];
    }
}
