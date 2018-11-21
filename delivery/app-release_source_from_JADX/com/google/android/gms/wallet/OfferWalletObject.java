package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new zzn();
    private final int mVersionCode;
    CommonWalletObject zzbjt;
    String zzbks;
    String zzif;

    OfferWalletObject() {
        this.mVersionCode = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.mVersionCode = versionCode;
        this.zzbks = redemptionCode;
        if (versionCode < 3) {
            this.zzbjt = CommonWalletObject.zzGu().zzfW(id).zzGv();
        } else {
            this.zzbjt = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzbjt.getId();
    }

    public String getRedemptionCode() {
        return this.zzbks;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
