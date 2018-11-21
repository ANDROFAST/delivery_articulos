package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR = new zzag();
    final int mVersionCode;
    int zzapC;
    int zzapD;
    boolean zzapE;

    FileUploadPreferencesImpl(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean allowRoaming) {
        this.mVersionCode = versionCode;
        this.zzapC = networkTypePreference;
        this.zzapD = batteryUsagePreference;
        this.zzapE = allowRoaming;
    }

    public static boolean zzdg(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzdh(int i) {
        switch (i) {
            case 256:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        return !zzdh(this.zzapD) ? 0 : this.zzapD;
    }

    public int getNetworkTypePreference() {
        return !zzdg(this.zzapC) ? 0 : this.zzapC;
    }

    public boolean isRoamingAllowed() {
        return this.zzapE;
    }

    public void setBatteryUsagePreference(int batteryUsagePreference) {
        if (zzdh(batteryUsagePreference)) {
            this.zzapD = batteryUsagePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int networkTypePreference) {
        if (zzdg(networkTypePreference)) {
            this.zzapC = networkTypePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean allowRoaming) {
        this.zzapE = allowRoaming;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzag.zza(this, parcel, flags);
    }
}
