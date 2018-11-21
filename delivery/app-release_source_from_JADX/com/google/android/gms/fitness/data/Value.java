package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzns;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class Value implements SafeParcelable {
    public static final Creator<Value> CREATOR = new zzt();
    private final int mVersionCode;
    private final int zzauR;
    private float zzauV;
    private boolean zzavh;
    private String zzavi;
    private Map<String, MapValue> zzavj;
    private int[] zzavk;
    private float[] zzavl;
    private byte[] zzavm;

    public Value(int format) {
        this(3, format, false, 0.0f, null, null, null, null, null);
    }

    Value(int versionCode, int format, boolean isSet, float value, String stringValue, Bundle mapValue, int[] intArrayValue, float[] floatArrayValue, byte[] blob) {
        this.mVersionCode = versionCode;
        this.zzauR = format;
        this.zzavh = isSet;
        this.zzauV = value;
        this.zzavi = stringValue;
        this.zzavj = zzv(mapValue);
        this.zzavk = intArrayValue;
        this.zzavl = floatArrayValue;
        this.zzavm = blob;
    }

    private boolean zza(Value value) {
        if (this.zzauR != value.zzauR || this.zzavh != value.zzavh) {
            return false;
        }
        switch (this.zzauR) {
            case 1:
                return asInt() == value.asInt();
            case 2:
                return this.zzauV == value.zzauV;
            case 3:
                return zzw.equal(this.zzavi, value.zzavi);
            case 4:
                return zzw.equal(this.zzavj, value.zzavj);
            case 5:
                return Arrays.equals(this.zzavk, value.zzavk);
            case 6:
                return Arrays.equals(this.zzavl, value.zzavl);
            case 7:
                return Arrays.equals(this.zzavm, value.zzavm);
            default:
                return this.zzauV == value.zzauV;
        }
    }

    private static Map<String, MapValue> zzv(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(MapValue.class.getClassLoader());
        Map<String, MapValue> arrayMap = new ArrayMap(bundle.size());
        for (String str : bundle.keySet()) {
            arrayMap.put(str, bundle.getParcelable(str));
        }
        return arrayMap;
    }

    public String asActivity() {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat() {
        zzx.zza(this.zzauR == 2, (Object) "Value is not in float format");
        return this.zzauV;
    }

    public int asInt() {
        boolean z = true;
        if (this.zzauR != 1) {
            z = false;
        }
        zzx.zza(z, (Object) "Value is not in int format");
        return Float.floatToRawIntBits(this.zzauV);
    }

    public String asString() {
        zzx.zza(this.zzauR == 3, (Object) "Value is not in string format");
        return this.zzavi;
    }

    public void clearKey(String key) {
        zzx.zza(this.zzauR == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (this.zzavj != null) {
            this.zzavj.remove(key);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof Value) && zza((Value) o));
    }

    public int getFormat() {
        return this.zzauR;
    }

    public Float getKeyValue(String key) {
        zzx.zza(this.zzauR == 4, (Object) "Value is not in float map format");
        return (this.zzavj == null || !this.zzavj.containsKey(key)) ? null : Float.valueOf(((MapValue) this.zzavj.get(key)).asFloat());
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzauV), this.zzavi, this.zzavj, this.zzavk, this.zzavl, this.zzavm);
    }

    public boolean isSet() {
        return this.zzavh;
    }

    public void setActivity(String activity) {
        setInt(FitnessActivities.zzdd(activity));
    }

    public void setFloat(float value) {
        zzx.zza(this.zzauR == 2, (Object) "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzavh = true;
        this.zzauV = value;
    }

    public void setInt(int value) {
        zzx.zza(this.zzauR == 1, (Object) "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzavh = true;
        this.zzauV = Float.intBitsToFloat(value);
    }

    public void setKeyValue(String key, float value) {
        zzx.zza(this.zzauR == 4, (Object) "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzavh = true;
        if (this.zzavj == null) {
            this.zzavj = new HashMap();
        }
        this.zzavj.put(key, MapValue.zzc(value));
    }

    public void setString(String value) {
        zzx.zza(this.zzauR == 3, (Object) "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzavh = true;
        this.zzavi = value;
    }

    public String toString() {
        if (!this.zzavh) {
            return "unset";
        }
        switch (this.zzauR) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(this.zzauV);
            case 3:
                return this.zzavi;
            case 4:
                return new TreeMap(this.zzavj).toString();
            case 5:
                return Arrays.toString(this.zzavk);
            case 6:
                return Arrays.toString(this.zzavl);
            case 7:
                return zzns.zza(this.zzavm, 0, this.zzavm.length, false);
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzt.zza(this, dest, flags);
    }

    float zztR() {
        return this.zzauV;
    }

    String zztX() {
        return this.zzavi;
    }

    Bundle zztY() {
        if (this.zzavj == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.zzavj.size());
        for (Entry entry : this.zzavj.entrySet()) {
            bundle.putParcelable((String) entry.getKey(), (Parcelable) entry.getValue());
        }
        return bundle;
    }

    int[] zztZ() {
        return this.zzavk;
    }

    float[] zzua() {
        return this.zzavl;
    }

    byte[] zzub() {
        return this.zzavm;
    }
}
