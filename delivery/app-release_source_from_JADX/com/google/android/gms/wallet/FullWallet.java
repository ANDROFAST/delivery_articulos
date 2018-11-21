package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new zze();
    private final int mVersionCode;
    String zzbjg;
    String zzbjh;
    ProxyCard zzbji;
    String zzbjj;
    Address zzbjk;
    Address zzbjl;
    String[] zzbjm;
    UserAddress zzbjn;
    UserAddress zzbjo;
    InstrumentInfo[] zzbjp;
    PaymentMethodToken zzbjq;

    private FullWallet() {
        this.mVersionCode = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos, PaymentMethodToken paymentMethodToken) {
        this.mVersionCode = versionCode;
        this.zzbjg = googleTransactionId;
        this.zzbjh = merchantTransactionId;
        this.zzbji = proxyCard;
        this.zzbjj = email;
        this.zzbjk = billingAddress;
        this.zzbjl = shippingAddress;
        this.zzbjm = paymentDescriptions;
        this.zzbjn = buyerBillingAddress;
        this.zzbjo = buyerShippingAddress;
        this.zzbjp = instrumentInfos;
        this.zzbjq = paymentMethodToken;
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

    public PaymentMethodToken getPaymentMethodToken() {
        return this.zzbjq;
    }

    public ProxyCard getProxyCard() {
        return this.zzbji;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzbjl;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
