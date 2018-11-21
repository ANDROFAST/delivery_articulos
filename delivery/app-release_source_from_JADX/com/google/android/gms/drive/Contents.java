package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR = new zzb();
    final int mVersionCode;
    final ParcelFileDescriptor zzaid;
    final int zzamD;
    final int zzamE;
    final DriveId zzamF;
    final boolean zzamG;
    final String zzsL;

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection, String signature) {
        this.mVersionCode = versionCode;
        this.zzaid = parcelFileDescriptor;
        this.zzamD = requestId;
        this.zzamE = mode;
        this.zzamF = driveId;
        this.zzamG = validForConflictDetection;
        this.zzsL = signature;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzamF;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzaid.getFileDescriptor());
    }

    public int getMode() {
        return this.zzamE;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzaid.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzaid;
    }

    public int getRequestId() {
        return this.zzamD;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public boolean zzsf() {
        return this.zzamG;
    }
}
