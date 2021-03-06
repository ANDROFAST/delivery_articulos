package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult implements Result, SafeParcelable {
    public static final Creator<AuthAccountResult> CREATOR = new zza();
    final int mVersionCode;
    private int zzbbS;
    private Intent zzbbT;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int versionCode, int connectionResultCode, Intent rawAuthResultionIntent) {
        this.mVersionCode = versionCode;
        this.zzbbS = connectionResultCode;
        this.zzbbT = rawAuthResultionIntent;
    }

    public AuthAccountResult(int connectionResultCode, Intent rawAuthResolutionIntent) {
        this(2, connectionResultCode, rawAuthResolutionIntent);
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzbbS == 0 ? Status.zzaeX : Status.zzafb;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public int zzDR() {
        return this.zzbbS;
    }

    public Intent zzDS() {
        return this.zzbbT;
    }
}
