package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bz implements Creator {
    bz() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ProofOfPayment(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ProofOfPayment[i];
    }
}
