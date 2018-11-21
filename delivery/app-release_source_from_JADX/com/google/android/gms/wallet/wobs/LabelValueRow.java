package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import java.util.ArrayList;

public final class LabelValueRow implements SafeParcelable {
    public static final Creator<LabelValueRow> CREATOR = new zzc();
    private final int mVersionCode;
    String zzblw;
    String zzblx;
    ArrayList<LabelValue> zzbly;

    LabelValueRow() {
        this.mVersionCode = 1;
        this.zzbly = zznh.zzrK();
    }

    LabelValueRow(int versionCode, String hexFontColor, String hexBackgroundColor, ArrayList<LabelValue> columns) {
        this.mVersionCode = versionCode;
        this.zzblw = hexFontColor;
        this.zzblx = hexBackgroundColor;
        this.zzbly = columns;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
