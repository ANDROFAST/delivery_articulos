package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken implements SafeParcelable {
    public static final Creator<PaymentMethodToken> CREATOR = new zzo();
    private final int mVersionCode;
    String zzaVZ;
    int zzbkt;

    private PaymentMethodToken() {
        this.mVersionCode = 1;
    }

    PaymentMethodToken(int versionCode, int tokenizationType, String token) {
        this.mVersionCode = versionCode;
        this.zzbkt = tokenizationType;
        this.zzaVZ = token;
    }

    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzbkt;
    }

    public String getToken() {
        return this.zzaVZ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }
}
