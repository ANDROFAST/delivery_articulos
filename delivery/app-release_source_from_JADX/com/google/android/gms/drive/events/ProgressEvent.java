package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

public final class ProgressEvent implements DriveEvent {
    public static final Creator<ProgressEvent> CREATOR = new zzh();
    final int mVersionCode;
    final int zzAk;
    final int zzZU;
    final DriveId zzamF;
    final long zzanU;
    final long zzanV;

    ProgressEvent(int versionCode, DriveId driveId, int status, long bytesTransferred, long totalBytes, int type) {
        this.mVersionCode = versionCode;
        this.zzamF = driveId;
        this.zzAk = status;
        this.zzanU = bytesTransferred;
        this.zzanV = totalBytes;
        this.zzZU = type;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ProgressEvent progressEvent = (ProgressEvent) o;
        return zzw.equal(this.zzamF, progressEvent.zzamF) && this.zzAk == progressEvent.zzAk && this.zzanU == progressEvent.zzanU && this.zzanV == progressEvent.zzanV;
    }

    public int getType() {
        return this.zzZU;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzamF, Integer.valueOf(this.zzAk), Long.valueOf(this.zzanU), Long.valueOf(this.zzanV));
    }

    public String toString() {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[]{this.zzamF, Integer.valueOf(this.zzAk), Long.valueOf(this.zzanU), Long.valueOf(this.zzanV)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
