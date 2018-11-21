package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzqv;

public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzaVU;
    private final zzqt zzaVW;
    private final zzqu zzaVX;
    private final zzqv zzaVY;

    EnableTargetRequest(int versionCode, String name, String description, byte deviceType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.name = zzx.zzcG(name);
        this.description = (String) zzx.zzy(description);
        this.zzaVU = deviceType;
        zzx.zzy(connectionListener);
        this.zzaVW = zza.zzdl(connectionListener);
        zzx.zzy(dataListener);
        this.zzaVX = zzqu.zza.zzdm(dataListener);
        zzx.zzy(callback);
        this.zzaVY = zzqv.zza.zzdn(callback);
    }

    public int describeContents() {
        zze com_google_android_gms_nearby_bootstrap_request_zze = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze com_google_android_gms_nearby_bootstrap_request_zze = CREATOR;
        zze.zza(this, out, flags);
    }

    public byte zzCk() {
        return this.zzaVU;
    }

    public IBinder zzCp() {
        return this.zzaVW == null ? null : this.zzaVW.asBinder();
    }

    public IBinder zzCq() {
        return this.zzaVX == null ? null : this.zzaVX.asBinder();
    }

    public IBinder zzui() {
        return this.zzaVY == null ? null : this.zzaVY.asBinder();
    }
}
