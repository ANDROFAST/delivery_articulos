package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    PendingIntent mPendingIntent;
    private final int mVersionCode;
    int zzaMg;
    LocationRequestInternal zzaMh;
    zzd zzaMi;
    zzc zzaMj;
    zzg zzaMk;

    LocationRequestUpdateData(int versionCode, int operation, LocationRequestInternal locationRequest, IBinder locationListenerBinder, PendingIntent pendingIntent, IBinder locationCallbackBinder, IBinder fusedLocationProviderCallbackBinder) {
        zzg com_google_android_gms_location_internal_zzg = null;
        this.mVersionCode = versionCode;
        this.zzaMg = operation;
        this.zzaMh = locationRequest;
        this.zzaMi = locationListenerBinder == null ? null : zza.zzcf(locationListenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaMj = locationCallbackBinder == null ? null : zzc.zza.zzce(locationCallbackBinder);
        if (fusedLocationProviderCallbackBinder != null) {
            com_google_android_gms_location_internal_zzg = zzg.zza.zzch(fusedLocationProviderCallbackBinder);
        }
        this.zzaMk = com_google_android_gms_location_internal_zzg;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null, com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzc com_google_android_gms_location_zzc, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, com_google_android_gms_location_zzc.asBinder(), com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzd com_google_android_gms_location_zzd, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, com_google_android_gms_location_zzd.asBinder(), null, null, com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(zzc com_google_android_gms_location_zzc, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 2, null, null, null, com_google_android_gms_location_zzc.asBinder(), com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zza(zzd com_google_android_gms_location_zzd, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 2, null, com_google_android_gms_location_zzd.asBinder(), null, null, com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData zzb(PendingIntent pendingIntent, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null, com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }

    IBinder zzye() {
        return this.zzaMi == null ? null : this.zzaMi.asBinder();
    }

    IBinder zzyf() {
        return this.zzaMj == null ? null : this.zzaMj.asBinder();
    }

    IBinder zzyg() {
        return this.zzaMk == null ? null : this.zzaMk.asBinder();
    }
}
