package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Creator<SensorUnregistrationRequest> {
    static void zza(SensorUnregistrationRequest sensorUnregistrationRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sensorUnregistrationRequest.zzuz(), false);
        zzb.zzc(parcel, 1000, sensorUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sensorUnregistrationRequest.zzuu(), i, false);
        zzb.zza(parcel, 3, sensorUnregistrationRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfu(x0);
    }

    public SensorUnregistrationRequest zzdt(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            IBinder zzq;
            IBinder iBinder3;
            PendingIntent pendingIntent2;
            int zzat = zza.zzat(parcel);
            IBinder iBinder4;
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    PendingIntent pendingIntent3 = pendingIntent;
                    zzq = zza.zzq(parcel, zzat);
                    iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    zzq = iBinder2;
                    i2 = i;
                    iBinder4 = iBinder;
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
                    iBinder3 = iBinder4;
                    break;
                case 3:
                    iBinder3 = zza.zzq(parcel, zzat);
                    pendingIntent2 = pendingIntent;
                    zzq = iBinder2;
                    i2 = i;
                    break;
                case 1000:
                    iBinder4 = iBinder;
                    pendingIntent2 = pendingIntent;
                    zzq = iBinder2;
                    i2 = zza.zzg(parcel, zzat);
                    iBinder3 = iBinder4;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    iBinder3 = iBinder;
                    pendingIntent2 = pendingIntent;
                    zzq = iBinder2;
                    i2 = i;
                    break;
            }
            i = i2;
            iBinder2 = zzq;
            pendingIntent = pendingIntent2;
            iBinder = iBinder3;
        }
        if (parcel.dataPosition() == zzau) {
            return new SensorUnregistrationRequest(i, iBinder2, pendingIntent, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SensorUnregistrationRequest[] zzfu(int i) {
        return new SensorUnregistrationRequest[i];
    }
}
