package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.paypal.android.sdk.C0494N;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class PayPalOAuthScopes implements Parcelable {
    public static final Creator CREATOR = new at();
    public static final String PAYPAL_SCOPE_ADDRESS = C0494N.ADDRESS.m16a();
    public static final String PAYPAL_SCOPE_EMAIL = C0494N.EMAIL.m16a();
    public static final String PAYPAL_SCOPE_FUTURE_PAYMENTS = C0494N.FUTURE_PAYMENTS.m16a();
    public static final String PAYPAL_SCOPE_OPENID = C0494N.OPENID.m16a();
    public static final String PAYPAL_SCOPE_PAYPAL_ATTRIBUTES = C0494N.PAYPAL_ATTRIBUTES.m16a();
    public static final String PAYPAL_SCOPE_PHONE = C0494N.PHONE.m16a();
    public static final String PAYPAL_SCOPE_PROFILE = C0494N.PROFILE.m16a();
    private List f785a;

    public PayPalOAuthScopes() {
        this.f785a = new ArrayList();
    }

    private PayPalOAuthScopes(Parcel parcel) {
        this.f785a = new ArrayList();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f785a.add(parcel.readString());
        }
    }

    public PayPalOAuthScopes(Set set) {
        this();
        for (String add : set) {
            this.f785a.add(add);
        }
    }

    final List m564a() {
        return this.f785a;
    }

    final String m565b() {
        return TextUtils.join(" ", this.f785a);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return String.format(PayPalOAuthScopes.class.getSimpleName() + ": {%s}", new Object[]{this.f785a});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f785a.size());
        for (int i2 = 0; i2 < this.f785a.size(); i2++) {
            parcel.writeString((String) this.f785a.get(i2));
        }
    }
}
