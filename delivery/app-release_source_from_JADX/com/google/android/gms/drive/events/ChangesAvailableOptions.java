package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Creator<ChangesAvailableOptions> CREATOR = new zzd();
    final int mVersionCode;
    final int zzanD;
    final boolean zzanE;
    final List<DriveSpace> zzanF;
    private final Set<DriveSpace> zzanG;

    ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList) {
        this(versionCode, changesSizeLimit, repeats, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzanD = changesSizeLimit;
        this.zzanE = repeats;
        this.zzanF = spacesList;
        this.zzanG = spaces;
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
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) o;
        return zzw.equal(this.zzanG, changesAvailableOptions.zzanG) && this.zzanD == changesAvailableOptions.zzanD && this.zzanE == changesAvailableOptions.zzanE;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanG, Integer.valueOf(this.zzanD), Boolean.valueOf(this.zzanE));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[]{Integer.valueOf(this.zzanD), Boolean.valueOf(this.zzanE), this.zzanF});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
