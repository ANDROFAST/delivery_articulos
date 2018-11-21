package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Permission implements SafeParcelable {
    public static final Creator<Permission> CREATOR = new zzi();
    final int mVersionCode;
    private String zzano;
    private int zzanp;
    private String zzanq;
    private String zzanr;
    private int zzans;
    private boolean zzant;

    Permission(int versionCode, String accountIdentifier, int accountType, String accountDisplayName, String photoLink, int role, boolean isLinkRequired) {
        this.mVersionCode = versionCode;
        this.zzano = accountIdentifier;
        this.zzanp = accountType;
        this.zzanq = accountDisplayName;
        this.zzanr = photoLink;
        this.zzans = role;
        this.zzant = isLinkRequired;
    }

    public static boolean zzcA(int i) {
        switch (i) {
            case 256:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcB(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
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
        Permission permission = (Permission) o;
        return zzw.equal(this.zzano, permission.zzano) && this.zzanp == permission.zzanp && this.zzans == permission.zzans && this.zzant == permission.zzant;
    }

    public int getRole() {
        return !zzcB(this.zzans) ? -1 : this.zzans;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzano, Integer.valueOf(this.zzanp), Integer.valueOf(this.zzans), Boolean.valueOf(this.zzant));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public String zzsr() {
        return !zzcA(this.zzanp) ? null : this.zzano;
    }

    public int zzss() {
        return !zzcA(this.zzanp) ? -1 : this.zzanp;
    }

    public String zzst() {
        return this.zzanq;
    }

    public String zzsu() {
        return this.zzanr;
    }

    public boolean zzsv() {
        return this.zzant;
    }
}
