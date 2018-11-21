package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SessionUnregistrationRequest implements SafeParcelable {
    public static final Creator<SessionUnregistrationRequest> CREATOR = new zzz();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzpp zzayj;

    SessionUnregistrationRequest(int versionCode, PendingIntent intent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzayj = zza.zzbR(callback);
    }

    public SessionUnregistrationRequest(PendingIntent pendingIntent, zzpp callback) {
        this.mVersionCode = 5;
        this.mPendingIntent = pendingIntent;
        this.zzayj = callback;
    }

    private boolean zzb(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return zzw.equal(this.mPendingIntent, sessionUnregistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionUnregistrationRequest) && zzb((SessionUnregistrationRequest) that));
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzx(this).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzz.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }

    public PendingIntent zzuu() {
        return this.mPendingIntent;
    }
}
