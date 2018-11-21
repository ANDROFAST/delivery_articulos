package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    final int mVersion;
    Account zzSo;
    @Deprecated
    String zzTD;
    int zzTF;

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int version, int eventIndex, String accountName, Account account) {
        this.mVersion = version;
        this.zzTF = eventIndex;
        this.zzTD = accountName;
        if (account != null || TextUtils.isEmpty(accountName)) {
            this.zzSo = account;
        } else {
            this.zzSo = new Account(accountName, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public String getAccountName() {
        return this.zzTD;
    }

    public int getEventIndex() {
        return this.zzTF;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzSo = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String accountName) {
        this.zzTD = accountName;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int eventIndex) {
        this.zzTF = eventIndex;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
