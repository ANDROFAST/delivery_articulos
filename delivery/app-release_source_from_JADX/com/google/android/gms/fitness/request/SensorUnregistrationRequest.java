package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzpp;

public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Creator<SensorUnregistrationRequest> CREATOR = new zzt();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzj zzayN;
    private final zzpp zzayj;

    SensorUnregistrationRequest(int versionCode, IBinder listenerBinder, PendingIntent pendingIntent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayN = listenerBinder == null ? null : zza.zzbt(listenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzayj = zzpp.zza.zzbR(callback);
    }

    public SensorUnregistrationRequest(zzj listener, PendingIntent pendingIntent, zzpp callback) {
        this.mVersionCode = 4;
        this.zzayN = listener;
        this.mPendingIntent = pendingIntent;
        this.zzayj = callback;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzayN});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzt.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }

    public PendingIntent zzuu() {
        return this.mPendingIntent;
    }

    IBinder zzuz() {
        return this.zzayN == null ? null : this.zzayN.asBinder();
    }
}
