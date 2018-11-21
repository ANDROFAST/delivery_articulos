package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class PaymentMethodTokenizationParameters implements SafeParcelable {
    public static final Creator<PaymentMethodTokenizationParameters> CREATOR = new zzp();
    private final int mVersionCode;
    int zzbkt;
    Bundle zzbku;

    public final class Builder {
        final /* synthetic */ PaymentMethodTokenizationParameters zzbkv;

        private Builder(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            this.zzbkv = paymentMethodTokenizationParameters;
        }

        public Builder addParameter(String name, String value) {
            zzx.zzh(name, "Tokenization parameter name must not be empty");
            zzx.zzh(value, "Tokenization parameter value must not be empty");
            this.zzbkv.zzbku.putString(name, value);
            return this;
        }

        public PaymentMethodTokenizationParameters build() {
            return this.zzbkv;
        }

        public Builder setPaymentMethodTokenizationType(int tokenizationType) {
            this.zzbkv.zzbkt = tokenizationType;
            return this;
        }
    }

    private PaymentMethodTokenizationParameters() {
        this.zzbku = new Bundle();
        this.mVersionCode = 1;
    }

    PaymentMethodTokenizationParameters(int versionCode, int tokenizationType, Bundle parameters) {
        this.zzbku = new Bundle();
        this.mVersionCode = versionCode;
        this.zzbkt = tokenizationType;
        this.zzbku = parameters;
    }

    public static Builder newBuilder() {
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = new PaymentMethodTokenizationParameters();
        paymentMethodTokenizationParameters.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getParameters() {
        return new Bundle(this.zzbku);
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzbkt;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzp.zza(this, out, flags);
    }
}
