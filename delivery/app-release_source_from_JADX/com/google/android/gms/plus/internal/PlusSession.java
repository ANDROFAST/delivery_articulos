package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class PlusSession implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private final String zzTD;
    private final String[] zzaZe;
    private final String[] zzaZf;
    private final String[] zzaZg;
    private final String zzaZh;
    private final String zzaZi;
    private final String zzaZj;
    private final PlusCommonExtras zzaZk;
    private final String zzabt;

    PlusSession(int versionCode, String accountName, String[] requestedScopes, String[] visibleActions, String[] requiredFeatures, String packageNameForAuth, String callingPackageName, String applicationName, String clientId_DEPRECATED, PlusCommonExtras extras) {
        this.mVersionCode = versionCode;
        this.zzTD = accountName;
        this.zzaZe = requestedScopes;
        this.zzaZf = visibleActions;
        this.zzaZg = requiredFeatures;
        this.zzaZh = packageNameForAuth;
        this.zzaZi = callingPackageName;
        this.zzabt = applicationName;
        this.zzaZj = clientId_DEPRECATED;
        this.zzaZk = extras;
    }

    public PlusSession(String accountName, String[] requestedScopes, String[] visibleActions, String[] requiredFeatures, String packageNameForAuth, String callingPackageName, String applicationName, PlusCommonExtras extra) {
        this.mVersionCode = 1;
        this.zzTD = accountName;
        this.zzaZe = requestedScopes;
        this.zzaZf = visibleActions;
        this.zzaZg = requiredFeatures;
        this.zzaZh = packageNameForAuth;
        this.zzaZi = callingPackageName;
        this.zzabt = applicationName;
        this.zzaZj = null;
        this.zzaZk = extra;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusSession)) {
            return false;
        }
        PlusSession plusSession = (PlusSession) obj;
        return this.mVersionCode == plusSession.mVersionCode && zzw.equal(this.zzTD, plusSession.zzTD) && Arrays.equals(this.zzaZe, plusSession.zzaZe) && Arrays.equals(this.zzaZf, plusSession.zzaZf) && Arrays.equals(this.zzaZg, plusSession.zzaZg) && zzw.equal(this.zzaZh, plusSession.zzaZh) && zzw.equal(this.zzaZi, plusSession.zzaZi) && zzw.equal(this.zzabt, plusSession.zzabt) && zzw.equal(this.zzaZj, plusSession.zzaZj) && zzw.equal(this.zzaZk, plusSession.zzaZk);
    }

    public String getAccountName() {
        return this.zzTD;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzTD, this.zzaZe, this.zzaZf, this.zzaZg, this.zzaZh, this.zzaZi, this.zzabt, this.zzaZj, this.zzaZk);
    }

    public String toString() {
        return zzw.zzx(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("accountName", this.zzTD).zzg("requestedScopes", this.zzaZe).zzg("visibleActivities", this.zzaZf).zzg("requiredFeatures", this.zzaZg).zzg("packageNameForAuth", this.zzaZh).zzg("callingPackageName", this.zzaZi).zzg("applicationName", this.zzabt).zzg("extra", this.zzaZk.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public String[] zzDi() {
        return this.zzaZe;
    }

    public String[] zzDj() {
        return this.zzaZf;
    }

    public String[] zzDk() {
        return this.zzaZg;
    }

    public String zzDl() {
        return this.zzaZh;
    }

    public String zzDm() {
        return this.zzaZi;
    }

    public String zzDn() {
        return this.zzaZj;
    }

    public PlusCommonExtras zzDo() {
        return this.zzaZk;
    }

    public Bundle zzDp() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.zzaZk.zzG(bundle);
        return bundle;
    }

    public String zznF() {
        return this.zzabt;
    }
}
