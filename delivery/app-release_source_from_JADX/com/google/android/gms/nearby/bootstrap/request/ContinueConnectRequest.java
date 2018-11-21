package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzqv zzaVY;
    private final String zzaVZ;

    ContinueConnectRequest(int versionCode, String token, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaVZ = (String) zzx.zzy(token);
        this.zzaVY = zza.zzdn(callback);
    }

    public int describeContents() {
        zzb com_google_android_gms_nearby_bootstrap_request_zzb = CREATOR;
        return 0;
    }

    public String getToken() {
        return this.zzaVZ;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_nearby_bootstrap_request_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public IBinder zzui() {
        return this.zzaVY == null ? null : this.zzaVY.asBinder();
    }
}
