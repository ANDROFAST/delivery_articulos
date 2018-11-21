package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzps;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new zzh();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzZU;
    private final String zzabv;
    private final String zzauA;
    private final String zzauB;
    private final String zzauC;
    private final int zzauD;

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.mVersionCode = versionCode;
        this.zzauA = (String) zzx.zzy(manufacturer);
        this.zzauB = (String) zzx.zzy(model);
        this.zzabv = "";
        this.zzauC = (String) zzx.zzy(uid);
        this.zzZU = type;
        this.zzauD = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, "", uid, type, 0);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(1, manufacturer, model, "", uid, type, platformType);
    }

    public static Device getLocalDevice(Context context) {
        int zzaF = zzoo.zzaF(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, zzaB(context), zzaF, 2);
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzauA, device.zzauA) && zzw.equal(this.zzauB, device.zzauB) && zzw.equal(this.zzabv, device.zzabv) && zzw.equal(this.zzauC, device.zzauC) && this.zzZU == device.zzZU && this.zzauD == device.zzauD;
    }

    private static String zzaB(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zztO() {
        return zztN() == 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && zza((Device) that));
    }

    public String getManufacturer() {
        return this.zzauA;
    }

    public String getModel() {
        return this.zzauB;
    }

    String getStreamIdentifier() {
        return String.format("%s:%s:%s", new Object[]{this.zzauA, this.zzauB, this.zzauC});
    }

    public int getType() {
        return this.zzZU;
    }

    public String getUid() {
        return this.zzauC;
    }

    public String getVersion() {
        return this.zzabv;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzauA, this.zzauB, this.zzabv, this.zzauC, Integer.valueOf(this.zzZU));
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", new Object[]{getStreamIdentifier(), this.zzabv, Integer.valueOf(this.zzZU), Integer.valueOf(this.zzauD)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public int zztN() {
        return this.zzauD;
    }

    public String zztP() {
        return zztO() ? this.zzauC : zzps.zzdr(this.zzauC);
    }
}
