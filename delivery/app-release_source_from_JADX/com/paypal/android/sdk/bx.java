package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bx implements Creator {
    bx() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new bw(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new bw[i];
    }
}
