package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class al implements Creator {
    al() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayPalAuthorization(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayPalAuthorization[i];
    }
}
