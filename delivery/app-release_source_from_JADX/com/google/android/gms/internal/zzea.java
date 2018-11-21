package com.google.android.gms.internal;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzk;

@zzha
public class zzea {
    private final VersionInfoParcel zzpI;
    private final zzd zzpc;
    private final zzew zzpd;
    private MutableContextWrapper zzzz;

    zzea(Context context, zzew com_google_android_gms_internal_zzew, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        this.zzzz = new MutableContextWrapper(context.getApplicationContext());
        this.zzpd = com_google_android_gms_internal_zzew;
        this.zzpI = versionInfoParcel;
        this.zzpc = com_google_android_gms_ads_internal_zzd;
    }

    public zzk zzac(String str) {
        return new zzk(this.zzzz, new AdSizeParcel(), str, this.zzpd, this.zzpI, this.zzpc);
    }

    public zzea zzdV() {
        return new zzea(this.zzzz.getBaseContext(), this.zzpd, this.zzpI, this.zzpc);
    }

    MutableContextWrapper zzdW() {
        return this.zzzz;
    }
}
