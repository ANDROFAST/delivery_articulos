package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bW implements Creator {
    bW() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new bV(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new bV[i];
    }
}
