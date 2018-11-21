package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzs implements Creator<SensorRegistrationRequest> {
    static void zza(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sensorRegistrationRequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, sensorRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sensorRegistrationRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, sensorRegistrationRequest.zzuz(), false);
        zzb.zzc(parcel, 4, sensorRegistrationRequest.zzayO);
        zzb.zzc(parcel, 5, sensorRegistrationRequest.zzayP);
        zzb.zza(parcel, 6, sensorRegistrationRequest.zztU());
        zzb.zza(parcel, 7, sensorRegistrationRequest.zzuw());
        zzb.zza(parcel, 8, sensorRegistrationRequest.zzuu(), i, false);
        zzb.zza(parcel, 9, sensorRegistrationRequest.zzuv());
        zzb.zzc(parcel, 10, sensorRegistrationRequest.getAccuracyMode());
        zzb.zzc(parcel, 11, sensorRegistrationRequest.zzux(), false);
        zzb.zza(parcel, 12, sensorRegistrationRequest.zzuy());
        zzb.zza(parcel, 13, sensorRegistrationRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzds(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfs(x0);
    }

    public SensorRegistrationRequest zzds(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzat, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 10:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 11:
                    list = zza.zzc(parcel, zzat, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = zza.zzi(parcel, zzat);
                    break;
                case 13:
                    iBinder2 = zza.zzq(parcel, zzat);
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
            return new SensorRegistrationRequest(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4, iBinder2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SensorRegistrationRequest[] zzfs(int i) {
        return new SensorRegistrationRequest[i];
    }
}
