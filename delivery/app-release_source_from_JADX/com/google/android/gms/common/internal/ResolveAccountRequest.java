package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new zzy();
    final int mVersionCode;
    private final Account zzSo;
    private final GoogleSignInAccount zzakA;
    private final int zzakz;

    ResolveAccountRequest(int versionCode, Account account, int sessionId, GoogleSignInAccount signInAccountHint) {
        this.mVersionCode = versionCode;
        this.zzSo = account;
        this.zzakz = sessionId;
        this.zzakA = signInAccountHint;
    }

    public ResolveAccountRequest(Account account, int sessionId, GoogleSignInAccount signInAccountHint) {
        this(2, account, sessionId, signInAccountHint);
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public int getSessionId() {
        return this.zzakz;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzy.zza(this, dest, flags);
    }

    public GoogleSignInAccount zzqG() {
        return this.zzakA;
    }
}
