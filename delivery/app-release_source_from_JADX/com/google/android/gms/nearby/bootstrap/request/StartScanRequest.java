package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.internal.zzqx.zza;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzqv zzaVY;
    private final zzqx zzaWb;

    StartScanRequest(int versionCode, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzy(scanListener);
        this.zzaWb = zza.zzdp(scanListener);
        zzx.zzy(callback);
        this.zzaVY = zzqv.zza.zzdn(callback);
    }

    public int describeContents() {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzCr() {
        return this.zzaWb == null ? null : this.zzaWb.asBinder();
    }

    public IBinder zzui() {
        return this.zzaVY == null ? null : this.zzaVY.asBinder();
    }
}
