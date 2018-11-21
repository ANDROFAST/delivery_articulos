package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzp implements Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, subscribeRequest.mVersionCode);
        zzb.zza(parcel, 2, subscribeRequest.zzCM(), false);
        zzb.zza(parcel, 3, subscribeRequest.zzaXG, i, false);
        zzb.zza(parcel, 4, subscribeRequest.zzCJ(), false);
        zzb.zza(parcel, 5, subscribeRequest.zzaXM, i, false);
        zzb.zza(parcel, 6, subscribeRequest.zzaXN, i, false);
        zzb.zzc(parcel, 7, subscribeRequest.zzaXO);
        zzb.zza(parcel, 8, subscribeRequest.zzaWI, false);
        zzb.zza(parcel, 9, subscribeRequest.zzaXH, false);
        zzb.zza(parcel, 10, subscribeRequest.zzaXP, false);
        zzb.zza(parcel, 11, subscribeRequest.zzaWJ);
        zzb.zza(parcel, 12, subscribeRequest.zzCN(), false);
        zzb.zza(parcel, 13, subscribeRequest.zzaWK);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzje(x0);
    }

    public SubscribeRequest zzgc(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        boolean z = false;
        IBinder iBinder3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    strategy = (Strategy) zza.zza(parcel, zzat, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 5:
                    messageFilter = (MessageFilter) zza.zza(parcel, zzat, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 11:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 12:
                    iBinder3 = zza.zzq(parcel, zzat);
                    break;
                case 13:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SubscribeRequest(i, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i2, str, str2, bArr, z, iBinder3, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SubscribeRequest[] zzje(int i) {
        return new SubscribeRequest[i];
    }
}
