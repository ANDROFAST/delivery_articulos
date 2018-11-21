package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ApplicationStatus implements SafeParcelable {
    public static final Creator<ApplicationStatus> CREATOR = new zza();
    private final int mVersionCode;
    private String zzabI;

    public ApplicationStatus() {
        this(1, null);
    }

    ApplicationStatus(int versionCode, String applicationStatusText) {
        this.mVersionCode = versionCode;
        this.zzabI = applicationStatusText;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationStatus)) {
            return false;
        }
        return zzf.zza(this.zzabI, ((ApplicationStatus) obj).zzabI);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzabI);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zznM() {
        return this.zzabI;
    }
}
