package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new zzg();
    private final String mName;
    final int mVersionCode;
    private boolean zzRH;
    private final int zzZU;
    private final int zzans;
    private final String zzatX;
    private final boolean zzblP;
    private String zzblQ;
    private boolean zzblR;
    private String zzblS;

    ConnectionConfiguration(int versionCode, String name, String address, int type, int role, boolean connectionEnabled, boolean isConnected, String peerNodeId, boolean btlePriority, String nodeId) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzatX = address;
        this.zzZU = type;
        this.zzans = role;
        this.zzblP = connectionEnabled;
        this.zzRH = isConnected;
        this.zzblQ = peerNodeId;
        this.zzblR = btlePriority;
        this.zzblS = nodeId;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) o;
        return zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && zzw.equal(this.mName, connectionConfiguration.mName) && zzw.equal(this.zzatX, connectionConfiguration.zzatX) && zzw.equal(Integer.valueOf(this.zzZU), Integer.valueOf(connectionConfiguration.zzZU)) && zzw.equal(Integer.valueOf(this.zzans), Integer.valueOf(connectionConfiguration.zzans)) && zzw.equal(Boolean.valueOf(this.zzblP), Boolean.valueOf(connectionConfiguration.zzblP)) && zzw.equal(Boolean.valueOf(this.zzblR), Boolean.valueOf(connectionConfiguration.zzblR));
    }

    public String getAddress() {
        return this.zzatX;
    }

    public String getName() {
        return this.mName;
    }

    public String getNodeId() {
        return this.zzblS;
    }

    public int getRole() {
        return this.zzans;
    }

    public int getType() {
        return this.zzZU;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.mName, this.zzatX, Integer.valueOf(this.zzZU), Integer.valueOf(this.zzans), Boolean.valueOf(this.zzblP), Boolean.valueOf(this.zzblR));
    }

    public boolean isConnected() {
        return this.zzRH;
    }

    public boolean isEnabled() {
        return this.zzblP;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.zzatX);
        stringBuilder.append(", mType=" + this.zzZU);
        stringBuilder.append(", mRole=" + this.zzans);
        stringBuilder.append(", mEnabled=" + this.zzblP);
        stringBuilder.append(", mIsConnected=" + this.zzRH);
        stringBuilder.append(", mPeerNodeId=" + this.zzblQ);
        stringBuilder.append(", mBtlePriority=" + this.zzblR);
        stringBuilder.append(", mNodeId=" + this.zzblS);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public String zzGw() {
        return this.zzblQ;
    }

    public boolean zzGx() {
        return this.zzblR;
    }
}
