package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class IdpTokenType implements SafeParcelable {
    public static final Creator<IdpTokenType> CREATOR = new zzi();
    public static final IdpTokenType zzWc = new IdpTokenType("accessToken");
    public static final IdpTokenType zzWd = new IdpTokenType("idToken");
    final int versionCode;
    private final String zzWe;

    IdpTokenType(int versionCode, String tokenType) {
        this.versionCode = versionCode;
        this.zzWe = zzx.zzcG(tokenType);
    }

    private IdpTokenType(String tokenType) {
        this(1, tokenType);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.zzWe.equals(((IdpTokenType) obj).zzmN());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.zzWe.hashCode();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }

    public String zzmN() {
        return this.zzWe;
    }
}
