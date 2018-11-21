package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new zzk();
    private final int mVersionCode;
    LoyaltyWalletObject[] zzbjZ;
    String zzbjg;
    String zzbjh;
    String zzbjj;
    Address zzbjk;
    Address zzbjl;
    String[] zzbjm;
    UserAddress zzbjn;
    UserAddress zzbjo;
    InstrumentInfo[] zzbjp;
    OfferWalletObject[] zzbka;

    public final class Builder {
        final /* synthetic */ MaskedWallet zzbkb;

        private Builder(MaskedWallet maskedWallet) {
            this.zzbkb = maskedWallet;
        }

        public MaskedWallet build() {
            return this.zzbkb;
        }

        public Builder setBillingAddress(Address billingAddress) {
            this.zzbkb.zzbjk = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            this.zzbkb.zzbjn = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            this.zzbkb.zzbjo = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            this.zzbkb.zzbjj = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzbkb.zzbjg = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            this.zzbkb.zzbjp = instrumentInfos;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzbkb.zzbjh = merchantTransactionId;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            this.zzbkb.zzbjm = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            this.zzbkb.zzbjl = shippingAddress;
            return this;
        }

        @Deprecated
        public Builder zza(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            this.zzbkb.zzbjZ = loyaltyWalletObjectArr;
            return this;
        }

        @Deprecated
        public Builder zza(OfferWalletObject[] offerWalletObjectArr) {
            this.zzbkb.zzbka = offerWalletObjectArr;
            return this;
        }
    }

    private MaskedWallet() {
        this.mVersionCode = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.mVersionCode = versionCode;
        this.zzbjg = googleTransactionId;
        this.zzbjh = merchantTransactionId;
        this.zzbjm = paymentDescriptions;
        this.zzbjj = email;
        this.zzbjk = billingAddress;
        this.zzbjl = shippingAddress;
        this.zzbjZ = loyaltyWalletObjects;
        this.zzbka = offerWalletObjects;
        this.zzbjn = buyerBillingAddress;
        this.zzbjo = buyerShippingAddress;
        this.zzbjp = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzx.zzy(maskedWallet);
        return zzGo().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).zza(maskedWallet.zzGp()).zza(maskedWallet.zzGq()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzGo() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzbjk;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzbjn;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzbjo;
    }

    public String getEmail() {
        return this.zzbjj;
    }

    public String getGoogleTransactionId() {
        return this.zzbjg;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzbjp;
    }

    public String getMerchantTransactionId() {
        return this.zzbjh;
    }

    public String[] getPaymentDescriptions() {
        return this.zzbjm;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzbjl;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    @Deprecated
    public LoyaltyWalletObject[] zzGp() {
        return this.zzbjZ;
    }

    @Deprecated
    public OfferWalletObject[] zzGq() {
        return this.zzbka;
    }
}
