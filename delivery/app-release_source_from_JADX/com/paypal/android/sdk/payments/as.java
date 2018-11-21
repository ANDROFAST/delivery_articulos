package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class as implements Creator {
    as() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalItem[i];
    }
}
