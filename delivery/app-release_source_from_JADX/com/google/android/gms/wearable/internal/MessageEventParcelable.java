package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Creator<MessageEventParcelable> CREATOR = new zzbn();
    private final String mPath;
    final int mVersionCode;
    private final byte[] zzaHC;
    private final String zzaMP;
    private final int zzamD;

    MessageEventParcelable(int versionCode, int requestId, String path, byte[] data, String source) {
        this.mVersionCode = versionCode;
        this.zzamD = requestId;
        this.mPath = path;
        this.zzaHC = data;
        this.zzaMP = source;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.zzaHC;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRequestId() {
        return this.zzamD;
    }

    public String getSourceNodeId() {
        return this.zzaMP;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzamD + "," + this.mPath + ", size=" + (this.zzaHC == null ? "null" : Integer.valueOf(this.zzaHC.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbn.zza(this, dest, flags);
    }
}
