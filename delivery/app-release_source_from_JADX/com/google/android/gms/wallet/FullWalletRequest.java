package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new zzf();
    private final int mVersionCode;
    String zzbjg;
    String zzbjh;
    Cart zzbjr;

    public final class Builder {
        final /* synthetic */ FullWalletRequest zzbjs;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.zzbjs = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.zzbjs;
        }

        public Builder setCart(Cart cart) {
            this.zzbjs.zzbjr = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzbjs.zzbjg = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzbjs.zzbjh = merchantTransactionId;
            return this;
        }
    }

    FullWalletRequest() {
        this.mVersionCode = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.mVersionCode = versionCode;
        this.zzbjg = googleTransactionId;
        this.zzbjh = merchantTransactionId;
        this.zzbjr = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzbjr;
    }

    public String getGoogleTransactionId() {
        return this.zzbjg;
    }

    public String getMerchantTransactionId() {
        return this.zzbjh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
