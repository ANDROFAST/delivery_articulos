package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Creator<CapabilityInfoParcelable> CREATOR = new zzk();
    private final String mName;
    final int mVersionCode;
    private Set<Node> zzbmN;
    private final List<NodeParcelable> zzbmQ;
    private final Object zzpK = new Object();

    CapabilityInfoParcelable(int versionCode, String name, List<NodeParcelable> nodeList) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzbmQ = nodeList;
        this.zzbmN = null;
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
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) o;
        if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.zzbmQ != null) {
            if (this.zzbmQ.equals(capabilityInfoParcelable.zzbmQ)) {
                return true;
            }
        } else if (capabilityInfoParcelable.zzbmQ == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.mName;
    }

    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzpK) {
            if (this.zzbmN == null) {
                this.zzbmN = new HashSet(this.zzbmQ);
            }
            set = this.zzbmN;
        }
        return set;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + (this.mVersionCode * 31)) * 31;
        if (this.zzbmQ != null) {
            i = this.zzbmQ.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzbmQ + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    public List<NodeParcelable> zzGK() {
        return this.zzbmQ;
    }
}
