package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;

public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int mVersionCode;
    private String zzaZb;
    private String zzaZc;

    public PlusCommonExtras() {
        this.mVersionCode = 1;
        this.zzaZb = "";
        this.zzaZc = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.mVersionCode = versionCode;
        this.zzaZb = gpsrc;
        this.zzaZc = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.mVersionCode == plusCommonExtras.mVersionCode && zzw.equal(this.zzaZb, plusCommonExtras.zzaZb) && zzw.equal(this.zzaZc, plusCommonExtras.zzaZc);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzaZb, this.zzaZc);
    }

    public String toString() {
        return zzw.zzx(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzaZb).zzg("ClientCallingPackage", this.zzaZc).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public String zzDg() {
        return this.zzaZb;
    }

    public String zzDh() {
        return this.zzaZc;
    }

    public void zzG(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzc.zza(this));
    }
}
