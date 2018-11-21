package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class AmsEntityUpdateParcelable implements SafeParcelable, zzb {
    public static final Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
    private final String mValue;
    final int mVersionCode;
    private byte zzbmA;
    private final byte zzbmB;

    AmsEntityUpdateParcelable(int versionCode, byte entityId, byte attributeId, String value) {
        this.zzbmA = entityId;
        this.mVersionCode = versionCode;
        this.zzbmB = attributeId;
        this.mValue = value;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) o;
        if (this.zzbmA != amsEntityUpdateParcelable.zzbmA) {
            return false;
        }
        if (this.mVersionCode != amsEntityUpdateParcelable.mVersionCode) {
            return false;
        }
        if (this.zzbmB != amsEntityUpdateParcelable.zzbmB) {
            return false;
        }
        return this.mValue.equals(amsEntityUpdateParcelable.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.zzbmA) * 31) + this.zzbmB) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.zzbmA + ", mAttributeId=" + this.zzbmB + ", mValue='" + this.mValue + '\'' + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public byte zzGC() {
        return this.zzbmA;
    }

    public byte zzGD() {
        return this.zzbmB;
    }
}
