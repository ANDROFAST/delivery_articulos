package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class SessionRegistrationRequest implements SafeParcelable {
    public static final Creator<SessionRegistrationRequest> CREATOR = new zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzpp zzayj;
    private final int zzaze;

    SessionRegistrationRequest(int versionCode, PendingIntent intent, IBinder callback, int sessionRegistrationOption) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzayj = callback == null ? null : zza.zzbR(callback);
        this.zzaze = sessionRegistrationOption;
    }

    public SessionRegistrationRequest(PendingIntent pendingIntent, zzpp callback, int sessionRegistrationOption) {
        this.mVersionCode = 6;
        this.mPendingIntent = pendingIntent;
        this.zzayj = callback;
        this.zzaze = sessionRegistrationOption;
    }

    private boolean zzb(SessionRegistrationRequest sessionRegistrationRequest) {
        return this.zzaze == sessionRegistrationRequest.zzaze && zzw.equal(this.mPendingIntent, sessionRegistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionRegistrationRequest) && zzb((SessionRegistrationRequest) that));
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent, Integer.valueOf(this.zzaze));
    }

    public String toString() {
        return zzw.zzx(this).zzg("pendingIntent", this.mPendingIntent).zzg("sessionRegistrationOption", Integer.valueOf(this.zzaze)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzw.zza(this, parcel, flags);
    }

    public int zzuD() {
        return this.zzaze;
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }

    public PendingIntent zzuu() {
        return this.mPendingIntent;
    }
}
