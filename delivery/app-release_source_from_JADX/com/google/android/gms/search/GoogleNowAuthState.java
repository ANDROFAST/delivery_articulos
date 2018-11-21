package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState implements SafeParcelable {
    public static final Creator<GoogleNowAuthState> CREATOR = new zza();
    final int mVersionCode;
    String zzbbt;
    String zzbbu;
    long zzbbv;

    GoogleNowAuthState(int versionCode, String authCode, String accessToken, long nextAllowedTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzbbt = authCode;
        this.zzbbu = accessToken;
        this.zzbbv = nextAllowedTimeMillis;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.zzbbu;
    }

    public String getAuthCode() {
        return this.zzbbt;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzbbv;
    }

    public String toString() {
        return "mAuthCode = " + this.zzbbt + "\nmAccessToken = " + this.zzbbu + "\nmNextAllowedTimeMillis = " + this.zzbbv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
