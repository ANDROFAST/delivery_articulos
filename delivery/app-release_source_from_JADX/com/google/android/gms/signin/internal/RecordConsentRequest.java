package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new zzg();
    final int mVersionCode;
    private final Account zzSo;
    private final String zzVG;
    private final Scope[] zzbbW;

    RecordConsentRequest(int versionCode, Account account, Scope[] scopesToConsent, String serverClientId) {
        this.mVersionCode = versionCode;
        this.zzSo = account;
        this.zzbbW = scopesToConsent;
        this.zzVG = serverClientId;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public Scope[] zzDT() {
        return this.zzbbW;
    }

    public String zzmB() {
        return this.zzVG;
    }
}
