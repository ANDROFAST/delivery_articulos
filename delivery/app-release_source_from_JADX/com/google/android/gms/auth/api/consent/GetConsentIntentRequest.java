package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class GetConsentIntentRequest implements SafeParcelable {
    public static final Creator<GetConsentIntentRequest> CREATOR = new zzb();
    private final int mVersionCode;
    private final Account zzSo;
    private final String zzUr;
    private final int zzUs;
    private final String zzUt;
    final ScopeDetail[] zzUu;
    private final boolean zzUv;
    private final int zzUw;
    private final String zzUx;

    GetConsentIntentRequest(int versionCode, String callingPackage, int callingUid, String service, Account account, ScopeDetail[] scopeDetails, boolean hasTitle, int title, String consentCookieWrapper) {
        this.mVersionCode = versionCode;
        this.zzUr = callingPackage;
        this.zzUs = callingUid;
        this.zzUt = service;
        this.zzSo = (Account) zzx.zzy(account);
        this.zzUu = scopeDetails;
        this.zzUv = hasTitle;
        this.zzUw = title;
        this.zzUx = consentCookieWrapper;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzSo;
    }

    public String getCallingPackage() {
        return this.zzUr;
    }

    public int getCallingUid() {
        return this.zzUs;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public String zzmc() {
        return this.zzUt;
    }

    public boolean zzmd() {
        return this.zzUv;
    }

    public int zzme() {
        return this.zzUw;
    }

    public String zzmf() {
        return this.zzUx;
    }
}
