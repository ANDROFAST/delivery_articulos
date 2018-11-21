package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqt.zza;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.nearby.bootstrap.Device;

public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzaVU;
    private final Device zzaVV;
    private final zzqt zzaVW;
    private final zzqu zzaVX;
    private final zzqv zzaVY;
    private final String zzaVZ;
    private final byte zzaWa;

    ConnectRequest(int versionCode, Device device, String name, String description, byte deviceType, long timeoutMillis, String token, byte connectType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaVV = (Device) zzx.zzy(device);
        this.name = zzx.zzcG(name);
        this.description = (String) zzx.zzy(description);
        this.zzaVU = deviceType;
        this.timeoutMillis = timeoutMillis;
        this.zzaWa = connectType;
        this.zzaVZ = token;
        zzx.zzy(connectionListener);
        this.zzaVW = zza.zzdl(connectionListener);
        zzx.zzy(dataListener);
        this.zzaVX = zzqu.zza.zzdm(dataListener);
        zzx.zzy(callback);
        this.zzaVY = zzqv.zza.zzdn(callback);
    }

    public int describeContents() {
        zza com_google_android_gms_nearby_bootstrap_request_zza = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzaVZ;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_nearby_bootstrap_request_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public byte zzCk() {
        return this.zzaVU;
    }

    public Device zzCm() {
        return this.zzaVV;
    }

    public long zzCn() {
        return this.timeoutMillis;
    }

    public byte zzCo() {
        return this.zzaWa;
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
