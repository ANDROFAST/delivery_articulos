package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.Collections;
import java.util.List;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new zzay();
    private static final List<DriveFileRange> zzaqe = Collections.emptyList();
    final int mVersionCode;
    final int zzAk;
    final long zzaqf;
    final long zzaqg;
    final List<DriveFileRange> zzaqh;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected, int status, List<DriveFileRange> rangesAvailable) {
        this.mVersionCode = versionCode;
        this.zzaqf = bytesLoaded;
        this.zzaqg = bytesExpected;
        this.zzAk = status;
        this.zzaqh = rangesAvailable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }

    public long zzsR() {
        return this.zzaqf;
    }

    public long zzsS() {
        return this.zzaqg;
    }
}
