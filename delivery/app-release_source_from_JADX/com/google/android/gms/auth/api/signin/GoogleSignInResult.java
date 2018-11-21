package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    private Status zzTA;
    private GoogleSignInAccount zzVI;

    public GoogleSignInResult(GoogleSignInAccount SignInAccount, Status status) {
        this.zzVI = SignInAccount;
        this.zzTA = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.zzVI;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public boolean isSuccess() {
        return this.zzTA.isSuccess();
    }
}
