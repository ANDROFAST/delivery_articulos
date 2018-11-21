package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sessionDataSet.getSession(), i, false);
        zzb.zzc(parcel, 1000, sessionDataSet.mVersionCode);
        zzb.zza(parcel, 2, sessionDataSet.zztT(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeX(x0);
    }

    public SessionDataSet zzcX(Parcel parcel) {
        DataSet dataSet = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    Session session3 = (Session) zza.zza(parcel, zzat, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case 2:
                    dataSet2 = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzat);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzau) {
            return new SessionDataSet(i, session, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SessionDataSet[] zzeX(int i) {
        return new SessionDataSet[i];
    }
}
