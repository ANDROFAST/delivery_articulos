package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SafeBrowsingData implements SafeParcelable {
    public static final Creator<SafeBrowsingData> CREATOR = new zzb();
    public final int mVersionCode;
    private String zzbbi;

    SafeBrowsingData(int versionCode, String metadata) {
        this.mVersionCode = versionCode;
        this.zzbbi = metadata;
    }

    public SafeBrowsingData(String metadata) {
        this(1, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public String getMetadata() {
        return this.zzbbi;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
