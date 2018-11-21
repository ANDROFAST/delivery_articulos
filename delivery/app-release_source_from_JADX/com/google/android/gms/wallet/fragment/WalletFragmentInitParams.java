package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int mVersionCode;
    private String zzTD;
    private MaskedWalletRequest zzbkT;
    private MaskedWallet zzbkU;
    private int zzblh;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams zzbli;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.zzbli = walletFragmentInitParams;
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.zzbli.zzbkU != null && this.zzbli.zzbkT == null) || (this.zzbli.zzbkU == null && this.zzbli.zzbkT != null);
            zzx.zza(z2, (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.zzbli.zzblh < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return this.zzbli;
        }

        public Builder setAccountName(String accountName) {
            this.zzbli.zzTD = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.zzbli.zzbkU = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            this.zzbli.zzbkT = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            this.zzbli.zzblh = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzblh = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.mVersionCode = versionCode;
        this.zzTD = accountName;
        this.zzbkT = maskedWalletRequest;
        this.zzblh = maskedWalletRequestCode;
        this.zzbkU = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzTD;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzbkU;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzbkT;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzblh;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
