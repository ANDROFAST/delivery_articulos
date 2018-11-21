package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
    public static final Creator<GiftCardWalletObject> CREATOR = new zzg();
    final int mVersionCode;
    String pin;
    CommonWalletObject zzbjt;
    String zzbju;
    String zzbjv;
    long zzbjw;
    String zzbjx;
    long zzbjy;
    String zzbjz;

    GiftCardWalletObject() {
        this.zzbjt = CommonWalletObject.zzGu().zzGv();
        this.mVersionCode = 1;
    }

    GiftCardWalletObject(int versionCode, CommonWalletObject commonWalletObject, String cardNumber, String pin, String cardIdentifier, long balanceMicros, String balanceCurrencyCode, long balanceUpdateTime, String eventNumber) {
        this.zzbjt = CommonWalletObject.zzGu().zzGv();
        this.mVersionCode = versionCode;
        this.zzbjt = commonWalletObject;
        this.zzbju = cardNumber;
        this.pin = pin;
        this.zzbjw = balanceMicros;
        this.zzbjx = balanceCurrencyCode;
        this.zzbjy = balanceUpdateTime;
        this.zzbjz = eventNumber;
        this.zzbjv = cardIdentifier;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzbjt.getId();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
