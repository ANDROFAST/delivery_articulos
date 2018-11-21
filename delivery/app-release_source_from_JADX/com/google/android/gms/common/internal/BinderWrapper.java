package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C02201();
    private IBinder zzaiT;

    static class C02201 implements Creator<BinderWrapper> {
        C02201() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzan(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzbR(x0);
        }

        public BinderWrapper zzan(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public BinderWrapper[] zzbR(int i) {
            return new BinderWrapper[i];
        }
    }

    public BinderWrapper() {
        this.zzaiT = null;
    }

    public BinderWrapper(IBinder binder) {
        this.zzaiT = null;
        this.zzaiT = binder;
    }

    private BinderWrapper(Parcel in) {
        this.zzaiT = null;
        this.zzaiT = in.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStrongBinder(this.zzaiT);
    }
}
