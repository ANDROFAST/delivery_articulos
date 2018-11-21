package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken implements SafeParcelable {
    public static final Creator<IdToken> CREATOR = new zze();
    final int mVersionCode;
    private final String zzUB;
    private final String zzUN;

    IdToken(int version, String accountType, String idToken) {
        this.mVersionCode = version;
        this.zzUB = accountType;
        this.zzUN = idToken;
    }

    public IdToken(String accountType, String idToken) {
        this(1, accountType, idToken);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountType() {
        return this.zzUB;
    }

    public String getIdToken() {
        return this.zzUN;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
