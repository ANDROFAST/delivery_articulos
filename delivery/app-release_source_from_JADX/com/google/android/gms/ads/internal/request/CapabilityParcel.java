package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public class CapabilityParcel implements SafeParcelable {
    public static final Creator<CapabilityParcel> CREATOR = new zzi();
    public final int versionCode;
    public final boolean zzHd;
    public final boolean zzHe;

    CapabilityParcel(int versionCode, boolean inAppPurchaseSupported, boolean defaultInAppPurchaseSupported) {
        this.versionCode = versionCode;
        this.zzHd = inAppPurchaseSupported;
        this.zzHe = defaultInAppPurchaseSupported;
    }

    public CapabilityParcel(boolean inAppPurchaseSupported, boolean defaultInAppPurchaseSupported) {
        this(1, inAppPurchaseSupported, defaultInAppPurchaseSupported);
    }

    public int describeContents() {
        return 0;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzHd);
        bundle.putBoolean("default_iap_supported", this.zzHe);
        return bundle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
