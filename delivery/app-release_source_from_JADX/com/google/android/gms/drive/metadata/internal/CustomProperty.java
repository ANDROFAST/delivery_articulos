package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR = new zzc();
    final String mValue;
    final int mVersionCode;
    final CustomPropertyKey zzaqI;

    CustomProperty(int versionCode, CustomPropertyKey key, String value) {
        this.mVersionCode = versionCode;
        zzx.zzb((Object) key, (Object) "key");
        this.zzaqI = key;
        this.mValue = value;
    }

    public CustomProperty(CustomPropertyKey key, String value) {
        this(1, key, value);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        CustomProperty customProperty = (CustomProperty) o;
        return zzw.equal(this.zzaqI, customProperty.zzaqI) && zzw.equal(this.mValue, customProperty.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaqI, this.mValue);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public CustomPropertyKey zztc() {
        return this.zzaqI;
    }
}
