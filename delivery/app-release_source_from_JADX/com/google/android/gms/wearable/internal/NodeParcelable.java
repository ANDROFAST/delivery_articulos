package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable implements SafeParcelable, Node {
    public static final Creator<NodeParcelable> CREATOR = new zzbp();
    final int mVersionCode;
    private final String zzVu;
    private final boolean zzboA;
    private final int zzboz;
    private final String zzxX;

    NodeParcelable(int versionCode, String id, String displayName, int hopCount, boolean isNearby) {
        this.mVersionCode = versionCode;
        this.zzxX = id;
        this.zzVu = displayName;
        this.zzboz = hopCount;
        this.zzboA = isNearby;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return !(o instanceof NodeParcelable) ? false : ((NodeParcelable) o).zzxX.equals(this.zzxX);
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public int getHopCount() {
        return this.zzboz;
    }

    public String getId() {
        return this.zzxX;
    }

    public int hashCode() {
        return this.zzxX.hashCode();
    }

    public boolean isNearby() {
        return this.zzboA;
    }

    public String toString() {
        return "Node{" + this.zzVu + ", id=" + this.zzxX + ", hops=" + this.zzboz + ", isNearby=" + this.zzboA + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbp.zza(this, dest, flags);
    }
}
