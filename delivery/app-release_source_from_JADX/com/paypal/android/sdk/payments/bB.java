package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bB implements Creator {
    bB() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new bA(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new bA[i];
    }
}
