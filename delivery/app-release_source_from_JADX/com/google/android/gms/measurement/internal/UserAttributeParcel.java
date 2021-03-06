package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class UserAttributeParcel implements SafeParcelable {
    public static final zzad CREATOR = new zzad();
    public final String name;
    public final int versionCode;
    public final String zzaSM;
    public final long zzaVg;
    public final Long zzaVh;
    public final Float zzaVi;
    public final String zzakS;

    UserAttributeParcel(int versionCode, String name, long timestamp, Long longValue, Float floatValue, String stringValue, String origin) {
        this.versionCode = versionCode;
        this.name = name;
        this.zzaVg = timestamp;
        this.zzaVh = longValue;
        this.zzaVi = floatValue;
        this.zzakS = stringValue;
        this.zzaSM = origin;
    }

    UserAttributeParcel(String name, long setTimestamp, Object value, String origin) {
        zzx.zzcG(name);
        this.versionCode = 1;
        this.name = name;
        this.zzaVg = setTimestamp;
        this.zzaSM = origin;
        if (value == null) {
            this.zzaVh = null;
            this.zzaVi = null;
            this.zzakS = null;
        } else if (value instanceof Long) {
            this.zzaVh = (Long) value;
            this.zzaVi = null;
            this.zzakS = null;
        } else if (value instanceof Float) {
            this.zzaVh = null;
            this.zzaVi = (Float) value;
            this.zzakS = null;
        } else if (value instanceof String) {
            this.zzaVh = null;
            this.zzaVi = null;
            this.zzakS = (String) value;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public int describeContents() {
        return 0;
    }

    public Object getValue() {
        return this.zzaVh != null ? this.zzaVh : this.zzaVi != null ? this.zzaVi : this.zzakS != null ? this.zzakS : null;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzad.zza(this, out, flags);
    }
}
