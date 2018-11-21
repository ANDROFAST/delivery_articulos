package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznm;
import java.util.Set;

public final class UserDataType implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    public static final UserDataType zzaNe = zzy("test_type", 1);
    public static final UserDataType zzaNf = zzy("labeled_place", 6);
    public static final UserDataType zzaNg = zzy("here_content", 7);
    public static final Set<UserDataType> zzaNh = zznm.zza(zzaNe, zzaNf, zzaNg);
    final int mVersionCode;
    final String zzIx;
    final int zzaNi;

    UserDataType(int versionCode, String type, int enumValue) {
        zzx.zzcG(type);
        this.mVersionCode = versionCode;
        this.zzIx = type;
        this.zzaNi = enumValue;
    }

    private static UserDataType zzy(String str, int i) {
        return new UserDataType(0, str, i);
    }

    public int describeContents() {
        zzm com_google_android_gms_location_places_zzm = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) object;
        return this.zzIx.equals(userDataType.zzIx) && this.zzaNi == userDataType.zzaNi;
    }

    public int hashCode() {
        return this.zzIx.hashCode();
    }

    public String toString() {
        return this.zzIx;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm com_google_android_gms_location_places_zzm = CREATOR;
        zzm.zza(this, parcel, flags);
    }
}
