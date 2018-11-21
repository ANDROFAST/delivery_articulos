package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Creator<LoyaltyPointsBalance> CREATOR = new zzd();
    private final int mVersionCode;
    String zzbjx;
    int zzblA;
    String zzblB;
    double zzblC;
    long zzblD;
    int zzblE;

    LoyaltyPointsBalance() {
        this.mVersionCode = 1;
        this.zzblE = -1;
        this.zzblA = -1;
        this.zzblC = -1.0d;
    }

    LoyaltyPointsBalance(int versionCode, int balanceInt, String balanceString, double balanceDouble, String currencyCode, long currencyMicros, int balanceType) {
        this.mVersionCode = versionCode;
        this.zzblA = balanceInt;
        this.zzblB = balanceString;
        this.zzblC = balanceDouble;
        this.zzbjx = currencyCode;
        this.zzblD = currencyMicros;
        this.zzblE = balanceType;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
