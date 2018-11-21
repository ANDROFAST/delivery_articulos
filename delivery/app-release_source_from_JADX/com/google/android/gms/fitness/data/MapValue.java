package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class MapValue implements SafeParcelable {
    public static final Creator<MapValue> CREATOR = new zzl();
    private final int mVersionCode;
    private final int zzauR;
    private final float zzauV;

    public MapValue(int format, float value) {
        this(1, format, value);
    }

    MapValue(int versionCode, int format, float value) {
        this.mVersionCode = versionCode;
        this.zzauR = format;
        this.zzauV = value;
    }

    private boolean zza(MapValue mapValue) {
        if (this.zzauR != mapValue.zzauR) {
            return false;
        }
        switch (this.zzauR) {
            case 2:
                return asFloat() == mapValue.asFloat();
            default:
                return this.zzauV == mapValue.zzauV;
        }
    }

    public static MapValue zzc(float f) {
        return new MapValue(2, f);
    }

    public float asFloat() {
        zzx.zza(this.zzauR == 2, (Object) "Value is not in float format");
        return this.zzauV;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof MapValue) && zza((MapValue) o));
    }

    int getFormat() {
        return this.zzauR;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return (int) this.zzauV;
    }

    public String toString() {
        switch (this.zzauR) {
            case 2:
                return Float.toString(asFloat());
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    float zztR() {
        return this.zzauV;
    }
}
