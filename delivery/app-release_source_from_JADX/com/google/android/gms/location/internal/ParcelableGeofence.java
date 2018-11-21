package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private final String zzDX;
    private final int zzaKO;
    private final short zzaKQ;
    private final double zzaKR;
    private final double zzaKS;
    private final float zzaKT;
    private final int zzaKU;
    private final int zzaKV;
    private final long zzaMl;

    public ParcelableGeofence(int version, String requestId, int transitionTypes, short type, double latitude, double longitude, float radius, long expireAt, int notificationResponsiveness, int loiteringDelayMillis) {
        zzdU(requestId);
        zze(radius);
        zza(latitude, longitude);
        transitionTypes = zzhw(transitionTypes);
        this.mVersionCode = version;
        this.zzaKQ = type;
        this.zzDX = requestId;
        this.zzaKR = latitude;
        this.zzaKS = longitude;
        this.zzaKT = radius;
        this.zzaMl = expireAt;
        this.zzaKO = transitionTypes;
        this.zzaKU = notificationResponsiveness;
        this.zzaKV = loiteringDelayMillis;
    }

    public ParcelableGeofence(String requestId, int transitionTypes, short type, double latitude, double longitude, float radius, long expireAt, int notificationResponsiveness, int loiteringDelayMillis) {
        this(1, requestId, transitionTypes, type, latitude, longitude, radius, expireAt, notificationResponsiveness, loiteringDelayMillis);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void zzdU(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static void zze(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static int zzhw(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static String zzhx(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static ParcelableGeofence zzo(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ParcelableGeofence zzeQ = CREATOR.zzeQ(obtain);
        obtain.recycle();
        return zzeQ;
    }

    public int describeContents() {
        zzo com_google_android_gms_location_internal_zzo = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
        if (this.zzaKT != parcelableGeofence.zzaKT) {
            return false;
        }
        if (this.zzaKR != parcelableGeofence.zzaKR) {
            return false;
        }
        if (this.zzaKS != parcelableGeofence.zzaKS) {
            return false;
        }
        return this.zzaKQ == parcelableGeofence.zzaKQ;
    }

    public long getExpirationTime() {
        return this.zzaMl;
    }

    public double getLatitude() {
        return this.zzaKR;
    }

    public double getLongitude() {
        return this.zzaKS;
    }

    public int getNotificationResponsiveness() {
        return this.zzaKU;
    }

    public String getRequestId() {
        return this.zzDX;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzaKR);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzaKS);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaKT)) * 31) + this.zzaKQ) * 31) + this.zzaKO;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{zzhx(this.zzaKQ), this.zzDX, Integer.valueOf(this.zzaKO), Double.valueOf(this.zzaKR), Double.valueOf(this.zzaKS), Float.valueOf(this.zzaKT), Integer.valueOf(this.zzaKU / 1000), Integer.valueOf(this.zzaKV), Long.valueOf(this.zzaMl)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo com_google_android_gms_location_internal_zzo = CREATOR;
        zzo.zza(this, parcel, flags);
    }

    public short zzyh() {
        return this.zzaKQ;
    }

    public float zzyi() {
        return this.zzaKT;
    }

    public int zzyj() {
        return this.zzaKO;
    }

    public int zzyk() {
        return this.zzaKV;
    }
}
