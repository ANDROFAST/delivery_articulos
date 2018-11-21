package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
    public static final Creator<PendingCallback> CREATOR = new C02541();
    final IBinder zzaiT;

    static class C02541 implements Creator<PendingCallback> {
        C02541() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzeA(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzgX(x0);
        }

        public PendingCallback zzeA(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public PendingCallback[] zzgX(int i) {
            return new PendingCallback[i];
        }
    }

    public PendingCallback(Parcel in) {
        this.zzaiT = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.zzaiT;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzaiT);
    }
}
