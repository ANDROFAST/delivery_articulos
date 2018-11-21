package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zztk;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int mVersionCode;
    final long zzamA;
    final long zzamB;
    private volatile String zzamC = null;
    final long zzamz;

    ChangeSequenceNumber(int versionCode, long sequenceNumber, long databaseInstanceId, long accountId) {
        boolean z = true;
        zzx.zzab(sequenceNumber != -1);
        zzx.zzab(databaseInstanceId != -1);
        if (accountId == -1) {
            z = false;
        }
        zzx.zzab(z);
        this.mVersionCode = versionCode;
        this.zzamz = sequenceNumber;
        this.zzamA = databaseInstanceId;
        this.zzamB = accountId;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzamC == null) {
            this.zzamC = "ChangeSequenceNumber:" + Base64.encodeToString(zzse(), 10);
        }
        return this.zzamC;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzamA == this.zzamA && changeSequenceNumber.zzamB == this.zzamB && changeSequenceNumber.zzamz == this.zzamz;
    }

    public int hashCode() {
        return (String.valueOf(this.zzamz) + String.valueOf(this.zzamA) + String.valueOf(this.zzamB)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    final byte[] zzse() {
        zztk com_google_android_gms_drive_internal_zzas = new zzas();
        com_google_android_gms_drive_internal_zzas.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzas.zzapS = this.zzamz;
        com_google_android_gms_drive_internal_zzas.zzapT = this.zzamA;
        com_google_android_gms_drive_internal_zzas.zzapU = this.zzamB;
        return zztk.toByteArray(com_google_android_gms_drive_internal_zzas);
    }
}
