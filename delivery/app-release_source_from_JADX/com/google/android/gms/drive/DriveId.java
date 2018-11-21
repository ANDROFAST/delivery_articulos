package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR = new zze();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final long zzamA;
    private volatile String zzamC;
    final String zzamR;
    final long zzamS;
    final int zzamT;
    private volatile String zzamU;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        boolean z = false;
        this.zzamC = null;
        this.zzamU = null;
        this.mVersionCode = versionCode;
        this.zzamR = resourceId;
        zzx.zzab(!"".equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        zzx.zzab(z);
        this.zzamS = sqlId;
        this.zzamA = databaseInstanceId;
        this.zzamT = resourceType;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this(1, resourceId, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzx.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzl(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcQ(String str) {
        zzx.zzy(str);
        return new DriveId(str, -1, -1, -1);
    }

    static DriveId zzl(byte[] bArr) {
        try {
            zzat zzm = zzat.zzm(bArr);
            return new DriveId(zzm.versionCode, "".equals(zzm.zzapV) ? null : zzm.zzapV, zzm.zzapW, zzm.zzapT, zzm.zzapX);
        } catch (zztj e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzsk() {
        zztk com_google_android_gms_drive_internal_zzau = new zzau();
        com_google_android_gms_drive_internal_zzau.zzapW = this.zzamS;
        com_google_android_gms_drive_internal_zzau.zzapT = this.zzamA;
        return zztk.toByteArray(com_google_android_gms_drive_internal_zzau);
    }

    public DriveFile asDriveFile() {
        if (this.zzamT != 1) {
            return new zzw(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }

    public DriveFolder asDriveFolder() {
        if (this.zzamT != 0) {
            return new zzy(this);
        }
        throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }

    public DriveResource asDriveResource() {
        return this.zzamT == 1 ? asDriveFolder() : this.zzamT == 0 ? asDriveFile() : new zzab(this);
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzamC == null) {
            this.zzamC = "DriveId:" + Base64.encodeToString(zzse(), 10);
        }
        return this.zzamC;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzamA != this.zzamA) {
            return false;
        }
        if (driveId.zzamS == -1 && this.zzamS == -1) {
            return driveId.zzamR.equals(this.zzamR);
        }
        if (this.zzamR == null || driveId.zzamR == null) {
            if (driveId.zzamS != this.zzamS) {
                z = false;
            }
            return z;
        } else if (driveId.zzamS != this.zzamS) {
            return false;
        } else {
            if (driveId.zzamR.equals(this.zzamR)) {
                return true;
            }
            zzz.zzA("DriveId", "Unexpected unequal resourceId for same DriveId object.");
            return false;
        }
    }

    public String getResourceId() {
        return this.zzamR;
    }

    public int getResourceType() {
        return this.zzamT;
    }

    public int hashCode() {
        return this.zzamS == -1 ? this.zzamR.hashCode() : (String.valueOf(this.zzamA) + String.valueOf(this.zzamS)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzamU == null) {
            this.zzamU = Base64.encodeToString(zzsk(), 10);
        }
        return this.zzamU;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }

    final byte[] zzse() {
        zztk com_google_android_gms_drive_internal_zzat = new zzat();
        com_google_android_gms_drive_internal_zzat.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzat.zzapV = this.zzamR == null ? "" : this.zzamR;
        com_google_android_gms_drive_internal_zzat.zzapW = this.zzamS;
        com_google_android_gms_drive_internal_zzat.zzapT = this.zzamA;
        com_google_android_gms_drive_internal_zzat.zzapX = this.zzamT;
        return zztk.toByteArray(com_google_android_gms_drive_internal_zzat);
    }
}
