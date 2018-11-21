package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    private final String zzTR;
    private final Long zzTS;
    private final boolean zzTT;
    private final boolean zzTU;
    private final List<String> zzTV;

    TokenData(int versionCode, String token, Long expirationTimeSecs, boolean isCached, boolean isSnowballed, List<String> grantedScopes) {
        this.mVersionCode = versionCode;
        this.zzTR = zzx.zzcG(token);
        this.zzTS = expirationTimeSecs;
        this.zzTT = isCached;
        this.zzTU = isSnowballed;
        this.zzTV = grantedScopes;
    }

    public static TokenData zza(Bundle bundle, String str) {
        bundle.setClassLoader(TokenData.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(TokenData.class.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) o;
        return TextUtils.equals(this.zzTR, tokenData.zzTR) && zzw.equal(this.zzTS, tokenData.zzTS) && this.zzTT == tokenData.zzTT && this.zzTU == tokenData.zzTU && zzw.equal(this.zzTV, tokenData.zzTV);
    }

    public String getToken() {
        return this.zzTR;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTR, this.zzTS, Boolean.valueOf(this.zzTT), Boolean.valueOf(this.zzTU), this.zzTV);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    public Long zzlW() {
        return this.zzTS;
    }

    public boolean zzlX() {
        return this.zzTT;
    }

    public boolean zzlY() {
        return this.zzTU;
    }

    public List<String> zzlZ() {
        return this.zzTV;
    }
}
