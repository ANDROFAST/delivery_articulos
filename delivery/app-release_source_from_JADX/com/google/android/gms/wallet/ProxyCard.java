package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new zzq();
    private final int mVersionCode;
    String zzbkw;
    String zzbkx;
    int zzbky;
    int zzbkz;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.mVersionCode = versionCode;
        this.zzbkw = pan;
        this.zzbkx = cvn;
        this.zzbky = expirationMonth;
        this.zzbkz = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzbkx;
    }

    public int getExpirationMonth() {
        return this.zzbky;
    }

    public int getExpirationYear() {
        return this.zzbkz;
    }

    public String getPan() {
        return this.zzbkw;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzq.zza(this, out, flags);
    }
}
