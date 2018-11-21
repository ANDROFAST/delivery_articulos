package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zza();
    final int mVersion;
    final long zzTC;
    final String zzTD;
    final int zzTE;
    final int zzTF;
    final String zzTG;

    AccountChangeEvent(int version, long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.mVersion = version;
        this.zzTC = id;
        this.zzTD = (String) zzx.zzy(accountName);
        this.zzTE = changeType;
        this.zzTF = eventIndex;
        this.zzTG = changeData;
    }

    public AccountChangeEvent(long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.mVersion = 1;
        this.zzTC = id;
        this.zzTD = (String) zzx.zzy(accountName);
        this.zzTE = changeType;
        this.zzTF = eventIndex;
        this.zzTG = changeData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (!(that instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) that;
        return this.mVersion == accountChangeEvent.mVersion && this.zzTC == accountChangeEvent.zzTC && zzw.equal(this.zzTD, accountChangeEvent.zzTD) && this.zzTE == accountChangeEvent.zzTE && this.zzTF == accountChangeEvent.zzTF && zzw.equal(this.zzTG, accountChangeEvent.zzTG);
    }

    public String getAccountName() {
        return this.zzTD;
    }

    public String getChangeData() {
        return this.zzTG;
    }

    public int getChangeType() {
        return this.zzTE;
    }

    public int getEventIndex() {
        return this.zzTF;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzTC), this.zzTD, Integer.valueOf(this.zzTE), Integer.valueOf(this.zzTF), this.zzTG);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzTE) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzTD + ", changeType = " + str + ", changeData = " + this.zzTG + ", eventIndex = " + this.zzTF + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
