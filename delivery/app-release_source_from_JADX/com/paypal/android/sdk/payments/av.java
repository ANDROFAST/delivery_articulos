package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class av implements Creator {
    av() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalPaymentDetails(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalPaymentDetails[i];
    }
}
