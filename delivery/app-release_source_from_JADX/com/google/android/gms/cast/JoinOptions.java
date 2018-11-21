package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class JoinOptions implements SafeParcelable {
    public static final Creator<JoinOptions> CREATOR = new zzc();
    private final int mVersionCode;
    private int zzZc;

    public JoinOptions() {
        this(1, 0);
    }

    JoinOptions(int versionCode, int connectionType) {
        this.mVersionCode = versionCode;
        this.zzZc = connectionType;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof JoinOptions)) {
            return false;
        }
        return this.zzZc == ((JoinOptions) obj).zzZc;
    }

    public int getConnectionType() {
        return this.zzZc;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzZc));
    }

    public String toString() {
        String str;
        switch (this.zzZc) {
            case 0:
                str = "STRONG";
                break;
            case 2:
                str = "INVISIBLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", new Object[]{str});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
